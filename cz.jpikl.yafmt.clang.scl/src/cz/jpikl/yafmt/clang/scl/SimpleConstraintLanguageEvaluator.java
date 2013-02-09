package cz.jpikl.yafmt.clang.scl;

import java.util.Set;

import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;

public class SimpleConstraintLanguageEvaluator extends Evaluator {

    private Expression expression;
    
    public SimpleConstraintLanguageEvaluator(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    protected Set<String> getAffectedFeatureIds() {
        return null;
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        return null;
    }

}
