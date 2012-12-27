package cz.jpikl.yafmt.editors.featuremodel.actions;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class DeleteConstraintAction extends BaseAction {

	public DeleteConstraintAction(IUndoContext undoContext, FeatureModel featureModel, TableViewer viewer) {
		super(undoContext, featureModel, viewer);
		setId(ActionFactory.DELETE.getId());
		setText("Delete selected constraint");
		
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}
	
	@Override
	public boolean isEnabled() {
		return !viewer.getSelection().isEmpty();
	}

	@Override
	protected IUndoableOperation createOperation() {
		return new DeleteOperation();
	}
	
	private class DeleteOperation extends AbstractOperation {

		private List<Constraint> removedObjects;
		
		public DeleteOperation() {
			super("Delete selected constraints");
			setId(ActionFactory.DELETE.getId());
		}

		@SuppressWarnings("unchecked")
		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			removedObjects = ((IStructuredSelection) viewer.getSelection()).toList();
			return redo(monitor, info);
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			featureModel.getConstraints().removeAll(removedObjects);
			return Status.OK_STATUS;
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			featureModel.getConstraints().addAll(removedObjects);
			return Status.OK_STATUS;
		}
		
	}

}
