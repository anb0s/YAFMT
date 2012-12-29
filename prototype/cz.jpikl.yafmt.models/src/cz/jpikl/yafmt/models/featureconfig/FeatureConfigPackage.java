/**
 */
package cz.jpikl.yafmt.models.featureconfig;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigFactory
 * @model kind="package"
 * @generated
 */
public interface FeatureConfigPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "featureconfig";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "https://bitbucket.org/jpikl/yafmt/featureconfig.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "featureconfig";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureConfigPackage eINSTANCE = cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl
     * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigPackageImpl#getFeatureConfiguration()
     * @generated
     */
    int FEATURE_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Feature Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__FEATURE_MODEL = 0;

    /**
     * The feature id for the '<em><b>Selection</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__SELECTION = 1;

    /**
     * The number of structural features of the '<em>Feature Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.models.featureconfig.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.models.featureconfig.impl.SelectionImpl
     * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigPackageImpl#getSelection()
     * @generated
     */
    int SELECTION = 1;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTION__FEATURE = 0;

    /**
     * The number of structural features of the '<em>Selection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTION_FEATURE_COUNT = 1;


    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration <em>Feature Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Configuration</em>'.
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration
     * @generated
     */
    EClass getFeatureConfiguration();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Feature Model</em>'.
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getFeatureModel()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EReference getFeatureConfiguration_FeatureModel();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getSelection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Selection</em>'.
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration#getSelection()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EReference getFeatureConfiguration_Selection();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.models.featureconfig.Selection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Selection</em>'.
     * @see cz.jpikl.yafmt.models.featureconfig.Selection
     * @generated
     */
    EClass getSelection();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.models.featureconfig.Selection#getFeature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Feature</em>'.
     * @see cz.jpikl.yafmt.models.featureconfig.Selection#getFeature()
     * @see #getSelection()
     * @generated
     */
    EReference getSelection_Feature();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    FeatureConfigFactory getFeatureConfigFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl
         * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigPackageImpl#getFeatureConfiguration()
         * @generated
         */
        EClass FEATURE_CONFIGURATION = eINSTANCE.getFeatureConfiguration();

        /**
         * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_CONFIGURATION__FEATURE_MODEL = eINSTANCE.getFeatureConfiguration_FeatureModel();

        /**
         * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_CONFIGURATION__SELECTION = eINSTANCE.getFeatureConfiguration_Selection();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.models.featureconfig.impl.SelectionImpl <em>Selection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.models.featureconfig.impl.SelectionImpl
         * @see cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigPackageImpl#getSelection()
         * @generated
         */
        EClass SELECTION = eINSTANCE.getSelection();

        /**
         * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SELECTION__FEATURE = eINSTANCE.getSelection_Feature();

    }

} //FeatureConfigPackage
