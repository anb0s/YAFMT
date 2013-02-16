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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:76:1: ruleExpression returns [EObject current=null] : this_ContextualExpression_0= ruleContextualExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ContextualExpression_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:79:28: (this_ContextualExpression_0= ruleContextualExpression )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:81:5: this_ContextualExpression_0= ruleContextualExpression
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleContextualExpression_in_ruleExpression131);
            this_ContextualExpression_0=ruleContextualExpression();

            state._fsp--;

             
                    current = this_ContextualExpression_0; 
                    afterParserOrEnumRuleCall();
                

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:97:1: entryRuleContextualExpression returns [EObject current=null] : iv_ruleContextualExpression= ruleContextualExpression EOF ;
    public final EObject entryRuleContextualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextualExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:98:2: (iv_ruleContextualExpression= ruleContextualExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:99:2: iv_ruleContextualExpression= ruleContextualExpression EOF
            {
             newCompositeNode(grammarAccess.getContextualExpressionRule()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression165);
            iv_ruleContextualExpression=ruleContextualExpression();

            state._fsp--;

             current =iv_ruleContextualExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextualExpression175); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:106:1: ruleContextualExpression returns [EObject current=null] : ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) ) | this_Implication_5= ruleImplication ) ;
    public final EObject ruleContextualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_contextId_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;

        EObject this_Implication_5 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:109:28: ( ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) ) | this_Implication_5= ruleImplication ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:110:1: ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) ) | this_Implication_5= ruleImplication )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:110:1: ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) ) | this_Implication_5= ruleImplication )
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
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:110:2: (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:110:2: (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:110:4: otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleImplication ) )
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleContextualExpression213); 

                        	newLeafNode(otherlv_0, grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0());
                        
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:114:1: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:115:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:120:2: ( (lv_contextId_2_0= RULE_ID ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:121:1: (lv_contextId_2_0= RULE_ID )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:121:1: (lv_contextId_2_0= RULE_ID )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:122:3: lv_contextId_2_0= RULE_ID
                    {
                    lv_contextId_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContextualExpression239); 

                    			newLeafNode(lv_contextId_2_0, grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContextualExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"contextId",
                            		lv_contextId_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleContextualExpression256); 

                        	newLeafNode(otherlv_3, grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3());
                        
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:142:1: ( (lv_expression_4_0= ruleImplication ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:143:1: (lv_expression_4_0= ruleImplication )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:143:1: (lv_expression_4_0= ruleImplication )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:144:3: lv_expression_4_0= ruleImplication
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImplication_in_ruleContextualExpression277);
                    lv_expression_4_0=ruleImplication();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContextualExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_4_0, 
                            		"Implication");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:162:5: this_Implication_5= ruleImplication
                    {
                     
                            newCompositeNode(grammarAccess.getContextualExpressionAccess().getImplicationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleImplication_in_ruleContextualExpression306);
                    this_Implication_5=ruleImplication();

                    state._fsp--;

                     
                            current = this_Implication_5; 
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
    // $ANTLR end "ruleContextualExpression"


    // $ANTLR start "entryRuleImplication"
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:178:1: entryRuleImplication returns [EObject current=null] : iv_ruleImplication= ruleImplication EOF ;
    public final EObject entryRuleImplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplication = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:179:2: (iv_ruleImplication= ruleImplication EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:180:2: iv_ruleImplication= ruleImplication EOF
            {
             newCompositeNode(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication341);
            iv_ruleImplication=ruleImplication();

            state._fsp--;

             current =iv_ruleImplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication351); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:187:1: ruleImplication returns [EObject current=null] : (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? ) ;
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
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:190:28: ( (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:191:1: (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:191:1: (this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )? )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:192:5: this_Disjunction_0= ruleDisjunction ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication398);
            this_Disjunction_0=ruleDisjunction();

            state._fsp--;

             
                    current = this_Disjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:200:1: ( () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=13 && LA3_0<=16)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:200:2: () (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' ) ( (lv_rightPart_6_0= ruleDisjunction ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:200:2: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:201:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:206:2: (otherlv_2= 'implies' | otherlv_3= 'requires' | otherlv_4= '->' | otherlv_5= '=>' )
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
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:206:4: otherlv_2= 'implies'
                            {
                            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleImplication420); 

                                	newLeafNode(otherlv_2, grammarAccess.getImplicationAccess().getImpliesKeyword_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:211:7: otherlv_3= 'requires'
                            {
                            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImplication438); 

                                	newLeafNode(otherlv_3, grammarAccess.getImplicationAccess().getRequiresKeyword_1_1_1());
                                

                            }
                            break;
                        case 3 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:216:7: otherlv_4= '->'
                            {
                            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleImplication456); 

                                	newLeafNode(otherlv_4, grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2());
                                

                            }
                            break;
                        case 4 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:221:7: otherlv_5= '=>'
                            {
                            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleImplication474); 

                                	newLeafNode(otherlv_5, grammarAccess.getImplicationAccess().getEqualsSignGreaterThanSignKeyword_1_1_3());
                                

                            }
                            break;

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:225:2: ( (lv_rightPart_6_0= ruleDisjunction ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:226:1: (lv_rightPart_6_0= ruleDisjunction )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:226:1: (lv_rightPart_6_0= ruleDisjunction )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:227:3: lv_rightPart_6_0= ruleDisjunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication496);
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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:251:1: entryRuleDisjunction returns [EObject current=null] : iv_ruleDisjunction= ruleDisjunction EOF ;
    public final EObject entryRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:252:2: (iv_ruleDisjunction= ruleDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:253:2: iv_ruleDisjunction= ruleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction534);
            iv_ruleDisjunction=ruleDisjunction();

            state._fsp--;

             current =iv_ruleDisjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction544); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:260:1: ruleDisjunction returns [EObject current=null] : (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* ) ;
    public final EObject ruleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_ExclusiveDisjunction_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:263:28: ( (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:264:1: (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:264:1: (this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:265:5: this_ExclusiveDisjunction_0= ruleExclusiveDisjunction ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getDisjunctionAccess().getExclusiveDisjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction591);
            this_ExclusiveDisjunction_0=ruleExclusiveDisjunction();

            state._fsp--;

             
                    current = this_ExclusiveDisjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:273:1: ( () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:273:2: () (otherlv_2= 'or' | otherlv_3= '|' ) ( (lv_parts_4_0= ruleExclusiveDisjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:273:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:274:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:279:2: (otherlv_2= 'or' | otherlv_3= '|' )
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
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:279:4: otherlv_2= 'or'
            	            {
            	            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleDisjunction613); 

            	                	newLeafNode(otherlv_2, grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:284:7: otherlv_3= '|'
            	            {
            	            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleDisjunction631); 

            	                	newLeafNode(otherlv_3, grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:288:2: ( (lv_parts_4_0= ruleExclusiveDisjunction ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: (lv_parts_4_0= ruleExclusiveDisjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:289:1: (lv_parts_4_0= ruleExclusiveDisjunction )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:290:3: lv_parts_4_0= ruleExclusiveDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDisjunctionAccess().getPartsExclusiveDisjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction653);
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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:314:1: entryRuleExclusiveDisjunction returns [EObject current=null] : iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF ;
    public final EObject entryRuleExclusiveDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveDisjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:315:2: (iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:316:2: iv_ruleExclusiveDisjunction= ruleExclusiveDisjunction EOF
            {
             newCompositeNode(grammarAccess.getExclusiveDisjunctionRule()); 
            pushFollow(FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction691);
            iv_ruleExclusiveDisjunction=ruleExclusiveDisjunction();

            state._fsp--;

             current =iv_ruleExclusiveDisjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveDisjunction701); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:323:1: ruleExclusiveDisjunction returns [EObject current=null] : (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* ) ;
    public final EObject ruleExclusiveDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_Conjunction_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:326:28: ( (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:327:1: (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:327:1: (this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:328:5: this_Conjunction_0= ruleConjunction ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExclusiveDisjunctionAccess().getConjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction748);
            this_Conjunction_0=ruleConjunction();

            state._fsp--;

             
                    current = this_Conjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:336:1: ( () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:336:2: () (otherlv_2= 'xor' | otherlv_3= '^' ) ( (lv_parts_4_0= ruleConjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:336:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:337:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:342:2: (otherlv_2= 'xor' | otherlv_3= '^' )
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
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:342:4: otherlv_2= 'xor'
            	            {
            	            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleExclusiveDisjunction770); 

            	                	newLeafNode(otherlv_2, grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:347:7: otherlv_3= '^'
            	            {
            	            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleExclusiveDisjunction788); 

            	                	newLeafNode(otherlv_3, grammarAccess.getExclusiveDisjunctionAccess().getCircumflexAccentKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:351:2: ( (lv_parts_4_0= ruleConjunction ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:352:1: (lv_parts_4_0= ruleConjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:352:1: (lv_parts_4_0= ruleConjunction )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:353:3: lv_parts_4_0= ruleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExclusiveDisjunctionAccess().getPartsConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction810);
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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:377:1: entryRuleConjunction returns [EObject current=null] : iv_ruleConjunction= ruleConjunction EOF ;
    public final EObject entryRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:378:2: (iv_ruleConjunction= ruleConjunction EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:379:2: iv_ruleConjunction= ruleConjunction EOF
            {
             newCompositeNode(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction848);
            iv_ruleConjunction=ruleConjunction();

            state._fsp--;

             current =iv_ruleConjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction858); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:386:1: ruleConjunction returns [EObject current=null] : (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* ) ;
    public final EObject ruleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_Negation_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:389:28: ( (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:390:1: (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:390:1: (this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )* )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:391:5: this_Negation_0= ruleNegation ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleNegation_in_ruleConjunction905);
            this_Negation_0=ruleNegation();

            state._fsp--;

             
                    current = this_Negation_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:399:1: ( () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=21 && LA9_0<=22)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:399:2: () (otherlv_2= 'and' | otherlv_3= '&' ) ( (lv_parts_4_0= ruleNegation ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:399:2: ()
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:400:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:405:2: (otherlv_2= 'and' | otherlv_3= '&' )
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
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:405:4: otherlv_2= 'and'
            	            {
            	            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleConjunction927); 

            	                	newLeafNode(otherlv_2, grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:410:7: otherlv_3= '&'
            	            {
            	            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleConjunction945); 

            	                	newLeafNode(otherlv_3, grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:414:2: ( (lv_parts_4_0= ruleNegation ) )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:415:1: (lv_parts_4_0= ruleNegation )
            	    {
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:415:1: (lv_parts_4_0= ruleNegation )
            	    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:416:3: lv_parts_4_0= ruleNegation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConjunctionAccess().getPartsNegationParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNegation_in_ruleConjunction967);
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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:440:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:441:2: (iv_ruleNegation= ruleNegation EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:442:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation1005);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation1015); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:449:1: ruleNegation returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:452:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:453:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:453:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) ) )
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
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:454:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation1062);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:463:6: ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:463:6: ( (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:463:7: (otherlv_1= 'not' | otherlv_2= '!' ) () ( (lv_expression_4_0= rulePrimaryExpression ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:463:7: (otherlv_1= 'not' | otherlv_2= '!' )
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
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:463:9: otherlv_1= 'not'
                            {
                            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNegation1081); 

                                	newLeafNode(otherlv_1, grammarAccess.getNegationAccess().getNotKeyword_1_0_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:468:7: otherlv_2= '!'
                            {
                            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleNegation1099); 

                                	newLeafNode(otherlv_2, grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_0_1());
                                

                            }
                            break;

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:472:2: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:473:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getNegationAccess().getNegationAction_1_1(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:478:2: ( (lv_expression_4_0= rulePrimaryExpression ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:479:1: (lv_expression_4_0= rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:479:1: (lv_expression_4_0= rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:480:3: lv_expression_4_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation1130);
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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:504:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:505:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:506:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1167);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1177); 

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
    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:513:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_featureId_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Expression_3 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:516:28: ( ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) ) )
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:1: ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) )
            {
            // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:1: ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) )
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
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:2: ( () ( (lv_featureId_1_0= RULE_ID ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:2: ( () ( (lv_featureId_1_0= RULE_ID ) ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:3: () ( (lv_featureId_1_0= RULE_ID ) )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:517:3: ()
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:518:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:523:2: ( (lv_featureId_1_0= RULE_ID ) )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:524:1: (lv_featureId_1_0= RULE_ID )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:524:1: (lv_featureId_1_0= RULE_ID )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:525:3: lv_featureId_1_0= RULE_ID
                    {
                    lv_featureId_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryExpression1229); 

                    			newLeafNode(lv_featureId_1_0, grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"featureId",
                            		lv_featureId_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:542:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    {
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:542:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    // ../cz.jpikl.yafmt.clang.scl/src-gen/cz/jpikl/yafmt/clang/scl/parser/antlr/internal/InternalSimpleConstraintLanguage.g:542:8: otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_rulePrimaryExpression1254); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression1276);
                    this_Expression_3=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_rulePrimaryExpression1287); 

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
    public static final BitSet FOLLOW_ruleContextualExpression_in_ruleExpression131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextualExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleContextualExpression213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContextualExpression239 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContextualExpression256 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleContextualExpression277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleContextualExpression306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication398 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_13_in_ruleImplication420 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_14_in_ruleImplication438 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_15_in_ruleImplication456 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_16_in_ruleImplication474 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction591 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_17_in_ruleDisjunction613 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_18_in_ruleDisjunction631 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_ruleDisjunction653 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleExclusiveDisjunction_in_entryRuleExclusiveDisjunction691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveDisjunction701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction748 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleExclusiveDisjunction770 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_20_in_ruleExclusiveDisjunction788 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleExclusiveDisjunction810 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction905 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_21_in_ruleConjunction927 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_22_in_ruleConjunction945 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction967 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation1005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleNegation1081 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_24_in_ruleNegation1099 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryExpression1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePrimaryExpression1254 = new BitSet(new long[]{0x0000000003800810L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression1276 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePrimaryExpression1287 = new BitSet(new long[]{0x0000000000000002L});

}