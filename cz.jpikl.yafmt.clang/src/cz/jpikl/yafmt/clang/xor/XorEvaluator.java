package cz.jpikl.yafmt.clang.xor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

public class XorEvaluator extends Evaluator {

    private Set<String> featureIds;
    
    public XorEvaluator(String[] ids) {
        featureIds = new HashSet<String>(Arrays.asList(ids));
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        int count = 0;
        
        for(String id: featureIds) {
            List<Selection> selections = featureConfig.getSelectionsById(id);
            if((selections != null) && !selections.isEmpty())
                count++;
            if(count > 1)
                return EvaluationResult.createFailureResult(null);
        }

        return (count > 1) ? EvaluationResult.SUCCESS_RESULT : EvaluationResult.createFailureResult(null);
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        return featureIds;
    }

}
