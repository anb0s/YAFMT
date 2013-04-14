package cz.jpikl.yafmt.clang.bcl.ui.contentassist.antlr.internal; 

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
import cz.jpikl.yafmt.clang.bcl.services.BooleanConstraintLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBooleanConstraintLanguageParser extends AbstractInternalContentAssistParser {
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


        public InternalBooleanConstraintLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBooleanConstraintLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBooleanConstraintLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g"; }


     
     	private BooleanConstraintLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(BooleanConstraintLanguageGrammarAccess grammarAccess) {
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:60:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:61:1: ( ruleExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:62:1: ruleExpression EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:69:1: ruleExpression : ( ruleContextualExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:73:2: ( ( ruleContextualExpression ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:74:1: ( ruleContextualExpression )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:74:1: ( ruleContextualExpression )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:75:1: ruleContextualExpression
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:88:1: entryRuleContextualExpression : ruleContextualExpression EOF ;
    public final void entryRuleContextualExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:89:1: ( ruleContextualExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:90:1: ruleContextualExpression EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:97:1: ruleContextualExpression : ( ( rule__ContextualExpression__Alternatives ) ) ;
    public final void ruleContextualExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:101:2: ( ( ( rule__ContextualExpression__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:103:1: ( rule__ContextualExpression__Alternatives )
            {
             before(grammarAccess.getContextualExpressionAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:104:1: ( rule__ContextualExpression__Alternatives )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:104:2: rule__ContextualExpression__Alternatives
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:116:1: entryRuleImplication : ruleImplication EOF ;
    public final void entryRuleImplication() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:117:1: ( ruleImplication EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:118:1: ruleImplication EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:125:1: ruleImplication : ( ( rule__Implication__Group__0 ) ) ;
    public final void ruleImplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:129:2: ( ( ( rule__Implication__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:130:1: ( ( rule__Implication__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:130:1: ( ( rule__Implication__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:131:1: ( rule__Implication__Group__0 )
            {
             before(grammarAccess.getImplicationAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:132:1: ( rule__Implication__Group__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:132:2: rule__Implication__Group__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:144:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:145:1: ( ruleDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:146:1: ruleDisjunction EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:153:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:157:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:158:1: ( ( rule__Disjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:158:1: ( ( rule__Disjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:159:1: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:160:1: ( rule__Disjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:160:2: rule__Disjunction__Group__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:172:1: entryRuleExclusiveDisjunction : ruleExclusiveDisjunction EOF ;
    public final void entryRuleExclusiveDisjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:173:1: ( ruleExclusiveDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:174:1: ruleExclusiveDisjunction EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:181:1: ruleExclusiveDisjunction : ( ( rule__ExclusiveDisjunction__Group__0 ) ) ;
    public final void ruleExclusiveDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:185:2: ( ( ( rule__ExclusiveDisjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:186:1: ( ( rule__ExclusiveDisjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:186:1: ( ( rule__ExclusiveDisjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:187:1: ( rule__ExclusiveDisjunction__Group__0 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:188:1: ( rule__ExclusiveDisjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:188:2: rule__ExclusiveDisjunction__Group__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:200:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:201:1: ( ruleConjunction EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:202:1: ruleConjunction EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:209:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:213:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:215:1: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:216:1: ( rule__Conjunction__Group__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:216:2: rule__Conjunction__Group__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:228:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:229:1: ( ruleNegation EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:230:1: ruleNegation EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:237:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:241:2: ( ( ( rule__Negation__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:243:1: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:244:1: ( rule__Negation__Alternatives )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:244:2: rule__Negation__Alternatives
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:256:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:257:1: ( rulePrimaryExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:258:1: rulePrimaryExpression EOF
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:265:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:269:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:271:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:272:1: ( rule__PrimaryExpression__Alternatives )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:272:2: rule__PrimaryExpression__Alternatives
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:284:1: rule__ContextualExpression__Alternatives : ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ruleImplication ) );
    public final void rule__ContextualExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:288:1: ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ruleImplication ) )
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:290:1: ( rule__ContextualExpression__Group_0__0 )
                    {
                     before(grammarAccess.getContextualExpressionAccess().getGroup_0()); 
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:291:1: ( rule__ContextualExpression__Group_0__0 )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:291:2: rule__ContextualExpression__Group_0__0
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:295:6: ( ruleImplication )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:295:6: ( ruleImplication )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:296:1: ruleImplication
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:306:1: rule__Negation__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:310:1: ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) )
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:311:1: ( rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:311:1: ( rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:312:1: rulePrimaryExpression
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:317:6: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:317:6: ( ( rule__Negation__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:318:1: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:319:1: ( rule__Negation__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:319:2: rule__Negation__Group_1__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:328:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:332:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:333:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:333:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:334:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:335:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:335:2: rule__PrimaryExpression__Group_0__0
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
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:339:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:339:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:340:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:341:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:341:2: rule__PrimaryExpression__Group_1__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:352:1: rule__ContextualExpression__Group_0__0 : rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 ;
    public final void rule__ContextualExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:356:1: ( rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:357:2: rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:364:1: rule__ContextualExpression__Group_0__0__Impl : ( 'context' ) ;
    public final void rule__ContextualExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:368:1: ( ( 'context' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:369:1: ( 'context' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:369:1: ( 'context' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:370:1: 'context'
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:383:1: rule__ContextualExpression__Group_0__1 : rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 ;
    public final void rule__ContextualExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:387:1: ( rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:388:2: rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:395:1: rule__ContextualExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__ContextualExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:399:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:400:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:400:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:401:1: ()
            {
             before(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:402:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:404:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:414:1: rule__ContextualExpression__Group_0__2 : rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 ;
    public final void rule__ContextualExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:418:1: ( rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:419:2: rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:426:1: rule__ContextualExpression__Group_0__2__Impl : ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) ;
    public final void rule__ContextualExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:430:1: ( ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:431:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:431:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:432:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:433:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:433:2: rule__ContextualExpression__ContextIdAssignment_0_2
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:443:1: rule__ContextualExpression__Group_0__3 : rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 ;
    public final void rule__ContextualExpression__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:447:1: ( rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:448:2: rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:455:1: rule__ContextualExpression__Group_0__3__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:459:1: ( ( ':' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:460:1: ( ':' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:460:1: ( ':' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:461:1: ':'
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:474:1: rule__ContextualExpression__Group_0__4 : rule__ContextualExpression__Group_0__4__Impl ;
    public final void rule__ContextualExpression__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:478:1: ( rule__ContextualExpression__Group_0__4__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:479:2: rule__ContextualExpression__Group_0__4__Impl
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:485:1: rule__ContextualExpression__Group_0__4__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) ;
    public final void rule__ContextualExpression__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:489:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:490:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:490:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:491:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:492:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:492:2: rule__ContextualExpression__ExpressionAssignment_0_4
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:512:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:516:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:517:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:524:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:528:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:529:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:529:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:530:1: ruleDisjunction
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:541:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:545:1: ( rule__Implication__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:546:2: rule__Implication__Group__1__Impl
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:552:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )? ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:556:1: ( ( ( rule__Implication__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:557:1: ( ( rule__Implication__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:557:1: ( ( rule__Implication__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:558:1: ( rule__Implication__Group_1__0 )?
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:559:1: ( rule__Implication__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:559:2: rule__Implication__Group_1__0
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:573:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:577:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:578:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:585:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:589:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:590:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:590:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:591:1: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:592:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:594:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:604:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:608:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:609:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:616:1: rule__Implication__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:620:1: ( ( 'implies' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:621:1: ( 'implies' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:621:1: ( 'implies' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:622:1: 'implies'
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:635:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:639:1: ( rule__Implication__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:640:2: rule__Implication__Group_1__2__Impl
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:646:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightPartAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:650:1: ( ( ( rule__Implication__RightPartAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:651:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:651:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:652:1: ( rule__Implication__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:653:1: ( rule__Implication__RightPartAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:653:2: rule__Implication__RightPartAssignment_1_2
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:669:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:673:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:674:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:681:1: rule__Disjunction__Group__0__Impl : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:685:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:686:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:686:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:687:1: ruleExclusiveDisjunction
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:698:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:702:1: ( rule__Disjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:703:2: rule__Disjunction__Group__1__Impl
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:709:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )? ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:713:1: ( ( ( rule__Disjunction__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:714:1: ( ( rule__Disjunction__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:714:1: ( ( rule__Disjunction__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:715:1: ( rule__Disjunction__Group_1__0 )?
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:716:1: ( rule__Disjunction__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:716:2: rule__Disjunction__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1403);
                    rule__Disjunction__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:730:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:734:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:735:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:742:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:746:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:747:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:747:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:748:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:749:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:751:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:761:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:765:1: ( rule__Disjunction__Group_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:766:2: rule__Disjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11499);
            rule__Disjunction__Group_1__1__Impl();

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:772:1: rule__Disjunction__Group_1__1__Impl : ( ( ( rule__Disjunction__Group_1_1__0 ) ) ( ( rule__Disjunction__Group_1_1__0 )* ) ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:776:1: ( ( ( ( rule__Disjunction__Group_1_1__0 ) ) ( ( rule__Disjunction__Group_1_1__0 )* ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:777:1: ( ( ( rule__Disjunction__Group_1_1__0 ) ) ( ( rule__Disjunction__Group_1_1__0 )* ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:777:1: ( ( ( rule__Disjunction__Group_1_1__0 ) ) ( ( rule__Disjunction__Group_1_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:778:1: ( ( rule__Disjunction__Group_1_1__0 ) ) ( ( rule__Disjunction__Group_1_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:778:1: ( ( rule__Disjunction__Group_1_1__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:779:1: ( rule__Disjunction__Group_1_1__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:780:1: ( rule__Disjunction__Group_1_1__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:780:2: rule__Disjunction__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1_1__0_in_rule__Disjunction__Group_1__1__Impl1528);
            rule__Disjunction__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 

            }

            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:783:1: ( ( rule__Disjunction__Group_1_1__0 )* )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:784:1: ( rule__Disjunction__Group_1_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:785:1: ( rule__Disjunction__Group_1_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:785:2: rule__Disjunction__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Disjunction__Group_1_1__0_in_rule__Disjunction__Group_1__1__Impl1540);
            	    rule__Disjunction__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1_1()); 

            }


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


    // $ANTLR start "rule__Disjunction__Group_1_1__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:800:1: rule__Disjunction__Group_1_1__0 : rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1 ;
    public final void rule__Disjunction__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:804:1: ( rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:805:2: rule__Disjunction__Group_1_1__0__Impl rule__Disjunction__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1_1__0__Impl_in_rule__Disjunction__Group_1_1__01577);
            rule__Disjunction__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1_1__1_in_rule__Disjunction__Group_1_1__01580);
            rule__Disjunction__Group_1_1__1();

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
    // $ANTLR end "rule__Disjunction__Group_1_1__0"


    // $ANTLR start "rule__Disjunction__Group_1_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:812:1: rule__Disjunction__Group_1_1__0__Impl : ( 'or' ) ;
    public final void rule__Disjunction__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:816:1: ( ( 'or' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:817:1: ( 'or' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:817:1: ( 'or' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:818:1: 'or'
            {
             before(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0()); 
            match(input,14,FOLLOW_14_in_rule__Disjunction__Group_1_1__0__Impl1608); 
             after(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0()); 

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
    // $ANTLR end "rule__Disjunction__Group_1_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1_1__1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:831:1: rule__Disjunction__Group_1_1__1 : rule__Disjunction__Group_1_1__1__Impl ;
    public final void rule__Disjunction__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:835:1: ( rule__Disjunction__Group_1_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:836:2: rule__Disjunction__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1_1__1__Impl_in_rule__Disjunction__Group_1_1__11639);
            rule__Disjunction__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__Disjunction__Group_1_1__1"


    // $ANTLR start "rule__Disjunction__Group_1_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:842:1: rule__Disjunction__Group_1_1__1__Impl : ( ( rule__Disjunction__PartsAssignment_1_1_1 ) ) ;
    public final void rule__Disjunction__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:846:1: ( ( ( rule__Disjunction__PartsAssignment_1_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:847:1: ( ( rule__Disjunction__PartsAssignment_1_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:847:1: ( ( rule__Disjunction__PartsAssignment_1_1_1 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:848:1: ( rule__Disjunction__PartsAssignment_1_1_1 )
            {
             before(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:849:1: ( rule__Disjunction__PartsAssignment_1_1_1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:849:2: rule__Disjunction__PartsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__Disjunction__PartsAssignment_1_1_1_in_rule__Disjunction__Group_1_1__1__Impl1666);
            rule__Disjunction__PartsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_1_1()); 

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
    // $ANTLR end "rule__Disjunction__Group_1_1__1__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:863:1: rule__ExclusiveDisjunction__Group__0 : rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 ;
    public final void rule__ExclusiveDisjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:867:1: ( rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:868:2: rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01700);
            rule__ExclusiveDisjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01703);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:875:1: rule__ExclusiveDisjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:879:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:880:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:880:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:881:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1730);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:892:1: rule__ExclusiveDisjunction__Group__1 : rule__ExclusiveDisjunction__Group__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:896:1: ( rule__ExclusiveDisjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:897:2: rule__ExclusiveDisjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11759);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:903:1: rule__ExclusiveDisjunction__Group__1__Impl : ( ( rule__ExclusiveDisjunction__Group_1__0 )? ) ;
    public final void rule__ExclusiveDisjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:907:1: ( ( ( rule__ExclusiveDisjunction__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:908:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:908:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:909:1: ( rule__ExclusiveDisjunction__Group_1__0 )?
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:910:1: ( rule__ExclusiveDisjunction__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:910:2: rule__ExclusiveDisjunction__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1786);
                    rule__ExclusiveDisjunction__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:924:1: rule__ExclusiveDisjunction__Group_1__0 : rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 ;
    public final void rule__ExclusiveDisjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:928:1: ( rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:929:2: rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01821);
            rule__ExclusiveDisjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01824);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:936:1: rule__ExclusiveDisjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__ExclusiveDisjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:940:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:941:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:941:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:942:1: ()
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:943:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:945:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:955:1: rule__ExclusiveDisjunction__Group_1__1 : rule__ExclusiveDisjunction__Group_1__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:959:1: ( rule__ExclusiveDisjunction__Group_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:960:2: rule__ExclusiveDisjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__11882);
            rule__ExclusiveDisjunction__Group_1__1__Impl();

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:966:1: rule__ExclusiveDisjunction__Group_1__1__Impl : ( ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) ) ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:970:1: ( ( ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) ) ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:971:1: ( ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) ) ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:971:1: ( ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) ) ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:972:1: ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) ) ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:972:1: ( ( rule__ExclusiveDisjunction__Group_1_1__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:973:1: ( rule__ExclusiveDisjunction__Group_1_1__0 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:974:1: ( rule__ExclusiveDisjunction__Group_1_1__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:974:2: rule__ExclusiveDisjunction__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0_in_rule__ExclusiveDisjunction__Group_1__1__Impl1911);
            rule__ExclusiveDisjunction__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1_1()); 

            }

            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:977:1: ( ( rule__ExclusiveDisjunction__Group_1_1__0 )* )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:978:1: ( rule__ExclusiveDisjunction__Group_1_1__0 )*
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:979:1: ( rule__ExclusiveDisjunction__Group_1_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:979:2: rule__ExclusiveDisjunction__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0_in_rule__ExclusiveDisjunction__Group_1__1__Impl1923);
            	    rule__ExclusiveDisjunction__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1_1()); 

            }


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


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1_1__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:994:1: rule__ExclusiveDisjunction__Group_1_1__0 : rule__ExclusiveDisjunction__Group_1_1__0__Impl rule__ExclusiveDisjunction__Group_1_1__1 ;
    public final void rule__ExclusiveDisjunction__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:998:1: ( rule__ExclusiveDisjunction__Group_1_1__0__Impl rule__ExclusiveDisjunction__Group_1_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:999:2: rule__ExclusiveDisjunction__Group_1_1__0__Impl rule__ExclusiveDisjunction__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1_1__01960);
            rule__ExclusiveDisjunction__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1_1__1_in_rule__ExclusiveDisjunction__Group_1_1__01963);
            rule__ExclusiveDisjunction__Group_1_1__1();

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
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1_1__0"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1006:1: rule__ExclusiveDisjunction__Group_1_1__0__Impl : ( 'xor' ) ;
    public final void rule__ExclusiveDisjunction__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1010:1: ( ( 'xor' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1011:1: ( 'xor' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1011:1: ( 'xor' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1012:1: 'xor'
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0()); 
            match(input,15,FOLLOW_15_in_rule__ExclusiveDisjunction__Group_1_1__0__Impl1991); 
             after(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0()); 

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
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1_1__0__Impl"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1_1__1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1025:1: rule__ExclusiveDisjunction__Group_1_1__1 : rule__ExclusiveDisjunction__Group_1_1__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1029:1: ( rule__ExclusiveDisjunction__Group_1_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1030:2: rule__ExclusiveDisjunction__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1_1__12022);
            rule__ExclusiveDisjunction__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1_1__1"


    // $ANTLR start "rule__ExclusiveDisjunction__Group_1_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1036:1: rule__ExclusiveDisjunction__Group_1_1__1__Impl : ( ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1040:1: ( ( ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1041:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1041:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1042:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1043:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_1_1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1043:2: rule__ExclusiveDisjunction__PartsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_1_1_in_rule__ExclusiveDisjunction__Group_1_1__1__Impl2049);
            rule__ExclusiveDisjunction__PartsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_1_1()); 

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
    // $ANTLR end "rule__ExclusiveDisjunction__Group_1_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1057:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1061:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1062:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02083);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02086);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1069:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1073:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1074:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1074:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1075:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2113);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1086:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1090:1: ( rule__Conjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1091:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12142);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1097:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )? ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1101:1: ( ( ( rule__Conjunction__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1102:1: ( ( rule__Conjunction__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1102:1: ( ( rule__Conjunction__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1103:1: ( rule__Conjunction__Group_1__0 )?
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1104:1: ( rule__Conjunction__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1104:2: rule__Conjunction__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2169);
                    rule__Conjunction__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1118:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1122:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1123:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02204);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02207);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1130:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1134:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1135:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1135:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1136:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1137:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1139:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1149:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1153:1: ( rule__Conjunction__Group_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1154:2: rule__Conjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12265);
            rule__Conjunction__Group_1__1__Impl();

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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1160:1: rule__Conjunction__Group_1__1__Impl : ( ( ( rule__Conjunction__Group_1_1__0 ) ) ( ( rule__Conjunction__Group_1_1__0 )* ) ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1164:1: ( ( ( ( rule__Conjunction__Group_1_1__0 ) ) ( ( rule__Conjunction__Group_1_1__0 )* ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1165:1: ( ( ( rule__Conjunction__Group_1_1__0 ) ) ( ( rule__Conjunction__Group_1_1__0 )* ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1165:1: ( ( ( rule__Conjunction__Group_1_1__0 ) ) ( ( rule__Conjunction__Group_1_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1166:1: ( ( rule__Conjunction__Group_1_1__0 ) ) ( ( rule__Conjunction__Group_1_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1166:1: ( ( rule__Conjunction__Group_1_1__0 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1167:1: ( rule__Conjunction__Group_1_1__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1168:1: ( rule__Conjunction__Group_1_1__0 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1168:2: rule__Conjunction__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1_1__0_in_rule__Conjunction__Group_1__1__Impl2294);
            rule__Conjunction__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup_1_1()); 

            }

            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1171:1: ( ( rule__Conjunction__Group_1_1__0 )* )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1172:1: ( rule__Conjunction__Group_1_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1173:1: ( rule__Conjunction__Group_1_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1173:2: rule__Conjunction__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Conjunction__Group_1_1__0_in_rule__Conjunction__Group_1__1__Impl2306);
            	    rule__Conjunction__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1_1()); 

            }


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


    // $ANTLR start "rule__Conjunction__Group_1_1__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1188:1: rule__Conjunction__Group_1_1__0 : rule__Conjunction__Group_1_1__0__Impl rule__Conjunction__Group_1_1__1 ;
    public final void rule__Conjunction__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1192:1: ( rule__Conjunction__Group_1_1__0__Impl rule__Conjunction__Group_1_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1193:2: rule__Conjunction__Group_1_1__0__Impl rule__Conjunction__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1_1__0__Impl_in_rule__Conjunction__Group_1_1__02343);
            rule__Conjunction__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1_1__1_in_rule__Conjunction__Group_1_1__02346);
            rule__Conjunction__Group_1_1__1();

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
    // $ANTLR end "rule__Conjunction__Group_1_1__0"


    // $ANTLR start "rule__Conjunction__Group_1_1__0__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1200:1: rule__Conjunction__Group_1_1__0__Impl : ( 'and' ) ;
    public final void rule__Conjunction__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1204:1: ( ( 'and' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1205:1: ( 'and' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1205:1: ( 'and' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1206:1: 'and'
            {
             before(grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0()); 
            match(input,16,FOLLOW_16_in_rule__Conjunction__Group_1_1__0__Impl2374); 
             after(grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0()); 

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
    // $ANTLR end "rule__Conjunction__Group_1_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1_1__1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1219:1: rule__Conjunction__Group_1_1__1 : rule__Conjunction__Group_1_1__1__Impl ;
    public final void rule__Conjunction__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1223:1: ( rule__Conjunction__Group_1_1__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1224:2: rule__Conjunction__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1_1__1__Impl_in_rule__Conjunction__Group_1_1__12405);
            rule__Conjunction__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__Conjunction__Group_1_1__1"


    // $ANTLR start "rule__Conjunction__Group_1_1__1__Impl"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1230:1: rule__Conjunction__Group_1_1__1__Impl : ( ( rule__Conjunction__PartsAssignment_1_1_1 ) ) ;
    public final void rule__Conjunction__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1234:1: ( ( ( rule__Conjunction__PartsAssignment_1_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1235:1: ( ( rule__Conjunction__PartsAssignment_1_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1235:1: ( ( rule__Conjunction__PartsAssignment_1_1_1 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1236:1: ( rule__Conjunction__PartsAssignment_1_1_1 )
            {
             before(grammarAccess.getConjunctionAccess().getPartsAssignment_1_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1237:1: ( rule__Conjunction__PartsAssignment_1_1_1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1237:2: rule__Conjunction__PartsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__Conjunction__PartsAssignment_1_1_1_in_rule__Conjunction__Group_1_1__1__Impl2432);
            rule__Conjunction__PartsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getPartsAssignment_1_1_1()); 

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
    // $ANTLR end "rule__Conjunction__Group_1_1__1__Impl"


    // $ANTLR start "rule__Negation__Group_1__0"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1251:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1255:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1256:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02466);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02469);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1263:1: rule__Negation__Group_1__0__Impl : ( 'not' ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1267:1: ( ( 'not' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1268:1: ( 'not' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1268:1: ( 'not' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1269:1: 'not'
            {
             before(grammarAccess.getNegationAccess().getNotKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__Negation__Group_1__0__Impl2497); 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1282:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1286:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1287:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12528);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12531);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1294:1: rule__Negation__Group_1__1__Impl : ( () ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1298:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1299:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1299:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1300:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1301:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1303:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1313:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1317:1: ( rule__Negation__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1318:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22589);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1324:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1328:1: ( ( ( rule__Negation__ExpressionAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1329:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1329:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1330:1: ( rule__Negation__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1331:1: ( rule__Negation__ExpressionAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1331:2: rule__Negation__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2616);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1347:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1351:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1352:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02652);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02655);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1359:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1363:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1364:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1364:1: ( () )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1365:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1366:1: ()
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1368:1: 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1378:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1382:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1383:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12713);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1389:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1393:1: ( ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1394:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1394:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1395:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1396:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1396:2: rule__PrimaryExpression__FeatureIdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2740);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1410:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1414:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1415:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02774);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02777);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1422:1: rule__PrimaryExpression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1426:1: ( ( '(' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1427:1: ( '(' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1427:1: ( '(' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1428:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__PrimaryExpression__Group_1__0__Impl2805); 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1441:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1445:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1446:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12836);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12839);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1453:1: rule__PrimaryExpression__Group_1__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1457:1: ( ( ruleExpression ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1458:1: ( ruleExpression )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1458:1: ( ruleExpression )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1459:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2866);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1470:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1474:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1475:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22895);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1481:1: rule__PrimaryExpression__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1485:1: ( ( ')' ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1486:1: ( ')' )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1486:1: ( ')' )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1487:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 
            match(input,19,FOLLOW_19_in_rule__PrimaryExpression__Group_1__2__Impl2923); 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1507:1: rule__ContextualExpression__ContextIdAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextIdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1511:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1512:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1512:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1513:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_22965); 
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1522:1: rule__ContextualExpression__ExpressionAssignment_0_4 : ( ruleImplication ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1526:1: ( ( ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1527:1: ( ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1527:1: ( ruleImplication )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1528:1: ruleImplication
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_42996);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1537:1: rule__Implication__RightPartAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1541:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1542:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1542:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1543:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23027);
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


    // $ANTLR start "rule__Disjunction__PartsAssignment_1_1_1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1552:1: rule__Disjunction__PartsAssignment_1_1_1 : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__PartsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1556:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1557:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1557:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1558:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_1_13058);
            ruleExclusiveDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__Disjunction__PartsAssignment_1_1_1"


    // $ANTLR start "rule__ExclusiveDisjunction__PartsAssignment_1_1_1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1567:1: rule__ExclusiveDisjunction__PartsAssignment_1_1_1 : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__PartsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1571:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1572:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1572:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1573:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_1_13089);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__ExclusiveDisjunction__PartsAssignment_1_1_1"


    // $ANTLR start "rule__Conjunction__PartsAssignment_1_1_1"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1582:1: rule__Conjunction__PartsAssignment_1_1_1 : ( ruleNegation ) ;
    public final void rule__Conjunction__PartsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1586:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1587:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1587:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1588:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_1_13120);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__Conjunction__PartsAssignment_1_1_1"


    // $ANTLR start "rule__Negation__ExpressionAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1597:1: rule__Negation__ExpressionAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__Negation__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1601:1: ( ( rulePrimaryExpression ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1602:1: ( rulePrimaryExpression )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1602:1: ( rulePrimaryExpression )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1603:1: rulePrimaryExpression
            {
             before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23151);
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
    // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1612:1: rule__PrimaryExpression__FeatureIdAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__FeatureIdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1616:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1617:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1617:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.bcl.ui/src-gen/cz/jpikl/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1618:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13182); 
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
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01438 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1_1__0_in_rule__Disjunction__Group_1__1__Impl1528 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1_1__0_in_rule__Disjunction__Group_1__1__Impl1540 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1_1__0__Impl_in_rule__Disjunction__Group_1_1__01577 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1_1__1_in_rule__Disjunction__Group_1_1__01580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Disjunction__Group_1_1__0__Impl1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1_1__1__Impl_in_rule__Disjunction__Group_1_1__11639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__PartsAssignment_1_1_1_in_rule__Disjunction__Group_1_1__1__Impl1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01700 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01821 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__11882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0_in_rule__ExclusiveDisjunction__Group_1__1__Impl1911 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0_in_rule__ExclusiveDisjunction__Group_1__1__Impl1923 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1_1__01960 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1_1__1_in_rule__ExclusiveDisjunction__Group_1_1__01963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExclusiveDisjunction__Group_1_1__0__Impl1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1_1__12022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_1_1_in_rule__ExclusiveDisjunction__Group_1_1__1__Impl2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02083 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02204 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1_1__0_in_rule__Conjunction__Group_1__1__Impl2294 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1_1__0_in_rule__Conjunction__Group_1__1__Impl2306 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1_1__0__Impl_in_rule__Conjunction__Group_1_1__02343 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1_1__1_in_rule__Conjunction__Group_1_1__02346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Conjunction__Group_1_1__0__Impl2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1_1__1__Impl_in_rule__Conjunction__Group_1_1__12405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__PartsAssignment_1_1_1_in_rule__Conjunction__Group_1_1__1__Impl2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02466 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Negation__Group_1__0__Impl2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12528 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02774 = new BitSet(new long[]{0x0000000000060810L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PrimaryExpression__Group_1__0__Impl2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12836 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimaryExpression__Group_1__2__Impl2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_22965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_42996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_1_13058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_1_13089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_1_13120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13182 = new BitSet(new long[]{0x0000000000000002L});

}