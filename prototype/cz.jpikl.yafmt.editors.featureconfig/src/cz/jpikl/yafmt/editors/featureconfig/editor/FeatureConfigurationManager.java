package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        for(Selection selection: featureConfig.getSelection()) {
            Feature feature = selection.getFeature();
            if(feature == null) {
                invalidSelections.add(selection);
                continue;
            }
            
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
        
        featureConfig.getSelection().removeAll(invalidSelections);
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
    
    public void unselectFeature(Feature feature) {
        Selection selection = featureToSelection.remove(feature);
        if(selection != null) {
            selection.setFeature(null);
            featureConfig.getSelection().remove(selection);
        }
    }
    
    public boolean isFeatureSelected(Feature feature) {
        return featureToSelection.containsKey(feature);
    }
        
    public boolean isFeatureSelectable(Feature feature) {
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
                    if(!featureName.equals(name) && isFeatureSelected(feature))
                        return false;
                }
            }
        }
        
        return true;
    }

}
