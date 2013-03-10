package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;

import cz.jpikl.yafmt.ui.util.DrawUtil;

public class SquareDecoration extends RectangleFigure implements RotatableDecoration {

    private static final int SIDE = 10;

    public SquareDecoration() {
        setForegroundColor(ColorConstants.black);
        setSize(SIDE, SIDE);
    }

    public void setFilled(boolean filled) {
        setBackgroundColor(filled ? ColorConstants.black : ColorConstants.white);
    }

    @Override
    public void setReferencePoint(Point ref) {
        translate(-SIDE / 2, -SIDE / 2);
    }
    
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixZoomedFigureLocation(graphics);
        super.paint(graphics);
    }

}
