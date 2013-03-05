package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.provider.util.FeatureConfigurationProviderUtil;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.ModelEditor;
import cz.jpikl.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.jpikl.yafmt.ui.editors.fc.layout.FeatureConfigurationLayoutHelper;
import cz.jpikl.yafmt.ui.editors.fc.layout.HorizontalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.TreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.VerticalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.parts.FeatureConfigurationEditPartFactory;
import cz.jpikl.yafmt.ui.operations.ResourceSaveOperation;

public class FeatureConfigurationEditor extends ModelEditor {

    private FeatureConfigurationLayoutHelper layoutHelper = new FeatureConfigurationLayoutHelper();
    private TreeLayout[] EDITOR_LAYOUTS = { new VerticalTreeLayout(layoutHelper), new HorizontalTreeLayout(layoutHelper) }; 
    private FeatureConfiguration featureConfig;
        
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
        createGraphicalViewer(parent); // Calls configureGraphicalViewer and others bellow.
        
        GraphicalViewer viewer = getGraphicalViewer(); 
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        layoutHelper.setGraphicalViewer(viewer);
        setEditorLayout(EDITOR_LAYOUTS[0]);
    }    
        
    private void createSettingsPanel(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false));
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
    
    private void setEditorLayout(TreeLayout layout) {
        Object featureConfigEditPart = getGraphicalViewer().getEditPartRegistry().get(featureConfig);
        ((GraphicalEditPart) featureConfigEditPart).getFigure().setLayoutManager(layout);
    }
    
    // ==================================================================================
    //  Providers
    // ==================================================================================
    
    @Override
    protected Object getModel() {
        return featureConfig;
    }
    
    @Override
    protected EditPartFactory getEditPartFactory() {
        return new FeatureConfigurationEditPartFactory();
    }
    
    @Override
    protected ContextMenuProvider getContextMenuProvider() {
        return new FeatureConfigurationEditorContextMenuProvider(this);
    }

    @Override
    protected ILabelProvider getLabelProvider() {
        return FeatureConfigurationProviderUtil.getLabelProvider();
    }

    @Override
    protected IPropertySourceProvider getPropertySourceProvider() {
        return FeatureConfigurationProviderUtil.getContentProvider();
    }

    @Override
    protected IContentProvider getContentProvider() {
        return FeatureConfigurationProviderUtil.getContentProvider();
    }
        
    // ==================================================================================
    //  Actions
    // ==================================================================================
    
    @Override
    protected void createActions() {
        super.createActions();
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureConfig.getName();
            }
        });
    }
        
    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================
    
    @Override
    protected void doLoad(IFileEditorInput input) throws Exception {
        String path = input.getFile().getFullPath().toString();
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.load(null);
        featureConfig = (FeatureConfiguration) resource.getContents().get(0);
    }

    @Override
    protected void doSave() throws Exception {
        IWorkbenchWindow window = getSite().getWorkbenchWindow(); 
        window.run(true, false, new ResourceSaveOperation(featureConfig.eResource()));
    }
    
    // ==================================================================================
    //  Adapters
    // ==================================================================================
        
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == FeatureModel.class)
            return featureConfig.getFeatureModelCopy();
        return super.getAdapter(type);
    }

}
