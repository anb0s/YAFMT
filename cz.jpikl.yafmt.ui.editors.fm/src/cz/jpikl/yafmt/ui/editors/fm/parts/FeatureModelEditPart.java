package cz.jpikl.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.util.IModelListener;
import cz.jpikl.yafmt.model.util.ModelListenerAdapter;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureModelFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.policies.FeatureModelLayoutPolicy;

public class FeatureModelEditPart extends AbstractGraphicalEditPart implements IModelListener, IModelLayoutProvider {

    private FeatureModel featureModel;
    private ModelLayout modelLayout;
    private ModelListenerAdapter modelAdapter;
    
    public FeatureModelEditPart(FeatureModel featureModel, ModelLayout modelLayout) {
        this.featureModel = featureModel;
        this.modelLayout = modelLayout;
        this.modelAdapter = new ModelListenerAdapter(this);
        setModel(featureModel);
    }
    
    @Override
    public void activate() {
        super.activate();
        modelAdapter.connectContents(featureModel);
    }
    
    @Override
    public void deactivate() {
        modelAdapter.dispose();
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
            
    @Override
    public Rectangle getObjectBounds(EObject object) {
        return modelLayout.getMapping().get(object);
    }
    
    @Override
    public void setObjectBounds(EObject object, Rectangle bounds) {
        GraphicalEditPart editPart = getEditPartForObject(object);
        setLayoutConstraint(editPart, editPart.getFigure(), bounds);
        modelLayout.getMapping().put(object, bounds);
    }
    
    @Override
    public boolean refreshObjectBounds(EObject object) {
        Rectangle bounds = modelLayout.getMapping().get(object);
        if(bounds == null)
            return false;
        GraphicalEditPart editPart = getEditPartForObject(object);
        setLayoutConstraint(editPart, editPart.getFigure(), bounds);
        editPart.getFigure().repaint();
        return true;
    }
    
    private GraphicalEditPart getEditPartForObject(Object object) {
        return (GraphicalEditPart) getViewer().getEditPartRegistry().get(object);
    }

    private void addEditPartForObject(Object object) {
        if(getEditPartForObject(object) != null)
            return;
        
        // Groups go before features.
        // This order is used for rendering objects.
        if(object instanceof Group)
            addChild(createChild(object), 0);
        if(object instanceof Feature)
            addChild(createChild(object), getChildren().size());
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
        if(object instanceof Feature) {
            Feature feature = (Feature) object;
            if((feature.getParent() == null) && !featureModel.getOrphans().contains(object))
                removeChild(editPart);
        }
        else if(object instanceof Group) {
            if(((Group) object).getParent() == null)
                removeChild(editPart);
        }
    }
    
    private void removeEditPartsForObjects(Collection<Object> objects) {
        for(Object object: objects)
            removeEditPartForObject(object);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void modelChanged(Notification notification) {       
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
