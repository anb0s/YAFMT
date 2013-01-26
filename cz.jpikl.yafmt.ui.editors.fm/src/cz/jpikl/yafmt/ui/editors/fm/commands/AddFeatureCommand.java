package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;

public class AddFeatureCommand extends Command {
    
    private IModelLayoutProvider layoutProvider;
    private FeatureModel featureModel;
    private Feature feature;
    private Rectangle bounds;
    
    public AddFeatureCommand(IModelLayoutProvider layoutProvider, FeatureModel featureModel, Feature feature, Point location) {
        setLabel("Add New Feature");
        this.layoutProvider = layoutProvider;
        this.featureModel = featureModel;
        this.feature = feature;
        this.bounds = new Rectangle(location.x - 50, location.y - 12, 100, 25);
    }

    @Override
    public void execute() {
        redo();
    }
    
    @Override
    public void redo() {
        featureModel.getOrphans().add(feature);
        layoutProvider.setObjectBounds(feature, bounds);
    }
    
    @Override
    public void undo() {
        featureModel.getOrphans().remove(feature);
        layoutProvider.setObjectBounds(feature, null);
    }
        
}
