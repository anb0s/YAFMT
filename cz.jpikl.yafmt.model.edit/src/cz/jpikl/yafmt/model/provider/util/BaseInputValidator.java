package cz.jpikl.yafmt.model.provider.util;

import cz.jpikl.yafmt.model.fm.provider.FeatureModelEditPlugin;

public abstract class BaseInputValidator implements IInputValidator {
    
    protected String getString(String key, Object param) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, new Object[] { param }, true);
    }
    
    protected String getString(String key) {
        return FeatureModelEditPlugin.INSTANCE.getString(key, true);
    }

}
