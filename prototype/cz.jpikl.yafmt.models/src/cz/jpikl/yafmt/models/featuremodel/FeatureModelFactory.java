/**
 */
package cz.jpikl.yafmt.models.featuremodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage
 * @generated
 */
public interface FeatureModelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureModelFactory eINSTANCE = cz.jpikl.yafmt.models.featuremodel.impl.FeatureModelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
    Constraint createConstraint();

    /**
     * Returns a new object of class '<em>Feature</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature</em>'.
     * @generated
     */
    Feature createFeature();

    /**
     * Returns a new object of class '<em>Feature Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature Model</em>'.
     * @generated
     */
    FeatureModel createFeatureModel();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    FeatureModelPackage getFeatureModelPackage();

} //FeatureModelFactory
