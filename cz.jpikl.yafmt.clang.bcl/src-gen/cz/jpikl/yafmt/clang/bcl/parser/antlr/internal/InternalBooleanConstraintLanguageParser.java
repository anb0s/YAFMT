package cz.jpikl.yafmt.clang.bcl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import cz.jpikl.yafmt.clang.bcl.services.BooleanConstraintLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBooleanConstraintLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "':'", "'equals'", "'implies'", "'or'", "'and'", "'not'", "'('", "')'"
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
    public String getGrammarFileName() { return "../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g"; }



     	private BooleanConstraintLanguageGrammarAccess grammarAccess;
     	
        public InternalBooleanConstraintLanguageParser(TokenStream input, BooleanConstraintLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Expression";	
       	}
       	
       	@Override
       	protected BooleanConstraintLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleExpression"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:67:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:68:2: (iv_ruleExpression= ruleExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:69:2: iv_ruleExpression= ruleExpression EOF
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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:76:1: ruleExpression returns [EObject current=null] : this_ContextualExpression_0= ruleContextualExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ContextualExpression_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:79:28: (this_ContextualExpression_0= ruleContextualExpression )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:81:5: this_ContextualExpression_0= ruleContextualExpression
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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:97:1: entryRuleContextualExpression returns [EObject current=null] : iv_ruleContextualExpression= ruleContextualExpression EOF ;
    public final EObject entryRuleContextualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextualExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:98:2: (iv_ruleContextualExpression= ruleContextualExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:99:2: iv_ruleContextualExpression= ruleContextualExpression EOF
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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:106:1: ruleContextualExpression returns [EObject current=null] : ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) ) | this_Equation_5= ruleEquation ) ;
    public final EObject ruleContextualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_contextId_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;

        EObject this_Equation_5 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:109:28: ( ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) ) | this_Equation_5= ruleEquation ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:110:1: ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) ) | this_Equation_5= ruleEquation )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:110:1: ( (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) ) | this_Equation_5= ruleEquation )
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
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:110:2: (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:110:2: (otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:110:4: otherlv_0= 'context' () ( (lv_contextId_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleEquation ) )
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleContextualExpression213); 

                        	newLeafNode(otherlv_0, grammarAccess.getContextualExpressionAccess().getContextKeyword_0_0());
                        
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:114:1: ()
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:115:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getContextualExpressionAccess().getContextualExpressionAction_0_1(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:120:2: ( (lv_contextId_2_0= RULE_ID ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:121:1: (lv_contextId_2_0= RULE_ID )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:121:1: (lv_contextId_2_0= RULE_ID )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:122:3: lv_contextId_2_0= RULE_ID
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
                        
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:142:1: ( (lv_expression_4_0= ruleEquation ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:143:1: (lv_expression_4_0= ruleEquation )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:143:1: (lv_expression_4_0= ruleEquation )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:144:3: lv_expression_4_0= ruleEquation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEquation_in_ruleContextualExpression277);
                    lv_expression_4_0=ruleEquation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContextualExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_4_0, 
                            		"Equation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:162:5: this_Equation_5= ruleEquation
                    {
                     
                            newCompositeNode(grammarAccess.getContextualExpressionAccess().getEquationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEquation_in_ruleContextualExpression306);
                    this_Equation_5=ruleEquation();

                    state._fsp--;

                     
                            current = this_Equation_5; 
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


    // $ANTLR start "entryRuleEquation"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:178:1: entryRuleEquation returns [EObject current=null] : iv_ruleEquation= ruleEquation EOF ;
    public final EObject entryRuleEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquation = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:179:2: (iv_ruleEquation= ruleEquation EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:180:2: iv_ruleEquation= ruleEquation EOF
            {
             newCompositeNode(grammarAccess.getEquationRule()); 
            pushFollow(FOLLOW_ruleEquation_in_entryRuleEquation341);
            iv_ruleEquation=ruleEquation();

            state._fsp--;

             current =iv_ruleEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquation351); 

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
    // $ANTLR end "entryRuleEquation"


    // $ANTLR start "ruleEquation"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:187:1: ruleEquation returns [EObject current=null] : (this_Implication_0= ruleImplication ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )* ) ;
    public final EObject ruleEquation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Implication_0 = null;

        EObject lv_rightPart_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:190:28: ( (this_Implication_0= ruleImplication ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:191:1: (this_Implication_0= ruleImplication ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:191:1: (this_Implication_0= ruleImplication ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )* )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:192:5: this_Implication_0= ruleImplication ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getEquationAccess().getImplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleImplication_in_ruleEquation398);
            this_Implication_0=ruleImplication();

            state._fsp--;

             
                    current = this_Implication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:200:1: ( () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:200:2: () otherlv_2= 'equals' ( (lv_rightPart_3_0= ruleImplication ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:200:2: ()
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:201:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleEquation419); 

            	        	newLeafNode(otherlv_2, grammarAccess.getEquationAccess().getEqualsKeyword_1_1());
            	        
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:210:1: ( (lv_rightPart_3_0= ruleImplication ) )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:211:1: (lv_rightPart_3_0= ruleImplication )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:211:1: (lv_rightPart_3_0= ruleImplication )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:212:3: lv_rightPart_3_0= ruleImplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImplication_in_ruleEquation440);
            	    lv_rightPart_3_0=ruleImplication();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEquationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rightPart",
            	            		lv_rightPart_3_0, 
            	            		"Implication");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleEquation"


    // $ANTLR start "entryRuleImplication"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:236:1: entryRuleImplication returns [EObject current=null] : iv_ruleImplication= ruleImplication EOF ;
    public final EObject entryRuleImplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplication = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:237:2: (iv_ruleImplication= ruleImplication EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:238:2: iv_ruleImplication= ruleImplication EOF
            {
             newCompositeNode(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication478);
            iv_ruleImplication=ruleImplication();

            state._fsp--;

             current =iv_ruleImplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication488); 

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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:245:1: ruleImplication returns [EObject current=null] : (this_Disjunction_0= ruleDisjunction ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )* ) ;
    public final EObject ruleImplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Disjunction_0 = null;

        EObject lv_rightPart_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:248:28: ( (this_Disjunction_0= ruleDisjunction ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:249:1: (this_Disjunction_0= ruleDisjunction ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:249:1: (this_Disjunction_0= ruleDisjunction ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:250:5: this_Disjunction_0= ruleDisjunction ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication535);
            this_Disjunction_0=ruleDisjunction();

            state._fsp--;

             
                    current = this_Disjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:258:1: ( () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:258:2: () otherlv_2= 'implies' ( (lv_rightPart_3_0= ruleDisjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:258:2: ()
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:259:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleImplication556); 

            	        	newLeafNode(otherlv_2, grammarAccess.getImplicationAccess().getImpliesKeyword_1_1());
            	        
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:268:1: ( (lv_rightPart_3_0= ruleDisjunction ) )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:269:1: (lv_rightPart_3_0= ruleDisjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:269:1: (lv_rightPart_3_0= ruleDisjunction )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:270:3: lv_rightPart_3_0= ruleDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDisjunction_in_ruleImplication577);
            	    lv_rightPart_3_0=ruleDisjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getImplicationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rightPart",
            	            		lv_rightPart_3_0, 
            	            		"Disjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleImplication"


    // $ANTLR start "entryRuleDisjunction"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:294:1: entryRuleDisjunction returns [EObject current=null] : iv_ruleDisjunction= ruleDisjunction EOF ;
    public final EObject entryRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:295:2: (iv_ruleDisjunction= ruleDisjunction EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:296:2: iv_ruleDisjunction= ruleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction615);
            iv_ruleDisjunction=ruleDisjunction();

            state._fsp--;

             current =iv_ruleDisjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction625); 

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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:303:1: ruleDisjunction returns [EObject current=null] : (this_Conjunction_0= ruleConjunction ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )* ) ;
    public final EObject ruleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Conjunction_0 = null;

        EObject lv_rightPart_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:306:28: ( (this_Conjunction_0= ruleConjunction ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:307:1: (this_Conjunction_0= ruleConjunction ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:307:1: (this_Conjunction_0= ruleConjunction ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )* )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:308:5: this_Conjunction_0= ruleConjunction ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleConjunction_in_ruleDisjunction672);
            this_Conjunction_0=ruleConjunction();

            state._fsp--;

             
                    current = this_Conjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:316:1: ( () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:316:2: () otherlv_2= 'or' ( (lv_rightPart_3_0= ruleConjunction ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:316:2: ()
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:317:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleDisjunction693); 

            	        	newLeafNode(otherlv_2, grammarAccess.getDisjunctionAccess().getOrKeyword_1_1());
            	        
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:326:1: ( (lv_rightPart_3_0= ruleConjunction ) )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:327:1: (lv_rightPart_3_0= ruleConjunction )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:327:1: (lv_rightPart_3_0= ruleConjunction )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:328:3: lv_rightPart_3_0= ruleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConjunction_in_ruleDisjunction714);
            	    lv_rightPart_3_0=ruleConjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDisjunctionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rightPart",
            	            		lv_rightPart_3_0, 
            	            		"Conjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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


    // $ANTLR start "entryRuleConjunction"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:352:1: entryRuleConjunction returns [EObject current=null] : iv_ruleConjunction= ruleConjunction EOF ;
    public final EObject entryRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConjunction = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:353:2: (iv_ruleConjunction= ruleConjunction EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:354:2: iv_ruleConjunction= ruleConjunction EOF
            {
             newCompositeNode(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction752);
            iv_ruleConjunction=ruleConjunction();

            state._fsp--;

             current =iv_ruleConjunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction762); 

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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:361:1: ruleConjunction returns [EObject current=null] : (this_Negation_0= ruleNegation ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )* ) ;
    public final EObject ruleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Negation_0 = null;

        EObject lv_rightPart_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:364:28: ( (this_Negation_0= ruleNegation ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )* ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:365:1: (this_Negation_0= ruleNegation ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )* )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:365:1: (this_Negation_0= ruleNegation ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )* )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:366:5: this_Negation_0= ruleNegation ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleNegation_in_ruleConjunction809);
            this_Negation_0=ruleNegation();

            state._fsp--;

             
                    current = this_Negation_0; 
                    afterParserOrEnumRuleCall();
                
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:374:1: ( () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:374:2: () otherlv_2= 'and' ( (lv_rightPart_3_0= ruleNegation ) )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:374:2: ()
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:375:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConjunction830); 

            	        	newLeafNode(otherlv_2, grammarAccess.getConjunctionAccess().getAndKeyword_1_1());
            	        
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:384:1: ( (lv_rightPart_3_0= ruleNegation ) )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:385:1: (lv_rightPart_3_0= ruleNegation )
            	    {
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:385:1: (lv_rightPart_3_0= ruleNegation )
            	    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:386:3: lv_rightPart_3_0= ruleNegation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNegation_in_ruleConjunction851);
            	    lv_rightPart_3_0=ruleNegation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConjunctionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rightPart",
            	            		lv_rightPart_3_0, 
            	            		"Negation");
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
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:410:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:411:2: (iv_ruleNegation= ruleNegation EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:412:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation889);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation899); 

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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:419:1: ruleNegation returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:422:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) ) ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:423:1: (this_PrimaryExpression_0= rulePrimaryExpression | (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:423:1: (this_PrimaryExpression_0= rulePrimaryExpression | (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:424:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation946);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:433:6: (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:433:6: (otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:433:8: otherlv_1= 'not' () ( (lv_expression_3_0= rulePrimaryExpression ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleNegation964); 

                        	newLeafNode(otherlv_1, grammarAccess.getNegationAccess().getNotKeyword_1_0());
                        
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:437:1: ()
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:438:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getNegationAccess().getNegationAction_1_1(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:443:2: ( (lv_expression_3_0= rulePrimaryExpression ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:444:1: (lv_expression_3_0= rulePrimaryExpression )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:444:1: (lv_expression_3_0= rulePrimaryExpression )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:445:3: lv_expression_3_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNegation994);
                    lv_expression_3_0=rulePrimaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNegationRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_3_0, 
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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:469:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:470:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:471:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1031);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1041); 

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
    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:478:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_featureId_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Expression_3 = null;


         enterRule(); 
            
        try {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:481:28: ( ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) ) )
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:1: ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) )
            {
            // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:1: ( ( () ( (lv_featureId_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==18) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:2: ( () ( (lv_featureId_1_0= RULE_ID ) ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:2: ( () ( (lv_featureId_1_0= RULE_ID ) ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:3: () ( (lv_featureId_1_0= RULE_ID ) )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:482:3: ()
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:483:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0(),
                                current);
                        

                    }

                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:488:2: ( (lv_featureId_1_0= RULE_ID ) )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:489:1: (lv_featureId_1_0= RULE_ID )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:489:1: (lv_featureId_1_0= RULE_ID )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:490:3: lv_featureId_1_0= RULE_ID
                    {
                    lv_featureId_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryExpression1093); 

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
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:507:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    {
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:507:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    // ../cz.jpikl.yafmt.clang.bcl/src-gen/cz/jpikl/yafmt/clang/bcl/parser/antlr/internal/InternalBooleanConstraintLanguage.g:507:8: otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_rulePrimaryExpression1118); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression1140);
                    this_Expression_3=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_rulePrimaryExpression1151); 

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
    public static final BitSet FOLLOW_12_in_ruleContextualExpression256 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_ruleEquation_in_ruleContextualExpression277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_ruleContextualExpression306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_entryRuleEquation341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquation351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleEquation398 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleEquation419 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_ruleImplication_in_ruleEquation440 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication535 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleImplication556 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_ruleDisjunction_in_ruleImplication577 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleDisjunction672 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleDisjunction693 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_ruleConjunction_in_ruleDisjunction714 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction809 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleConjunction830 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleConjunction851 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNegation964 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNegation994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryExpression1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulePrimaryExpression1118 = new BitSet(new long[]{0x0000000000060810L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression1140 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimaryExpression1151 = new BitSet(new long[]{0x0000000000000002L});

}