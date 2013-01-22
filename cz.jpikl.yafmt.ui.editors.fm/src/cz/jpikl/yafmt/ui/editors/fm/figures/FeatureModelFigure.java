package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.MarginBorder;

public class FeatureModelFigure extends FreeformLayer {

    public FeatureModelFigure() {
        setBorder(new MarginBorder(3));
        setLayoutManager(new FreeformLayout());
    }
    
}
