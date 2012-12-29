/**
 */
package cz.jpikl.yafmt.models.featuremodel.impl;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

import java.util.Collection;

import java.util.List;
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
 * An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.jpikl.yafmt.models.featuremodel.impl.FeatureModelImpl#getRootFeature <em>Root Feature</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.models.featuremodel.impl.FeatureModelImpl#getOrphanedFeatures <em>Orphaned Features</em>}</li>
 *   <li>{@link cz.jpikl.yafmt.models.featuremodel.impl.FeatureModelImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureModelImpl extends EObjectImpl implements FeatureModel {
    /**
     * The cached value of the '{@link #getRootFeature() <em>Root Feature</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRootFeature()
     * @generated
     * @ordered
     */
    protected Feature rootFeature;

    /**
     * The cached value of the '{@link #getOrphanedFeatures() <em>Orphaned Features</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrphanedFeatures()
     * @generated
     * @ordered
     */
    protected EList<Feature> orphanedFeatures;

    /**
     * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConstraints()
     * @generated
     * @ordered
     */
    protected EList<Constraint> constraints;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected FeatureModelImpl() {
        rootFeature = FeatureModelFactory.eINSTANCE.createFeature();
        rootFeature.setName("Root Feature");
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FeatureModelPackage.Literals.FEATURE_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Feature getRootFeature() {
        return rootFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRootFeature(Feature newRootFeature, NotificationChain msgs) {
        Feature oldRootFeature = rootFeature;
        rootFeature = newRootFeature;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE, oldRootFeature, newRootFeature);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRootFeature(Feature newRootFeature) {
        if (newRootFeature != rootFeature) {
            NotificationChain msgs = null;
            if (rootFeature != null)
                msgs = ((InternalEObject)rootFeature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE, null, msgs);
            if (newRootFeature != null)
                msgs = ((InternalEObject)newRootFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE, null, msgs);
            msgs = basicSetRootFeature(newRootFeature, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE, newRootFeature, newRootFeature));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<Feature> getOrphanedFeatures() {
        if (orphanedFeatures == null) {
            orphanedFeatures = new EObjectContainmentEList<Feature>(Feature.class, this, FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES);
        }
        return orphanedFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<Constraint> getConstraints() {
        if (constraints == null) {
            constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS);
        }
        return constraints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE:
                return basicSetRootFeature(null, msgs);
            case FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES:
                return ((InternalEList<?>)getOrphanedFeatures()).basicRemove(otherEnd, msgs);
            case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
                return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
            case FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE:
                return getRootFeature();
            case FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES:
                return getOrphanedFeatures();
            case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
                return getConstraints();
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
            case FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE:
                setRootFeature((Feature)newValue);
                return;
            case FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES:
                getOrphanedFeatures().clear();
                getOrphanedFeatures().addAll((Collection<? extends Feature>)newValue);
                return;
            case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
                getConstraints().clear();
                getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
            case FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE:
                setRootFeature((Feature)null);
                return;
            case FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES:
                getOrphanedFeatures().clear();
                return;
            case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
                getConstraints().clear();
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
            case FeatureModelPackage.FEATURE_MODEL__ROOT_FEATURE:
                return rootFeature != null;
            case FeatureModelPackage.FEATURE_MODEL__ORPHANED_FEATURES:
                return orphanedFeatures != null && !orphanedFeatures.isEmpty();
            case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
                return constraints != null && !constraints.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FeatureModelImpl
