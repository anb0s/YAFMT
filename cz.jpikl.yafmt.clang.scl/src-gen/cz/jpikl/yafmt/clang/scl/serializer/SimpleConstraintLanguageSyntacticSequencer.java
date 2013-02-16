package cz.jpikl.yafmt.clang.scl.serializer;

import com.google.inject.Inject;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SimpleConstraintLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SimpleConstraintLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Conjunction_AmpersandKeyword_1_1_1_or_AndKeyword_1_1_0;
	protected AbstractElementAlias match_Disjunction_OrKeyword_1_1_0_or_VerticalLineKeyword_1_1_1;
	protected AbstractElementAlias match_ExclusiveDisjunction_CircumflexAccentKeyword_1_1_1_or_XorKeyword_1_1_0;
	protected AbstractElementAlias match_Implication_EqualsSignGreaterThanSignKeyword_1_1_3_or_HyphenMinusGreaterThanSignKeyword_1_1_2_or_ImpliesKeyword_1_1_0_or_RequiresKeyword_1_1_1;
	protected AbstractElementAlias match_Negation_ExclamationMarkKeyword_1_0_1_or_NotKeyword_1_0_0;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SimpleConstraintLanguageGrammarAccess) access;
		match_Conjunction_AmpersandKeyword_1_1_1_or_AndKeyword_1_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1_1()), new TokenAlias(false, false, grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0()));
		match_Disjunction_OrKeyword_1_1_0_or_VerticalLineKeyword_1_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0()), new TokenAlias(false, false, grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1_1()));
		match_ExclusiveDisjunction_CircumflexAccentKeyword_1_1_1_or_XorKeyword_1_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExclusiveDisjunctionAccess().getCircumflexAccentKeyword_1_1_1()), new TokenAlias(false, false, grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0()));
		match_Implication_EqualsSignGreaterThanSignKeyword_1_1_3_or_HyphenMinusGreaterThanSignKeyword_1_1_2_or_ImpliesKeyword_1_1_0_or_RequiresKeyword_1_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getImplicationAccess().getEqualsSignGreaterThanSignKeyword_1_1_3()), new TokenAlias(false, false, grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1_2()), new TokenAlias(false, false, grammarAccess.getImplicationAccess().getImpliesKeyword_1_1_0()), new TokenAlias(false, false, grammarAccess.getImplicationAccess().getRequiresKeyword_1_1_1()));
		match_Negation_ExclamationMarkKeyword_1_0_1_or_NotKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getNegationAccess().getNotKeyword_1_0_0()));
		match_PrimaryExpression_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
		match_PrimaryExpression_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Conjunction_AmpersandKeyword_1_1_1_or_AndKeyword_1_1_0.equals(syntax))
				emit_Conjunction_AmpersandKeyword_1_1_1_or_AndKeyword_1_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Disjunction_OrKeyword_1_1_0_or_VerticalLineKeyword_1_1_1.equals(syntax))
				emit_Disjunction_OrKeyword_1_1_0_or_VerticalLineKeyword_1_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExclusiveDisjunction_CircumflexAccentKeyword_1_1_1_or_XorKeyword_1_1_0.equals(syntax))
				emit_ExclusiveDisjunction_CircumflexAccentKeyword_1_1_1_or_XorKeyword_1_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Implication_EqualsSignGreaterThanSignKeyword_1_1_3_or_HyphenMinusGreaterThanSignKeyword_1_1_2_or_ImpliesKeyword_1_1_0_or_RequiresKeyword_1_1_1.equals(syntax))
				emit_Implication_EqualsSignGreaterThanSignKeyword_1_1_3_or_HyphenMinusGreaterThanSignKeyword_1_1_2_or_ImpliesKeyword_1_1_0_or_RequiresKeyword_1_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Negation_ExclamationMarkKeyword_1_0_1_or_NotKeyword_1_0_0.equals(syntax))
				emit_Negation_ExclamationMarkKeyword_1_0_1_or_NotKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '&' | 'and'
	 */
	protected void emit_Conjunction_AmpersandKeyword_1_1_1_or_AndKeyword_1_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'or' | '|'
	 */
	protected void emit_Disjunction_OrKeyword_1_1_0_or_VerticalLineKeyword_1_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '^' | 'xor'
	 */
	protected void emit_ExclusiveDisjunction_CircumflexAccentKeyword_1_1_1_or_XorKeyword_1_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'implies' | '->' | '=>' | 'requires'
	 */
	protected void emit_Implication_EqualsSignGreaterThanSignKeyword_1_1_3_or_HyphenMinusGreaterThanSignKeyword_1_1_2_or_ImpliesKeyword_1_1_0_or_RequiresKeyword_1_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '!' | 'not'
	 */
	protected void emit_Negation_ExclamationMarkKeyword_1_0_1_or_NotKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
