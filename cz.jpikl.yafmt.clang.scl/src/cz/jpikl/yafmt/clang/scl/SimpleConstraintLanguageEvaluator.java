package cz.jpikl.yafmt.clang.scl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.util.SelectionHelper;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fm.Feature;

public class SimpleConstraintLanguageEvaluator extends Evaluator {

    private Expression expression;
    
    public SimpleConstraintLanguageEvaluator(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    protected Set<String> getAffectedFeatureIds() {
        Set<String> ids = new HashSet<String>();
        expression.retrieveFeatureIds(ids);
        return ids;
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig, List<Feature> featuresToSelect) {
        SelectionHelper selectionHelper = new SelectionHelper(featureConfig, featuresToSelect);
        if(expression.evaluate(selectionHelper, null))
            return EvaluationResult.SUCCESS_RESULT;
        return EvaluationResult.createFailureResult(null);
    }

}
