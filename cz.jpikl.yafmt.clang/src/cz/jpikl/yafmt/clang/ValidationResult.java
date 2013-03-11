package cz.jpikl.yafmt.clang;

public class ValidationResult implements IValidationResult {

    public static final IValidationResult SUCCESS_RESULT = new ValidationResult();

    private String errorMessage;

    public ValidationResult() {
        this(null);
    }
    
    public ValidationResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isSuccess() {
        return errorMessage != null;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
