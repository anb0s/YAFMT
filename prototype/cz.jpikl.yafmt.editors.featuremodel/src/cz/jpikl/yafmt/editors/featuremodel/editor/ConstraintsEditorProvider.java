package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class ConstraintsEditorProvider implements IStructuredContentProvider, ILabelProvider, ModelListener {

	private Viewer viewer;
	private ModelAdapter adapter = new ModelAdapter(this);
	
	// =================================================================
	//  IStructuredContentProvider
	// =================================================================

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		
		FeatureModel featureModel = (FeatureModel) newInput;
		adapter.disconnectFromAll();
		adapter.connect(featureModel);
	}
	
	@Override
	public void dispose() {	
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return ((FeatureModel) inputElement).getConstraints().toArray();
	}
	
	// =================================================================
	//  ILabelProvider
	// =================================================================
	
	@Override
	public String getText(Object element) {
		return ((Constraint) element).getValue();
	}
	
	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	// =================================================================
	//  ILabelProvider
	// =================================================================
	
	@Override
	public void modelChanged(Notification notification) {
		viewer.refresh();
	}

}
