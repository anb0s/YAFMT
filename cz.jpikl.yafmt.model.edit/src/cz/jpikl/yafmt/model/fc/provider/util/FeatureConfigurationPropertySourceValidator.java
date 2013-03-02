package cz.jpikl.yafmt.model.fc.provider.util;

import cz.jpikl.yafmt.model.fc.BooleanValue;
import cz.jpikl.yafmt.model.fc.DoubleValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.IntegerValue;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fc.StringValue;
import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.provider.FeatureModelEditPlugin;
import cz.jpikl.yafmt.model.validation.IPropertySourceValidator;

public class FeatureConfigurationPropertySourceValidator implements IPropertySourceValidator {

    @Override
    public String validate(Object object, Object property, Object value) {
        try {
            if(object instanceof Selection)
                return validateSelection((Selection) object, property, (String) value);
            if(object instanceof BooleanValue)
                return validateBooleanValue((BooleanValue) object, property, (String) value);
            if(object instanceof IntegerValue)
                return validateIntegerValue((IntegerValue) object, property, (String) value);
            if(object instanceof DoubleValue)
                return validateDoubleValue((DoubleValue) object, property, (String) value);
            if(object instanceof StringValue)
                return validateStringValue((StringValue) object, property, (String) value);
            if(object instanceof FeatureConfiguration)
                return validateFeatureConfiguration((FeatureConfiguration) object, property, (String) value);
                
        }
        catch(NumberFormatException ex) {
            return getString("_UI_Errors_NotANumber");
        }
        return null;
    }
    
    private String validateSelection(Selection selection, Object property, String value) {
        return null;
    }

    private String validateBooleanValue(BooleanValue booleanValue, Object property, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    private String validateIntegerValue(IntegerValue integerValue, Object property, String value) {
        
        return null;
    }

    private String validateDoubleValue(DoubleValue doubleValue, Object property, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    private String validateStringValue(StringValue stringValue, Object property, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    private String validateFeatureConfiguration(FeatureConfiguration featureConfig, Object property, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    private String getString(String key, Object param) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, new Object[] { param }, true);
    }
    
    private String getString(String key) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, true);
    }

}
