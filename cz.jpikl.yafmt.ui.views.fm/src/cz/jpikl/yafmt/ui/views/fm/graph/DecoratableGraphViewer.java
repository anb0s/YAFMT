package cz.jpikl.yafmt.ui.views.fm.graph;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;

import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;

public class DecoratableGraphViewer extends GraphViewer {

    public static final int BACK_DECORATION_LAYER_INDEX = 0;
    public static final int ZEST_LAYER_INDEX = 1;
    public static final int FRONT_DECORATION_LAYER_INDEX = 2;
        
    private List<NodeFigure> highlightedFigures = new ArrayList<NodeFigure>();
    
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
    protected void firePostSelectionChanged(SelectionChangedEvent event) {
        refreshHightlight();
        super.firePostSelectionChanged(event);
    }
        
    public void refreshHightlight() {
        // Hide old selection.
        for(NodeFigure figure: highlightedFigures)
            figure.setHighlighted(false);
        highlightedFigures.clear();
        
        // Show new selection.
        for(Object node: graph.getSelection()) {
            if(node instanceof GraphNode) {
                IFigure figure = ((GraphNode) node).getNodeFigure();
                if(figure instanceof NodeFigure) {
                    ((NodeFigure) figure).setHighlighted(true);
                    highlightedFigures.add((NodeFigure) figure);
                }
            }
        }
    }
    
    public void moveViewportToSelection(ISelection selection) {
        if(selection.isEmpty())
            return;
        
        // Zoom to the last selected object
        Object[] objects = ((IStructuredSelection) selection).toArray();
        for(int i = objects.length - 1; i >= 0 ; i--) {
            GraphItem item = findGraphItem(objects[i]);
            if(item instanceof GraphNode) {
                Point p = ((GraphNode) item).getLocation();
                Viewport vp = graph.getViewport();
                vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
                return;
            }
        }
    }

}
