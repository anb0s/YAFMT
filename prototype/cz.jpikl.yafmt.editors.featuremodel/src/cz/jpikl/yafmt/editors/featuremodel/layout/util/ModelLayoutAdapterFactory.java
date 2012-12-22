/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout.util;

import cz.jpikl.yafmt.editors.featuremodel.layout.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage
 * @generated
 */
public class ModelLayoutAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelLayoutPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelLayoutAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelLayoutPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelLayoutSwitch<Adapter> modelSwitch =
		new ModelLayoutSwitch<Adapter>() {
			@Override
			public Adapter caseModelLayout(ModelLayout object) {
				return createModelLayoutAdapter();
			}
			@Override
			public Adapter caseObjectBounds(ObjectBounds object) {
				return createObjectBoundsAdapter();
			}
			@Override
			public Adapter caseObjectLayout(ObjectLayout object) {
				return createObjectLayoutAdapter();
			}
			@Override
			public <T, T1> Adapter caseMap(Map<T, T1> object) {
				return createMapAdapter();
			}
			@Override
			public <T, T1> Adapter caseEMap(EMap<T, T1> object) {
				return createEMapAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout <em>Model Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout
	 * @generated
	 */
	public Adapter createModelLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds <em>Object Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds
	 * @generated
	 */
	public Adapter createObjectBoundsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout <em>Object Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout
	 * @generated
	 */
	public Adapter createObjectLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map
	 * @generated
	 */
	public Adapter createMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.common.util.EMap <em>EMap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.common.util.EMap
	 * @generated
	 */
	public Adapter createEMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelLayoutAdapterFactory
