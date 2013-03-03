package cz.jpikl.yafmt.ui.editors.fc;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.provider.util.FeatureConfigurationProviderUtil;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.jpikl.yafmt.ui.editors.fc.layout.FeatureConfigurationLayoutHelper;
import cz.jpikl.yafmt.ui.editors.fc.layout.HorizontalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.TreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.VerticalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.parts.FeatureConfigurationEditPartFactory;
import cz.jpikl.yafmt.ui.operations.ResourceSaveOperation;
import cz.jpikl.yafmt.ui.pages.EditorContentOutlinePage;
import cz.jpikl.yafmt.ui.pages.EditorPropertySheetPage;
import cz.jpikl.yafmt.ui.util.EditorAutoCloser;
import cz.jpikl.yafmt.ui.util.UnwrappingSelectionProvider;

public class FeatureConfigurationEditor extends GraphicalEditor {

    private FeatureConfigurationLayoutHelper layoutHelper = new FeatureConfigurationLayoutHelper();
    private TreeLayout[] EDITOR_LAYOUTS = { new VerticalTreeLayout(layoutHelper), new HorizontalTreeLayout(layoutHelper) }; 
    
    private FeatureConfiguration featureConfig;
    private EditorAutoCloser editorAutoCloser;
    private IContentOutlinePage contentOutlinePage;
    private IPropertySheetPage propertySheetPage;
    
    public FeatureConfigurationEditor() {
        editorAutoCloser = new EditorAutoCloser(this);
        setEditDomain(new DefaultEditDomain(this));
    }
    
    // ==================================================================================
    //  Basic initialization and dispose operations
    // ==================================================================================

    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");
        
        super.init(site, input);
        setPartName(input.getName());
        doLoad((IFileEditorInput) input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorAutoCloser);
    }
    
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorAutoCloser);
        super.dispose();
    }
    
    private void setEditorLayout(TreeLayout layout) {
        Object featureConfigEditPart = getGraphicalViewer().getEditPartRegistry().get(featureConfig);
        ((GraphicalEditPart) featureConfigEditPart).getFigure().setLayoutManager(layout);
    }
    
    // ==================================================================================
    //  Editor initialization
    // ==================================================================================
    
    @Override
    public void createPartControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());
        createFeatureConfigurationEditor(panel);
        createSettingsPanel(panel);
    }
    
    private void createFeatureConfigurationEditor(Composite parent) {
        super.createPartControl(parent); // Calls configureGraphicalViewer and others bellow.
        getGraphicalViewer().getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        setEditorLayout(EDITOR_LAYOUTS[0]);
    }
    
    private void createSettingsPanel(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(2, false));
        
        Label label = new Label(panel, SWT.NONE);
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        label.setText("Layout: ");
        
        Combo combo = new Combo(panel, SWT.READ_ONLY);
        combo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        for(TreeLayout layout: EDITOR_LAYOUTS)
            combo.add(layout.getName());
        
        combo.select(0);
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                setEditorLayout(EDITOR_LAYOUTS[index]);
            }
        });
    }
    
    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setEditPartFactory(new FeatureConfigurationEditPartFactory());
        viewer.setRootEditPart(new ScalableFreeformRootEditPart());
        
        setActionsSelectionProvider(viewer); // Actions need original selection provider.
        layoutHelper.setGraphicalViewer(viewer);
    }
    
    @Override
    protected void hookGraphicalViewer() {
        super.hookGraphicalViewer();
        // Provide unwrapped selections for rest of the world.
        getSite().setSelectionProvider(new UnwrappingSelectionProvider(getGraphicalViewer()));
    }
    
    @Override
    protected void initializeGraphicalViewer() {
        getGraphicalViewer().setContents(featureConfig);
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
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureConfig.getName().trim();
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
    //  Save and Load operations
    // ==================================================================================
    
    private void doLoad(IFileEditorInput input) throws PartInitException {
        String path = input.getFile().getFullPath().toString();
        
        try {
            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
            resource.load(null);
            featureConfig = (FeatureConfiguration) resource.getContents().get(0);
        }
        catch(IOException ex) {
            throw new PartInitException("Unable to load " + path, ex);
        }
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            IWorkbenchWindow window = getSite().getWorkbenchWindow(); 
            window.run(true, false, new ResourceSaveOperation(featureConfig.eResource()));
            getEditDomain().getCommandStack().markSaveLocation();
            firePropertyChange(PROP_DIRTY);
        } 
        catch (Exception ex) {
            ErrorDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(),
                null, new Status(Status.ERROR, FeatureConfigurationEditorPlugin.PLUGIN_ID, ex.getMessage(), ex), 0);
        }
    }
    
    @Override
    public void doSaveAs() {
        SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();
        
        IPath path = dialog.getResult();
        if (path == null)
            return;

        featureConfig.eResource().setURI(URI.createPlatformResourceURI(path.toString(), true));
        setInputWithNotify(new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path)));
        setPartName(getEditorInput().getName());
        doSave(null);
    }
    
    @Override
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
            return featureConfig.getFeatureModelCopy();
        
        if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null)
                propertySheetPage = new EditorPropertySheetPage(this, FeatureConfigurationProviderUtil.getContentProvider());
            return propertySheetPage;
        }
        
        if(type == IContentOutlinePage.class) {
            if(contentOutlinePage == null)
                contentOutlinePage = new EditorContentOutlinePage(this, featureConfig, FeatureConfigurationProviderUtil.getContentProvider(), FeatureConfigurationProviderUtil.getLabelProvider());
            return contentOutlinePage;
        }
        
        return super.getAdapter(type);
    }

}
