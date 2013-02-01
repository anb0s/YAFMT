package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.SetFeatureCardinalityCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_MAKE_FEATURE_MAN.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, true);
        }
        else if(RequestConstants.REQ_MAKE_FEATURE_OPT.equals(type)) {
            Feature feature = (Feature) getHost().getModel();
            return createSetFeatureCardinalityCommand(feature, false);
        }
        return super.getCommand(request);
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
