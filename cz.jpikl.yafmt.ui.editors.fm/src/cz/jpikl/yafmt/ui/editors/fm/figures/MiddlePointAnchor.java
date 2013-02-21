package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

public class MiddlePointAnchor extends AbstractConnectionAnchor {

    public MiddlePointAnchor(IFigure figure) {
        super(figure);
    }
    
    @Override
    public Point getLocation(Point reference) {
        IFigure owner = getOwner();
        Point center = owner.getBounds().getCenter();
        // Important!!!
        // It computes the right position when viewport is scrolling.
        owner.translateToAbsolute(center);
        return center;
    }
    
}
