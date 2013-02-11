/**
 */
package cz.jpikl.yafmt.model.fc.impl;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.Selection;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getSelections <em>Selections</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getValues <em>Values</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getFeatureConfiguration <em>Feature Configuration</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionImpl extends EObjectImpl implements Selection {
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

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
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<AttributeValue> values;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SelectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FeatureConfigurationPackage.Literals.SELECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.SELECTION__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selection getParent() {
        if (eContainerFeatureID() != FeatureConfigurationPackage.SELECTION__PARENT) return null;
        return (Selection)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent(Selection newParent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParent, FeatureConfigurationPackage.SELECTION__PARENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent(Selection newParent) {
        if (newParent != eInternalContainer() || (eContainerFeatureID() != FeatureConfigurationPackage.SELECTION__PARENT && newParent != null)) {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, FeatureConfigurationPackage.SELECTION__SELECTIONS, Selection.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.SELECTION__PARENT, newParent, newParent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Selection> getSelections() {
        if (selections == null) {
            selections = new EObjectContainmentWithInverseEList<Selection>(Selection.class, this, FeatureConfigurationPackage.SELECTION__SELECTIONS, FeatureConfigurationPackage.SELECTION__PARENT);
        }
        return selections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AttributeValue> getValues() {
        if (values == null) {
            values = new EObjectContainmentEList<AttributeValue>(AttributeValue.class, this, FeatureConfigurationPackage.SELECTION__VALUES);
        }
        return values;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfiguration getFeatureConfiguration() {
        FeatureConfiguration featureConfiguration = basicGetFeatureConfiguration();
        return featureConfiguration != null && featureConfiguration.eIsProxy() ? (FeatureConfiguration)eResolveProxy((InternalEObject)featureConfiguration) : featureConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FeatureConfiguration basicGetFeatureConfiguration() {
        Resource resource = eResource();
        if(resource == null)
            return null;
        EObject target = resource.getContents().get(0);
        return (target instanceof FeatureConfiguration) ? (FeatureConfiguration) target : null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Feature getFeature() {
        Feature feature = basicGetFeature();
        return feature != null && feature.eIsProxy() ? (Feature)eResolveProxy((InternalEObject)feature) : feature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Feature basicGetFeature() {
        FeatureConfiguration featureConfig = getFeatureConfiguration();
        if(featureConfig == null)
            return null;
        
        FeatureModel featureModel = featureConfig.getFeatureModel();
        if(featureModel == null)
            return null;
        
        return featureModel.getFeatureById(getId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean hasContext(String context) {
        // Check if there is an ancestor with given ID.
        for(Selection ancestor = this; ancestor != null; ancestor = ancestor.getParent()) {
            if(context.equals(ancestor.getId()))
                return true;
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FeatureConfigurationPackage.SELECTION__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((Selection)otherEnd, msgs);
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSelections()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FeatureConfigurationPackage.SELECTION__PARENT:
                return basicSetParent(null, msgs);
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                return ((InternalEList<?>)getSelections()).basicRemove(otherEnd, msgs);
            case FeatureConfigurationPackage.SELECTION__VALUES:
                return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case FeatureConfigurationPackage.SELECTION__PARENT:
                return eInternalContainer().eInverseRemove(this, FeatureConfigurationPackage.SELECTION__SELECTIONS, Selection.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FeatureConfigurationPackage.SELECTION__ID:
                return getId();
            case FeatureConfigurationPackage.SELECTION__PARENT:
                return getParent();
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                return getSelections();
            case FeatureConfigurationPackage.SELECTION__VALUES:
                return getValues();
            case FeatureConfigurationPackage.SELECTION__FEATURE_CONFIGURATION:
                if (resolve) return getFeatureConfiguration();
                return basicGetFeatureConfiguration();
            case FeatureConfigurationPackage.SELECTION__FEATURE:
                if (resolve) return getFeature();
                return basicGetFeature();
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
            case FeatureConfigurationPackage.SELECTION__ID:
                setId((String)newValue);
                return;
            case FeatureConfigurationPackage.SELECTION__PARENT:
                setParent((Selection)newValue);
                return;
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                getSelections().clear();
                getSelections().addAll((Collection<? extends Selection>)newValue);
                return;
            case FeatureConfigurationPackage.SELECTION__VALUES:
                getValues().clear();
                getValues().addAll((Collection<? extends AttributeValue>)newValue);
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
            case FeatureConfigurationPackage.SELECTION__ID:
                setId(ID_EDEFAULT);
                return;
            case FeatureConfigurationPackage.SELECTION__PARENT:
                setParent((Selection)null);
                return;
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                getSelections().clear();
                return;
            case FeatureConfigurationPackage.SELECTION__VALUES:
                getValues().clear();
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
            case FeatureConfigurationPackage.SELECTION__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case FeatureConfigurationPackage.SELECTION__PARENT:
                return getParent() != null;
            case FeatureConfigurationPackage.SELECTION__SELECTIONS:
                return selections != null && !selections.isEmpty();
            case FeatureConfigurationPackage.SELECTION__VALUES:
                return values != null && !values.isEmpty();
            case FeatureConfigurationPackage.SELECTION__FEATURE_CONFIGURATION:
                return basicGetFeatureConfiguration() != null;
            case FeatureConfigurationPackage.SELECTION__FEATURE:
                return basicGetFeature() != null;
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
        result.append(" (id: ");
        result.append(id);
        result.append(')');
        return result.toString();
    }

} //SelectionImpl
