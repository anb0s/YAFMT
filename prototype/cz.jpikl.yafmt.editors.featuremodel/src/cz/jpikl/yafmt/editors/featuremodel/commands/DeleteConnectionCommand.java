package cz.jpikl.yafmt.editors.featuremodel.commands;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class DeleteConnectionCommand extends Command {

	private Connection connection;
	
	public DeleteConnectionCommand(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void execute() {
		FeatureModel featureModel = (FeatureModel) connection.getParent().eResource().getContents().get(0);
		featureModel.getOrphanedFeatures().add(connection.getChild());
	}


	
	@Override
	public void undo() {
		connection.getParent().getChildren().add(connection.getChild());
	}
	
}
