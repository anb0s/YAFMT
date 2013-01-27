package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class ConnectionFigure extends PolylineConnection {
    
    private CircleDecoration decoration;
    
    public ConnectionFigure(boolean mandatoryTarget) {
        decoration = new CircleDecoration(mandatoryTarget);
        setSourceDecoration(decoration);
    }
    
    public void highlight(boolean value) {
        setLineWidth(value ? 2 : 1);
    }
    
    public void setMandatoryTarget(boolean mandatoryTarget) {
        decoration.setFilled(mandatoryTarget);
    }
    
    private static class CircleDecoration extends Ellipse implements RotatableDecoration {
    
        private static final int SIZE = 10;
        
        public CircleDecoration(boolean filled) {
            setForegroundColor(ColorConstants.black);
            setFilled(filled);
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
