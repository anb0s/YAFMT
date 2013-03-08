package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.model.fm.provider.FeatureModelItemProviderAdapterFactory;

public class FeatureModelProviderUtil {

    private static FeatureModelItemProviderAdapterFactory adapterFactory = new FeatureModelItemProviderAdapterFactory();

    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(adapterFactory) {
            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new FeatureModelPropertySource(object, itemPropertySource);
            }
        };
    }

    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(adapterFactory);
    }

}
