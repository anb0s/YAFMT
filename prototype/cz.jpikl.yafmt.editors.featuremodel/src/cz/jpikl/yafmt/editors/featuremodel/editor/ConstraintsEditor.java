package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class ConstraintsEditor extends EditorPart implements ISelectionListener {

	private ListViewer viewer;
	private FeatureModel featureModel;
	private ActionRegistry actionRegistry;
	
	public ConstraintsEditor(FeatureModel featureModel) {
		this.featureModel = featureModel;
		this.actionRegistry = new ActionRegistry();
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
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if(adapter == ActionRegistry.class)
			return actionRegistry;
		return super.getAdapter(adapter);
	}
	
	// =======================================================
	//  ISelectionListener
	// =======================================================
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		String id = part.getClass().getName();
		if((id == "cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView") || 
		   (id == "org.eclipse.ui.views.contentoutline.ContentOutline")) {
			viewer.setSelection(selection);
		}
	}
	
	// =======================================================
	//  Not implemented
	// =======================================================
	
	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

}
