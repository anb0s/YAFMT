package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.util.DrawUtil;

public class FeatureFigure extends DecoratableNodeFigure {

    public FeatureFigure(Feature feature) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawUtil.FEATURE_COLOR);
        setHightlightColor(DrawUtil.FEATURE_LIGHTER_COLOR);
        setText(feature.getName());
        setToolTipText(createToolTipText(feature));
    }
    
    private String createToolTipText(Feature feature) {
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            return feature.getId() + " - " + description;
        else
            return feature.getId();
    }

}
