package cz.jpikl.yafmt.clang;

import cz.jpikl.yafmt.model.fm.Constraint;

public class ConstraintLanguageException extends Exception {

    private static final long serialVersionUID = 4843523043184156094L;
    
    private Constraint constraint;
    
    public ConstraintLanguageException(Constraint constraint, String message) {
        super(message);
        this.constraint = constraint;
    }
    
    public ConstraintLanguageException(String message) {
        this(null, message);
    }
    
    public Constraint getConstraint() {
        return constraint;
    }
    
}
