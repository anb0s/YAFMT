package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class NodeFigure extends Label implements IFigureWithAlpha {

    private Color hightlightColor;
    private boolean highlighted = false;
    private int margin = 2;
    private int arcRadius = 10;
    private int alpha = 255;

    public NodeFigure() {
        setFont(DrawConstantans.DEFAULT_FONT);
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHightlightColor(Color color) {
        if(hightlightColor != color) {
            hightlightColor = color;
            repaint();
        }
    }

    public Color getHightlightColor() {
        return hightlightColor;
    }
    
    public void setMargin(int margin) {
        this.margin = margin;
    }

    public void setArcRadius(int arcRadius) {
        this.arcRadius = arcRadius;
    }

    public int getArcRadius() {
        return arcRadius;
    }

    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }

    @Override
    public int getAlpha() {
        return alpha;
    }
    
    public void setToolTipText(String text) {
        setToolTip(new Label(text));
    }
    
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        adjustBoundsToFit();
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        adjustBoundsToFit();
    }

    protected void adjustBoundsToFit() {
        if((getText() == null) || (getFont() == null))
            return;
        
        Dimension minSize = FigureUtilities.getTextExtents(getText(), getFont());
        if(getIcon() != null) {
            org.eclipse.swt.graphics.Rectangle imageRect = getIcon().getBounds();
            int expandHeight = Math.max(imageRect.height - minSize.height, 0);
            minSize.expand(imageRect.width + 4, expandHeight);
        }
        minSize.expand(5 + 2 * margin, 2 + 2 * margin);
        setBounds(new Rectangle(getLocation(), minSize));
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        
        Color bgColor1 = highlighted ? hightlightColor : getBackgroundColor();
        Color bgColor2 = DrawConstantans.getModifiedColor(bgColor1, -0.2f);
                
        Rectangle rect = new Rectangle(bounds.x, bounds.y, bounds.width - 1, arcRadius);
        graphics.setBackgroundColor(bgColor1);
        graphics.fillRoundRectangle(rect, arcRadius, arcRadius);
        
        rect.y += bounds.height - arcRadius - 1;
        graphics.setBackgroundColor(bgColor2);
        graphics.fillRoundRectangle(rect, arcRadius, arcRadius);
        
        
        rect.height = bounds.height - arcRadius - 1;
        rect.y = bounds.y + arcRadius / 2;
        graphics.setForegroundColor(bgColor1);
        graphics.fillGradient(rect, true);
        
        rect.y = bounds.y;
        rect.height = bounds.height - 1;
        graphics.setForegroundColor(getForegroundColor());
        graphics.drawRoundRectangle(rect, arcRadius, arcRadius);
        
        bgColor2.dispose();
        
        super.paint(graphics);
    }

}
