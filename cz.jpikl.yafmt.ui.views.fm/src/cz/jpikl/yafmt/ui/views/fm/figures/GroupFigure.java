package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

public class GroupFigure extends NodeFigure {

    public GroupFigure(Group group) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(ColorConstants.darkGray);
        setHightlightColor(ColorConstants.lightGray);
        setText(FeatureModelUtil.getCardinality(group) + " Group");
    }
    
}
