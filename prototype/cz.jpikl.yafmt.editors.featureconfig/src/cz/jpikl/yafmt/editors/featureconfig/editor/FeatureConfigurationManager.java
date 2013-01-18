package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.editors.featureconfig.utils.FeatureClone;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfigFactory;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featureconfig.Selection;
import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureConfigurationManager {

    private FeatureConfiguration featureConfig;
    private Map<String, Feature> nameToFeature;
    private Map<Feature, Selection> featureToSelection;

    public FeatureConfigurationManager(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
        this.nameToFeature = new HashMap<String, Feature>();
        this.featureToSelection = new HashMap<Feature, Selection>();
        
        reloadFeatureNames();
        reloadFeatureSelections();
    }
    
    public FeatureConfiguration getFeatureConfiguration() {
        return featureConfig;
    }

    private void reloadFeatureNames() {
        nameToFeature.clear();
        
        TreeIterator<EObject> it = featureConfig.getFeatureModel().eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Feature) {
                Feature feature = (Feature) object;
                nameToFeature.put(feature.getName(), feature);
            }
        }
    }
    
    private void reloadFeatureSelections() {
        featureToSelection.clear();
        List<Selection> invalidSelections = new ArrayList<Selection>();
        Map<Feature, Integer> clonesCount = new HashMap<Feature, Integer>();
        Set<Feature> missingSelections = new HashSet<Feature>();
        
        // Load all selections into hash map.
        for(Selection selection: featureConfig.getSelection()) {
            // Check for invalid selection.
            Feature feature = selection.getFeature();
            if(feature == null) {
                invalidSelections.add(selection);
                continue;
            }
            
            // Clone features with cardinality larger than 1 with multiple selection.
            if(featureToSelection.containsKey(feature)) {
                Integer count = clonesCount.get(feature);
                if(count == null)
                    count = new Integer(1);
                else
                    count++;
                
                clonesCount.put(feature, count);
                feature = new FeatureClone(feature, count);
            }
            
            featureToSelection.put(feature, selection);
        }
        
        // Remove selections with missing features.
        featureConfig.getSelection().removeAll(invalidSelections);
        
        // Find all selected features which parents are not selected.
        for(Selection selection: featureConfig.getSelection()) {
            Feature feature = selection.getFeature();
            while(feature != null) {
                if(!isFeatureSelected(feature))
                    missingSelections.add(feature);
                feature = feature.getParent();
            }
        }
        
        // Select unselected parent features.
        for(Feature feature: missingSelections)
            selectFeature(feature);
        
        // Check if root feature is selected.
        Feature rootFeature = featureConfig.getFeatureModel().getRootFeature();
        if(!isFeatureSelected(rootFeature))
            selectFeature(rootFeature);
    }
            
    public Selection selectFeature(Feature feature) {
        Selection selection = FeatureConfigFactory.eINSTANCE.createSelection();
        if(feature instanceof FeatureClone)
            selection.setFeature(((FeatureClone) feature).getOriginator());
        else
            selection.setFeature(feature);
        
        featureToSelection.put(feature, selection);
        featureConfig.getSelection().add(selection);
        
        return selection;
    }
    
    public List<Selection> unselectFeature(Feature feature) {
        List<Selection> selections = new ArrayList<Selection>();
        unselectFeature(selections, feature);
        featureConfig.getSelection().removeAll(selections);
        return selections;
    }
    
    private void unselectFeature(List<Selection> selections, Feature feature) {
        Selection selection = featureToSelection.remove(feature);
        if(selection != null) {
            selection.setFeature(null);
            selections.add(selection);
            for(Feature child: feature.getChildren())
                unselectFeature(selections, child);
        }
    }
    
    public boolean isFeatureSelected(Feature feature) {
        return featureToSelection.containsKey(feature);
    }
        
    public boolean isFeatureSelectable(Feature feature) {
        Feature parentFeature = feature.getParent();
        if((parentFeature != null) && !isFeatureSelected(parentFeature))
            return false;
        
        String featureName = feature.getName();
        for(Constraint constraint: featureConfig.getFeatureModel().getConstraints()) {
            String[] names = constraint.getValue().split("\\s+");
            boolean shouldTest = false;
            
            for(String name: names) {
                if(featureName.equals(name)) {
                    shouldTest = true;
                    break;
                }
            }
            
            if(shouldTest) {
                for(String name: names) {
                    if(!featureName.equals(name) && isFeatureSelected(nameToFeature.get(name)))
                        return false;
                }
            }
        }
        
        return true;
    }

}
