package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;

public class SeparatorFigure extends Figure {

    public SeparatorFigure() {
        setPreferredSize(1, 1);
        setForegroundColor(ColorConstants.black);
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setLineWidth(1);
        graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
    }
    
}
