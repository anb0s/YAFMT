package cz.jpikl.yafmt.model.fm.provider.util;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.provider.util.BaseInputValidator;

public class FeatureModelInputValidator extends BaseInputValidator {
    
    @Override
    public String validate(Object object, int propertyId, String value) {
        if(object instanceof Feature)
            return validate((Feature) object, propertyId, value);
        return null;
    }
    
    public String validate(Feature feature, int propertyId, String value) {
        switch(propertyId) {
            case FeatureModelPackage.FEATURE__ID: {
                String result = checkEmptyValue(value, "_UI_Feature_id_feature");
                if(result != null)
                    return result;
                Feature otherFeature = feature.getFeatureModel().getFeatureById(value);
                if((otherFeature != null) && (otherFeature != feature))
                    return getString("_UI_Errors_IdNotUnique", getString("_UI_FeatureModel_type"));
                break;
            }
                
            case FeatureModelPackage.FEATURE__NAME:
                return checkEmptyValue(value, "_UI_Feature_name_feature");
                
            case FeatureModelPackage.FEATURE__LOWER:
                try {
                    return checkBounds(Integer.parseInt(value), feature.getUpper());
                }
                catch(NumberFormatException ex) {
                    return getString("_UI_Errors_NotANumber");
                }
                
            case FeatureModelPackage.FEATURE__UPPER:
                try {
                    return checkBounds(feature.getLower(), Integer.parseInt(value));
                }
                catch(NumberFormatException ex) {
                    return getString("_UI_Errors_NotANumber");
                }
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
