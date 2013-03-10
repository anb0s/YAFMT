package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.core.resources.IResource;
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
import cz.jpikl.yafmt.ui.actions.ExportGraphicalEditorAsImageAction;
import cz.jpikl.yafmt.ui.actions.ShowFeatureModelVisualizerAction;
import cz.jpikl.yafmt.ui.editors.ModelEditor;
import cz.jpikl.yafmt.ui.editors.fc.actions.DeselectFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fc.actions.SelectFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fc.layout.FeatureConfigurationLayoutHelper;
import cz.jpikl.yafmt.ui.editors.fc.layout.HorizontalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.TreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.layout.VerticalTreeLayout;
import cz.jpikl.yafmt.ui.editors.fc.parts.FeatureConfigurationEditPartFactory;
import cz.jpikl.yafmt.ui.operations.ResourceSaveOperation;
import cz.jpikl.yafmt.ui.validation.IDiagnosticWriter;
import cz.jpikl.yafmt.ui.validation.ResourceMarkerDiagnosticWriter;

public class FeatureConfigurationEditor extends ModelEditor {

    private FeatureConfigurationLayoutHelper layoutHelper = new FeatureConfigurationLayoutHelper();
    private TreeLayout[] EDITOR_LAYOUTS = { new VerticalTreeLayout(layoutHelper), new HorizontalTreeLayout(layoutHelper) };
    private FeatureConfiguration featureConfig;
    private FeatureConfigurationManager featureConfigManager;

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
        panel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(4, false));

        Label layoutLabel = new Label(panel, SWT.NONE);
        layoutLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        layoutLabel.setText("Layout: ");

        Combo layoutCombo = new Combo(panel, SWT.READ_ONLY);
        layoutCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        for(TreeLayout layout: EDITOR_LAYOUTS)
            layoutCombo.add(layout.getName());

        layoutCombo.select(0);
        layoutCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                setEditorLayout(EDITOR_LAYOUTS[index]);
            }
        });
        
        Label visibilityLabel = new Label(panel, SWT.NONE);
        visibilityLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        visibilityLabel.setText("Unselected Features Visibility: ");

        Combo visibilityCombo = new Combo(panel, SWT.READ_ONLY);
        visibilityCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        visibilityCombo.add("Hide All");
        visibilityCombo.add("Show Only Selectable");
        visibilityCombo.add("Show All");
        visibilityCombo.setText(visibilityCombo.getItem(1));
        visibilityCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                featureConfigManager.setSelectableFeaturesVisibility(index > 0, index > 1);
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
        return new FeatureConfigurationEditPartFactory(featureConfigManager);
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
        return FeatureConfigurationProviderUtil.getPropertySourceProvider();
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
        
        createAction(new ShowFeatureModelVisualizerAction());
        createAction(new ExportGraphicalEditorAsImageAction(this) {
            @Override
            protected String getDefaultName() {
                return featureConfig.getName();
            }
        });
    }

    @Override
    protected void createActionsLate() {
        super.createActionsLate();
        
        createAction(new SelectFeaturesAction(this, featureConfigManager));
        createAction(new DeselectFeaturesAction(this, featureConfigManager));
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

        // Initialize feature configuration manager.
        IDiagnosticWriter diagnosticWriter = new ResourceMarkerDiagnosticWriter((IResource) input.getAdapter(IResource.class));
        featureConfigManager = new FeatureConfigurationManager(featureConfig, diagnosticWriter);
        featureConfigManager.revalidateFeatureConfiguration();
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
