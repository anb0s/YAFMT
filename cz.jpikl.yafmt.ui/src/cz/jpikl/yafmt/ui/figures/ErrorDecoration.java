package cz.jpikl.yafmt.ui.figures;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.util.DrawConstantans;
import cz.jpikl.yafmt.ui.util.DrawUtil;

public class ErrorDecoration extends RoundedRectangle {

    private static final Dimension CORNER_DIMENSION = new Dimension(4, 4);
    private static final int SIZE = 12; 
    
    private Label toolTip = new Label();

    public ErrorDecoration() {
        setForegroundColor(DrawConstantans.DARK_RED_COLOR);
        setBackgroundColor(ColorConstants.red);
        setToolTip(toolTip);
        setSize(SIZE, SIZE);
        setCornerDimensions(CORNER_DIMENSION);
        setVisible(false);
    }

    public void setErrors(Collection<String> messages) {
        if((messages == null) || messages.isEmpty()) {
            setVisible(false);
            return;
        }

        StringBuilder builder = null;
        for(String message: messages) {
            if(builder == null)
                builder = new StringBuilder(message);
            else
                builder.append("\n").append(message);
        }

        toolTip.setText(builder.toString());
        setVisible(true);
    }
    
    @Override
    protected void outlineShape(Graphics graphics) {
        drawCross(graphics);
        DrawUtil.fixZoomedFigureLocation(graphics);
        super.outlineShape(graphics);
    }
            
    private void drawCross(Graphics graphics) {
        graphics.setForegroundColor(ColorConstants.white);
        Rectangle rect = bounds.getCopy().shrink(3, 3);
        graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
        graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
        graphics.setForegroundColor(getForegroundColor());
    }

}
