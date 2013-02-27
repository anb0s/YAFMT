package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fm.Constraint;

public class ConstraintFigure extends DecoratableNodeFigure {

    private static final Color LIGHT_RED_COLOR = new Color(Display.getCurrent(), 255, 192, 192);
    
    public ConstraintFigure(Constraint constraint) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(ColorConstants.red);
        setHightlightColor(LIGHT_RED_COLOR);
        setText(constraint.getValue());
        
        String description = constraint.getDescription();
        if((description != null) && !description.isEmpty())
            setToolTipText(description);
    }
    
}
