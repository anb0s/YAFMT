package cz.jpikl.yafmt.clang.scl.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import cz.jpikl.yafmt.clang.scl.ui.internal.SimpleConstraintLanguageActivator;

public class SimpleConstraintLanguageEditingSupportPlugin extends SimpleConstraintLanguageActivator {

    private static final String PLUGIN_ID = "cz.jpikl.yafmt.clang.scl.ui";

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        super.initializeImageRegistry(registry);
        registry.put("id", getImageDescriptor("icons/id.png").createImage());
    }

}
