package cz.jpikl.yafmt.editors.featuremodel.editor;


import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class ConstraintsEditor extends EditorPart implements ISelectionListener {

	private ListViewer viewer;
	private FeatureModel featureModel;
	private IUndoContext undoContext;
 
	private static class UndoAction extends Action implements IOperationHistoryListener {
		
		private IOperationHistory operationHistory;
		private IUndoContext undoContext;
		
		public UndoAction(IOperationHistory operationHistory, IUndoContext undoContext) {
			super("Undo");
			
			this.operationHistory = operationHistory;
			this.operationHistory.addOperationHistoryListener(this);
			this.undoContext = undoContext;
			
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
			setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_DISABLED));
		}

		@Override
		public void run() {
			try {
				operationHistory.undo(undoContext, null, null);
			} catch (ExecutionException ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public boolean isEnabled() {
			return operationHistory.canUndo(undoContext);
		}
		
		@Override
		public void historyNotification(OperationHistoryEvent event) {
			setEnabled(isEnabled());
		}
		
	}
	
	private static class RedoAction extends Action implements IOperationHistoryListener {
		
		private IOperationHistory operationHistory;
		private IUndoContext undoContext;
		
		public RedoAction(IOperationHistory operationHistory, IUndoContext undoContext) {
			super("Redo");
			
			this.operationHistory = operationHistory;
			this.operationHistory.addOperationHistoryListener(this);
			this.undoContext = undoContext;
			
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
			setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_REDO_DISABLED));
		}

		@Override
		public void run() {
			try {
				operationHistory.redo(undoContext, null, null);
			} catch (ExecutionException ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public boolean isEnabled() {
			return operationHistory.canRedo(undoContext);
		}

		@Override
		public void historyNotification(OperationHistoryEvent event) {
			setEnabled(isEnabled());
		}
		
	}
	
	private static class DeleteAction extends Action implements UpdateAction {
				
		private static class DeleteOperation extends AbstractOperation {

			private ListViewer viewer;
			private FeatureModel featureModel;
			private List<Constraint> removedObjects;
			
			public DeleteOperation(IUndoContext undoContext, ListViewer viewer, FeatureModel featureModel) {
				super("Delete selected constraints");
				this.viewer = viewer;
				this.featureModel = featureModel;
				addContext(undoContext);
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
			
			@Override
			public boolean canExecute() {
				return !viewer.getSelection().isEmpty();
			}
			
		}
		
		private IOperationHistory operationHistory;
		private IUndoContext undoContext;
		private ListViewer viewer;
		private FeatureModel featureModel;
		
		public DeleteAction(IOperationHistory operationHistory, IUndoContext undoContext, ListViewer viewer, FeatureModel featureModel) {
			super("Redo");
			
			this.operationHistory = operationHistory;
			this.undoContext = undoContext;
			this.viewer = viewer;
			this.featureModel = featureModel;
			
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
			setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		}

		@Override
		public void run() {
			try {
				operationHistory.execute(new DeleteOperation(undoContext, viewer, featureModel), null, null);
			} catch (ExecutionException ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public boolean isEnabled() {
			return !viewer.getSelection().isEmpty();
		}
		
		@Override
		public void update() {
			setEnabled(isEnabled());
		}
		
	}
	
	public IAction undo;
	public IAction redo;
	public IAction delete;
	private int savedPosition = 0;
	private int historyPosition = 0;
	
	public ConstraintsEditor(FeatureModel featureModel) {
		this.featureModel = featureModel;
		this.undoContext = new ObjectUndoContext(this);
		undo = new UndoAction(getOperationHistory(), undoContext);
		redo = new RedoAction(getOperationHistory(), undoContext);
		getOperationHistory().addOperationHistoryListener(new IOperationHistoryListener() {
			
			@Override
			public void historyNotification(OperationHistoryEvent event) {
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
		});
		
		
	}	
	
	@Override
	public void createPartControl(Composite parent) {
		ConstraintsEditorProvider provider = new ConstraintsEditorProvider();
		viewer = new ListViewer(parent);
		viewer.setContentProvider(provider);
		viewer.setLabelProvider(provider);
		viewer.setInput(featureModel);
		
		getSite().setSelectionProvider(viewer);
		getSite().getPage().addSelectionListener(this);
		
		delete = new DeleteAction(getOperationHistory(), undoContext, viewer, featureModel);
		
		viewer.getList().addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				if((event.keyCode == SWT.DEL) && delete.isEnabled())
					delete.run();
			}
		});
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
		
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		getSite().setSelectionProvider(null);
		super.dispose();
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// Clear operation history <-- NO.
		//getOperationHistory().dispose(undoContext, true, true, false);
		savedPosition = historyPosition;
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
		// When undo can be done, some constraints were changed.
		return savedPosition != historyPosition;
	}
	
	private IOperationHistory getOperationHistory() {
		return OperationHistoryFactory.getOperationHistory();
	}
	
	// =======================================================
	//  ISelectionListener
	// =======================================================
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		String id = part.getClass().getName();
		if((id == "cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView") || 
		   (id == "org.eclipse.ui.views.contentoutline.ContentOutline") ||
		   (part instanceof FeatureModelEditor)) {
			
			if(!(part instanceof FeatureModelEditor))
				viewer.setSelection(selection);
			((UpdateAction) delete).update();
		}
	}

}
