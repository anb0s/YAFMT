package cz.zcu.yafmt.model.fm.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

public class UnknownFeatureResourceHandler extends BasicResourceHandler {

    public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
        final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
        for(Iterator<Entry<EObject, AnyType>> itr = extMap.entrySet().iterator(); itr.hasNext();) {
            Entry<?, ?> entry = (Entry<?, ?>) itr.next();
            EObject key = (EObject) entry.getKey();
            AnyType value = (AnyType) entry.getValue();
            handleUnknownData(key, value);
        }
    }

    private void handleUnknownData(EObject eObj, AnyType unknownData) {
        handleUnknownFeatures(eObj, unknownData.getMixed());
        handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
    }

    private void handleUnknownFeatures(EObject owner, FeatureMap featureMap) {
        for (Iterator<FeatureMap.Entry> iter = featureMap.iterator(); iter.hasNext();) {
            FeatureMap.Entry entry = (FeatureMap.Entry) iter.next();
            EStructuralFeature f = entry.getEStructuralFeature();
            if(handleUnknownFeature(owner, f, entry.getValue())) {
                iter.remove();
            }
        }
    }

    private boolean handleUnknownFeature(EObject owner, EStructuralFeature f, Object value) {
        if (owner.getClass() == cz.zcu.yafmt.model.fm.impl.AttributeImpl.class) {
            if (f.getName().equals("value")) {
                f.setName("defaultValue");
            }
        }
        return false;
    }

}
