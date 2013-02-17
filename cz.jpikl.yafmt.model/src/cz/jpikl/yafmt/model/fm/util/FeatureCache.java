package cz.jpikl.yafmt.model.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;

public class FeatureCache {
    
    private Map<String, Feature> idToFeature;
    private Adapter adapter;
    
    public FeatureCache(FeatureModel featureModel) {
        if(featureModel == null)
            throw new IllegalArgumentException("Argument cannot be null");
        
        idToFeature = new HashMap<String, Feature>();
        adapter = new Adapter();
        featureModel.eAdapters().add(adapter);
    }
    
    public void dispose() {
        adapter.getTarget().eAdapters().remove(adapter);
        adapter = null;
        idToFeature = null;
    }
    
    public Feature getFeature(String id) {
        return idToFeature.get(id);
    }
        
    private class Adapter extends EContentAdapter {
        
        @Override
        protected void addAdapter(Notifier notifier) {
            super.addAdapter(notifier);
            
            if(notifier instanceof Feature)
                idToFeature.put(((Feature) notifier).getId(), (Feature) notifier);
        }
        
        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            
            if(notifier instanceof Feature)
                idToFeature.remove(((Feature) notifier).getId());
        }
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            
            if(!(notification.getNotifier() instanceof Feature))
                return;
            
            if(notification.getFeatureID(Feature.class) == FeatureModelPackage.FEATURE__ID) {
                Feature feature = idToFeature.remove(notification.getOldStringValue());
                idToFeature.put(notification.getNewStringValue(), feature);
            }
        }
        
    }
    
}
