package cz.jpikl.yafmt.clang.scl.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Feature;

public class SelectionHelper {

    private FeatureConfiguration featureConfig; // Features which are already selected.
    private List<Feature> featuresToSelect;     // Features which user want to select.
    
    public SelectionHelper(FeatureConfiguration featureConfig, List<Feature> featuresToSelect) {
        this.featureConfig = featureConfig;
        this.featuresToSelect = featuresToSelect;
    }
    
    public boolean isFeatureSelected(String featureId) {
        return isFeatureSelected(null, featureId);
    }
    
    public boolean isFeatureSelected(String contextId, String featureId) {
        return isFeatureBeingSelected(contextId, featureId) || isFeatureAlreadySelected(contextId, featureId);
    }
    
    public boolean isFeatureBeingSelected(String contextId, String featureId) {
        // No features are being selected.
        if(featuresToSelect == null)
            return false;
        
        // Look for the feature in list of all features which are being selected.
        Feature feature = null;
        for(Feature featureToSelect: featuresToSelect) {
            if(featureId.equals(featureToSelect.getId())) {
                feature = featureToSelect;
                break;
            }
        }
        
        // Feature is not being selected.
        if(feature == null)
            return false;
                
        // Feature is being selected and no need to check context.
        if(contextId == null)
            return true;
        
        // Feature is being selected, but check context (look for an ancestor with given ID).
        for(EObject parent = feature; parent != null; parent.eContainer()) {
            if((parent instanceof Feature) && contextId.equals(((Feature) parent).getId()))
                return true;
        }
        
        return false;
    }
    
    public boolean isFeatureAlreadySelected(String contextId, String featureId) {
        // Get all feature selections with specified ID.
        EList<Selection> selections = featureConfig.getSelectionsById(featureId);        
        
        // Feature is not selected.
        if((selections == null) || selections.isEmpty())
        
         // Feature is selected and no need to check context.
        if(contextId == null)
            return true;
        
        // Feature is selected, but check context (look for an ancestor with given ID).
        for(Selection selection: selections) {
            for(Selection ancestor = selection; ancestor != null; ancestor = ancestor.getParent()) {
                if(contextId.equals(ancestor.getId()))
                    return true;
            }
        }
        
        return false;
    }  
    
}
