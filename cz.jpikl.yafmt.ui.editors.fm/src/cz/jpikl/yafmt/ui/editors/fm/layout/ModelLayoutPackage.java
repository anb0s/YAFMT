/**
 */
package cz.jpikl.yafmt.ui.editors.fm.layout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayoutFactory
 * @model kind="package"
 * @generated
 */
public interface ModelLayoutPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "layout";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "https://bitbucket.org/jpikl/yafmt/ui/editors/fm/layout";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "layout";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelLayoutPackage eINSTANCE = cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutImpl <em>Model Layout</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutImpl
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getModelLayout()
     * @generated
     */
    int MODEL_LAYOUT = 0;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_LAYOUT__MAPPING = 0;

    /**
     * The number of structural features of the '<em>Model Layout</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_LAYOUT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.ui.editors.fm.layout.impl.EObjectToBoundsImpl <em>EObject To Bounds</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.EObjectToBoundsImpl
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getEObjectToBounds()
     * @generated
     */
    int EOBJECT_TO_BOUNDS = 1;

    /**
     * The feature id for the '<em><b>Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_BOUNDS__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_BOUNDS__VALUE = 1;

    /**
     * The number of structural features of the '<em>EObject To Bounds</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_BOUNDS_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '<em>Bounds</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getBounds()
     * @generated
     */
    int BOUNDS = 2;


    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout <em>Model Layout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model Layout</em>'.
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout
     * @generated
     */
    EClass getModelLayout();

    /**
     * Returns the meta object for the map '{@link cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout#getMapping <em>Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Mapping</em>'.
     * @see cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout#getMapping()
     * @see #getModelLayout()
     * @generated
     */
    EReference getModelLayout_Mapping();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To Bounds</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EObject To Bounds</em>'.
     * @see java.util.Map.Entry
     * @model keyType="org.eclipse.emf.ecore.EObject"
     *        valueDataType="cz.jpikl.yafmt.ui.editors.fm.layout.Bounds"
     * @generated
     */
    EClass getEObjectToBounds();

    /**
     * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEObjectToBounds()
     * @generated
     */
    EReference getEObjectToBounds_Key();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEObjectToBounds()
     * @generated
     */
    EAttribute getEObjectToBounds_Value();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Bounds</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Bounds</em>'.
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
     * @generated
     */
    EDataType getBounds();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelLayoutFactory getModelLayoutFactory();

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
         * The meta object literal for the '{@link cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutImpl <em>Model Layout</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutImpl
         * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getModelLayout()
         * @generated
         */
        EClass MODEL_LAYOUT = eINSTANCE.getModelLayout();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODEL_LAYOUT__MAPPING = eINSTANCE.getModelLayout_Mapping();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.ui.editors.fm.layout.impl.EObjectToBoundsImpl <em>EObject To Bounds</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.EObjectToBoundsImpl
         * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getEObjectToBounds()
         * @generated
         */
        EClass EOBJECT_TO_BOUNDS = eINSTANCE.getEObjectToBounds();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EOBJECT_TO_BOUNDS__KEY = eINSTANCE.getEObjectToBounds_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EOBJECT_TO_BOUNDS__VALUE = eINSTANCE.getEObjectToBounds_Value();

        /**
         * The meta object literal for the '<em>Bounds</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.draw2d.geometry.Rectangle
         * @see cz.jpikl.yafmt.ui.editors.fm.layout.impl.ModelLayoutPackageImpl#getBounds()
         * @generated
         */
        EDataType BOUNDS = eINSTANCE.getBounds();

    }

} //ModelLayoutPackage
