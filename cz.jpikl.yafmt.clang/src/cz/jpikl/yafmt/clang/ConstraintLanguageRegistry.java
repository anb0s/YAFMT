package cz.jpikl.yafmt.clang;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConstraintLanguageRegistry {

    private Map<String, ConstraintLanguageDescriptor> registry = new HashMap<String, ConstraintLanguageDescriptor>();
    
    protected void putDescriptor(ConstraintLanguageDescriptor descriptor) {
        registry.put(descriptor.getId(), descriptor);
    }
    
    public Collection<ConstraintLanguageDescriptor> getDescriptors() {
        return Collections.unmodifiableCollection(registry.values());
    }
    
    public ConstraintLanguageDescriptor getDescriptor(String id) {
        return registry.get(id);
    }
    
    public ConstraintLanguage getLanguage(String id) {
        ConstraintLanguageDescriptor descriptor = registry.get(id);
        return (descriptor == null) ? null : descriptor.getLanguage();
    }
    
}
