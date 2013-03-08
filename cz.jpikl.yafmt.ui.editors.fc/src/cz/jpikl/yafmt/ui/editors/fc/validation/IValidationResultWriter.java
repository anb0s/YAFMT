package cz.jpikl.yafmt.ui.editors.fc.validation;

public interface IValidationResultWriter {

    void addWarning(Object element, String message);

    void addError(Object element, String message);

}
