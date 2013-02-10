package cz.jpikl.yafmt.clang.scl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cz.jpikl.yafmt.clang.ConstraintLanguage;
import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.parser.antlr.SimpleConstraintLanguageParser;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class SimpleConstraintLanguage extends ConstraintLanguage {

    private static SimpleConstraintLanguageParser parser;
    
    public static SimpleConstraintLanguageParser getParser() {
        if(parser == null) {
            // Use dependency injection when creating parser.
            Injector injector = Guice.createInjector(new SimpleConstraintLanguageRuntimeModule());
            parser = injector.getInstance(SimpleConstraintLanguageParser.class);
        }
        return parser;
    }
    
    private Expression parseConstraint(Constraint constraint) throws ConstraintLanguageException {
        IParseResult result; 
        
        try {
            result = getParser().doParse(constraint.getValue());
        }
        catch(RuntimeException ex) {
            throw new ConstraintLanguageException(constraint, "Unexpected error: " + ex.getMessage());
        }
        
        if(result.hasSyntaxErrors()) {
            // Get only the first error message.
            String message = result.getSyntaxErrors().iterator().next().getSyntaxErrorMessage().getMessage();
            throw new ConstraintLanguageException(constraint, message);
        }
        
        EObject astRoot = result.getRootASTElement();
        if(!(astRoot instanceof Expression))
            throw new ConstraintLanguageException(constraint, "Empty input");
        return (Expression) astRoot;
    }
    
    private String validateEvaluator(SimpleConstraintLanguageEvaluator evaluator, FeatureModel featureModel) {
        if(featureModel == null)
            return null;
        
        List<String> ids = evaluator.getMissingFeatures(featureModel);
        if((ids == null) || ids.isEmpty())
            return null;
        
        if(ids.size() == 1)
            return "Nonexistent feature ID: " + ids.get(0);
        
        StringBuilder builder = new StringBuilder("Nonexistent feature IDs: ");
        for(int i = 0; i < ids.size(); i++) {
            if(i != 0)
                builder.append(", ");
            builder.append(ids.get(i));
        }
        return builder.toString();
    }
    
    @Override
    public IEvaluator createEvaluator(Constraint constraint) throws ConstraintLanguageException {
        if(constraint == null)
            throw new IllegalArgumentException("Cannot create IEvaluator for null constraint");
        
        Expression expression = parseConstraint(constraint);
        SimpleConstraintLanguageEvaluator evaluator = new SimpleConstraintLanguageEvaluator(expression);
        
        String error = validateEvaluator(evaluator, constraint.getFeatureModel());
        if(error != null)
            throw new ConstraintLanguageException(constraint, error);
        
        return evaluator;
    }

}
