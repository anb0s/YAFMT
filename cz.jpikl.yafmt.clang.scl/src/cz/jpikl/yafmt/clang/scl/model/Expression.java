/**
 */
package cz.jpikl.yafmt.clang.scl.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.Expression#getContext <em>Context</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.Expression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
    /**
     * Returns the value of the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' attribute.
     * @see #setContext(String)
     * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getExpression_Context()
     * @model
     * @generated
     */
    String getContext();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.clang.scl.model.Expression#getContext <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' attribute.
     * @see #getContext()
     * @generated
     */
    void setContext(String value);

    /**
     * Returns the value of the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' containment reference.
     * @see #setExpression(Expression)
     * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getExpression_Expression()
     * @model containment="true"
     * @generated
     */
    Expression getExpression();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.clang.scl.model.Expression#getExpression <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' containment reference.
     * @see #getExpression()
     * @generated
     */
    void setExpression(Expression value);

} // Expression
