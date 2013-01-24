package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.RemoveAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureEditPolicy extends AbstractEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_ADD_ATTRIBUTE.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createAddAttributeCommand(feature);
        }
        else if(RequestConstants.REQ_REMOVE_ATTRIBUTE.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            Integer attributeIndex = (Integer) request.getExtendedData().get("index");
            return createRemoveAttributeCommand(feature, attributeIndex);
        }
        return null;
    }

    private Command createAddAttributeCommand(Feature feature) {
        return new AddAttributeCommand(feature);
    }
    
    private Command createRemoveAttributeCommand(Feature feature, int attributeIndex) {
        if((attributeIndex < 0) || (attributeIndex >= feature.getAttributes().size()))
            return null;
        return new RemoveAttributeCommand(feature, attributeIndex);
    }
    
}
