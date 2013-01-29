package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class MoveResizeFeatureCommand extends Command {

    private LayoutData layoutData;
    private Feature feature;
    private Rectangle oldBounds;
    private Rectangle newBounds;
    
    public MoveResizeFeatureCommand(LayoutData layoutData, Feature feature, Rectangle newBounds) {
        this.layoutData = layoutData;
        this.feature = feature;
        this.oldBounds = layoutData.getMapping().get(feature);
        this.newBounds = newBounds;
        
        if((oldBounds.x != newBounds.x) || (oldBounds.y != newBounds.y))
            setLabel("Move Feature");
        else
            setLabel("Resize Feature");
    }

    @Override
    public void execute() {
        redo();
    }
    
    @Override
    public void redo() {
        layoutData.getMapping().put(feature, newBounds);
        moveGrous(oldBounds, newBounds);
    }
    
    @Override
    public void undo() {
        layoutData.getMapping().put(feature, oldBounds);
        moveGrous(newBounds, oldBounds);
    }
    
    private void moveGrous(Rectangle from, Rectangle to) {
        int dx = to.x - from.x;
        int dy = to.y - from.y;
        
        for(Group group: feature.getGroups()) {
            Rectangle bounds = layoutData.getMapping().get(group);
            bounds.x += dx;
            bounds.y += dy;
            layoutData.getMapping().put(group, bounds);
        }
    }
    
}
