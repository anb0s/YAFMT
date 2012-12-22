package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;

public class ConnectionEditPart extends AbstractConnectionEditPart {

	private static final PointList CIRCLE = new PointList(new int[]{
		0, 0, 0, -1, -1, -2, -3, -2, -4, -1, -4, 1, -3, 2, -1, 2, 0, 1  
	});
	
	public ConnectionEditPart(Connection connection) {
		setModel(connection);
	}
		
	@Override
	protected IFigure createFigure() {
		PolylineConnection connection = new PolylineConnection();
		PolygonDecoration decoration = new PolygonDecoration();
		decoration.setBackgroundColor(ColorConstants.white);
		decoration.setScale(2, 2);
		decoration.setTemplate(CIRCLE);
		connection.setSourceDecoration(decoration);
		return connection;
	}
	
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}

}
