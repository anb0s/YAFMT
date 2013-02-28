package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutItem;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import cz.jpikl.yafmt.model.fm.Feature;

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
        
        return new LayoutAlgorithm[] { radialLayoutAlgorithm, springLayoutAlgorithm };
    }
    
    public FeatureModelLayoutAlgorithm() {
        super(createAlgorithms());
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
