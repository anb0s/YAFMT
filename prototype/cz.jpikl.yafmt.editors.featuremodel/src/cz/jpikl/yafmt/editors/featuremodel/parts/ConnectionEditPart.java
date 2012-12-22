package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;

public class ConnectionEditPart extends AbstractConnectionEditPart {

	public ConnectionEditPart(Connection connection) {
		setModel(connection);
	}
		
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}

}
