package cz.jpikl.yafmt.clang.scl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleConstraintLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "':'", "'implies'", "'or'", "'xor'", "'and'", "'not'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSimpleConstraintLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleConstraintLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleConstraintLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g"; }


     
     	private SimpleConstraintLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(SimpleConstraintLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:60:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:61:1: ( ruleExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:62:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression61);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:69:1: ruleExpression : ( ruleContextualExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:73:2: ( ( ruleContextualExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:74:1: ( ruleContextualExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:74:1: ( ruleContextualExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:75:1: ruleContextualExpression
            {
             before(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_ruleExpression94);
            ruleContextualExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleContextualExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:88:1: entryRuleContextualExpression : ruleContextualExpression EOF ;
    public final void entryRuleContextualExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:89:1: ( ruleContextualExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:90:1: ruleContextualExpression EOF
            {
             before(grammarAccess.getContextualExpressionRule()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression120);
            ruleContextualExpression();

            state._fsp--;

             after(grammarAccess.getContextualExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextualExpression127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContextualExpression"


    // $ANTLR start "ruleContextualExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:97:1: ruleContextualExpression : ( ( rule__ContextualExpression__Alternatives ) ) ;
    public final void ruleContextualExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:101:2: ( ( ( rule__ContextualExpression__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:103:1: ( rule__ContextualExpression__Alternatives )
            {
             before(grammarAccess.getContextualExpressionAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:104:1: ( rule__ContextualExpression__Alternatives )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:104:2: rule__ContextualExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Alternatives_in_ruleContextualExpression153);
            rule__ContextualExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextualExpression"


    // $ANTLR start "entryRuleImplication"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:116:1: entryRuleImplication : ruleImplication EOF ;
    public final void entryRuleImplication() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:117:1: ( ruleImplication EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:118:1: ruleImplication EOF
            {
             before(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication180);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getImplicationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication187); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImplication"


    // $ANTLR start "ruleImplication"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:125:1: ruleImplication : ( ( rule__Implication__Group__0 ) ) ;
    public final void ruleImplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:129:2: ( ( ( rule__Implication__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:130:1: ( ( rule__Implication__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:130:1: ( ( rule__Implication__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:131:1: ( rule__Implication__Group__0 )
            {
             before(grammarAccess.getImplicationAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:132:1: ( rule__Implication__Group__0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:132:2: rule__Implication__Group__0
            {
            pushFollow(FOLLOW_rule__Implication__Group__0_in_ruleImplication213);
            rule__Implication__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImplication"


    // $ANTLR start "entryRuleDisjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:144:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:145:1: ( ruleDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:146:1: ruleDisjunction EOF
            {
             before(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction240);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:153:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:157:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:158:1: ( ( rule__Disjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:158:1: ( ( rule__Disjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:159:1: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:160:1: ( rule__Disjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:160:2: rule__Disjunction__Group__0
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction273);
            rule__Disjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleExclusiveDisjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:172:1: entryRuleExclusiveDisjunction : ruleExclusiveDisjunction EOF ;
    public final void entryRuleExclusiveDisjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:173:1: ( ruleExclusiveDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:174:1: ruleExclusiveDisjunction EOF
            {
             before(grammarAccess.getExclusiveDisjunctionRule()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction300);
            ruleExclusiveDisjunction();

            state._fsp--;

             after(grammarAccess.getExclusiveDisjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveDisjunction307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExclusiveDisjunction"


    // $ANTLR start "ruleExclusiveDisjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:181:1: ruleExclusiveDisjunction : ( ( rule__ExclusiveDisjunction__Group__0 ) ) ;
    public final void ruleExclusiveDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:185:2: ( ( ( rule__ExclusiveDisjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:186:1: ( ( rule__ExclusiveDisjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:186:1: ( ( rule__ExclusiveDisjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:187:1: ( rule__ExclusiveDisjunction__Group__0 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:188:1: ( rule__ExclusiveDisjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:188:2: rule__ExclusiveDisjunction__Group__0
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0_in_ruleExclusiveDisjunction333);
            rule__ExclusiveDisjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExclusiveDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:200:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:201:1: ( ruleConjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:202:1: ruleConjunction EOF
            {
             before(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction360);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:209:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:213:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:215:1: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:216:1: ( rule__Conjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:216:2: rule__Conjunction__Group__0
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction393);
            rule__Conjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:228:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:229:1: ( ruleNegation EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:230:1: ruleNegation EOF
            {
             before(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation420);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:237:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:241:2: ( ( ( rule__Negation__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:243:1: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:244:1: ( rule__Negation__Alternatives )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:244:2: rule__Negation__Alternatives
            {
            pushFollow(FOLLOW_rule__Negation__Alternatives_in_ruleNegation453);
            rule__Negation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:256:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:257:1: ( rulePrimaryExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:258:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression480);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:265:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:269:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:271:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:272:1: ( rule__PrimaryExpression__Alternatives )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:272:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression513);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "rule__ContextualExpression__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:284:1: rule__ContextualExpression__Alternatives : ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ruleImplication ) );
    public final void rule__ContextualExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:288:1: ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ruleImplication ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID||(LA1_0>=17 && LA1_0<=18)) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:290:1: ( rule__ContextualExpression__Group_0__0 )
                    {
                     before(grammarAccess.getContextualExpressionAccess().getGroup_0()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:291:1: ( rule__ContextualExpression__Group_0__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:291:2: rule__ContextualExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ContextualExpression__Group_0__0_in_rule__ContextualExpression__Alternatives549);
                    rule__ContextualExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getContextualExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:295:6: ( ruleImplication )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:295:6: ( ruleImplication )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:296:1: ruleImplication
                    {
                     before(grammarAccess.getContextualExpressionAccess().getImplicationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImplication_in_rule__ContextualExpression__Alternatives567);
                    ruleImplication();

                    state._fsp--;

                     after(grammarAccess.getContextualExpressionAccess().getImplicationParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Alternatives"


    // $ANTLR start "rule__Negation__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:306:1: rule__Negation__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:310:1: ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:311:1: ( rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:311:1: ( rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:312:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives599);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:317:6: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:317:6: ( ( rule__Negation__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:318:1: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:319:1: ( rule__Negation__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:319:2: rule__Negation__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives616);
                    rule__Negation__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNegationAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:328:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:332:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:333:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:333:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:334:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:335:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:335:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives649);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:339:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:339:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:340:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:341:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:341:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives667);
                    rule__PrimaryExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__ContextualExpression__Group_0__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:352:1: rule__ContextualExpression__Group_0__0 : rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 ;
    public final void rule__ContextualExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:356:1: ( rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:357:2: rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__0698);
            rule__ContextualExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__0701);
            rule__ContextualExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__0"


    // $ANTLR start "rule__ContextualExpression__Group_0__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:364:1: rule__ContextualExpression__Group_0__0__Impl : ( 'context' ) ;
    public final void rule__ContextualExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:368:1: ( ( 'context' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:369:1: ( 'context' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:369:1: ( 'context' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:370:1: 'context'
            {
             before(grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0()); 
            match(input,11,FOLLOW_11_in_rule__ContextualExpression__Group_0__0__Impl729); 
             after(grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__0__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:383:1: rule__ContextualExpression__Group_0__1 : rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 ;
    public final void rule__ContextualExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:387:1: ( rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:388:2: rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__1760);
            rule__ContextualExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__1763);
            rule__ContextualExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__1"


    // $ANTLR start "rule__ContextualExpression__Group_0__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:395:1: rule__ContextualExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__ContextualExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:399:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:400:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:400:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:401:1: ()
            {
             before(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:402:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:404:1: 
            {
            }

             after(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__1__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:414:1: rule__ContextualExpression__Group_0__2 : rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 ;
    public final void rule__ContextualExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:418:1: ( rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:419:2: rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__2821);
            rule__ContextualExpression__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__2824);
            rule__ContextualExpression__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__2"


    // $ANTLR start "rule__ContextualExpression__Group_0__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:426:1: rule__ContextualExpression__Group_0__2__Impl : ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) ;
    public final void rule__ContextualExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:430:1: ( ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:431:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:431:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:432:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:433:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:433:2: rule__ContextualExpression__ContextIdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl851);
            rule__ContextualExpression__ContextIdAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__2__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__3"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:443:1: rule__ContextualExpression__Group_0__3 : rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 ;
    public final void rule__ContextualExpression__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:447:1: ( rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:448:2: rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__3881);
            rule__ContextualExpression__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__3884);
            rule__ContextualExpression__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__3"


    // $ANTLR start "rule__ContextualExpression__Group_0__3__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:455:1: rule__ContextualExpression__Group_0__3__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:459:1: ( ( ':' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:460:1: ( ':' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:460:1: ( ':' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:461:1: ':'
            {
             before(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); 
            match(input,12,FOLLOW_12_in_rule__ContextualExpression__Group_0__3__Impl912); 
             after(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__3__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__4"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:474:1: rule__ContextualExpression__Group_0__4 : rule__ContextualExpression__Group_0__4__Impl ;
    public final void rule__ContextualExpression__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:478:1: ( rule__ContextualExpression__Group_0__4__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:479:2: rule__ContextualExpression__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__4943);
            rule__ContextualExpression__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__4"


    // $ANTLR start "rule__ContextualExpression__Group_0__4__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:485:1: rule__ContextualExpression__Group_0__4__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) ;
    public final void rule__ContextualExpression__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:489:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:490:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:490:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:491:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:492:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:492:2: rule__ContextualExpression__ExpressionAssignment_0_4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl970);
            rule__ContextualExpression__ExpressionAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__4__Impl"


    // $ANTLR start "rule__Implication__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:512:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:516:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:517:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
            {
            pushFollow(FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01010);
            rule__Implication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01013);
            rule__Implication__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0"


    // $ANTLR start "rule__Implication__Group__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:524:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:528:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:529:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:529:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:530:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1040);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0__Impl"


    // $ANTLR start "rule__Implication__Group__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:541:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:545:1: ( rule__Implication__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:546:2: rule__Implication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11069);
            rule__Implication__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1"


    // $ANTLR start "rule__Implication__Group__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:552:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )? ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:556:1: ( ( ( rule__Implication__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:557:1: ( ( rule__Implication__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:557:1: ( ( rule__Implication__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:558:1: ( rule__Implication__Group_1__0 )?
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:559:1: ( rule__Implication__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:559:2: rule__Implication__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1096);
                    rule__Implication__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImplicationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:573:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:577:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:578:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01131);
            rule__Implication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01134);
            rule__Implication__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0"


    // $ANTLR start "rule__Implication__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:585:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:589:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:590:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:590:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:591:1: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:592:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:594:1: 
            {
            }

             after(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0__Impl"


    // $ANTLR start "rule__Implication__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:604:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:608:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:609:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11192);
            rule__Implication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11195);
            rule__Implication__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1"


    // $ANTLR start "rule__Implication__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:616:1: rule__Implication__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:620:1: ( ( 'implies' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:621:1: ( 'implies' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:621:1: ( 'implies' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:622:1: 'implies'
            {
             before(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); 
            match(input,13,FOLLOW_13_in_rule__Implication__Group_1__1__Impl1223); 
             after(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:635:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:639:1: ( rule__Implication__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:640:2: rule__Implication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21254);
            rule__Implication__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2"


    // $ANTLR start "rule__Implication__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:646:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightPartAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:650:1: ( ( ( rule__Implication__RightPartAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:651:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:651:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:652:1: ( rule__Implication__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:653:1: ( rule__Implication__RightPartAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:653:2: rule__Implication__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1281);
            rule__Implication__RightPartAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2__Impl"


    // $ANTLR start "rule__Disjunction__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:669:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:673:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:674:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01317);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01320);
            rule__Disjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0"


    // $ANTLR start "rule__Disjunction__Group__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:681:1: rule__Disjunction__Group__0__Impl : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:685:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:686:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:686:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:687:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1347);
            ruleExclusiveDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0__Impl"


    // $ANTLR start "rule__Disjunction__Group__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:698:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:702:1: ( rule__Disjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:703:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11376);
            rule__Disjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1"


    // $ANTLR start "rule__Disjunction__Group__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:709:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:713:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:714:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:714:1: ( ( rule__Disjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:715:1: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:716:1: ( rule__Disjunction__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:716:2: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1403);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:730:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:734:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:735:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01438);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01441);
            rule__Disjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:742:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:746:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:747:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:747:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:748:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:749:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:751:1: 
            {
            }

             after(grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:761:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:765:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:766:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11499);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11502);
            rule__Disjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:773:1: rule__Disjunction__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:777:1: ( ( 'or' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:778:1: ( 'or' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:778:1: ( 'or' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:779:1: 'or'
            {
             before(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); 
            match(input,14,FOLLOW_14_in_rule__Disjunction__Group_1__1__Impl1530); 
             after(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:792:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:796:1: ( rule__Disjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:797:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21561);
            rule__Disjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2"


    // $ANTLR start "rule__Disjunction__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:803:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:807:1: ( ( ( rule__Disjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:808:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:808:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:809:1: ( rule__Disjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:810:1: ( rule__Disjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:810:2: rule__Disjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1588);
            rule__Disjunction__PartsAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:826:1: rule__ExclusiveDisjunction__Group__0 : rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 ;
    public final void rule__ExclusiveDisjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:830:1: ( rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:831:2: rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01624);
            rule__ExclusiveDisjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01627);
            rule__ExclusiveDisjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group__0"


    // $ANTLR start "rule__ExclusiveDisjunction__Group__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:838:1: rule__ExclusiveDisjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:842:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:843:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:843:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:844:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1654);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group__0__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:855:1: rule__ExclusiveDisjunction__Group__1 : rule__ExclusiveDisjunction__Group__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:859:1: ( rule__ExclusiveDisjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:860:2: rule__ExclusiveDisjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11683);
            rule__ExclusiveDisjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group__1"


    // $ANTLR start "rule__ExclusiveDisjunction__Group__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:866:1: rule__ExclusiveDisjunction__Group__1__Impl : ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) ;
    public final void rule__ExclusiveDisjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:870:1: ( ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:871:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:871:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:872:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:873:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:873:2: rule__ExclusiveDisjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1710);
            	    rule__ExclusiveDisjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group__1__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:887:1: rule__ExclusiveDisjunction__Group_1__0 : rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 ;
    public final void rule__ExclusiveDisjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:891:1: ( rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:892:2: rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01745);
            rule__ExclusiveDisjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01748);
            rule__ExclusiveDisjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__0"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:899:1: rule__ExclusiveDisjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__ExclusiveDisjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:903:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:904:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:904:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:905:1: ()
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:906:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:908:1: 
            {
            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__0__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:918:1: rule__ExclusiveDisjunction__Group_1__1 : rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 ;
    public final void rule__ExclusiveDisjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:922:1: ( rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:923:2: rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__11806);
            rule__ExclusiveDisjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__11809);
            rule__ExclusiveDisjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__1"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:930:1: rule__ExclusiveDisjunction__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__ExclusiveDisjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:934:1: ( ( 'xor' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:935:1: ( 'xor' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:935:1: ( 'xor' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:936:1: 'xor'
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1()); 
            match(input,15,FOLLOW_15_in_rule__ExclusiveDisjunction__Group_1__1__Impl1837); 
             after(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__1__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:949:1: rule__ExclusiveDisjunction__Group_1__2 : rule__ExclusiveDisjunction__Group_1__2__Impl ;
    public final void rule__ExclusiveDisjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:953:1: ( rule__ExclusiveDisjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:954:2: rule__ExclusiveDisjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__21868);
            rule__ExclusiveDisjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__2"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:960:1: rule__ExclusiveDisjunction__Group_1__2__Impl : ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:964:1: ( ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:965:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:965:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:966:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:967:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:967:2: rule__ExclusiveDisjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl1895);
            rule__ExclusiveDisjunction__PartsAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:983:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:987:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:988:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__01931);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__01934);
            rule__Conjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0"


    // $ANTLR start "rule__Conjunction__Group__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:995:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:999:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1000:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1000:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1001:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl1961);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0__Impl"


    // $ANTLR start "rule__Conjunction__Group__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1012:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1016:1: ( rule__Conjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1017:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__11990);
            rule__Conjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1"


    // $ANTLR start "rule__Conjunction__Group__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1023:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1027:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1028:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1028:1: ( ( rule__Conjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1029:1: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1030:1: ( rule__Conjunction__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1030:2: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2017);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1044:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1048:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1049:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02052);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02055);
            rule__Conjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0"


    // $ANTLR start "rule__Conjunction__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1056:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1060:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1061:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1061:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1062:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1063:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1065:1: 
            {
            }

             after(grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1075:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1079:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1080:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12113);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12116);
            rule__Conjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1"


    // $ANTLR start "rule__Conjunction__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1087:1: rule__Conjunction__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1091:1: ( ( 'and' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1092:1: ( 'and' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1092:1: ( 'and' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1093:1: 'and'
            {
             before(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); 
            match(input,16,FOLLOW_16_in_rule__Conjunction__Group_1__1__Impl2144); 
             after(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1106:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1110:1: ( rule__Conjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1111:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22175);
            rule__Conjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2"


    // $ANTLR start "rule__Conjunction__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1117:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1121:1: ( ( ( rule__Conjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1122:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1122:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1123:1: ( rule__Conjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1124:1: ( rule__Conjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1124:2: rule__Conjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2202);
            rule__Conjunction__PartsAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getPartsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Negation__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1140:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1144:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1145:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02238);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02241);
            rule__Negation__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0"


    // $ANTLR start "rule__Negation__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1152:1: rule__Negation__Group_1__0__Impl : ( 'not' ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1156:1: ( ( 'not' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1157:1: ( 'not' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1157:1: ( 'not' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1158:1: 'not'
            {
             before(grammarAccess.getNegationAccess().getNotKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__Negation__Group_1__0__Impl2269); 
             after(grammarAccess.getNegationAccess().getNotKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0__Impl"


    // $ANTLR start "rule__Negation__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1171:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1175:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1176:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12300);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12303);
            rule__Negation__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1"


    // $ANTLR start "rule__Negation__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1183:1: rule__Negation__Group_1__1__Impl : ( () ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1187:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1188:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1188:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1189:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1190:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1192:1: 
            {
            }

             after(grammarAccess.getNegationAccess().getNegationAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1__Impl"


    // $ANTLR start "rule__Negation__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1202:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1206:1: ( rule__Negation__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1207:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22361);
            rule__Negation__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2"


    // $ANTLR start "rule__Negation__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1213:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1217:1: ( ( ( rule__Negation__ExpressionAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1218:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1218:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1219:1: ( rule__Negation__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1220:1: ( rule__Negation__ExpressionAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1220:2: rule__Negation__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2388);
            rule__Negation__ExpressionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1236:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1240:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1241:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02424);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02427);
            rule__PrimaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1248:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1252:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1253:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1253:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1254:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1255:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1257:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1267:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1271:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1272:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12485);
            rule__PrimaryExpression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1278:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1282:1: ( ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1283:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1283:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1284:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1285:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1285:2: rule__PrimaryExpression__FeatureIdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2512);
            rule__PrimaryExpression__FeatureIdAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1299:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1303:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1304:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02546);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02549);
            rule__PrimaryExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1311:1: rule__PrimaryExpression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1315:1: ( ( '(' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1316:1: ( '(' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1316:1: ( '(' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1317:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__PrimaryExpression__Group_1__0__Impl2577); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1330:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1334:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1335:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12608);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12611);
            rule__PrimaryExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1342:1: rule__PrimaryExpression__Group_1__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1346:1: ( ( ruleExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1347:1: ( ruleExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1347:1: ( ruleExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1348:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2638);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1359:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1363:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1364:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22667);
            rule__PrimaryExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1370:1: rule__PrimaryExpression__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1374:1: ( ( ')' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1375:1: ( ')' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1375:1: ( ')' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1376:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 
            match(input,19,FOLLOW_19_in_rule__PrimaryExpression__Group_1__2__Impl2695); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ContextualExpression__ContextIdAssignment_0_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1396:1: rule__ContextualExpression__ContextIdAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextIdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1400:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1401:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1401:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1402:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_22737); 
             after(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ContextIdAssignment_0_2"


    // $ANTLR start "rule__ContextualExpression__ExpressionAssignment_0_4"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1411:1: rule__ContextualExpression__ExpressionAssignment_0_4 : ( ruleImplication ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1415:1: ( ( ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1416:1: ( ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1416:1: ( ruleImplication )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1417:1: ruleImplication
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_42768);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ExpressionAssignment_0_4"


    // $ANTLR start "rule__Implication__RightPartAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1426:1: rule__Implication__RightPartAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1430:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1431:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1431:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1432:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_22799);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__RightPartAssignment_1_2"


    // $ANTLR start "rule__Disjunction__PartsAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1441:1: rule__Disjunction__PartsAssignment_1_2 : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1445:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1446:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1446:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1447:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_22830);
            ruleExclusiveDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__PartsAssignment_1_2"


    // $ANTLR start "rule__ExclusiveDisjunction__PartsAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1456:1: rule__ExclusiveDisjunction__PartsAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1460:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1461:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1461:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1462:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_22861);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExclusiveDisjunction__PartsAssignment_1_2"


    // $ANTLR start "rule__Conjunction__PartsAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1471:1: rule__Conjunction__PartsAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1475:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1476:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1476:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1477:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_22892);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__PartsAssignment_1_2"


    // $ANTLR start "rule__Negation__ExpressionAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1486:1: rule__Negation__ExpressionAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__Negation__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1490:1: ( ( rulePrimaryExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1491:1: ( rulePrimaryExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1491:1: ( rulePrimaryExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1492:1: rulePrimaryExpression
            {
             before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_22923);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__ExpressionAssignment_1_2"


    // $ANTLR start "rule__PrimaryExpression__FeatureIdAssignment_0_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1501:1: rule__PrimaryExpression__FeatureIdAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__FeatureIdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1505:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1506:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1506:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1507:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_12954); 
             after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__FeatureIdAssignment_0_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_ruleExpression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextualExpression127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Alternatives_in_ruleContextualExpression153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0_in_ruleImplication213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveDisjunction307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0_in_ruleExclusiveDisjunction333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Alternatives_in_ruleNegation453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__0_in_rule__ContextualExpression__Alternatives549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__ContextualExpression__Alternatives567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__0698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__0701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ContextualExpression__Group_0__0__Impl729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__1760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__2821 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__3881 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ContextualExpression__Group_0__3__Impl912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__4943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01010 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01131 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11192 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Implication__Group_1__1__Impl1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01317 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1403 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01438 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11499 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Disjunction__Group_1__1__Impl1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01624 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1710 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01745 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__11806 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__11809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExclusiveDisjunction__Group_1__1__Impl1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__21868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__01931 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__01934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__11990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2017 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02052 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12113 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Conjunction__Group_1__1__Impl2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02238 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Negation__Group_1__0__Impl2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12300 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02546 = new BitSet(new long[]{0x0000000000060810L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PrimaryExpression__Group_1__0__Impl2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12608 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimaryExpression__Group_1__2__Impl2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_22737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_42768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_22799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_22830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_22861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_22892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_22923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_12954 = new BitSet(new long[]{0x0000000000000002L});

}