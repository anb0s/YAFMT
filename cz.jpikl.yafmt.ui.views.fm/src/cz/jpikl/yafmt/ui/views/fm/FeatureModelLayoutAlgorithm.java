package cz.jpikl.yafmt.ui.views.fm;

import java.util.Map;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutItem;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;
import cz.jpikl.yafmt.ui.views.fm.settings.Settings;
import cz.jpikl.yafmt.ui.views.fm.util.ColorAnimator;

public class FeatureModelLayoutAlgorithm extends CompositeLayoutAlgorithm {

    private static LayoutAlgorithm[] createAlgorithms() {
        // First algorithm layouts the basic radial tree structure made from feature nodes. 
        // It ignores group and constraint nodes.
        RadialLayoutAlgorithm radialLayoutAlgorithm = new RadialLayoutAlgorithm();
        radialLayoutAlgorithm.setFilter(new FeatureToOthersConnectionFilter());
        
        // Second algorithm repositions group and constraint nodes.
        SpringLayoutAlgorithm springLayoutAlgorithm = new SpringLayoutAlgorithm();
        springLayoutAlgorithm.setFilter(new FeatureToFeatureConnectionFilter());
        springLayoutAlgorithm.setRandom(false);
        
        // Compose layout algorithm from the previous two.
        return new LayoutAlgorithm[] { radialLayoutAlgorithm, springLayoutAlgorithm };
    }
    
    private Settings settings;
    private Graph graph;
    
    public FeatureModelLayoutAlgorithm(GraphViewer viewer, Settings settings) {
        super(LayoutStyles.NO_LAYOUT_NODE_RESIZING, createAlgorithms());
        this.graph = viewer.getGraphControl();
        this.settings = settings;
    }
    
    @Override
    public synchronized void applyLayout(LayoutEntity[] entitiesToLayout, LayoutRelationship[] relationshipsToConsider, double x, double y, double width, double height, boolean asynchronous, boolean continuous) throws InvalidLayoutConfiguration {
        super.applyLayout(entitiesToLayout, relationshipsToConsider, x, y, width, height, asynchronous, continuous);
        
        if(settings.isAnimationEnabled())
            repositionNewGraphNodes();
        
        // Very ugly trick how to change graph animation time.
        // This method is internally called by Graph before it calls Animation.run().
        // If we manage to call Animation.run() before, the second call is discarded
        // and only our call is performed.
        if(settings.isAnimationEnabled())
            Animation.run(settings.getAnimationTime());
    }
    
    private void repositionNewGraphNodes() {
        IFigure rootLayer = (IFigure) graph.getRootLayer().getChildren().get(0);
        Map<?, ?> initialStates = (Map<?, ?>) Animation.getInitialState(LayoutAnimator.getDefault(), rootLayer);
        Map initialStates2 = (Map) Animation.getInitialState(ColorAnimator.getDefault(), rootLayer);
        
        for(Object child: rootLayer.getChildren()) {
            if(child instanceof Connection) {
                IFigure o = ((Connection) child).getSourceAnchor().getOwner();
                Rectangle src = (Rectangle) initialStates.get(o);
                if((src != null) && (src.x == 0) && (src.y == 0))
                    initialStates2.put(child, new Object());
                
                o = ((Connection) child).getTargetAnchor().getOwner();
                src = (Rectangle) initialStates.get(o);
                if((src != null) && (src.x == 0) && (src.y == 0))
                    initialStates2.put(child, new Object());
            }
        }
        
        for(Object child: rootLayer.getChildren()) {
            if(child instanceof NodeFigure) {
                NodeFigure figure = (NodeFigure) child;
                Rectangle src = (Rectangle) initialStates.get(figure);
                if((src != null) && (src.x == 0) && (src.y == 0)) {
                    Rectangle dest = (Rectangle) rootLayer.getLayoutManager().getConstraint(figure);
                    if(dest != null) {
                        src.x = dest.x;
                        src.y = dest.y;
                        figure.moveDecorations();
                        for(IFigure dec: figure.getDecorations()) {
                            Rectangle r2 = ((Rectangle) rootLayer.getLayoutManager().getConstraint(dec));
                            Rectangle r1 = (Rectangle) initialStates.get(dec);
                            if(r1 != null && r2 != null) {
                                r1.x = r2.x;
                                r1.y = r2.y;
                            }
                        }
                    }
                    
                    initialStates2.put(figure, new Integer(0));
                }
                
            }
        }
    }
    
    private static abstract class ConnectionFilter implements Filter {
        
        @Override
        public boolean isObjectFiltered(LayoutItem object) {
            Object graphData = object.getGraphData();
            if(!(graphData instanceof GraphConnection))
                return false;
            
            GraphConnection graphConnection = (GraphConnection) graphData;
            Object sourceData = graphConnection.getSource().getData();
            Object destinationData = graphConnection.getDestination().getData();
            return isConnectionFiltered(sourceData, destinationData);
        }

        protected abstract boolean isConnectionFiltered(Object sourceData, Object destinationData);
        
    }
    
    private static class FeatureToFeatureConnectionFilter extends ConnectionFilter {

        @Override
        protected boolean isConnectionFiltered(Object sourceData, Object destinationData) {
            return (sourceData instanceof Feature) && (destinationData instanceof Feature);
        }
        
    }
    
    private static class FeatureToOthersConnectionFilter extends ConnectionFilter {

        @Override
        protected boolean isConnectionFiltered(Object sourceData, Object destinationData) {
            return !(sourceData instanceof Feature) || !(destinationData instanceof Feature);
        }
        
    }
 

}
