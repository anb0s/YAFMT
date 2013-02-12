package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.GroupFilter;
import cz.jpikl.yafmt.ui.views.fm.util.SettingsUtil;

public class FeatureModelVisualizer extends ViewPart implements ISelectionListener, IPartListener {

	public static final String ID = "cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizer";
	
	private static final int CONNECTION_LENGHT = 200;
	private static final int MAX_SIZE_MULTIPLIER = 5; 
	
	private IWorkbenchPart sourcePart;
	private FeatureModel featureModel;
	private FeatureModelAdapter featureModelAdapter;
	
    private GraphViewer viewer;
    private DistanceFilter distanceFilter;
    private GroupFilter groupFilter;
    private ConstraintFilter constraintFilter;
    
    private int visibleDistance;     // Visible distance from selected graph nodes.
    private int sizeMultiplier;      // Size multiplier, used when size of graph canvas is adjusted manually.
    private boolean sizeSpecified;   // Is size of graph canvas is manually adjusted?
    private boolean showGroups;      // Are groups shown?
    private boolean showConstraints; // Are constraints shown?
    private boolean enableAnimation; // Is graph animation enabled?
    private boolean locked;          // Is graph layout locked?
    private int treeHeight = 1;      // Height of the current feature model tree.
    
    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);
        site.getPage().addPartListener(this);
        site.getPage().addSelectionListener(this);
        initState(FeatureModelVisualizerPlugin.getDefault().getDialogSettings());
    }
        
    @Override
    public void dispose() {
        saveState(FeatureModelVisualizerPlugin.getDefault().getDialogSettings());
        setFeatureModel(null);
        getSite().getPage().removeSelectionListener(this);
        getSite().getPage().removePartListener(this);
        getSite().setSelectionProvider(null);
        super.dispose();
    }
    
    private void initState(IDialogSettings settings) {
        visibleDistance = SettingsUtil.getInteger(settings, "visibleDistance", DistanceFilter.INFINITE_DISTACE);
        sizeMultiplier = SettingsUtil.getInteger(settings, "sizeMultiplier", 1);
        sizeSpecified = SettingsUtil.getBoolean(settings, "sizeSpecified", true);
        showGroups = SettingsUtil.getBoolean(settings, "showGroups", true);
        showConstraints = SettingsUtil.getBoolean(settings, "showConstraints", true);
        enableAnimation = SettingsUtil.getBoolean(settings, "enableAnimation", true);
        locked = SettingsUtil.getBoolean(settings, "locked", false);
    }
    
    public void saveState(IDialogSettings settings) {
        settings.put("visibleDistance", visibleDistance);
        settings.put("sizeMultiplier", sizeMultiplier);
        settings.put("sizeSpecified", sizeSpecified);
        settings.put("showGroups", showGroups);
        settings.put("showConstraints", showConstraints);
        settings.put("enableAnimation", enableAnimation);
        settings.put("locked", locked);
    }
    	
    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        createGraphViewerControl(parent);
        createOptionsControl(parent);
        
        setSourcePart(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
        distanceFilter.update(null, featureModel);
        groupFilter.update(null);
        constraintFilter.update(null, featureModel);
        viewer.refresh();
        viewer.applyLayout();
        
        parent.addControlListener(new ControlAdapter() {
            @Override
            public void controlResized(ControlEvent event) {
                if(!sizeSpecified) {
                    resizeGraphView();
                    viewer.applyLayout();
                }
            }
        });
    }
        
    private void createGraphViewerControl(Composite parent) {
        distanceFilter = new DistanceFilter(visibleDistance);
        groupFilter = new GroupFilter(showGroups);
        constraintFilter = new ConstraintFilter(showConstraints);
        
        // Do not enable hash lookup. It causes invalidation of current selection during graph refresh.
        viewer = new GraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelLabelProvider());
        viewer.setLayoutAlgorithm(new FeatureGraphLayoutAlgorithm());
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        viewer.setNodeStyle(enableAnimation ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
        viewer.setFilters(new ViewerFilter[] { distanceFilter, groupFilter, constraintFilter });
        getSite().setSelectionProvider(viewer);
    }
    
    private void createOptionsControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(6, false));
        
        Button showGroupsButton = new Button(panel, SWT.TOGGLE);
        showGroupsButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group"));
        showGroupsButton.setToolTipText("Show Groups");
        showGroupsButton.setSelection(showGroups);
        showGroupsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                showGroups = ((Button) event.getSource()).getSelection();
                groupFilter.setEnabled(showGroups);
                groupFilter.update(viewer.getSelection());
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Button showConstraintsButton = new Button(panel, SWT.TOGGLE);
        showConstraintsButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint"));
        showConstraintsButton.setToolTipText("Show Constraints");
        showConstraintsButton.setSelection(showConstraints);
        showConstraintsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                showConstraints = ((Button) event.getSource()).getSelection();
                constraintFilter.setEnabled(showConstraints);
                constraintFilter.update(viewer.getSelection(), featureModel);
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Button enableAnimationButton = new Button(panel, SWT.TOGGLE);
        enableAnimationButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("animation"));
        enableAnimationButton.setToolTipText("Enable animation");
        enableAnimationButton.setSelection(enableAnimation);
        enableAnimationButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                enableAnimation = ((Button) event.getSource()).getSelection();
                viewer.setInput(null); // Style can be only changed when input is not set.
                viewer.setNodeStyle(enableAnimation ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
                viewer.setInput(featureModel);
            }
        });
        
        Button lockButton = new Button(panel, SWT.TOGGLE);
        lockButton.setImage(FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("lock"));
        lockButton.setToolTipText("Lock View");
        lockButton.setSelection(locked);
        lockButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                locked = ((Button) event.getSource()).getSelection();
            }
        });
        
        Composite distancePanel = new Composite(panel, SWT.NONE);
        distancePanel.setLayout(new GridLayout(2, false));
        
        Text distanceText = new Text(distancePanel, SWT.NONE);
        distanceText.setText("Visible distance:");
        
        Combo distanceComboBox = new Combo(distancePanel, SWT.READ_ONLY);
        distanceComboBox.setItems(new String[] { "infinite", "1", "2" });
        distanceComboBox.setText(distanceComboBox.getItem(Math.max(0, visibleDistance)));
        distanceComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                visibleDistance = (index > 0) ? index : DistanceFilter.INFINITE_DISTACE;
                distanceFilter.setDistance(visibleDistance);
                distanceFilter.update(viewer.getSelection(), featureModel);
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Composite sizePanel = new Composite(panel, SWT.NONE);
        sizePanel.setLayout(new GridLayout(2, false));
        
        Button sizeButton = new Button(sizePanel, SWT.CHECK);
        final Combo sizeComboBox = new Combo(sizePanel, SWT.READ_ONLY);
                
        sizeButton.setText("Adjust size:");
        sizeButton.setSelection(sizeSpecified);
        sizeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeSpecified = ((Button) event.getSource()).getSelection();
                sizeComboBox.setEnabled(sizeSpecified);
                resizeGraphView();
                viewer.applyLayout();
            }
        });
        
        for(int i = 1; i <= MAX_SIZE_MULTIPLIER; i++)
            sizeComboBox.add(i + "x");
        sizeComboBox.setText(sizeComboBox.getItem(sizeMultiplier - 1));
        sizeComboBox.setEnabled(sizeSpecified);
        sizeComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                sizeMultiplier = ((Combo) event.getSource()).getSelectionIndex() + 1;
                resizeGraphView();
                viewer.applyLayout();
            }
        });
    }
    
    private void recomputeTreeHeight() {
        treeHeight = FeatureModelUtil.getTreeHeight(featureModel);
    }
    
    private void resizeGraphView() {
        if(sizeSpecified) {
            int size = 2 * treeHeight * CONNECTION_LENGHT * sizeMultiplier;
            viewer.getGraphControl().setPreferredSize(size, size);
        }
        else {
            viewer.getGraphControl().setPreferredSize(-1, -1);
        }
    }
    
    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }
    
    private void setSourcePart(IWorkbenchPart part) {
        if(part == sourcePart)
            return;
            
        FeatureModel newFeatureModel = (FeatureModel) part.getAdapter(FeatureModel.class);
        if(newFeatureModel == null)
            return;
            
        sourcePart = part;
        setFeatureModel(newFeatureModel);
    }
    
    private void setFeatureModel(FeatureModel newFeatureModel) {
        if(featureModel == newFeatureModel)
            return;
        
        if(featureModel != null)
            featureModel.eAdapters().remove(featureModelAdapter);
        
        featureModel = newFeatureModel;
        if(!viewer.getControl().isDisposed()) {
            viewer.setInput(featureModel);
            recomputeTreeHeight();
            resizeGraphView();
        }
        
        if(featureModel != null) {
            if(featureModelAdapter == null)
                featureModelAdapter = new FeatureModelAdapter();
            featureModel.eAdapters().add(featureModelAdapter);
        }
    }
    
    private boolean isValidSelection(ISelection selection) {
        if(selection == null)
            return false;
        if(selection.isEmpty())
            return true;
        if(!(selection instanceof IStructuredSelection))
            return false;
        
        Object firstElement = ((IStructuredSelection) selection).getFirstElement();
        return (firstElement instanceof FeatureModel) ||
               (firstElement instanceof Feature) || 
               (firstElement instanceof Group) || 
               (firstElement instanceof Constraint);
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if(part != this) {
            setSourcePart(part);
            if(viewer.getSelection().isEmpty() && selection.isEmpty())
                return;
            if(!isValidSelection(selection))
                return;
        }

        if(!locked) {
            distanceFilter.update(selection, featureModel);
            groupFilter.update(selection);
            constraintFilter.update(selection, featureModel);
            viewer.refresh();
            viewer.applyLayout();
        }
        
        if(part != this) {
            viewer.setSelection(selection);
            // TODO should be applied after layout animation finishes.
            // moveViewportToSelection(selection);
        }
    }
    
    private void moveViewportToSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return;
        
        Object[] objects = ((IStructuredSelection) selection).toArray();
        if((objects == null) || (objects.length == 0))
            return;
        
        // Zoom to the last selected object
        GraphItem item = viewer.findGraphItem(objects[objects.length - 1]);
        if(item instanceof GraphNode) {
            Point p = ((GraphNode) item).getLocation();
            Viewport vp = viewer.getGraphControl().getViewport();
            vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
        }
    }
    
    @Override
    public void partClosed(IWorkbenchPart part) {
        if(part == sourcePart) {
            sourcePart = null;
            setFeatureModel(null);
        }
    }
        
    class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            
            switch(notification.getEventType()) {
                case Notification.ADD:
                case Notification.ADD_MANY:
                case Notification.REMOVE:
                case Notification.REMOVE_MANY:
                case Notification.SET:
                    recomputeTreeHeight();
                    resizeGraphView();
                    viewer.refresh();
                    viewer.applyLayout();
                    break;
            }
        }
        
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        // Reuse property sheet from editor.
        if((type == IPropertySheetPage.class) && (sourcePart != null))
            return sourcePart.getAdapter(type);
        return super.getAdapter(type);
    }
    
    @Override
    public void partOpened(IWorkbenchPart part) {
    }
    
    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
    }
    
    @Override
    public void partActivated(IWorkbenchPart part) {
    }
    
    @Override
    public void partDeactivated(IWorkbenchPart part) {
    }
	
}