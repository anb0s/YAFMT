package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.IFileEditorInput;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout;
import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelPartFactory;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

public class FeatureModelEditor extends GraphicalEditorWithFlyoutPalette implements ModelLayoutStore {

	private FeatureModel featureModel;
	private ModelLayout modelLayout;
	
	public FeatureModelEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new FeatureModelPartFactory(this));
		getGraphicalViewer().setRootEditPart(new FreeformGraphicalRootEditPart());
		getGraphicalViewer().addDropTargetListener(new TemplateTransferDropTargetListener(getGraphicalViewer()));
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(doLoad());
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		PaletteToolbar tools = new PaletteToolbar("Tools");
		ToolEntry selection = new PanningSelectionToolEntry();
		tools.add(selection);
		tools.add(new MarqueeToolEntry());
		
		SimpleFactory featureFactory = new SimpleFactory(Feature.class) {
			@Override
			public Object getNewObject() {
				Feature feature = FeatureModelFactory.eINSTANCE.createFeature();
				feature.setName("New feature");
				return feature;
			}
		};
				
		PaletteDrawer elements = new PaletteDrawer("Elements");
		elements.add(new CombinedTemplateCreationEntry("Feature", "Add a new feature.", featureFactory, null, null));
		elements.add(new ConnectionCreationToolEntry("Connection", "Create a connection.", null, null, null));
		
		PaletteRoot root = new PaletteRoot();
		root.setDefaultEntry(selection);
		root.add(tools);
		root.add(elements);
		return root;
	}
	
	
	
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}
	
	private FeatureModel doLoad() {
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
		
		// For package registration.
		@SuppressWarnings("unused")
		FeatureModelPackage fmPack = FeatureModelPackage.eINSTANCE;
		@SuppressWarnings("unused")
		ModelLayoutPackage mlPack = ModelLayoutPackage.eINSTANCE;
				
		try {
			URI uri = URI.createURI(file.getFullPath().toString());
			resource = resourceSet.createResource(uri);
			resource.load(null);
			featureModel = (FeatureModel) resource.getContents().get(0);	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
		try {
			URI uri = URI.createURI(file.getFullPath().toString() + ".layout");
			resource = resourceSet.createResource(uri);
			resource.load(null);
			modelLayout = (ModelLayout) resource.getContents().get(0);
		}
		catch(IOException ex) {
			modelLayout = ModelLayoutFactory.eINSTANCE.createModelLayout();
			resource.getContents().add(modelLayout);
		}
		
		return featureModel;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Remove layout data of all objects which were removed from feature model.
		Iterator<ObjectLayout> it = modelLayout.getObjectLayouts().iterator();
		while(it.hasNext()) {
			if(it.next().getObject().eResource() == null)
				it.remove();
		}
		
		try {
			featureModel.eResource().save(null);
			modelLayout.eResource().save(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void setObjectLayout(EObject object, EObject layoutData) {		
		for(ObjectLayout objectLayout: modelLayout.getObjectLayouts()) {
			if(objectLayout.getObject() == object) {
				objectLayout.setLayoutData(layoutData);
				return;
			}
		}
		
		ObjectLayout objectLayout = ModelLayoutFactory.eINSTANCE.createObjectLayout();
		objectLayout.setObject(object);
		objectLayout.setLayoutData(layoutData);
		modelLayout.getObjectLayouts().add(objectLayout);
	}

	@Override
	public EObject getObjectLayout(EObject object) {
		for(ObjectLayout objectLayout: modelLayout.getObjectLayouts()) {
			if(objectLayout.getObject() == object)
				return objectLayout.getLayoutData();
		}
		return null;
	}
	
	@Override
	public void dispose() {
		doSave(null);
		super.dispose();
	}

}
