package cz.jpikl.yafmt.model.provider.util;

public interface IInputValidator {

    String validate(Object object, String property, String value);
    
}
