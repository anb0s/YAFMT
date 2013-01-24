package cz.jpikl.yafmt.model.provider.util;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class ValidatingPropertySource extends PropertySource {

    private IPropertySourceValidator validator;
    
    public ValidatingPropertySource(Object object, IItemPropertySource itemPropertySource, IPropertySourceValidator validator) {
        super(object, itemPropertySource);
        this.validator = validator;
    }

    @Override
    public Object getEditableValue() {
        // Unwrap value is necessary.
        Object value = super.getEditableValue();
        if(value instanceof PropertyValueWrapper)
            return ((PropertyValueWrapper) value).getEditableValue(null);
        return value;
    }

    @Override
    public Object getPropertyValue(Object id) {
        // Unwrap value is necessary.
        Object value = super.getPropertyValue(id);
        if(value instanceof PropertyValueWrapper)
            return ((PropertyValueWrapper) value).getEditableValue(null);
        return value;
    }
    
    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
        return new ValidatingPropertyDescriptor(object, itemPropertyDescriptor);
    }
    
    private class ValidatingPropertyDescriptor extends PropertyDescriptor {
        
        public ValidatingPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
            super(object, itemPropertyDescriptor);
        }
        
        @Override
        protected CellEditor createEDataTypeCellEditor(EDataType eDataType, Composite composite) {
            CellEditor cellEditor = super.createEDataTypeCellEditor(eDataType, composite);
            cellEditor.setValidator(new ValidatorAdapter(cellEditor.getValidator()));
            return cellEditor;
        }
        
        private class ValidatorAdapter implements ICellEditorValidator {

            private ICellEditorValidator originalValidator;
            
            public ValidatorAdapter(ICellEditorValidator originalValidator) {
                this.originalValidator = originalValidator;
            }
            
            @Override
            public String isValid(Object value) {
                String property = itemPropertyDescriptor.getId(value);
                String result = validator.validate(object, property, (String) value);
                if(result != null)
                    return result;
                if(originalValidator != null)
                    return originalValidator.isValid(value);
                return null;
            }
            
        }
        
    }

}