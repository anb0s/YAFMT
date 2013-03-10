package cz.jpikl.yafmt.clang;

import java.util.Collections;
import java.util.List;

import cz.jpikl.yafmt.model.fc.Selection;

public class EvaluationResult implements IEvaluationResult {

    public static final IEvaluationResult SUCCESS_RESULT = new EvaluationResult(true, null);

    public static IEvaluationResult createFailureResult(String errorMessage) {
        return new EvaluationResult(false, errorMessage);
    }

    private boolean success;
    private String errorMessage;

    private EvaluationResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    public List<Selection> getProblemSelections() {
        return Collections.emptyList();
    }

}
