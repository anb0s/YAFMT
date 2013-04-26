package cz.zcu.yafmt.model.provider.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.widgets.Composite;

import cz.zcu.yafmt.model.validation.IStructuralFeatureValidator;

public class ValidatingPropertyDescriptor extends PropertyDescriptor {

    private IStructuralFeatureValidator validator;

    public ValidatingPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor, IStructuralFeatureValidator validator) {
        super(object, itemPropertyDescriptor);
        this.validator = validator;
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite) {
        return attachValidator(super.createPropertyEditor(composite));
    }

    public CellEditor attachValidator(CellEditor cellEditor) {
        if(cellEditor != null)
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
            EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(value);
            String result = validator.getStructuralFeatureError((EObject) object, structuralFeature, value);
            if(result != null)
                return result;
            if(originalValidator != null)
                return originalValidator.isValid(value);
            return null;
        }

    }

}
