package cz.jpikl.yafmt.editors.featuremodel.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;

public class AddConstraintAction extends BaseAction {

    public static final String ID = "cz.jpikl.yafmt.editors.featuremodel.actions.AddConstraintAction";

    public AddConstraintAction(IUndoContext undoContext, FeatureModel featureModel, TableViewer viewer) {
        super(undoContext, featureModel, viewer);
        setId(ID);
        setText("Add new constraint");

        ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
        setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
    }

    @Override
    protected IUndoableOperation createOperation() {
        return new AddOperation();
    }

    private class AddOperation extends AbstractOperation {

        private Constraint newConstraint;

        public AddOperation() {
            super("Add new constraint");
            setId(ActionFactory.DELETE.getId());
        }

        @Override
        public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
            newConstraint = FeatureModelFactory.eINSTANCE.createConstraint();
            newConstraint.setValue("<new constraint>");
            IStatus status = redo(monitor, info);
            viewer.editElement(newConstraint, 0);
            return status;
        }

        @Override
        public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
            featureModel.getConstraints().add(newConstraint);
            return Status.OK_STATUS;
        }

        @Override
        public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
            featureModel.getConstraints().remove(newConstraint);
            return Status.OK_STATUS;
        }

    }

}
