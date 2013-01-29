package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

public class FeatureFigure extends RoundedRectangle {
    
    public static final int WIDTH = 100;
    public static final int HEGHT = 25;

    private Label label = new Label();
    
    public FeatureFigure(String featureName) {
        add(label);
        setLayoutManager(new BorderLayout());
        setConstraint(label, BorderLayout.CENTER);
        updateLabel(featureName);
    }
    
    public void updateLabel(String featurename) {
        label.setText(featurename);
    }
    
    public Label getLabel() {
        return label;
    }
    
    @Override
    protected void fillShape(Graphics graphics) {
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        
        Color lightBlue = new Color(Display.getCurrent(), 175, 201, 235);
        Pattern pattern = new Pattern(Display.getCurrent(), top.x, top.y, bottom.x, bottom.y, lightBlue, ColorConstants.white);
        
        graphics.setBackgroundPattern(pattern);
        super.fillShape(graphics);
        graphics.setBackgroundPattern(null);
        
        pattern.dispose();
        lightBlue.dispose();
    }
        
}
