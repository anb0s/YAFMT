package cz.jpikl.yafmt.ui.editors.fc.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.ui.editors.fc.figures.AttributeValueFigure;
import cz.jpikl.yafmt.ui.editors.fc.policies.AttributeValueSelectionPolicy;


public class AttributeValueEditPart extends AbstractGraphicalEditPart {

    private AttributeValue attributeValue;
    private AttributeValueAdapter attributeValueAdapter;

    public AttributeValueEditPart(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
        this.attributeValueAdapter = new AttributeValueAdapter();
        setModel(attributeValue);
    }

    // ===================================================================
    //  Initialization
    // ===================================================================
    
    @Override
    public void activate() {
        super.activate();
        attributeValue.eAdapters().add(attributeValueAdapter);
    }
    
    @Override
    public void deactivate() {
        attributeValue.eAdapters().remove(attributeValueAdapter);
        super.deactivate();
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================
    
    @Override
    protected IFigure createFigure() {
        return new AttributeValueFigure(attributeValue);
    }
    
    @Override
    public AttributeValueFigure getFigure() {
        return (AttributeValueFigure) super.getFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        getFigure().refresh();
    }

    // ===================================================================
    //  Policies
    // ===================================================================
    
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new AttributeValueSelectionPolicy());
    }
    
    // ===================================================================
    //  Events
    // ===================================================================
        
    private class AttributeValueAdapter extends AdapterImpl {
        
        @Override
        public void notifyChanged(Notification msg) {
            refreshVisuals(); // Only value change notification can occurs.
        }
        
    }
    
}
