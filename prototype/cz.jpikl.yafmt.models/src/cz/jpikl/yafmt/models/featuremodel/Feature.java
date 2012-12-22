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
	
}
