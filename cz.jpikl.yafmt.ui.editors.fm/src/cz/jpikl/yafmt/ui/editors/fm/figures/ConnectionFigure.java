package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

public class ConnectionFigure extends PolylineConnection {
    
    private CircleDecoration decoration = new CircleDecoration();;
    private Label label = new Label();
    
    public ConnectionFigure(Feature target) {
        ConnectionEndpointLocator locator = new ConnectionEndpointLocator(this, false);
        locator.setUDistance(4);
        locator.setVDistance(16);
        add(label, locator);
        updateTargetDecoration(target);
    }
        
    public void updateTargetDecoration(Feature target) {
        if(target.isClonable()) {
            setSourceDecoration(null);
            label.setText(FeatureModelUtil.getCardinality(target));
        }
        else {
            setSourceDecoration(decoration);
            decoration.setFilled(target.isMandatory());
            label.setText(null);
        }
    }
    
    public void setHighlighted(boolean value) {
        setLineWidth(value ? 2 : 1);
    }

}
