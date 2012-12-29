package cz.jpikl.yafmt.editors.featuremodel.utils;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;

// Fixes class cast exception when using property source from EMF.Edit.
public class UnwrappingPropertySource extends PropertySource {

    public UnwrappingPropertySource(Object object, IItemPropertySource itemPropertySource) {
        super(object, itemPropertySource);
    }

    @Override
    public Object getEditableValue() {
        Object value = super.getEditableValue();
        if(value instanceof PropertyValueWrapper)
            return ((PropertyValueWrapper) value).getEditableValue(null);
        return value;
    }

    @Override
    public Object getPropertyValue(Object id) {
        Object value = super.getPropertyValue(id);
        if(value instanceof PropertyValueWrapper)
            return ((PropertyValueWrapper) value).getEditableValue(null);
        return value;
    }

}
