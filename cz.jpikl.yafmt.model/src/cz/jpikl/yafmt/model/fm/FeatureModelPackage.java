/**
 */
package cz.jpikl.yafmt.model.fm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see cz.jpikl.yafmt.model.fm.FeatureModelFactory
 * @model kind="package"
 * @generated
 */
public interface FeatureModelPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "fm";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "https://bitbucket.org/jpikl/yafmt/model/fm";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "fm";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureModelPackage eINSTANCE = cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.impl.FeatureModelImpl <em>Feature Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelImpl
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getFeatureModel()
     * @generated
     */
    int FEATURE_MODEL = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__NAME = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__VERSION = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__ROOT = 3;

    /**
     * The feature id for the '<em><b>Orphans</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__ORPHANS = 4;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL__CONSTRAINTS = 5;

    /**
     * The number of structural features of the '<em>Feature Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_MODEL_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureImpl
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getFeature()
     * @generated
     */
    int FEATURE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__NAME = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Lower</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__LOWER = 3;

    /**
     * The feature id for the '<em><b>Upper</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__UPPER = 4;

    /**
     * The feature id for the '<em><b>Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__ROOT = 5;

    /**
     * The feature id for the '<em><b>Orphan</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__ORPHAN = 6;

    /**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__OPTIONAL = 7;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__MANDATORY = 8;

    /**
     * The feature id for the '<em><b>Clonable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__CLONABLE = 9;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__PARENT = 10;

    /**
     * The feature id for the '<em><b>Parent Feature</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__PARENT_FEATURE = 11;

    /**
     * The feature id for the '<em><b>Parent Group</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__PARENT_GROUP = 12;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__ATTRIBUTES = 13;

    /**
     * The feature id for the '<em><b>Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__FEATURES = 14;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__GROUPS = 15;

    /**
     * The feature id for the '<em><b>Feature Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE__FEATURE_MODEL = 16;

    /**
     * The number of structural features of the '<em>Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_FEATURE_COUNT = 17;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.impl.GroupImpl
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getGroup()
     * @generated
     */
    int GROUP = 2;

    /**
     * The feature id for the '<em><b>Lower</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__LOWER = 0;

    /**
     * The feature id for the '<em><b>Upper</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__UPPER = 1;

    /**
     * The feature id for the '<em><b>Xor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__XOR = 2;

    /**
     * The feature id for the '<em><b>Or</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__OR = 3;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__PARENT = 4;

    /**
     * The feature id for the '<em><b>Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP__FEATURES = 5;

    /**
     * The number of structural features of the '<em>Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.impl.AttributeImpl
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getAttribute()
     * @generated
     */
    int ATTRIBUTE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__NAME = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__TYPE = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__DESCRIPTION = 3;

    /**
     * The number of structural features of the '<em>Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.impl.ConstraintImpl
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getConstraint()
     * @generated
     */
    int CONSTRAINT = 4;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__VALUE = 0;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__LANGUAGE = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Feature Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT__FEATURE_MODEL = 3;

    /**
     * The number of structural features of the '<em>Constraint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRAINT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link cz.jpikl.yafmt.model.fm.AttributeType <em>Attribute Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.jpikl.yafmt.model.fm.AttributeType
     * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getAttributeType()
     * @generated
     */
    int ATTRIBUTE_TYPE = 5;


    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fm.FeatureModel <em>Feature Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Model</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel
     * @generated
     */
    EClass getFeatureModel();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getName()
     * @see #getFeatureModel()
     * @generated
     */
    EAttribute getFeatureModel_Name();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getDescription()
     * @see #getFeatureModel()
     * @generated
     */
    EAttribute getFeatureModel_Description();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getVersion()
     * @see #getFeatureModel()
     * @generated
     */
    EAttribute getFeatureModel_Version();

    /**
     * Returns the meta object for the containment reference '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getRoot()
     * @see #getFeatureModel()
     * @generated
     */
    EReference getFeatureModel_Root();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getOrphans <em>Orphans</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Orphans</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getOrphans()
     * @see #getFeatureModel()
     * @generated
     */
    EReference getFeatureModel_Orphans();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.FeatureModel#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Constraints</em>'.
     * @see cz.jpikl.yafmt.model.fm.FeatureModel#getConstraints()
     * @see #getFeatureModel()
     * @generated
     */
    EReference getFeatureModel_Constraints();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fm.Feature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature
     * @generated
     */
    EClass getFeature();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getId()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Id();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getName()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Name();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getDescription()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Description();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#getLower <em>Lower</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getLower()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Lower();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#getUpper <em>Upper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Upper</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getUpper()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Upper();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#isRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Root</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#isRoot()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Root();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#isOrphan <em>Orphan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Orphan</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#isOrphan()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Orphan();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#isOptional()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Optional();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#isMandatory <em>Mandatory</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#isMandatory()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Mandatory();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Feature#isClonable <em>Clonable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Clonable</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#isClonable()
     * @see #getFeature()
     * @generated
     */
    EAttribute getFeature_Clonable();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.Feature#getAttributes <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Attributes</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getAttributes()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_Attributes();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.model.fm.Feature#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getParent()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_Parent();

    /**
     * Returns the meta object for the container reference '{@link cz.jpikl.yafmt.model.fm.Feature#getParentFeature <em>Parent Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent Feature</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getParentFeature()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_ParentFeature();

    /**
     * Returns the meta object for the container reference '{@link cz.jpikl.yafmt.model.fm.Feature#getParentGroup <em>Parent Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent Group</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getParentGroup()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_ParentGroup();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.Feature#getFeatures <em>Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Features</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getFeatures()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_Features();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.Feature#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getGroups()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_Groups();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.model.fm.Feature#getFeatureModel <em>Feature Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Feature Model</em>'.
     * @see cz.jpikl.yafmt.model.fm.Feature#getFeatureModel()
     * @see #getFeature()
     * @generated
     */
    EReference getFeature_FeatureModel();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fm.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group
     * @generated
     */
    EClass getGroup();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Group#getLower <em>Lower</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#getLower()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_Lower();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Group#getUpper <em>Upper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Upper</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#getUpper()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_Upper();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Group#isXor <em>Xor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xor</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#isXor()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_Xor();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Group#isOr <em>Or</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Or</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#isOr()
     * @see #getGroup()
     * @generated
     */
    EAttribute getGroup_Or();

    /**
     * Returns the meta object for the container reference '{@link cz.jpikl.yafmt.model.fm.Group#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#getParent()
     * @see #getGroup()
     * @generated
     */
    EReference getGroup_Parent();

    /**
     * Returns the meta object for the containment reference list '{@link cz.jpikl.yafmt.model.fm.Group#getFeatures <em>Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Features</em>'.
     * @see cz.jpikl.yafmt.model.fm.Group#getFeatures()
     * @see #getGroup()
     * @generated
     */
    EReference getGroup_Features();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fm.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute</em>'.
     * @see cz.jpikl.yafmt.model.fm.Attribute
     * @generated
     */
    EClass getAttribute();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Attribute#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see cz.jpikl.yafmt.model.fm.Attribute#getId()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Id();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Attribute#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see cz.jpikl.yafmt.model.fm.Attribute#getName()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Name();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Attribute#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see cz.jpikl.yafmt.model.fm.Attribute#getDescription()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Description();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Attribute#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see cz.jpikl.yafmt.model.fm.Attribute#getType()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Type();

    /**
     * Returns the meta object for class '{@link cz.jpikl.yafmt.model.fm.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constraint</em>'.
     * @see cz.jpikl.yafmt.model.fm.Constraint
     * @generated
     */
    EClass getConstraint();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Constraint#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see cz.jpikl.yafmt.model.fm.Constraint#getValue()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Value();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Constraint#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see cz.jpikl.yafmt.model.fm.Constraint#getLanguage()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Language();

    /**
     * Returns the meta object for the attribute '{@link cz.jpikl.yafmt.model.fm.Constraint#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see cz.jpikl.yafmt.model.fm.Constraint#getDescription()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Description();

    /**
     * Returns the meta object for the reference '{@link cz.jpikl.yafmt.model.fm.Constraint#getFeatureModel <em>Feature Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Feature Model</em>'.
     * @see cz.jpikl.yafmt.model.fm.Constraint#getFeatureModel()
     * @see #getConstraint()
     * @generated
     */
    EReference getConstraint_FeatureModel();

    /**
     * Returns the meta object for enum '{@link cz.jpikl.yafmt.model.fm.AttributeType <em>Attribute Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Attribute Type</em>'.
     * @see cz.jpikl.yafmt.model.fm.AttributeType
     * @generated
     */
    EEnum getAttributeType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    FeatureModelFactory getFeatureModelFactory();

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
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.impl.FeatureModelImpl <em>Feature Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelImpl
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getFeatureModel()
         * @generated
         */
        EClass FEATURE_MODEL = eINSTANCE.getFeatureModel();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_MODEL__NAME = eINSTANCE.getFeatureModel_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_MODEL__DESCRIPTION = eINSTANCE.getFeatureModel_Description();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_MODEL__VERSION = eINSTANCE.getFeatureModel_Version();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_MODEL__ROOT = eINSTANCE.getFeatureModel_Root();

        /**
         * The meta object literal for the '<em><b>Orphans</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_MODEL__ORPHANS = eINSTANCE.getFeatureModel_Orphans();

        /**
         * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_MODEL__CONSTRAINTS = eINSTANCE.getFeatureModel_Constraints();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.impl.FeatureImpl <em>Feature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureImpl
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getFeature()
         * @generated
         */
        EClass FEATURE = eINSTANCE.getFeature();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__DESCRIPTION = eINSTANCE.getFeature_Description();

        /**
         * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__LOWER = eINSTANCE.getFeature_Lower();

        /**
         * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__UPPER = eINSTANCE.getFeature_Upper();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__ROOT = eINSTANCE.getFeature_Root();

        /**
         * The meta object literal for the '<em><b>Orphan</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__ORPHAN = eINSTANCE.getFeature_Orphan();

        /**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__OPTIONAL = eINSTANCE.getFeature_Optional();

        /**
         * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__MANDATORY = eINSTANCE.getFeature_Mandatory();

        /**
         * The meta object literal for the '<em><b>Clonable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE__CLONABLE = eINSTANCE.getFeature_Clonable();

        /**
         * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__ATTRIBUTES = eINSTANCE.getFeature_Attributes();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__PARENT = eINSTANCE.getFeature_Parent();

        /**
         * The meta object literal for the '<em><b>Parent Feature</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__PARENT_FEATURE = eINSTANCE.getFeature_ParentFeature();

        /**
         * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__PARENT_GROUP = eINSTANCE.getFeature_ParentGroup();

        /**
         * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__FEATURES = eINSTANCE.getFeature_Features();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__GROUPS = eINSTANCE.getFeature_Groups();

        /**
         * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE__FEATURE_MODEL = eINSTANCE.getFeature_FeatureModel();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.impl.GroupImpl <em>Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.impl.GroupImpl
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getGroup()
         * @generated
         */
        EClass GROUP = eINSTANCE.getGroup();

        /**
         * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__LOWER = eINSTANCE.getGroup_Lower();

        /**
         * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__UPPER = eINSTANCE.getGroup_Upper();

        /**
         * The meta object literal for the '<em><b>Xor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__XOR = eINSTANCE.getGroup_Xor();

        /**
         * The meta object literal for the '<em><b>Or</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP__OR = eINSTANCE.getGroup_Or();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP__PARENT = eINSTANCE.getGroup_Parent();

        /**
         * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP__FEATURES = eINSTANCE.getGroup_Features();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.impl.AttributeImpl <em>Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.impl.AttributeImpl
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getAttribute()
         * @generated
         */
        EClass ATTRIBUTE = eINSTANCE.getAttribute();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE__ID = eINSTANCE.getAttribute_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE__DESCRIPTION = eINSTANCE.getAttribute_Description();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.impl.ConstraintImpl <em>Constraint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.impl.ConstraintImpl
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getConstraint()
         * @generated
         */
        EClass CONSTRAINT = eINSTANCE.getConstraint();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTRAINT__VALUE = eINSTANCE.getConstraint_Value();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTRAINT__LANGUAGE = eINSTANCE.getConstraint_Language();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTRAINT__DESCRIPTION = eINSTANCE.getConstraint_Description();

        /**
         * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONSTRAINT__FEATURE_MODEL = eINSTANCE.getConstraint_FeatureModel();

        /**
         * The meta object literal for the '{@link cz.jpikl.yafmt.model.fm.AttributeType <em>Attribute Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.jpikl.yafmt.model.fm.AttributeType
         * @see cz.jpikl.yafmt.model.fm.impl.FeatureModelPackageImpl#getAttributeType()
         * @generated
         */
        EEnum ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

    }

} //FeatureModelPackage
