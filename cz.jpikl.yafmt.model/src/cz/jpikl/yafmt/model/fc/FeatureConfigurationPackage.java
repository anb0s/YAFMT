/**
 */
package cz.jpikl.yafmt.model.fc;

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
 * @see cz.jpikl.yafmt.model.fc.FeatureConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface FeatureConfigurationPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "fc";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "bitbucket.org/jpikl/yafmt/model/fc";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "fc";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureConfigurationPackage eINSTANCE = cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getFeatureConfiguration()
     * @generated
     */
    int FEATURE_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__VERSION = 2;

    /**
     * The feature id for the '<em><b>Feature Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__FEATURE_MODEL = 3;

    /**
     * The feature id for the '<em><b>Selections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION__SELECTIONS = 4;

    /**
     * The number of structural features of the '<em>Feature Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_CONFIGURATION_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.SelectionImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getSelection()
     * @generated
     */
    int SELECTION = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTION__ID = 0;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTION__VALUES = 1;

    /**
     * The number of structural features of the '<em>Selection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.AttributeValue <em>Attribute Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.AttributeValue
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getAttributeValue()
     * @generated
     */
    int ATTRIBUTE_VALUE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE__ID = 0;

    /**
     * The number of structural features of the '<em>Attribute Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.BooleanValueImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getBooleanValue()
     * @generated
     */
    int BOOLEAN_VALUE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_VALUE__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_VALUE__VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Boolean Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.IntegerValueImpl <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.IntegerValueImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getIntegerValue()
     * @generated
     */
    int INTEGER_VALUE = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_VALUE__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_VALUE__VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Integer Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.DoubleValueImpl <em>Double Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.DoubleValueImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getDoubleValue()
     * @generated
     */
    int DOUBLE_VALUE = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOUBLE_VALUE__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOUBLE_VALUE__VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Double Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOUBLE_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fc.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fc.impl.StringValueImpl
     * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getStringValue()
     * @generated
     */
    int STRING_VALUE = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_VALUE__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_VALUE__VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_VALUE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration <em>Feature Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Configuration</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration
     * @generated
     */
    EClass getFeatureConfiguration();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration#getName()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EAttribute getFeatureConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration#getDescription()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EAttribute getFeatureConfiguration_Description();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration#getVersion()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EAttribute getFeatureConfiguration_Version();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Feature Model</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration#getFeatureModel()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EReference getFeatureConfiguration_FeatureModel();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fc.FeatureConfiguration#getSelections <em>Selections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Selections</em>'.
     * @see cz.jpikl.yafmt.model.fc.FeatureConfiguration#getSelections()
     * @see #getFeatureConfiguration()
     * @generated
     */
    EReference getFeatureConfiguration_Selections();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.Selection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Selection</em>'.
     * @see cz.jpikl.yafmt.model.fc.Selection
     * @generated
     */
    EClass getSelection();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.Selection#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see cz.jpikl.yafmt.model.fc.Selection#getId()
     * @see #getSelection()
     * @generated
     */
    EAttribute getSelection_Id();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fc.Selection#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see cz.jpikl.yafmt.model.fc.Selection#getValues()
     * @see #getSelection()
     * @generated
     */
    EReference getSelection_Values();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.AttributeValue <em>Attribute Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.AttributeValue
     * @generated
     */
    EClass getAttributeValue();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.AttributeValue#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see cz.jpikl.yafmt.model.fc.AttributeValue#getId()
     * @see #getAttributeValue()
     * @generated
     */
    EAttribute getAttributeValue_Id();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.BooleanValue <em>Boolean Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.BooleanValue
     * @generated
     */
    EClass getBooleanValue();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.BooleanValue#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.BooleanValue#isValue()
     * @see #getBooleanValue()
     * @generated
     */
    EAttribute getBooleanValue_Value();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.IntegerValue <em>Integer Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.IntegerValue
     * @generated
     */
    EClass getIntegerValue();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.IntegerValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.IntegerValue#getValue()
     * @see #getIntegerValue()
     * @generated
     */
    EAttribute getIntegerValue_Value();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.DoubleValue <em>Double Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Double Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.DoubleValue
     * @generated
     */
    EClass getDoubleValue();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.DoubleValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.DoubleValue#getValue()
     * @see #getDoubleValue()
     * @generated
     */
    EAttribute getDoubleValue_Value();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fc.StringValue <em>String Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.StringValue
     * @generated
     */
    EClass getStringValue();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fc.StringValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see cz.jpikl.yafmt.model.fc.StringValue#getValue()
     * @see #getStringValue()
     * @generated
     */
    EAttribute getStringValue_Value();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    FeatureConfigurationFactory getFeatureConfigurationFactory();

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
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getFeatureConfiguration()
         * @generated
         */
        EClass FEATURE_CONFIGURATION = eINSTANCE.getFeatureConfiguration();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_CONFIGURATION__NAME = eINSTANCE.getFeatureConfiguration_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_CONFIGURATION__DESCRIPTION = eINSTANCE.getFeatureConfiguration_Description();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_CONFIGURATION__VERSION = eINSTANCE.getFeatureConfiguration_Version();

        /**
         * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_CONFIGURATION__FEATURE_MODEL = eINSTANCE.getFeatureConfiguration_FeatureModel();

        /**
         * The meta object literal for the '<em><b>Selections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_CONFIGURATION__SELECTIONS = eINSTANCE.getFeatureConfiguration_Selections();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.SelectionImpl <em>Selection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.SelectionImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getSelection()
         * @generated
         */
        EClass SELECTION = eINSTANCE.getSelection();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SELECTION__ID = eINSTANCE.getSelection_Id();

        /**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SELECTION__VALUES = eINSTANCE.getSelection_Values();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.AttributeValue <em>Attribute Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.AttributeValue
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getAttributeValue()
         * @generated
         */
        EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_VALUE__ID = eINSTANCE.getAttributeValue_Id();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.BooleanValueImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getBooleanValue()
         * @generated
         */
        EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.IntegerValueImpl <em>Integer Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.IntegerValueImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getIntegerValue()
         * @generated
         */
        EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.DoubleValueImpl <em>Double Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.DoubleValueImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getDoubleValue()
         * @generated
         */
        EClass DOUBLE_VALUE = eINSTANCE.getDoubleValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOUBLE_VALUE__VALUE = eINSTANCE.getDoubleValue_Value();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fc.impl.StringValueImpl <em>String Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fc.impl.StringValueImpl
         * @see cz.jpikl.yafmt.model.fc.impl.FeatureConfigurationPackageImpl#getStringValue()
         * @generated
         */
        EClass STRING_VALUE = eINSTANCE.getStringValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

    }

} //FeatureConfigurationPackage
