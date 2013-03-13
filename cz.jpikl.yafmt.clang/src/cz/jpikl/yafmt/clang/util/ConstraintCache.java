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

// Write-back cache preserving feature-constraint mapping, indicating which
// constraints affect which features and vice versa. Cache must be manually
// invalidated when underlying model is changed. Refresh of invalidated cache
// is lazily performed later when cached data are requested.
public class ConstraintCache {

    private ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
    private Map<Constraint, List<Feature>> constraintToFeatures = new HashMap<Constraint, List<Feature>>();
    private Map<Feature, Set<Constraint>> featureToConstraints = new HashMap<Feature, Set<Constraint>>();

    private FeatureModel featureModel;
    private boolean valid = false;

    public ConstraintCache() {
        this(null);
    }

    public ConstraintCache(FeatureModel featureModel) {
        setFeatureModel(featureModel);
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

    public Collection<Feature> getFeaturesAffectedByConstraint() {
        checkValidity();
        return featureToConstraints.keySet();
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
        for(Constraint constraint: featureModel.getConstraints()) {
            List<Feature> features = getAffectedFeatures(constraint);
            if(features != null) {
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
        }
    }

    private List<Feature> getAffectedFeatures(Constraint constraint) {
        IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
        if(langauge == null)
            return null;

        try {
            IEvaluator evaluator = langauge.createEvaluator(constraint.getValue());
            return evaluator.getAffectedFeatures(featureModel);
        }
        catch(ConstraintLanguageException ex) {
            return null; // Ignore that.
        }
    }

}
