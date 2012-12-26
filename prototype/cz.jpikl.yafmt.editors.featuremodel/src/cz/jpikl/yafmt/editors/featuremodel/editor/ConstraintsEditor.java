package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class ConstraintsEditor extends EditorPart {

	private ListViewer viewer;
	private FeatureModel featureModel;
	
	public ConstraintsEditor(FeatureModel featureModel) {
		this.featureModel = featureModel;
	}	
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new ListViewer(parent);
		viewer.setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof FeatureModel)
					return ((FeatureModel) inputElement).getConstraints().toArray();
				return null;
			}
		});
		viewer.setLabelProvider(new ILabelProvider() {
			
			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getText(Object element) {
				if(element instanceof Constraint)
					return ((Constraint) element).getValue();
				return null;
			}
			
			@Override
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		viewer.setInput(featureModel);
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
		super.dispose();
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
