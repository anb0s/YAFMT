package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ui.EditingSupportRegistry;
import cz.jpikl.yafmt.clang.ui.IEditingSupport;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.provider.util.IPropertySourceValidator;
import cz.jpikl.yafmt.model.provider.util.ValidatingPropertyDescriptor;

public class ConstraintValuePropertyDescriptor extends ValidatingPropertyDescriptor {
    
    public ConstraintValuePropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor, IPropertySourceValidator validator) {
        super(object, itemPropertyDescriptor, validator);
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite) {
        EditingSupportRegistry registry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IEditingSupport editingSupport = registry.getEditingSupport(((Constraint) object).getLanguage());
        if(editingSupport != null)
            return attachValidator(editingSupport.createCellEditor(composite));
        return super.createPropertyEditor(composite);
    }

}
