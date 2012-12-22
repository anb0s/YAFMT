package cz.jpikl.yafmt.editors.featuremodel.commands;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class CreateConnectionCommand extends Command {

	private Feature source;
	private Feature destination;
	private Feature prevDstParent;
	
	public CreateConnectionCommand(Feature source) {
		this.source = source;
	}
	
	private FeatureModel getFeatureModel() {
		return (FeatureModel) source.eResource().getContents().get(0);
	}
	
	public boolean setDestination(Feature destination) {
		if(getFeatureModel().getRootFeature() == destination)
			return false;
		
		for(Feature ft = source; ft != null; ft = ft.getParent()) {
			if(ft == destination)
				return false;
		}
					
		this.destination = destination;
		return true;
	}
		
	@Override
	public void execute() {
		prevDstParent = destination.getParent();
		source.getChildren().add(destination);
	}
	
	@Override
	public void undo() {
		if(prevDstParent != null)
			prevDstParent.getChildren().add(destination);
		else
			getFeatureModel().getOrphanedFeatures().add(destination);
	}
	
}
