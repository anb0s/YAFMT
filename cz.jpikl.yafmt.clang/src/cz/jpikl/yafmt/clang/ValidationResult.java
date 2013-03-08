package cz.jpikl.yafmt.clang;

public class ValidationResult implements IValidationResult {

    public static final IValidationResult SUCCESS_RESULT = new ValidationResult(true, null);

    public static IValidationResult createFailureResult(String errorMessage) {
        return new ValidationResult(false, errorMessage);
    }

    private boolean success;
    private String errorMessage;

    private ValidationResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
