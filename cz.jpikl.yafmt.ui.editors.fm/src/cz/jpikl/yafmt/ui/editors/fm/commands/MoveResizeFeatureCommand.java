package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;

public class MoveResizeFeatureCommand extends Command {

    private IModelLayoutProvider layoutProvider;
    private Feature feature;
    private Rectangle newBounds;
    private Rectangle oldBounds;
    
    public MoveResizeFeatureCommand(IModelLayoutProvider layoutProvider, Feature feature, Rectangle bounds) {
        setLabel("Move/Resize Feature");
        this.layoutProvider = layoutProvider;
        this.feature = feature;
        this.newBounds = bounds;
    }

    @Override
    public void execute() {
        oldBounds = layoutProvider.getObjectBounds(feature);
        redo();
    }
    
    @Override
    public void redo() {
        layoutProvider.setObjectBounds(feature, newBounds);
    }

    @Override
    public void undo() {
        layoutProvider.setObjectBounds(feature, oldBounds);
    }
    
}
