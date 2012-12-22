/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout.impl;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ModelLayoutImpl#getObjectLayouts <em>Object Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelLayoutImpl extends EObjectImpl implements ModelLayout {
	/**
	 * The cached value of the '{@link #getObjectLayouts() <em>Object Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectLayout> objectLayouts;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelLayoutPackage.Literals.MODEL_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectLayout> getObjectLayouts() {
		if (objectLayouts == null) {
			objectLayouts = new EObjectContainmentEList<ObjectLayout>(ObjectLayout.class, this, ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS);
		}
		return objectLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS:
				return ((InternalEList<?>)getObjectLayouts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS:
				return getObjectLayouts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS:
				getObjectLayouts().clear();
				getObjectLayouts().addAll((Collection<? extends ObjectLayout>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS:
				getObjectLayouts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelLayoutPackage.MODEL_LAYOUT__OBJECT_LAYOUTS:
				return objectLayouts != null && !objectLayouts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelLayoutImpl
