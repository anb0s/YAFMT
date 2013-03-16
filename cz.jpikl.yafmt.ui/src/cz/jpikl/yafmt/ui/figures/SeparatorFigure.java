package cz.jpikl.yafmt.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;

public class SeparatorFigure extends Figure {

    public SeparatorFigure() {
        setPreferredSize(1, 1);
        setForegroundColor(ColorConstants.black);
    }

    @Override
    public void paintFigure(Graphics graphics) {
        graphics.setLineWidth(computeLineWidth(graphics));
        graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
    }

    private int computeLineWidth(Graphics graphics) {
        return (int) Math.max(1.0, graphics.getAbsoluteScale());
    }
    
}
