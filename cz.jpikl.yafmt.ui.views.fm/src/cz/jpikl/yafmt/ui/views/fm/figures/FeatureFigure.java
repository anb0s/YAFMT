package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class FeatureFigure extends DecoratableNodeFigure {

    public FeatureFigure(Feature feature) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawConstantans.FEATURE_COLOR);
        setHightlightColor(DrawConstantans.FEATURE_HL_COLOR);
        setText(feature.getName());

        String id = feature.getId();
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            setToolTipText(id + " - " + description);
        else
            setToolTipText(id);
    }

}
