package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class AddFeatureCommand extends RecordingCommand {
    
    private LayoutData layoutData;
    private FeatureModel featureModel;
    private Feature feature;
    private Point location;
    
    public AddFeatureCommand(LayoutData layoutData, FeatureModel featureModel, Feature feature, Point location) {
        setLabel("Add New Feature");
        this.layoutData = layoutData;
        this.featureModel = featureModel;
        this.feature = feature;
        this.location = location;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
        addRecordedObject(layoutData);
    }

    @Override
    protected void performRecording() {
        int x = location.x - FeatureFigure.WIDTH / 2;
        int y = location.y - FeatureFigure.HEGHT / 2;
        Rectangle bounds = new Rectangle(x, y, FeatureFigure.WIDTH, FeatureFigure.HEGHT);
        
        featureModel.getOrphans().add(feature);
        layoutData.getMapping().put(feature, bounds);
    }
        
}
