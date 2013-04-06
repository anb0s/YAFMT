package cz.jpikl.yafmt.clang.base;

import cz.jpikl.yafmt.clang.ConstraintLanguage;
import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.IEvaluator;

// Dummy constraint language just for testing purpose.
public class BaseLanguage extends ConstraintLanguage {

    @Override
    public IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException {
        if(constraintValue == null)
            throw new ConstraintLanguageException("Missing first operand.");
        
        String[] parts = constraintValue.split("\\s+");
        if((parts == null) || parts.length < 1 || (parts[0] == null) || parts[0].trim().isEmpty())
            throw new ConstraintLanguageException("Missing first operand.");
        if(parts.length == 1)
            throw new ConstraintLanguageException("Missing operator");
        
        Operator operator;
        if("requires".equals(parts[1]))
            operator = Operator.REQUIRES;
        else if("mutex-with".equals(parts[1]))
            operator = Operator.MUTEX_WITH;
        else
            throw new ConstraintLanguageException("Operator must be 'requires' or 'mutex-with'.");
        
        if(parts.length == 2)
            throw new ConstraintLanguageException("Missing second operand.");
        if(parts.length > 3)
            throw new ConstraintLanguageException("Unnecessary input at the end.");
        
        return new BaseEvaluator(parts[0], parts[2], operator);
    }

}
