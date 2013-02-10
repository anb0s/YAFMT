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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:69:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:73:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:74:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:74:1: ( ( rule__Expression__Alternatives ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:75:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:76:1: ( rule__Expression__Alternatives )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:76:2: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_rule__Expression__Alternatives_in_ruleExpression94);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

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
            pushFollow(FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression121);
            ruleContextualExpression();

            state._fsp--;

             after(grammarAccess.getContextualExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextualExpression128); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:97:1: ruleContextualExpression : ( ( rule__ContextualExpression__Group__0 ) ) ;
    public final void ruleContextualExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:101:2: ( ( ( rule__ContextualExpression__Group__0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Group__0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Group__0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:103:1: ( rule__ContextualExpression__Group__0 )
            {
             before(grammarAccess.getContextualExpressionAccess().getGroup()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:104:1: ( rule__ContextualExpression__Group__0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:104:2: rule__ContextualExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group__0_in_ruleContextualExpression154);
            rule__ContextualExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getGroup()); 

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
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication181);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getImplicationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication188); 

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
            pushFollow(FOLLOW_rule__Implication__Group__0_in_ruleImplication214);
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
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction241);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction248); 

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
            pushFollow(FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction274);
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
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction301);
            ruleExclusiveDisjunction();

            state._fsp--;

             after(grammarAccess.getExclusiveDisjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveDisjunction308); 

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
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0_in_ruleExclusiveDisjunction334);
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
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction361);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction368); 

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
            pushFollow(FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction394);
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
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation421);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation428); 

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
            pushFollow(FOLLOW_rule__Negation__Alternatives_in_ruleNegation454);
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
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression481);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression488); 

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
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression514);
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


    // $ANTLR start "rule__Expression__Alternatives"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:284:1: rule__Expression__Alternatives : ( ( ruleContextualExpression ) | ( ruleImplication ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:288:1: ( ( ruleContextualExpression ) | ( ruleImplication ) )
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
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: ( ruleContextualExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: ( ruleContextualExpression )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:290:1: ruleContextualExpression
                    {
                     before(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleContextualExpression_in_rule__Expression__Alternatives550);
                    ruleContextualExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:295:6: ( ruleImplication )
                    {
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:295:6: ( ruleImplication )
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:296:1: ruleImplication
                    {
                     before(grammarAccess.getExpressionAccess().getImplicationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImplication_in_rule__Expression__Alternatives567);
                    ruleImplication();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getImplicationParserRuleCall_1()); 

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
    // $ANTLR end "rule__Expression__Alternatives"


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


    // $ANTLR start "rule__ContextualExpression__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:498:1: rule__ContextualExpression__Group__0 : rule__ContextualExpression__Group__0__Impl rule__ContextualExpression__Group__1 ;
    public final void rule__ContextualExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:502:1: ( rule__ContextualExpression__Group__0__Impl rule__ContextualExpression__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:503:2: rule__ContextualExpression__Group__0__Impl rule__ContextualExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group__0__Impl_in_rule__ContextualExpression__Group__01013);
            rule__ContextualExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group__1_in_rule__ContextualExpression__Group__01016);
            rule__ContextualExpression__Group__1();

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
    // $ANTLR end "rule__ContextualExpression__Group__0"


    // $ANTLR start "rule__ContextualExpression__Group__0__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:510:1: rule__ContextualExpression__Group__0__Impl : ( 'context' ) ;
    public final void rule__ContextualExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:514:1: ( ( 'context' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:515:1: ( 'context' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:515:1: ( 'context' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:516:1: 'context'
            {
             before(grammarAccess.getContextualExpressionAccess().getContextKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__ContextualExpression__Group__0__Impl1044); 
             after(grammarAccess.getContextualExpressionAccess().getContextKeyword_0()); 

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
    // $ANTLR end "rule__ContextualExpression__Group__0__Impl"


    // $ANTLR start "rule__ContextualExpression__Group__1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:529:1: rule__ContextualExpression__Group__1 : rule__ContextualExpression__Group__1__Impl rule__ContextualExpression__Group__2 ;
    public final void rule__ContextualExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:533:1: ( rule__ContextualExpression__Group__1__Impl rule__ContextualExpression__Group__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:534:2: rule__ContextualExpression__Group__1__Impl rule__ContextualExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group__1__Impl_in_rule__ContextualExpression__Group__11075);
            rule__ContextualExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group__2_in_rule__ContextualExpression__Group__11078);
            rule__ContextualExpression__Group__2();

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
    // $ANTLR end "rule__ContextualExpression__Group__1"


    // $ANTLR start "rule__ContextualExpression__Group__1__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:541:1: rule__ContextualExpression__Group__1__Impl : ( ( rule__ContextualExpression__ContextAssignment_1 ) ) ;
    public final void rule__ContextualExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:545:1: ( ( ( rule__ContextualExpression__ContextAssignment_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:546:1: ( ( rule__ContextualExpression__ContextAssignment_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:546:1: ( ( rule__ContextualExpression__ContextAssignment_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:547:1: ( rule__ContextualExpression__ContextAssignment_1 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextAssignment_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:548:1: ( rule__ContextualExpression__ContextAssignment_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:548:2: rule__ContextualExpression__ContextAssignment_1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ContextAssignment_1_in_rule__ContextualExpression__Group__1__Impl1105);
            rule__ContextualExpression__ContextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getContextAssignment_1()); 

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
    // $ANTLR end "rule__ContextualExpression__Group__1__Impl"


    // $ANTLR start "rule__ContextualExpression__Group__2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:558:1: rule__ContextualExpression__Group__2 : rule__ContextualExpression__Group__2__Impl rule__ContextualExpression__Group__3 ;
    public final void rule__ContextualExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:562:1: ( rule__ContextualExpression__Group__2__Impl rule__ContextualExpression__Group__3 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:563:2: rule__ContextualExpression__Group__2__Impl rule__ContextualExpression__Group__3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group__2__Impl_in_rule__ContextualExpression__Group__21135);
            rule__ContextualExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group__3_in_rule__ContextualExpression__Group__21138);
            rule__ContextualExpression__Group__3();

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
    // $ANTLR end "rule__ContextualExpression__Group__2"


    // $ANTLR start "rule__ContextualExpression__Group__2__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:570:1: rule__ContextualExpression__Group__2__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:574:1: ( ( ':' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:575:1: ( ':' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:575:1: ( ':' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:576:1: ':'
            {
             before(grammarAccess.getContextualExpressionAccess().getColonKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__ContextualExpression__Group__2__Impl1166); 
             after(grammarAccess.getContextualExpressionAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__ContextualExpression__Group__2__Impl"


    // $ANTLR start "rule__ContextualExpression__Group__3"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:589:1: rule__ContextualExpression__Group__3 : rule__ContextualExpression__Group__3__Impl ;
    public final void rule__ContextualExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:593:1: ( rule__ContextualExpression__Group__3__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:594:2: rule__ContextualExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group__3__Impl_in_rule__ContextualExpression__Group__31197);
            rule__ContextualExpression__Group__3__Impl();

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
    // $ANTLR end "rule__ContextualExpression__Group__3"


    // $ANTLR start "rule__ContextualExpression__Group__3__Impl"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:600:1: rule__ContextualExpression__Group__3__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_3 ) ) ;
    public final void rule__ContextualExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:604:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_3 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:605:1: ( ( rule__ContextualExpression__ExpressionAssignment_3 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:605:1: ( ( rule__ContextualExpression__ExpressionAssignment_3 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:606:1: ( rule__ContextualExpression__ExpressionAssignment_3 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_3()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:607:1: ( rule__ContextualExpression__ExpressionAssignment_3 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:607:2: rule__ContextualExpression__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ExpressionAssignment_3_in_rule__ContextualExpression__Group__3__Impl1224);
            rule__ContextualExpression__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_3()); 

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
    // $ANTLR end "rule__ContextualExpression__Group__3__Impl"


    // $ANTLR start "rule__Implication__Group__0"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:625:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:629:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:630:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
            {
            pushFollow(FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01262);
            rule__Implication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01265);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:637:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:641:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:642:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:642:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:643:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1292);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:654:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:658:1: ( rule__Implication__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:659:2: rule__Implication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11321);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:665:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )? ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:669:1: ( ( ( rule__Implication__Group_1__0 )? ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:670:1: ( ( rule__Implication__Group_1__0 )? )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:670:1: ( ( rule__Implication__Group_1__0 )? )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:671:1: ( rule__Implication__Group_1__0 )?
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:672:1: ( rule__Implication__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=11 && LA9_0<=14)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:672:2: rule__Implication__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1348);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:686:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:690:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:691:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01383);
            rule__Implication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01386);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:698:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:702:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:703:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:703:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:704:1: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:705:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:707:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:717:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:721:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:722:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11444);
            rule__Implication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11447);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:729:1: rule__Implication__Group_1__1__Impl : ( ( rule__Implication__Alternatives_1_1 ) ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:733:1: ( ( ( rule__Implication__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:734:1: ( ( rule__Implication__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:734:1: ( ( rule__Implication__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:735:1: ( rule__Implication__Alternatives_1_1 )
            {
             before(grammarAccess.getImplicationAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:736:1: ( rule__Implication__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:736:2: rule__Implication__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Implication__Alternatives_1_1_in_rule__Implication__Group_1__1__Impl1474);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:746:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:750:1: ( rule__Implication__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:751:2: rule__Implication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21504);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:757:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightPartAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:761:1: ( ( ( rule__Implication__RightPartAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:762:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:762:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:763:1: ( rule__Implication__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:764:1: ( rule__Implication__RightPartAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:764:2: rule__Implication__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1531);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:780:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:784:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:785:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01567);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01570);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:792:1: rule__Disjunction__Group__0__Impl : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:796:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:797:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:797:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:798:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1597);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:809:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:813:1: ( rule__Disjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:814:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11626);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:820:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:824:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:825:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:825:1: ( ( rule__Disjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:826:1: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:827:1: ( rule__Disjunction__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=15 && LA10_0<=16)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:827:2: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1653);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:841:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:845:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:846:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01688);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01691);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:853:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:857:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:858:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:858:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:859:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:860:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:862:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:872:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:876:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:877:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11749);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11752);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:884:1: rule__Disjunction__Group_1__1__Impl : ( ( rule__Disjunction__Alternatives_1_1 ) ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:888:1: ( ( ( rule__Disjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:889:1: ( ( rule__Disjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:889:1: ( ( rule__Disjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:890:1: ( rule__Disjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getDisjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:891:1: ( rule__Disjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:891:2: rule__Disjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Disjunction__Alternatives_1_1_in_rule__Disjunction__Group_1__1__Impl1779);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:901:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:905:1: ( rule__Disjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:906:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21809);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:912:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:916:1: ( ( ( rule__Disjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:917:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:917:1: ( ( rule__Disjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:918:1: ( rule__Disjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:919:1: ( rule__Disjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:919:2: rule__Disjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1836);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:935:1: rule__ExclusiveDisjunction__Group__0 : rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 ;
    public final void rule__ExclusiveDisjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:939:1: ( rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:940:2: rule__ExclusiveDisjunction__Group__0__Impl rule__ExclusiveDisjunction__Group__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01872);
            rule__ExclusiveDisjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01875);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:947:1: rule__ExclusiveDisjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:951:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:952:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:952:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:953:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1902);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:964:1: rule__ExclusiveDisjunction__Group__1 : rule__ExclusiveDisjunction__Group__1__Impl ;
    public final void rule__ExclusiveDisjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:968:1: ( rule__ExclusiveDisjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:969:2: rule__ExclusiveDisjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11931);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:975:1: rule__ExclusiveDisjunction__Group__1__Impl : ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) ;
    public final void rule__ExclusiveDisjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:979:1: ( ( ( rule__ExclusiveDisjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:980:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:980:1: ( ( rule__ExclusiveDisjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:981:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:982:1: ( rule__ExclusiveDisjunction__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=17 && LA11_0<=18)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:982:2: rule__ExclusiveDisjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1958);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:996:1: rule__ExclusiveDisjunction__Group_1__0 : rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 ;
    public final void rule__ExclusiveDisjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1000:1: ( rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1001:2: rule__ExclusiveDisjunction__Group_1__0__Impl rule__ExclusiveDisjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01993);
            rule__ExclusiveDisjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01996);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1008:1: rule__ExclusiveDisjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__ExclusiveDisjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1012:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1013:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1013:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1014:1: ()
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1015:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1017:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1027:1: rule__ExclusiveDisjunction__Group_1__1 : rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 ;
    public final void rule__ExclusiveDisjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1031:1: ( rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1032:2: rule__ExclusiveDisjunction__Group_1__1__Impl rule__ExclusiveDisjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__12054);
            rule__ExclusiveDisjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__12057);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1039:1: rule__ExclusiveDisjunction__Group_1__1__Impl : ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1043:1: ( ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1044:1: ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1044:1: ( ( rule__ExclusiveDisjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1045:1: ( rule__ExclusiveDisjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1046:1: ( rule__ExclusiveDisjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1046:2: rule__ExclusiveDisjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Alternatives_1_1_in_rule__ExclusiveDisjunction__Group_1__1__Impl2084);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1056:1: rule__ExclusiveDisjunction__Group_1__2 : rule__ExclusiveDisjunction__Group_1__2__Impl ;
    public final void rule__ExclusiveDisjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1060:1: ( rule__ExclusiveDisjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1061:2: rule__ExclusiveDisjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__22114);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1067:1: rule__ExclusiveDisjunction__Group_1__2__Impl : ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__ExclusiveDisjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1071:1: ( ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1072:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1072:1: ( ( rule__ExclusiveDisjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1073:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1074:1: ( rule__ExclusiveDisjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1074:2: rule__ExclusiveDisjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl2141);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1090:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1094:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1095:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02177);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02180);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1102:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1106:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1107:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1107:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1108:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2207);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1119:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1123:1: ( rule__Conjunction__Group__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1124:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12236);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1130:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1134:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1135:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1135:1: ( ( rule__Conjunction__Group_1__0 )* )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1136:1: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1137:1: ( rule__Conjunction__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=19 && LA12_0<=20)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1137:2: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2263);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1151:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1155:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1156:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02298);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02301);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1163:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1167:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1168:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1168:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1169:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1170:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1172:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1182:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1186:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1187:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12359);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12362);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1194:1: rule__Conjunction__Group_1__1__Impl : ( ( rule__Conjunction__Alternatives_1_1 ) ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1198:1: ( ( ( rule__Conjunction__Alternatives_1_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1199:1: ( ( rule__Conjunction__Alternatives_1_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1199:1: ( ( rule__Conjunction__Alternatives_1_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1200:1: ( rule__Conjunction__Alternatives_1_1 )
            {
             before(grammarAccess.getConjunctionAccess().getAlternatives_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1201:1: ( rule__Conjunction__Alternatives_1_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1201:2: rule__Conjunction__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Conjunction__Alternatives_1_1_in_rule__Conjunction__Group_1__1__Impl2389);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1211:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1215:1: ( rule__Conjunction__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1216:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22419);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1222:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__PartsAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1226:1: ( ( ( rule__Conjunction__PartsAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1227:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1227:1: ( ( rule__Conjunction__PartsAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1228:1: ( rule__Conjunction__PartsAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getPartsAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1229:1: ( rule__Conjunction__PartsAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1229:2: rule__Conjunction__PartsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2446);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1245:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1249:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1250:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02482);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02485);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1257:1: rule__Negation__Group_1__0__Impl : ( ( rule__Negation__Alternatives_1_0 ) ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1261:1: ( ( ( rule__Negation__Alternatives_1_0 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1262:1: ( ( rule__Negation__Alternatives_1_0 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1262:1: ( ( rule__Negation__Alternatives_1_0 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1263:1: ( rule__Negation__Alternatives_1_0 )
            {
             before(grammarAccess.getNegationAccess().getAlternatives_1_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1264:1: ( rule__Negation__Alternatives_1_0 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1264:2: rule__Negation__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Negation__Alternatives_1_0_in_rule__Negation__Group_1__0__Impl2512);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1274:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1278:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1279:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12542);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12545);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1286:1: rule__Negation__Group_1__1__Impl : ( () ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1290:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1291:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1291:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1292:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1293:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1295:1: 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1305:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1309:1: ( rule__Negation__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1310:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22603);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1316:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1320:1: ( ( ( rule__Negation__ExpressionAssignment_1_2 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1321:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1321:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1322:1: ( rule__Negation__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1323:1: ( rule__Negation__ExpressionAssignment_1_2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1323:2: rule__Negation__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2630);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1339:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1343:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1344:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02666);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02669);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1351:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1355:1: ( ( () ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1356:1: ( () )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1356:1: ( () )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1357:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAction_0_0()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1358:1: ()
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1360:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAction_0_0()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1370:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1374:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1375:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12727);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1381:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__ValueAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1385:1: ( ( ( rule__PrimaryExpression__ValueAssignment_0_1 ) ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1386:1: ( ( rule__PrimaryExpression__ValueAssignment_0_1 ) )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1386:1: ( ( rule__PrimaryExpression__ValueAssignment_0_1 ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1387:1: ( rule__PrimaryExpression__ValueAssignment_0_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_0_1()); 
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1388:1: ( rule__PrimaryExpression__ValueAssignment_0_1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1388:2: rule__PrimaryExpression__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__ValueAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2754);
            rule__PrimaryExpression__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_0_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1402:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1406:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1407:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02788);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02791);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1414:1: rule__PrimaryExpression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1418:1: ( ( '(' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1419:1: ( '(' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1419:1: ( '(' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1420:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,25,FOLLOW_25_in_rule__PrimaryExpression__Group_1__0__Impl2819); 
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1433:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1437:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1438:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12850);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12853);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1445:1: rule__PrimaryExpression__Group_1__1__Impl : ( ruleImplication ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1449:1: ( ( ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1450:1: ( ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1450:1: ( ruleImplication )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1451:1: ruleImplication
            {
             before(grammarAccess.getPrimaryExpressionAccess().getImplicationParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__PrimaryExpression__Group_1__1__Impl2880);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getImplicationParserRuleCall_1_1()); 

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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1462:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1466:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1467:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22909);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1473:1: rule__PrimaryExpression__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1477:1: ( ( ')' ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1478:1: ( ')' )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1478:1: ( ')' )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1479:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 
            match(input,26,FOLLOW_26_in_rule__PrimaryExpression__Group_1__2__Impl2937); 
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


    // $ANTLR start "rule__ContextualExpression__ContextAssignment_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1499:1: rule__ContextualExpression__ContextAssignment_1 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1503:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1504:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1504:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1505:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextAssignment_12979); 
             after(grammarAccess.getContextualExpressionAccess().getContextIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__ContextualExpression__ContextAssignment_1"


    // $ANTLR start "rule__ContextualExpression__ExpressionAssignment_3"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1514:1: rule__ContextualExpression__ExpressionAssignment_3 : ( ruleImplication ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1518:1: ( ( ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1519:1: ( ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1519:1: ( ruleImplication )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1520:1: ruleImplication
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_33010);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__ContextualExpression__ExpressionAssignment_3"


    // $ANTLR start "rule__Implication__RightPartAssignment_1_2"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1529:1: rule__Implication__RightPartAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1533:1: ( ( ruleDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1534:1: ( ruleDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1534:1: ( ruleDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1535:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23041);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1544:1: rule__Disjunction__PartsAssignment_1_2 : ( ruleExclusiveDisjunction ) ;
    public final void rule__Disjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1548:1: ( ( ruleExclusiveDisjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1549:1: ( ruleExclusiveDisjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1549:1: ( ruleExclusiveDisjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1550:1: ruleExclusiveDisjunction
            {
             before(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_23072);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1559:1: rule__ExclusiveDisjunction__PartsAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__ExclusiveDisjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1563:1: ( ( ruleConjunction ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1564:1: ( ruleConjunction )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1564:1: ( ruleConjunction )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1565:1: ruleConjunction
            {
             before(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_23103);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1574:1: rule__Conjunction__PartsAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__PartsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1578:1: ( ( ruleNegation ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1579:1: ( ruleNegation )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1579:1: ( ruleNegation )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1580:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_23134);
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
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1589:1: rule__Negation__ExpressionAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__Negation__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1593:1: ( ( rulePrimaryExpression ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1594:1: ( rulePrimaryExpression )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1594:1: ( rulePrimaryExpression )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1595:1: rulePrimaryExpression
            {
             before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23165);
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


    // $ANTLR start "rule__PrimaryExpression__ValueAssignment_0_1"
    // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1604:1: rule__PrimaryExpression__ValueAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1608:1: ( ( RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1609:1: ( RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1609:1: ( RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl.ui/src-gen/cz/jpikl/yafmt/clang/scl/ui/contentassist/antlr/internal/InternalSimpleConstraintLanguage.g:1610:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__ValueAssignment_0_13196); 
             after(grammarAccess.getPrimaryExpressionAccess().getValueIDTerminalRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__PrimaryExpression__ValueAssignment_0_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextualExpression128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__0_in_ruleContextualExpression154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0_in_ruleImplication214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveDisjunction308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0_in_ruleExclusiveDisjunction334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Alternatives_in_ruleNegation454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_rule__Expression__Alternatives550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__Expression__Alternatives567 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__0__Impl_in_rule__ContextualExpression__Group__01013 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__1_in_rule__ContextualExpression__Group__01016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ContextualExpression__Group__0__Impl1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__1__Impl_in_rule__ContextualExpression__Group__11075 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__2_in_rule__ContextualExpression__Group__11078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ContextAssignment_1_in_rule__ContextualExpression__Group__1__Impl1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__2__Impl_in_rule__ContextualExpression__Group__21135 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__3_in_rule__ContextualExpression__Group__21138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ContextualExpression__Group__2__Impl1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group__3__Impl_in_rule__ContextualExpression__Group__31197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ExpressionAssignment_3_in_rule__ContextualExpression__Group__3__Impl1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01262 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01383 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11444 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Alternatives_1_1_in_rule__Implication__Group_1__1__Impl1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01567 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__Group__0__Impl1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__11626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl1653 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__01688 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__01691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__11749 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__11752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Alternatives_1_1_in_rule__Disjunction__Group_1__1__Impl1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__21809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__PartsAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__0__Impl_in_rule__ExclusiveDisjunction__Group__01872 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1_in_rule__ExclusiveDisjunction__Group__01875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__Group__0__Impl1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group__1__Impl_in_rule__ExclusiveDisjunction__Group__11931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0_in_rule__ExclusiveDisjunction__Group__1__Impl1958 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__0__Impl_in_rule__ExclusiveDisjunction__Group_1__01993 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1_in_rule__ExclusiveDisjunction__Group_1__01996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__1__Impl_in_rule__ExclusiveDisjunction__Group_1__12054 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2_in_rule__ExclusiveDisjunction__Group_1__12057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Alternatives_1_1_in_rule__ExclusiveDisjunction__Group_1__1__Impl2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__Group_1__2__Impl_in_rule__ExclusiveDisjunction__Group_1__22114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExclusiveDisjunction__PartsAssignment_1_2_in_rule__ExclusiveDisjunction__Group_1__2__Impl2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02177 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2263 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02298 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12359 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Alternatives_1_1_in_rule__Conjunction__Group_1__1__Impl2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__PartsAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02482 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Alternatives_1_0_in_rule__Negation__Group_1__0__Impl2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12542 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__ValueAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02788 = new BitSet(new long[]{0x0000000002600010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__PrimaryExpression__Group_1__0__Impl2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12850 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__PrimaryExpression__Group_1__1__Impl2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PrimaryExpression__Group_1__2__Impl2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextAssignment_12979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__ContextualExpression__ExpressionAssignment_33010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_rule__Disjunction__PartsAssignment_1_23072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__ExclusiveDisjunction__PartsAssignment_1_23103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__PartsAssignment_1_23134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__ValueAssignment_0_13196 = new BitSet(new long[]{0x0000000000000002L});

}