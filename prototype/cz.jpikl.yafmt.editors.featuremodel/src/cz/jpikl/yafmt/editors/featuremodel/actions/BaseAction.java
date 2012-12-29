package cz.jpikl.yafmt.editors.featuremodel.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public abstract class BaseAction extends Action implements UpdateAction {

    private IUndoContext undoContext;
    protected FeatureModel featureModel;
    protected TableViewer viewer;

    public BaseAction(IUndoContext undoContext, FeatureModel featureModel, TableViewer viewer) {
        this.undoContext = undoContext;
        this.featureModel = featureModel;
        this.viewer = viewer;
    }

    protected abstract IUndoableOperation createOperation();

    @Override
    public void run() {
        try {
            IUndoableOperation operation = createOperation();
            operation.addContext(undoContext);
            IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
            operationHistory.execute(operation, null, null);
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {
        setEnabled(isEnabled());
    }

}
