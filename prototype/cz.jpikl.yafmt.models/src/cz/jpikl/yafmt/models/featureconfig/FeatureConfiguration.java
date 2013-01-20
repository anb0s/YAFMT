/**
 */
package cz.jpikl.yafmt.models.featureconfig;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#getFeatureConfiguration()
 * @model
 * @generated
 */
public interface FeatureConfiguration extends EObject {
    /**
     * Returns the value of the '<em><b>Feature Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Model</em>' reference.
     * @see #setFeatureModel(FeatureModel)
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#getFeatureConfiguration_FeatureModel()
     * @model required="true"
     * @generated
     */
    FeatureModel getFeatureModel();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature Model</em>' reference.
     * @see #getFeatureModel()
     * @generated
     */
    void setFeatureModel(FeatureModel value);

    /**
     * Returns the value of the '<em><b>Selection</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.models.featureconfig.Selection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selection</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selection</em>' containment reference list.
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#getFeatureConfiguration_Selection()
     * @model containment="true"
     * @generated
     */
    EList<Selection> getSelection();

} // FeatureConfiguration
