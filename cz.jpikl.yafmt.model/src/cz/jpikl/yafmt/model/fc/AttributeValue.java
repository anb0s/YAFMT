/**
 */
package cz.jpikl.yafmt.model.fc;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fc.AttributeValue#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeValue extends EObject {
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
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fc.AttributeValue#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // AttributeValue
