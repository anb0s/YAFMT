package cz.jpikl.yafmt.ui.views.fm.util;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;

public class DecoratableGraphViewer extends GraphViewer {

    public static final int BACK_DECORATION_LAYER_INDEX = 0;
    public static final int FRONT_DECORATION_LAYER_INDEX = 2;
    
    public DecoratableGraphViewer(Composite composite, int style) {
        super(composite, style);
        createDecorationLayers();
    }

    private void createDecorationLayers() {
        IFigure contents = graph.getContents();
        contents.add(createDecorationLayer(), BACK_DECORATION_LAYER_INDEX);
        contents.add(createDecorationLayer(), FRONT_DECORATION_LAYER_INDEX);
    }    
    
    private IFigure createDecorationLayer() {
        FreeformLayer layer = new FreeformLayer();
        layer.setLayoutManager(new FreeformLayout());
        return layer;
    }
    
}
