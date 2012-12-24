package cz.jpikl.yafmt.views.featuremodel.view;

import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import cz.jpikl.yafmt.editors.featuremodel.editor.FeatureModelEditor;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureModelView extends ViewPart implements ISelectionListener, ModelListener, IPartListener {

	public static final String ID = "cz.jpikl.yafmt.views.featuremodel.views.FeatureModelView";

	private GraphViewer viewer;	
	private ModelAdapter modelAdapter = new ModelAdapter(this);
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, ZestStyles.NONE);
		viewer.setContentProvider(new FeatureModelContentProvider());
		viewer.setLabelProvider(new FeatureModelLabelProvider());
		viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		viewer.setNodeStyle(ZestStyles.NODES_NO_ANIMATION); // Disable graph animation. Animation duration cannot be set (no API).
		getSite().setSelectionProvider(viewer);
		getSite().getPage().addSelectionListener(this);
		getSite().getPage().addPartListener(this);
		
		// Load editor input when editor is already opened.
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		updateModelAndSelection(editor, null);
	}
	
	private void updateModelAndSelection(IWorkbenchPart part, ISelection selection) {
		if(!(part instanceof FeatureModelEditor))
			return;
		
		FeatureModelEditor editor = (FeatureModelEditor) part;
		if(getModel() != editor.getFeatureModel())
			setModel(editor.getFeatureModel());
		
		if(selection == null)
			return;
		
		Object object = ((IStructuredSelection) selection).getFirstElement();
		Object model = ((EditPart) object).getModel();
		viewer.setSelection(new StructuredSelection(new Object[] { model }));
		
		// Center viewport to selected feature.
		GraphItem item = viewer.findGraphItem(model);
		if(item instanceof GraphNode) {
			Point p = ((GraphNode) item).getLocation();
			Viewport vp = viewer.getGraphControl().getViewport();
			vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
		}
	}
	
	private void setModel(FeatureModel model) {
		FeatureModel prevModel = getModel();
		if(prevModel != null)
			modelAdapter.disconnectFromAll();
			
		// IllegalStateException is thrown when setting input to disposed control
		if(!viewer.getControl().isDisposed())
			viewer.setInput(model);
		
		if(model != null) {
			refreshGraphLayout();
			modelAdapter.connectToAllContents(model.getRootFeature());
		}
	}
	
	private FeatureModel getModel() {
		return (FeatureModel) viewer.getInput();
	}
	
	private void refreshGraphLayout() {
		if(getModel() == null)
			return;
		
		int height = findFeatureTreeHeight(getModel().getRootFeature(), 1);
		viewer.getGraphControl().setPreferredSize(height * 100, height * 100);
		viewer.applyLayout();
	}
	
	private int findFeatureTreeHeight(Feature root, int currentHeight) {
		int foundHeight = currentHeight;
		for(Feature feature: root.getChildren()) {
			int height = findFeatureTreeHeight(feature, currentHeight + 1);
			if(height > foundHeight)
				foundHeight = height;
		}
		return foundHeight;
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	@Override
	public void dispose() {
		setModel(null);
		getSite().getPage().removePartListener(this);
		getSite().getPage().removeSelectionListener(this);
		getSite().setSelectionProvider(null);
		super.dispose();
	}
	
	// ======================================================================
	//  ISelectionListener
	// ======================================================================
		
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		updateModelAndSelection(part, selection);
	}
	
	// ======================================================================
	//  ModelListener
	// ======================================================================
	
	@Override
	public void modelChanged(Notification notification) {
		viewer.refresh();
		
		switch(notification.getEventType()) {
			case Notification.ADD:		
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				modelAdapter.disconnectFromAll();
				modelAdapter.connectToAllContents(getModel().getRootFeature());
				refreshGraphLayout();
				break;
		}
		
	}

	// ======================================================================
	//  IPartListener
	// ======================================================================
	
	@Override
	public void partActivated(IWorkbenchPart part) {
		if(part instanceof FeatureModelEditor)
			updateModelAndSelection(part, null);
	}
	
	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part instanceof FeatureModelEditor)
			setModel(null);
	}
	
	@Override
	public void partOpened(IWorkbenchPart part) {
	}
	
	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	
	
}