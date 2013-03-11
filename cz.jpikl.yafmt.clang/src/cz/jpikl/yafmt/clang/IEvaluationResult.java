package cz.jpikl.yafmt.clang;

import java.util.List;

public interface IEvaluationResult {

    boolean isSuccess();

    String getErrorMessage();
    
    List<Object> getProblemElements();

}
