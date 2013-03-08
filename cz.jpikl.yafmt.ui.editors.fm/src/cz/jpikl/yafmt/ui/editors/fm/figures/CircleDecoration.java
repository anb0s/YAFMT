package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;

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
    protected void fillShape(Graphics graphics) {
        graphics.fillOval(getBounds());
    }

    @Override
    public void setReferencePoint(Point ref) {
        translate(-RADIUS, -RADIUS);
    }

}
