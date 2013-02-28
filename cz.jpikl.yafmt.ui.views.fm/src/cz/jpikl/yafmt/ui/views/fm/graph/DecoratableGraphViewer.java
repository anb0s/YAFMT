package cz.jpikl.yafmt.ui.views.fm.graph;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphNode;

import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;

public class DecoratableGraphViewer extends GraphViewer {

    public static final int BACK_DECORATION_LAYER_INDEX = 0;
    public static final int ZEST_LAYER_INDEX = 1;
    public static final int FRONT_DECORATION_LAYER_INDEX = 2;
        
    public DecoratableGraphViewer(Composite composite, int style) {
        super(composite, style);
        createDecorationLayers();
    }

    private void createDecorationLayers() {
        graph.getRootLayer().add(createDecorationLayer(), BACK_DECORATION_LAYER_INDEX);
        graph.getRootLayer().add(createDecorationLayer(), FRONT_DECORATION_LAYER_INDEX);
    }    
    
    private IFigure createDecorationLayer() {
        FreeformLayer layer = new FreeformLayer();
        layer.setLayoutManager(new FreeformLayout());
        return layer;
    }
    
    @Override
    protected void fireSelectionChanged(SelectionChangedEvent event) {
        setSelectedNodesHighlight(false);
        super.fireSelectionChanged(event);
        setSelectedNodesHighlight(true);
        
    }
    
    @Override
    protected void firePostSelectionChanged(SelectionChangedEvent event) {
        setSelectedNodesHighlight(false);
        super.firePostSelectionChanged(event);
        setSelectedNodesHighlight(true);
    }
        
    private void setSelectedNodesHighlight(boolean highlighted) {
        for(Object node: graph.getSelection()) {
            IFigure figure = ((GraphNode) node).getNodeFigure();
            if(figure instanceof NodeFigure)
                ((NodeFigure) figure).setHighlighted(highlighted);
        }
    }
    
    public void restoreHightlight() {
        setSelectedNodesHighlight(true);
    }
            
}
