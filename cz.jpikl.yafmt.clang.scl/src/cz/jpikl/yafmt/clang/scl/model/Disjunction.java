/**
 */
package cz.jpikl.yafmt.clang.scl.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.clang.scl.model.Disjunction#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getDisjunction()
 * @model
 * @generated
 */
public interface Disjunction extends Expression {
    /**
     * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.clang.scl.model.Expression}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parts</em>' containment reference list.
     * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage#getDisjunction_Parts()
     * @model containment="true"
     * @generated
     */
    EList<Expression> getParts();

} // Disjunction
