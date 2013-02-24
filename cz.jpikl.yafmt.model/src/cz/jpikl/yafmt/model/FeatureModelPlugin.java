/**
 */
package cz.jpikl.yafmt.model;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

import cz.jpikl.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

/**
 * This is the central singleton for the FeatureModel model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class FeatureModelPlugin extends EMFPlugin {
    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final FeatureModelPlugin INSTANCE = new FeatureModelPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureModelPlugin() {
        super(new ResourceLocator [] {});
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EclipsePlugin {
        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
            
            // Register packages and custom resource factories.
            FeatureModelUtil.hookResourceFactoryRegistry();
            FeatureModelUtil.hookPackageRegistry();
            FeatureConfigurationUtil.hookResourceFactoryRegistry();
            FeatureConfigurationUtil.hookPackageRegistry();
        }
        
        @Override
        public void start(BundleContext context) throws Exception {
            // TODO Auto-generated method stub
            super.start(context);
        }
        
    }
    
    
    
}
