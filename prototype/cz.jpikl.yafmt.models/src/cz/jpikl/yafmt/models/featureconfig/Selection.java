/**
 */
package cz.jpikl.yafmt.models.featureconfig;

import cz.jpikl.yafmt.models.featuremodel.Feature;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.models.featureconfig.Selection#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends EObject {
    /**
     * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Name</em>' attribute.
     * @see #setFeatureName(String)
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#getSelection_FeatureName()
     * @model
     * @generated
     */
    String getFeatureName();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.models.featureconfig.Selection#getFeatureName <em>Feature Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature Name</em>' attribute.
     * @see #getFeatureName()
     * @generated
     */
    void setFeatureName(String value);

} // Selection
