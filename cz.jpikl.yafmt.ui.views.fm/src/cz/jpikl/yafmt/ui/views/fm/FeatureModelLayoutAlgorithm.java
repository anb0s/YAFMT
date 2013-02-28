package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutItem;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.views.fm.settings.Settings;
import cz.jpikl.yafmt.ui.views.fm.util.LayoutAlgorithmWithAnimation;

public class FeatureModelLayoutAlgorithm extends LayoutAlgorithmWithAnimation {

    private CompositeLayoutAlgorithm algorithm;
    
    public FeatureModelLayoutAlgorithm(GraphViewer viewer, Settings settings) {
        super(viewer.getGraphControl(), settings, ZestStyles.NONE);

        // First algorithm layouts the basic radial tree structure made from feature nodes. 
        // It ignores group and constraint nodes.
        RadialLayoutAlgorithm radialLayoutAlgorithm = new RadialLayoutAlgorithm();
        radialLayoutAlgorithm.setFilter(new FeatureToOthersConnectionFilter());
        
        // Second algorithm repositions group and constraint nodes.
        SpringLayoutAlgorithm springLayoutAlgorithm = new SpringLayoutAlgorithm();
        springLayoutAlgorithm.setFilter(new FeatureToFeatureConnectionFilter());
        springLayoutAlgorithm.setRandom(false);
        
        // Final algorithm.
        algorithm = new CompositeLayoutAlgorithm(new LayoutAlgorithm[] { radialLayoutAlgorithm, springLayoutAlgorithm });
    }

    @Override
    public synchronized void applyLayout(LayoutEntity[] entitiesToLayout, LayoutRelationship[] relationshipsToConsider, double x, double y, double width, double height, boolean asynchronous, boolean continuous) throws InvalidLayoutConfiguration {
        algorithm.applyLayout(entitiesToLayout, relationshipsToConsider, x, y, width, height, asynchronous, continuous);
        super.applyLayout(entitiesToLayout, relationshipsToConsider, x, y, width, height, asynchronous, continuous);
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
