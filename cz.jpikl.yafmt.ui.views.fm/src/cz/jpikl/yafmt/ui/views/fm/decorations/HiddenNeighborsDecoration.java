package cz.jpikl.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class HiddenNeighborsDecoration extends RoundedRectangle implements IDecoration {

    private static final int BORDER_SCALE = 5;
    private static final int GRADIENT_DETAIL = 5;

    private int hiddenNeighborsCount;

    public HiddenNeighborsDecoration(int hiddenNeighborsCount) {
        this.hiddenNeighborsCount = hiddenNeighborsCount;

        setCornerDimensions(new Dimension(15, 15));
        setForegroundColor(DrawConstantans.FEATURE_COLOR);
        setBackgroundColor(DrawConstantans.FEATURE_HL_COLOR);

        if(hiddenNeighborsCount > 1)
            setToolTip(new Label("Feature has " + hiddenNeighborsCount + " hidden neighbors."));
        else
            setToolTip(new Label("Feature has a hidden neighbor."));
        
        setLineStyle(SWT.LINE_CUSTOM);
        setLineDash(DrawConstantans.LINE_DOTTED);
    }
    
    @Override
    public boolean isAutoPositioned() {
        return false;
    }

    @Override
    public boolean isOnTop() {
        return false;
    }

    private int computeAlpha() {
        Integer alpha = getAlpha();
        return (alpha != null) ? alpha : 255;  
    }
    
    private int computeBorder() {
        return hiddenNeighborsCount * BORDER_SCALE;
    }
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int border = computeBorder();
        return parentBounds.getCopy().expand(border, border);
    }
    
    @Override
    protected void fillShape(Graphics graphics) {
        graphics.setAlpha(computeAlpha() / (2 * GRADIENT_DETAIL));
        
        int shinkStep = computeBorder() / GRADIENT_DETAIL;
        Rectangle rect = bounds.getCopy();
        Dimension corner = getCornerDimensions();
        
        for(int i = 0; i < GRADIENT_DETAIL; i++) {
            graphics.fillRoundRectangle(rect, corner.width, corner.width);
            rect.shrink(shinkStep, shinkStep);
        }
    }
    
    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.setAlpha(computeAlpha() / 2);
        super.outlineShape(graphics);
    }

}
