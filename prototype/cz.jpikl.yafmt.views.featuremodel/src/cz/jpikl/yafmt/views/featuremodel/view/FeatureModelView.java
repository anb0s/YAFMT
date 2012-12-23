package cz.jpikl.yafmt.views.featuremodel.view;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import cz.jpikl.yafmt.editors.featuremodel.editor.FeatureModelEditor;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureModelView extends ViewPart implements ISelectionListener, ModelListener {

	public static final String ID = "cz.jpikl.yafmt.views.featuremodel.views.FeatureModelView";

	private GraphViewer viewer;	
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.NONE);
		viewer.setContentProvider(new FeatureModelContentProvider());
		viewer.setLabelProvider(new FeatureModelLabelProvider());
		viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		getSite().getPage().addSelectionListener(this);
	}
	
	private void setModel(FeatureModel model) {
		FeatureModel prevModel = getModel();
		if(prevModel != null)
			ModelAdapter.removeListenerFromAllContents(prevModel.getRootFeature(), this);
			
		if(model != null) {
			viewer.setInput(model);
			refreshGraphLayout();
			ModelAdapter.addListenerToAllContents(model.getRootFeature(), this);
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
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}
		
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(part instanceof FeatureModelEditor) {
			FeatureModelEditor editor = (FeatureModelEditor) part;
			if(getModel() != editor.getFeatureModel())
				setModel(editor.getFeatureModel());
			Object object = ((IStructuredSelection) selection).getFirstElement();
			Object model = ((EditPart) object).getModel();
			viewer.setSelection(new StructuredSelection(new Object[] { model }));
		}
	}

	@Override
	public void modelChanged(Notification notification) {
		viewer.refresh();
		
		switch(notification.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				refreshGraphLayout();
				break;
		}
		
	}
	
}