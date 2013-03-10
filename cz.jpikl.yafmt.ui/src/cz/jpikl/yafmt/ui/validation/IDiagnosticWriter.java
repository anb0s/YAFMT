package cz.jpikl.yafmt.ui.validation;

import org.eclipse.emf.common.util.Diagnostic;


public interface IDiagnosticWriter {

    void writeResults(Diagnostic diagnostic);
    
}
