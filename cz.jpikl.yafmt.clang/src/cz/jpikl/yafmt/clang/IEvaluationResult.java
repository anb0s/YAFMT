package cz.jpikl.yafmt.clang;

import java.util.List;

import cz.jpikl.yafmt.model.fc.Selection;

public interface IEvaluationResult {

    boolean isSuccess();

    String getErrorMessage();
    
    List<Selection> getProblemSelections();

}
