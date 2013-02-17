package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ui.EditingContext;
import cz.jpikl.yafmt.clang.ui.EditingSupportRegistry;
import cz.jpikl.yafmt.clang.ui.IEditingSupport;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.commands.SetConstraintValueCommand;

public class ConstraintsEditorEditingSupport extends EditingSupport {

    private EditDomain editDomain;
    
    public ConstraintsEditorEditingSupport(ColumnViewer viewer) {
        super(viewer);
    }
    
    public void setEditDomain(EditDomain editDomain) {
        this.editDomain = editDomain;
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        // Custom editor.
        EditingSupportRegistry registry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IEditingSupport editingSupport = registry.getEditingSupport(((Constraint) element).getLanguage());
        if(editingSupport != null) {
            EditingContext context = new EditingContext((FeatureModel) getViewer().getInput());
            return editingSupport.createCellEditor(((TableViewer) getViewer()).getTable(), context);
        }
        
        // Fallback editor.
        return new TextCellEditor(((TableViewer) getViewer()).getTable());
    }

    @Override
    protected boolean canEdit(Object element) {
        return element instanceof Constraint;
    }

    @Override
    protected Object getValue(Object element) {
        return ((Constraint) element).getValue();
    }

    @Override
    protected void setValue(Object element, Object value) {
        Constraint constraint = (Constraint) element;
        if(constraint.getValue().equals(value))
            return;
        
        Command command = new SetConstraintValueCommand(constraint, (String) value);
        editDomain.getCommandStack().execute(command);
    }

}
