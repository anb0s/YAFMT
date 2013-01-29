package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.SetFeatureCardinalityCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureEditPolicy extends ComponentEditPolicy {

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
        else if(RequestConstants.REQ_MAKE_FEATURES_MAN.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, true);
        }
        else if(RequestConstants.REQ_MAKE_FEATURES_OPT.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, false);
        }
        return super.getCommand(request);
    }

    private Command createAddAttributeCommand(Feature feature) {
        return new AddAttributeCommand(feature);
    }
    
    private Command createRemoveAttributeCommand(Feature feature, int attributeIndex) {
        if((attributeIndex < 0) || (attributeIndex >= feature.getAttributes().size()))
            return null;
        return new DeleteAttributeCommand(feature, attributeIndex);
    }   
    
    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        Feature feature = (Feature) getHost().getModel();
        if(feature.isRoot())
            return null;
        
        LayoutData layoutData = ((FeatureEditPart) getHost()).getLayoutData();
        return new DeleteFeatureCommand(feature, layoutData);
    }
    
    private Command createSetFeatureCardinalityCommand(Feature feature, boolean mandatory) {
        if(feature.isRoot())
            return null;
        if(feature.isMandatory() == mandatory)
            return null;
        return new SetFeatureCardinalityCommand(feature, mandatory);
    }
    
}
