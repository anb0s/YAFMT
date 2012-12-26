package cz.jpikl.yafmt.models.featuremodel.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureModelUtil implements ModelListener {

	private Map<String, Feature> featureMap;
	private ModelAdapter modelAdapter;
	
	
	public FeatureModelUtil(FeatureModel featureModel) {
		this.featureMap = new HashMap<String, Feature>();
		this.modelAdapter = new ModelAdapter(this);		
		this.modelAdapter.connectToAllContents(featureModel);
		
		TreeIterator<EObject> it = featureModel.eAllContents();
		while(it.hasNext()) {
			EObject object = it.next();
			if(object instanceof Feature)
				addFeature((Feature) object);
		}
	}
	
	public Feature getFeatureByName(String name) {
		return featureMap.get(name);
	}

	private void addFeature(Feature feature) {
		modelAdapter.connect(feature);
		featureMap.put(feature.getName(), feature);
	}
	
	private void replaceFeature(String oldName, String newName) {
		Feature feature = featureMap.remove(oldName);
		if((feature != null) && (newName != null))
			featureMap.put(newName, feature);
	}
	
	private void removeFeature(Feature feature) {
		modelAdapter.disconnect(feature);
		featureMap.remove(feature.getName());
	}

	@Override
	public void modelChanged(Notification notification) {
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		
		// The code expect that all children of added feature are already registered,
		// so only the changed one should be handled.
		
		switch(notification.getEventType()) {
			case Notification.ADD:
				if(newValue instanceof Feature)
					addFeature((Feature) newValue);
				break;
			
			case Notification.ADD_MANY:
				if(newValue instanceof Collection<?>) {
					for(Object object: (Collection<?>) newValue) {
						if(object instanceof Feature)
							addFeature((Feature) object);
					}
				}
				break;
				
			case Notification.REMOVE:
				if(oldValue instanceof Feature)
					removeFeature((Feature) oldValue);
				break;
			
			case Notification.REMOVE_MANY:
				if(oldValue instanceof Collection<?>) {
					for(Object object: (Collection<?>) oldValue) {
						if(object instanceof Feature)
							removeFeature((Feature) object);
					}
				}
				break;
				
			case Notification.SET:
				if(notification.getFeatureID(Feature.class) == FeatureModelPackage.FEATURE__NAME)
					replaceFeature((String) oldValue, (String) newValue);
		}
	}
	
	
	
}
