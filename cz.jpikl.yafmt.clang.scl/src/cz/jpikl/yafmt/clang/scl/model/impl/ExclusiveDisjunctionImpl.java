/**
 */
package cz.jpikl.yafmt.clang.scl.model.impl;

import cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction;
import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.model.ModelPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclusive Disjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.impl.ExclusiveDisjunctionImpl#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExclusiveDisjunctionImpl extends ExpressionImpl implements ExclusiveDisjunction {
    /**
     * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParts()
     * @generated
     * @ordered
     */
    protected EList<Expression> parts;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExclusiveDisjunctionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EXCLUSIVE_DISJUNCTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Expression> getParts() {
        if (parts == null) {
            parts = new EObjectContainmentEList<Expression>(Expression.class, this, ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS);
        }
        return parts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS:
                return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS:
                return getParts();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS:
                getParts().clear();
                getParts().addAll((Collection<? extends Expression>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS:
                getParts().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelPackage.EXCLUSIVE_DISJUNCTION__PARTS:
                return parts != null && !parts.isEmpty();
        }
        return super.eIsSet(featureID);
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        // Parts should not be empty or null.
        for(Expression part: parts)
            part.retrieveFeatureIds(ids);
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection context) {
        // Parts should not be empty or null.
        // This is actually not the same as the XOR logic function, but it uses
        // semantic of XOR group. This means that expression A1 xor A2 xor ... xor An
        // if true only if exactly one of A1, A2, ..., An is true.
        int count = 0;
        for(Expression part: parts) {
            if(part.evaluate(featureConfig, context))
                count++;
            if(count > 1)
                return false;
        }
        return count == 1;
    }

} //ExclusiveDisjunctionImpl
