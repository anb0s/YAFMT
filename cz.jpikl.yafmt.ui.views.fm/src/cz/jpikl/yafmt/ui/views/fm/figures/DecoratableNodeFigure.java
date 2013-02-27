package cz.jpikl.yafmt.ui.views.fm.figures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.views.fm.decorations.IDecoration;

public class DecoratableNodeFigure extends NodeFigure {
    
    private List<IDecoration> decorations = new ArrayList<IDecoration>();
    private int decorationSpace = 2;
    
    public DecoratableNodeFigure() {
        setVisible(false);
    }
        
    public void setDecorationSpace(int decorationSpace) {
        this.decorationSpace = decorationSpace;
    }
    
    public int getDecorationSpace() {
        return decorationSpace;
    }
    
    public List<IDecoration> getDecorations() {
        return Collections.unmodifiableList(decorations);
    }
    
    public void addDecoration(IDecoration decoration) {
        decorations.add(decoration);
        addDecorationToParent(decoration);
    }
        
    public void removeDecoration(IDecoration decoration) {
        decorations.remove(decoration);
        removeDecorationFromParent(decoration);  
    }
    
    private void addDecorationToParent(IDecoration decoration) {
        if(getParent() != null) {        
            if(decoration.isOnTop())
                getParent().add(decoration);
            else
                getParent().add(decoration, 0);
        }
    }
    
    private void removeDecorationFromParent(IDecoration decoration) {
        if(getParent() != null)
            getParent().remove(decoration);
        
    }
    
    public void moveDecorations() {
        IFigure parent = getParent();
        if(parent == null)
            return;
        
        Rectangle rect = (Rectangle) parent.getLayoutManager().getConstraint(this);
        if(rect == null)
            return;
        
        Point bottomLeft = rect.getBottomLeft();
        int x = -1;
        int y = bottomLeft.y;
        
        for(IDecoration decoration: decorations) {            
            if(decoration.isAutoPositioned()) {
                if(x == -1)
                    x = bottomLeft.x - decoration.getSize().width / 2;
                Dimension size = decoration.getSize();
                Point position = new Point(x, y - size.height / 4);
                parent.setConstraint(decoration, new Rectangle(position, size));
                x += size.width + decorationSpace;
            }
            else {
                parent.setConstraint(decoration, decoration.computeNewPosition(rect));
            }
        }
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        for(IDecoration decoration: decorations)
            addDecorationToParent(decoration);
    }
    
    @Override
    public void removeNotify() {
        for(IDecoration decoration: decorations)
            removeDecorationFromParent(decoration);
        super.removeNotify();
    }
    
    @Override
    protected void fireFigureMoved() {
        super.fireFigureMoved();
        moveDecorations();
    }
        
}
