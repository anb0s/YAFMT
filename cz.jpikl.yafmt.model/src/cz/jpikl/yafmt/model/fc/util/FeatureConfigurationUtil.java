package cz.jpikl.yafmt.model.fc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage.Literals;

public class FeatureConfigurationUtil {

    private static Map<Object, Object> saveLoadOptions;
    
    private static XMLInfo createXmlInfo(String name) {
        XMLInfo info = new XMLInfoImpl();
        info.setName(name);
        return info;
    }
    
    private static XMLResource.XMLMap createXmlNamesMapping() {  
        XMLResource.XMLMap mapping = new XMLMapImpl();
        XMLInfo rootInfo = createXmlInfo("feature-configuration");
        rootInfo.setTargetNamespace(FeatureConfigurationPackage.eNS_URI);
        mapping.add(Literals.FEATURE_CONFIGURATION, rootInfo);
        mapping.add(Literals.FEATURE_CONFIGURATION__FEATURE_MODEL, createXmlInfo("feature-model"));
        mapping.add(Literals.FEATURE_CONFIGURATION__SELECTIONS, createXmlInfo("feature"));
        mapping.add(Literals.SELECTION__VALUES, createXmlInfo("attribute"));
        mapping.add(Literals.BOOLEAN_VALUE, createXmlInfo("boolean"));
        mapping.add(Literals.INTEGER_VALUE, createXmlInfo("integer"));
        mapping.add(Literals.DOUBLE_VALUE, createXmlInfo("double"));
        mapping.add(Literals.STRING_VALUE, createXmlInfo("string"));
        return mapping;
    }
    
    public static Map<Object, Object> createSaveLoadOptions() {
        if(saveLoadOptions == null) {
            Map<Object, Object> saveLoadOptions = new HashMap<Object, Object>();
            saveLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            saveLoadOptions.put(XMLResource.OPTION_XML_MAP, createXmlNamesMapping());
        }
        return saveLoadOptions;
    }

}
