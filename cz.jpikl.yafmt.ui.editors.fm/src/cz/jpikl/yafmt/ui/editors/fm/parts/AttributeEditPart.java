package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.SelectionRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.ui.editors.fm.directediting.AttributeTypeCellEditor;
import cz.jpikl.yafmt.ui.editors.fm.directediting.ComboDirectEditManager;
import cz.jpikl.yafmt.ui.editors.fm.directediting.DirectInputValidator;
import cz.jpikl.yafmt.ui.editors.fm.directediting.LabelDirectEditManager;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeDirectEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.AttributeEditPolicy;

public class AttributeEditPart extends AbstractGraphicalEditPart {

    private Attribute attribute;
    private Adapter attributeAdapter;

    public AttributeEditPart(Attribute attribute) {
        this.attribute = attribute;
        this.attributeAdapter = new AttributeAdapter();
        setModel(attribute);
    }

    @Override
    public void activate() {
        super.activate();
        attribute.eAdapters().add(attributeAdapter);
    }

    @Override
    public void deactivate() {
        attribute.eAdapters().remove(attributeAdapter);
        super.deactivate();
    }

    @Override
    protected IFigure createFigure() {
        return new AttributeFigure(attribute);
    }

    @Override
    protected void refreshVisuals() {
        ((AttributeFigure) getFigure()).refresh(); // Called when direct edit input is cancelled.
    }

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new AttributeEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AttributeDirectEditPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(REQ_OPEN.equals(request.getType())) {
            String name = attribute.getName();
            AttributeType type = attribute.getType();

            Label label = ((AttributeFigure) getFigure());
            Rectangle labelBounds = label.getBounds().getCopy();
            label.translateToAbsolute(labelBounds);
            int nameTextWidth = TextUtilities.INSTANCE.getStringExtents(name + ": ", label.getFont()).width;
            int typeTextX = labelBounds.x + nameTextWidth;
            int mouseX = ((SelectionRequest) request).getLocation().x;

            // Name direct edit
            if(mouseX <= typeTextX) {
                LabelDirectEditManager manager = new LabelDirectEditManager(this, label, name);
                manager.setValidator(new DirectInputValidator());
                manager.show();
            }
            // Type direct edit.
            else {
                Rectangle bounds = labelBounds.getCopy();
                bounds.x += nameTextWidth;
                bounds.y -= 2;
                bounds.width = 80;
                bounds.height += 2;
                ComboDirectEditManager manager = new ComboDirectEditManager(this, bounds, AttributeTypeCellEditor.class, type);
                manager.show();
            }
        }
    }

    private class AttributeAdapter extends AdapterImpl {

        @Override
        public void notifyChanged(Notification notification) {
            switch(notification.getFeatureID(Attribute.class)) {
                case FeatureModelPackage.ATTRIBUTE__NAME:
                case FeatureModelPackage.ATTRIBUTE__TYPE:
                    refreshVisuals();
            }
        }

    }

}
