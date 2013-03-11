package cz.jpikl.yafmt.ui.validation;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;


public interface IProblemStore {
    
    void readProblems(Diagnostic diagnostic);
    
    List<String> getProblems(Object target);
    
    void clearProblems(Object target);
    
    void clearAllProblems();
    
}
