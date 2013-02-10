package cz.jpikl.yafmt.model.fm.provider.util;

import java.util.regex.Pattern;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.provider.FeatureModelEditPlugin;
import cz.jpikl.yafmt.model.provider.util.IPropertySourceValidator;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.Literals.*;

public class FeatureModelPropertySourceValidator implements IPropertySourceValidator {
        
    @Override
    public String validate(Object object, Object property, Object value) {
        try {
            if(object instanceof Feature)
                return validateFeature((Feature) object, property, (String) value);
            if(object instanceof Group)
                return validateGroup((Group) object, property, (String) value);
            if(object instanceof Attribute)
                return validateAttribute((Attribute) object, property, (String) value);
            if(object instanceof FeatureModel)
                return validateFeatureModel((FeatureModel) object, property, (String) value);
        }
        catch(NumberFormatException ex) {
            return getString("_UI_Errors_NotANumber");
        }
        return null;
    }
    
    private String validateFeature(Feature feature, Object property, String value) {
        if(property == FEATURE__ID) {
            String result = checkIdValue(value, "_UI_Feature_id_feature");
            if(result != null)
                return result;
            Feature otherFeature = feature.getFeatureModel().getFeatureById(value);
            if((otherFeature != null) && (otherFeature != feature))
                return getString("_UI_Errors_IdNotUnique", getString("_UI_FeatureModel_type"));
            return null;
        }
        if(property == FEATURE__NAME)
            return checkEmptyValue(value, "_UI_Feature_name_feature");
        if(property == FEATURE__LOWER)
            return checkBounds(Integer.parseInt(value), feature.getUpper());
        if(property == FEATURE__UPPER)
            return checkBounds(feature.getLower(), Integer.parseInt(value));        
        return null;
    }
    
    private String validateGroup(Group group, Object property, String value) {
        if(property == GROUP__LOWER)
            return checkBounds(Integer.parseInt(value), group.getUpper());
        if(property == GROUP__UPPER)
            return checkBounds(group.getLower(), Integer.parseInt(value));
        return null;
    }
    
    private String validateAttribute(Attribute attribute, Object property, String value) {
        if(property == ATTRIBUTE__ID) {
            String result = checkIdValue(value, "_UI_Attribute_id_feature");
            if(result != null)
                return result;
            for(Attribute otherAttribute: ((Feature) attribute.eContainer()).getAttributes()) {
                if((otherAttribute != attribute) && (otherAttribute.getId().equals(value)))
                    return getString("_UI_Errors_IdNotUnique", getString("_UI_Feature_type"));
            }
            return null;
        }
        if(property == ATTRIBUTE__NAME)
            return checkEmptyValue(value, "_UI_Attribute_name_feature");
        return null;
    }
    
    private String validateFeatureModel(FeatureModel featureModel, Object property, String value) {
        if(property == FEATURE_MODEL__NAME)
            return checkEmptyValue(value, "_UI_FeatureModel_name_feature");
        return null;
    }
    
    private String checkIdValue(String value, String name) {
        String result = checkEmptyValue(value, name);
        if(result != null)
            return result;
        if(!Pattern.matches("[a-zA-Z0-9_\\.]+", value))
            return getString("_UI_Errors_WrongIdFormat");
        return null;
    }
    
    private String checkEmptyValue(String value, String name) {
        if((value == null) || value.isEmpty())
            return getString("_UI_Errors_Empty", getString(name));
        return null;
    }
    
    private String checkBounds(int lower, int upper) {
        upper = (upper == -1) ? Integer.MAX_VALUE : upper;
        if(lower < 0)
            return getString("_UI_Errors_NegativeLowerBound");
        if(upper < 1)
            return getString("_UI_Errors_NegativeUpperBound");
        if(lower > upper)
            return getString("_UI_Errors_UpperLowerBoundMismatch");
        return null;
    }
    
    private String getString(String key, Object param) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, new Object[] { param }, true);
    }
    
    private String getString(String key) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, true);
    }
    
}
