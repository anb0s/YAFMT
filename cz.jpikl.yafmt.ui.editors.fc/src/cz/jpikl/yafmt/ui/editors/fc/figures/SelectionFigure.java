package cz.jpikl.yafmt.ui.editors.fc.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.util.DrawConstantans;
import cz.jpikl.yafmt.ui.util.DrawUtil;

public class SelectionFigure extends RoundedRectangle {
    
    private static final int MIN_WIDTH = 100;
    private static final int MIN_HEIGHT = 25;

    private Label label;
    private Selection selection;

    public SelectionFigure(Selection selection) {
        this.selection = selection;

        setLayoutManager(new GridLayout());
        setSize(-1, -1);
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setHighlighted(false);
        setToolTip(createToolTip());
        add(createLabel(), new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    
    private Label createLabel() {
        label = new Label();
        label.setFont(DrawConstantans.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        label.setText(selection.getName());
        return label;
    }
    
    private Label createToolTip() {
        Label toolTip = new Label();
        String id = selection.getId();
        String description = selection.getDescription();
        
        if((description != null) && !description.isEmpty())
            toolTip.setText(id + " - " + description);
        else
            toolTip.setText(id);
        
        return toolTip;
    }
        
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }
        
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixZoomedFigureLocation(graphics);
        label.setForegroundColor(computeForgroundColor());
        super.paint(graphics);
    }

    @Override
    protected void fillShape(Graphics graphics) {
        Pattern pattern = createPattern(graphics);
        if(pattern != null)
            graphics.setBackgroundPattern(pattern);
            
        super.fillShape(graphics);
        
        if(pattern != null) {
            graphics.setBackgroundPattern(null);
            pattern.dispose();
        }
    }
        
    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.setForegroundColor(computeForgroundColor());
        if(!selection.isEnabled())
            drawCross(graphics);
        super.outlineShape(graphics);
    }
    
    private Color computeForgroundColor() {
        return selection.isPresent() ? ColorConstants.black : ColorConstants.lightGray;
    }
    
    private void drawCross(Graphics graphics) {
        Rectangle rect = bounds.getCopy().shrink(2, 2);
        graphics.setLineStyle(SWT.LINE_CUSTOM);
        graphics.setLineDash(DrawConstantans.LINE_DASHED);
        graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
        graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
    }

    private Pattern createPattern(Graphics graphics) {
        if(!selection.isPresent())
            return null;
        
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        double scale = graphics.getAbsoluteScale();

        // Apply scale.
        int topX = (int) (scale * top.x);
        int topY = (int) (scale * top.y);
        int bottomX = (int) (scale * bottom.x);
        int bottomY = (int) (scale * bottom.y);

        return new Pattern(Display.getCurrent(), topX, topY, bottomX, bottomY, DrawConstantans.FEATURE_GRADIENT_COLOR, ColorConstants.white);
    }

}
