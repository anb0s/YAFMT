/**
 */
package cz.jpikl.yafmt.editors.featuremodel.layout.impl;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl#getObject <em>Object</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.editors.featuremodel.layout.impl.ObjectLayoutImpl#getLayoutData <em>Layout Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectLayoutImpl extends EObjectImpl implements ObjectLayout {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;
	/**
	 * The cached value of the '{@link #getLayoutData() <em>Layout Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutData()
	 * @generated
	 * @ordered
	 */
	protected EObject layoutData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelLayoutPackage.Literals.OBJECT_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelLayoutPackage.OBJECT_LAYOUT__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(EObject newObject) {
		EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_LAYOUT__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLayoutData() {
		return layoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutData(EObject newLayoutData, NotificationChain msgs) {
		EObject oldLayoutData = layoutData;
		layoutData = newLayoutData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA, oldLayoutData, newLayoutData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutData(EObject newLayoutData) {
		if (newLayoutData != layoutData) {
			NotificationChain msgs = null;
			if (layoutData != null)
				msgs = ((InternalEObject)layoutData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA, null, msgs);
			if (newLayoutData != null)
				msgs = ((InternalEObject)newLayoutData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA, null, msgs);
			msgs = basicSetLayoutData(newLayoutData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA, newLayoutData, newLayoutData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA:
				return basicSetLayoutData(null, msgs);
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
			case ModelLayoutPackage.OBJECT_LAYOUT__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA:
				return getLayoutData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelLayoutPackage.OBJECT_LAYOUT__OBJECT:
				setObject((EObject)newValue);
				return;
			case ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA:
				setLayoutData((EObject)newValue);
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
			case ModelLayoutPackage.OBJECT_LAYOUT__OBJECT:
				setObject((EObject)null);
				return;
			case ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA:
				setLayoutData((EObject)null);
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
			case ModelLayoutPackage.OBJECT_LAYOUT__OBJECT:
				return object != null;
			case ModelLayoutPackage.OBJECT_LAYOUT__LAYOUT_DATA:
				return layoutData != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectLayoutImpl
