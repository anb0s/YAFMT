package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.util.DrawConstantans;

public class FeatureFigure extends RoundedRectangle {
    
    public static final int WIDTH = 100;
    public static final int HEGHT = 25;
    
    private Label label = new Label();
    private Label toolTip = new Label();
    private SeparatorFigure separator;
    private Figure attributes;
    
    private Feature feature;
    
    public FeatureFigure(Feature feature) {
        this.feature = feature;
        
        setLayoutManager(new GridLayout());
        label.setFont(DrawConstantans.getBoldFont());
        label.setForegroundColor(ColorConstants.black);
        add(label, new GridData(SWT.FILL, SWT.FILL, true, true));
        
        setForegroundColor(ColorConstants.black);
        refresh();
    }
    
    public Label getLabel() {
        return label;
    }
    
    public void refresh() {
        label.setText(feature.getName());
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            toolTip.setText(feature.getId() + " - " + description);
        else
            toolTip.setText(feature.getId());
    }
    
    @Override
    protected void fillShape(Graphics graphics) {
        Pattern pattern = createPattern(graphics, DrawConstantans.getBackgroundColor(), ColorConstants.white);
        graphics.setBackgroundPattern(pattern);
        super.fillShape(graphics);
        graphics.setBackgroundPattern(null);
        pattern.dispose();
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
    
    private void addAttributeFigure(IFigure figure, Object constraint, int index) {
        if(attributes == null) {
            separator = new SeparatorFigure();
            attributes = new AttributeContainerFigure();
            add(separator, new GridData(SWT.FILL, SWT.CENTER, true, false), 1);
            add(attributes, new GridData(SWT.CENTER, SWT.FILL, true, false), 2);
        }
        attributes.add(figure, constraint, index);
    }
    
    private void removeAttributeFigure(IFigure figure) {
        attributes.remove(figure);
        if(attributes.getChildren().isEmpty()) {
            remove(attributes);
            remove(separator);
            attributes = null;
            separator = null;
        }
    }
    
    @Override
    public void add(IFigure figure, Object constraint, int index) {
        if(figure instanceof AttributeFigure)
            addAttributeFigure(figure, constraint, index);
        else
            super.add(figure, constraint, index);
    }
    
    @Override
    public void remove(IFigure figure) {
        if(figure instanceof AttributeFigure)
            removeAttributeFigure(figure);
        else
            super.remove(figure);
    }
    
}
