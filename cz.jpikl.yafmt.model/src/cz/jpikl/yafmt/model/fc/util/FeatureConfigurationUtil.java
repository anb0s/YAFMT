package cz.jpikl.yafmt.model.fc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationFactory;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class FeatureConfigurationUtil {

    private static Map<Object, Object> saveLoadOptions;
    
    private static ExtendedMetaData createExtendedMetadata() {
        ExtendedMetaData emd = new BasicExtendedMetaData();
        emd.setName(Literals.FEATURE_CONFIGURATION, "feature-configuration");
        emd.setName(Literals.FEATURE_CONFIGURATION__FEATURE_MODEL, "feature-model");
        emd.setName(Literals.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY, "feature-model-copy");
        emd.setName(Literals.FEATURE_CONFIGURATION__ROOT, "root-feature");
        emd.setName(Literals.SELECTION__SELECTIONS, "feature");
        emd.setName(Literals.SELECTION__VALUES, "attribute");
        emd.setName(Literals.BOOLEAN_VALUE, "boolean");
        emd.setName(Literals.INTEGER_VALUE, "integer");
        emd.setName(Literals.DOUBLE_VALUE, "double");
        emd.setName(Literals.STRING_VALUE, "string");
        emd.setFeatureKind(Literals.FEATURE_CONFIGURATION__DESCRIPTION, ExtendedMetaData.ELEMENT_FEATURE);
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
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("yafc", 
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
        FeatureConfigurationPackage.eINSTANCE.eClass();
    }
    
    public static FeatureConfiguration createEmptyFeatureConfiguration(FeatureModel featureModel) {
        return createEmptyFeatureConfiguration(featureModel, (featureModel != null) ? featureModel.getName() : null); 
    }
    
    public static FeatureConfiguration createEmptyFeatureConfiguration(FeatureModel featureModel, String name) {
        if(featureModel == null)
            throw new IllegalArgumentException("Feature model cannot be null");
        
        FeatureConfiguration featureConfig = FeatureConfigurationFactory.eINSTANCE.createFeatureConfiguration();
        featureConfig.setFeatureModel(featureModel);
        featureConfig.setFeatureModelCopy(EcoreUtil.copy(featureModel));
        featureConfig.setRoot(createSelection(featureModel.getRoot()));
        
        return featureConfig;
    }
    
    public static Selection createSelection(Feature feature) {
        Selection selection = FeatureConfigurationFactory.eINSTANCE.createSelection();
        selection.setId(feature.getId());
        
        for(Attribute attribute: feature.getAttributes())
            selection.getValues().add(createAttributeValue(attribute));
        
        return selection;
    }
    
    public static AttributeValue createAttributeValue(Attribute attribute) {
        AttributeValue value = createAttributeValue(attribute.getType());
        value.setId(attribute.getId());
        return value;
    }
    
    public static AttributeValue createAttributeValue(AttributeType attributeType) {
        switch (attributeType) {
            case BOOLEAN: return FeatureConfigurationFactory.eINSTANCE.createBooleanValue();
            case INTEGER: return FeatureConfigurationFactory.eINSTANCE.createIntegerValue();
            case DOUBLE: return FeatureConfigurationFactory.eINSTANCE.createDoubleValue();
            case STRING: return FeatureConfigurationFactory.eINSTANCE.createStringValue();
            default: return FeatureConfigurationFactory.eINSTANCE.createStringValue();
        }
    }
    
}
