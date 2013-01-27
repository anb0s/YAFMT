package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;

public class MoveGroupCommand extends Command {
    
    private IModelLayoutProvider layoutProvider;
    private Group group;
    private Rectangle newBounds;
    private Rectangle oldBounds;
    
    public MoveGroupCommand(IModelLayoutProvider layoutProvider, Group group, Rectangle bounds) {
        setLabel("Move Group");
        this.layoutProvider = layoutProvider;
        this.group = group;
        this.newBounds = bounds;
    }
        
    private void relocateNewPosition() {
        Rectangle parentBounds = layoutProvider.getObjectBounds(group.getParent());
        
        int cx = newBounds.x + newBounds.width / 2;
        int cy = newBounds.y + newBounds.height / 2;

        if((cx < parentBounds.x) || (cx > parentBounds.right()) || (cy < parentBounds.y) || (cy > parentBounds.bottom())) {
            if(cx < parentBounds.x) cx = parentBounds.x;
            else if(cx > parentBounds.right()) cx = parentBounds.right();
            if(cy < parentBounds.y) cy = parentBounds.y;
            else if(cy > parentBounds.bottom()) cy = parentBounds.bottom();
        }
        else {
            int dxLeft = cx - parentBounds.x;
            int dxRight = parentBounds.right() - cx;
            int dyTop = cy - parentBounds.y;
            int dyBottom = parentBounds.bottom() - cy;
            
            int dx = Math.min(dxLeft, dxRight);
            int dy = Math.min(dyTop, dyBottom);
            
            if(dx < dy)
                cx = (dxLeft < dxRight) ? parentBounds.x : parentBounds.right();
            else
                cy = (dyTop < dyBottom) ? parentBounds.y : parentBounds.bottom();
        }
                 
        newBounds.x = cx - newBounds.width / 2;
        newBounds.y = cy - newBounds.height / 2;
    }
    
    @Override
    public void execute() {
        oldBounds = layoutProvider.getObjectBounds(group);
        relocateNewPosition();
        redo();
    }
    
    @Override
    public void redo() {
        layoutProvider.setObjectBounds(group, newBounds);
    }

    @Override
    public void undo() {
        layoutProvider.setObjectBounds(group, oldBounds);
    }

}
