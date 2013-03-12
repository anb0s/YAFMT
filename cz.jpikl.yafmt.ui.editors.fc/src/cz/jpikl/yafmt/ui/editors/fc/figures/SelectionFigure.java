package cz.jpikl.yafmt.ui.editors.fc.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.figures.ErrorDecoration;
import cz.jpikl.yafmt.ui.util.DrawConstantans;
import cz.jpikl.yafmt.ui.util.DrawUtil;

public class SelectionFigure extends RoundedRectangle {
    
    private static final int MIN_WIDTH = 100;
    private static final int MIN_HEIGHT = 25;

    private Selection selection;
    private Label label;
    private ErrorDecoration errorDecoration;

    public SelectionFigure(Selection selection) {
        this.selection = selection;

        setLayoutManager(new StackLayout());        
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setSize(-1, -1);
        setHighlighted(false);
        setToolTip(createToolTip());
        
        add(createMainLayer());
        add(createDecorationsLayer());
    }
    
    // =================================================================
    //  Initialization
    // =================================================================

    private IFigure createMainLayer() {
        Figure layer = new Figure();
        layer.setLayoutManager(new GridLayout());
        layer.add(createLabel(), new GridData(SWT.CENTER, SWT.CENTER, true, true));
        return layer;
    }
    
    private Label createLabel() {
        label = new Label();
        label.setFont(DrawConstantans.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        label.setText(selection.getName());
        return label;
    }
    
    private IFigure createDecorationsLayer() {
        Figure layer = new Figure();
        layer.add(createErrorDecoration());
        return layer;
    }
    
    private IFigure createErrorDecoration() {
        errorDecoration = new ErrorDecoration();
        errorDecoration.setLocation(new Point(2, 2));
        return errorDecoration;
    }
    
    private Label createToolTip() {
        return new Label(createToolTipText());
    }
    
    private String createToolTipText() {
        String description = selection.getDescription();
        if((description != null) && !description.isEmpty())
            return selection.getId() + " - " + description;
        else
            return selection.getId();
    }
    
    // =================================================================
    //  Properties
    // =================================================================
        
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }
    
    public void setErrors(List<String> messages) {
        errorDecoration.setErrors(messages);
    }
    
    // =================================================================
    //  Drawing
    // =================================================================
        
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
    
    private void drawCross(Graphics graphics) {
        Rectangle rect = bounds.getCopy().shrink(2, 2);
        graphics.setLineStyle(SWT.LINE_CUSTOM);
        graphics.setLineDash(DrawConstantans.LINE_DASHED);
        graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
        graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
    }
    
    private Color computeForgroundColor() {
        return selection.isPresent() ? ColorConstants.black : ColorConstants.lightGray;
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
