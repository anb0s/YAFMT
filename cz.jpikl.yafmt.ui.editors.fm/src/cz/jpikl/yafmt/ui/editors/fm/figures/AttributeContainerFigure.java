package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ToolbarLayout;

public class AttributeContainerFigure extends Figure {
    
    public AttributeContainerFigure() {
        ToolbarLayout layout = new ToolbarLayout(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        layout.setSpacing(1);
        setLayoutManager(layout);
    }
                
}
