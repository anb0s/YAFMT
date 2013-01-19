package cz.jpikl.yafmt.editors.featureconfig.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.jpikl.yafmt.editors.featureconfig.utils.Connection;

public class ConnectionEditPart extends AbstractConnectionEditPart {

    public ConnectionEditPart(Connection connection) {
        setModel(connection);
    }

    @Override
    protected IFigure createFigure() {
        PolylineConnection connection = new PolylineConnection();
        PolygonDecoration decoration = new PolygonDecoration();
        decoration.setTemplate(PolygonDecoration.TRIANGLE_TIP);
        connection.setSourceDecoration(decoration);
        return connection;
    }

    @Override
    protected void createEditPolicies() {
    }


}
