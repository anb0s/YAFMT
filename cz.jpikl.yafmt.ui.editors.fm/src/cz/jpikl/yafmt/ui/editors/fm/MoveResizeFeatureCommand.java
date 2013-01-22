package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPart;

public class MoveResizeFeatureCommand extends Command {

    private FeatureModelEditPart featureModelEditPart;
    private Feature feature;
    private Rectangle newBounds;
    private Rectangle oldBounds;
    
    public MoveResizeFeatureCommand(FeatureModelEditPart featureModelEditPart, Feature feature, Rectangle bounds) {
        this.featureModelEditPart = featureModelEditPart;
        this.feature = feature;
        this.newBounds = bounds;
    }

    @Override
    public void execute() {
        oldBounds = featureModelEditPart.getFeatureBounds(feature);
        redo();
    }
    
    @Override
    public void redo() {
        featureModelEditPart.setFeatureBounds(feature, newBounds);
    }

    @Override
    public void undo() {
        featureModelEditPart.setFeatureBounds(feature, oldBounds);
    }
    
}
