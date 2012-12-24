package cz.jpikl.yafmt.views.featuremodel.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureModelContentProvider implements IGraphEntityContentProvider {

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

	@Override
	public Object[] getElements(Object input) {
		List<Object> features = new ArrayList<Object>();
		if(input == null)
			return features.toArray();
		
		Feature rootFeature = ((FeatureModel) input).getRootFeature();
		features.add(rootFeature);
		
		TreeIterator<EObject> it = rootFeature.eAllContents();
		while(it.hasNext()) {
			EObject obj = it.next();
			if(obj instanceof Feature)
				features.add(obj);
		}
		
		return features.toArray();
	}

	@Override
	public Object[] getConnectedTo(Object object) {
		return ((Feature) object).getChildren().toArray();
	}
	
	@Override
	public void dispose() {	
	}

}
