package cz.jpikl.yafmt.model.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage.Literals;

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
    
    public static FeatureModel createEmptyFeatureModel(String name) {
        FeatureModelFactory factory = FeatureModelFactory.eINSTANCE;
        
        Feature rootFeature = factory.createFeature();
        rootFeature.setId(name);
        rootFeature.setName(name);
        
        FeatureModel featureModel = factory.createFeatureModel();
        featureModel.setName(name);
        featureModel.setRoot(rootFeature);
        return featureModel;
    }
    
}
