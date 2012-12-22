package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface ObjectLayout extends EObject {

	/**
	 * @model
	 */
	EObject getObject();
	
	/**
	 * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * @model containment="true"
	 */
	EObject getLayoutData();

	/**
	 * Sets the value of the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getLayoutData <em>Layout Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Data</em>' containment reference.
	 * @see #getLayoutData()
	 * @generated
	 */
	void setLayoutData(EObject value);
	
}
