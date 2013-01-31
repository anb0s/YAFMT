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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.util.DrawConstantans;

public class FeatureFigure extends RoundedRectangle {
    
    public static final int WIDTH = 100;
    public static final int HEGHT = 25;

    public static Rectangle computeBoundsDeltaAddAttribute(Feature feature, Rectangle bounds) {
        Rectangle deltas = new Rectangle();
        deltas.height = (feature.getAttributes().isEmpty()) ? AttributeFigure.EXTENDED_HEIGHT : AttributeFigure.HEIGHT;
        if(bounds.width < AttributeFigure.WIDTH)
            deltas.width = AttributeFigure.WIDTH - bounds.width;
        return deltas;
    }
    
    public static Rectangle computeBoundsDeltaDeleteAttribute(Feature feature) {
        Rectangle deltas = new Rectangle();
        deltas.height = -((feature.getAttributes().size() == 1) ? AttributeFigure.EXTENDED_HEIGHT : AttributeFigure.HEIGHT);
        return deltas;
    }
    
    private Label label = new Label();
    private SeparatorFigure separator;
    private Figure attributes;
    
    public FeatureFigure(String featureName) {
        label.setFont(DrawConstantans.getBoldFont());
        setLayoutManager(new GridLayout());
        add(label, new GridData(SWT.FILL, SWT.FILL, true, true));
        updateLabel(featureName);
    }
    
    public void updateLabel(String featurename) {
        label.setText(featurename);
    }
    
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
    
    public Label getLabel() {
        return label;
    }
        
    @Override
    public void add(IFigure figure, Object constraint, int index) {
        if(figure instanceof AttributeFigure) {
            if(attributes == null) {
                separator = new SeparatorFigure();
                attributes = new AttributeContainerFigure();
                add(separator, new GridData(SWT.FILL, SWT.CENTER, true, false), 1);
                add(attributes, new GridData(SWT.CENTER, SWT.FILL, true, false), 2);
            }
            attributes.add(figure, constraint, index);
        }
        else {
            super.add(figure, constraint, index);
        }
    }
    
    @Override
    public void remove(IFigure figure) {
        if(figure instanceof AttributeFigure) {
            attributes.remove(figure);
            if(attributes.getChildren().isEmpty()) {
                remove(attributes);
                remove(separator);
                attributes = null;
                separator = null;
            }
        }
        else {
            super.remove(figure);
        }
    }
        
    @Override
    protected void fillShape(Graphics graphics) {
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        
        Color bgColor = DrawConstantans.getBackgroundColor();
        Pattern pattern = new Pattern(Display.getCurrent(), top.x, top.y, bottom.x, bottom.y, bgColor, ColorConstants.white);
        
        graphics.setBackgroundPattern(pattern);
        super.fillShape(graphics);
        graphics.setBackgroundPattern(null);
        
        pattern.dispose();
    }

}
