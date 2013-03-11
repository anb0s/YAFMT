package cz.jpikl.yafmt.model.validation;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;

import static cz.jpikl.yafmt.model.validation.Localization.*;

public abstract class BasicValidator implements EValidator, IStructuralFeatureValidator {

    private static final String DIAGNOSTIC_SOURCE = "cz.jpikl.yafmt.model.validation";
    
    public abstract boolean validate(EObject object, DiagnosticChain diagnostics);
    
    public boolean validateAllContents(EObject object, DiagnosticChain diagnostics) {
        TreeIterator<EObject> it = object.eAllContents();
        boolean result = true;
        while(it.hasNext())
            result &= validate(it.next(), diagnostics, null);
        return result;
    }
        
    public boolean validateAllStructuralFeatures(EObject object, DiagnosticChain diagnostics) {
        EList<EStructuralFeature> structuralFeautures = object.eClass().getEAllStructuralFeatures(); 
        return validateStructuralFeatures(object, structuralFeautures.toArray(new EStructuralFeature[structuralFeautures.size()]), diagnostics);
    }
    
    public boolean validateStructuralFeatures(EObject object, EStructuralFeature[] structuralFeatures, DiagnosticChain diagnostics) {
        boolean result = true;
        for(EStructuralFeature structuralFeature: structuralFeatures)
            result &= validateStructuralFeature(object, structuralFeature, diagnostics);
        return result;
    }
    
    public boolean validateStructuralFeature(EObject object, EStructuralFeature structuralFeature, DiagnosticChain diagnostics) {
        String message = getStructuralFeatureError(object, structuralFeature, object.eGet(structuralFeature));
        if(message != null) {
            addError(diagnostics, message, object);
            return false;
        }
        return true;
    }
    
    @Override
    public String getStructuralFeatureError(EObject object, EStructuralFeature structuralFeature, Object value) {
        try {
            checkStructuralFeature(object, structuralFeature, value);
            return null;
        }
        catch(NumberFormatException ex) {
            return getMessage("Errors_NotANumber");
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
    }
    
    protected abstract void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception ;

    public void addError(DiagnosticChain diagnostics, String message, Object object) {
        addDiagnostics(diagnostics, Diagnostic.ERROR, message, new Object[] { object });
    }
    
    public void addError(DiagnosticChain diagnostics, String message, Object[] objects) {
        addDiagnostics(diagnostics, Diagnostic.ERROR, message, objects);
    }
        
    public void addDiagnostics(DiagnosticChain diagnostics, int code, String message, Object[] objects) {
        diagnostics.add(new BasicDiagnostic(DIAGNOSTIC_SOURCE, code, message, objects));
    }
    
    // =============================================================================
    //  EValidator interface methods
    // =============================================================================
    
    @Override
    public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate(eObject, diagnostics);
    }

    @Override
    public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate(eObject, diagnostics);
    }

    @Override
    public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }
        
}
