package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.clang.ConstraintLanguageException;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.IConstraintLanguage;
import cz.jpikl.yafmt.clang.IEvaluator;
import cz.jpikl.yafmt.clang.IValidationResult;
import cz.jpikl.yafmt.clang.ui.EditingContext;
import cz.jpikl.yafmt.clang.ui.EditingSupportRegistry;
import cz.jpikl.yafmt.clang.ui.IEditingSupport;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.commands.SetConstraintValueCommand;

public class ConstraintsEditorEditingSupport extends EditingSupport {

    private IStatusLineManager statusLineManager;
    private CommandStack commandStack;
    
    public ConstraintsEditorEditingSupport(ColumnViewer viewer, CommandStack commandStack) {
        super(viewer);
        this.commandStack = commandStack;
    }
        
    private Table getTable() {
        return ((TableViewer) getViewer()).getTable();
    }
    
    private FeatureModel getFeatureModel() {
        return (FeatureModel) getViewer().getInput();
    }
    
    private IStatusLineManager getStatusLineManager() {
        if(statusLineManager == null) {
            statusLineManager = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().
                                getActiveEditor().getEditorSite().getActionBars().getStatusLineManager();
        }
        return statusLineManager;
    }
    
    // ================================================================================
    //  EditingSupport
    // ================================================================================

    @Override
    protected CellEditor getCellEditor(Object element) {
        CellEditor editor = null;
        
        String languageId = ((Constraint) element).getLanguage();
        ConstraintLanguageRegistry clRegistry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        EditingSupportRegistry esRegistry = ConstraintLanguagePlugin.getDefault().getEditingSupportRegistry();
        IConstraintLanguage language = clRegistry.getLanguage(languageId);
        IEditingSupport editingSupport = esRegistry.getEditingSupport(languageId);
        
        // Custom editor.
        if(editingSupport != null) {
            EditingContext context = new EditingContext(getFeatureModel());
            editor = editingSupport.createCellEditor(getTable(), context);
        } 
        // Fallback editor.
        else {
            editor = new TextCellEditor(getTable());
        }
        
        editor.setValidator(new EditorValidator(language));
        editor.addListener(new EditorListener(editor));
        return editor;
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
        commandStack.execute(command);
    }
    
    // ================================================================================
    //  Input validator
    // ================================================================================

    private class EditorValidator implements ICellEditorValidator {

        private IConstraintLanguage language;
                
        public EditorValidator(IConstraintLanguage language) {
            this.language = language;
        }

        @Override
        public String isValid(Object value) {
            if(language == null)
                return null;
            
            try {
                IEvaluator evaluator = language.createEvaluator((String) value);
                IValidationResult result = evaluator.validate(getFeatureModel());
                return result.isSuccess() ? null : result.getErrorMessage();
            }
            catch(ConstraintLanguageException ex) {
                return ex.getMessage();
            }
        }
        
    }
    
    // ================================================================================
    //  Editor listener
    // ================================================================================
    
    private class EditorListener implements ICellEditorListener {
    
        private CellEditor editor;
                
        public EditorListener(CellEditor editor) {
            this.editor = editor;
        }

        @Override
        public void applyEditorValue() {
            getStatusLineManager().setErrorMessage(null);
        }
    
        @Override
        public void cancelEditor() {
            getStatusLineManager().setErrorMessage(null);
        }
    
        @Override
        public void editorValueChanged(boolean oldValidState, boolean newValidState) {
            getStatusLineManager().setErrorMessage(editor.getErrorMessage());
        }
    
    }

}
