package cz.jpikl.yafmt.clang.bcl;

import cz.jpikl.yafmt.clang.bcl.BooleanConstraintLanguageStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class BooleanConstraintLanguageStandaloneSetup extends BooleanConstraintLanguageStandaloneSetupGenerated {

    public static void doSetup() {
        new BooleanConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
