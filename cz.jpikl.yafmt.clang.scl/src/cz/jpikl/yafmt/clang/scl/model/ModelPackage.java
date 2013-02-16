/**
 */
package cz.jpikl.yafmt.clang.scl.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.clang.scl.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "https://bitbucket.org/jpikl/yafmt/clang/scl";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "model";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelPackage eINSTANCE = cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ExpressionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getExpression()
     * @generated
     */
    int EXPRESSION = 0;

    /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl <em>Contextual Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getContextualExpression()
     * @generated
     */
    int CONTEXTUAL_EXPRESSION = 1;

    /**
     * The feature id for the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXTUAL_EXPRESSION__CONTEXT_ID = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXTUAL_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Contextual Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXTUAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ImplicationImpl <em>Implication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ImplicationImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getImplication()
     * @generated
     */
    int IMPLICATION = 2;

    /**
     * The feature id for the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION__LEFT_PART = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION__RIGHT_PART = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Implication</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.DisjunctionImpl <em>Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.DisjunctionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getDisjunction()
     * @generated
     */
    int DISJUNCTION = 3;

    /**
     * The feature id for the '<em><b>Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISJUNCTION__PARTS = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Disjunction</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISJUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ExclusiveDisjunctionImpl <em>Exclusive Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ExclusiveDisjunctionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getExclusiveDisjunction()
     * @generated
     */
    int EXCLUSIVE_DISJUNCTION = 4;

    /**
     * The feature id for the '<em><b>Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXCLUSIVE_DISJUNCTION__PARTS = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exclusive Disjunction</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXCLUSIVE_DISJUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ConjunctionImpl <em>Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ConjunctionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getConjunction()
     * @generated
     */
    int CONJUNCTION = 5;

    /**
     * The feature id for the '<em><b>Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONJUNCTION__PARTS = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Conjunction</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONJUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.NegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.NegationImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getNegation()
     * @generated
     */
    int NEGATION = 6;

    /**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Negation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.clang.scl.model.impl.PrimaryExpressionImpl
     * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getPrimaryExpression()
     * @generated
     */
    int PRIMARY_EXPRESSION = 7;

    /**
     * The feature id for the '<em><b>Feature Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_EXPRESSION__FEATURE_ID = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Primary Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Expression
     * @generated
     */
    EClass getExpression();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.ContextualExpression <em>Contextual Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Contextual Expression</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.ContextualExpression
     * @generated
     */
    EClass getContextualExpression();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.clang.scl.model.ContextualExpression#getContextId <em>Context Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Id</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.ContextualExpression#getContextId()
     * @see #getContextualExpression()
     * @generated
     */
    EAttribute getContextualExpression_ContextId();

    /**
     * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.clang.scl.model.ContextualExpression#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.ContextualExpression#getExpression()
     * @see #getContextualExpression()
     * @generated
     */
    EReference getContextualExpression_Expression();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.Implication <em>Implication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Implication</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Implication
     * @generated
     */
    EClass getImplication();

    /**
     * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.clang.scl.model.Implication#getLeftPart <em>Left Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left Part</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Implication#getLeftPart()
     * @see #getImplication()
     * @generated
     */
    EReference getImplication_LeftPart();

    /**
     * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.clang.scl.model.Implication#getRightPart <em>Right Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right Part</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Implication#getRightPart()
     * @see #getImplication()
     * @generated
     */
    EReference getImplication_RightPart();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.Disjunction <em>Disjunction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Disjunction</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Disjunction
     * @generated
     */
    EClass getDisjunction();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.clang.scl.model.Disjunction#getParts <em>Parts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parts</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Disjunction#getParts()
     * @see #getDisjunction()
     * @generated
     */
    EReference getDisjunction_Parts();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction <em>Exclusive Disjunction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exclusive Disjunction</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction
     * @generated
     */
    EClass getExclusiveDisjunction();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction#getParts <em>Parts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parts</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.ExclusiveDisjunction#getParts()
     * @see #getExclusiveDisjunction()
     * @generated
     */
    EReference getExclusiveDisjunction_Parts();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.Conjunction <em>Conjunction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conjunction</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Conjunction
     * @generated
     */
    EClass getConjunction();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.clang.scl.model.Conjunction#getParts <em>Parts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parts</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Conjunction#getParts()
     * @see #getConjunction()
     * @generated
     */
    EReference getConjunction_Parts();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.Negation <em>Negation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Negation</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Negation
     * @generated
     */
    EClass getNegation();

    /**
     * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.clang.scl.model.Negation#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.Negation#getExpression()
     * @see #getNegation()
     * @generated
     */
    EReference getNegation_Expression();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.clang.scl.model.PrimaryExpression <em>Primary Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primary Expression</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.PrimaryExpression
     * @generated
     */
    EClass getPrimaryExpression();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.clang.scl.model.PrimaryExpression#getFeatureId <em>Feature Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature Id</em>'.
     * @see cz.jpikl.yafmt.clang.scl.model.PrimaryExpression#getFeatureId()
     * @see #getPrimaryExpression()
     * @generated
     */
    EAttribute getPrimaryExpression_FeatureId();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelFactory getModelFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ExpressionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getExpression()
         * @generated
         */
        EClass EXPRESSION = eINSTANCE.getExpression();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl <em>Contextual Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ContextualExpressionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getContextualExpression()
         * @generated
         */
        EClass CONTEXTUAL_EXPRESSION = eINSTANCE.getContextualExpression();

        /**
         * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTEXTUAL_EXPRESSION__CONTEXT_ID = eINSTANCE.getContextualExpression_ContextId();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXTUAL_EXPRESSION__EXPRESSION = eINSTANCE.getContextualExpression_Expression();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ImplicationImpl <em>Implication</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ImplicationImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getImplication()
         * @generated
         */
        EClass IMPLICATION = eINSTANCE.getImplication();

        /**
         * The meta object literal for the '<em><b>Left Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPLICATION__LEFT_PART = eINSTANCE.getImplication_LeftPart();

        /**
         * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPLICATION__RIGHT_PART = eINSTANCE.getImplication_RightPart();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.DisjunctionImpl <em>Disjunction</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.DisjunctionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getDisjunction()
         * @generated
         */
        EClass DISJUNCTION = eINSTANCE.getDisjunction();

        /**
         * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISJUNCTION__PARTS = eINSTANCE.getDisjunction_Parts();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ExclusiveDisjunctionImpl <em>Exclusive Disjunction</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ExclusiveDisjunctionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getExclusiveDisjunction()
         * @generated
         */
        EClass EXCLUSIVE_DISJUNCTION = eINSTANCE.getExclusiveDisjunction();

        /**
         * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXCLUSIVE_DISJUNCTION__PARTS = eINSTANCE.getExclusiveDisjunction_Parts();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.ConjunctionImpl <em>Conjunction</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ConjunctionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getConjunction()
         * @generated
         */
        EClass CONJUNCTION = eINSTANCE.getConjunction();

        /**
         * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONJUNCTION__PARTS = eINSTANCE.getConjunction_Parts();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.NegationImpl <em>Negation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.NegationImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getNegation()
         * @generated
         */
        EClass NEGATION = eINSTANCE.getNegation();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NEGATION__EXPRESSION = eINSTANCE.getNegation_Expression();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.clang.scl.model.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.clang.scl.model.impl.PrimaryExpressionImpl
         * @see cz.jpikl.yafmt.clang.scl.model.impl.ModelPackageImpl#getPrimaryExpression()
         * @generated
         */
        EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

        /**
         * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMARY_EXPRESSION__FEATURE_ID = eINSTANCE.getPrimaryExpression_FeatureId();

    }

} //ModelPackage
