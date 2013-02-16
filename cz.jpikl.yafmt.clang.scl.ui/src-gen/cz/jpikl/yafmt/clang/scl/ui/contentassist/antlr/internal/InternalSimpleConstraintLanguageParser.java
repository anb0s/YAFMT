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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'implies'", "'requires'", "'->'", "'=>'", "'or'", "'|'", "'xor'", "'^'", "'and'", "'&'", "'not'", "'!'", "'context'", "':'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
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

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID||(LA1_0>=21 && LA1_0<=22)||LA1_0==25) ) {
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


    // $ANTLR start "rule__Implication__Alternatives_1_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:306:1: rule__Implication__Alternatives_1_1 : ( ( 'implies' ) | ( 'requires' ) | ( '->' ) | ( '=>' ) );
    public final void rule__Implication__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:310:1: ( ( 'implies' ) | ( 'requires' ) | ( '->' ) | ( '=>' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:311:1: ( 'implies' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:311:1: ( 'implies' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:312:1: 'implies'
                    {
                     before(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1_0()); 
                    match(input,11,FOLLOW_11_in_rule__Implication__Alternatives_1_1600); 
                     after(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:319:6: ( 'requires' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:319:6: ( 'requires' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:320:1: 'requires'
                    {
                     before(grammarAccess.getImplicationAccess().getRequiresKeyword_1_1_1()); 
                    match(input,12,FOLLOW_12_in_rule__Implication__Alternatives_1_1620); 
                     after(grammarAccess.getImplicationAccess().getRequiresKeyword_1_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:327:6: ( '->' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:327:6: ( '->' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:328:1: '->'
                    {
                     before(grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2()); 
                    match(input,13,FOLLOW_13_in_rule__Implication__Alternatives_1_1640); 
                     after(grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:335:6: ( '=>' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:335:6: ( '=>' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:336:1: '=>'
                    {
                     before(grammarAccess.getImplicationAccess().getEqualsSignGreaterThanSignKeyword_1_1_3()); 
                    match(input,14,FOLLOW_14_in_rule__Implication__Alternatives_1_1660); 
                     after(grammarAccess.getImplicationAccess().getEqualsSignGreaterThanSignKeyword_1_1_3()); 

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
    // $ANTLR end "rule__Implication__Alternatives_1_1"


    // $ANTLR start "rule__Disjunction__Alternatives_1_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:348:1: rule__Disjunction__Alternatives_1_1 : ( ( 'or' ) | ( '|' ) );
    public final void rule__Disjunction__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:352:1: ( ( 'or' ) | ( '|' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:353:1: ( 'or' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:353:1: ( 'or' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:354:1: 'or'
                    {
                     before(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0()); 
                    match(input,15,FOLLOW_15_in_rule__Disjunction__Alternatives_1_1695); 
                     after(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:361:6: ( '|' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:361:6: ( '|' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:362:1: '|'
                    {
                     before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_1()); 
                    match(input,16,FOLLOW_16_in_rule__Disjunction__Alternatives_1_1715); 
                     after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_1()); 

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
    // $ANTLR end "rule__Disjunction__Alternatives_1_1"


    // $ANTLR start "rule__ExclusiveDisjunction__Alternatives_1_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:374:1: rule__ExclusiveDisjunction__Alternatives_1_1 : ( ( 'xor' ) | ( '^' ) );
    public final void rule__ExclusiveDisjunction__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:378:1: ( ( 'xor' ) | ( '^' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:379:1: ( 'xor' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:379:1: ( 'xor' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:380:1: 'xor'
                    {
                     before(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0()); 
                    match(input,17,FOLLOW_17_in_rule__ExclusiveDisjunction__Alternatives_1_1750); 
                     after(grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:387:6: ( '^' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:387:6: ( '^' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:388:1: '^'
                    {
                     before(grammarAccess.getExclusiveDisjunctionAccess().getCircumflexAccentKeyword_1_1_1()); 
                    match(input,18,FOLLOW_18_in_rule__ExclusiveDisjunction__Alternatives_1_1770); 
                     after(grammarAccess.getExclusiveDisjunctionAccess().getCircumflexAccentKeyword_1_1_1()); 

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
    // $ANTLR end "rule__ExclusiveDisjunction__Alternatives_1_1"


    // $ANTLR start "rule__Conjunction__Alternatives_1_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:400:1: rule__Conjunction__Alternatives_1_1 : ( ( 'and' ) | ( '&' ) );
    public final void rule__Conjunction__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:404:1: ( ( 'and' ) | ( '&' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:405:1: ( 'and' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:405:1: ( 'and' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:406:1: 'and'
                    {
                     before(grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0()); 
                    match(input,19,FOLLOW_19_in_rule__Conjunction__Alternatives_1_1805); 
                     after(grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:413:6: ( '&' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:413:6: ( '&' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:414:1: '&'
                    {
                     before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1_1()); 
                    match(input,20,FOLLOW_20_in_rule__Conjunction__Alternatives_1_1825); 
                     after(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1_1()); 

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
    // $ANTLR end "rule__Conjunction__Alternatives_1_1"


    // $ANTLR start "rule__Negation__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:426:1: rule__Negation__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:430:1: ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==25) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=21 && LA6_0<=22)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:431:1: ( rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:431:1: ( rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:432:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives859);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:437:6: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:437:6: ( ( rule__Negation__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:438:1: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:439:1: ( rule__Negation__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:439:2: rule__Negation__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives876);
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


    // $ANTLR start "rule__Negation__Alternatives_1_0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:448:1: rule__Negation__Alternatives_1_0 : ( ( 'not' ) | ( '!' ) );
    public final void rule__Negation__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:452:1: ( ( 'not' ) | ( '!' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:453:1: ( 'not' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:453:1: ( 'not' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:454:1: 'not'
                    {
                     before(grammarAccess.getNegationAccess().getNotKeyword_1_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__Negation__Alternatives_1_0910); 
                     after(grammarAccess.getNegationAccess().getNotKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:461:6: ( '!' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:461:6: ( '!' )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:462:1: '!'
                    {
                     before(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__Negation__Alternatives_1_0930); 
                     after(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_0_1()); 

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
    // $ANTLR end "rule__Negation__Alternatives_1_0"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:474:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:478:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==25) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:479:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:479:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:480:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:481:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:481:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives964);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:485:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:485:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:486:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:487:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:487:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives982);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:498:1: rule__ContextualExpression__Group_0__0 : rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 ;
    public final void rule__ContextualExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:502:1: ( rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:503:2: rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__01013);
            rule__ContextualExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__01016);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:510:1: rule__ContextualExpression__Group_0__0__Impl : ( 'context' ) ;
    public final void rule__ContextualExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:514:1: ( ( 'context' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:515:1: ( 'context' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:515:1: ( 'context' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:516:1: 'context'
            {
             before(grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__ContextualExpression__Group_0__0__Impl1044); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:529:1: rule__ContextualExpression__Group_0__1 : rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 ;
    public final void rule__ContextualExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:533:1: ( rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:534:2: rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__11075);
            rule__ContextualExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__11078);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:541:1: rule__ContextualExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__ContextualExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:545:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:546:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:546:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:547:1: ()
            {
             before(grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:548:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:550:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:560:1: rule__ContextualExpression__Group_0__2 : rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 ;
    public final void rule__ContextualExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:564:1: ( rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:565:2: rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__21136);
            rule__ContextualExpression__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__21139);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:572:1: rule__ContextualExpression__Group_0__2__Impl : ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) ;
    public final void rule__ContextualExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:576:1: ( ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:577:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:577:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:578:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:579:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:579:2: rule__ContextualExpression__ContextIdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl1166);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:589:1: rule__ContextualExpression__Group_0__3 : rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 ;
    public final void rule__ContextualExpression__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:593:1: ( rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:594:2: rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__31196);
            rule__ContextualExpression__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__31199);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:601:1: rule__ContextualExpression__Group_0__3__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:605:1: ( ( ':' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:606:1: ( ':' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:606:1: ( ':' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:607:1: ':'
            {
             before(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); 
            match(input,24,FOLLOW_24_in_rule__ContextualExpression__Group_0__3__Impl1227); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:620:1: rule__ContextualExpression__Group_0__4 : rule__ContextualExpression__Group_0__4__Impl ;
    public final void rule__ContextualExpression__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:624:1: ( rule__ContextualExpression__Group_0__4__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:625:2: rule__ContextualExpression__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__41258);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:631:1: rule__ContextualExpression__Group_0__4__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) ;
    public final void rule__ContextualExpression__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:635:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:636:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:636:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:637:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:638:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:638:2: rule__ContextualExpression__ExpressionAssignment_0_4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl1285);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:658:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:662:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:663:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
            {
            pushFollow(FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01325);
            rule__Implication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01328);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:670:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:674:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:675:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:675:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:676:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1355);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:687:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:691:1: ( rule__Implication__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:692:2: rule__Implication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11384);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:698:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )? ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:702:1: ( ( ( rule__Implication__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:703:1: ( ( rule__Implication__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:703:1: ( ( rule__Implication__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:704:1: ( rule__Implication__Group_1__0 )?
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:705:1: ( rule__Implication__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=11 && LA9_0<=14)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:705:2: rule__Implication__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1411);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:719:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:723:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:724:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01446);
            rule__Implication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01449);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:731:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:735:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:736:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:736:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:737:1: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:738:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:740:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:750:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:754:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:755:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11507);
            rule__Implication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11510);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:762:1: rule__Implication__Group_1__1__Impl : ( ( rule__Implication__Alternatives_1_1 ) ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:766:1: ( ( ( rule__Implication__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:767:1: ( ( rule__Implication__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:767:1: ( ( rule__Implication__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:768:1: ( rule__Implication__Alternatives_1_1 )
            {
             before(grammarAccess.getImplicationAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:769:1: ( rule__Implication__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:769:2: rule__Implication__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Implication__Alternatives_1_1_in_rule__Implication__Group_1__1__Impl1537);
            rule__Implication__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getAlternatives_1_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:779:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:783:1: ( rule__Implication__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:784:2: rule__Implication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21567);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:790:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightPartAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:794:1: ( ( ( rule__Implication__RightPartAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:795:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:795:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:796:1: ( rule__Implication__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:797:1: ( rule__Implication__RightPartAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:797:2: rule__Implication__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1594);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:813:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:817:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:818:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01630);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01633);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:825:1: rule__Disjunction__Group__0__Impl : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:829:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:830:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:830:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:831:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1660);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:842:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:846:1: ( rule__Disjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:847:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11689);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:853:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:857:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:858:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:858:1: ( ( rule__Disjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:859:1: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:860:1: ( rule__Disjunction__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=15 && LA10_0<=16)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:860:2: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1716);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:874:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:878:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:879:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01751);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01754);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:886:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:890:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:891:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:891:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:892:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:893:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:895:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:905:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:909:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:910:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11812);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11815);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:917:1: rule__Disjunction__Group_1__1__Impl : ( ( rule__Disjunction__Alternatives_1_1 ) ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:921:1: ( ( ( rule__Disjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:922:1: ( ( rule__Disjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:922:1: ( ( rule__Disjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:923:1: ( rule__Disjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getDisjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:924:1: ( rule__Disjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:924:2: rule__Disjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Disjunction__Alternatives_1_1_in_rule__Disjunction__Group_1__1__Impl1842);
            rule__Disjunction__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getAlternatives_1_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:934:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:938:1: ( rule__Disjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:939:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21872);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:945:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:949:1: ( ( ( rule__Disjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:950:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:950:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:951:1: ( rule__Disjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:952:1: ( rule__Disjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:952:2: rule__Disjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1899);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:968:1: rule__ExclusiveDisjunction__Group__0 : rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 ;
    public final void rule__ExclusiveDisjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:972:1: ( rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:973:2: rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01935);
            rule__ExclusiveDisjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01938);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:980:1: rule__ExclusiveDisjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:984:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:985:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:985:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:986:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1965);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:997:1: rule__ExclusiveDisjunction__Group__1 : rule__ExclusiveDisjunction__Group__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1001:1: ( rule__ExclusiveDisjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1002:2: rule__ExclusiveDisjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11994);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1008:1: rule__ExclusiveDisjunction__Group__1__Impl : ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) ;
    public final void rule__ExclusiveDisjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1012:1: ( ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1013:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1013:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1014:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1015:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=17 && LA11_0<=18)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1015:2: rule__ExclusiveDisjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl2021);
            	    rule__ExclusiveDisjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1029:1: rule__ExclusiveDisjunction__Group_1__0 : rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 ;
    public final void rule__ExclusiveDisjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1033:1: ( rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1034:2: rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__02056);
            rule__ExclusiveDisjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__02059);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1041:1: rule__ExclusiveDisjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__ExclusiveDisjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1045:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1046:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1046:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1047:1: ()
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1048:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1050:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1060:1: rule__ExclusiveDisjunction__Group_1__1 : rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 ;
    public final void rule__ExclusiveDisjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1064:1: ( rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1065:2: rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__12117);
            rule__ExclusiveDisjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__12120);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1072:1: rule__ExclusiveDisjunction__Group_1__1__Impl : ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1076:1: ( ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1077:1: ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1077:1: ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1078:1: ( rule__ExclusiveDisjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1079:1: ( rule__ExclusiveDisjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1079:2: rule__ExclusiveDisjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Alternatives_1_1_in_rule__ExclusiveDisjunction__Group_1__1__Impl2147);
            rule__ExclusiveDisjunction__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExclusiveDisjunctionAccess().getAlternatives_1_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1089:1: rule__ExclusiveDisjunction__Group_1__2 : rule__ExclusiveDisjunction__Group_1__2__Impl ;
    public final void rule__ExclusiveDisjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1093:1: ( rule__ExclusiveDisjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1094:2: rule__ExclusiveDisjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__22177);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1100:1: rule__ExclusiveDisjunction__Group_1__2__Impl : ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1104:1: ( ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1105:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1105:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1106:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1107:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1107:2: rule__ExclusiveDisjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl2204);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1123:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1127:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1128:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02240);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02243);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1135:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1139:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1140:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1140:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1141:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2270);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1152:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1156:1: ( rule__Conjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1157:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12299);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1163:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1167:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1168:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1168:1: ( ( rule__Conjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1169:1: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1170:1: ( rule__Conjunction__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=19 && LA12_0<=20)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1170:2: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2326);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1184:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1188:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1189:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02361);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02364);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1196:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1200:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1201:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1201:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1202:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1203:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1205:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1215:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1219:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1220:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12422);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12425);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1227:1: rule__Conjunction__Group_1__1__Impl : ( ( rule__Conjunction__Alternatives_1_1 ) ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1231:1: ( ( ( rule__Conjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1232:1: ( ( rule__Conjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1232:1: ( ( rule__Conjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1233:1: ( rule__Conjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getConjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1234:1: ( rule__Conjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1234:2: rule__Conjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Conjunction__Alternatives_1_1_in_rule__Conjunction__Group_1__1__Impl2452);
            rule__Conjunction__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getAlternatives_1_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1244:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1248:1: ( rule__Conjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1249:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22482);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1255:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1259:1: ( ( ( rule__Conjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1260:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1260:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1261:1: ( rule__Conjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1262:1: ( rule__Conjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1262:2: rule__Conjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2509);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1278:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1282:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1283:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02545);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02548);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1290:1: rule__Negation__Group_1__0__Impl : ( ( rule__Negation__Alternatives_1_0 ) ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1294:1: ( ( ( rule__Negation__Alternatives_1_0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1295:1: ( ( rule__Negation__Alternatives_1_0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1295:1: ( ( rule__Negation__Alternatives_1_0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1296:1: ( rule__Negation__Alternatives_1_0 )
            {
             before(grammarAccess.getNegationAccess().getAlternatives_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1297:1: ( rule__Negation__Alternatives_1_0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1297:2: rule__Negation__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Negation__Alternatives_1_0_in_rule__Negation__Group_1__0__Impl2575);
            rule__Negation__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives_1_0()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1307:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1311:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1312:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12605);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12608);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1319:1: rule__Negation__Group_1__1__Impl : ( () ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1323:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1324:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1324:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1325:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1326:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1328:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1338:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1342:1: ( rule__Negation__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1343:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22666);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1349:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1353:1: ( ( ( rule__Negation__ExpressionAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1354:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1354:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1355:1: ( rule__Negation__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1356:1: ( rule__Negation__ExpressionAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1356:2: rule__Negation__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2693);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1372:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1376:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1377:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02729);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02732);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1384:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1388:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1389:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1389:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1390:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1391:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1393:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1403:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1407:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1408:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12790);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1414:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1418:1: ( ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1419:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1419:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1420:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1421:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1421:2: rule__PrimaryExpression__FeatureIdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2817);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1435:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1439:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1440:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02851);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02854);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1447:1: rule__PrimaryExpression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1451:1: ( ( '(' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1452:1: ( '(' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1452:1: ( '(' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1453:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,25,FOLLOW_25_in_rule__PrimaryExpression__Group_1__0__Impl2882); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1466:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1470:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1471:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12913);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12916);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1478:1: rule__PrimaryExpression__Group_1__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1482:1: ( ( ruleExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1483:1: ( ruleExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1483:1: ( ruleExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1484:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2943);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1495:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1499:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1500:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22972);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1506:1: rule__PrimaryExpression__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1510:1: ( ( ')' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1511:1: ( ')' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1511:1: ( ')' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1512:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 
            match(input,26,FOLLOW_26_in_rule__PrimaryExpression__Group_1__2__Impl3000); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1532:1: rule__ContextualExpression__ContextIdAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextIdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1536:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1537:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1537:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1538:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_23042); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1547:1: rule__ContextualExpression__ExpressionAssignment_0_4 : ( ruleImplication ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1551:1: ( ( ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1552:1: ( ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1552:1: ( ruleImplication )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1553:1: ruleImplication
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_43073);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1562:1: rule__Implication__RightPartAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1566:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1567:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1567:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1568:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23104);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1577:1: rule__Disjunction__PartsAssignment_1_2 : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1581:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1582:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1582:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1583:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_23135);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1592:1: rule__ExclusiveDisjunction__PartsAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1596:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1597:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1597:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1598:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_23166);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1607:1: rule__Conjunction__PartsAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1611:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1612:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1612:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1613:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_23197);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1622:1: rule__Negation__ExpressionAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__Negation__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1626:1: ( ( rulePrimaryExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1627:1: ( rulePrimaryExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1627:1: ( rulePrimaryExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1628:1: rulePrimaryExpression
            {
             before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23228);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1637:1: rule__PrimaryExpression__FeatureIdAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__FeatureIdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1641:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1642:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1642:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1643:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13259); 
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
    public static final BitSet FOLLOW_11_in_rule__Implication__Alternatives_1_1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Implication__Alternatives_1_1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Implication__Alternatives_1_1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Implication__Alternatives_1_1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Disjunction__Alternatives_1_1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Disjunction__Alternatives_1_1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExclusiveDisjunction__Alternatives_1_1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExclusiveDisjunction__Alternatives_1_1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Conjunction__Alternatives_1_1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Conjunction__Alternatives_1_1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Negation__Alternatives_1_0910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Negation__Alternatives_1_0930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__01013 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__01016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ContextualExpression__Group_0__0__Impl1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__11075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__11078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__21136 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__21139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__31196 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__31199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ContextualExpression__Group_0__3__Impl1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__41258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01325 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01446 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11507 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Alternatives_1_1_in_rule__Implication__Group_1__1__Impl1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01630 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1716 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01751 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11812 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Alternatives_1_1_in_rule__Disjunction__Group_1__1__Impl1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01935 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl2021 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__02056 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__02059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__12117 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__12120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Alternatives_1_1_in_rule__ExclusiveDisjunction__Group_1__1__Impl2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__22177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02240 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2326 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02361 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12422 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Alternatives_1_1_in_rule__Conjunction__Group_1__1__Impl2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02545 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Alternatives_1_0_in_rule__Negation__Group_1__0__Impl2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12605 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02729 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02851 = new BitSet(new long[]{0x0000000002E00010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__PrimaryExpression__Group_1__0__Impl2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12913 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PrimaryExpression__Group_1__2__Impl3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_23042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_0_43073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_23135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_23166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_23197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13259 = new BitSet(new long[]{0x0000000000000002L});

}