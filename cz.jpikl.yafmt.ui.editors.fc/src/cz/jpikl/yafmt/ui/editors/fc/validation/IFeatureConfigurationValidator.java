package cz.jpikl.yafmt.ui.editors.fc.validation;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;

public interface IFeatureConfigurationValidator {

	void validate(FeatureConfiguration featureConfig, IValidationResultWriter writer);
	
}
