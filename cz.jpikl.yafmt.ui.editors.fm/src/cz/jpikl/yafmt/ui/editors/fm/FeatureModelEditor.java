package cz.jpikl.yafmt.ui.editors.fm;

import java.io.IOException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;
import cz.jpikl.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.AutoLayoutAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.DeleteAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.SelectAllAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutDataFactory;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutDataPackage;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPartFactory;
import cz.jpikl.yafmt.ui.editors.fm.widgets.Splitter;
import cz.jpikl.yafmt.ui.operations.ResourceSaveOperation;
import cz.jpikl.yafmt.ui.pages.EditorContentOutlinePage;
import cz.jpikl.yafmt.ui.pages.EditorPropertySheetPage;
import cz.jpikl.yafmt.ui.util.EditorAutoCloser;
import cz.jpikl.yafmt.ui.util.SelectionConverter;
import cz.jpikl.yafmt.ui.util.UnwrappingSelectionProvider;

public class FeatureModelEditor extends GraphicalEditorWithFlyoutPalette {

    private static final String LAYOUT_DATA_EXTENSION = ".layout";
    
    private FeatureModel featureModel;
    private LayoutData layoutData;
    private IContentOutlinePage contentOutlinePage;
    private IPropertySheetPage propertySheetPage;
    private ConstraintsEditor constraintsEditor;
    private EditorAutoCloser editorAutoCloser;
	
    // ==================================================================================
    //  Basic initialization and dispose operations
    // ==================================================================================
    
    public FeatureModelEditor() {
        editorAutoCloser = new EditorAutoCloser(this);
        setEditDomain(new DefaultEditDomain(this));
    }
    
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");
        
        super.init(site, input);
        setPartName(input.getName());
        doLoad((IFileEditorInput) input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorAutoCloser);
    }
    
    public void dispose() {
        getSite().getPage().removeSelectionListener(constraintsEditor);
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorAutoCloser);
        super.dispose();
    }
        
    // ==================================================================================
    //  Editor initialization
    // ==================================================================================
    
    @Override
    public void createPartControl(Composite parent) {
        Splitter splitter = new Splitter(parent);
        createFeatureTreeEditor(splitter);
        createConstraintsEditor(splitter);
    }
    
    private void createFeatureTreeEditor(Composite parent) {
        super.createPartControl(parent); // Calls configureGraphicalViewer and others bellow.
    }
    
    private void createConstraintsEditor(Splitter splitter) {
        constraintsEditor = new ConstraintsEditor(splitter, this);
        constraintsEditor.getViewer().addSelectionChangedListener((UnwrappingSelectionProvider) getSite().getSelectionProvider());
        getSite().getPage().addSelectionListener(constraintsEditor);
    }
        
    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setEditPartFactory(new FeatureModelEditPartFactory(layoutData));
        viewer.setRootEditPart(new ScalableFreeformRootEditPart());
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
        viewer.setContextMenu(new FeatureModelEditorContextMenuProvider(viewer, getActionRegistry()));
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
        
        // Actions need original selection provider.
        setActionsSelectionProvider(viewer);
    }
    
    @Override
    protected void hookGraphicalViewer() {
        super.hookGraphicalViewer();
        // Provide unwrapped selections for rest of the world.
        getSite().setSelectionProvider(new UnwrappingSelectionProvider(getGraphicalViewer()));
    }
    
    @Override
    protected void initializeGraphicalViewer() {
        getGraphicalViewer().setContents(featureModel);
    }
    
    private ScalableFreeformRootEditPart getRootEditPart() {
        return (ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart();
    }
       
    // ==================================================================================
    //  Actions
    // ==================================================================================
    
    @SuppressWarnings("unchecked")
    private void createAction(IAction action) {
        getActionRegistry().registerAction(action);
        if(action instanceof SelectionAction)
            getSelectionActions().add(action.getId());
    }
    
    @Override
    protected void createActions() {
        super.createActions();
        createAction(new DeleteAction(this));    // Custom delete action.
        createAction(new SelectAllAction(this)); // Custom select all action.
        createAction(new SetFeatureCardinalityAction(this, false));
        createAction(new SetFeatureCardinalityAction(this, true));
        createAction(new GroupFeaturesAction(this, true));
        createAction(new GroupFeaturesAction(this, false));
        createAction(new UngroupFeaturesAction(this));
        createAction(new AutoLayoutAction(this));
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureModel.getName().trim();
            }
        });
    }
    
    private void setActionsSelectionProvider(ISelectionProvider selectionProvider) {
        for(Iterator<?> it = getActionRegistry().getActions(); it.hasNext(); ) {
            IAction action = (IAction) it.next();
            if(action instanceof SelectionAction)
                ((SelectionAction) action).setSelectionProvider(selectionProvider);
        }
    }

    // ==================================================================================
    //  Palette initialization
    // ==================================================================================
    
    @Override
    protected PaletteRoot getPaletteRoot() {
        return new FeatureModelEditorPaletteRoot();
    }
    
    @Override
    protected PaletteViewerProvider createPaletteViewerProvider() {
        return new PaletteViewerProvider(getEditDomain()) {
            @Override
            protected void configurePaletteViewer(PaletteViewer viewer) {
                super.configurePaletteViewer(viewer);
                // Add drag and drop support for palette.
                viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
            }
        };
    }
    
    @Override
    protected FlyoutPreferences getPalettePreferences() {
        FlyoutPreferences preferences = super.getPalettePreferences();
        preferences.setDockLocation(PositionConstants.WEST);
        preferences.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
        preferences.setPaletteWidth(150);
        return preferences;
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
        super.selectionChanged(part, selection); // Updates all selection actions.
        
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
    //  Save and Load operations
    // ==================================================================================
    
	private void doLoad(IFileEditorInput input) throws PartInitException {
	    ResourceSet resourceSet = new ResourceSetImpl();
	    String path = input.getFile().getFullPath().toString();
	    loadFeatureModel(resourceSet, path);
	    loadLayoutData(resourceSet, path);
	}
	
	private void loadFeatureModel(ResourceSet resourceSet, String path) throws PartInitException {
	    try {
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
            resource.load(null);
            featureModel = (FeatureModel) resource.getContents().get(0);
        }
        catch(IOException ex) {
            throw new PartInitException("Unable to load " + path, ex);
        }
	}
		
	private void loadLayoutData(ResourceSet resourceSet, String featureModelPath) {
        LayoutDataPackage.eINSTANCE.eClass(); // For package registration.
        String path = featureModelPath + LAYOUT_DATA_EXTENSION;
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        
        try {
            resource.load(createModelLayoytLoadSaveOptions());
            layoutData = (LayoutData) resource.getContents().get(0);
        }
        catch(IOException ex) {
            layoutData = LayoutDataFactory.eINSTANCE.createLayoutData();
            resource.getContents().add(layoutData);
            // Set root feature position.
            Rectangle rootBounds = new Rectangle(320, 32, FeatureFigure.WIDTH, FeatureFigure.HEGHT);
            layoutData.set(featureModel.getRoot(), rootBounds);
        }
	}
	
	private Map<Object, Object> createModelLayoytLoadSaveOptions() {
        Map<Object, Object> options = new HashMap<Object, Object>();
        // Ignore and discard all dangling references.
        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
        return options;
    }
	
	public void doSave(IProgressMonitor monitor) {
	    try {
	        IWorkbenchWindow window = getSite().getWorkbenchWindow(); 
            window.run(true, false, new ResourceSaveOperation(featureModel.eResource()));
            window.run(true, false, new ResourceSaveOperation(layoutData.eResource(), createModelLayoytLoadSaveOptions()));
            getEditDomain().getCommandStack().markSaveLocation();
            firePropertyChange(PROP_DIRTY);
        } 
	    catch (Exception ex) {
	        ErrorDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(),
	            null, new Status(Status.ERROR, FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage(), ex), 0);
        }
	}

	public void doSaveAs() {
	    SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();
        
        IPath path = dialog.getResult();
        if (path == null)
            return;

        featureModel.eResource().setURI(URI.createPlatformResourceURI(path.toString(), true));
        layoutData.eResource().setURI(URI.createPlatformResourceURI(path.toString() + LAYOUT_DATA_EXTENSION, true));
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
	    if(type == FeatureModel.class)
	        return featureModel;
	    
	    if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null)
                propertySheetPage = new EditorPropertySheetPage(this, FeatureModelProviderUtil.getContentProvider());
            return propertySheetPage;
        }
	    
	    if(type == IContentOutlinePage.class) {
	        if(contentOutlinePage == null)
	            contentOutlinePage = new EditorContentOutlinePage(this, featureModel, FeatureModelProviderUtil.getContentProvider(), FeatureModelProviderUtil.getLabelProvider());
	        return contentOutlinePage;
	    }
	    
	    return super.getAdapter(type);
	}
	
}
