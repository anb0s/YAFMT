package cz.jpikl.yafmt.clang.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class ConstraintCache {

    private Map<Constraint, List<Feature>> constraintToFeatures = new HashMap<Constraint, List<Feature>>();
    private Map<Feature, Set<Constraint>> featureToConstraints = new HashMap<Feature, Set<Constraint>>();
    
    private FeatureModel featureModel;
    private boolean valid = false;
    
    public ConstraintCache() {
        setFeatureModel(null);
    }
    
    public void dispose() {
        setFeatureModel(null);
    }
    
    public void setFeatureModel(FeatureModel featureModel) {
        if(this.featureModel != featureModel) {
            this.featureModel = featureModel;
            invalidate();
        }
    }
    
    public void invalidate() {
        featureToConstraints.clear();
        constraintToFeatures.clear();
        valid = false;
    }
        
    public Collection<Feature> getFeaturesAffectedByConstraint(Constraint constraint) {
        checkValidity();
        return constraintToFeatures.get(constraint);
    }
    
    public Collection<Constraint> getConstraintsAffectingFeature(Feature feature) {
        checkValidity();
        return featureToConstraints.get(feature);
    }
    
    private void checkValidity() {
        if(!valid && (featureModel != null)) {
            refresh();
            valid = true;
        }
    }
    
    private void refresh() {
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        
        for(Constraint constraint: featureModel.getConstraints()) {
            IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
            if(langauge == null)
                continue;
            
            try {
                IEvaluator evaluator = langauge.createEvaluator(constraint.getValue());
                List<Feature> features = evaluator.getAffectedFeatures(featureModel);
                constraintToFeatures.put(constraint, features);
                
                for(Feature feature: features) {
                    Set<Constraint> set = featureToConstraints.get(feature);
                    if(set == null) {
                        set = new HashSet<Constraint>();
                        featureToConstraints.put(feature, set);
                    }
                    set.add(constraint);
                }
            }
            catch(ConstraintLanguageException ex) {
                // Ignore that.
            }
        }
    }   
    
}
