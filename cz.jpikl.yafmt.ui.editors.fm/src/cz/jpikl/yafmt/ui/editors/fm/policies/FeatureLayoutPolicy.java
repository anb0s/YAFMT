package cz.jpikl.yafmt.ui.editors.fm.policies;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class FeatureLayoutPolicy extends OrderedLayoutEditPolicy {

    @Override
    protected EditPart getInsertionReference(Request request) {
        // Find the edit part after cursor location.
        List<?> editParts = getHost().getChildren();
        EditPart editPartAfter = null;
        
        int requestY = ((ChangeBoundsRequest) request).getLocation().y;
        int prevY = Integer.MAX_VALUE;
        
        for (Object editPart: editParts) {
            GraphicalEditPart currentEditPart = (GraphicalEditPart) editPart;
            int currentY = currentEditPart.getFigure().getBounds().getCenter().y; 
            if((currentY > requestY) && (currentY < prevY)) {
                prevY = currentY;
                editPartAfter = currentEditPart;
            }
        }

        return editPartAfter;
    }

    // Moved attribute within the same feature (change its position).
    @Override
    protected Command createMoveChildCommand(EditPart editPart, EditPart editPartAfter) {
        List<Attribute> attributes = ((Feature) getHost().getModel()).getAttributes();
        Attribute attribute = (Attribute) editPart.getModel();
        
        int currentIndex = attributes.indexOf(attribute);
        int targetIndex = attributes.size();
        if(editPartAfter != null)
            targetIndex = attributes.indexOf(editPartAfter.getModel());
                
        // Ignore request if attribute position was not changed.        
        if((currentIndex == targetIndex) || (currentIndex == (targetIndex - 1)))
            return null;
        // Fix position
        if(currentIndex < targetIndex)
            targetIndex--;
        
        return new MoveAttributeCommand(attribute, targetIndex);
    }
    
    // Moving attribute from another feature.
    @Override
    protected Command createAddCommand(EditPart editPart, EditPart editPartAfter) {
        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();
        Feature feature = (Feature) getHost().getModel();
        List<Attribute> attributes = feature.getAttributes();
        Attribute attribute = (Attribute) editPart.getModel();
        
        int targetIndex = attributes.size();
        if(editPartAfter != null)
            targetIndex = attributes.indexOf(editPartAfter.getModel());
                
        CompoundCommand command = new CompoundCommand("Move attribute " + attribute.getName() + " to " + feature.getName());
        command.add(new DeleteAttributeCommand(layoutData, attribute));
        command.add(new AddAttributeCommand(layoutData, feature, attribute, targetIndex));
        return command;
    }

    // A new attribute added to the feature.
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        Object object = request.getNewObject();
        if(!(object instanceof Attribute))
            return null;
        
        Feature feature = (Feature) getHost().getModel();
        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();
        
        return new AddAttributeCommand(layoutData, feature, (Attribute) object);
    }

}