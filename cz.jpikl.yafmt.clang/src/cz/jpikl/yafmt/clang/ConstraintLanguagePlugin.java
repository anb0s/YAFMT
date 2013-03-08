package cz.jpikl.yafmt.clang;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import cz.jpikl.yafmt.clang.ui.EditingSupportRegistry;

public class ConstraintLanguagePlugin extends Plugin {

    public static final String ID = "cz.jpikl.yafmt.clang";
    private static ConstraintLanguagePlugin instance;

    public static ConstraintLanguagePlugin getDefault() {
        return instance;
    }

    private ConstraintLanguageRegistry constraintLanguageRegistry;
    private EditingSupportRegistry editingSupportRegistry;

    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        instance = this;
    }

    public void stop(BundleContext bundleContext) throws Exception {
        instance = null;
        super.stop(bundleContext);
    }

    public ConstraintLanguageRegistry getConstraintLanguageRegistry() {
        if(constraintLanguageRegistry == null)
            constraintLanguageRegistry = new ConstraintLanguageRegistry();
        return constraintLanguageRegistry;
    }

    public EditingSupportRegistry getEditingSupportRegistry() {
        if(editingSupportRegistry == null)
            editingSupportRegistry = new EditingSupportRegistry();
        return editingSupportRegistry;
    }

    public void logError(String message, Exception ex) {
        getLog().log(new Status(Status.ERROR, ID, message, ex));
    }

}
