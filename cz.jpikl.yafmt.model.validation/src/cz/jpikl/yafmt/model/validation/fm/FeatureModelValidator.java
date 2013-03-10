package cz.jpikl.yafmt.model.validation.fm;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.clang.IValidationResult;
import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.validation.BasicValidator;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.*;
import static cz.jpikl.yafmt.model.validation.Localization.*;
import static cz.jpikl.yafmt.model.validation.ValidationUtil.*;

public class FeatureModelValidator extends BasicValidator {

    public static final FeatureModelValidator INSTANCE = new FeatureModelValidator();
    
    private EStructuralFeature[] FEATURE_MODEL_STRUCTURAL_FEATURES = { Literals.FEATURE_MODEL__NAME };
    private EStructuralFeature[] FEATURE_STRUCTURAL_FEATURES = { Literals.FEATURE__ID, Literals.FEATURE__NAME, Literals.FEATURE__LOWER, Literals.FEATURE__UPPER };
    private EStructuralFeature[] GROUP_STRUCTURAL_FEATURES = { Literals.GROUP__LOWER, Literals.GROUP__UPPER };
    private EStructuralFeature[] ATTRIBUTE_STRUCTURAL_FEATURES = { Literals.ATTRIBUTE__ID, Literals.ATTRIBUTE__NAME };
    private EStructuralFeature[] CONSTRAINT_STRUCTURAL_FEATURES = { Literals.CONSTRAINT__LANGUAGE, Literals.CONSTRAINT__VALUE };
    
    // ===========================================================================
    //  Object validation
    // ===========================================================================
    
    @Override
    public boolean validate(EObject object, DiagnosticChain diagnostics) {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_MODEL:
                return validateFeatureModel((FeatureModel) object, diagnostics);
            
            case FEATURE:
                return validateFeature((Feature) object, diagnostics);
                
            case GROUP:
                return validateGroup((Group) object, diagnostics);
                
            case ATTRIBUTE:
                return validateAttribute((Attribute) object, diagnostics);
                
            case CONSTRAINT:
                return validateConstraint((Constraint) object, diagnostics);
        }
        return true;
    }
    
    private boolean validateFeatureModel(FeatureModel featureModel, DiagnosticChain diagnostics) {
        boolean result =  validateStructuralFeatures(featureModel, FEATURE_MODEL_STRUCTURAL_FEATURES, diagnostics);
        result &= validateAllContents(featureModel, diagnostics);
        return result;
    }
    
    private boolean validateFeature(Feature feature, DiagnosticChain diagnostics) {
        return validateStructuralFeatures(feature, FEATURE_STRUCTURAL_FEATURES, diagnostics);
    }
    
    private boolean validateGroup(Group group, DiagnosticChain diagnostics) {
        boolean result = validateStructuralFeatures(group, GROUP_STRUCTURAL_FEATURES, diagnostics);
        result &= validateGroupUpperMinimum(group, diagnostics, result);
        result &= validateGroupLowerMaximum(group, diagnostics, result);
        return result;
    }

    private boolean validateGroupUpperMinimum(Group group, DiagnosticChain diagnostics, boolean result) {
        int groupUpper = group.getUpper();
        if(groupUpper == -1)
            return true;
        
        int featuresLowerSum = 0;
        for(Feature feature: group.getFeatures())
            featuresLowerSum += feature.getLower();
        
        if(featuresLowerSum > groupUpper) {
            addError(diagnostics, getMessage("Errors_GroupUpperMinimum"), group);
            return false;
        }
        
        return true;
    }
    
    private boolean validateGroupLowerMaximum(Group group, DiagnosticChain diagnostics, boolean result) {
        int groupLower = group.getLower();
        
        int featuresUpperSum = 0;
        for(Feature feature: group.getFeatures()) {
            int featureUpper = feature.getUpper();
            if(featureUpper == -1)
                return true;
            featuresUpperSum += featureUpper;
        }
        
        if(featuresUpperSum < groupLower) {
            addError(diagnostics, getMessage("Errors_GroupLowerMaximum"), group);
            return false;
        }
        
        return true;
    }
    
    private boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics) {
        return validateStructuralFeatures(attribute, ATTRIBUTE_STRUCTURAL_FEATURES, diagnostics);
    }
    
    private boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics) {
        return validateStructuralFeatures(constraint, CONSTRAINT_STRUCTURAL_FEATURES, diagnostics);
    }

    // ===========================================================================
    //  Structural feature validation
    // ===========================================================================

    @Override
    protected void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception  {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_MODEL:
                checkFeatureModelStructuralFeature((FeatureModel) object, structuralFeature, value);
                break;
            
            case FEATURE:
                checkFeatureStructuralFeature((Feature) object, structuralFeature, value);
                break;
                
            case GROUP:
                checkGroupStructuralFeature((Group) object, structuralFeature, value);
                break;
                
            case ATTRIBUTE:
                checkAttributeStructuralFeature((Attribute) object, structuralFeature, value);
                break;
                
            case CONSTRAINT:
                checkConstraintStructuralFeature((Constraint) object, structuralFeature, value);
                break;
        }
    }

    private void checkFeatureModelStructuralFeature(FeatureModel featureModel, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE_MODEL__NAME:
                checkEmptyValue(getMessage("FeatureModel_Name"), (String) value);
                break;
        }
    }
    
    private void checkFeatureStructuralFeature(Feature feature, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE__ID: {
                String id = (String) value;
                checkIdValue(getMessage("Feature_Id"), id);
                
                FeatureModel featureModel = feature.getFeatureModel();
                if((featureModel != null) && (featureModel.getFeatureById(id) != feature))
                    throw new Exception(getMessage("Errors_IdNotUnique", getMessage("FeatureModel")));
                break;
            }
                
            case FEATURE__NAME:
                checkEmptyValue(getMessage("Feature_Name"), (String) value);
                break;
                
            case FEATURE__LOWER:
                int lower = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(lower, feature.getUpper());
                break;
                
            case FEATURE__UPPER:
                int upper = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(feature.getLower(), upper);
                break;
        }
    }
    
    private void checkGroupStructuralFeature(Group group, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case GROUP__LOWER:
                int lower = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(lower, group.getUpper());
                break;
                
            case GROUP__UPPER:
                int upper = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(group.getLower(), upper);
                break;
        }
    }
    
    private void checkAttributeStructuralFeature(Attribute attribute, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case ATTRIBUTE__ID: {
                String id = (String) value;
                checkIdValue(getMessage("Attribute_Id"), id);
                
                Feature feature = attribute.getFeature();
                if(feature == null)
                    break;
                
                for(Attribute otherAttribute: feature.getAttributes()) {
                    if((otherAttribute != attribute) && (id.equals(otherAttribute.getId())))
                        throw new Exception(getMessage("Errors_IdNotUnique", getMessage("Feature")));
                }
                break;
            }
            
            case ATTRIBUTE__NAME:
                checkEmptyValue(getMessage("Attribute_Name"), (String) value);
                break;
        }
    }
    
    private void checkConstraintStructuralFeature(Constraint constraint, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case CONSTRAINT__LANGUAGE: {
                ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
                if(registry.getLanguage(constraint.getLanguage()) == null)
                    throw new Exception(getMessage("Errors_UnknownConstraintLangauge"));
                break;
            }
                
            case CONSTRAINT__VALUE: {
                ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
                IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
                if(langauge == null)
                    break;
                
                IEvaluator evaluator = langauge.createEvaluator((String) value);
                IValidationResult result = evaluator.validate(constraint.getFeatureModel());
                if(!result.isSuccess())
                    throw new Exception(result.getErrorMessage());
                break;
            }
        }
    }
    
}
