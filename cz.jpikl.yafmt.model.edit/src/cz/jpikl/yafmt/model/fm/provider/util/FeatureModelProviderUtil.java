package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.model.fm.provider.FeatureModelItemProviderAdapterFactory;

public class FeatureModelProviderUtil {

    private static FeatureModelItemProviderAdapterFactory adapterFactory;
    
    public static FeatureModelItemProviderAdapterFactory getAdapterFactory() {
        if(adapterFactory == null)
            adapterFactory = new FeatureModelItemProviderAdapterFactory();
        return adapterFactory;
    }
    
    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(getAdapterFactory()) {
            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new FeatureModelPropertySource(object, itemPropertySource);
            }
        };
    }
    
    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(getAdapterFactory());
    }
    
}
