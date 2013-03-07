package cz.jpikl.yafmt.ui.editors.fc.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluationResult;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class GlobalConstraintsValidator implements IFeatureConfigurationValidator {

	private List<IEvaluator> evaluators = null;
	private Map<IEvaluator, String> constraintValues = null;
	
	@Override
	public void validate(FeatureConfiguration featureConfig, IValidationResultWriter writer) {
		initEvaluators(featureConfig);
		
		for(IEvaluator evaluator: evaluators)
			validateContraint(featureConfig, evaluator, writer);
	}
	
	private void initEvaluators(FeatureConfiguration featureConfig) {
		if(evaluators != null)
			return;
		
		evaluators = new ArrayList<IEvaluator>();
		constraintValues = new HashMap<IEvaluator, String>();
		
		FeatureModel featureModel = featureConfig.getFeatureModelCopy();
		ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
		
		for(Constraint constraint: featureModel.getConstraints()) {
			try {
				// Add evaluators only for valid constraints.
				IConstraintLanguage language = registry.getLanguage(constraint.getLanguage());
				if(language == null)
					continue;
				IEvaluator evaluator = language.createEvaluator(constraint.getValue());
				if(evaluator.validate(featureModel).isSuccess()) {
					evaluators.add(evaluator);
					constraintValues.put(evaluator, constraint.getValue());
				}
			}
			catch(ConstraintLanguageException ex) {
				// Ignore it.
			}
		}
	}
	
	private void validateContraint(FeatureConfiguration featureConfig, IEvaluator evaluator, IValidationResultWriter writer) {
		IEvaluationResult result = evaluator.evaluate(featureConfig);
		if(result.isSuccess())
			return;
			
		StringBuilder messageBuilder = new StringBuilder(constraintValues.get(evaluator));
		messageBuilder.append(" is violated");
		
		String errorMessage = result.getErrorMessage();
		if((errorMessage != null) && !errorMessage.isEmpty())
			messageBuilder.append(" (").append(errorMessage).append("");
		messageBuilder.append(".");
		
		errorMessage = messageBuilder.toString();
		
		FeatureModel featureModel = featureConfig.getFeatureModel();
		List<Feature> affectedFeatures = evaluator.getAffectedFeatures(featureModel);
		if(affectedFeatures == null)
			return;
		
		for(Feature feature: affectedFeatures) {
			List<Selection> selections = featureConfig.getSelectionsById(feature.getId());
			if(selections != null) {
				for(Selection selection: selections)
					writer.addError(selection, errorMessage);
			}
		}
	}

}
