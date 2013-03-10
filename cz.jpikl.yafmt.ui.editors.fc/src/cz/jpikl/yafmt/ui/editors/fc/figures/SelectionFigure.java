package cz.jpikl.yafmt.ui.editors.fc.figures;

import java.util.List;

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

    private static final int WIDTH = 100;
    private static final int HEIGHT = 25;

    private Label label = new Label();
    private Label toolTip = new Label();

    private Selection selection;
    private String baseDescription;
    private boolean selectionError;

    public SelectionFigure(Selection selection) {
        this.selection = selection;

        setLayoutManager(new GridLayout());
        setToolTip(toolTip);

        label.setFont(DrawConstantans.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        add(label, new GridData(SWT.FILL, SWT.FILL, true, true));

        setSize(-1, -1);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setHighlighted(false);
        initContents();
    }

    private void initContents() {
        String id = selection.getId();
        String description = selection.getDescription();

        if((description != null) && !description.isEmpty())
            baseDescription = id + " - " + description;
        else
            baseDescription = id;

        label.setText(selection.getName());
        toolTip.setText(baseDescription);
    }
    
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }

    public void setErrorMessages(List<String> errorMessages) {
        StringBuilder tooltipBuilder = new StringBuilder(baseDescription);
        selectionError = (errorMessages != null) && !errorMessages.isEmpty();

        if(selectionError) {
            tooltipBuilder.append("\n");
            for(String message: errorMessages)
                tooltipBuilder.append("\n").append(message);
        }

        toolTip.setText(tooltipBuilder.toString());
    }
    
    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixZoomedFigureLocation(graphics);
        super.paint(graphics);
    }

    @Override
    protected void fillShape(Graphics graphics) {
        Color color = ColorConstants.lightGray;
        Pattern pattern = null;

        if(selection.isPresent()) {
            color = ColorConstants.black;
            pattern = createPattern(graphics, DrawConstantans.FEATURE_GRADIENT_COLOR, ColorConstants.white);
        }
                    
        label.setForegroundColor(color);
        graphics.setForegroundColor(color);
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
        if(!selection.isEnabled()) {
            Rectangle rect = bounds.getCopy().shrink(2, 2);
            graphics.setLineStyle(SWT.LINE_CUSTOM);
            graphics.setLineDash(DrawConstantans.LINE_DASHED);
            graphics.drawLine(rect.getTopLeft(), rect.getBottomRight());
            graphics.drawLine(rect.getBottomLeft(), rect.getTopRight());
        }
        
        super.outlineShape(graphics);
    }

    private Pattern createPattern(Graphics graphics, Color topColor, Color bottomColor) {
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        double scale = graphics.getAbsoluteScale();

        // Apply scale.
        int topX = (int) (scale * top.x);
        int topY = (int) (scale * top.y);
        int bottomX = (int) (scale * bottom.x);
        int bottomY = (int) (scale * bottom.y);

        return new Pattern(Display.getCurrent(), topX, topY, bottomX, bottomY, topColor, bottomColor);
    }

}
