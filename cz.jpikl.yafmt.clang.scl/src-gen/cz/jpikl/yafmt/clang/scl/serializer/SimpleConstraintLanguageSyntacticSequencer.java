package cz.jpikl.yafmt.clang.scl.serializer;

import com.google.inject.Inject;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SimpleConstraintLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SimpleConstraintLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Conjunction_AndKeyword_1_1_0_q;
	protected AbstractElementAlias match_Disjunction_OrKeyword_1_1_0_q;
	protected AbstractElementAlias match_ExclusiveDisjunction_XorKeyword_1_1_0_q;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SimpleConstraintLanguageGrammarAccess) access;
		match_Conjunction_AndKeyword_1_1_0_q = new TokenAlias(false, true, grammarAccess.getConjunctionAccess().getAndKeyword_1_1_0());
		match_Disjunction_OrKeyword_1_1_0_q = new TokenAlias(false, true, grammarAccess.getDisjunctionAccess().getOrKeyword_1_1_0());
		match_ExclusiveDisjunction_XorKeyword_1_1_0_q = new TokenAlias(false, true, grammarAccess.getExclusiveDisjunctionAccess().getXorKeyword_1_1_0());
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
			if(match_Conjunction_AndKeyword_1_1_0_q.equals(syntax))
				emit_Conjunction_AndKeyword_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Disjunction_OrKeyword_1_1_0_q.equals(syntax))
				emit_Disjunction_OrKeyword_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExclusiveDisjunction_XorKeyword_1_1_0_q.equals(syntax))
				emit_ExclusiveDisjunction_XorKeyword_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'and'?
	 */
	protected void emit_Conjunction_AndKeyword_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'or'?
	 */
	protected void emit_Disjunction_OrKeyword_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'xor'?
	 */
	protected void emit_ExclusiveDisjunction_XorKeyword_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
