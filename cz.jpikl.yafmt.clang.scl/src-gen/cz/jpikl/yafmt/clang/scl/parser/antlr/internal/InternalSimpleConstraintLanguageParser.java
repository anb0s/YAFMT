package cz.jpikl.yafmt.clang.scl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleConstraintLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "':'", "'implies'", "'requires'", "'->'", "'=>'", "'or'", "'|'", "'xor'", "'^'", "'and'", "'&'", "'not'", "'!'", "'('", "')'"
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
    public String getGrammarFileName() { return "../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g"; }



     	private SimpleConstraintLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleConstraintLanguageParser(TokenStream input, SimpleConstraintLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Expression";	
       	}
       	
       	@Override
       	protected SimpleConstraintLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:67:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:68:2: (iv_ruleExpression= ruleExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:69:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression75);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:76:1: ruleExpression returns [EObject current=null] : (this_ContextualExpression_0= ruleContextualExpression | this_Implication_1= ruleImplication ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ContextualExpression_0 = null;

        EObject this_Implication_1 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:79:28: ( (this_ContextualExpression_0= ruleContextualExpression | this_Implication_1= ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:80:1: (this_ContextualExpression_0= ruleContextualExpression | this_Implication_1= ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:80:1: (this_ContextualExpression_0= ruleContextualExpression | this_Implication_1= ruleImplication )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID||(LA1_0>=23 && LA1_0<=25)) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:81:5: this_ContextualExpression_0= ruleContextualExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleContextualExpression_in_ruleExpression132);
                    this_ContextualExpression_0=ruleContextualExpression();

                    state._fsp--;

                     
                            current = this_ContextualExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:91:5: this_Implication_1= ruleImplication
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getImplicationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleImplication_in_ruleExpression159);
                    this_Implication_1=ruleImplication();

                    state._fsp--;

                     
                            current = this_Implication_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleContextualExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:107:1: entryRuleContextualExpression returns [EObject current=null] : iv_ruleContextualExpression= ruleContextualExpression EOF ;
    public final EObject entryRuleContextualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextualExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:108:2: (iv_ruleContextualExpression= ruleContextualExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:109:2: iv_ruleContextualExpression= ruleContextualExpression EOF
            {
             newCompositeNode(grammarAccess.getContextualExpressionRule()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression194);
            iv_ruleContextualExpression=ruleContextualExpression();

            state._fsp--;

             current =iv_ruleContextualExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextualExpression204); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextualExpression"


    // $ANTLR start "ruleContextualExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:116:1: ruleContextualExpression returns [EObject current=null] : (otherlv_0= 'context' ( (lv_context_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_expression_3_0= ruleImplication ) ) ) ;
    public final EObject ruleContextualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_context_1_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:119:28: ( (otherlv_0= 'context' ( (lv_context_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_expression_3_0= ruleImplication ) ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:120:1: (otherlv_0= 'context' ( (lv_context_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_expression_3_0= ruleImplication ) ) )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:120:1: (otherlv_0= 'context' ( (lv_context_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_expression_3_0= ruleImplication ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:120:3: otherlv_0= 'context' ( (lv_context_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_expression_3_0= ruleImplication ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleContextualExpression241); 

                	newLeafNode(otherlv_0, grammarAccess.getContextualExpressionAccess().getContextKeyword_0());
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:124:1: ( (lv_context_1_0= RULE_ID ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:125:1: (lv_context_1_0= RULE_ID )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:125:1: (lv_context_1_0= RULE_ID )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:126:3: lv_context_1_0= RULE_ID
            {
            lv_context_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContextualExpression258); 

            			newLeafNode(lv_context_1_0, grammarAccess.getContextualExpressionAccess().getContextIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getContextualExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"context",
                    		lv_context_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleContextualExpression275); 

                	newLeafNode(otherlv_2, grammarAccess.getContextualExpressionAccess().getColonKeyword_2());
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:146:1: ( (lv_expression_3_0= ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:147:1: (lv_expression_3_0= ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:147:1: (lv_expression_3_0= ruleImplication )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:148:3: lv_expression_3_0= ruleImplication
            {
             
            	        newCompositeNode(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleImplication_in_ruleContextualExpression296);
            lv_expression_3_0=ruleImplication();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContextualExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_3_0, 
                    		"Implication");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextualExpression"


    // $ANTLR start "entryRuleImplication"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:172:1: entryRuleImplication returns [EObject current=null] : iv_ruleImplication= ruleImplication EOF ;
    public final EObject entryRuleImplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplication = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:173:2: (iv_ruleImplication= ruleImplication EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:174:2: iv_ruleImplication= ruleImplication EOF
            {
             newCompositeNode(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication332);
            iv_ruleImplication=ruleImplication();

            state._fsp--;

             current =iv_ruleImplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication342); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplication"


    // $ANTLR start "ruleImplication"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:181:1: ruleImplication returns [EObject current=null] : (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? ) ;
    public final EObject ruleImplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_Disjunction_0 = null;

        EObject lv_rightPart_6_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:184:28: ( (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:185:1: (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:185:1: (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:186:5: this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication389);
            this_Disjunction_0=ruleDisjunction();

            state._fsp--;

             
                    current = this_Disjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:194:1: ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=13 && LA3_0<=16)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:194:2: () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:194:2: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:195:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:200:2: (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' )
                    int alt2=4;
                    switch ( input.LA(1) ) {
                    case 13:
                        {
                        alt2=1;
                        }
                        break;
                    case 14:
                        {
                        alt2=2;
                        }
                        break;
                    case 15:
                        {
                        alt2=3;
                        }
                        break;
                    case 16:
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
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:200:4: otherlv_2= 'implies'
                            {
                            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleImplication411); 

                                	newLeafNode(otherlv_2, grammarAccess.getImplicationAccess().getImpliesKeyword_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:205:7: otherlv_3= 'requires'
                            {
                            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImplication429); 

                                	newLeafNode(otherlv_3, grammarAccess.getImplicationAccess().getRequiresKeyword_1_1_1());
                                

                            }
                            break;
                        case 3 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:210:7: otherlv_4= '->'
                            {
                            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleImplication447); 

                                	newLeafNode(otherlv_4, grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                                

                            }
                            break;
                        case 4 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:215:7: otherlv_5= '=>'
                            {
                            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleImplication465); 

                                	newLeafNode(otherlv_5, grammarAccess.getImplicationAccess().getEqualsSignGreaterThanSignKeyword_1_1_3());
                                

                            }
                            break;

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:219:2: ( (lv_rightPart_6_0= ruleDisjunction ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:220:1: (lv_rightPart_6_0= ruleDisjunction )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:220:1: (lv_rightPart_6_0= ruleDisjunction )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:221:3: lv_rightPart_6_0= ruleDisjunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication487);
                    lv_rightPart_6_0=ruleDisjunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImplicationRule());
                    	        }
                           		set(
                           			current, 
                           			"rightPart",
                            		lv_rightPart_6_0, 
                            		"Disjunction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplication"


    // $ANTLR start "entryRuleDisjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:245:1: entryRuleDisjunction returns [EObject current=null] : iv_ruleDisjunction= ruleDisjunction EOF ;
    public final EObject entryRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:246:2: (iv_ruleDisjunction= ruleDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:247:2: iv_ruleDisjunction= ruleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction525);
            iv_ruleDisjunction=ruleDisjunction();

            state._fsp--;

             current =iv_ruleDisjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction535); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:254:1: ruleDisjunction returns [EObject current=null] : (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* ) ;
    public final EObject ruleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_ExclusiveDisjunction_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:257:28: ( (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:258:1: (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:258:1: (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:259:5: this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction582);
            this_ExclusiveDisjunction_0=ruleExclusiveDisjunction();

            state._fsp--;

             
                    current = this_ExclusiveDisjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:267:1: ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:267:2: () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:267:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:268:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:273:2: (otherlv_2= 'or' | otherlv_3= '|' )
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
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:273:4: otherlv_2= 'or'
            	            {
            	            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleDisjunction604); 

            	                	newLeafNode(otherlv_2, grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:278:7: otherlv_3= '|'
            	            {
            	            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleDisjunction622); 

            	                	newLeafNode(otherlv_3, grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:282:2: ( (lv_parts_4_0= ruleExclusiveDisjunction ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:283:1: (lv_parts_4_0= ruleExclusiveDisjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:283:1: (lv_parts_4_0= ruleExclusiveDisjunction )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:284:3: lv_parts_4_0= ruleExclusiveDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction644);
            	    lv_parts_4_0=ruleExclusiveDisjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDisjunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parts",
            	            		lv_parts_4_0, 
            	            		"ExclusiveDisjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleExclusiveDisjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:308:1: entryRuleExclusiveDisjunction returns [EObject current=null] : iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF ;
    public final EObject entryRuleExclusiveDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveDisjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:309:2: (iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:310:2: iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF
            {
             newCompositeNode(grammarAccess.getExclusiveDisjunctionRule()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction682);
            iv_ruleExclusiveDisjunction=ruleExclusiveDisjunction();

            state._fsp--;

             current =iv_ruleExclusiveDisjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveDisjunction692); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExclusiveDisjunction"


    // $ANTLR start "ruleExclusiveDisjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:317:1: ruleExclusiveDisjunction returns [EObject current=null] : (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* ) ;
    public final EObject ruleExclusiveDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_Conjunction_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:320:28: ( (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:321:1: (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:321:1: (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:322:5: this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction739);
            this_Conjunction_0=ruleConjunction();

            state._fsp--;

             
                    current = this_Conjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:330:1: ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:330:2: () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:330:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:331:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:336:2: (otherlv_2= 'xor' | otherlv_3= '^' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==19) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==20) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:336:4: otherlv_2= 'xor'
            	            {
            	            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleExclusiveDisjunction761); 

            	                	newLeafNode(otherlv_2, grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:341:7: otherlv_3= '^'
            	            {
            	            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleExclusiveDisjunction779); 

            	                	newLeafNode(otherlv_3, grammarAccess.getExclusiveDisjunctionAccess().getCircumflexAccentKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:345:2: ( (lv_parts_4_0= ruleConjunction ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:346:1: (lv_parts_4_0= ruleConjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:346:1: (lv_parts_4_0= ruleConjunction )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:347:3: lv_parts_4_0= ruleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction801);
            	    lv_parts_4_0=ruleConjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExclusiveDisjunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parts",
            	            		lv_parts_4_0, 
            	            		"Conjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExclusiveDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:371:1: entryRuleConjunction returns [EObject current=null] : iv_ruleConjunction= ruleConjunction EOF ;
    public final EObject entryRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:372:2: (iv_ruleConjunction= ruleConjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:373:2: iv_ruleConjunction= ruleConjunction EOF
            {
             newCompositeNode(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction839);
            iv_ruleConjunction=ruleConjunction();

            state._fsp--;

             current =iv_ruleConjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction849); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:380:1: ruleConjunction returns [EObject current=null] : (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* ) ;
    public final EObject ruleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_Negation_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:383:28: ( (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:384:1: (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:384:1: (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:385:5: this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleNegation_in_ruleConjunction896);
            this_Negation_0=ruleNegation();

            state._fsp--;

             
                    current = this_Negation_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:393:1: ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=21 && LA9_0<=22)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:393:2: () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:393:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:394:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:399:2: (otherlv_2= 'and' | otherlv_3= '&' )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==21) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==22) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:399:4: otherlv_2= 'and'
            	            {
            	            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleConjunction918); 

            	                	newLeafNode(otherlv_2, grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:404:7: otherlv_3= '&'
            	            {
            	            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleConjunction936); 

            	                	newLeafNode(otherlv_3, grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:408:2: ( (lv_parts_4_0= ruleNegation ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:409:1: (lv_parts_4_0= ruleNegation )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:409:1: (lv_parts_4_0= ruleNegation )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:410:3: lv_parts_4_0= ruleNegation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNegation_in_ruleConjunction958);
            	    lv_parts_4_0=ruleNegation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConjunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parts",
            	            		lv_parts_4_0, 
            	            		"Negation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:434:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:435:2: (iv_ruleNegation= ruleNegation EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:436:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation996);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation1006); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:443:1: ruleNegation returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:446:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:447:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:447:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==25) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=23 && LA11_0<=24)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:448:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation1053);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:457:6: ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:457:6: ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:457:7: (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:457:7: (otherlv_1= 'not' | otherlv_2= '!' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==23) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==24) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:457:9: otherlv_1= 'not'
                            {
                            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNegation1072); 

                                	newLeafNode(otherlv_1, grammarAccess.getNegationAccess().getNotKeyword_1_0_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:462:7: otherlv_2= '!'
                            {
                            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleNegation1090); 

                                	newLeafNode(otherlv_2, grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_0_1());
                                

                            }
                            break;

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:466:2: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:467:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getNegationAccess().getNegationAction_1_1(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:472:2: ( (lv_expression_4_0= rulePrimaryExpression ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:473:1: (lv_expression_4_0= rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:473:1: (lv_expression_4_0= rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:474:3: lv_expression_4_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation1121);
                    lv_expression_4_0=rulePrimaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNegationRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_4_0, 
                            		"PrimaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:498:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:499:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:500:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1158);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1168); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:507:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Implication_3 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:510:28: ( ( ( () ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:1: ( ( () ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' ) )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:1: ( ( () ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==25) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:2: ( () ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:2: ( () ( (lv_value_1_0= RULE_ID ) ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:3: () ( (lv_value_1_0= RULE_ID ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:511:3: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:512:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getFeatureIdAction_0_0(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:2: ( (lv_value_1_0= RULE_ID ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:518:1: (lv_value_1_0= RULE_ID )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:518:1: (lv_value_1_0= RULE_ID )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:519:3: lv_value_1_0= RULE_ID
                    {
                    lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryExpression1220); 

                    			newLeafNode(lv_value_1_0, grammarAccess.getPrimaryExpressionAccess().getValueIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:536:6: (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:536:6: (otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')' )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:536:8: otherlv_2= '(' this_Implication_3= ruleImplication otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression1245); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getImplicationParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleImplication_in_rulePrimaryExpression1267);
                    this_Implication_3=ruleImplication();

                    state._fsp--;

                     
                            current = this_Implication_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_rulePrimaryExpression1278); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_ruleExpression132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleExpression159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextualExpression204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleContextualExpression241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContextualExpression258 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContextualExpression275 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleContextualExpression296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication389 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_13_in_ruleImplication411 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_14_in_ruleImplication429 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_15_in_ruleImplication447 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_16_in_ruleImplication465 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction582 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_17_in_ruleDisjunction604 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_18_in_ruleDisjunction622 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction644 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveDisjunction692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction739 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleExclusiveDisjunction761 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_20_in_ruleExclusiveDisjunction779 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction801 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction896 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_21_in_ruleConjunction918 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_22_in_ruleConjunction936 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction958 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleNegation1072 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_24_in_ruleNegation1090 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryExpression1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression1245 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleImplication_in_rulePrimaryExpression1267 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePrimaryExpression1278 = new BitSet(new long[]{0x0000000000000002L});

}