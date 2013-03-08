package cz.jpikl.yafmt.clang.scl;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class SimpleConstraintLanguageStandaloneSetup extends SimpleConstraintLanguageStandaloneSetupGenerated {

    public static void doSetup() {
        new SimpleConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
