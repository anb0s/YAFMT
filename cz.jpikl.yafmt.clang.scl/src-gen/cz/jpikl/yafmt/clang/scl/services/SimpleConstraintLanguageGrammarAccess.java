/*
* generated by Xtext
*/

package cz.jpikl.yafmt.clang.scl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class SimpleConstraintLanguageGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final RuleCall cContextualExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//// Unassigned rule call
		//// 
		//// It simply call ContextualExpression rule.
		//// The return type is Expression (abstract class for all kinds of expressions).
		//Expression:
		//	ContextualExpression;
		public ParserRule getRule() { return rule; }

		//ContextualExpression
		public RuleCall getContextualExpressionParserRuleCall() { return cContextualExpressionParserRuleCall; }
	}

	public class ContextualExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ContextualExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cContextKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Action cContextualExpressionAction_0_1 = (Action)cGroup_0.eContents().get(1);
		private final Assignment cContextIdAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cContextIdIDTerminalRuleCall_0_2_0 = (RuleCall)cContextIdAssignment_0_2.eContents().get(0);
		private final Keyword cColonKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Assignment cExpressionAssignment_0_4 = (Assignment)cGroup_0.eContents().get(4);
		private final RuleCall cExpressionImplicationParserRuleCall_0_4_0 = (RuleCall)cExpressionAssignment_0_4.eContents().get(0);
		private final RuleCall cImplicationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// Uses simple action: {ExplicitReturnType} memberVariable=value.
		////
		//// If there is 'context' token at input, instance of ContextualExpression is returned. 
		//// Value contains the parsed ID and expression contains the result of Implication rule.
		//// Otherwise (no 'context' found), the result of Implication rule is returned. 
		//ContextualExpression returns Expression:
		//	"context" {ContextualExpression} contextId=ID ":" expression=Implication | Implication;
		public ParserRule getRule() { return rule; }

		//"context" {ContextualExpression} contextId=ID ":" expression=Implication | Implication
		public Alternatives getAlternatives() { return cAlternatives; }

		//"context" {ContextualExpression} contextId=ID ":" expression=Implication
		public Group getGroup_0() { return cGroup_0; }

		//"context"
		public Keyword getContextKeyword_0_0() { return cContextKeyword_0_0; }

		//{ContextualExpression}
		public Action getContextualExpressionAction_0_1() { return cContextualExpressionAction_0_1; }

		//contextId=ID
		public Assignment getContextIdAssignment_0_2() { return cContextIdAssignment_0_2; }

		//ID
		public RuleCall getContextIdIDTerminalRuleCall_0_2_0() { return cContextIdIDTerminalRuleCall_0_2_0; }

		//":"
		public Keyword getColonKeyword_0_3() { return cColonKeyword_0_3; }

		//expression=Implication
		public Assignment getExpressionAssignment_0_4() { return cExpressionAssignment_0_4; }

		//Implication
		public RuleCall getExpressionImplicationParserRuleCall_0_4_0() { return cExpressionImplicationParserRuleCall_0_4_0; }

		//Implication
		public RuleCall getImplicationParserRuleCall_1() { return cImplicationParserRuleCall_1; }
	}

	public class ImplicationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Implication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cDisjunctionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cImplicationLeftPartAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cImpliesKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightPartAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightPartDisjunctionParserRuleCall_1_2_0 = (RuleCall)cRightPartAssignment_1_2.eContents().get(0);
		
		//Implication returns Expression:
		//	Disjunction ({Implication.leftPart=current} "implies" rightPart=Disjunction)?;
		public ParserRule getRule() { return rule; }

		//Disjunction ({Implication.leftPart=current} "implies" rightPart=Disjunction)?
		public Group getGroup() { return cGroup; }

		//Disjunction
		public RuleCall getDisjunctionParserRuleCall_0() { return cDisjunctionParserRuleCall_0; }

		//({Implication.leftPart=current} "implies" rightPart=Disjunction)?
		public Group getGroup_1() { return cGroup_1; }

		//{Implication.leftPart=current}
		public Action getImplicationLeftPartAction_1_0() { return cImplicationLeftPartAction_1_0; }

		//"implies"
		public Keyword getImpliesKeyword_1_1() { return cImpliesKeyword_1_1; }

		//rightPart=Disjunction
		public Assignment getRightPartAssignment_1_2() { return cRightPartAssignment_1_2; }

		//Disjunction
		public RuleCall getRightPartDisjunctionParserRuleCall_1_2_0() { return cRightPartDisjunctionParserRuleCall_1_2_0; }
	}

	public class DisjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Disjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cExclusiveDisjunctionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cDisjunctionPartsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cOrKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cPartsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cPartsExclusiveDisjunctionParserRuleCall_1_2_0 = (RuleCall)cPartsAssignment_1_2.eContents().get(0);
		
		//// Uses assigned action: {ExplicitReturnType.memberVariable=value}.
		//// This particular case is also called tree rewrite action.
		////
		//// If there is no 'or' token, the rule simply returns result of the only one ExclusiveDisjunction rule.
		////
		//// Otherwise, instance of Disjunction is returned. Parts array contains results of parsed ExclusiveDisjunction 
		//// rules. The result of the first one ExclusiveDisjunction (current keyword) was in that case added 
		//// to the parts array. Current then became the resulting Disjunction.
		////    Disjunction disjunction = new Disjunction();
		////    disjunction.getParts().add(current);
		////    current = disjunction;
		//Disjunction returns Expression:
		//	ExclusiveDisjunction ({Disjunction.parts+=current} "or" parts+=ExclusiveDisjunction)*;
		public ParserRule getRule() { return rule; }

		//ExclusiveDisjunction ({Disjunction.parts+=current} "or" parts+=ExclusiveDisjunction)*
		public Group getGroup() { return cGroup; }

		//ExclusiveDisjunction
		public RuleCall getExclusiveDisjunctionParserRuleCall_0() { return cExclusiveDisjunctionParserRuleCall_0; }

		//({Disjunction.parts+=current} "or" parts+=ExclusiveDisjunction)*
		public Group getGroup_1() { return cGroup_1; }

		//{Disjunction.parts+=current}
		public Action getDisjunctionPartsAction_1_0() { return cDisjunctionPartsAction_1_0; }

		//"or"
		public Keyword getOrKeyword_1_1() { return cOrKeyword_1_1; }

		//parts+=ExclusiveDisjunction
		public Assignment getPartsAssignment_1_2() { return cPartsAssignment_1_2; }

		//ExclusiveDisjunction
		public RuleCall getPartsExclusiveDisjunctionParserRuleCall_1_2_0() { return cPartsExclusiveDisjunctionParserRuleCall_1_2_0; }
	}

	public class ExclusiveDisjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExclusiveDisjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cConjunctionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExclusiveDisjunctionPartsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cXorKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cPartsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cPartsConjunctionParserRuleCall_1_2_0 = (RuleCall)cPartsAssignment_1_2.eContents().get(0);
		
		//ExclusiveDisjunction returns Expression:
		//	Conjunction ({ExclusiveDisjunction.parts+=current} "xor" parts+=Conjunction)*;
		public ParserRule getRule() { return rule; }

		//Conjunction ({ExclusiveDisjunction.parts+=current} "xor" parts+=Conjunction)*
		public Group getGroup() { return cGroup; }

		//Conjunction
		public RuleCall getConjunctionParserRuleCall_0() { return cConjunctionParserRuleCall_0; }

		//({ExclusiveDisjunction.parts+=current} "xor" parts+=Conjunction)*
		public Group getGroup_1() { return cGroup_1; }

		//{ExclusiveDisjunction.parts+=current}
		public Action getExclusiveDisjunctionPartsAction_1_0() { return cExclusiveDisjunctionPartsAction_1_0; }

		//"xor"
		public Keyword getXorKeyword_1_1() { return cXorKeyword_1_1; }

		//parts+=Conjunction
		public Assignment getPartsAssignment_1_2() { return cPartsAssignment_1_2; }

		//Conjunction
		public RuleCall getPartsConjunctionParserRuleCall_1_2_0() { return cPartsConjunctionParserRuleCall_1_2_0; }
	}

	public class ConjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Conjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNegationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cConjunctionPartsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAndKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cPartsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cPartsNegationParserRuleCall_1_2_0 = (RuleCall)cPartsAssignment_1_2.eContents().get(0);
		
		//Conjunction returns Expression:
		//	Negation ({Conjunction.parts+=current} "and" parts+=Negation)*;
		public ParserRule getRule() { return rule; }

		//Negation ({Conjunction.parts+=current} "and" parts+=Negation)*
		public Group getGroup() { return cGroup; }

		//Negation
		public RuleCall getNegationParserRuleCall_0() { return cNegationParserRuleCall_0; }

		//({Conjunction.parts+=current} "and" parts+=Negation)*
		public Group getGroup_1() { return cGroup_1; }

		//{Conjunction.parts+=current}
		public Action getConjunctionPartsAction_1_0() { return cConjunctionPartsAction_1_0; }

		//"and"
		public Keyword getAndKeyword_1_1() { return cAndKeyword_1_1; }

		//parts+=Negation
		public Assignment getPartsAssignment_1_2() { return cPartsAssignment_1_2; }

		//Negation
		public RuleCall getPartsNegationParserRuleCall_1_2_0() { return cPartsNegationParserRuleCall_1_2_0; }
	}

	public class NegationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Negation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPrimaryExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cNotKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Action cNegationAction_1_1 = (Action)cGroup_1.eContents().get(1);
		private final Assignment cExpressionAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cExpressionPrimaryExpressionParserRuleCall_1_2_0 = (RuleCall)cExpressionAssignment_1_2.eContents().get(0);
		
		//Negation returns Expression:
		//	PrimaryExpression | "not" {Negation} expression=PrimaryExpression;
		public ParserRule getRule() { return rule; }

		//PrimaryExpression | "not" {Negation} expression=PrimaryExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//PrimaryExpression
		public RuleCall getPrimaryExpressionParserRuleCall_0() { return cPrimaryExpressionParserRuleCall_0; }

		//"not" {Negation} expression=PrimaryExpression
		public Group getGroup_1() { return cGroup_1; }

		//"not"
		public Keyword getNotKeyword_1_0() { return cNotKeyword_1_0; }

		//{Negation}
		public Action getNegationAction_1_1() { return cNegationAction_1_1; }

		//expression=PrimaryExpression
		public Assignment getExpressionAssignment_1_2() { return cExpressionAssignment_1_2; }

		//PrimaryExpression
		public RuleCall getExpressionPrimaryExpressionParserRuleCall_1_2_0() { return cExpressionPrimaryExpressionParserRuleCall_1_2_0; }
	}

	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cPrimaryExpressionAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cFeatureIdAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cFeatureIdIDTerminalRuleCall_0_1_0 = (RuleCall)cFeatureIdAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//PrimaryExpression returns Expression:
		//	{PrimaryExpression} featureId=ID | "(" Expression ")";
		public ParserRule getRule() { return rule; }

		//{PrimaryExpression} featureId=ID | "(" Expression ")"
		public Alternatives getAlternatives() { return cAlternatives; }

		//{PrimaryExpression} featureId=ID
		public Group getGroup_0() { return cGroup_0; }

		//{PrimaryExpression}
		public Action getPrimaryExpressionAction_0_0() { return cPrimaryExpressionAction_0_0; }

		//featureId=ID
		public Assignment getFeatureIdAssignment_0_1() { return cFeatureIdAssignment_0_1; }

		//ID
		public RuleCall getFeatureIdIDTerminalRuleCall_0_1_0() { return cFeatureIdIDTerminalRuleCall_0_1_0; }

		//"(" Expression ")"
		public Group getGroup_1() { return cGroup_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//Expression
		public RuleCall getExpressionParserRuleCall_1_1() { return cExpressionParserRuleCall_1_1; }

		//")"
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}
	
	
	private ExpressionElements pExpression;
	private ContextualExpressionElements pContextualExpression;
	private ImplicationElements pImplication;
	private DisjunctionElements pDisjunction;
	private ExclusiveDisjunctionElements pExclusiveDisjunction;
	private ConjunctionElements pConjunction;
	private NegationElements pNegation;
	private PrimaryExpressionElements pPrimaryExpression;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public SimpleConstraintLanguageGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("cz.jpikl.yafmt.clang.scl.SimpleConstraintLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//// Unassigned rule call
	//// 
	//// It simply call ContextualExpression rule.
	//// The return type is Expression (abstract class for all kinds of expressions).
	//Expression:
	//	ContextualExpression;
	public ExpressionElements getExpressionAccess() {
		return (pExpression != null) ? pExpression : (pExpression = new ExpressionElements());
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//// Uses simple action: {ExplicitReturnType} memberVariable=value.
	////
	//// If there is 'context' token at input, instance of ContextualExpression is returned. 
	//// Value contains the parsed ID and expression contains the result of Implication rule.
	//// Otherwise (no 'context' found), the result of Implication rule is returned. 
	//ContextualExpression returns Expression:
	//	"context" {ContextualExpression} contextId=ID ":" expression=Implication | Implication;
	public ContextualExpressionElements getContextualExpressionAccess() {
		return (pContextualExpression != null) ? pContextualExpression : (pContextualExpression = new ContextualExpressionElements());
	}
	
	public ParserRule getContextualExpressionRule() {
		return getContextualExpressionAccess().getRule();
	}

	//Implication returns Expression:
	//	Disjunction ({Implication.leftPart=current} "implies" rightPart=Disjunction)?;
	public ImplicationElements getImplicationAccess() {
		return (pImplication != null) ? pImplication : (pImplication = new ImplicationElements());
	}
	
	public ParserRule getImplicationRule() {
		return getImplicationAccess().getRule();
	}

	//// Uses assigned action: {ExplicitReturnType.memberVariable=value}.
	//// This particular case is also called tree rewrite action.
	////
	//// If there is no 'or' token, the rule simply returns result of the only one ExclusiveDisjunction rule.
	////
	//// Otherwise, instance of Disjunction is returned. Parts array contains results of parsed ExclusiveDisjunction 
	//// rules. The result of the first one ExclusiveDisjunction (current keyword) was in that case added 
	//// to the parts array. Current then became the resulting Disjunction.
	////    Disjunction disjunction = new Disjunction();
	////    disjunction.getParts().add(current);
	////    current = disjunction;
	//Disjunction returns Expression:
	//	ExclusiveDisjunction ({Disjunction.parts+=current} "or" parts+=ExclusiveDisjunction)*;
	public DisjunctionElements getDisjunctionAccess() {
		return (pDisjunction != null) ? pDisjunction : (pDisjunction = new DisjunctionElements());
	}
	
	public ParserRule getDisjunctionRule() {
		return getDisjunctionAccess().getRule();
	}

	//ExclusiveDisjunction returns Expression:
	//	Conjunction ({ExclusiveDisjunction.parts+=current} "xor" parts+=Conjunction)*;
	public ExclusiveDisjunctionElements getExclusiveDisjunctionAccess() {
		return (pExclusiveDisjunction != null) ? pExclusiveDisjunction : (pExclusiveDisjunction = new ExclusiveDisjunctionElements());
	}
	
	public ParserRule getExclusiveDisjunctionRule() {
		return getExclusiveDisjunctionAccess().getRule();
	}

	//Conjunction returns Expression:
	//	Negation ({Conjunction.parts+=current} "and" parts+=Negation)*;
	public ConjunctionElements getConjunctionAccess() {
		return (pConjunction != null) ? pConjunction : (pConjunction = new ConjunctionElements());
	}
	
	public ParserRule getConjunctionRule() {
		return getConjunctionAccess().getRule();
	}

	//Negation returns Expression:
	//	PrimaryExpression | "not" {Negation} expression=PrimaryExpression;
	public NegationElements getNegationAccess() {
		return (pNegation != null) ? pNegation : (pNegation = new NegationElements());
	}
	
	public ParserRule getNegationRule() {
		return getNegationAccess().getRule();
	}

	//PrimaryExpression returns Expression:
	//	{PrimaryExpression} featureId=ID | "(" Expression ")";
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return (pPrimaryExpression != null) ? pPrimaryExpression : (pPrimaryExpression = new PrimaryExpressionElements());
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
