package cz.jpikl.yafmt.ui.editors.fm.policies;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
    
    @Override
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        Object model = child.getModel();
        
        if(model instanceof Feature)
            return new MoveResizeFeatureCommand(layoutData, (Feature) model, (Rectangle) constraint);
        
        if(model instanceof Group){
            Dimension sizeDelta = request.getSizeDelta();
            if((sizeDelta.width != 0) || (sizeDelta.height != 0))
                return null;
            return new MoveGroupCommand(layoutData, (Group) model, (Rectangle) constraint);
        }

        return null;
    }
    
}
