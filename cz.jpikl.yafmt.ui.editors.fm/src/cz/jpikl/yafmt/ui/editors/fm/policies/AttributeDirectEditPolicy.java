package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.ui.editors.fm.commands.RenameAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.SetAttributeTypeCommand;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;

public class AttributeDirectEditPolicy extends DirectEditPolicy {

    @Override
    protected Command getDirectEditCommand(DirectEditRequest request) {
        Attribute attribute = (Attribute) getHost().getModel();
        Object value = request.getCellEditor().getValue();
        
        // Name input.
        if(value instanceof String) {
            String name = (String) value;
            if(name.isEmpty())
                return null;
            return new RenameAttributeCommand(attribute, name);
        }
        
        // Type input.
        if(value instanceof AttributeType) {
            AttributeType type = (AttributeType) value;
            return new SetAttributeTypeCommand(attribute, type);
        }
        
        return null;
    }

    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {
        // Feedback only for attribute name input.
        Object value = request.getCellEditor().getValue();
        if(value == null)
            value = "";
        if(value instanceof String)
            ((AttributeFigure) getHostFigure()).updateName((String) value);
    }
    
}
