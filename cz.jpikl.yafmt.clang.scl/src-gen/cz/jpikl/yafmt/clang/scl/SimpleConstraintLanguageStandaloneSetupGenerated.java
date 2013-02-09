
package cz.jpikl.yafmt.clang.scl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
@SuppressWarnings("all")
public class SimpleConstraintLanguageStandaloneSetupGenerated implements ISetup {

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new cz.jpikl.yafmt.clang.scl.SimpleConstraintLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("https://bitbucket.org/jpikl/yafmt/clang/scl")) {
		EPackage.Registry.INSTANCE.put("https://bitbucket.org/jpikl/yafmt/clang/scl", cz.jpikl.yafmt.clang.scl.model.ModelPackage.eINSTANCE);
	}

	}
}
