package cz.jpikl.yafmt.model.fm.provider.util;

import java.util.regex.Pattern;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.provider.util.ProperySourceValidator;

public class FeatureModelPropertySourceValidator extends ProperySourceValidator {
    
    @Override
    public String validate(Object object, String property, String value) {
        if(object instanceof Feature)
            return validateFeature((Feature) object, property, value);
        if(object instanceof Group)
            return validateGroup((Group) object, property, value);
        if(object instanceof Attribute)
            return validateAttribute((Attribute) object, property, value);
        if(object instanceof FeatureModel)
            return validateFeatureModel((FeatureModel) object, property, value);
        return null;
    }
    
    private String validateFeature(Feature feature, String property, String value) {
        if("id".equals(property)) {
            String result = checkIdValue(value, "_UI_Feature_id_feature");
            if(result != null)
                return result;
            Feature otherFeature = feature.getFeatureModel().getFeatureById(value);
            if((otherFeature != null) && (otherFeature != feature))
                return getString("_UI_Errors_IdNotUnique", getString("_UI_FeatureModel_type"));
        }
        else if("name".equals(property)) {
            return checkEmptyValue(value, "_UI_Feature_name_feature");
        }
        else if("lower".equals(property)) {
            try {
                return checkBounds(Integer.parseInt(value), feature.getUpper());
            }
            catch(NumberFormatException ex) {
                return getString("_UI_Errors_NotANumber");
            }
        }
        else if("upper".equals(property)) {
            try {
                return checkBounds(feature.getLower(), Integer.parseInt(value));
            }
            catch(NumberFormatException ex) {
                return getString("_UI_Errors_NotANumber");
            }
        }
        else if (property.startsWith("attribute[")) {
            property = property.substring(10);
            int pos = property.indexOf("].");
            int index = Integer.parseInt(property.substring(0, pos));
            return validateAttribute(feature.getAttributes().get(index), property.substring(pos + 2), value);
        }
        return null;
    }
    
    private String validateGroup(Group group, String property, String value) {
        if("lower".equals(property)) {
            try {
                return checkBounds(Integer.parseInt(value), group.getUpper());
            }
            catch(NumberFormatException ex) {
                return getString("_UI_Errors_NotANumber");
            }
        }
        else if("upper".equals(property)) {
            try {
                return checkBounds(group.getLower(), Integer.parseInt(value));
            }
            catch(NumberFormatException ex) {
                return getString("_UI_Errors_NotANumber");
            }
        }
        return null;
    }
    
    private String validateAttribute(Attribute attribute, String property, String value) {
        if("id".equals(property)) {
            String result = checkIdValue(value, "_UI_Attribute_id_feature");
            if(result != null)
                return result;
            for(Attribute otherAttribute: ((Feature) attribute.eContainer()).getAttributes()) {
                if((otherAttribute != attribute) && (otherAttribute.getId().equals(value)))
                    return getString("_UI_Errors_IdNotUnique", getString("_UI_Feature_type"));
            }
        }
        else if("name".equals(property)) {
            return checkEmptyValue(value, "_UI_Attribute_name_feature");
        }
        return null;
    }
    
    private String validateFeatureModel(FeatureModel featureModel, String property, String value) {
        if("name".equals(property))
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
}
