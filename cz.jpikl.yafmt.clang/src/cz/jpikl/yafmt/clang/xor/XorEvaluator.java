package cz.jpikl.yafmt.clang.xor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;

public class XorEvaluator extends Evaluator {

    private Set<String> featureIds;

    public XorEvaluator(String[] ids) {
        featureIds = new HashSet<String>(Arrays.asList(ids));
    }

    private String createErrorMessage() {
        StringBuilder builder = null;
        for(String id: featureIds) {
            if(builder == null)
                builder = new StringBuilder("Only one of the following features should be selected: ").append(id);
            else
                builder.append(", ").append(id);
        }
        return builder.append(".").toString();
    }
    
    private IEvaluationResult createFailureResult(FeatureConfiguration featureConfig) {
        EvaluationResult result = new EvaluationResult(createErrorMessage());
        
        for(String id: featureIds)
            result.getProblemElements().addAll(featureConfig.getSelectionsById(id));
        
        if(result.getProblemElements().isEmpty())
            result.getProblemElements().add(featureConfig.getRoot());
        
        return result;
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        int count = 0;
        for(String id: featureIds) {
            if(!featureConfig.getSelectionsById(id).isEmpty()) {
                count++;
                if(count > 1)
                    break;
            }
        }
        
        if(count == 1)
            return EvaluationResult.SUCCESS_RESULT;
        else
            return createFailureResult(featureConfig);
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        return featureIds;
    }

}
