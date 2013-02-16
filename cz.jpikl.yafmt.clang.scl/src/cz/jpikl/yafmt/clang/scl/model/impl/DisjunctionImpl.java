/**
 */
package cz.jpikl.yafmt.clang.scl.model.impl;

import cz.jpikl.yafmt.clang.scl.model.Disjunction;
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
 * An implementation of the model object '<em><b>Disjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.impl.DisjunctionImpl#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisjunctionImpl extends ExpressionImpl implements Disjunction {
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
    protected DisjunctionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.DISJUNCTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Expression> getParts() {
        if (parts == null) {
            parts = new EObjectContainmentEList<Expression>(Expression.class, this, ModelPackage.DISJUNCTION__PARTS);
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
            case ModelPackage.DISJUNCTION__PARTS:
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
            case ModelPackage.DISJUNCTION__PARTS:
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
            case ModelPackage.DISJUNCTION__PARTS:
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
            case ModelPackage.DISJUNCTION__PARTS:
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
            case ModelPackage.DISJUNCTION__PARTS:
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
        for(Expression part: parts) {
            if(part.evaluate(featureConfig, context))
                return true;
        }
        return false;
    }

} //DisjunctionImpl
