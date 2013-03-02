package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PolylineConnection;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class ConnectionFigure extends PolylineConnection {
    
    private CircleDecoration circleDecoration = new CircleDecoration();
    private SquareDecoration squareDecoration = new SquareDecoration();
    private Label label = new Label();
    
    private Connection connection;
    
    public ConnectionFigure(Connection connection) {
        this.connection = connection;
        
        label.setForegroundColor(ColorConstants.black);
        add(label, createLabelLocator());
        setForegroundColor(ColorConstants.black);
        refresh();
    }
    
    private Locator createLabelLocator() {
        ConnectionEndpointLocator locator = new ConnectionEndpointLocator(this, false);
        locator.setUDistance(4);
        locator.setVDistance(16);
        return locator;
    }
        
    public void refresh() {
        Feature target = connection.getTarget();
        
        if(target.isCloneable()) {
            setSourceDecoration(null);
            label.setText(FeatureModelUtil.getCardinality(target));
        }
        else {
            if(target.getParentGroup() != null) {
                squareDecoration.setFilled(target.isMandatory());
                setSourceDecoration(squareDecoration);
            }
            else {
                circleDecoration.setFilled(target.isMandatory());
                setSourceDecoration(circleDecoration);
            }
            label.setText(null);
        }
    }
    
    public void setHighlighted(boolean highlighted) {
        setLineWidth(highlighted ? 2 : 1);
    }

}
