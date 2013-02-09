package cz.jpikl.yafmt.clang;

public class EvaluationResult implements IEvaluationResult {

    public static final IEvaluationResult SUCCESS_RESULT = new EvaluationResult(true);
    public static final IEvaluationResult FAIL_RESULT = new EvaluationResult(false);
    
    private boolean success;

    public EvaluationResult(boolean success) {
        this.success = success;
    }
    
    @Override
    public boolean isSuccess() {
        return success;
    }
    
}
