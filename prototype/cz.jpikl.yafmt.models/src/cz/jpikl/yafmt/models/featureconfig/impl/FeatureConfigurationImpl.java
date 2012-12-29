/**
 */
package cz.jpikl.yafmt.models.featureconfig.impl;

import cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featureconfig.Selection;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.models.featureconfig.impl.FeatureConfigurationImpl#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureConfigurationImpl extends EObjectImpl implements FeatureConfiguration {
    /**
     * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureModel()
     * @generated
     * @ordered
     */
    protected FeatureModel featureModel;

    /**
     * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelection()
     * @generated
     * @ordered
     */
    protected EList<Selection> selection;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FeatureConfigurationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FeatureConfigPackage.Literals.FEATURE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModel getFeatureModel() {
        if (featureModel != null && featureModel.eIsProxy()) {
            InternalEObject oldFeatureModel = (InternalEObject)featureModel;
            featureModel = (FeatureModel)eResolveProxy(oldFeatureModel);
            if (featureModel != oldFeatureModel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
            }
        }
        return featureModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModel basicGetFeatureModel() {
        return featureModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFeatureModel(FeatureModel newFeatureModel) {
        FeatureModel oldFeatureModel = featureModel;
        featureModel = newFeatureModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Selection> getSelection() {
        if (selection == null) {
            selection = new EObjectContainmentEList<Selection>(Selection.class, this, FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION);
        }
        return selection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION:
                return ((InternalEList<?>)getSelection()).basicRemove(otherEnd, msgs);
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
            case FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                if (resolve) return getFeatureModel();
                return basicGetFeatureModel();
            case FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION:
                return getSelection();
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
            case FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                setFeatureModel((FeatureModel)newValue);
                return;
            case FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION:
                getSelection().clear();
                getSelection().addAll((Collection<? extends Selection>)newValue);
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
            case FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                setFeatureModel((FeatureModel)null);
                return;
            case FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION:
                getSelection().clear();
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
            case FeatureConfigPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                return featureModel != null;
            case FeatureConfigPackage.FEATURE_CONFIGURATION__SELECTION:
                return selection != null && !selection.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FeatureConfigurationImpl
