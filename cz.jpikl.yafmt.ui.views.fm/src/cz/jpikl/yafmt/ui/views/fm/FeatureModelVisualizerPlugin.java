package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FeatureModelVisualizerPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui.views.fm"; //$NON-NLS-1$

	// The shared instance
	private static FeatureModelVisualizerPlugin plugin;
	
	/**
	 * The constructor
	 */
	public FeatureModelVisualizerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FeatureModelVisualizerPlugin getDefault() {
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
	    registerImage(registry, "constraints-enabled");
        registerImage(registry, "constraints-disabled");
	    registerImage(registry, "groups-enabled");
	    registerImage(registry, "groups-disabled");
	    registerImage(registry, "locked");
	    registerImage(registry, "unlocked");
	    registerImage(registry, "constraint-decoration");
        registerImage(registry, "group-decoration");
	}
	
}
