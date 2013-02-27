package cz.jpikl.yafmt.ui.views.fm.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.ui.views.fm.decorations.IDecoration;

public class NodeFigure extends Label implements IFigureWithAlpha {
    
    private List<IDecoration> decorations = new ArrayList<IDecoration>();
    private int decorationSpace = 2;
    
    private boolean highlighted = false;
    private Color hightlightColor;
    
    private int arcRadius = 10; 
    private int alpha = 255;
    
    public NodeFigure() {
        setMargin(3);
        setFont(Display.getDefault().getSystemFont());
        setVisible(false);
    }
    
    public void setMargin(int margin) {
        setBorder(new MarginBorder(margin, 2 * margin, margin, 2 * margin));
    }
    
    public List<IDecoration> getDecorations() {
        return decorations;
    }
    
    public void setDecorationSpace(int decorationSpace) {
        this.decorationSpace = decorationSpace;
    }
    
    public int getDecorationSpace() {
        return decorationSpace;
    }
    
    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
    
    public boolean isHighlighted() {
        return highlighted;
    }
    
    public void setHightlightColor(Color hightlightColor) {
        this.hightlightColor = hightlightColor;
    }
    
    public Color getHightlightColor() {
        return hightlightColor;
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
        
    public void addDecoration(IDecoration decoration) {
        decorations.add(decoration);
        addDecorationToParent(decoration);
    }
        
    public void removeDecoration(IDecoration decoration) {
        decorations.remove(decoration);
        removeDecorationFromParent(decoration);
            
    }
    
    private void addDecorationToParent(IDecoration decoration) {
        if(getParent() != null) {        
            if(decoration.isOnTop())
                getParent().add(decoration);
            else
                getParent().add(decoration, 0);
        }
    }
    
    private void removeDecorationFromParent(IDecoration decoration) {
        if(getParent() != null)
            getParent().remove(decoration);
        
    }
    
    public void moveDecorations() {
        if(getParent() == null)return;
        Rectangle r = ((Rectangle) getParent().getLayoutManager().getConstraint(this));
        if(r == null)return;
        Point bottomLeft = r.getBottomLeft();//bounds.getBottomLeft();
        int x = -1;
        int y = bottomLeft.y;
        
        for(IDecoration decoration: decorations) {            
            if(decoration.isAutoPositioned()) {
                if(x == -1)
                    x = bottomLeft.x - decoration.getSize().width / 2;
                Dimension size = decoration.getSize();
                Point position = new Point(x, y - size.height / 4);
                getParent().setConstraint(decoration, new Rectangle(position, size));
                x += size.width + decorationSpace;
            }
            else {
                getParent().setConstraint(decoration, decoration.computeNewPosition(bounds));
            }
        }
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        for(IDecoration decoration: decorations)
            addDecorationToParent(decoration);
    }
    
    @Override
    public void removeNotify() {
        for(IDecoration decoration: decorations)
            removeDecorationFromParent(decoration);
        super.removeNotify();
    }
    
    @Override
    protected void fireFigureMoved() {
        moveDecorations();
        super.fireFigureMoved();
    }
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        
        graphics.setBackgroundColor(highlighted ? hightlightColor : getBackgroundColor());
        graphics.setForegroundColor(getForegroundColor());
        
        Rectangle rect = getBounds().getCopy().resize(-1, -1);
        graphics.fillRoundRectangle(rect, arcRadius, arcRadius);
        graphics.drawRoundRectangle(rect, arcRadius, arcRadius);
        
        super.paint(graphics);
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
        String text = getText();
        int safeBorderWidth = 1;
        if ((text != null)) {
            Font font = getFont();
            if (font != null) {
                Dimension minSize = FigureUtilities.getTextExtents(text, font);
                if (getIcon() != null) {
                    org.eclipse.swt.graphics.Rectangle imageRect = getIcon().getBounds();
                    int expandHeight = Math.max(imageRect.height - minSize.height, 0);
                    minSize.expand(imageRect.width + 4, expandHeight);
                }
                minSize.expand(10 + (2 * safeBorderWidth), 4 + (2 * safeBorderWidth));
                setBounds(new Rectangle(getLocation(), minSize));
            }
        }
    }
        
}
