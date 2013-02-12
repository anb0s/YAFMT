package cz.jpikl.yafmt.clang.dummy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Feature;

public class DummyEvaluator extends Evaluator {

    private Set<String> featureIds;
    
    public DummyEvaluator(String[] ids) {
        featureIds = new HashSet<String>(Arrays.asList(ids));
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig, List<Feature> featuresToSelect) {
        int count = 0;
        
        for(String id: featureIds) {
            List<Selection> selections = featureConfig.getSelectionsById(id);
            if((selections != null) && !selections.isEmpty()) {
                count++;
            }
            else {
                for(Feature featureToSelect: featuresToSelect) {
                    if(id.equals(featureToSelect.getId())) {
                        count++;
                        break;
                    }
                }
            }
            
            if(count > 1)
                return EvaluationResult.createFailureResult(null);
        }
            
        return EvaluationResult.SUCCESS_RESULT;
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        return featureIds;
    }

}
