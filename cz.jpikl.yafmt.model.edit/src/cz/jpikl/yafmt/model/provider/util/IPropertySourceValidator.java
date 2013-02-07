package cz.jpikl.yafmt.model.provider.util;

public interface IPropertySourceValidator {

    String validate(Object object, String property, String value);
    
}
