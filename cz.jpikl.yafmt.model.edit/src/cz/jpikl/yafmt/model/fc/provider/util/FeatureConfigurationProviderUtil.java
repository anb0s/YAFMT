package cz.jpikl.yafmt.model.fc.provider.util;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import cz.jpikl.yafmt.model.fc.provider.FeatureConfigurationItemProviderAdapterFactory;

public class FeatureConfigurationProviderUtil {

    private static FeatureConfigurationItemProviderAdapterFactory adapterFactory;
    
    public static FeatureConfigurationItemProviderAdapterFactory getAdapterFactory() {
        if(adapterFactory == null)
            adapterFactory = new FeatureConfigurationItemProviderAdapterFactory();
        return adapterFactory;
    }
    
    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(getAdapterFactory());
    }
    
    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(getAdapterFactory());
    }
    
}
