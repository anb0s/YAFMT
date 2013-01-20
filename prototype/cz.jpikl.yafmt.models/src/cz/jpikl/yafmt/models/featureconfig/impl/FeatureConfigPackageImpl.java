/**
 */
package cz.jpikl.yafmt.models.featureconfig.impl;

import cz.jpikl.yafmt.models.featureconfig.FeatureConfigFactory;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featureconfig.Selection;

import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

import cz.jpikl.yafmt.models.featuremodel.impl.FeatureModelPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureConfigPackageImpl extends EPackageImpl implements FeatureConfigPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass featureConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass selectionEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private FeatureConfigPackageImpl() {
        super(eNS_URI, FeatureConfigFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link FeatureConfigPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static FeatureConfigPackage init() {
        if (isInited) return (FeatureConfigPackage)EPackage.Registry.INSTANCE.getEPackage(FeatureConfigPackage.eNS_URI);

        // Obtain or create and register package
        FeatureConfigPackageImpl theFeatureConfigPackage = (FeatureConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FeatureConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FeatureConfigPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        FeatureModelPackageImpl theFeatureModelPackage = (FeatureModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) instanceof FeatureModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) : FeatureModelPackage.eINSTANCE);

        // Create package meta-data objects
        theFeatureConfigPackage.createPackageContents();
        theFeatureModelPackage.createPackageContents();

        // Initialize created meta-data
        theFeatureConfigPackage.initializePackageContents();
        theFeatureModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFeatureConfigPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FeatureConfigPackage.eNS_URI, theFeatureConfigPackage);
        return theFeatureConfigPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFeatureConfiguration() {
        return featureConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFeatureConfiguration_FeatureModel() {
        return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFeatureConfiguration_Selection() {
        return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSelection() {
        return selectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSelection_FeatureName() {
        return (EAttribute)selectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfigFactory getFeatureConfigFactory() {
        return (FeatureConfigFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        featureConfigurationEClass = createEClass(FEATURE_CONFIGURATION);
        createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__FEATURE_MODEL);
        createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__SELECTION);

        selectionEClass = createEClass(SELECTION);
        createEAttribute(selectionEClass, SELECTION__FEATURE_NAME);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        FeatureModelPackage theFeatureModelPackage = (FeatureModelPackage)EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(featureConfigurationEClass, FeatureConfiguration.class, "FeatureConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFeatureConfiguration_FeatureModel(), theFeatureModelPackage.getFeatureModel(), null, "featureModel", null, 1, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFeatureConfiguration_Selection(), this.getSelection(), null, "selection", null, 0, -1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(selectionEClass, Selection.class, "Selection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSelection_FeatureName(), ecorePackage.getEString(), "featureName", null, 1, 1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //FeatureConfigPackageImpl
