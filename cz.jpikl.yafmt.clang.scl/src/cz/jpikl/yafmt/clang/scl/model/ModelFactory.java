/**
 */
package cz.jpikl.yafmt.clang.scl.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.jpikl.yafmt.clang.scl.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelFactory eINSTANCE = cz.jpikl.yafmt.clang.scl.model.impl.ModelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Expression</em>'.
     * @generated
     */
    Expression createExpression();

    /**
     * Returns a new object of class '<em>Contextual Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Contextual Expression</em>'.
     * @generated
     */
    ContextualExpression createContextualExpression();

    /**
     * Returns a new object of class '<em>Implication</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Implication</em>'.
     * @generated
     */
    Implication createImplication();

    /**
     * Returns a new object of class '<em>Disjunction</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Disjunction</em>'.
     * @generated
     */
    Disjunction createDisjunction();

    /**
     * Returns a new object of class '<em>Exclusive Disjunction</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exclusive Disjunction</em>'.
     * @generated
     */
    ExclusiveDisjunction createExclusiveDisjunction();

    /**
     * Returns a new object of class '<em>Conjunction</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Conjunction</em>'.
     * @generated
     */
    Conjunction createConjunction();

    /**
     * Returns a new object of class '<em>Negation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Negation</em>'.
     * @generated
     */
    Negation createNegation();

    /**
     * Returns a new object of class '<em>Primary Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primary Expression</em>'.
     * @generated
     */
    PrimaryExpression createPrimaryExpression();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelPackage getModelPackage();

} //ModelFactory
