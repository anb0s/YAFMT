package cz.jpikl.yafmt.editors.featuremodel.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutFactory;
import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.layout.ObjectBounds;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class CreateFeatureCommand extends Command {

	private FeatureModel featureModel;
	private Feature feature;
	private Rectangle bounds;
	private ModelLayoutStore layoutStore;
	
	public CreateFeatureCommand(FeatureModel featureModel, Feature feature, Rectangle bounds, ModelLayoutStore layoutStore) {
		this.featureModel = featureModel;
		this.feature = feature;
		this.bounds = bounds;
		this.layoutStore = layoutStore;
	}

	@Override
	public void execute() {
		System.out.println("New feature bounds: " + bounds.toString());
		
		ObjectBounds objectBounds = ModelLayoutFactory.eINSTANCE.createObjectBounds();
		objectBounds.setBounds(bounds);
		objectBounds.setWidth(100);
		objectBounds.setHeight(25);
		layoutStore.setObjectLayout(feature, objectBounds);
		
		featureModel.getOrphanedFeatures().add(feature);
	}
	
	@Override
	public void undo() {
		featureModel.getOrphanedFeatures().remove(feature);
	}
	
}
