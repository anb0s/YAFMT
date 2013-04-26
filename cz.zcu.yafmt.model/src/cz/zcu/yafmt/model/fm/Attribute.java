/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
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
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getId <em>Id</em>}' attribute.
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
     * @see #setName(String)
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

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
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Comment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Comment</em>' attribute.
     * @see #setComment(String)
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Comment()
     * @model
     * @generated
     */
    String getComment();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getComment <em>Comment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Comment</em>' attribute.
     * @see #getComment()
     * @generated
     */
    void setComment(String value);

    /**
     * Returns the value of the '<em><b>Feature</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getAttributes <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature</em>' container reference.
     * @see #setFeature(Feature)
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Feature()
     * @see cz.zcu.yafmt.model.fm.Feature#getAttributes
     * @model opposite="attributes" required="true" transient="false"
     * @generated
     */
    Feature getFeature();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getFeature <em>Feature</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature</em>' container reference.
     * @see #getFeature()
     * @generated
     */
    void setFeature(Feature value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The default value is <code>"BOOLEAN"</code>.
     * The literals are from the enumeration {@link cz.zcu.yafmt.model.fm.AttributeType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see cz.zcu.yafmt.model.fm.AttributeType
     * @see #setType(AttributeType)
     * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Type()
     * @model default="BOOLEAN" required="true"
     * @generated
     */
    AttributeType getType();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see cz.zcu.yafmt.model.fm.AttributeType
     * @see #getType()
     * @generated
     */
    void setType(AttributeType value);

} // Attribute
