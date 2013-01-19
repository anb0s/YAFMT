package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayout;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutPackage;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectLayout;
import cz.jpikl.yafmt.editors.featuremodel.parts.FeatureModelEditPartFactory;
import cz.jpikl.yafmt.editors.featuremodel.utils.CreationAndDirectEditTool;
import cz.jpikl.yafmt.editors.featuremodel.utils.EditorUtil;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;

public class FeatureTreeEditor extends GraphicalEditorWithFlyoutPalette implements ModelLayoutStore,
                                                                                   ISelectionListener {

    private FeatureModel featureModel;
    private ModelLayout modelLayout;

    public FeatureTreeEditor(FeatureModel featureModel) {
        this.featureModel = featureModel;
        setEditDomain(new DefaultEditDomain(this));
    }

    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setEditPartFactory(new FeatureModelEditPartFactory(this));
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
        viewer.addDropTargetListener(new TemplateTransferDropTargetListener(viewer));
        viewer.setContextMenu(new FeatureTreeEditorContextMenuProvider(viewer, getActionRegistry()));
        getSite().getPage().addSelectionListener(this);
        // Selection provider is registered automatically in init() method
    }

    @Override
    protected void initializeGraphicalViewer() {
        super.initializeGraphicalViewer();
        doLoad();
        getGraphicalViewer().setContents(featureModel);
    }

    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        super.dispose();
    }

    @Override
    public void setFocus() {
        getGraphicalControl().setFocus();
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

    void doLoad() {
        @SuppressWarnings("unused")
        ModelLayoutPackage mlPackage = ModelLayoutPackage.eINSTANCE; // For package registration.
        ResourceSet resourceSet = featureModel.eResource().getResourceSet();
        String path = EditorUtil.getEditorInputFileName(getEditorInput()) + ".layout";
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));

        try {
            resource.load(null);
            modelLayout = (ModelLayout) resource.getContents().get(0);
        }
        catch(IOException ex) {
            modelLayout = ModelLayoutFactory.eINSTANCE.createModelLayout();
            resource.getContents().add(modelLayout);
        }
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        // Remove layout data of all objects which were removed from the feature model.
        Iterator<ObjectLayout> it = modelLayout.getObjectLayouts().iterator();
        while(it.hasNext()) {
            if(it.next().getObject().eResource() == null)
                it.remove();
        }

        try {
            modelLayout.eResource().save(null);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        
        getCommandStack().markSaveLocation();
    }

 // Makes the editor dirty when a command is executed (allows save action).
    @Override
    public void commandStackChanged(EventObject event) {
        firePropertyChange(PROP_DIRTY);
        super.commandStackChanged(event);
    }

    // Unwraps edit parts selection to model elements selection.
    @SuppressWarnings("unchecked")
    public static ISelection unwrapSelection(ISelection selection) {
        if((selection == null) || !(((IStructuredSelection) selection).getFirstElement() instanceof EditPart))
            return selection;

        List<Object> objects = new ArrayList<Object>();
        Iterator<Object> it = ((IStructuredSelection) selection).iterator();
        while(it.hasNext()) {
            Object object = ((EditPart) it.next()).getModel();
            if(object instanceof Feature)
                objects.add(object);
        }

        return new StructuredSelection(objects);
    }

    // Wraps model elements selection to edit parts selection.
    @SuppressWarnings("unchecked")
    private ISelection wrapSelection(ISelection selection) {
        if(selection == null)
            return null;

        List<Object> objects = new ArrayList<Object>();
        Iterator<Object> it = ((IStructuredSelection) selection).iterator();
        while(it.hasNext()) {
            Object object = getGraphicalViewer().getEditPartRegistry().get(it.next());
            if(object != null)
                objects.add(object);
        }

        return new StructuredSelection(objects);
    }

    // =====================================================================
    //  ISelectionListener
    // =====================================================================

    // Called when selection changes in feature model view or outline view.
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        String id = part.getClass().getName();

        if((id.equals("cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView")) ||
           (id.equals("org.eclipse.ui.views.contentoutline.ContentOutline"))) {
            // Wraps model elements to edit parts
            ISelection wrappedSelection = wrapSelection(selection);
            // Select edit parts
            getGraphicalViewer().setSelection(wrappedSelection);
            // Get first selected edit part
            EditPart selectedPart = (EditPart) ((IStructuredSelection) wrappedSelection).getFirstElement();

            if(selectedPart != null) {
                // Zoom to the selected edit part
                Viewport vp = (Viewport)((FreeformGraphicalRootEditPart) getGraphicalViewer().getRootEditPart()).getFigure();
                IFigure figure = ((GraphicalEditPart) selectedPart).getFigure();
                Point p = figure.getBounds().getCenter();
                vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);

                // Forward selection to the property sheet view (because feature model view does not provide properties itself)
                PropertySheet properySheet = (PropertySheet) getSite().getPage().findView("org.eclipse.ui.views.PropertySheet");
                if(properySheet != null) {
                    properySheet.partActivated(this); // fake editor activation
                    properySheet.selectionChanged(this, wrappedSelection);//new StructuredSelection(selectedPart));
                }
            }
        }

        super.selectionChanged(part, selection);
    }

    // =====================================================================
    //  ModelLayoutStore
    // =====================================================================

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
