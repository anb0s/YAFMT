package cz.zcu.yafmt.model.validation;

import static cz.zcu.yafmt.model.validation.Localization.getMessage;

import java.util.regex.Pattern;

import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;

public class ValidationUtil {

    public static void checkEmptyValue(String name, String value) throws Exception {
        if((value == null) || value.isEmpty())
            throw new Exception(getMessage("Errors_EmptyValue", name));
    }

    public static void checkIdValue(String name, String prefix, String value) throws Exception {
        checkEmptyValue(name, value);
        if(!Pattern.matches(prefix + ".*", value))
            throw new Exception(getMessage("Errors_WrongIdFormat", prefix));
        //if(!Pattern.matches("[a-zA-Z_][0-9a-zA-Z_]*", value))
        //    throw new Exception(getMessage("Errors_WrongIdFormat"));
    }

    public static void checkAttributeIdValue(String name, String value) throws Exception {
        checkEmptyValue(name, value);
        checkIdValue(name, FeatureModelUtil.getAttributeIdPrefix(), value);
    }

    public static void checkFeatureIdValue(String name, String value) throws Exception {
        checkEmptyValue(name, value);
        checkIdValue(name, FeatureModelUtil.getFeatureIdPrefix(), value);
    }

    public static void checkBounds(int lower, int upper) throws Exception {
        upper = (upper == -1) ? Integer.MAX_VALUE : upper;
        if(lower < 0)
            throw new Exception(getMessage("Errors_NegativeLowerBound"));
        if(upper < 1)
            throw new Exception(getMessage("Errors_NegativeUpperBound"));
        if(lower > upper)
            throw new Exception(getMessage("Errors_UpperLowerBoundMismatch"));
    }

    public static void checkBooleanValue(Object value) throws Exception {
        if(value instanceof String) {
            String boolValStr = (String) value;
            if (!(boolValStr.toLowerCase().equals("true") || boolValStr.toLowerCase().equals("false"))) {
                throw new Exception(getMessage("Errors_NotABoolean", value));
            }//Boolean.parseBoolean(boolValStr);
        }
    }

    public static void checkIntegerValue(Object value) throws Exception {
        try {
            if(value instanceof String)
                Integer.parseInt((String) value);
        }
        catch(NumberFormatException ex) {
            throw new Exception(getMessage("Errors_NotANInteger", value));
        }
    }

    public static void checkDoubleValue(Object value) throws Exception {
        try {
            if(value instanceof String)
                Double.parseDouble((String) value);
        }
        catch(NumberFormatException ex) {
            throw new Exception(getMessage("Errors_NotADouble", value));
        }
    }

}
