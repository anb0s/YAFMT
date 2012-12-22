package cz.jpikl.yafmt.models.featuremodel;

import org.eclipse.emf.ecore.EObject;
import java.util.List;

/**
 * @model
 */
public interface Feature extends EObject {
	
	/**
	 * @model
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link cz.jpikl.yafmt.models.featuremodel.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * @model containment="true"
	 */
	List<Feature> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.jpikl.yafmt.models.featuremodel.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Feature)
	 * @see cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage#getFeature_Parent()
	 * @see cz.jpikl.yafmt.models.featuremodel.Feature#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Feature getParent();

	/**
	 * Sets the value of the '{@link cz.jpikl.yafmt.models.featuremodel.Feature#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Feature value);
	
}
