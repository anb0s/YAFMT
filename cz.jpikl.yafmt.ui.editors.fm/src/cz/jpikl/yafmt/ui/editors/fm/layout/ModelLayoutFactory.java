/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage
 * @generated
 */
public interface ModelLayoutFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelLayoutFactory eINSTANCE = cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Model Layout</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model Layout</em>'.
     * @generated
     */
    ModelLayout createModelLayout();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelLayoutPackage getModelLayoutPackage();

} //ModelLayoutFactory
