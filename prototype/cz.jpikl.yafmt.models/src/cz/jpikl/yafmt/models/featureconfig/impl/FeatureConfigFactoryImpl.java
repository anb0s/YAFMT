/**
 */
package cz.jpikl.yafmt.models.featureconfig.impl;

import cz.jpikl.yafmt.models.featureconfig.*;

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
public class FeatureConfigFactoryImpl extends EFactoryImpl implements FeatureConfigFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FeatureConfigFactory init() {
        try {
            FeatureConfigFactory theFeatureConfigFactory = (FeatureConfigFactory)EPackage.Registry.INSTANCE.getEFactory("https://bitbucket.org/jpikl/yafmt/featureconfig.ecore"); 
            if (theFeatureConfigFactory != null) {
                return theFeatureConfigFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FeatureConfigFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfigFactoryImpl() {
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
            case FeatureConfigPackage.FEATURE_CONFIGURATION: return createFeatureConfiguration();
            case FeatureConfigPackage.SELECTION: return createSelection();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfiguration createFeatureConfiguration() {
        FeatureConfigurationImpl featureConfiguration = new FeatureConfigurationImpl();
        return featureConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selection createSelection() {
        SelectionImpl selection = new SelectionImpl();
        return selection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureConfigPackage getFeatureConfigPackage() {
        return (FeatureConfigPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FeatureConfigPackage getPackage() {
        return FeatureConfigPackage.eINSTANCE;
    }

} //FeatureConfigFactoryImpl
