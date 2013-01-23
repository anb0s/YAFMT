package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ui.views.properties.IPropertySource;

import cz.jpikl.yafmt.model.fm.provider.FeatureModelItemProviderAdapterFactory;
import cz.jpikl.yafmt.model.provider.util.IInputValidator;
import cz.jpikl.yafmt.model.provider.util.ValidatingPropertySource;

public class FeatureModelProviderUtil {

    private static FeatureModelItemProviderAdapterFactory adapterFactory;
    private static IInputValidator inputValidator;

    public static FeatureModelItemProviderAdapterFactory getAdapterFactory() {
        if(adapterFactory == null)
            adapterFactory = new FeatureModelItemProviderAdapterFactory();
        return adapterFactory;
    }
    
    private static IInputValidator getInputValidator() {
        if(inputValidator == null)
            inputValidator = new FeatureModelInputValidator();
        return inputValidator;
    }

    public static AdapterFactoryContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(getAdapterFactory()) {
            @Override
            protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
                return new ValidatingPropertySource(object, itemPropertySource, getInputValidator());
            }
        };
    }
    
    public static AdapterFactoryLabelProvider getLabelProvider() {
        return new AdapterFactoryLabelProvider(getAdapterFactory());
    }
    
}
