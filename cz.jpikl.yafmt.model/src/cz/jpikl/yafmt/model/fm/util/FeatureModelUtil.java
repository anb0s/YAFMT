package cz.jpikl.yafmt.model.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage.Literals;

public class FeatureModelUtil {

    private static Map<Object, Object> saveLoadOptions;
    
    private static XMLInfo createXmlInfo(String name) {
        XMLInfo info = new XMLInfoImpl();
        info.setName(name);
        return info;
    }
    
    private static XMLResource.XMLMap createXmlNamesMapping() {  
        XMLResource.XMLMap mapping = new XMLMapImpl();
        XMLInfo rootInfo = createXmlInfo("feature-model");
        rootInfo.setTargetNamespace(FeatureModelPackage.eNS_URI);
        mapping.add(Literals.FEATURE_MODEL, rootInfo);
        mapping.add(Literals.FEATURE_MODEL__CONSTRAINT_LANGUAGE, createXmlInfo("constraint-language"));
        mapping.add(Literals.FEATURE_MODEL__CONSTRAINTS, createXmlInfo("constraint"));
        mapping.add(Literals.FEATURE_MODEL__ORPHANS, createXmlInfo("orphaned-feature"));
        mapping.add(Literals.FEATURE_MODEL__ROOT, createXmlInfo("root-feature"));
        mapping.add(Literals.FEATURE__ATTRIBUTES, createXmlInfo("attribute"));
        mapping.add(Literals.FEATURE__FEATURES, createXmlInfo("feature"));
        mapping.add(Literals.FEATURE__GROUPS, createXmlInfo("group"));
        mapping.add(Literals.FEATURE__LOWER, createXmlInfo("lower-bound"));
        mapping.add(Literals.FEATURE__UPPER, createXmlInfo("upper-bound"));
        mapping.add(Literals.GROUP__FEATURES, createXmlInfo("feature"));
        mapping.add(Literals.GROUP__LOWER, createXmlInfo("lower-bound"));
        mapping.add(Literals.GROUP__UPPER, createXmlInfo("upper-bound"));
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
