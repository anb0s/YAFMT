package cz.jpikl.yafmt.clang;

public interface IConstraintLanguage {
       
    IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException;
    
}
