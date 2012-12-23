package cz.jpikl.yafmt.editors.featuremodel.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class DeleteFeatureCommand extends Command {

	private FeatureModel featureModel;
	private Feature parent;
	private Feature feature;
	private List<Feature> children;
	
	public DeleteFeatureCommand(FeatureModel featureModel, Feature feature) {
		this.featureModel = featureModel;
		this.feature = feature;
	}
		
	@Override
	public void execute() {
		parent = feature.getParent();
		if(parent == null)
			featureModel.getOrphanedFeatures().remove(feature);
		else
			parent.getChildren().remove(feature);

		children = new ArrayList<Feature>(feature.getChildren());
		featureModel.getOrphanedFeatures().addAll(children);
	}
	
	@Override
	public void undo() {
		if(parent == null)
			featureModel.getOrphanedFeatures().add(feature);
		else
			parent.getChildren().add(feature);
		
		featureModel.getOrphanedFeatures().removeAll(children);
		feature.getChildren().addAll(children);
	}
	
}
