package cz.zcu.yafmt.model.fm.util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLRegistry;
import org.eclipse.emf.mapping.ecore2xml.impl.Ecore2XMLRegistryImpl;
import org.eclipse.emf.mapping.ecore2xml.util.Ecore2XMLExtendedMetaData;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.FeatureModelPackage.Literals;

public class FeatureModelUtil {

    private static Map<Object, Object> loadOptions;
    private static Map<Object, Object> saveOptions;

    // ===============================================================================================
    //  Save and load utilities
    // ===============================================================================================

    private static ExtendedMetaData createExtendedMetadataLoadAndSave(ExtendedMetaData emd4use) {
        ExtendedMetaData emd = emd4use;
        if (emd4use == null)
            emd = new BasicExtendedMetaData();
        // Rename some elements.
        emd.setName(Literals.FEATURE_MODEL, "featureModel");
        emd.setName(Literals.FEATURE_MODEL__CONSTRAINTS, "constraint");
        emd.setName(Literals.FEATURE_MODEL__ORPHANS, "orphanedFeature");
        emd.setName(Literals.FEATURE_MODEL__ROOT, "rootFeature");
        emd.setName(Literals.FEATURE__ATTRIBUTES, "attribute");
        emd.setName(Literals.FEATURE__FEATURES, "feature");
        emd.setName(Literals.FEATURE__GROUPS, "group");
        emd.setName(Literals.GROUP__FEATURES, "feature");
        // Let comment be element instead of attribute.
        emd.setFeatureKind(Literals.FEATURE_MODEL__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.FEATURE__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.GROUP__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.ATTRIBUTE__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.CONSTRAINT__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        return emd;
    }

    private static ExtendedMetaData createExtendedMetadataLoad(ResourceSet resourceSet) {
        // compatibility to value = defaultValue (issue #1)
        //emd.setName(Literals.ATTRIBUTE__DEFAULT_VALUE, "value");
        List<String[]> modelsURIs=new ArrayList<String[]>();
        modelsURIs.add(new String[]{
                "http://zcu.cz/yafmt/model/fm",
                "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.4.0.ecore",
                "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.3.0_2_fm-0.4.0.ecore2xml"
        });
        /*modelsURIs.add(new String[]{
                "http://zcu.cz/yafmt/model/fm-0.4.0",
                "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.5.0.ecore",
                "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.4.0_2_fm-0.5.0.ecore2xml"
        });*/
        /*
        final String FM_NS_URI = "http://zcu.cz/yafmt/model/fm";
        final String FM_PLATFORM_URI        = "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.4.0.ecore";
        final String ECORE2XML_PLATFORM_URI = "platform:/plugin/cz.zcu.yafmt.model/model/history/fm-0.3.0_2_fm-0.4.0.ecore2xml";
        */
        if (resourceSet == null) {
            resourceSet = new ResourceSetImpl();
        }
        Ecore2XMLRegistry ecore2xmlRegistry = null;
        EPackage.Registry ePackageRegistry = resourceSet.getPackageRegistry();
        for (String[] modelURIs : modelsURIs) {
            ePackageRegistry.put(modelURIs[0], FeatureModelPackage.eINSTANCE);
            ePackageRegistry.put(modelURIs[1], FeatureModelPackage.eINSTANCE);
            if (ecore2xmlRegistry == null) {
                ecore2xmlRegistry = new Ecore2XMLRegistryImpl(Ecore2XMLRegistry.INSTANCE);
            }
            ecore2xmlRegistry.put(modelURIs[0],
                    EcoreUtil.getObjectByType(resourceSet.getResource(URI.createURI(modelURIs[2]), true).getContents(),Ecore2XMLPackage.Literals.XML_MAP)
            );
        }
        Ecore2XMLExtendedMetaData emd = new Ecore2XMLExtendedMetaData(ePackageRegistry, ecore2xmlRegistry);
        createExtendedMetadataLoadAndSave(emd);
        return emd;
    }

    private static ExtendedMetaData createExtendedMetadataSave() {
        ExtendedMetaData emd = createExtendedMetadataLoadAndSave(null);
        // compatibility to value = defaultValue (issue #1)
        //emd.setName(Literals.ATTRIBUTE__DEFAULT_VALUE, "defaultValue");
        return emd;
    }

    public static Map<Object, Object> createLoadOptions(ResourceSet resourceSet) {
        if(loadOptions == null) {
            loadOptions = new HashMap<Object, Object>();
            loadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, createExtendedMetadataLoad(resourceSet));
            //loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE); // This options allows you to record unknown features during deserialization/loading.
            //loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE); // Allows proper loading of renamed XML elements.
            //loadOptions.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE); // Persist even attributes with default value.
            //loadOptions.put(XMLResource.OPTION_RESOURCE_HANDLER, new UnknownFeatureResourceHandler());
        }
        return loadOptions;
    }

    public static Map<Object, Object> createSaveOptions() {
        if(saveOptions == null) {
            saveOptions = new HashMap<Object, Object>();
            saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, createExtendedMetadataSave());
            //saveOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE); // This options allows you to record unknown features during deserialization/loading.
            saveOptions.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE); // Persist even attributes with default value.
        }
        return saveOptions;
    }

    public static void hookResourceFactoryRegistry() {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("yafm",
                new XMIResourceFactoryImpl() {
                    @Override
                    public Resource createResource(URI uri) {
                        XMIResource resource = (XMIResource) super.createResource(uri);
                        resource.getDefaultLoadOptions().putAll(createLoadOptions(resource.getResourceSet()));
                        resource.getDefaultSaveOptions().putAll(createSaveOptions());
                        return resource;
                    }
                }
         );
    }

    public static void hookPackageRegistry() {
        FeatureModelPackage.eINSTANCE.eClass();
    }

    // ===============================================================================================
    //  Creation utilities
    // ===============================================================================================

    public static FeatureModel createEmptyFeatureModel(String name) {
        if((name == null) || name.isEmpty())
            throw new IllegalArgumentException("Feature model name cannot be empty");

        FeatureModelFactory factory = FeatureModelFactory.eINSTANCE;

        Feature rootFeature = factory.createFeature();
        //rootFeature.setId(generateIdFromName(name));
        rootFeature.setId(generateFeatureId());
        rootFeature.setName(name);
        rootFeature.setLower(1);
        rootFeature.setUpper(1);

        FeatureModel featureModel = factory.createFeatureModel();
        featureModel.setName(name);
        featureModel.setRoot(rootFeature);
        return featureModel;
    }

    public static String generateFeatureId() {
        return getFeatureIdPrefix() + generateUniqueId();
    }

    public static String generateAttributeId() {
        return getAttributeIdPrefix() + generateUniqueId();
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString().replace('-', '_');
    }

    public static String getFeatureIdPrefix() {
        return "f_";
    }

    public static String getAttributeIdPrefix() {
        return "a_";
    }

    public static String generateIdFromName(String name) {
        String id = Normalizer.normalize(name, Normalizer.Form.NFD);
        id = id.replaceAll("^\\s+", "").replaceAll("\\s+$", "").replaceAll("\\s+", "_");
        return id.replaceAll("[^a-zA-Z0-9_]+", "").toLowerCase();
    }

    // ===============================================================================================
    //  Query utilities
    // ===============================================================================================

    public static String getName(EObject object) {
        if(object == null)
            return "null";
        if(object instanceof FeatureModel)
            return ((FeatureModel) object).getName();
        if(object instanceof Feature)
            return ((Feature) object).getName();
        if(object instanceof Group)
            return "Group";
        if(object instanceof Attribute)
            return ((Attribute) object).getName();
        return object.toString();
    }

    public static String getParentName(EObject parent) {
        if(parent == null)
            return "null";
        if(parent instanceof Group)
            return getName(((Group) parent).getParent());
        return getName(parent);
    }

    public static void removeUnneededGroup(EObject object) {
        if(!(object instanceof Group))
            return;

        Group group = (Group) object;
        List<Feature> features = group.getFeatures();
        if(features.size() <= 1) {
            if(features.size() == 1)
                features.get(0).setParent(group.getParent());
            group.setParent(null);
        }
    }

    public static String getCardinality(Feature feature) {
        if(feature == null)
            return null;

        int lower = feature.getLower();
        int upper = feature.getUpper();
        return "[" + lower + ".." + ((upper == -1) ? "*" : upper) + "]";
    }

    public static String getCardinality(Group group) {
        if(group == null)
            return null;

        int lower = group.getLower();
        int upper = group.getUpper();
        return "<" + lower + "-" + ((upper == -1) ? "*" : upper) + ">";
    }

    public static String getTranslatedCardinality(Group group) {
        if(group == null)
            return null;

        if(group.isOr())
            return "OR";
        else if(group.isXor())
            return "XOR";
        else
            return getCardinality(group);
    }

    public static TreeInfo analyzeTree(FeatureModel featureModel) {
        if(featureModel == null)
            return new TreeInfo();
        return analyzeTree(featureModel.getRoot());
    }

    public static TreeInfo analyzeTree(Feature feature) {
        TreeInfo info = new TreeInfo();
        if(feature != null)
            analyzeTreeNode(feature, info, 0);
        return info;
    }

    private static void analyzeTreeNode(Feature feature, TreeInfo info, int currentHeight) {
        info.size++;

        currentHeight++;
        if(currentHeight > info.height)
            info.height = currentHeight;

        for(Feature child: feature.getFeatures())
            analyzeTreeNode(child, info, currentHeight);

        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures())
                analyzeTreeNode(child, info, currentHeight);
        }
    }

    public static class TreeInfo {

        public int size = 0;
        public int height = 0;

    }

    // ===============================================================================================
    //  Comparison utilities
    // ===============================================================================================

    // Of course we could use EMF compare, but why another dependency when we just need to test if
    // models are the same.

    public static boolean compareFeatureModels(FeatureModel featureModelA, FeatureModel featureModelB, boolean compareOrphanedFeatures) {
        if(featureModelA == featureModelB)
            return true;
        if((featureModelA == null) || (featureModelB == null))
            return false;

        if(!compareStrings(featureModelA.getName(), featureModelB.getName()))
            return false;
        if(!compareStrings(featureModelA.getVersion(), featureModelB.getVersion()))
            return false;
        if(!compareStrings(featureModelA.getDescription(), featureModelB.getDescription()))
            return false;
        if(!compareStrings(featureModelA.getComment(), featureModelB.getComment()))
            return false;
        if(!compareFeatures(featureModelA.getRoot(), featureModelB.getRoot(), true))
            return false;
        if(compareOrphanedFeatures && !compareFeatures(featureModelA.getOrphans(), featureModelB.getOrphans(), true))
            return false;
        if(!compareConstraints(featureModelA.getConstraints(), featureModelB.getConstraints()))
            return false;

        return true;
    }

    public static boolean compareFeatures(Feature featureA, Feature featureB, boolean recursive) {
        if(featureA == featureB)
            return true;
        if((featureA == null) || (featureB == null))
            return false;

        if(!compareStrings(featureA.getId(), featureB.getId()))
            return false;
        if(!compareStrings(featureA.getName(), featureB.getName()))
            return false;
        if(!compareStrings(featureA.getDescription(), featureB.getDescription()))
            return false;
        if(!compareStrings(featureA.getComment(), featureB.getComment()))
            return false;
        if(featureA.getLower() != featureB.getLower())
            return false;
        if(featureA.getUpper() != featureB.getUpper())
            return false;
        if(!compareAttributes(featureA.getAttributes(), featureB.getAttributes()))
            return false;
        if(recursive && !compareFeatures(featureA.getFeatures(), featureB.getFeatures(), recursive))
            return false;
        if(recursive && !compareGroups(featureA.getGroups(), featureB.getGroups(), recursive))
            return false;

        return true;
    }

    public static boolean compareFeatures(List<Feature> featuresA, List<Feature> featuresB, boolean recursive) {
        if(featuresA == featuresB)
            return true;
        if((featuresA == null) || (featuresB == null))
            return false;

        if(featuresA.size() != featuresB.size())
            return false;
        for(int i = 0; i < featuresA.size(); i++) {
            if(!compareFeatures(featuresA.get(i), featuresB.get(i), recursive))
                return false;
        }

        return true;
    }

    private static boolean compareAttributes(Attribute attributeA, Attribute attributeB) {
        if(attributeA == attributeB)
            return true;
        if((attributeA == null) || (attributeB == null))
            return false;

        if(!compareStrings(attributeA.getId(), attributeB.getId()))
            return false;
        if(!compareStrings(attributeA.getName(), attributeB.getName()))
            return false;
        if(attributeA.getType() != attributeB.getType())
            return false;
        if(!compareStrings(attributeA.getDescription(), attributeB.getDescription()))
            return false;
        if(!compareStrings(attributeA.getComment(), attributeB.getComment()))
            return false;

        return true;
    }

    public static boolean compareAttributes(List<Attribute> attributesA, List<Attribute> attributesB) {
        if(attributesA == attributesB)
            return true;
        if((attributesA == null) || (attributesB == null))
            return false;

        if(attributesA.size() != attributesB.size())
            return false;
        for(int i = 0; i < attributesA.size(); i++) {
            if(!compareAttributes(attributesA.get(i), attributesB.get(i)))
                return false;
        }

        return true;
    }

    public static boolean compareGroups(Group groupA, Group groupB, boolean recursive) {
        if(groupA == groupB)
            return true;
        if((groupA == null) || (groupB == null))
            return false;

        if(groupA.getLower() != groupB.getLower())
            return false;
        if(groupA.getUpper() != groupB.getUpper())
            return false;
        if(!compareStrings(groupA.getDescription(), groupB.getDescription()))
            return false;
        if(!compareStrings(groupA.getComment(), groupB.getComment()))
            return false;
        if(recursive && !compareFeatures(groupA.getFeatures(), groupB.getFeatures(), recursive))
            return false;

        return true;
    }

    public static boolean compareGroups(EList<Group> groupsA, EList<Group> groupsB, boolean recursive) {
        if(groupsA == groupsB)
            return true;
        if((groupsA == null) || (groupsB == null))
            return false;

        if(groupsA.size() != groupsB.size())
            return false;
        for(int i = 0; i < groupsA.size(); i++) {
            if(!compareGroups(groupsA.get(i), groupsB.get(i), recursive))
                return false;
        }

        return true;
    }

    public static boolean compareConstraints(Constraint constraintA, Constraint constraintB) {
        if(constraintA == constraintB)
            return true;
        if((constraintA == null) || (constraintB == null))
            return false;

        if(!compareStrings(constraintA.getLanguage(), constraintB.getLanguage()))
            return false;
        if(!compareStrings(constraintA.getValue(), constraintB.getValue()))
            return false;
        if(!compareStrings(constraintA.getDescription(), constraintB.getDescription()))
            return false;
        if(!compareStrings(constraintA.getComment(), constraintB.getComment()))
            return false;

        return true;
    }

    public static boolean compareConstraints(List<Constraint> constraintsA, List<Constraint> constraintsB) {
        if(constraintsA == constraintsB)
            return true;
        if((constraintsA == null) || (constraintsB == null))
            return false;

        if(constraintsA.size() != constraintsB.size())
            return false;
        for(int i = 0; i < constraintsA.size(); i++) {
            if(!compareConstraints(constraintsA.get(i), constraintsB.get(i)))
                return false;
        }

        return true;
    }

    private static boolean compareStrings(String stringA, String stringB) {
        if(stringA == stringB)
            return true;
        if((stringA == null) || (stringB == null))
            return false;

        return stringA.equals(stringB);
    }

}
