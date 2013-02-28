package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class HiddenNeighborsDecoration extends RoundedRectangle implements IDecoration {
        
    private static final int BORDER_SCALE = 5;
    
    private int hiddenNeighborsCount;
    
    public HiddenNeighborsDecoration(int hiddenNeighborsCount) {
        this.hiddenNeighborsCount = hiddenNeighborsCount;
        
        setCornerDimensions(new Dimension(15, 15));
        setForegroundColor(DrawConstantans.FEATURE_COLOR);
        setBackgroundColor(DrawConstantans.FEATURE_HL_COLOR);
        
        if(hiddenNeighborsCount > 1)
            setToolTip(new Label("Feature has " + hiddenNeighborsCount + " hidden neighbors."));
        else
            setToolTip(new Label("Feature has a hidden neighbor."));
    }
    
    @Override
    public boolean isAutoPositioned() {
        return false;
    }

    @Override
    public boolean isOnTop() {
        return false;
    }

    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int border = hiddenNeighborsCount * BORDER_SCALE; 
        return parentBounds.getCopy().expand(border, border);
    }
            
}
