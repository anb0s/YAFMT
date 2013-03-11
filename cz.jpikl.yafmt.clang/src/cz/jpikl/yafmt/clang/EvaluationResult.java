package cz.jpikl.yafmt.clang;

import java.util.ArrayList;
import java.util.List;

public class EvaluationResult implements IEvaluationResult {

    public static final IEvaluationResult SUCCESS_RESULT = new EvaluationResult();

    private String errorMessage;
    private List<Object> problemElements = new ArrayList<Object>();

    
    public EvaluationResult() {
        this(null);
    }
    
    public EvaluationResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isSuccess() {
        return (errorMessage == null) && problemElements.isEmpty();
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
    
    @Override
    public List<Object> getProblemElements() {
        return problemElements;
    }

}
