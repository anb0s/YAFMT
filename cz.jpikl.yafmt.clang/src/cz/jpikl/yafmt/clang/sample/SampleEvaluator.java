package cz.jpikl.yafmt.clang.sample;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.EvaluationResult;
import cz.jpikl.yafmt.clang.Evaluator;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

/**
 * Example implementation of the {@link IEvaluator} interface for the
 * {@link SampleConstraintLanguage}. The
 * {@link #getAffectedFeatures(cz.jpikl.yafmt.model.fm.FeatureModel)} and the
 * {@link #validate(cz.jpikl.yafmt.model.fm.FeatureModel)} methods were already
 * implemented in the {@link Evaluator} class.
 * 
 * @author Jan Pikl
 */
public class SampleEvaluator extends Evaluator {

    private String leftOperand;
    private String rightOperand;
    private Operator operator;

    /**
     * Creates evaluator.
     * 
     * @param leftOperand
     *            feature ID representing the right operand
     * @param rightOperand
     *            feature ID representing the left operand
     * @param operator
     *            operator
     */
    public SampleEvaluator(String leftOperand, String rightOperand, Operator operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        // Get list of selected features matching the ID of the left operand.
        List<Selection> leftSelections = featureConfig.getSelectionsById(leftOperand);

        // No feature selected, the constraint is satisfied.
        if(leftSelections.isEmpty())
            return EvaluationResult.SUCCESS_RESULT;

        // Get list of selected features matching the ID of the right operand.
        List<Selection> rightSelections = featureConfig.getSelectionsById(rightOperand);

        // Check if the configuration satisfies this constraint.
        if(operator == Operator.REQUIRES) {
            // The existence of selected features of the right operand is required.
            if(rightSelections.isEmpty()) {
                String leftName = getName(featureConfig, leftOperand);
                String rightName = getName(featureConfig, rightOperand);
                EvaluationResult error = new EvaluationResult(leftName + " requires " + rightName);
                error.getProblemElements().addAll(leftSelections);
                return error;
            }
        }
        else {
            // The existence of selected features of the right operand is prohibited.
            if(!rightSelections.isEmpty()) {
                String leftName = getName(featureConfig, leftOperand);
                String rightName = getName(featureConfig, rightOperand);
                EvaluationResult error = new EvaluationResult("Only 1 of " + leftName + ", " + rightName + " can be selected");
                error.getProblemElements().addAll(leftSelections);
                error.getProblemElements().addAll(rightSelections);
                return error;
            }
        }

        // No problem.
        return EvaluationResult.SUCCESS_RESULT;
    }

    /**
     * Returns name of the feature with the specified ID.
     * 
     * @param featureConfig
     *            the configuration we are evaluating
     * @param featureId
     *            the target ID
     * @return name of the feature with the specified ID
     */
    private String getName(FeatureConfiguration featureConfig, String featureId) {
        return featureConfig.getFeatureModel().getFeatureById(featureId).getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Set<String> getAffectedFeatureIds() {
        // We got only 2 feature IDs to return.
        Set<String> ids = new HashSet<String>();
        ids.add(leftOperand);
        ids.add(rightOperand);
        return ids;
    }

}
