package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;

public class FeatureFigure extends Label {

    public FeatureFigure(String featureName) {
        super(featureName);
        setBorder(new LineBorder());
        setBackgroundColor(ColorConstants.white);
        setOpaque(true);
    }
    
    public void setFeatureName(String name) {
        setText(name);
    }
    
}
