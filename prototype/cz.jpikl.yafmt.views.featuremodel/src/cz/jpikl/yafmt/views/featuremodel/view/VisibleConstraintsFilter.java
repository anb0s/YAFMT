package cz.jpikl.yafmt.views.featuremodel.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class VisibleConstraintsFilter extends ViewerFilter {

	private Set<String> selectedFeatureIds = new HashSet<String>();
	private Set<Constraint> selectedConstraints = new HashSet<Constraint>();
	
	@SuppressWarnings("unchecked")
	public void selectionChanged(ISelection selection) {
		selectedFeatureIds.clear();
		selectedConstraints.clear();

		Iterator<Object> it = ((IStructuredSelection) selection).iterator();
		while(it.hasNext()) {
			Object object = it.next();
			if(object instanceof Feature)
				selectedFeatureIds.add(((Feature) object).getName());
			else if(object instanceof Constraint)
				selectedConstraints.add((Constraint) object);
		}
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(element instanceof Constraint) {
			Constraint constraint = (Constraint) element;
			if(selectedConstraints.contains(constraint))
				return true;
			for(String name: constraint.getValue().split("\\s+")) {
				if(selectedFeatureIds.contains(name))
					return true;
			}
			return false;
		}
		return true;
	}

}
