package cz.jpikl.yafmt.ui.views.fm.util;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;

import cz.jpikl.yafmt.ui.views.fm.settings.Settings;

public class LayoutAlgorithmWithAnimation extends LayoutAlgorithmAdapter {

    private Graph graph;
    private Settings settings;
    
    public LayoutAlgorithmWithAnimation(Graph graph, Settings settings, int styles) {
        super(styles);
        this.graph = graph;
        this.settings = settings;
        hookGraph();
    }
    
    private IFigure getLayer(int index) {
        return (IFigure) graph.getRootLayer().getChildren().get(index);
    }
    
    private void hookGraph() {
        getLayer(DecoratableGraphViewer.ZEST_LAYER_INDEX).removeLayoutListener(LayoutAnimator.getDefault());
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.ZEST_LAYER_INDEX));
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.BACK_DECORATION_LAYER_INDEX));
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.FRONT_DECORATION_LAYER_INDEX));
    }
    
    @Override
    public synchronized void applyLayout(LayoutEntity[] entitiesToLayout, LayoutRelationship[] relationshipsToConsider, double x, double y, double width, double height, boolean asynchronous, boolean continuous) throws InvalidLayoutConfiguration {
        if(!settings.isAnimationEnabled())
            return;
            
        // We must invalidate layers, so graph animator can capture their state.
        getLayer(DecoratableGraphViewer.BACK_DECORATION_LAYER_INDEX).invalidate();
        getLayer(DecoratableGraphViewer.FRONT_DECORATION_LAYER_INDEX).invalidate();
        
        // Very ugly trick how to change graph animation time.
        // This method is internally called by Graph before it calls Animation.run().
        // If we manage to call Animation.run() before, the second call is discarded
        // and only our call is performed.
        Animation.run(settings.getAnimationTime());
    }
    
}
