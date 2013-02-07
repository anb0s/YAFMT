package cz.jpikl.yafmt.clang.scl;

import cz.jpikl.yafmt.clang.ConstraintLanguage;
import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.model.fm.Constraint;

public class SimpleConstraintLanguage extends ConstraintLanguage {

    @Override
    public IEvaluator createEvaluator(Constraint constraint) throws ConstraintLanguageException {
        return new SCLEvaluator();
    }

}
