package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class ConstraintFigure extends NodeFigure {

    public ConstraintFigure(Constraint constraint) {
        setFont(DrawConstantans.ITALIC_FONT);
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawConstantans.CONSTRAINT_COLOR);
        setHightlightColor(DrawConstantans.CONSTRAINT_LIGHTER_COLOR);
        setBorderStyle(SWT.LINE_CUSTOM);
        setBorderDash(DrawConstantans.LINE_DASHED);
        setText(constraint.getValue());
        setToolTipText(constraint.getDescription());
    }

}
