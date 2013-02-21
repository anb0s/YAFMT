package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;

public class AttributeContainerFigure extends Figure {
    
    public AttributeContainerFigure() {
        ToolbarLayout layout = new ToolbarLayout(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        layout.setSpacing(2);
        
        setLayoutManager(layout);
        setBorder(new MarginBorder(2, 2, 0, 2));
    }
                
}
