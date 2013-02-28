package cz.jpikl.yafmt.ui.views.fm.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.ui.views.fm.figures.IFigureWithAlpha;

public class GraphAnimator extends LayoutAnimator {

    private static final GraphAnimator INSTANCE = new GraphAnimator();
        
    public static void hook(IFigure figure) {
        figure.addLayoutListener(INSTANCE.internalLayoutListener);
    }
    
    public static void unhook(IFigure figure) {
        figure.removeLayoutListener(INSTANCE.internalLayoutListener);
    }
    
    private InternalLayoutListener internalLayoutListener = new InternalLayoutListener();
    private Set<IFigure> newlyAddedFigures = new HashSet<IFigure>();
    private Map<Connection, Color> connectionCurrentColors = new HashMap<Connection, Color>();
    private Map<Connection, Color> connectionFinalColors = new HashMap<Connection, Color>();
    
    @Override
    public void playbackStarting(IFigure container) {
        Map<?, ?> initialState = (Map<?, ?>) Animation.getInitialState(this, container);
        
        // Place newly added node figures immediately to the final position. 
        for(Object child: container.getChildren()) {
            Rectangle initialBounds = (Rectangle) initialState.get(child); 
            if((initialBounds != null) && (initialBounds.x == 0) && (initialBounds.y == 0)) {
                Rectangle finalBounds = (Rectangle) container.getLayoutManager().getConstraint((IFigure) child);
                if(finalBounds != null) {
                    initialBounds.x = finalBounds.x;
                    initialBounds.y = finalBounds.y;
                    newlyAddedFigures.add((IFigure) child);
                }
            }
        }
   
        // Remember connections to newly added nodes.
        for(Object child: container.getChildren()) {
            if(child instanceof Connection) {
                Connection connection = (Connection) child;
                IFigure source = connection.getSourceAnchor().getOwner();
                IFigure target = connection.getTargetAnchor().getOwner();
                if(newlyAddedFigures.contains(source) || newlyAddedFigures.contains(target))
                    connectionFinalColors.put(connection, connection.getForegroundColor());
            }
        }
    }
    
    @Override
    protected boolean playback(IFigure container) {
        animateAlpha(container);
        return super.playback(container);
    }
    
    private void animateAlpha(IFigure container) {
        float progress = Animation.getProgress();
        int alpha = (int) (255 * progress);
        
        for(Object child: container.getChildren()) {
            if((child instanceof IFigureWithAlpha) && newlyAddedFigures.contains(child)) {
                ((IFigureWithAlpha) child).setAlpha(alpha);
            }
            else if(child instanceof Connection) {
                Color finalColor = connectionFinalColors.get(child);
                if(finalColor == null)
                    continue;
                
                int r = finalColor.getRed();
                int g = finalColor.getGreen();
                int b = finalColor.getBlue();
                
                r = 255 - (int) ((255 - r) * progress);
                g = 255 - (int) ((255 - g) * progress);
                b = 255 - (int) ((255 - b) * progress);
                
                // Dispose previously used color.
                Color currentColor = connectionCurrentColors.get(child);
                if(currentColor != null)
                    currentColor.dispose();
                
                currentColor = new Color(Display.getDefault(), r, g, b);
                connectionCurrentColors.put((Connection) child, currentColor);
                ((Connection) child).setForegroundColor(currentColor);
            }
        }
    }

    @Override
    public void tearDown(IFigure figure) {
        if(newlyAddedFigures.isEmpty())
            return;
        
        // Dispose temporary colors and use the original ones.
        for(Map.Entry<Connection, Color> entry: connectionCurrentColors.entrySet()) {
            Color color = entry.getValue();
            if(color != null)
                color.dispose();
            
            Connection connection = entry.getKey();
            connection.setForegroundColor(connectionFinalColors.get(connection));
        }
        
        newlyAddedFigures.clear();
        connectionCurrentColors.clear();
        connectionFinalColors.clear();
    }
    
    public void processConstraintChange(IFigure child, Object constraint) {
        // Hide newly created node and connection figures.
        // Otherwise there is ugly effect when figure is displayed in top left corner.
        if(child instanceof Connection) {
            Connection connection = (Connection) child;
            connection.setVisible(false);
            connection.getSourceAnchor().addAnchorListener(new ConnectionVisibilityEnabler(connection));
        }
        else {
            Rectangle bounds = (Rectangle) constraint;
            child.setVisible((bounds != null) && (bounds.x != 0));
        }
    }
    
    private class InternalLayoutListener extends LayoutListener.Stub {
        
        @Override
        public void setConstraint(IFigure child, Object constraint) {
            processConstraintChange(child, constraint);
        }
        
        @Override
        public void invalidate(IFigure container) {
            GraphAnimator.this.invalidate(container);
        }
        
        @Override
        public boolean layout(IFigure container) {
            return GraphAnimator.this.layout(container);
        }
        
        @Override
        public void postLayout(IFigure container) {
            GraphAnimator.this.postLayout(container);
        }
        
    }
        
    private static class ConnectionVisibilityEnabler implements AnchorListener {

        private Connection connection;
                
        public ConnectionVisibilityEnabler(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void anchorMoved(ConnectionAnchor anchor) {
            connection.setVisible(true);
            anchor.removeAnchorListener(this);
        }
        
    }
    
}
