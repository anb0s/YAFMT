package cz.jpikl.yafmt.clang.scl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import cz.jpikl.yafmt.clang.scl.model.Conjunction;
import cz.jpikl.yafmt.clang.scl.model.ContextualExpression;
import cz.jpikl.yafmt.clang.scl.model.Disjunction;
import cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction;
import cz.jpikl.yafmt.clang.scl.model.FeatureId;
import cz.jpikl.yafmt.clang.scl.model.Implication;
import cz.jpikl.yafmt.clang.scl.model.ModelPackage;
import cz.jpikl.yafmt.clang.scl.model.Negation;
import cz.jpikl.yafmt.clang.scl.services.SimpleConstraintLanguageGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class SimpleConstraintLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SimpleConstraintLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ModelPackage.CONJUNCTION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Conjunction(context, (Conjunction) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.CONTEXTUAL_EXPRESSION:
				if(context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_ContextualExpression(context, (ContextualExpression) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.DISJUNCTION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Disjunction(context, (Disjunction) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.EXCLUSIVE_DISJUNCTION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_ExclusiveDisjunction(context, (ExclusiveDisjunction) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.FEATURE_ID:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression(context, (FeatureId) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.IMPLICATION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Implication(context, (Implication) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.NEGATION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionPartsAction_1_0() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExclusiveDisjunctionRule() ||
				   context == grammarAccess.getExclusiveDisjunctionAccess().getExclusiveDisjunctionPartsAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Negation(context, (Negation) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (parts+=Conjunction_Conjunction_1_0 parts+=Negation)
	 */
	protected void sequence_Conjunction(EObject context, Conjunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (context=ID expression=Implication)
	 */
	protected void sequence_ContextualExpression(EObject context, ContextualExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.CONTEXTUAL_EXPRESSION__CONTEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.CONTEXTUAL_EXPRESSION__CONTEXT));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.CONTEXTUAL_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.CONTEXTUAL_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContextualExpressionAccess().getContextIDTerminalRuleCall_1_0(), semanticObject.getContext());
		feeder.accept(grammarAccess.getContextualExpressionAccess().getExpressionImplicationParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (parts+=Disjunction_Disjunction_1_0 parts+=ExclusiveDisjunction)
	 */
	protected void sequence_Disjunction(EObject context, Disjunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parts+=ExclusiveDisjunction_ExclusiveDisjunction_1_0 parts+=Conjunction)
	 */
	protected void sequence_ExclusiveDisjunction(EObject context, ExclusiveDisjunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (leftPart=Implication_Implication_1_0 rightPart=Disjunction)
	 */
	protected void sequence_Implication(EObject context, Implication semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.IMPLICATION__LEFT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.IMPLICATION__LEFT_PART));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.IMPLICATION__RIGHT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.IMPLICATION__RIGHT_PART));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0(), semanticObject.getLeftPart());
		feeder.accept(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0(), semanticObject.getRightPart());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=PrimaryExpression
	 */
	protected void sequence_Negation(EObject context, Negation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.NEGATION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.NEGATION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=ID
	 */
	protected void sequence_PrimaryExpression(EObject context, FeatureId semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.FEATURE_ID__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.FEATURE_ID__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getValueIDTerminalRuleCall_0_1_0(), semanticObject.getValue());
		feeder.finish();
	}
}
