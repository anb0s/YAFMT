/**
 */
package cz.jpikl.yafmt.model.fc.impl;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.BooleanValue;
import cz.jpikl.yafmt.model.fc.DoubleValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationFactory;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.IntegerValue;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fc.StringValue;

import cz.jpikl.yafmt.model.fm.FeatureModelPackage;

import cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl;

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
public class FeatureConfigurationPackageImpl extends EPackageImpl implements FeatureConfigurationPackage {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass integerValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass doubleValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringValueEClass = null;

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
     * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private FeatureConfigurationPackageImpl() {
        super(eNS_URI, FeatureConfigurationFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link FeatureConfigurationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static FeatureConfigurationPackage init() {
        if (isInited) return (FeatureConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(FeatureConfigurationPackage.eNS_URI);

        // Obtain or create and register package
        FeatureConfigurationPackageImpl theFeatureConfigurationPackage = (FeatureConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FeatureConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FeatureConfigurationPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        FeatureModelPackageImpl theFeatureModelPackage = (FeatureModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) instanceof FeatureModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) : FeatureModelPackage.eINSTANCE);

        // Create package meta-data objects
        theFeatureConfigurationPackage.createPackageContents();
        theFeatureModelPackage.createPackageContents();

        // Initialize created meta-data
        theFeatureConfigurationPackage.initializePackageContents();
        theFeatureModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFeatureConfigurationPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FeatureConfigurationPackage.eNS_URI, theFeatureConfigurationPackage);
        return theFeatureConfigurationPackage;
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
    public EAttribute getFeatureConfiguration_Name() {
        return (EAttribute)featureConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFeatureConfiguration_Description() {
        return (EAttribute)featureConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFeatureConfiguration_Version() {
        return (EAttribute)featureConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFeatureConfiguration_FeatureModel() {
        return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFeatureConfiguration_Root() {
        return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(4);
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
    public EAttribute getSelection_Id() {
        return (EAttribute)selectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSelection_Parent() {
        return (EReference)selectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSelection_Selections() {
        return (EReference)selectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSelection_Values() {
        return (EReference)selectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeValue() {
        return attributeValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeValue_Id() {
        return (EAttribute)attributeValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBooleanValue() {
        return booleanValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBooleanValue_Value() {
        return (EAttribute)booleanValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntegerValue() {
        return integerValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntegerValue_Value() {
        return (EAttribute)integerValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDoubleValue() {
        return doubleValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDoubleValue_Value() {
        return (EAttribute)doubleValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringValue() {
        return stringValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringValue_Value() {
        return (EAttribute)stringValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfigurationFactory getFeatureConfigurationFactory() {
        return (FeatureConfigurationFactory)getEFactoryInstance();
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
        createEAttribute(featureConfigurationEClass, FEATURE_CONFIGURATION__NAME);
        createEAttribute(featureConfigurationEClass, FEATURE_CONFIGURATION__DESCRIPTION);
        createEAttribute(featureConfigurationEClass, FEATURE_CONFIGURATION__VERSION);
        createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__FEATURE_MODEL);
        createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__ROOT);

        selectionEClass = createEClass(SELECTION);
        createEAttribute(selectionEClass, SELECTION__ID);
        createEReference(selectionEClass, SELECTION__PARENT);
        createEReference(selectionEClass, SELECTION__SELECTIONS);
        createEReference(selectionEClass, SELECTION__VALUES);

        attributeValueEClass = createEClass(ATTRIBUTE_VALUE);
        createEAttribute(attributeValueEClass, ATTRIBUTE_VALUE__ID);

        booleanValueEClass = createEClass(BOOLEAN_VALUE);
        createEAttribute(booleanValueEClass, BOOLEAN_VALUE__VALUE);

        integerValueEClass = createEClass(INTEGER_VALUE);
        createEAttribute(integerValueEClass, INTEGER_VALUE__VALUE);

        doubleValueEClass = createEClass(DOUBLE_VALUE);
        createEAttribute(doubleValueEClass, DOUBLE_VALUE__VALUE);

        stringValueEClass = createEClass(STRING_VALUE);
        createEAttribute(stringValueEClass, STRING_VALUE__VALUE);
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
        booleanValueEClass.getESuperTypes().add(this.getAttributeValue());
        integerValueEClass.getESuperTypes().add(this.getAttributeValue());
        doubleValueEClass.getESuperTypes().add(this.getAttributeValue());
        stringValueEClass.getESuperTypes().add(this.getAttributeValue());

        // Initialize classes and features; add operations and parameters
        initEClass(featureConfigurationEClass, FeatureConfiguration.class, "FeatureConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFeatureConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFeatureConfiguration_Description(), ecorePackage.getEString(), "description", null, 0, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFeatureConfiguration_Version(), ecorePackage.getEString(), "version", null, 0, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFeatureConfiguration_FeatureModel(), theFeatureModelPackage.getFeatureModel(), null, "featureModel", null, 0, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFeatureConfiguration_Root(), this.getSelection(), null, "root", null, 1, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(selectionEClass, Selection.class, "Selection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSelection_Id(), ecorePackage.getEString(), "id", null, 1, 1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSelection_Parent(), this.getSelection(), this.getSelection_Selections(), "parent", null, 0, 1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSelection_Selections(), this.getSelection(), this.getSelection_Parent(), "selections", null, 0, -1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSelection_Values(), this.getAttributeValue(), null, "values", null, 0, -1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeValueEClass, AttributeValue.class, "AttributeValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeValue_Id(), ecorePackage.getEString(), "id", null, 1, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(booleanValueEClass, BooleanValue.class, "BooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBooleanValue_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntegerValue_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(doubleValueEClass, DoubleValue.class, "DoubleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDoubleValue_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stringValueEClass, StringValue.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStringValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //FeatureConfigurationPackageImpl
