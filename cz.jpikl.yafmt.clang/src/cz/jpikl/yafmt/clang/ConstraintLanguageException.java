package cz.jpikl.yafmt.clang;

public class ConstraintLanguageException extends Exception {

    private static final long serialVersionUID = 4843523043184156094L;
    
    public ConstraintLanguageException(String message) {
        super(message);
    }
    
    public ConstraintLanguageException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
