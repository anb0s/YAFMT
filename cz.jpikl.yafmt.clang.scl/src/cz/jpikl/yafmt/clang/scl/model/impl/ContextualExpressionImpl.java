/**
 */
package cz.jpikl.yafmt.clang.scl.model.impl;

import java.util.List;
import java.util.Set;

import cz.jpikl.yafmt.clang.scl.model.ContextualExpression;
import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.model.ModelPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextual Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl#getContextId <em>Context Id</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextualExpressionImpl extends ExpressionImpl implements ContextualExpression {
    /**
     * The default value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected String contextId = CONTEXT_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected Expression expression;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContextualExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.CONTEXTUAL_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContextId() {
        return contextId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextId(String newContextId) {
        String oldContextId = contextId;
        contextId = newContextId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXTUAL_EXPRESSION__CONTEXT_ID, oldContextId, contextId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
        Expression oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION, oldExpression, newExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(Expression newExpression) {
        if (newExpression != expression) {
            NotificationChain msgs = null;
            if (expression != null)
                msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION, null, msgs);
            msgs = basicSetExpression(newExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION, newExpression, newExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION:
                return basicSetExpression(null, msgs);
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
            case ModelPackage.CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                return getContextId();
            case ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION:
                return getExpression();
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
            case ModelPackage.CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                setContextId((String)newValue);
                return;
            case ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION:
                setExpression((Expression)newValue);
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
            case ModelPackage.CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                setContextId(CONTEXT_ID_EDEFAULT);
                return;
            case ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION:
                setExpression((Expression)null);
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
            case ModelPackage.CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                return CONTEXT_ID_EDEFAULT == null ? contextId != null : !CONTEXT_ID_EDEFAULT.equals(contextId);
            case ModelPackage.CONTEXTUAL_EXPRESSION__EXPRESSION:
                return expression != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (contextId: ");
        result.append(contextId);
        result.append(')');
        return result.toString();
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        expression.retrieveFeatureIds(ids);
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection parentContext) {
        // Get all context instances.
        List<Selection> contexts = featureConfig.getSelectionsById(contextId);
        
        // Expression must be true for each context instance. If there is no context,
        // the expression is automatically true.
        if((contexts == null) || !contexts.isEmpty())
            return true;
        
        // Evaluate expression for each context.
        for(Selection context: contexts) {
            // Evaluate expression only if we are under the parent context.
            if(parentContext != null) {
                boolean underParentContext = false;
                for(Selection ancestor = context; ancestor != null; ancestor = ancestor.getParent()) {
                    if(ancestor == parentContext) {
                        underParentContext = true;
                        break;
                    }
                }
                if(!underParentContext)
                    continue;
            }
            
            // Expression must be true for each context.
            if(!expression.evaluate(featureConfig, context))
                return false;
        }
        
        // Expression was true for each valid context.
        return true;
    }

} //ContextualExpressionImpl
