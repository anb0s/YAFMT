package cz.jpikl.yafmt.clang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cz.jpikl.yafmt.model.fc.Selection;

public abstract class EvaluationResult implements IEvaluationResult {

    public static final IEvaluationResult SUCCESS_RESULT = new IEvaluationResult() {
        
        @Override
        public boolean isSuccess() {
            return true;
        }
        
        @Override
        public List<Selection> getSelections() {
            return Collections.emptyList();
        }
        
        @Override
        public String getMessage() {
            return null;
        }
        
    };
    
    private boolean success;
    private String message;
    private List<Selection> selections;
        
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
        
    @Override
    public boolean isSuccess() {
        return success;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    @Override
    public List<Selection> getSelections() {
        if(selections == null)
            selections = new ArrayList<Selection>();
        return selections;
    }
    
}
