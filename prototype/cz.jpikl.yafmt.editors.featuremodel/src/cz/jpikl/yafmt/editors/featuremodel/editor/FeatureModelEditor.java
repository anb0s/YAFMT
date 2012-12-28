package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import cz.jpikl.yafmt.editors.featuremodel.utils.EditorUtil;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

public class FeatureModelEditor extends MultiPageEditorPart implements ISelectionListener {

	private FeatureModel featureModel;
	private ContentOutlinePage outlinePage;
	private DefaultEditDomain editDomain;
	
	public FeatureModelEditor() {
		editDomain = new DefaultEditDomain(this);
		// ISelectionProvider is registered automatically in init() method.
		// I forwards selection from selection providers of inner editors.
	}
			
	// Initializes editor with input.
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		try {
			doLoad();
		}
		catch(IOException ex) {
			throw new PartInitException("Unable to load input.", ex);
		}
		
		setPartName(getEditorInput().getName());
		site.getPage().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}
	
	// Creates editor pages. Called after init.
	@Override
	protected void createPages() {
		try {
			addPage(new FeatureTreeEditor(featureModel, editDomain), getEditorInput());
			setPageText(0, "Feature Tree");
			addPage(new ConstraintsEditor(featureModel), getEditorInput());
			setPageText(1, "Constraints");
		} 
		catch (PartInitException ex) {
			ex.printStackTrace();
		}
	}
	
	// Loads specified input.
	private void doLoad() throws IOException {
		@SuppressWarnings("unused")
		FeatureModelPackage fmPackage = FeatureModelPackage.eINSTANCE; // For package registration.
		ResourceSet resourceSet = new ResourceSetImpl();
		String path = EditorUtil.getEditorInputFileName(getEditorInput());
		Resource resource = resourceSet.createResource(URI.createURI(path));
		resource.load(null);
		featureModel = (FeatureModel) resource.getContents().get(0);	
	}

	// Saves model.
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			featureModel.eResource().save(null);
			for(int i = 0; i < getPageCount(); i++)
				getEditor(i).doSave(monitor);
			editDomain.getCommandStack().markSaveLocation();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	// =====================================================================
	//  IAdaptable
	// =====================================================================
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class type) {
		// Provides outline view content page.
		if(type == IContentOutlinePage.class) {
			if(outlinePage == null)
				outlinePage = new FeatureModelContentOutlinePage(featureModel);
			return outlinePage;
		}
		if(type == FeatureModel.class)
			return featureModel;
		return super.getAdapter(type);
	}
	
	// =====================================================================
	//  ISelectionListener
	// =====================================================================
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(outlinePage == null)
			return;
				
		// Forward selection to the content outline view when it comes from the feature model view 
		// or from feature tree editor.
		String id = part.getClass().getName(); 		
		if(id.equals("cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView")) 
			outlinePage.setSelection(selection);
		else if(id.equals("cz.jpikl.yafmt.editors.featuremodel.editor.FeatureModelEditor")) {
			outlinePage.setSelection(FeatureTreeEditor.unwrapSelection(selection));
		}
	}
		
}
