package cz.jpikl.yafmt.clang;

import cz.jpikl.yafmt.model.fm.Constraint;

public interface IConstraintLanguage {
       
    IEvaluator createEvaluator(Constraint constraint) throws ConstraintLanguageException;
    
}
