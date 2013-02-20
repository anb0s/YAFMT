package cz.jpikl.yafmt.ui.views.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

public abstract class GraphDecorator {

    private static final int DECORATION_SPACE = 1;
    
    private Graph graph;
    private IFigure rootLayer;
    private Map<IFigure, IFigure[]> figureDecorations;
    private InternalListener listener;
    private boolean movingDecorations = false;
    
    
    public GraphDecorator() {
        figureDecorations = new HashMap<IFigure, IFigure[]>();
        listener = new InternalListener();
    }
    
    public void hook(Graph graph) {
        dispose();
        
        this.graph = graph;
        this.graph.addPaintListener(listener);
        rootLayer = (IFigure) graph.getContents().getChildren().get(0); 
        rootLayer.addLayoutListener(listener);
    }
    
    public void dispose() {
        if((graph == null) || graph.isDisposed())
            return;
                
        removeDecorations();
        rootLayer.removeLayoutListener(listener);
        rootLayer = null;
        graph.removePaintListener(listener);
        graph = null;
    }
    
    public void refresh() {
        removeDecorations();
    }
        
    protected abstract IFigure[] getDecorations(Object element);
    
    private Object findElementForFigure(IFigure figure) {
        for(Object node: graph.getNodes()) {
            if(((GraphNode) node).getNodeFigure() == figure)
                return ((GraphNode) node).getData();
        }
        return null;
    }
    
    private void addDecorations(IFigure figure) {
        if(movingDecorations || figureDecorations.containsKey(figure))
            return;
        
        Object element = findElementForFigure(figure);
        if(element == null)
            return;
        
        IFigure[] decorations = getDecorations(element);
        if((decorations == null) || (decorations.length == 0))
            return;
        
        figure.addFigureListener(listener);
        figureDecorations.put(figure, decorations);
        for(IFigure decoration: decorations)
            rootLayer.add(decoration);
        moveDecorations(figure);
    }
    
    private void removeDecorations() {
        for(Map.Entry<IFigure, IFigure[]> entry: figureDecorations.entrySet()) {
            entry.getKey().removeFigureListener(listener);
            for(IFigure decoration: entry.getValue())
                rootLayer.remove(decoration);
        }
        figureDecorations.clear();
    }
    
    private void removeDecorations(IFigure figure) {
        IFigure[] decorations = figureDecorations.remove(figure);
        if(decorations == null)
            return;
        
        figure.removeFigureListener(listener);
        for(IFigure decoration: decorations)
            rootLayer.remove(decoration);
    }
    
    private void moveDecorations(IFigure figure) {
        movingDecorations = true;
        
        IFigure[] decorations = figureDecorations.get(figure);
        if(decorations == null)
            return;
        
        Point bottomLeft = figure.getBounds().getBottomLeft();
        int x = bottomLeft.x - decorations[0].getSize().width / 2;
        int y = bottomLeft.y;
        
        for(IFigure decoration: decorations) {
            Dimension size = decoration.getSize();
            Point position = new Point(x, y - size.height / 4);
            rootLayer.setConstraint(decoration, new Rectangle(position, size));
            x += size.width + DECORATION_SPACE;
        }
        
        movingDecorations = false;
    }
        
    private class InternalListener implements PaintListener, FigureListener, LayoutListener {

        @Override
        public void paintControl(PaintEvent event) {
            //refreshDecorations();
        }

        @Override
        public void figureMoved(IFigure source) {
            moveDecorations(source);
        }

        @Override
        public void invalidate(IFigure container) {
        }

        @Override
        public boolean layout(IFigure container) {
            return false;
        }

        @Override
        public void postLayout(IFigure container) {
        }

        @Override
        public void remove(IFigure child) {
            removeDecorations(child);
        }

        @Override
        public void setConstraint(IFigure child, Object constraint) {
            addDecorations(child);
        }
        
    }
    
}
