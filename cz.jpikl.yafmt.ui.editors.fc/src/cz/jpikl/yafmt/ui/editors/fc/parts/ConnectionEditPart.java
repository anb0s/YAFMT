package cz.jpikl.yafmt.ui.editors.fc.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.jpikl.yafmt.ui.editors.fc.figures.ConnectionFigure;
import cz.jpikl.yafmt.ui.editors.fc.model.Connection;

public class ConnectionEditPart extends AbstractConnectionEditPart {

    Connection connection;
    
    public ConnectionEditPart(Connection connection) {
        this.connection = connection;
        setModel(connection);
    }

    @Override
    protected IFigure createFigure() {
        return new ConnectionFigure();
    }
    
    @Override
    protected void refreshVisuals() {
        ConnectionFigure figure = (ConnectionFigure) getFigure();
        figure.setGrayed(connection.getTarget().getParent() == null);
        figure.repaint();
        
    }
    
    @Override
    protected void createEditPolicies() {
    }

}
