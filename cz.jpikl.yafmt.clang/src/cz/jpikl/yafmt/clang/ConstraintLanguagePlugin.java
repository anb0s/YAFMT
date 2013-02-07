package cz.jpikl.yafmt.clang;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class ConstraintLanguagePlugin extends Plugin {

    public static final String ID = "cz.jpikl.yafmt.clang";
    private static final String EXTENSION_POINT_ID = "cz.jpikl.yafmt.clang";
	private static ConstraintLanguagePlugin instance;
	
	public static ConstraintLanguagePlugin getDefault() {
        return instance;
    }
    
	private ConstraintLanguageRegistry registry;
    
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		instance = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
	    instance = null;
		super.stop(bundleContext);
	}
	
	public void logError(String message, Exception ex) {
        getLog().log(new Status(Status.ERROR, ID, message, ex));
    }
	
	public ConstraintLanguageRegistry getConstraintLanguageRegistry() {
	    if(registry == null) {
	        IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
	        for(IConfigurationElement element: extensionRegistry.getConfigurationElementsFor(EXTENSION_POINT_ID)) {
	            try {
	                registry.putDescriptor(new ConstraintLanguageDescriptor(element));
	            }
	            catch(Exception ex) {
	                logError("Invalid " + EXTENSION_POINT_ID + " extension point element.", ex);
	            }
	        }
	    }
	    
	    return registry;
	}

}
