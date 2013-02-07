package cz.jpikl.yafmt.clang;

import java.util.ArrayList;
import java.util.List;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public abstract class Evaluator implements IEvaluator {

    @Override
    public List<Feature> getAffectedFeatures(FeatureModel featureModel) {
        if(featureModel == null)
            return null;
        
        List<String> ids = getAffectedFeatureIds();
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
    
    protected abstract List<String> getAffectedFeatureIds();
    
}
