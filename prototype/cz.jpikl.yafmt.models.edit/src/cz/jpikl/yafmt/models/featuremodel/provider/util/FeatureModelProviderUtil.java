package cz.jpikl.yafmt.models.featuremodel.provider.util;

import cz.jpikl.yafmt.models.featuremodel.provider.FeatureItemProvider;
import cz.jpikl.yafmt.models.featuremodel.provider.FeatureModelItemProvider;
import cz.jpikl.yafmt.models.featuremodel.provider.FeatureModelItemProviderAdapterFactory;

public class FeatureModelProviderUtil {

    private static FeatureModelItemProviderAdapterFactory adapterFactory;

    public static FeatureModelItemProviderAdapterFactory getAdapterFactory() {
        if(adapterFactory == null)
            adapterFactory = new FeatureModelItemProviderAdapterFactory();
        return adapterFactory;
    }

    public static FeatureModelItemProvider getFeatureModelItemProvider() {
        return (FeatureModelItemProvider) getAdapterFactory().createFeatureModelAdapter();
    }

    public static FeatureItemProvider getFeatureItemProvider() {
        return (FeatureItemProvider) getAdapterFactory().createFeatureAdapter();
    }

}
