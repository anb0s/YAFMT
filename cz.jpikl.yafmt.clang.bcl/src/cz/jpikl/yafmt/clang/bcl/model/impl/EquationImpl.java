/**
 */
package cz.jpikl.yafmt.clang.bcl.model.impl;

import java.util.HashSet;
import java.util.Set;

import cz.jpikl.yafmt.clang.bcl.model.Equation;
import cz.jpikl.yafmt.clang.bcl.model.Expression;
import cz.jpikl.yafmt.clang.bcl.model.ModelPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.bcl.model.impl.EquationImpl#getLeftPart <em>Left Part</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.clang.bcl.model.impl.EquationImpl#getRightPart <em>Right Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationImpl extends ExpressionImpl implements Equation {
    /**
     * The cached value of the '{@link #getLeftPart() <em>Left Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeftPart()
     * @generated
     * @ordered
     */
    protected Expression leftPart;

    /**
     * The cached value of the '{@link #getRightPart() <em>Right Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRightPart()
     * @generated
     * @ordered
     */
    protected Expression rightPart;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EquationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EQUATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression getLeftPart() {
        return leftPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLeftPart(Expression newLeftPart, NotificationChain msgs) {
        Expression oldLeftPart = leftPart;
        leftPart = newLeftPart;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EQUATION__LEFT_PART, oldLeftPart, newLeftPart);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLeftPart(Expression newLeftPart) {
        if (newLeftPart != leftPart) {
            NotificationChain msgs = null;
            if (leftPart != null)
                msgs = ((InternalEObject)leftPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EQUATION__LEFT_PART, null, msgs);
            if (newLeftPart != null)
                msgs = ((InternalEObject)newLeftPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EQUATION__LEFT_PART, null, msgs);
            msgs = basicSetLeftPart(newLeftPart, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EQUATION__LEFT_PART, newLeftPart, newLeftPart));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression getRightPart() {
        return rightPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRightPart(Expression newRightPart, NotificationChain msgs) {
        Expression oldRightPart = rightPart;
        rightPart = newRightPart;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EQUATION__RIGHT_PART, oldRightPart, newRightPart);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRightPart(Expression newRightPart) {
        if (newRightPart != rightPart) {
            NotificationChain msgs = null;
            if (rightPart != null)
                msgs = ((InternalEObject)rightPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EQUATION__RIGHT_PART, null, msgs);
            if (newRightPart != null)
                msgs = ((InternalEObject)newRightPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EQUATION__RIGHT_PART, null, msgs);
            msgs = basicSetRightPart(newRightPart, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EQUATION__RIGHT_PART, newRightPart, newRightPart));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ModelPackage.EQUATION__LEFT_PART:
                return basicSetLeftPart(null, msgs);
            case ModelPackage.EQUATION__RIGHT_PART:
                return basicSetRightPart(null, msgs);
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
            case ModelPackage.EQUATION__LEFT_PART:
                return getLeftPart();
            case ModelPackage.EQUATION__RIGHT_PART:
                return getRightPart();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelPackage.EQUATION__LEFT_PART:
                setLeftPart((Expression)newValue);
                return;
            case ModelPackage.EQUATION__RIGHT_PART:
                setRightPart((Expression)newValue);
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
            case ModelPackage.EQUATION__LEFT_PART:
                setLeftPart((Expression)null);
                return;
            case ModelPackage.EQUATION__RIGHT_PART:
                setRightPart((Expression)null);
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
            case ModelPackage.EQUATION__LEFT_PART:
                return leftPart != null;
            case ModelPackage.EQUATION__RIGHT_PART:
                return rightPart != null;
        }
        return super.eIsSet(featureID);
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        leftPart.retrieveFeatureIds(ids);
        rightPart.retrieveFeatureIds(ids);
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection context, Set<Selection> problemSelections, boolean expectedValue) {
        Set<Selection> internalProblemSelections = new HashSet<Selection>();

        // We have to evaluate both parts to gather all problem elements.
        boolean leftValue = leftPart.evaluate(featureConfig, context, internalProblemSelections, true);
        boolean rightValue = rightPart.evaluate(featureConfig, context, internalProblemSelections, true);
        boolean value = leftValue == rightValue;

        if(value != expectedValue) {
            problemSelections.addAll(internalProblemSelections);
            // Gather problem elements again if we guessed the right value.
            if(leftValue)
                leftPart.evaluate(featureConfig, context, problemSelections, false);
            if(rightValue)
                rightPart.evaluate(featureConfig, context, problemSelections, false);
        }

        return value;
    }

} //EquationImpl
