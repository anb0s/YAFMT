package cz.jpikl.yafmt.ui.views.fm.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphNode;

import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;

public class Highlighter {

    private Set<NodeFigure> highlightedFigures = new HashSet<NodeFigure>();
    private Set<Object> highlightedObjects = new HashSet<Object>();
    
    public boolean isHighlighted(Object element) {
        return highlightedObjects.contains(element);
    }
    
    public void update(GraphViewer viewer) {
        unhighlightNodes();
        for(Object object: viewer.getGraphControl().getSelection()) {
            if(object instanceof GraphNode)
                highlightNode((GraphNode) object);
        }
    }
    
    private void unhighlightNodes() {
        for(NodeFigure figure: highlightedFigures)
            figure.setHighlighted(false);
        highlightedFigures.clear();
        highlightedObjects.clear();
    }
    
    private void highlightNode(GraphNode node) {
        IFigure figure = node.getNodeFigure();
        if(figure instanceof NodeFigure) {
            NodeFigure nodeFigure = (NodeFigure) figure;
            nodeFigure.setHighlighted(true);
            highlightedFigures.add(nodeFigure);
            highlightedObjects.add(node.getData());
        }
    }

}
