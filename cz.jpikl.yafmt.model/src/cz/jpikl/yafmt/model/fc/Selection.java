/**
 */
package cz.jpikl.yafmt.model.fc;

import cz.jpikl.yafmt.model.fm.Feature;
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
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getName <em>Name</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getValues <em>Values</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getSelections <em>Selections</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getFeatureConfiguration <em>Feature Configuration</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.Selection#getFeature <em>Feature</em>}</li>
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
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Name()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getName();

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Description()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getDescription();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link cz.jpikl.yafmt.model.fc.Selection#getSelections <em>Selections</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(Selection)
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Parent()
     * @see cz.jpikl.yafmt.model.fc.Selection#getSelections
     * @model opposite="selections" transient="false"
     * @generated
     */
    Selection getParent();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.model.fc.Selection#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(Selection value);

    /**
     * Returns the value of the '<em><b>Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root</em>' attribute.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Root()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isRoot();

    /**
     * Returns the value of the '<em><b>Selections</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fc.Selection}.
     * It is bidirectional and its opposite is '{@link cz.jpikl.yafmt.model.fc.Selection#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selections</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Selections()
     * @see cz.jpikl.yafmt.model.fc.Selection#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<Selection> getSelections();

    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link cz.jpikl.yafmt.model.fc.AttributeValue}.
     * It is bidirectional and its opposite is '{@link cz.jpikl.yafmt.model.fc.AttributeValue#getSelection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Values()
     * @see cz.jpikl.yafmt.model.fc.AttributeValue#getSelection
     * @model opposite="selection" containment="true"
     * @generated
     */
    EList<AttributeValue> getValues();

    /**
     * Returns the value of the '<em><b>Feature Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Configuration</em>' reference.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_FeatureConfiguration()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    FeatureConfiguration getFeatureConfiguration();

    /**
     * Returns the value of the '<em><b>Feature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature</em>' reference.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Feature()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    Feature getFeature();

} // Selection
