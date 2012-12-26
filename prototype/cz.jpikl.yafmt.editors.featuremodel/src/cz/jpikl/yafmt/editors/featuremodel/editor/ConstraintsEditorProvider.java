package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class ConstraintsEditorProvider implements IStructuredContentProvider, ILabelProvider {

	// =================================================================
	//  IStructuredContentProvider
	// =================================================================

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
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

}
