/**
 */
package cz.jpikl.yafmt.models.featureconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage
 * @generated
 */
public interface FeatureConfigFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureConfigFactory eINSTANCE = cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Feature Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Feature Configuration</em>'.
     * @generated
     */
    FeatureConfiguration createFeatureConfiguration();

    /**
     * Returns a new object of class '<em>Selection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Selection</em>'.
     * @generated
     */
    Selection createSelection();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    FeatureConfigPackage getFeatureConfigPackage();

} //FeatureConfigFactory
