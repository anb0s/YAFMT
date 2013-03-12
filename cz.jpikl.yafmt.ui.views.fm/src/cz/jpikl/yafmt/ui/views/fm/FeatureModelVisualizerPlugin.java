package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class FeatureModelVisualizerPlugin extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "cz.jpikl.yafmt.ui.views.fm"; //$NON-NLS-1$

    private static FeatureModelVisualizerPlugin plugin;

    public FeatureModelVisualizerPlugin() {
    }

    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static FeatureModelVisualizerPlugin getDefault() {
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
        registerImage(registry, "attribute-decoration");
        registerImage(registry, "constraint");
        registerImage(registry, "constraint-decoration");
        registerImage(registry, "group");
        registerImage(registry, "group-decoration");
        registerImage(registry, "lock");
    }

}
