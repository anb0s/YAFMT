/**
 */
package cz.jpikl.yafmt.model.fc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fc.BooleanValue#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getBooleanValue()
 * @model
 * @generated
 */
public interface BooleanValue extends AttributeValue {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(boolean)
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getBooleanValue_Value()
     * @model required="true"
     * @generated
     */
    boolean isValue();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fc.BooleanValue#isValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #isValue()
     * @generated
     */
    void setValue(boolean value);

} // BooleanValue
