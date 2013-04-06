package cz.jpikl.yafmt.clang.base;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

public class BaseEvaluator extends Evaluator {

    private String leftOperand;
    private String rightOperand;
    private Operator operator;

    public BaseEvaluator(String leftOperand, String rightOperand, Operator operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }
    
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        List<Selection> leftSelections = featureConfig.getSelectionsById(leftOperand);
        if(leftSelections.isEmpty())
            return EvaluationResult.SUCCESS_RESULT;
        
        List<Selection> rightSelections = featureConfig.getSelectionsById(rightOperand);
        
        if(operator == Operator.REQUIRES) {
            if(rightSelections.isEmpty()) {
                String leftName = getName(featureConfig, leftOperand);
                String rightName = getName(featureConfig, rightOperand);
                EvaluationResult error = new EvaluationResult(leftName + " requires " + rightName);
                error.getProblemElements().addAll(leftSelections);
                return error;
            }
        }
        else {
            if(!rightSelections.isEmpty()) {
                String leftName = getName(featureConfig, leftOperand);
                String rightName = getName(featureConfig, rightOperand);
                EvaluationResult error = new EvaluationResult("Only 1 of " + leftName + ", " + rightName + " can be selected");
                error.getProblemElements().addAll(leftSelections);
                error.getProblemElements().addAll(rightSelections);
                return error;
            }
        }
        
        return EvaluationResult.SUCCESS_RESULT;
    }
    
    private String getName(FeatureConfiguration featureConfig, String featureId) {
        return featureConfig.getFeatureModel().getFeatureById(featureId).getName();
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        Set<String> ids = new HashSet<String>();
        ids.add(leftOperand);
        ids.add(rightOperand);
        return ids;
    }

}
