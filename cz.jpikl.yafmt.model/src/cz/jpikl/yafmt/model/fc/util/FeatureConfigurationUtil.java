package cz.jpikl.yafmt.model.fc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals;

public class FeatureConfigurationUtil {

    private static Map<Object, Object> saveLoadOptions;
    
    private static ExtendedMetaData createExtendedMetadata() {
        ExtendedMetaData emd = new BasicExtendedMetaData();
        emd.setName(Literals.FEATURE_CONFIGURATION, "feature-configuration");
        emd.setName(Literals.FEATURE_CONFIGURATION__FEATURE_MODEL, "feature-model");
        emd.setName(Literals.FEATURE_CONFIGURATION__SELECTIONS, "feature");
        emd.setName(Literals.SELECTION__VALUES, "attribute");
        emd.setName(Literals.BOOLEAN_VALUE, "boolean");
        emd.setName(Literals.INTEGER_VALUE, "integer");
        emd.setName(Literals.DOUBLE_VALUE, "double");
        emd.setName(Literals.STRING_VALUE, "string");
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

}
