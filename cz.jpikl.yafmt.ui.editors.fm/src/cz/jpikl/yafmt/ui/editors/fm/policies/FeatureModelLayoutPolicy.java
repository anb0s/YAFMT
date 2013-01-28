package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveGroupCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveResizeFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPart;

public class FeatureModelLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    protected Command getCreateCommand(CreateRequest request) {
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        FeatureModel featureModel = (FeatureModel) getHost().getModel();
        Feature feature = (Feature) request.getNewObject();
        Point location = request.getLocation();
        return new AddFeatureCommand(layoutData, featureModel, feature, location);
    }
    
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        Object model = child.getModel();
        
        if(model instanceof Group){
            Dimension sizeDelta = request.getSizeDelta();
            if((sizeDelta.width != 0) || (sizeDelta.height != 0))
                return null;
            return new MoveGroupCommand(layoutData, (Group) model, (Rectangle) constraint);
        }
        
        if(model instanceof Feature)
            return new MoveResizeFeatureCommand(layoutData, (Feature) model, (Rectangle) constraint);

        return null;
    }

}
