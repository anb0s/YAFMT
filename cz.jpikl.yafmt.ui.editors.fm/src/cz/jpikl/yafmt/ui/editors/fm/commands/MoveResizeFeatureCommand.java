package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutProvider;

public class MoveResizeFeatureCommand extends Command {

    private LayoutProvider layoutProvider;
    private Feature feature;
    private Rectangle newBounds;
    private Rectangle oldBounds;
    
    public MoveResizeFeatureCommand(LayoutProvider layoutProvider, Feature feature, Rectangle bounds) {
        setLabel("Move/Resize Feature");
        this.layoutProvider = layoutProvider;
        this.feature = feature;
        this.newBounds = bounds;
    }

    @Override
    public void execute() {
        oldBounds = layoutProvider.getBounds(feature);
        redo();
    }
    
    @Override
    public void redo() {
        layoutProvider.setBounds(feature, newBounds);
        moveGroups(oldBounds, newBounds);
    }

    @Override
    public void undo() {
        layoutProvider.setBounds(feature, oldBounds);
        moveGroups(newBounds, oldBounds);
    }
    
    private void moveGroups(Rectangle from, Rectangle to) {
        int dx = to.x - from.x;
        int dy = to.y - from.y;
        
        for(Group group: feature.getGroups()) {
            Rectangle bounds = layoutProvider.getBounds(group);
            bounds.x += dx;
            bounds.y += dy;
            layoutProvider.setBounds(group, bounds);
        }
        
        // Force repainting of parent group.
        EObject parent = feature.getParent();
        if(parent instanceof Group)
            layoutProvider.refreshBounds(parent);
    }
    
}
