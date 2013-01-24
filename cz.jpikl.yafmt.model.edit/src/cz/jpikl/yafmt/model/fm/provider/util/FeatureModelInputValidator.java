package cz.jpikl.yafmt.model.fm.provider.util;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.provider.util.BaseInputValidator;

public class FeatureModelInputValidator extends BaseInputValidator {
    
    @Override
    public String validate(Object object, String property, String value) {
        if(object instanceof Feature)
            return validate((Feature) object, property, value);
        return null;
    }
    
    private String validate(Feature feature, String property, String value) {
        if("id".equals(property)) {
            String result = checkEmptyValue(value, "_UI_Feature_id_feature");
            if(result != null)
                return result;
            Feature otherFeature = feature.getFeatureModel().getFeatureById(value);
            if((otherFeature != null) && (otherFeature != feature))
                return getString("_UI_Errors_IdNotUnique", getString("_UI_FeatureModel_type"));
        }
        else if("name".equals(property)) {
            return checkEmptyValue(value, "_UI_Feature_name_feature");
        }
        else if("upper".equals(property)) {
            try {
                return checkBounds(Integer.parseInt(value), feature.getUpper());
            }
            catch(NumberFormatException ex) {
                return getString("_UI_Errors_NotANumber");
            }
        }
        else if("lower".equals(property)) {
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
            return validate(feature.getAttributes().get(index), property.substring(pos + 2), value);
        }
        return null;
    }
    
    private String validate(Attribute attribute, String property, String value) {
        if("id".equals(property)) {
            String result = checkEmptyValue(value, "_UI_Attribute_id_feature");
            if(result != null)
                return result;
            for(Attribute otherAttribute: ((Feature) attribute.eContainer()).getAttributes()) {
                System.out.println(otherAttribute.getId() + "/" + value);
                if((otherAttribute != attribute) && (otherAttribute.getId().equals(value)))
                    return getString("_UI_Errors_IdNotUnique", getString("_UI_Feature_type"));
            }
        }
        else if("name".equals(property)) {
            return checkEmptyValue(value, "_UI_Attribute_name_feature");
        }
        return null;
    }
    
    private String checkEmptyValue(String value, String name) {
        if((value == null) || value.isEmpty())
            return getString("_UI_Errors_Empty", getString(name));
        return null;
    }
    
    private String checkBounds(int lower, int upper) {
        if(lower < 0)
            return getString("_UI_Errors_NegativeLowerBound");
        if(upper < -1)
            return getString("_UI_Errors_NegativeUpperBound");
        if((upper < lower) && (upper != -1))
            return getString("_UI_Errors_UpperLowerBoundMismatch");
        return null;
    }
}
