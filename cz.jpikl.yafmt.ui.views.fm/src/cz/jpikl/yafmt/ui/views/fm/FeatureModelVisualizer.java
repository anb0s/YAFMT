package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.util.SWTUtil;
import cz.jpikl.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.GroupFilter;
import cz.jpikl.yafmt.ui.views.fm.graph.DecoratableGraphViewer;
import cz.jpikl.yafmt.ui.views.fm.graph.LayoutAlgorithmAnimator;
import cz.jpikl.yafmt.ui.views.fm.settings.ISettingsListener;
import cz.jpikl.yafmt.ui.views.fm.settings.Settings;

public class FeatureModelVisualizer extends ViewPart implements ISelectionListener,
                                                                IPartListener,
                                                                ISettingsListener,
                                                                IContributedContentsView {

    public static final String ID = "cz.jpikl.yafmt.ui.views.fm";
    private static final int CONNECTION_LENGHT = 200;

    private IWorkbenchPart sourcePart;
    private FeatureModel featureModel;
    private FeatureModelAdapter featureModelAdapter;

    private Settings settings;
    private ConstraintCache constraintCache;
    private int treeHeight; // Height of the current feature model tree.

    private DecoratableGraphViewer viewer;
    private DistanceFilter distanceFilter;
    private GroupFilter groupFilter;
    private ConstraintFilter constraintFilter;
    private ISelection currentSelection; // Viewer may not contain all selected elements, so we have to remember them.

    // ===========================================================================
    //  Basic initialization and dispose operations
    // ===========================================================================

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        constraintCache = new ConstraintCache();
        treeHeight = 1;
        currentSelection = StructuredSelection.EMPTY;
        settings = new Settings();
        settings.addSettingsListener(this);
        settings.init(FeatureModelVisualizerPlugin.getDefault().getDialogSettings());

        site.getPage().addPartListener(this);
        site.getPage().addSelectionListener(this);
    }

    @Override
    public void dispose() {
        settings.save(FeatureModelVisualizerPlugin.getDefault().getDialogSettings());
        settings.removeSettingsListener(this);
        setFeatureModel(null);

        getSite().getPage().removeSelectionListener(this);
        getSite().getPage().removePartListener(this);
        getSite().setSelectionProvider(null);

        super.dispose();
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    // ===========================================================================
    //  Viewer and control creation 
    // ===========================================================================

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        createGraphViewerControl(parent);
        settings.createControl(parent);

        // Try to load active editor input.
        setSourcePart(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());

        distanceFilter.update(StructuredSelection.EMPTY, featureModel);
        groupFilter.update(StructuredSelection.EMPTY);
        constraintFilter.update(StructuredSelection.EMPTY, featureModel);

        viewer.refresh();
        viewer.applyLayout();

        parent.addControlListener(new ControlAdapter() {
            @Override
            public void controlResized(ControlEvent event) {
                if(!settings.isFixedSize()) {
                    resizeGraphView();
                    viewer.applyLayout();
                }
            }
        });
    }

    private void createGraphViewerControl(Composite parent) {
        distanceFilter = new DistanceFilter(constraintCache, settings.getVisibleDistance());
        groupFilter = new GroupFilter(settings.areGroupsVisible());
        constraintFilter = new ConstraintFilter(constraintCache, settings.areConstraintsVisible());

        // Do not enable hash lookup. It causes invalidation of current selection during graph refresh.
        viewer = new DecoratableGraphViewer(parent, ZestStyles.NONE);
        viewer.setContentProvider(new FeatureModelContentProvider());
        viewer.setLabelProvider(new FeatureModelStyleProvider(viewer, constraintCache));
        viewer.setLayoutAlgorithm(new LayoutAlgorithmAnimator(viewer, settings, new FeatureModelLayoutAlgorithm()));
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        viewer.setNodeStyle(settings.isAnimationEnabled() ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
        viewer.setFilters(new ViewerFilter[] { distanceFilter, groupFilter, constraintFilter });

        SWTUtil.enableAntialiasing(viewer.getControl()); // Enable antialiasing on Windows.
        getSite().setSelectionProvider(viewer);
    }

    // ===========================================================================
    //  Settings change callbacks
    // ===========================================================================

    @Override
    public void groupsVisibilityChanged(boolean groupsVisible) {
        groupFilter.setEnabled(groupsVisible);
        groupFilter.update(viewer.getSelection());
        viewer.refresh();
        viewer.applyLayout();
    }

    @Override
    public void constraintsVisibilityChanged(boolean constraintsVisible) {
        constraintFilter.setEnabled(constraintsVisible);
        constraintFilter.update(viewer.getSelection(), featureModel);
        viewer.refresh();
        viewer.applyLayout();
    }

    @Override
    public void animationStateChanged(boolean animationEnabled, int animationTime) {
        viewer.setInput(null); // Style can be only changed when input is not set.
        viewer.setNodeStyle(animationEnabled ? ZestStyles.NONE : ZestStyles.NODES_NO_ANIMATION);
        viewer.setInput(featureModel);
    }

    @Override
    public void lockedStateChanged(boolean viewLocked) {
    }

    @Override
    public void visibleDistanceChanged(int visibleDistance) {
        distanceFilter.setDistance(visibleDistance);
        distanceFilter.update(viewer.getSelection(), featureModel);
        viewer.refresh();
        viewer.applyLayout();
    }

    @Override
    public void viewSizeChanged(boolean fixedSize, int sizeMultiplier) {
        resizeGraphView();
        viewer.applyLayout();
    }

    // ===========================================================================
    //  Input initialization
    // ===========================================================================

    private void setSourcePart(IWorkbenchPart part) {
        if(part == sourcePart)
            return;

        FeatureModel newFeatureModel = (FeatureModel) part.getAdapter(FeatureModel.class);
        if(newFeatureModel == null)
            return;

        sourcePart = part;
        setFeatureModel(newFeatureModel);
    }

    private void setFeatureModel(FeatureModel newFeatureModel) {
        if(featureModel == newFeatureModel)
            return;

        if(featureModel != null) {
            featureModel.eAdapters().remove(featureModelAdapter);
            constraintCache.dispose();
        }

        featureModel = newFeatureModel;
        if(!viewer.getControl().isDisposed()) {
            viewer.setInput(featureModel);
            currentSelection = StructuredSelection.EMPTY;
            recomputeTreeHeight();
            resizeGraphView();
        }

        if(featureModel != null) {
            if(featureModelAdapter == null)
                featureModelAdapter = new FeatureModelAdapter();
            featureModel.eAdapters().add(featureModelAdapter);
            constraintCache.setFeatureModel(newFeatureModel);
        }
    }

    private void recomputeTreeHeight() {
        treeHeight = FeatureModelUtil.getTreeHeight(featureModel);
    }

    private void resizeGraphView() {
        if(settings.isFixedSize()) {
            int size = 2 * treeHeight * CONNECTION_LENGHT * settings.getSizeMultiplier();
            viewer.getGraphControl().setPreferredSize(size, size);
        }
        else {
            viewer.getGraphControl().setPreferredSize(-1, -1);
        }
    }

    // ===========================================================================
    //  Event handling
    // ===========================================================================

    @Override
    public IWorkbenchPart getContributingPart() {
        // This make the property sheet view working.
        // PropertySheet takes via this method the workbench part which content should display.
        return sourcePart;
    }

    private ISelection unwrapSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return null;
        if(selection.isEmpty())
            return selection;

        Object[] elements = ((IStructuredSelection) selection).toArray();
        if(!isValidSelectionElement(elements[0]))
            return null;

        // Replace selections by features if possible.
        for(int i = 0; i < elements.length; i++) {
            Object element = elements[i];
            if(element instanceof Selection) {
                Feature feature = ((Selection) element).getFeature();
                // Selection elements can't be null.
                if(feature != null)
                    elements[i] = feature;
            }
        }

        return new StructuredSelection(elements);
    }

    private boolean isValidSelectionElement(Object element) {
        return (element instanceof FeatureModel) ||
                (element instanceof Feature) ||
                (element instanceof Group) ||
                (element instanceof Constraint) ||
                (element instanceof Attribute) ||
                (element instanceof FeatureConfiguration) ||
                (element instanceof Selection) ||
                (element instanceof AttributeValue);
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        // Ignore invalid selections.
        IWorkbenchPart activePart = getSite().getPage().getActivePart();
        if((part != activePart) || (part == this) || (part instanceof PropertySheet))
            return;

        selection = unwrapSelection(selection);
        if(selection == null)
            return;

        setSourcePart(part);

        if(!currentSelection.equals(selection)) {
            currentSelection = selection; // Viewer may not contain all selected elements, so we have to remember them.

            if(!settings.isViewLocked()) {
                distanceFilter.update(selection, featureModel);
                groupFilter.update(selection);
                constraintFilter.update(selection, featureModel);
                ((FeatureModelStyleProvider) viewer.getLabelProvider()).refresh(selection);
                viewer.refresh();
                viewer.applyLayout();
            }

            viewer.setSelection(selection);
            if(settings.isViewLocked())
                viewer.moveViewportToSelection(selection); // Do not move viewport when layout animation is in progress!
        }
    }

    @Override
    public void partClosed(IWorkbenchPart part) {
        if(part == sourcePart) {
            sourcePart = null;
            setFeatureModel(null);
        }
    }

    @Override
    public void partActivated(IWorkbenchPart part) {
    }

    @Override
    public void partOpened(IWorkbenchPart part) {
    }

    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
    }

    @Override
    public void partDeactivated(IWorkbenchPart part) {
    }

    // ===========================================================================
    //  Model changes handling
    // ===========================================================================

    class FeatureModelAdapter extends EContentAdapter {

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            switch(notification.getEventType()) {
                case Notification.ADD:
                case Notification.ADD_MANY:
                case Notification.REMOVE:
                case Notification.REMOVE_MANY:
                case Notification.SET:
                    constraintCache.invalidate();
                    recomputeTreeHeight();
                    resizeGraphView();
                    viewer.refresh();
                    viewer.applyLayout();
                    break;
            }
        }

    }

}
