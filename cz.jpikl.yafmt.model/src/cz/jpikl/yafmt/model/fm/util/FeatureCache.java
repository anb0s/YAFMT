package cz.jpikl.yafmt.model.fm.util;

import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE__ID;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class FeatureCache {

    private Map<String, Feature> idToFeature;
    private FeatureModelAdapter featureModelAdapter;

    public FeatureCache(FeatureModel featureModel) {
        if(featureModel == null)
            throw new IllegalArgumentException("Feature model cannot be null");

        idToFeature = new HashMap<String, Feature>();
        featureModelAdapter = new FeatureModelAdapter();
        featureModel.eAdapters().add(featureModelAdapter);
    }

    public void dispose() {
        featureModelAdapter.getTarget().eAdapters().remove(featureModelAdapter);
        featureModelAdapter = null;
        idToFeature = null;
    }

    public Feature getFeatureById(String id) {
        return idToFeature.get(id);
    }
    
    // =======================================================================
    //  Events
    // =======================================================================

    private class FeatureModelAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            if(notifier instanceof Attribute)
                return;

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

            if((notification.getNotifier() instanceof Feature) && (notification.getFeatureID(Feature.class) == FEATURE__ID)) {
                Feature feature = idToFeature.remove(notification.getOldStringValue());
                idToFeature.put(notification.getNewStringValue(), feature);
            }
        }

    }

}
