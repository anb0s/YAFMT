package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveResizeFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;

public class FeatureModelLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    protected Command getCreateCommand(CreateRequest request) {
        IModelLayoutProvider layoutProvider = (IModelLayoutProvider) getHost();
        FeatureModel featureModel = (FeatureModel) getHost().getModel();
        Feature feature = (Feature) request.getNewObject();
        Point location = request.getLocation();
        return new AddFeatureCommand(layoutProvider, featureModel, feature, location);
    }
    
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        IModelLayoutProvider layoutProvider = (IModelLayoutProvider) getHost();
        Feature feature = (Feature) child.getModel();
        Rectangle bounds = (Rectangle) constraint; 
        return new MoveResizeFeatureCommand(layoutProvider, feature, bounds);
    }

}
