package cz.jpikl.yafmt.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import cz.jpikl.yafmt.ui.util.DrawConstantans;

/**
 * The activator class controls the plug-in life cycle
 */
public class CommonUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui"; //$NON-NLS-1$

	// The shared instance
	private static CommonUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CommonUIPlugin() {
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
	    DrawConstantans.dispose();
	    
	    plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static CommonUIPlugin getDefault() {
		return plugin;
	}

}
