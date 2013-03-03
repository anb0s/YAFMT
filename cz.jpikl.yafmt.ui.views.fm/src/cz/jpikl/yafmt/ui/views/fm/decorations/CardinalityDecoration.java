package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class CardinalityDecoration extends Label implements IDecoration {

    private static final Label MANDATORY_TOOL_TIP = new Label("Feature is mandatory.");
    private static final Label MANDATORY_CLONNABLE_TOOL_TIP = new Label("Feature is mandatory and clonnable.");
    private static final Label OPTIONAL_TOOL_TIP = new Label("Feature is optional.");
    private static final Label OPTIONAL_CLONNABLE_TOOL_TIP = new Label("Feature is optional and clonnable.");
    
    private int alpha = 255;
    
    public CardinalityDecoration(int lower, int upper) {
        setForegroundColor(ColorConstants.darkGray);
        setFont(DrawConstantans.TINY_FONT);
        setText(lower + ".." + ((upper == -1) ? "*" : upper));
        setSize(FigureUtilities.getStringExtents(getText(), getFont()).expand(4, 4));
        setBorder(new MarginBorder(2));
        
        if(upper > 1)
            setToolTip((lower == 0) ? OPTIONAL_CLONNABLE_TOOL_TIP : MANDATORY_CLONNABLE_TOOL_TIP);
        else
            setToolTip((lower == 0) ? OPTIONAL_TOOL_TIP : MANDATORY_TOOL_TIP);
    }
    
    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }

    @Override
    public Integer getAlpha() {
        return alpha;
    }

    @Override
    public boolean isAutoPositioned() {
        return false;
    }

    @Override
    public boolean isOnTop() {
        return true;
    }

    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x + parentBounds.width - 1;
        int y = parentBounds.y - bounds.height + 1;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        graphics.setForegroundColor(ColorConstants.lightGray);
        graphics.setBackgroundColor(ColorConstants.white);
        graphics.fillRoundRectangle(bounds, 4, 4);
        graphics.drawRoundRectangle(bounds.getCopy().resize(-1, -1), 4, 4);
        super.paint(graphics);
    }

}