package cz.jpikl.yafmt.clang.dummy;

import cz.jpikl.yafmt.clang.ConstraintLanguage;
import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fm.Constraint;

// Dummy constraint language just for testing purpose.
public class DummyLanguage extends ConstraintLanguage {

    @Override
    public IEvaluator createEvaluator(Constraint constraint) throws ConstraintLanguageException {
        if(constraint == null)
            throw new ConstraintLanguageException("Cannot create IEvaluator for null constraint");
        
        String value = constraint.getValue();
        if((value == null) || value.trim().isEmpty())
            throw new ConstraintLanguageException(constraint, "Empty constraint");
        
        return new DummyEvaluator(constraint.getValue().split("\\s+"));
    }
    
}
