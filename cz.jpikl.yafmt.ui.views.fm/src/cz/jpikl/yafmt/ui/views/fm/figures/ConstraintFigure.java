package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class ConstraintFigure extends NodeFigure {
    
    public ConstraintFigure(Constraint constraint) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(ColorConstants.red);
        setHightlightColor(DrawConstantans.LIGHT_RED_COLOR);
        setText(constraint.getValue());
        
        String description = constraint.getDescription();
        if((description != null) && !description.isEmpty())
            setToolTipText(description);
    }
    
}
