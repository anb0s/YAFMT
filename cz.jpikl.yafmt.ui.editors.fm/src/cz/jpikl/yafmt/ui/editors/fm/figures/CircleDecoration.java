package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

class CircleDecoration extends Ellipse implements RotatableDecoration {

    private static final int RADIUS = 5;
    
    public CircleDecoration() {
        setForegroundColor(ColorConstants.black);
        setSize(2 * RADIUS, 2 * RADIUS);
    }
    
    public void setFilled(boolean filled) {
        setBackgroundColor(filled ? ColorConstants.black : ColorConstants.white);
    }
    
    @Override
    public void setReferencePoint(Point ref) {
        Point a = getLocation().getCopy();
        Point b = ref.getTranslated(a.getNegated());
        PrecisionPoint center = new PrecisionPoint();
        
        double c = RADIUS / Math.sqrt(b.x * b.x + b.y * b.y);
        
        center.setPreciseX(a.x + b.x * c - RADIUS);
        center.setPreciseY(a.y + b.y * c - RADIUS);

        center.x = (int) Math.round(center.preciseX());
        center.y = (int) Math.round(center.preciseY());

        if((b.x * c) < 0)
            center.x++;
        if((b.y * c) < 0)
            center.y++;

        setLocation(center);
    }

}
