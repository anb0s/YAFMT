/**
 */
package cz.jpikl.yafmt.model.fm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Constraint#getValue <em>Value</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fm.Constraint#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getConstraint_Value()
     * @model required="true"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Constraint#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see cz.jpikl.yafmt.model.fm.FeatureModelPackage#getConstraint_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fm.Constraint#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

} // Constraint