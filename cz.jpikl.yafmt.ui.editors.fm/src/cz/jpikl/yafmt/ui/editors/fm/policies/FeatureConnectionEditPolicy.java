package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddConnectionCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.ReconnectTargetCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.ReconnectSourceCommand;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

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
        EObject newTarget = (EObject) request.getTarget().getModel();
        if(!(newTarget instanceof Feature))
            return null;

        Connection connection = (Connection) request.getConnectionEditPart().getModel();
        if((newTarget == connection.getTarget()) || (newTarget.eContainer() == connection.getSource()))
            return null;

        for(EObject object = connection.getSource(); object != null; object = object.eContainer()) {
            if(newTarget == object)
                return null;
        }
        
        return new ReconnectSourceCommand(connection, (Feature) newTarget);
    }

    @Override
    protected Command getReconnectTargetCommand(ReconnectRequest request) {
        Object newSource = request.getTarget().getModel();
        if(!(newSource instanceof Feature) && (newSource instanceof Group))
            return null;
        
        Connection connection = (Connection) request.getConnectionEditPart().getModel();
        if(newSource == connection.getSource())
            return null;
        
        for(EObject object = (EObject) newSource; object != null; object = object.eContainer()) {
            if(connection.getTarget() == object)
                return null;
        }
        
        return new ReconnectTargetCommand(connection, (EObject) newSource);
    }

}
