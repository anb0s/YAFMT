package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
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

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.GroupFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.SelectionBasedTypedFilter;

public class FeatureModelView extends ViewPart implements ISelectionListener, IPartListener {

	public static final String ID = "cz.jpikl.yafmt.ui.views.fm.FeatureModelView";

	private FeatureModel featureModel;
	private FeatureModelAdapter featureModelAdapter;
	private IWorkbenchPart sourcePart;
    private GraphViewer viewer;
    private SelectionBasedTypedFilter groupFilter;
    private SelectionBasedTypedFilter constraintFilter;
	
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
        super.dispose();
    }
	
    @Override
    public void createPartControl(Composite parent) {
        viewer = new GraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelLabelProvider());
        viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
        getSite().setSelectionProvider(viewer);
        
        groupFilter = new GroupFilter(viewer);
        constraintFilter = new ConstraintFilter(viewer);
        viewer.setFilters(new ViewerFilter[] { groupFilter, constraintFilter });
        
        setSourcePart(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
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
        if(featureModel != null)
            featureModel.eAdapters().remove(featureModelAdapter);
        
        featureModel = newFeatureModel;
        if(!viewer.getControl().isDisposed())
            viewer.setInput(featureModel);
        
        if(featureModel == null)
            return;
            
        if(featureModelAdapter == null)
            featureModelAdapter = new FeatureModelAdapter();
        featureModel.eAdapters().add(featureModelAdapter);
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        setSourcePart(part);
        
        // TODO check selection from other parts
        if(part == this) {
            // viewer.setSelection(selection);
            groupFilter.update();
            constraintFilter.update();
            viewer.refresh();
            viewer.applyLayout();
        }
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
        }
        
    }
	
}