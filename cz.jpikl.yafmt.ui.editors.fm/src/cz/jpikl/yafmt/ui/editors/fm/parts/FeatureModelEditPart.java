package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.jpikl.yafmt.ui.editors.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelLayoutPolicy;

public class FeatureModelEditPart extends AbstractGraphicalEditPart {

    private FeatureModel featureModel;
    private LayoutData layoutData;
    private Adapter featureModelAdapter;
    private Adapter layoutDataAdapter;
    
    public FeatureModelEditPart(FeatureModel featureModel, LayoutData layoutData) {
        this.featureModel = featureModel;
        this.layoutData = layoutData;
        this.featureModelAdapter = new FeatureModelAdapter();
        this.layoutDataAdapter = new LayoutDataAdapter(); 
        setModel(featureModel);
    }
    
    @Override
    public void activate() {
        featureModel.eAdapters().add(featureModelAdapter);
        layoutData.eAdapters().add(layoutDataAdapter);
        // Adapters MUST be registered BEFORE children parts activation!
        super.activate();
    }
    
    @Override
    public void deactivate() {
        featureModel.eAdapters().remove(featureModelAdapter);
        layoutData.eAdapters().remove(layoutDataAdapter);
        super.deactivate();
    }
    
    @Override
    protected List<Object> getModelChildren() {
        List<Object> modelChildren = new ArrayList<Object>();
        
        // Groups go before features.
        // This order is used for rendering objects.
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
    
    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureModelLayoutPolicy());
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureModelEditPolicy());
    }
    
    private GraphicalEditPart getEditPartForObject(Object object) {
        return (GraphicalEditPart) getViewer().getEditPartRegistry().get(object);
    }

    private void addEditPartForObject(Object object) {
        if(getEditPartForObject(object) == null) {
            if(object instanceof Group) {
                // Groups go before features.
                // This order is used for rendering objects.
                addChild(createChild(object), 0);
                // When ChangeRecorder does undo, it merge all changes, so previously deleted
                // group can be added together with previously deleted features.
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
        
        // Make sure that 'orphaned' state of figure of all added features is refreshed. 
        if(object instanceof Feature)
            refreshFeatureFiguresOrphanedState((Feature) object);
    }
    
    private void addEditPartsForObjects(Collection<?> objects) {
        for(Object object: objects)
            addEditPartForObject(object);
    }
    
    private void removeEditPartForObject(Object object) {
        EditPart editPart = getEditPartForObject(object);
        if(editPart == null)
            return;
            
        // Do not remove edit parts when they are still present in model.
        // This situation usually happens when feature parent was changed.
        if(object instanceof EObject) {
            if(((EObject) object).eContainer() == null)
                removeChild(editPart);
        }
    }
    
    private void removeEditPartsForObjects(Collection<?> objects) {
        for(Object object: objects)
            removeEditPartForObject(object);
    }
    
    private void refreshFeatureFiguresOrphanedState(Feature feature) {
        boolean orphaned = feature.isOrphan();
        GraphicalEditPart editPart = getEditPartForObject(feature);
        if(editPart == null)
            return;
        
        // Quit when state was not changed.
        if(!((FeatureFigure) editPart.getFigure()).setOrphaned(orphaned))
            return;
        
        TreeIterator<EObject> it = feature.eAllContents();
        while(it.hasNext()) {
            Object object = it.next();
            if(object instanceof Feature) {
                editPart = getEditPartForObject(object);
                if(editPart != null)
                    ((FeatureFigure) editPart.getFigure()).setOrphaned(orphaned);
            }
        }
    }
    
    private void updateLayoutConstraint(Object updateValue) {
        if(!(updateValue instanceof Map.Entry<?, ?>))
            return;
        
        Map.Entry<?, ?> entry = (Map.Entry<?, ?>) updateValue;
        Object object = entry.getKey();
        Object constraint = entry.getValue();
        
        GraphicalEditPart editPart = getEditPartForObject(object);        
        if(editPart != null) {
            setLayoutConstraint(editPart, editPart.getFigure(), constraint);
            // Update group figure shape when the group or one of its children features moved.
            if(object instanceof Group)
                updateGroupFigure((Group) object);
            else if(object instanceof Feature)
                updateGroupFigure(((Feature) object).getParentGroup());
        }
    }
    
    public void updateGroupFigure(Group group) {
        GraphicalEditPart editPart = getEditPartForObject(group);
        if(editPart != null) {
            GroupFigure figure = (GroupFigure) editPart.getFigure();
            figure.refresh();
            figure.repaint();
        }
    }

    class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification); // Superclass implementation must be called!
            
            switch(notification.getEventType()) {
                case Notification.ADD:
                    addEditPartForObject(notification.getNewValue());
                    break;
                    
                case Notification.ADD_MANY:
                    addEditPartsForObjects((Collection<?>) notification.getNewValue());
                    break;
                    
                case Notification.REMOVE:
                    removeEditPartForObject(notification.getOldValue());
                    break;
                    
                case Notification.REMOVE_MANY:
                    removeEditPartsForObjects((Collection<?>) notification.getOldValue());
                    break;
            }
            
        }
        
    }
        
    class LayoutDataAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification); // Superclass implementation must be called!
            
            switch (notification.getEventType()) {
                case Notification.ADD:
                    updateLayoutConstraint(notification.getNewValue());
                    break;
                
                case Notification.SET:
                    updateLayoutConstraint(notification.getNotifier());
                    break;
            }
        }
        
    }
        
}
