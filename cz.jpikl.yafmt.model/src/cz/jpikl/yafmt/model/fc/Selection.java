/**
 */
package cz.jpikl.yafmt.model.fc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getId <em>Id</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fc.Selection#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fc.AttributeValue}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Values()
     * @model containment="true"
     * @generated
     */
    EList<AttributeValue> getValues();

} // Selection