package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FeatureConfigurationEditorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui.editors.fc"; //$NON-NLS-1$

	// The shared instance
	private static FeatureConfigurationEditorPlugin plugin;
	
	/**
	 * The constructor
	 */
	public FeatureConfigurationEditorPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FeatureConfigurationEditorPlugin getDefault() {
		return plugin;
	}

}
