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
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutProvider;

public class FeatureModelLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    protected Command getCreateCommand(CreateRequest request) {
        LayoutProvider layoutProvider = (LayoutProvider) getHost();
        FeatureModel featureModel = (FeatureModel) getHost().getModel();
        Feature feature = (Feature) request.getNewObject();
        Point location = request.getLocation();
        return new AddFeatureCommand(layoutProvider, featureModel, feature, location);
    }
    
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        LayoutProvider layoutProvider = (LayoutProvider) getHost();
        Object model = child.getModel();
        
        if(model instanceof Group){
            Dimension sizeDelta = request.getSizeDelta();
            if((sizeDelta.width != 0) || (sizeDelta.height != 0))
                return null;
            return new MoveGroupCommand(layoutProvider, (Group) model, (Rectangle) constraint);
        }
        
        if(model instanceof Feature)
            return new MoveResizeFeatureCommand(layoutProvider, (Feature) model, (Rectangle) constraint);

        return null;
    }

}
