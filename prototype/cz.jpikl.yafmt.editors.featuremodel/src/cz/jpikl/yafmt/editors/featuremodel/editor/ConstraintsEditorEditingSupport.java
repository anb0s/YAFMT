package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.models.featuremodel.Constraint;

public class ConstraintsEditorEditingSupport extends EditingSupport {

	private IUndoContext undoContext;
	
	public ConstraintsEditorEditingSupport(ColumnViewer viewer, IUndoContext undoContext) {
		super(viewer);
		this.undoContext = undoContext;
	}

	@Override
	protected void setValue(Object element, Object value) {
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		IUndoableOperation operation = new ChangeConstraintOperation((Constraint) element, (String) value);
		operation.addContext(undoContext);
		
		try {
			operationHistory.execute(operation, null, null);
			getViewer().update(element, null);
		}
		catch(ExecutionException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected Object getValue(Object element) {
		return ((Constraint) element).getValue();
	}
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor(((TableViewer) getViewer()).getTable());
	}
	
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}
	
	public static class ChangeConstraintOperation extends AbstractOperation {

		private Constraint constraint;
		private String newValue;
		private String oldValue;
		
		public ChangeConstraintOperation(Constraint constraint, String newValue) {
			super("Change constraint");
			this.constraint = constraint;
			this.newValue = newValue;
		}
		
		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			this.oldValue = constraint.getValue();
			return redo(monitor, info);
		}
		
		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			constraint.setValue(newValue);
			return Status.OK_STATUS;
		}
		
		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			constraint.setValue(oldValue);
			return Status.OK_STATUS;
		}
		
	}
	
}
