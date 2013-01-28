package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
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
    protected IFigure createFigure() {
        return new FeatureModelFigure();
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new FeatureModelLayoutPolicy());
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
        
        it = featureModel.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Feature)
                modelChildren.add(object);
        }
        
        return modelChildren;
    }

    public LayoutData getLayoutData() {
        return layoutData;
    }
    
    private GraphicalEditPart getEditPartForObject(Object object) {
        return (GraphicalEditPart) getViewer().getEditPartRegistry().get(object);
    }

    private void addEditPartForObject(Object object) {
        if(getEditPartForObject(object) != null)
            return;
        
        // Groups go before features.
        // This order is used for rendering objects.
        if(object instanceof Group) {
            addChild(createChild(object), 0);
            // When ChangeRecorder does undo, it merge all changes, so previously deleted
            // group can be added together with previously deleted features.
            Group group = (Group) object;
            for(Feature feature: group.getFeatures())
                addEditPartForObject(feature);
        }
        if(object instanceof Feature) {
            addChild(createChild(object), getChildren().size());
            // Same case as mentioned above.
            Feature feature = (Feature) object;
            for(Group group: feature.getGroups())
                addEditPartForObject(group);
        }
    }
    
    private void addEditPartsForObjects(Collection<Object> objects) {
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
    
    private void removeEditPartsForObjects(Collection<Object> objects) {
        for(Object object: objects)
            removeEditPartForObject(object);
    }

    class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        @SuppressWarnings("unchecked")
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            
            switch(notification.getEventType()) {
                case Notification.ADD:
                    addEditPartForObject(notification.getNewValue());
                    break;
                    
                case Notification.ADD_MANY:
                    addEditPartsForObjects((Collection<Object>) notification.getNewValue());
                    break;
                    
                case Notification.REMOVE:
                    removeEditPartForObject(notification.getOldValue());
                    break;
                    
                case Notification.REMOVE_MANY:
                    removeEditPartsForObjects((Collection<Object>) notification.getOldValue());
                    break;
            }
            
        }
        
    }
    
    class LayoutDataAdapter extends EContentAdapter {
                
        @SuppressWarnings("unchecked")
        private void updateLayoutConstraint(Object object) {
            if(!(object instanceof Map.Entry<?, ?>))
                return;
            
            Map.Entry<EObject, Rectangle> entry = (Map.Entry<EObject, Rectangle>) object;
            GraphicalEditPart editPart = getEditPartForObject(entry.getKey());
            if(editPart != null)
                setLayoutConstraint(editPart, editPart.getFigure(), entry.getValue());
        }
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            
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
