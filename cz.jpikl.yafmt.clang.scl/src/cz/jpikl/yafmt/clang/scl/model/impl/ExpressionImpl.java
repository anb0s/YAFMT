/**
 */
package cz.jpikl.yafmt.clang.scl.model.impl;

import java.util.Set;

import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.model.ModelPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EXPRESSION;
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        // This is never called.
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection context) {
        return false; // This is never called.
    }

} //ExpressionImpl
