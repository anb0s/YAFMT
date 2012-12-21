package cz.jpikl.yafmt.model.featuremodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface Constraint extends EObject {

	/**
	 * @model
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link cz.jpikl.yafmt.model.featuremodel.Constraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);
	
}
