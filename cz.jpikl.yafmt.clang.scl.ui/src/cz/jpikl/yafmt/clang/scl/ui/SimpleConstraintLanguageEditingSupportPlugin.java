package cz.jpikl.yafmt.clang.scl.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import cz.jpikl.yafmt.clang.scl.ui.internal.SimpleConstraintLanguageActivator;

public class SimpleConstraintLanguageEditingSupportPlugin extends SimpleConstraintLanguageActivator {

    private static final String PLUGIN_ID = "cz.jpikl.yafmt.clang.scl.ui";

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + path);
    }

    private void registerImage(ImageRegistry registry, String name) {
        registry.put(name, getImageDescriptor(name).createImage());
    }
    
    @Override
    protected void initializeImageRegistry(ImageRegistry registry) {
        registerImage(registry, "id.png");
    }

}
