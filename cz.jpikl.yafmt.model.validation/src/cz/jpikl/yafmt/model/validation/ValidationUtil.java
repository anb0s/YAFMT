package cz.jpikl.yafmt.model.validation;

import static cz.jpikl.yafmt.model.validation.Localization.getMessage;

import java.util.Collection;
import java.util.regex.Pattern;

public class ValidationUtil {
    
    public static void checkEmptyValue(String name, String value) throws Exception {
        if((value == null) || value.isEmpty())
            throw new Exception(getMessage("Errors_EmptyValue", name));
    }
    
    public static String checkIdValue(String name, String value) throws Exception {
        checkEmptyValue(name, value);
        if(!Pattern.matches("[a-zA-Z0-9_\\.]+", value))
            throw new Exception(getMessage("Errors_WrongIdFormat"));
        return null;
    }
    
    public static String checkBounds(int lower, int upper) throws Exception {
        upper = (upper == -1) ? Integer.MAX_VALUE : upper;
        if(lower < 0)
            throw new Exception(getMessage("Errors_NegativeLowerBound"));
        if(upper < 1)
            throw new Exception(getMessage("Errors_NegativeUpperBound"));
        if(lower > upper)
            throw new Exception(getMessage("Errors_UpperLowerBoundMismatch"));
        return null;
    }
    
    public static String printIds(Collection<String> ids) {
        if(ids.isEmpty())
            return null;

        StringBuilder builder = null;
        for(String id: ids) {
            if(builder == null)
                builder = new StringBuilder(id);
            else
                builder.append(", ").append(id);
        }
        
        return builder.toString();
    }
    
}
