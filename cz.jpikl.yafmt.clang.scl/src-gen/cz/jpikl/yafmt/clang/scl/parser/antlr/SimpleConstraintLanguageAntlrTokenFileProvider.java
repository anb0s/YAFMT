/*
* generated by Xtext
*/
package cz.jpikl.yafmt.clang.scl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SimpleConstraintLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.tokens");
	}
}