package cz.jpikl.yafmt.model.validation;

public interface IPropertySourceValidator {

    String validate(Object object, Object feature, Object value);

}
