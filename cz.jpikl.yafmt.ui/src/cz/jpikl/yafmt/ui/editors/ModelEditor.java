package cz.jpikl.yafmt.ui.editors;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.jpikl.yafmt.ui.CommonUIPlugin;
import cz.jpikl.yafmt.ui.actions.EditorZoomComboContributioItem;
import cz.jpikl.yafmt.ui.pages.EditorContentOutlinePage;
import cz.jpikl.yafmt.ui.pages.EditorPropertySheetPage;
import cz.jpikl.yafmt.ui.util.EditorAutoCloser;
import cz.jpikl.yafmt.ui.util.SelectionConverter;
import cz.jpikl.yafmt.ui.util.UnwrappingSelectionProvider;
import cz.jpikl.yafmt.ui.validation.ResourceProblemStore;

public abstract class ModelEditor extends GraphicalEditorWithFlyoutPalette implements IGotoMarker {

    private IContentOutlinePage contentOutlinePage;
    private IPropertySheetPage propertySheetPage;
    private EditorAutoCloser editorAutoCloser;
    private UnwrappingSelectionProvider selectionProvider;

    public ModelEditor() {
        editorAutoCloser = new EditorAutoCloser(this);
        setEditDomain(new DefaultEditDomain(this));
    }

    // ==================================================================================
    //  Basic initialization and dispose operations
    // ==================================================================================

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if(!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");

        super.init(site, input);
        setPartName(input.getName());

        try {
            doLoad((IFileEditorInput) input);
        }
        catch(Exception ex) {
            String path = ((IFileEditorInput) input).getFile().getFullPath().toString();
            throw new PartInitException("Unable to load " + path, ex);
        }

        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorAutoCloser);
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorAutoCloser);
        super.dispose();
    }

    // ==================================================================================
    //  Editor initialization
    // ==================================================================================

    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();

        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setRootEditPart(new ScalableFreeformRootEditPart());
        viewer.setEditPartFactory(getEditPartFactory());

        ContextMenuProvider contextMenuProvider = getContextMenuProvider();
        if(contextMenuProvider != null)
            viewer.setContextMenu(contextMenuProvider);

        // Actions need original selection provider.
        createActionsLate();
        setActionsSelectionProvider(viewer);
    }

    @Override
    protected void hookGraphicalViewer() {
        super.hookGraphicalViewer();

        // Provide unwrapped selections for rest of the world.
        selectionProvider = new UnwrappingSelectionProvider(getGraphicalViewer());
        getSite().setSelectionProvider(selectionProvider);
    }

    @Override
    protected void initializeGraphicalViewer() {
        getGraphicalViewer().setContents(getModel());
    }

    // ==================================================================================
    //  Providers
    // ==================================================================================

    protected ScalableFreeformRootEditPart getRootEditPart() {
        return (ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart();
    }

    protected UnwrappingSelectionProvider getSelectionProvider() {
        return selectionProvider;
    }

    @Override
    protected PaletteRoot getPaletteRoot() {
        return null;
    }

    protected ContextMenuProvider getContextMenuProvider() {
        return null;
    }

    protected abstract EObject getModel();

    protected abstract EditPartFactory getEditPartFactory();

    protected abstract ILabelProvider getLabelProvider();

    protected abstract IPropertySourceProvider getPropertySourceProvider();

    protected abstract IContentProvider getContentProvider();

    // ==================================================================================
    //  Actions
    // ==================================================================================

    @SuppressWarnings("unchecked")
    protected void createAction(IAction action) {
        getActionRegistry().registerAction(action);
        if(action instanceof SelectionAction)
            getSelectionActions().add(action.getId());
    }

    protected void createActionsLate() {
        ZoomManager zoomManager = getRootEditPart().getZoomManager();
        EditorZoomComboContributioItem.contributeZoomLevels(zoomManager);
        createAction(new ZoomInAction(zoomManager));
        createAction(new ZoomOutAction(zoomManager));
    }

    private void setActionsSelectionProvider(ISelectionProvider selectionProvider) {
        for(Iterator<?> it = getActionRegistry().getActions(); it.hasNext();) {
            IAction action = (IAction) it.next();
            if(action instanceof SelectionAction)
                ((SelectionAction) action).setSelectionProvider(selectionProvider);
        }
    }

    // ==================================================================================
    //  Event handling
    // ==================================================================================

    @Override
    public void commandStackChanged(EventObject event) {
        super.commandStackChanged(event);
        firePropertyChange(PROP_DIRTY);
        updateActions(getSelectionActions());
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        super.selectionChanged(part, selection); // Update all selection actions.

        // Ignore invalid selections.
        IEditorPart activeEditor = getSite().getPage().getActiveEditor();
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((this != activeEditor) || (part != activePart) || (part == this) || (part instanceof PropertySheet))
            return;

        // Apply selection to the editor if it differs.
        selection = SelectionConverter.wrapSelection(selection, getGraphicalViewer().getEditPartRegistry());
        if(!getGraphicalViewer().getSelection().equals(selection))
            applySelection(selection);
    }

    private void applySelection(ISelection selection) {
        getGraphicalViewer().setSelection(selection);
        if(selection.isEmpty())
            return;

        // Center viewport to last selected object.
        if(selection instanceof IStructuredSelection) {
            Object[] objects = ((IStructuredSelection) selection).toArray();
            for(int i = objects.length - 1; i >= 0; i--) {
                if(objects[i] instanceof GraphicalEditPart) {
                    centerViewportToEditPart((GraphicalEditPart) objects[i]);
                    break;
                }
            }
        }
    }

    private void centerViewportToEditPart(GraphicalEditPart editPart) {
        Viewport viewport = (Viewport) getRootEditPart().getFigure();
        Point point = editPart.getFigure().getBounds().getCenter();
        int x = point.x - viewport.getSize().width / 2;
        int y = point.y - viewport.getSize().height / 2;
        viewport.setViewLocation(x, y);
    }
    
    // ==================================================================================
    //  Markers
    // ==================================================================================
    
    @Override
    public void gotoMarker(IMarker marker) {
        try {
            if(!marker.getType().equals(ResourceProblemStore.MARKER_ID))
                return;
            
            String uriFragments = marker.getAttribute(ResourceProblemStore.MARKER_PROBLEM_OBJECT_URI, null);
            if(uriFragments == null)
                return;
            
            Resource resource = getModel().eResource();
            if(resource == null)
                return;
            
            List<Object> objectsToSelect = new ArrayList<Object>();
            for(String uriFragment: uriFragments.split(ResourceProblemStore.URI_FRAGMENTS_SEPARATOR)) {
                EObject object = resource.getEObject(uriFragment);
                if(object != null)
                    objectsToSelect.add(object);
            }
            
            if(!objectsToSelect.isEmpty()) {
                ISelection selection = new StructuredSelection(objectsToSelect);
                applySelection(SelectionConverter.wrapSelection(selection, getGraphicalViewer().getEditPartRegistry()));
            }
        }
        catch(CoreException ex) {
            ex.printStackTrace();
        }
    }

    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================

    protected abstract void doLoad(IFileEditorInput input) throws Exception;

    protected abstract void doSave() throws Exception;

    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            doSave();
            getEditDomain().getCommandStack().markSaveLocation();
            firePropertyChange(PROP_DIRTY);
        }
        catch(Exception ex) {
            ErrorDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(),
                    null, new Status(Status.ERROR, CommonUIPlugin.PLUGIN_ID, ex.getMessage(), ex), 0);
        }
    }

    public void doSaveAs() {
        SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();

        IPath path = dialog.getResult();
        if(path == null)
            return;

        setInputWithNotify(new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path)));
        setPartName(getEditorInput().getName());
        doSave(null);
    }

    public boolean isSaveAsAllowed() {
        return true;
    }

    // ==================================================================================
    //  Adapters
    // ==================================================================================

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null)
                propertySheetPage = new EditorPropertySheetPage(this, getPropertySourceProvider());
            return propertySheetPage;
        }

        if(type == IContentOutlinePage.class) {
            if(contentOutlinePage == null)
                contentOutlinePage = new EditorContentOutlinePage(this, getModel(), getContentProvider(), getLabelProvider());
            return contentOutlinePage;
        }
        
        if(type == ZoomManager.class) {
            return getRootEditPart().getZoomManager();
        }

        return super.getAdapter(type);
    }

}
