package cz.jpikl.yafmt.model.fm.provider.util;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ui.EditingContext;
import cz.jpikl.yafmt.clang.ui.EditingSupportRegistry;
import cz.jpikl.yafmt.clang.ui.IEditingSupport;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.validation.IPropertySourceValidator;
import cz.jpikl.yafmt.model.validation.ValidatingPropertyDescriptor;

public class ConstraintValuePropertyDescriptor extends ValidatingPropertyDescriptor {
    
    public ConstraintValuePropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor, IPropertySourceValidator validator) {
        super(object, itemPropertyDescriptor, validator);
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite) {
        Constraint constraint = (Constraint) object;
        
        // Use language custom editor from extension point if possible.
        EditingSupportRegistry registry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IEditingSupport editingSupport = registry.getEditingSupport(constraint.getLanguage());
        if(editingSupport != null) {
            EditingContext context = new EditingContext(constraint.getFeatureModel());
            return attachValidator(editingSupport.createCellEditor(composite, context));
        }
        
        return super.createPropertyEditor(composite);
    }

}
