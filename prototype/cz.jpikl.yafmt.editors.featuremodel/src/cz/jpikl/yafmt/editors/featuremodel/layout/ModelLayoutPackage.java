/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * @model kind="package"
 */
public interface ModelLayoutPackage extends EPackage {

	/**
	 * @model
	 */
	String eNAME = "layout";

	/**
	 * @model
	 */
	String eNS_URI = "https://bitbucket.org/jpikl/yafmt/modellayout.ecore";

	/**
	 * @model
	 */
	String eNS_PREFIX = "cz.jpikl.yafmt.editors.featuremodel.layout";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelLayoutPackage eINSTANCE = cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl.init();

	/**
	 * The meta object id for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutImpl <em>Model Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutImpl
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getModelLayout()
	 * @generated
	 */
	int MODEL_LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Object Layouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_LAYOUT__OBJECT_LAYOUTS = 0;

	/**
	 * The number of structural features of the '<em>Model Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_LAYOUT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl <em>Object Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getObjectLayout()
	 * @generated
	 */
	int OBJECT_LAYOUT = 2;

	/**
	 * The meta object id for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl <em>Object Bounds</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getObjectBounds()
	 * @generated
	 */
	int OBJECT_BOUNDS = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS__Y = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS__HEIGHT = 3;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS__BOUNDS = 4;

	/**
	 * The number of structural features of the '<em>Object Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOUNDS_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LAYOUT__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LAYOUT__LAYOUT_DATA = 1;

	/**
	 * The number of structural features of the '<em>Object Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LAYOUT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link java.util.Map <em>Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 3;

	/**
	 * The number of structural features of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.util.EMap <em>EMap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.EMap
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getEMap()
	 * @generated
	 */
	int EMAP = 4;

	/**
	 * The number of structural features of the '<em>EMap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Rectangle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 5;

	/**
	 * Returns the meta object for class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout <em>Model Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Layout</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout
	 * @generated
	 */
	EClass getModelLayout();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout#getObjectLayouts <em>Object Layouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Object Layouts</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout#getObjectLayouts()
	 * @see #getModelLayout()
	 * @generated
	 */
	EReference getModelLayout_ObjectLayouts();

	/**
	 * Returns the meta object for class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds <em>Object Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Bounds</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds
	 * @generated
	 */
	EClass getObjectBounds();

	/**
	 * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getX()
	 * @see #getObjectBounds()
	 * @generated
	 */
	EAttribute getObjectBounds_X();

	/**
	 * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getY()
	 * @see #getObjectBounds()
	 * @generated
	 */
	EAttribute getObjectBounds_Y();

	/**
	 * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getWidth()
	 * @see #getObjectBounds()
	 * @generated
	 */
	EAttribute getObjectBounds_Width();

	/**
	 * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getHeight()
	 * @see #getObjectBounds()
	 * @generated
	 */
	EAttribute getObjectBounds_Height();

	/**
	 * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bounds</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds#getBounds()
	 * @see #getObjectBounds()
	 * @generated
	 */
	EAttribute getObjectBounds_Bounds();

	/**
	 * Returns the meta object for class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout <em>Object Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Layout</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout
	 * @generated
	 */
	EClass getObjectLayout();

	/**
	 * Returns the meta object for the reference '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getObject()
	 * @see #getObjectLayout()
	 * @generated
	 */
	EReference getObjectLayout_Object();

	/**
	 * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getLayoutData <em>Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout Data</em>'.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout#getLayoutData()
	 * @see #getObjectLayout()
	 * @generated
	 */
	EReference getObjectLayout_LayoutData();

	/**
	 * Returns the meta object for class '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" typeParameters="T T1"
	 * @generated
	 */
	EClass getMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.common.util.EMap <em>EMap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMap</em>'.
	 * @see org.eclipse.emf.common.util.EMap
	 * @model instanceClass="org.eclipse.emf.common.util.EMap" typeParameters="T T1"
	 * @generated
	 */
	EClass getEMap();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rectangle</em>'.
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
	 * @generated
	 */
	EDataType getRectangle();

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
		 * The meta object literal for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutImpl <em>Model Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutImpl
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getModelLayout()
		 * @generated
		 */
		EClass MODEL_LAYOUT = eINSTANCE.getModelLayout();

		/**
		 * The meta object literal for the '<em><b>Object Layouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_LAYOUT__OBJECT_LAYOUTS = eINSTANCE.getModelLayout_ObjectLayouts();

		/**
		 * The meta object literal for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl <em>Object Bounds</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectBoundsImpl
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getObjectBounds()
		 * @generated
		 */
		EClass OBJECT_BOUNDS = eINSTANCE.getObjectBounds();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_BOUNDS__X = eINSTANCE.getObjectBounds_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_BOUNDS__Y = eINSTANCE.getObjectBounds_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_BOUNDS__WIDTH = eINSTANCE.getObjectBounds_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_BOUNDS__HEIGHT = eINSTANCE.getObjectBounds_Height();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_BOUNDS__BOUNDS = eINSTANCE.getObjectBounds_Bounds();

		/**
		 * The meta object literal for the '{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl <em>Object Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getObjectLayout()
		 * @generated
		 */
		EClass OBJECT_LAYOUT = eINSTANCE.getObjectLayout();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_LAYOUT__OBJECT = eINSTANCE.getObjectLayout_Object();

		/**
		 * The meta object literal for the '<em><b>Layout Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_LAYOUT__LAYOUT_DATA = eINSTANCE.getObjectLayout_LayoutData();

		/**
		 * The meta object literal for the '{@link java.util.Map <em>Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getMap()
		 * @generated
		 */
		EClass MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.common.util.EMap <em>EMap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.EMap
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getEMap()
		 * @generated
		 */
		EClass EMAP = eINSTANCE.getEMap();

		/**
		 * The meta object literal for the '<em>Rectangle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Rectangle
		 * @see cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutPackageImpl#getRectangle()
		 * @generated
		 */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

	}

}
