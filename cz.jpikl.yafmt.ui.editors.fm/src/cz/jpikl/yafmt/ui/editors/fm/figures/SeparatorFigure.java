package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;

public class SeparatorFigure extends Figure {

    public SeparatorFigure() {
        setPreferredSize(1, 1);
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
    }
    
}
