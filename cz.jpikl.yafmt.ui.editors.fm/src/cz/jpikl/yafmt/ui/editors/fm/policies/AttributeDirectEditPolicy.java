package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.ui.editors.fm.commands.RenameAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;

public class AttributeDirectEditPolicy extends DirectEditPolicy {

    private String getEnteredText(DirectEditRequest request) {
        return (String) request.getCellEditor().getValue();
    }
    
    @Override
    protected Command getDirectEditCommand(DirectEditRequest request) {
        String text = getEnteredText(request);
        if((text == null) || text.isEmpty())
            return null;
        
        Attribute attribute = (Attribute) getHost().getModel();
        return new RenameAttributeCommand(attribute, text);
    }

    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {
        ((AttributeFigure) getHostFigure()).setText(getEnteredText(request)); 
    }

}
