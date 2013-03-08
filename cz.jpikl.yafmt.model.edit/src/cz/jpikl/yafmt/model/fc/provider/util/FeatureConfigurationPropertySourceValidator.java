package cz.jpikl.yafmt.model.fc.provider.util;

import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals.DOUBLE_VALUE__VALUE;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals.FEATURE_CONFIGURATION__NAME;
import static cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals.INTEGER_VALUE__VALUE;
import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.provider.FeatureModelEditPlugin;
import cz.jpikl.yafmt.model.validation.IPropertySourceValidator;

public class FeatureConfigurationPropertySourceValidator implements IPropertySourceValidator {

    @Override
    public String validate(Object object, Object property, Object value) {
        try {
            if(object instanceof Selection)
                return validateSelection((Selection) object, property, value);
            if(object instanceof AttributeValue)
                return validateAttributeValue((AttributeValue) object, property, value);
            if(object instanceof FeatureConfiguration)
                return validateFeatureConfiguration((FeatureConfiguration) object, property, value);
        }
        catch(NumberFormatException ex) {
            return getString("_UI_Errors_NotANumber");
        }
        return null;
    }

    private String validateSelection(Selection selection, Object property, Object value) {
        if(property == INTEGER_VALUE__VALUE)
            Integer.parseInt((String) value);
        else if(property == DOUBLE_VALUE__VALUE)
            Double.parseDouble((String) value);
        return null;
    }

    private String validateAttributeValue(AttributeValue object, Object property, Object value) {
        if(property == INTEGER_VALUE__VALUE)
            Integer.parseInt((String) value);
        else if(property == DOUBLE_VALUE__VALUE)
            Double.parseDouble((String) value);
        return null;
    }

    private String validateFeatureConfiguration(FeatureConfiguration featureConfig, Object property, Object value) {
        if(property == FEATURE_CONFIGURATION__NAME)
            return checkEmptyValue((String) value, "_UI_FeatureConfiguration_name_feature");
        return null;
    }

    private String checkEmptyValue(String value, String name) {
        if((value == null) || value.isEmpty())
            return getString("_UI_Errors_Empty", getString(name));
        return null;
    }

    private String getString(String key, Object param) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, new Object[] { param }, true);
    }

    private String getString(String key) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, true);
    }

}
