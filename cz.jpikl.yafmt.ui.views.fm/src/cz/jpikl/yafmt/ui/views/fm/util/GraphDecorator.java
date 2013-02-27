package cz.jpikl.yafmt.ui.views.fm.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.zest.core.widgets.Graph;

public abstract class GraphDecorator {

    private static final int DECORATION_SPACE = 1;
    
    private IFigure rootLayer;
    private Map<IFigure, IFigure[]> figureDecorations = new HashMap<IFigure, IFigure[]>();
    private InternalListener internalListener = new InternalListener();
        
    public void hook(Graph graph) {
        unhook();
        rootLayer = (IFigure) graph.getContents().getChildren().get(0); 
        rootLayer.addLayoutListener(internalListener);
        rootLayer.addLayoutListener(ColorAnimator.getDefault());
    }
    
    private void unhook() {
        if(rootLayer == null)
            return;

        //removeDecorations();
        rootLayer.removeLayoutListener(internalListener);
        rootLayer = null;
    }
    
    public void dispose() {
        unhook();
    }
            
    protected abstract IFigure[] getDecorations(Object element);
    
    protected void addDecorations(Object element, IFigure figure) {
        if(figureDecorations.containsKey(figure))
            return;
                
        IFigure[] decorations = getDecorations(element);
        if((decorations == null) || (decorations.length == 0))
            return;
        
        figure.addFigureListener(internalListener);
        figureDecorations.put(figure, decorations);
        for(IFigure decoration: decorations)
            rootLayer.add(decoration);
        
        moveDecorations(figure);
    }
    
    private void removeDecorations() {
        for(Map.Entry<IFigure, IFigure[]> entry: figureDecorations.entrySet()) {
            entry.getKey().removeFigureListener(internalListener);
            for(IFigure decoration: entry.getValue())
                rootLayer.remove(decoration);
        }
        figureDecorations.clear();
    }
    
    private void removeDecorations(IFigure figure) {
        IFigure[] decorations = figureDecorations.remove(figure);
        if(decorations == null)
            return;
        
        figure.removeFigureListener(internalListener);
        for(IFigure decoration: decorations)
            rootLayer.remove(decoration);
    }
    
    private void moveDecorations(IFigure figure) {
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
    }
        
    private class InternalListener implements FigureListener, LayoutListener {

        @Override
        public void figureMoved(IFigure source) {
            //moveDecorations(source);
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
            if(child instanceof Connection) {
                child.setVisible(false);
                final Connection connection = (Connection) child;
                connection.getSourceAnchor().addAnchorListener(new AnchorListener() {
                    @Override
                    public void anchorMoved(ConnectionAnchor anchor) {
                        anchor.removeAnchorListener(this);
                        connection.setVisible(true);
                    }
                });
            }
            else if(constraint instanceof Rectangle) {
                Rectangle rect = (Rectangle) constraint;
                child.setVisible((rect.x != 0) || (rect.y != 0));
            }
            else child.setVisible(false);
        }
        
    }
    
}
