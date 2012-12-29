/**
 */
package cz.jpikl.yafmt.models.featuremodel.impl;

import cz.jpikl.yafmt.models.featuremodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureModelFactoryImpl extends EFactoryImpl implements FeatureModelFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FeatureModelFactory init() {
        try {
            FeatureModelFactory theFeatureModelFactory = (FeatureModelFactory)EPackage.Registry.INSTANCE.getEFactory("https://bitbucket.org/jpikl/yafmt/featuremodel.ecore");
            if (theFeatureModelFactory != null) {
                return theFeatureModelFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FeatureModelFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case FeatureModelPackage.CONSTRAINT: return createConstraint();
            case FeatureModelPackage.FEATURE: return createFeature();
            case FeatureModelPackage.FEATURE_MODEL: return createFeatureModel();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Constraint createConstraint() {
        ConstraintImpl constraint = new ConstraintImpl();
        return constraint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Feature createFeature() {
        FeatureImpl feature = new FeatureImpl();
        return feature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModel createFeatureModel() {
        FeatureModelImpl featureModel = new FeatureModelImpl();
        return featureModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModelPackage getFeatureModelPackage() {
        return (FeatureModelPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FeatureModelPackage getPackage() {
        return FeatureModelPackage.eINSTANCE;
    }

} //FeatureModelFactoryImpl
