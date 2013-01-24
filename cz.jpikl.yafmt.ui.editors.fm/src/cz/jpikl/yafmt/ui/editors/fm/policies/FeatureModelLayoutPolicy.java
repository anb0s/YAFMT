package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveResizeFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPart;

public class FeatureModelLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    protected Command getCreateCommand(CreateRequest request) {
        return null;
    }
    
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        FeatureModelEditPart featureModelEditPart = (FeatureModelEditPart) getHost();
        Feature feature = (Feature) child.getModel();
        Rectangle bounds = (Rectangle) constraint; 
        return new MoveResizeFeatureCommand(featureModelEditPart, feature, bounds);
    }

}
