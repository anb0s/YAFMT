package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenConstraintDecoration;

public class FeatureFigure extends DecoratableNodeFigure {

    public FeatureFigure(Feature feature) {
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(ColorConstants.darkBlue);
        setHightlightColor(ColorConstants.lightBlue);
        setText(feature.getName());
        
        String id = feature.getId();
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            setToolTipText(id + " - " + description);
        else
            setToolTipText(id);
        
        addDecoration(new HiddenConstraintDecoration());
    }
    
}
