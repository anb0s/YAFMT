package cz.jpikl.yafmt.ui.editors.fm.parts;

import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL__NAME;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL__ORPHANS;
import static cz.jpikl.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL__ROOT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.validation.fm.FeatureModelValidator;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelLayoutPolicy;
import cz.jpikl.yafmt.ui.validation.IProblemManager;

public class FeatureModelEditPart extends AbstractGraphicalEditPart {

    // Enabling constraint markers may slow down editor when 
    // editing large feature models with many constraints.
    // Each time when model modification is performed, constraint cache
    // and all affected feature figures must be refreshed.
    private static final boolean CONSTRAINT_MARKERS_ENABLED = true;

    private FeatureModel featureModel;
    private LayoutData layoutData;
    private IProblemManager problemManager;
    private ConstraintCache constraintCache;
    private Adapter featureModelAdapter;
    private Adapter layoutDataAdapter;
    
    public FeatureModelEditPart(FeatureModel featureModel, LayoutData layoutData, IProblemManager problemManager) {
        this.featureModel = featureModel;
        this.layoutData = layoutData;
        this.problemManager = problemManager;
        this.featureModelAdapter = new FeatureModelAdapter();
        this.layoutDataAdapter = new LayoutDataAdapter();
        setModel(featureModel);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        // Adapters must be registered before children parts activation!
        featureModel.eAdapters().add(featureModelAdapter);
        layoutData.eAdapters().add(layoutDataAdapter);
        super.activate();
        revalidateModel();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        refreshFeatureFiguresConstraintMarker();
    }

    @Override
    public void deactivate() {
        problemManager.clearProblems(featureModel);
        featureModel.eAdapters().remove(featureModelAdapter);
        layoutData.eAdapters().remove(layoutDataAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================

    @Override
    protected IFigure createFigure() {
        return new FeatureModelFigure();
    }

    @Override
    protected void refreshVisuals() {
        // Enable antialiasing for connection layer.
        // Antialiasing for other layers is enabled in FeatureModelFigure.
        ((ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER)).setAntialias(SWT.ON);
    }
    
    private void refreshFeatureFiguresOrphanedState(Feature feature) {
        GraphicalEditPart editPart = getEditPartForObject(feature);
        if(editPart == null)
            return;

        boolean orphaned = feature.isOrphan();
        ((FeatureEditPart) editPart).getFigure().setOrphaned(orphaned);

        TreeIterator<EObject> it = feature.eAllContents();
        while(it.hasNext()) {
            Object object = it.next();
            if(object instanceof Feature) {
                editPart = getEditPartForObject(object);
                if(editPart != null)
                    ((FeatureEditPart) editPart).getFigure().setOrphaned(orphaned);
            }
        }
    }

    private void refreshFeatureFiguresConstraintMarker() {
        if(!CONSTRAINT_MARKERS_ENABLED)
            return;
        
        // Reset state of currently marked figures.
        if(constraintCache == null)
            constraintCache = new ConstraintCache(featureModel);
        else
            setFeatureFiguresConstraintMarker(false);
         
        // Set state of newly marked figures.
        constraintCache.invalidate();
        setFeatureFiguresConstraintMarker(true);
    }
    
    private void setFeatureFiguresConstraintMarker(boolean constrained) {
        for(Feature feature: constraintCache.getFeaturesAffectedByConstraint()) {
            EditPart editPart = getEditPartForObject(feature);
            if(editPart != null)
                ((FeatureEditPart) editPart).getFigure().setConstrained(constrained);
        }
    }
    
    public void refreshGroupFigure(Group group) {
        GraphicalEditPart editPart = getEditPartForObject(group);
        if(editPart == null)
            return;
        
        GroupFigure figure = ((GroupEditPart) editPart).getFigure();
        figure.refresh();
        figure.repaint();
    }
    
    // ===================================================================
    //  Layout
    // ===================================================================
   
    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    private void layoutDataChanged(Object notifier) {
        if(!(notifier instanceof Map.Entry<?, ?>))
            return;

        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) notifier;
        Object object = entry.getKey();
        Object constraint = entry.getValue();

        GraphicalEditPart editPart = getEditPartForObject(object);
        if(editPart == null)
            return;
            
        setLayoutConstraint(editPart, editPart.getFigure(), constraint);
        
        // Update group figure when the group or one of its children features moved.
        if(object instanceof Group)
            refreshGroupFigure((Group) object);
        else if(object instanceof Feature)
            refreshGroupFigure(((Feature) object).getParentGroup());
    }
    
    // ===================================================================
    //  Model
    // ===================================================================
    
    private void revalidateModel() {
        problemManager.clearProblems(featureModel);
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!FeatureModelValidator.INSTANCE.validate(featureModel, diagnostic))
            problemManager.addProblems(diagnostic);
    }
    
    @Override
    protected List<Object> getModelChildren() {
        List<Object> modelChildren = new ArrayList<Object>();

        // Groups go before features. This order is used for rendering objects.
        TreeIterator<EObject> it = featureModel.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Group)
                modelChildren.add(object);
        }

        // Features go after groups.
        it = featureModel.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Feature)
                modelChildren.add(object);
        }

        return modelChildren;
    }
    
    // ===================================================================
    //  Children edit parts
    // ===================================================================
    
    private GraphicalEditPart getEditPartForObject(Object object) {
        return (GraphicalEditPart) getViewer().getEditPartRegistry().get(object);
    }

    private void addEditPartForObject(Object object) {
        // Create edit part only of it does not exist yet.
        if(getEditPartForObject(object) == null) {
            if(object instanceof Group) {
                // Groups go before features. This order is used for rendering objects.
                addChild(createChild(object), 0);
                // When ChangeRecorder does undo operation, it merge all changes, so previously 
                // deleted group can be added together with previously deleted features.
                Group group = (Group) object;
                for(Feature feature: group.getFeatures())
                    addEditPartForObject(feature);
            }
            if(object instanceof Feature) {
                // Features go after groups.
                addChild(createChild(object), getChildren().size());
                // Same case as mentioned above.
                Feature feature = (Feature) object;
                for(Feature child: feature.getFeatures())
                    addEditPartForObject(child);
                for(Group group: feature.getGroups())
                    addEditPartForObject(group);
            }
        }

        // Make sure that orphaned state of all added feature figures is refreshed.
        if(object instanceof Feature)
            refreshFeatureFiguresOrphanedState((Feature) object);
    }

    private void addEditPartsForObjects(Collection<?> objects) {
        for(Object object: objects)
            addEditPartForObject(object);
    }

    private void removeEditPartForObject(Object object) {
        // Ignore non-existing edit parts.
        EditPart editPart = getEditPartForObject(object);
        if(editPart == null)
            return;

        // Do not remove edit parts when they are still present in model.
        // This situation usually happens when feature parent was changed,
        // but feature is stil present in model.
        if(((EObject) object).eContainer() == null)
            removeChild(editPart);
    }

    private void removeEditPartsForObjects(Collection<?> objects) {
        for(Object object: objects)
            removeEditPartForObject(object);
    }
    
    // ===================================================================
    //  Policies
    // ===================================================================
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureModelLayoutPolicy());
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureModelEditPolicy());
    }
    
    // ===================================================================
    //  Events
    // ===================================================================
    
    class FeatureModelAdapter extends EContentAdapter {

        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);
            
            Object notifier = msg.getNotifier();
            if(notifier instanceof FeatureModel)
                notifyChangedFromFeatureModel(msg);
            else if((notifier instanceof Feature) || (notifier instanceof Group))
                notifyChangedFromOthers(msg);

            refreshFeatureFiguresConstraintMarker();
        }

        private void notifyChangedFromFeatureModel(Notification msg) {
            switch(msg.getFeatureID(FeatureModel.class)) {
                case FEATURE_MODEL__NAME:
                    revalidateModel();
                    break;
                
                case FEATURE_MODEL__ROOT:
                case FEATURE_MODEL__ORPHANS:
                    notifyChangedFromOthers(msg);
                    break;
            }
        }
        
        private void notifyChangedFromOthers(Notification msg) {
            // Features, groups or attributes are added or removed.
            switch(msg.getEventType()) {
                case Notification.ADD:
                    addEditPartForObject(msg.getNewValue());
                    break;

                case Notification.ADD_MANY:
                    addEditPartsForObjects((Collection<?>) msg.getNewValue());
                    break;

                case Notification.REMOVE:
                    removeEditPartForObject(msg.getOldValue());
                    break;

                case Notification.REMOVE_MANY:
                    removeEditPartsForObjects((Collection<?>) msg.getOldValue());
                    break;
            }
        }

    }

    class LayoutDataAdapter extends EContentAdapter {

        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);

            switch(msg.getEventType()) {
                case Notification.ADD:
                    layoutDataChanged(msg.getNewValue());
                    break;

                case Notification.SET:
                    layoutDataChanged(msg.getNotifier());
                    break;
            }
        }

    }

}
