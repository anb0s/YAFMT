package cz.jpikl.yafmt.clang;

public interface IValidationResult {

    boolean isSuccess();
    
    String getErrorMessage();
    
}
