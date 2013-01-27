package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

import cz.jpikl.yafmt.model.fm.Feature;

public class ConnectionFigure extends PolylineConnection {
    
    private CircleDecoration decoration = new CircleDecoration();;
    private Label label = new Label();
    
    public ConnectionFigure(Feature feature) {
        ConnectionEndpointLocator locator = new ConnectionEndpointLocator(this, false);
        locator.setUDistance(4);
        locator.setVDistance(16);
        add(label, locator);
        updateDecoration(feature);
    }
    
    public void setHighlighted(boolean value) {
        setLineWidth(value ? 2 : 1);
    }
    
    public void updateDecoration(Feature feature) {
        if(feature.isClonable()) {
            setSourceDecoration(null);
            int lower = feature.getLower();
            int upper = feature.getUpper();
            label.setText("[" + lower + ".." + ((upper == -1) ? "*" : upper) + "]");
        }
        else {
            setSourceDecoration(decoration);
            decoration.setFilled(feature.isMandatory());
            label.setText(null);
        }
    }
    
    private static class CircleDecoration extends Ellipse implements RotatableDecoration {
    
        private static final int SIZE = 10;
        
        public CircleDecoration() {
            setForegroundColor(ColorConstants.black);
            setSize(SIZE, SIZE);
        }
        
        public void setFilled(boolean filled) {
            setBackgroundColor(filled ? ColorConstants.black : ColorConstants.white);
        }
        
        @Override
        public void setReferencePoint(Point ref) {
            Point a = getLocation().getCopy();
            Point ab = ref.getTranslated(a.getNegated());
            int diameter = getSize().height;
            PrecisionPoint center = new PrecisionPoint();
  
            center.setPreciseX(a.x + (ab.x * diameter) / (2. * Math.sqrt(ab.x * ab.x + ab.y * ab.y)) - diameter / 2.0);
            center.setPreciseY(a.y + (ab.y * diameter) / (2. * Math.sqrt(ab.x * ab.x + ab.y * ab.y)) - diameter / 2.0);
  
            center.x = (int) Math.round(center.preciseX());
            center.y = (int) Math.round(center.preciseY());
  
            if ((ab.x * diameter) / (2. * Math.sqrt(ab.x * ab.x + ab.y * ab.y)) < 0)
                center.x++;
            if ((ab.y * diameter) / (2. * Math.sqrt(ab.x * ab.x + ab.y * ab.y)) < 0)
                center.y++;
  
            setLocation(center);
        }
    
    }

}
