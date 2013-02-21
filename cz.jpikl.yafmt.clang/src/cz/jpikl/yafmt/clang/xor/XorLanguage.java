package cz.jpikl.yafmt.clang.xor;

import cz.jpikl.yafmt.clang.ConstraintLanguage;
import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.IEvaluator;

// Dummy constraint language just for testing purpose.
public class XorLanguage extends ConstraintLanguage {

    @Override
    public IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException {
        if((constraintValue == null) || constraintValue.trim().isEmpty())
            throw new ConstraintLanguageException("Empty constraint");
        return new XorEvaluator(constraintValue.split("\\s+"));
    }
    
}
