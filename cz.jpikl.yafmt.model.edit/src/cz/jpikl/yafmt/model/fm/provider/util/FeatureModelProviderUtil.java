package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import cz.jpikl.yafmt.model.fm.provider.FeatureModelItemProviderAdapterFactory;

public class FeatureModelProviderUtil {

    private static FeatureModelItemProviderAdapterFactory adapterFactory;

    public static FeatureModelItemProviderAdapterFactory getAdapterFactory() {
        if(adapterFactory == null)
            adapterFactory = new FeatureModelItemProviderAdapterFactory();
        return adapterFactory;
    }

    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(getAdapterFactory());
    }
    
    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(getAdapterFactory());
    }
    
}
