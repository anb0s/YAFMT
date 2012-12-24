package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.io.IOException;
import java.util.EventObject;
import java.util.Iterator;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbenchPart;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout;
import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelEditPart;
import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelPartFactory;
import cz.jpikl.yafmt.editors.featuremodel.utils.CreationAndDirectEditTool;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

public class FeatureModelEditor extends GraphicalEditorWithFlyoutPalette implements ModelLayoutStore, ISelectionListener {

	private FeatureModel featureModel;
	private ModelLayout modelLayout;
	
	public FeatureModelEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	public FeatureModel getFeatureModel() {
		return featureModel;
	}
	
	// Called when editor is created.
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new FeatureModelPartFactory(this));
		viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
		viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
		viewer.setContextMenu(new FeatureModelEditorContextMenuProvider(viewer, getActionRegistry()));
		getSite().setSelectionProvider(getGraphicalViewer());
		getSite().getPage().addSelectionListener(this);
	}
	
	// Called when editor is initialized with an input.
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(doLoad());
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		getSite().setSelectionProvider(null);
		super.dispose();
	}
	
	// Creates and returns palette
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
		CreationToolEntry featureCreationToolEntry = new CombinedTemplateCreationEntry("Feature", "Add a new feature.", featureFactory, null, null);
		featureCreationToolEntry.setToolClass(CreationAndDirectEditTool.class);
		elements.add(featureCreationToolEntry);
		elements.add(new ConnectionCreationToolEntry("Connection", "Create a connection.", null, null, null));
		
		PaletteRoot root = new PaletteRoot();
		root.setDefaultEntry(selection);
		root.add(tools);
		root.add(elements);
		return root;
	}
	
	// Allows dragging features from palette to the canvas.
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}
	
	// Loads specified input.
	private FeatureModel doLoad() {
		IEditorInput input = getEditorInput();
		String path = null;
		
		if(input instanceof IFileEditorInput) {
			path = ((IFileEditorInput) input).getFile().getFullPath().toString();
		}
		else if(input instanceof IURIEditorInput) {
			try {
				IFileStore store = EFS.getStore(((IURIEditorInput) input).getURI());
				path = "file://" + store.toLocalFile(EFS.NONE, null).getAbsolutePath();
			}
			catch(CoreException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
				
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
		
		// For package registration.
		@SuppressWarnings("unused")
		FeatureModelPackage fmPack = FeatureModelPackage.eINSTANCE;
		@SuppressWarnings("unused")
		ModelLayoutPackage mlPack = ModelLayoutPackage.eINSTANCE;
				
		try {
			resource = resourceSet.createResource(URI.createURI(path));
			resource.load(null);
			featureModel = (FeatureModel) resource.getContents().get(0);	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
		try {
			resource = resourceSet.createResource(URI.createURI(path + ".layout"));
			resource.load(null);
			modelLayout = (ModelLayout) resource.getContents().get(0);
		}
		catch(IOException ex) {
			modelLayout = ModelLayoutFactory.eINSTANCE.createModelLayout();
			resource.getContents().add(modelLayout);
		}
		
		setPartName(input.getName());
		return featureModel;
	}

	// Saves model.
	@Override
	public void doSave(IProgressMonitor monitor) {
		// Remove layout data of all objects which were removed from the feature model.
		Iterator<ObjectLayout> it = modelLayout.getObjectLayouts().iterator();
		while(it.hasNext()) {
			if(it.next().getObject().eResource() == null)
				it.remove();
		}
		
		try {
			featureModel.eResource().save(null);
			modelLayout.eResource().save(null);
			getCommandStack().markSaveLocation();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// Makes the editor dirty whenever is a command executed (allows save action).
	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(PROP_DIRTY);
		super.commandStackChanged(event);
	}
	
	// Called when selection changes in feature model view.
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(part.getClass().getName() == "cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView") {
			FeatureModelEditPart rootPart = (FeatureModelEditPart) getGraphicalViewer().getContents();
			EditPart selectedPart = rootPart.getEditPartForModel(((IStructuredSelection) selection).getFirstElement());
			if(selectedPart != null)
				getGraphicalViewer().select(selectedPart);
		}
		super.selectionChanged(part, selection);
	}

	// Stores model element layout (ModelLayoutStore interface).
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

	// Gets model element layout (ModelLayoutStore interface).
	@Override
	public EObject getObjectLayout(EObject object) {
		for(ObjectLayout objectLayout: modelLayout.getObjectLayouts()) {
			if(objectLayout.getObject() == object)
				return objectLayout.getLayoutData();
		}
		return null;
	}
	

}
