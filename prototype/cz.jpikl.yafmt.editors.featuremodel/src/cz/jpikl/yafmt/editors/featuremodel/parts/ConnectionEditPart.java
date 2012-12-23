package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.editors.featuremodel.commands.DeleteConnectionCommand;
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
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			// Called when deleting connection.
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteConnectionCommand((Connection) getModel());
			}
		});
		
		// Enable/disable connection selection.
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy() {
			@Override
			protected void showSelection() {
				((PolylineConnection) getFigure()).setLineWidth(2);
			}
			
			@Override
			protected void hideSelection() {
				((PolylineConnection) getFigure()).setLineWidth(1);	
			}
		});
	}

}
