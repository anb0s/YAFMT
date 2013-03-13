package cz.jpikl.yafmt.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;

import cz.jpikl.yafmt.ui.util.DrawConstantans;


public class ConstraintMarker extends MarkerFigure {
    
    private static final String LABEL = "{ }";
    
    public ConstraintMarker() {
        setBackgroundColor(DrawConstantans.CONSTRAINT_COLOR);
        setForegroundColor(DrawConstantans.CONSTRAINT_DARKER_COLOR);
        setToolTipText("This feature is affected by a constraint.");
        setVisible(false);
    }
    
    @Override
    protected void paintContents(Graphics graphics) {
        Dimension size = TextUtilities.INSTANCE.getStringExtents(LABEL, DrawConstantans.TINY_FONT);
        double x = bounds.x + 0.5 * (bounds.width - size.width);
        double y = bounds.y + 0.5 * (bounds.height - size.height);
        graphics.setForegroundColor(ColorConstants.white);
        graphics.setFont(DrawConstantans.TINY_FONT);
        graphics.drawText("{ }", new PrecisionPoint(x, y));
    }
    
}
