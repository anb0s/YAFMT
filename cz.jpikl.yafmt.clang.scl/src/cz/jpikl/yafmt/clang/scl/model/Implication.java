/**
 */
package cz.jpikl.yafmt.clang.scl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.Implication#getLeftPart <em>Left Part</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.Implication#getRightPart <em>Right Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getImplication()
 * @model
 * @generated
 */
public interface Implication extends Expression {
    /**
     * Returns the value of the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left Part</em>' containment reference.
     * @see #setLeftPart(Expression)
     * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getImplication_LeftPart()
     * @model containment="true"
     * @generated
     */
    Expression getLeftPart();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.clang.scl.model.Implication#getLeftPart <em>Left Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Part</em>' containment reference.
     * @see #getLeftPart()
     * @generated
     */
    void setLeftPart(Expression value);

    /**
     * Returns the value of the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right Part</em>' containment reference.
     * @see #setRightPart(Expression)
     * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getImplication_RightPart()
     * @model containment="true"
     * @generated
     */
    Expression getRightPart();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.clang.scl.model.Implication#getRightPart <em>Right Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Part</em>' containment reference.
     * @see #getRightPart()
     * @generated
     */
    void setRightPart(Expression value);

} // Implication
