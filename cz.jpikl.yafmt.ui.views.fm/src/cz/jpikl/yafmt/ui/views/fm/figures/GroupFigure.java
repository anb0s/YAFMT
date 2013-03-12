package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class GroupFigure extends NodeFigure {

    public GroupFigure(Group group) {
        setFont(DrawConstantans.ITALIC_FONT);
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawConstantans.GROUP_COLOR);
        setHightlightColor(DrawConstantans.GROUP_HL_COLOR);
        setBorderStyle(SWT.LINE_CUSTOM);
        setBorderDash(DrawConstantans.LINE_DASHED);
        setText(createCardinalityText(group) + " Group");
    }
    
    private String createCardinalityText(Group group) {
        if(group.isOr())
            return "OR";
        else if(group.isXor())
            return "XOR";
        else
            return FeatureModelUtil.getCardinality(group);
    }

}
