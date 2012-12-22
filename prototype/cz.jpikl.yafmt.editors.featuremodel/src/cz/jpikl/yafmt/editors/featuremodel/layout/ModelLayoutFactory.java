/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage
 * @generated
 */
public interface ModelLayoutFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelLayoutFactory eINSTANCE = cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Layout</em>'.
	 * @generated
	 */
	ModelLayout createModelLayout();

	/**
	 * Returns a new object of class '<em>Object Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Bounds</em>'.
	 * @generated
	 */
	ObjectBounds createObjectBounds();

	/**
	 * Returns a new object of class '<em>Object Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Layout</em>'.
	 * @generated
	 */
	ObjectLayout createObjectLayout();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelLayoutPackage getModelLayoutPackage();

} //ModelLayoutFactory
