package cz.jpikl.yafmt.clang.dummy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;

public class DummyEvaluator extends Evaluator {

    private Set<String> featureIds;
    
    public DummyEvaluator(String[] ids) {
        featureIds = new HashSet<String>(Arrays.asList(ids));
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        return EvaluationResult.SUCCESS_RESULT;
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        return featureIds;
    }

}
