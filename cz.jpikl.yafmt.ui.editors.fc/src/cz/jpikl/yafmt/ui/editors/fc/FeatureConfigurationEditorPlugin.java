package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class FeatureConfigurationEditorPlugin extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui.editors.fc"; //$NON-NLS-1$

    private static FeatureConfigurationEditorPlugin plugin;

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

    public static FeatureConfigurationEditorPlugin getDefault() {
        return plugin;
    }

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    private void registerImage(ImageRegistry registry, String key) {
        registry.put(key, getImageDescriptor("icons/" + key + ".png").createImage());
    }

    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        registerImage(registry, "select");
        registerImage(registry, "deselect");
    }

}
