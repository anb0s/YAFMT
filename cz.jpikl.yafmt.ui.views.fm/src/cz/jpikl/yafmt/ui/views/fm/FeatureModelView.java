package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
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
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.GroupFilter;

public class FeatureModelView extends ViewPart implements ISelectionListener, IPartListener {

	public static final String ID = "cz.jpikl.yafmt.ui.views.fm.FeatureModelView";

	private FeatureModel featureModel;
	private FeatureModelAdapter featureModelAdapter;
	private IWorkbenchPart sourcePart;
    private GraphViewer viewer;
    private DistanceFilter distanceFilter;
    private GroupFilter groupFilter;
    private ConstraintFilter constraintFilter;
    private int treeHeight = 1;
	
	@Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);
        site.getPage().addPartListener(this);
        site.getPage().addSelectionListener(this);
    }
	
	@Override
    public void dispose() {
	    setFeatureModel(null);
	    getSite().getPage().removeSelectionListener(this);
	    getSite().getPage().removePartListener(this);
	    getSite().setSelectionProvider(null);
        super.dispose();
    }
	
    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        createGraphViewerControl(parent);
        createOptionsControl(parent);
        
        setSourcePart(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
    }
        
    private void createGraphViewerControl(Composite parent) {
        // Do not enable hash lookup. It causes invalidation of current selection during graph refresh.
        viewer = new GraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelLabelProvider());
        viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        getSite().setSelectionProvider(viewer);
        
        distanceFilter = new DistanceFilter(viewer);
        groupFilter = new GroupFilter(viewer);
        constraintFilter = new ConstraintFilter(viewer);
        viewer.setFilters(new ViewerFilter[] { distanceFilter, groupFilter, constraintFilter });
    }
    
    private void createOptionsControl(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        panel.setLayout(new GridLayout(4, false));
        
        Composite distancePanel = new Composite(panel, SWT.NONE);
        distancePanel.setLayout(new GridLayout(2, false));
        
        Text distanceText = new Text(distancePanel, SWT.NONE);
        distanceText.setText("Visible distance:");
        
        Combo distanceComboBox = new Combo(distancePanel, SWT.READ_ONLY);
        distanceComboBox.setItems(new String[] { "infinite", "1", "2" });
        distanceComboBox.setText(distanceComboBox.getItem(0));
        distanceComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                int index = ((Combo) event.getSource()).getSelectionIndex();
                distanceFilter.setDistance((index == 0) ? DistanceFilter.INFINITE_DISTACE : index);
                distanceFilter.update();
                resizeGraphView();
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Button showGroupsButton = new Button(panel, SWT.CHECK);
        showGroupsButton.setText("Show Groups");
        showGroupsButton.setSelection(true);
        showGroupsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                groupFilter.setEnabled(((Button) event.getSource()).getSelection());
                groupFilter.update();
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Button showConstraintsButton = new Button(panel, SWT.CHECK);
        showConstraintsButton.setText("Show Constraints");
        showConstraintsButton.setSelection(true);
        showConstraintsButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                constraintFilter.setEnabled(((Button) event.getSource()).getSelection());
                constraintFilter.update();
                viewer.refresh();
                viewer.applyLayout();
            }
        });
        
        Button enableAnimationButton = new Button(panel, SWT.CHECK);
        enableAnimationButton.setText("Enable animation");
        enableAnimationButton.setSelection(true);
        enableAnimationButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                viewer.setInput(null); // Style can be only changed when input is not set.
                if(Boolean.TRUE.equals(((Button) event.getSource()).getSelection()))
                    viewer.setNodeStyle(ZestStyles.NONE);
                else
                    viewer.setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
                viewer.setInput(featureModel);
            }
        });
    }
    
    void recomputeTreeHeight() {
        treeHeight = FeatureModelUtil.getTreeHeight(featureModel);
    }
    
    void resizeGraphView() {
        int size = 2 * treeHeight;
        if(distanceFilter.getDistance() != DistanceFilter.INFINITE_DISTACE)
            size = distanceFilter.getDistance();
        viewer.getGraphControl().setPreferredSize(200 * size, 200 * size);
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
        if(!(selection instanceof IStructuredSelection))
            return false;
        
        Object firstElement = ((IStructuredSelection) selection).getFirstElement();
        if(firstElement == null)
            return true; // Empty selection.
        
        return (firstElement instanceof Feature) || 
               (firstElement instanceof Group) || 
               (firstElement instanceof Constraint);
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        setSourcePart(part);
        
        if(viewer.getSelection().isEmpty() && selection.isEmpty())
            return;
        
        if(part != this) {
            if(!isValidSelection(selection))
                return;
            viewer.setSelection(selection);
        }
        
        distanceFilter.update();
        groupFilter.update();
        constraintFilter.update();
        viewer.refresh();
        viewer.applyLayout();
    }
    
    @Override
    public void partOpened(IWorkbenchPart part) {
        // Called when part is created and opened.
    }
    
    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
        // Called when part is made visible.
    }
    
    @Override
    public void partClosed(IWorkbenchPart part) {
        // Called when part is closed and destroyed.
        if(part == sourcePart) {
            sourcePart = null;
            setFeatureModel(null);
        }
    }
    
    @Override
    public void partActivated(IWorkbenchPart part) {
        // Called when user select part (usually go together with selection changed event).
    }
    
    @Override
    public void partDeactivated(IWorkbenchPart part) {
        // Called when user select other part than the current.
    }
    
    class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            recomputeTreeHeight();
            resizeGraphView();
            viewer.refresh();
            viewer.applyLayout();
        }
        
    }
	
}