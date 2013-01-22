/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout.impl;

import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage;

import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelLayoutPackageImpl extends EPackageImpl implements ModelLayoutPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modelLayoutEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eObjectToBoundsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType boundsEDataType = null;

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
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModelLayoutPackageImpl() {
        super(eNS_URI, ModelLayoutFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ModelLayoutPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModelLayoutPackage init() {
        if (isInited) return (ModelLayoutPackage)EPackage.Registry.INSTANCE.getEPackage(ModelLayoutPackage.eNS_URI);

        // Obtain or create and register package
        ModelLayoutPackageImpl theModelLayoutPackage = (ModelLayoutPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelLayoutPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelLayoutPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theModelLayoutPackage.createPackageContents();

        // Initialize created meta-data
        theModelLayoutPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theModelLayoutPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ModelLayoutPackage.eNS_URI, theModelLayoutPackage);
        return theModelLayoutPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModelLayout() {
        return modelLayoutEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModelLayout_Mapping() {
        return (EReference)modelLayoutEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEObjectToBounds() {
        return eObjectToBoundsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEObjectToBounds_Key() {
        return (EReference)eObjectToBoundsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEObjectToBounds_Value() {
        return (EAttribute)eObjectToBoundsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getBounds() {
        return boundsEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelLayoutFactory getModelLayoutFactory() {
        return (ModelLayoutFactory)getEFactoryInstance();
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
        modelLayoutEClass = createEClass(MODEL_LAYOUT);
        createEReference(modelLayoutEClass, MODEL_LAYOUT__MAPPING);

        eObjectToBoundsEClass = createEClass(EOBJECT_TO_BOUNDS);
        createEReference(eObjectToBoundsEClass, EOBJECT_TO_BOUNDS__KEY);
        createEAttribute(eObjectToBoundsEClass, EOBJECT_TO_BOUNDS__VALUE);

        // Create data types
        boundsEDataType = createEDataType(BOUNDS);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(modelLayoutEClass, ModelLayout.class, "ModelLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getModelLayout_Mapping(), this.getEObjectToBounds(), null, "mapping", null, 0, -1, ModelLayout.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eObjectToBoundsEClass, Map.Entry.class, "EObjectToBounds", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEObjectToBounds_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEObjectToBounds_Value(), this.getBounds(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(boundsEDataType, Rectangle.class, "Bounds", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //ModelLayoutPackageImpl
