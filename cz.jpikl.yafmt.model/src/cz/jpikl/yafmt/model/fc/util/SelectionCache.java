package cz.jpikl.yafmt.model.fc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.Selection;

public class SelectionCache {

    private Map<String, EList<Selection>> idToSelections; // Multimap
    private Adapter adapter;
    
    public SelectionCache(FeatureConfiguration featureConfig) {
        if(featureConfig == null)
            throw new IllegalArgumentException("Argument cannot be null");
        
        idToSelections = new HashMap<String, EList<Selection>>();
        adapter = new Adapter();
        featureConfig.eAdapters().add(adapter);
    }
    
    public EList<Selection> getSelectionsById(String id) {
        return idToSelections.get(id);
    }
    
    private void addSelection(Selection selection) {
        String id = selection.getId();
        EList<Selection> selections = idToSelections.get(id);
        
        if(selections == null) {
            selections = new BasicEList<Selection>();
            idToSelections.put(id, selections);
        }
        
        selections.add(selection);
    }
    
    private void removeSelection(Selection selection, String oldId) {
        String id = (oldId != null) ? oldId : selection.getId();
        EList<Selection> selections = idToSelections.get(id);
        
        // Should not happen.
        if(selections == null)
            return;
        
        selections.remove(selection);
        if(selections.isEmpty())
            idToSelections.remove(id);
    }
    
    private class Adapter extends EContentAdapter {
        
        @Override
        protected void addAdapter(Notifier notifier) {
            super.addAdapter(notifier);
            if(notifier instanceof Selection)
                addSelection((Selection) notifier);
        }
        
        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            if(notifier instanceof Selection)
                removeSelection((Selection) notifier, null);
        }
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            if(notification.getFeatureID(Selection.class) == FeatureConfigurationPackage.SELECTION__ID) {
                Selection selection = (Selection) notification.getNotifier();
                removeSelection(selection, notification.getOldStringValue());
                addSelection(selection); // Should have the new ID value.
            }
        }
        
    }
    
}
