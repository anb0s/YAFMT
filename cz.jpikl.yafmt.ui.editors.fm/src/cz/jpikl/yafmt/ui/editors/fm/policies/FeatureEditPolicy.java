package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.RequestConstants;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.RemoveAttributeCommand;

public class FeatureEditPolicy extends AbstractEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_ADD_ATTRIBUTE.equals(type))
            return createAddAttributeCommand();
        else if(RequestConstants.REQ_REMOVE_ATTRIBUTE.equals(type))
            return createRemoveAttributeCommand(request);
        return null;
    }

    private Command createAddAttributeCommand() {
        Feature feature = (Feature) getHost().getModel();
        return new AddAttributeCommand(feature);
    }
    
    private Command createRemoveAttributeCommand(Request request) {
        Feature feature = (Feature) getHost().getModel();
        Integer index = (Integer) request.getExtendedData().get("index");
        return new RemoveAttributeCommand(feature, index);
    }
    
}
