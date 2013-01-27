package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.jpikl.yafmt.ui.editors.fm.figures.ConnectionFigure;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionEditPolicy;
import cz.jpikl.yafmt.ui.editors.fm.policies.ConnectionSelectionPolicy;

public class ConnectionEditPart extends AbstractConnectionEditPart {

    public ConnectionEditPart(Connection connection) {
        setModel(connection);
    }
    
    @Override
    protected IFigure createFigure() {
        return new ConnectionFigure();
    }
        
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ConnectionSelectionPolicy());
        installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy());        
    }

}
