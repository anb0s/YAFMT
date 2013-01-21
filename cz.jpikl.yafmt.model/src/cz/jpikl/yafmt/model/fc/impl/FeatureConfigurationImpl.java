/**
 */
package cz.jpikl.yafmt.model.fc.impl;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.Selection;

import cz.jpikl.yafmt.model.fm.FeatureModel;

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
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl#getSelections <em>Selections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureConfigurationImpl extends EObjectImpl implements FeatureConfiguration {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

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
     * The cached value of the '{@link #getSelections() <em>Selections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelections()
     * @generated
     * @ordered
     */
    protected EList<Selection> selections;

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
        return FeatureConfigurationPackage.Literals.FEATURE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION, oldVersion, version));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Selection> getSelections() {
        if (selections == null) {
            selections = new EObjectContainmentEList<Selection>(Selection.class, this, FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS);
        }
        return selections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS:
                return ((InternalEList<?>)getSelections()).basicRemove(otherEnd, msgs);
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
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
                return getName();
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
                return getDescription();
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
                return getVersion();
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                if (resolve) return getFeatureModel();
                return basicGetFeatureModel();
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS:
                return getSelections();
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
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
                setName((String)newValue);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
                setVersion((String)newValue);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                setFeatureModel((FeatureModel)newValue);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS:
                getSelections().clear();
                getSelections().addAll((Collection<? extends Selection>)newValue);
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
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                setFeatureModel((FeatureModel)null);
                return;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS:
                getSelections().clear();
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
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
                return featureModel != null;
            case FeatureConfigurationPackage.FEATURE_CONFIGURATION__SELECTIONS:
                return selections != null && !selections.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(", version: ");
        result.append(version);
        result.append(')');
        return result.toString();
    }

} //FeatureConfigurationImpl
