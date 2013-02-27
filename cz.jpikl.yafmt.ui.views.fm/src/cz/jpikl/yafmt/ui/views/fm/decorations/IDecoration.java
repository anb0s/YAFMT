package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public interface IDecoration extends IFigure {

    boolean isAutoPositioned();
    
    boolean isOnTop();
    
    Rectangle computeNewPosition(Rectangle parentBounds);
    
    
    
}
