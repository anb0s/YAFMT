package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.IFileEditorInput;

import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelPartFactory;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

public class FeatureModelEditor extends GraphicalEditorWithFlyoutPalette {

	public FeatureModelEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new FeatureModelPartFactory());
		getGraphicalViewer().setRootEditPart(new FreeformGraphicalRootEditPart());
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(doLoad());
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		return null;
	}
	
	private FeatureModel doLoad() {
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		URI uri = URI.createURI(file.getFullPath().toString());			
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		FeatureModelPackage pack = FeatureModelPackage.eINSTANCE; // For package registration.
		
		try {
			resource.load(null);
			setPartName(file.getName());
			return (FeatureModel) resource.getContents().get(0);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		FeatureModel model = (FeatureModel) getGraphicalViewer().getContents().getModel();
		
		try {
			model.eResource().save(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	

}
