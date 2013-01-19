package cz.jpikl.yafmt.views.featuremodel.view;

import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import cz.jpikl.yafmt.editors.featuremodel.editor.FeatureModelEditor;
import cz.jpikl.yafmt.editors.featuremodel.editor.FeatureTreeEditor;
import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;
import cz.jpikl.yafmt.models.utils.ModelAdapter;
import cz.jpikl.yafmt.models.utils.ModelListener;

public class FeatureModelView extends ViewPart implements ISelectionListener, ModelListener, IPartListener {

    public static final String ID = "cz.jpikl.yafmt.views.featuremodel.views.FeatureModelView";

    private GraphViewer viewer;
    private ModelAdapter modelAdapter = new ModelAdapter(this);
    private VisibleConstraintsFilter constraintsFilter = new VisibleConstraintsFilter();
    private IWorkbenchPart activePart;

    @Override
    public void createPartControl(Composite parent) {
        viewer = new GraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelLabelProvider());
        viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
        viewer.setNodeStyle(ZestStyles.NODES_NO_ANIMATION); // Disable graph animation. Animation duration cannot be set (no API).
        viewer.setFilters(new ViewerFilter[] { constraintsFilter });

        getSite().setSelectionProvider(viewer);
        getSite().getPage().addSelectionListener(this);
        getSite().getPage().addPartListener(this);

        // Load input when editor is already opened.
        activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        setModelFromEditor(activePart);
    }

    @Override
    public void dispose() {
        setModel(null);
        getSite().getPage().removePartListener(this);
        getSite().getPage().removeSelectionListener(this);
        getSite().setSelectionProvider(null);
        super.dispose();
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    private void setModelFromEditor(IWorkbenchPart part) {
        if(part instanceof IEditorPart) {
            FeatureModel model = (FeatureModel) part.getAdapter(FeatureModel.class);
            setModel(model);
        }
    }

    private void setModel(FeatureModel model) {
        // Update feature model only when changed.
        FeatureModel prevModel = getModel();
        if(prevModel != null)
            modelAdapter.disconnectFromAll();

        // IllegalStateException is thrown when setting input to disposed control
        if(!viewer.getControl().isDisposed())
            viewer.setInput(model);

        if(model != null) {
            modelAdapter.connectToAllContents(model);
            resizeViewArea();
            viewer.applyLayout();
        }
    }

    private FeatureModel getModel() {
        return (FeatureModel) viewer.getInput();
    }

    // Sets viewport size accordingly to tree height.
    private void resizeViewArea() {
        if(getModel() != null) {
            int height = findFeatureTreeHeight(getModel().getRootFeature(), 1);
            viewer.getGraphControl().setPreferredSize(height * 100, height * 100);
        }
    }

    private int findFeatureTreeHeight(Feature root, int currentHeight) {
        int foundHeight = currentHeight;
        for(Feature feature: root.getChildren()) {
            int height = findFeatureTreeHeight(feature, currentHeight + 1);
            if(height > foundHeight)
                foundHeight = height;
        }
        return foundHeight;
    }

    // Center viewport to selected object.
    private void moveViewportToSelection(Object selectedObject) {
        GraphItem item = viewer.findGraphItem(selectedObject);
        if(item instanceof GraphNode) {
            Point p = ((GraphNode) item).getLocation();
            Viewport vp = viewer.getGraphControl().getViewport();
            vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
        }
    }

    // ======================================================================
    //  ISelectionListener
    // ======================================================================

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if(activePart != part)
            return;

        if((part instanceof FeatureModelEditor) || (part instanceof ContentOutline) || (part == this) ||
            part.getClass().getName().equals("cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationEditor")) {
            
            // Unwrap selected edit parts to model elements
            Object firstSelection = ((IStructuredSelection) selection).getFirstElement();
            if(firstSelection instanceof EditPart) {
                selection = FeatureTreeEditor.unwrapSelection(selection);
                firstSelection = ((IStructuredSelection) selection).getFirstElement();
            }

            constraintsFilter.selectionChanged(selection);
            viewer.refresh();
            viewer.applyLayout();
            if(part != this)
                viewer.setSelection(selection);
            moveViewportToSelection(firstSelection);
        }
    }

    // ======================================================================
    //  ModelListener
    // ======================================================================

    @Override
    public void modelChanged(Notification notification) {
        viewer.refresh();

        switch(notification.getEventType()) {
            case Notification.SET:
                if(notification.getFeatureID(Constraint.class) != FeatureModelPackage.CONSTRAINT__VALUE)
                    break;

            case Notification.ADD:
            case Notification.ADD_MANY:
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                modelAdapter.disconnectFromAll();
                modelAdapter.connect(getModel());
                modelAdapter.connectToAllContents(getModel());
                // Do not connect to the oprhaned features since they are not displayed
                resizeViewArea();
                viewer.applyLayout();
                break;
        }

    }

    // ======================================================================
    //  IPartListener
    // ======================================================================

    @Override
    public void partActivated(IWorkbenchPart part) {
        activePart = part;
        setModelFromEditor(part);
    }

    @Override
    public void partClosed(IWorkbenchPart part) {
        activePart = null;
        if(part instanceof FeatureModelEditor)
            setModel(null);
    }

    @Override
    public void partOpened(IWorkbenchPart part) {
    }

    @Override
    public void partDeactivated(IWorkbenchPart part) {
    }

    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
    }

}
