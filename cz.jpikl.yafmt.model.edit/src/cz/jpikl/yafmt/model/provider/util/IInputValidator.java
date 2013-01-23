package cz.jpikl.yafmt.model.provider.util;

public interface IInputValidator {

    String validate(Object object, int propertyId, String value);
    
}
