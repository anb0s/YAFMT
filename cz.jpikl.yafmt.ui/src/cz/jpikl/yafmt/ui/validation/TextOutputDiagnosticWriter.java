package cz.jpikl.yafmt.ui.validation;

import org.eclipse.emf.common.util.Diagnostic;


public class TextOutputDiagnosticWriter implements IDiagnosticWriter {

    @Override
    public void writeResults(Diagnostic diagnostic) {
        System.out.println("------------------------------------------");
        System.out.println(" Validation Results");
        System.out.println("------------------------------------------");
        writeResult(diagnostic, 0);
        System.out.println();
    }
    
    private void writeResult(Diagnostic diagnostic, int indent) {
        writeIndented("[" + getCodeName(diagnostic.getCode()) + "] " + diagnostic.getMessage(), indent);
        for(Diagnostic childDiagnostic: diagnostic.getChildren())
            writeResult(childDiagnostic, indent + 1);
    }
    
    private void writeIndented(String text, int indent) {
        for(int i = 0; i < indent; i++)
            System.out.print("    ");
        System.out.println(text);
    }

    private String getCodeName(int code) {
        switch(code) {
            case Diagnostic.CANCEL:
                return "CANCEL";
                
            case Diagnostic.ERROR:
                return "ERROR";
                
            case Diagnostic.INFO:
                return "INFO ";
                
            case Diagnostic.OK:
                return "OK   ";
                
            default:
                return "?????";
        }
    }

    @Override
    public void clearResults(Object target) {
    }

    @Override
    public void clearAllResults() {
    }
    
}
