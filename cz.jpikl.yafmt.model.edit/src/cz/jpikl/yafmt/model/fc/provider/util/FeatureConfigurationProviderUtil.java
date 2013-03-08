package cz.jpikl.yafmt.model.fc.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.model.fc.provider.FeatureConfigurationItemProviderAdapterFactory;
import cz.jpikl.yafmt.model.validation.ValidatingPropertySource;

public class FeatureConfigurationProviderUtil {

    private static final FeatureConfigurationPropertySourceValidator validator = new FeatureConfigurationPropertySourceValidator();
    private static FeatureConfigurationItemProviderAdapterFactory adapterFactory = new FeatureConfigurationItemProviderAdapterFactory();

    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(adapterFactory) {

            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new ValidatingPropertySource(object, itemPropertySource, validator);
            }
        };
    }

    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(adapterFactory);
    }

}
