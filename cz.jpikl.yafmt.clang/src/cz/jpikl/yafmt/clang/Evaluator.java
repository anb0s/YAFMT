package cz.jpikl.yafmt.clang;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public abstract class Evaluator implements IEvaluator {

    @Override
    public List<Feature> getAffectedFeatures(FeatureModel featureModel) {
        if(featureModel == null)
            return null;
        
        Set<String> ids = getAffectedFeatureIds();
        if(ids == null)
            return null;
        
        List<Feature> features = new ArrayList<Feature>(ids.size());
        for(String id: ids) {
            Feature feature = featureModel.getFeatureById(id);
            if(feature != null)
                features.add(feature);
        }
        return features;
    }
    
    public List<String> getMissingFeatures(FeatureModel featureModel) {
        if(featureModel == null)
            return null;
        
        Set<String> ids = getAffectedFeatureIds();
        if(ids == null)
            return null;
        
        List<String> features = null;
        for(String id: ids) {
            if(featureModel.getFeatureById(id) == null) {
                if(features == null)
                    features = new ArrayList<String>();
                features.add(id);
            }
        }
        return features;
    }
    
    protected abstract Set<String> getAffectedFeatureIds();
    
}
