package cz.jpikl.yafmt.ui.editors.fm.policies;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.AutoLayoutCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveGroupCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.ResizeFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPart;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureModelLayoutPolicy extends XYLayoutEditPolicy {

    @Override
    public Command getCommand(Request request) {
        if(RequestConstants.REQ_AUTO_LAYOUT.equals(request.getType()))
            return createAutoLayoutCommand();
        return super.getCommand(request);
    }
    
    // Auto layout.
    private Command createAutoLayoutCommand() {
        FeatureModel featureModel = (FeatureModel) getHost().getModel();
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        return new AutoLayoutCommand(featureModel, layoutData);
    }

    // Add new feature.
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        FeatureModel featureModel = (FeatureModel) getHost().getModel();
        Feature feature = (Feature) request.getNewObject();
        Point location = request.getLocation();
        return new AddFeatureCommand(layoutData, featureModel, feature, location);
    }
    
    // Move/resize elements.
    @Override
    protected Command getChangeConstraintCommand(ChangeBoundsRequest request) {
        // Fix move command.
        // Drop all group edit parts which parent feature is also being moved.
        Dimension sizeDelta = request.getSizeDelta();
        if((sizeDelta.width == 0) && (sizeDelta.height == 0)) {
            // Find all feature edit parts which are also selected to move.
            Set<Feature> features = new HashSet<Feature>();
            for(Object editPart: getHost().getChildren()) {
                if(((EditPart) editPart).getSelected() == EditPart.SELECTED_NONE)
                    continue;
                Object model = ((EditPart) editPart).getModel();
                if(model instanceof Feature)
                    features.add((Feature) model);
            }
            // Remove related group edit parts from request.
            for(Iterator<?> it = request.getEditParts().iterator(); it.hasNext(); ) {
                Object model = ((EditPart) it.next()).getModel();
                if((model instanceof Group) && (features.contains(((Group) model).getParent())))
                    it.remove();
            }
        }
        // No need to proceed empty request.
        if(request.getEditParts().isEmpty())
            return null;
        
        return super.getChangeConstraintCommand(request);
    }
    
    // Move/resize feature or group.
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        Dimension sizeDelta = request.getSizeDelta();
        boolean resizeCommand = (sizeDelta.width != 0) || (sizeDelta.height != 0);
        
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        Object model = child.getModel();
        
        if(model instanceof Feature) {
            if(resizeCommand) {
                Rectangle deltas = new Rectangle(request.getMoveDelta(), sizeDelta);
                return new ResizeFeatureCommand(layoutData, (Feature) model, deltas);
            }            
            else {
                return new MoveFeatureCommand(layoutData, (Feature) model, (Rectangle) constraint);   
            }
        }
        
        if(model instanceof Group){
            // Groups can be only moved.
            if(resizeCommand)
                return null;
            return new MoveGroupCommand(layoutData, (Group) model, (Rectangle) constraint);
        }

        return null;
    }
    
}
