package cz.jpikl.yafmt.model.fm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage.Literals;
import cz.jpikl.yafmt.model.fm.Group;

public class FeatureModelUtil {

    private static Map<Object, Object> saveLoadOptions;
        
    private static ExtendedMetaData createExtendedMetadata() {
        ExtendedMetaData emd = new BasicExtendedMetaData();
        emd.setName(Literals.FEATURE_MODEL, "feature-model");
        emd.setName(Literals.FEATURE_MODEL__CONSTRAINT_LANGUAGE, "constraint-language");
        emd.setName(Literals.FEATURE_MODEL__CONSTRAINTS, "constraint");
        emd.setName(Literals.FEATURE_MODEL__ORPHANS, "orphaned-feature");
        emd.setName(Literals.FEATURE_MODEL__ROOT, "root-feature");
        emd.setName(Literals.FEATURE__ATTRIBUTES, "attribute");
        emd.setName(Literals.FEATURE__FEATURES, "feature");
        emd.setName(Literals.FEATURE__GROUPS, "group");
        emd.setName(Literals.FEATURE__LOWER, "lower-bound");
        emd.setName(Literals.FEATURE__UPPER, "upper-bound");
        emd.setName(Literals.GROUP__FEATURES, "feature");
        emd.setName(Literals.GROUP__LOWER, "lower-bound");
        emd.setName(Literals.GROUP__UPPER, "upper-bound");
        emd.setFeatureKind(Literals.FEATURE_MODEL__DESCRIPTION, ExtendedMetaData.ELEMENT_FEATURE);
        return emd;
    }
    
    public static Map<Object, Object> createSaveLoadOptions() {
        if(saveLoadOptions == null) {
            saveLoadOptions = new HashMap<Object, Object>();
            saveLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            saveLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, createExtendedMetadata());
            saveLoadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE); // Allows proper loading of renamed XML elements.
        }
        return saveLoadOptions;
    }
    
    public static void hookResourceFactoryRegistry() {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("yafm", 
            new XMIResourceFactoryImpl(){
                @Override
                public Resource createResource(URI uri) {
                    XMIResource resource = (XMIResource) super.createResource(uri);
                    resource.getDefaultLoadOptions().putAll(createSaveLoadOptions());
                    resource.getDefaultSaveOptions().putAll(createSaveLoadOptions());
                    return resource;
                }
            }
        );
    }
    
    public static void hookPackageRegistry() {
        FeatureModelPackage.eINSTANCE.eClass();
    }
    
    public static FeatureModel createEmptyFeatureModel(String name) {
        if((name == null) || name.isEmpty())
            throw new IllegalArgumentException("Feature model name cannot be empty");
        
        FeatureModelFactory factory = FeatureModelFactory.eINSTANCE;
        
        Feature rootFeature = factory.createFeature();
        rootFeature.setId(name.trim().replaceAll("\\s+", ".").toLowerCase());
        rootFeature.setName(name);
        rootFeature.setLower(1);
        rootFeature.setUpper(1);
        
        FeatureModel featureModel = factory.createFeatureModel();
        featureModel.setName(name);
        featureModel.setRoot(rootFeature);
        return featureModel;
    }

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
    
    public static int getTreeHeight(FeatureModel featureModel) {
        if((featureModel == null) || (featureModel.getRoot() == null))
            return 0;
        return getTreeHeight(featureModel.getRoot());
    }
    
    public static int getTreeHeight(Feature feature) {
        int maxHeight = 0;
        
        for(Feature child: feature.getFeatures()) {
            int height = getTreeHeight(child);
            if(height > maxHeight)
                height = maxHeight;
        }

        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures()) {
                int height = getTreeHeight(child);
                if(height > maxHeight)
                    height = maxHeight;
            }
        }
        
        return maxHeight + 1;
    }
    
}
