package cz.jpikl.yafmt.model.provider.util;

public interface PropertySourceValidator {

    String validate(Object object, String property, String value);
    
}
