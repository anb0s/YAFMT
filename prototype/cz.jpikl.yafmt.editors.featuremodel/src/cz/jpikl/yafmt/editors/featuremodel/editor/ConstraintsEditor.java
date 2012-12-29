package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.util.Iterator;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.EditorPart;

import cz.jpikl.yafmt.editors.featuremodel.actions.AddConstraintAction;
import cz.jpikl.yafmt.editors.featuremodel.actions.DeleteConstraintAction;
import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class ConstraintsEditor extends EditorPart implements ISelectionListener,
                                                             IOperationHistoryListener,
                                                             KeyListener {

    private FeatureModel featureModel;
    private IUndoContext undoContext;
    private TableViewer viewer;
    private ActionRegistry actionRegistry;
    private int historyPosition = 0;
    private int savedHistoryPosition = 0;

    public ConstraintsEditor(FeatureModel featureModel) {
        this.featureModel = featureModel;
        this.undoContext = new ObjectUndoContext(this);
    }

    @Override
    public void createPartControl(Composite parent) {
        viewer = new TableViewer(parent);

        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        column.getColumn().setWidth(100);
        column.setEditingSupport(new ConstraintsEditorEditingSupport(viewer, undoContext));
        column.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((Constraint) element).getValue();
            }
        });
        ColumnViewerEditorActivationStrategy activationStrategy = new ColumnViewerEditorActivationStrategy(viewer) {
            @Override
            protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
                return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL ||
                       event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION ||
                        event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
            }
        };
        TableViewerEditor.create(viewer, activationStrategy, SWT.NONE);

        viewer.setContentProvider(new ConstraintsEditorContentProvider());
        viewer.setInput(featureModel);
        viewer.getTable().addKeyListener(this);

        initActions();
        getSite().setSelectionProvider(viewer);
        getSite().getPage().addSelectionListener(this);
        getOperationHistory().addOperationHistoryListener(this);
    }

    private void initActions() {
        IAction undoAction = new UndoActionHandler(getSite(), undoContext);
        undoAction.setId(ActionFactory.UNDO.getId());
        IAction redoAction = new  RedoActionHandler(getSite(), undoContext);
        redoAction.setId(ActionFactory.REDO.getId());

        actionRegistry = new ActionRegistry();
        actionRegistry.registerAction(undoAction);
        actionRegistry.registerAction(redoAction);
        actionRegistry.registerAction(new AddConstraintAction(undoContext, featureModel, viewer));
        actionRegistry.registerAction(new DeleteConstraintAction(undoContext, featureModel, viewer));
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSite(site);
        setInput(input);
    }

    @Override
    public void dispose() {
        getOperationHistory().removeOperationHistoryListener(this);
        getSite().getPage().removeSelectionListener(this);
        getSite().setSelectionProvider(null);
        super.dispose();
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        savedHistoryPosition = historyPosition;
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public boolean isDirty() {
        return savedHistoryPosition != historyPosition;
    }

    private IOperationHistory getOperationHistory() {
        return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
    }

    // =======================================================
    //  IOperationHistoryListener
    // =======================================================

    @Override
    public void historyNotification(OperationHistoryEvent event) {
        boolean sameContext = false;
        for(IUndoContext context: event.getOperation().getContexts()) {
            if(context == undoContext)
                sameContext = true;
        }

        if(!sameContext)
            return;

        switch(event.getEventType()) {
            case OperationHistoryEvent.DONE:
            case OperationHistoryEvent.REDONE:
                historyPosition++;
                firePropertyChange(PROP_DIRTY);
                break;

            case OperationHistoryEvent.UNDONE:
                historyPosition--;
                firePropertyChange(PROP_DIRTY);
                break;
        }
    }

    // =======================================================
    //  ISelectionListener
    // =======================================================

    @Override
    public void keyReleased(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch(event.keyCode) {
            case SWT.DEL:
                IAction deleteAction = actionRegistry.getAction(ActionFactory.DELETE.getId());
                if(deleteAction.isEnabled())
                    deleteAction.run();
                break;
        }
    }

    // =======================================================
    //  ISelectionListener
    // =======================================================

    @SuppressWarnings("unchecked")
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        String id = part.getClass().getName();
        if((id.equals("cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView")) ||
           (id.equals("org.eclipse.ui.views.contentoutline.ContentOutline")) ||
           (part instanceof FeatureModelEditor)) {

            // Update view selection only when selection occurred in other part.
            if(!(part instanceof FeatureModelEditor))
                viewer.setSelection(selection);

            // Update actions when selection changes
            Iterator<IAction> it = actionRegistry.getActions();
            while(it.hasNext()) {
                IAction action = it.next();
                if(action instanceof UpdateAction)
                    ((UpdateAction) action).update();
            }

        }
    }

    // =======================================================
    //  IAdaptable
    // =======================================================

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class adapter) {
        if(adapter == ActionRegistry.class)
            return actionRegistry;
        return super.getAdapter(adapter);
    }

}
