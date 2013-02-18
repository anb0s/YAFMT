package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.util.DrawConstantans;

/**
 * The activator class controls the plug-in life cycle.
 */
public class FeatureModelEditorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui.editors.fm"; //$NON-NLS-1$

	// The shared instance
	private static FeatureModelEditorPlugin plugin;
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// Register packages and custom resource factories.
        FeatureModelUtil.hookResourceFactoryRegistry();
        FeatureModelUtil.hookPackageRegistry();
        
        DrawConstantans.init();
	}

	public void stop(BundleContext context) throws Exception {
	    DrawConstantans.dispose();
	    
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FeatureModelEditorPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	private void registerImage(ImageRegistry registry, String key) {
        registry.put(key, getImageDescriptor("icons/" + key + ".png").createImage());
    }
	
	@Override
    protected void initializeImageRegistry(ImageRegistry registry) {
	    registerImage(registry, "constraint");
	    registerImage(registry, "left");
	    registerImage(registry, "right");
	    registerImage(registry, "dock-bg");
	    registerImage(registry, "filter-enabled");
	    registerImage(registry, "filter-disabled");
    }
	
}
