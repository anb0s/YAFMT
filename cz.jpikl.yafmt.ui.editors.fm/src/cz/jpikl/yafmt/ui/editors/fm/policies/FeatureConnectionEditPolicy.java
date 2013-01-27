package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddConnectionCommand;

public class FeatureConnectionEditPolicy extends GraphicalNodeEditPolicy {

    @Override
    protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
        Feature feature = (Feature) getHost().getModel();
        request.setStartCommand(new AddConnectionCommand(feature));
        return request.getStartCommand();
    }
    
    @Override
    protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
        Feature feature = (Feature) getHost().getModel();
        AddConnectionCommand command = (AddConnectionCommand) request.getStartCommand();
        if(command.setDestination(feature))
            return command;
        return null;
    }

    @Override
    protected Command getReconnectSourceCommand(ReconnectRequest request) {
        return null;
    }

    @Override
    protected Command getReconnectTargetCommand(ReconnectRequest request) {
        return null;
    }

}
