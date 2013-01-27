package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.IModelLayoutProvider;

public class GroupFigure extends RectangleFigure {

    private IModelLayoutProvider layoutProvider;
    private Group group;

    private Rectangle arcBounds;
    private int arcOffset;
    private int arcLength;
    
    public GroupFigure(IModelLayoutProvider layoutProvider, Group group) {
        this.layoutProvider = layoutProvider;
        this.group = group;
        
        setOpaque(true);
        setForegroundColor(ColorConstants.black);
        updateState();
    }
    
    public void updateState() {
        setBackgroundColor(group.isOr() ? ColorConstants.black : null);
    }
        
    @Override
    public void paintFigure(Graphics graphics) {
        recomputeArcData();
        super.paintFigure(graphics);
    }
        
    @Override
    protected void fillShape(Graphics graphics) {
        graphics.fillArc(arcBounds, arcOffset, arcLength);
    }
    
    @Override
    protected void outlineShape(Graphics graphics) {
        graphics.drawArc(arcBounds, arcOffset, arcLength);
    }
    
    private void recomputeArcData() {
        List<Feature> features = group.getFeatures();
        int size = features.size();
        if(size < 2)
            return;
        
        double[] angles = new double[size + 1];
        angles[size] = Double.MAX_VALUE; 
        Point self = layoutProvider.getObjectBounds(group).getCenter();
        
        for(int i = 0; i < size; i++) {
            Point target = layoutProvider.getObjectBounds(features.get(i)).getCenter();
            angles[i] = getAngle(self, target);
        }
        
        Arrays.sort(angles);
        angles[size] = angles[0] + 360.0;
        
        double maxDiff = -1.0;
        int maxIndex = 0;
        for(int i = 0; i < size; i++) {
            double diff = angles[i + 1] - angles[i];
            if(diff > maxDiff) {
                maxDiff = diff;
                maxIndex = i;
            }
        }
        
        arcOffset = (int) angles[maxIndex + 1];
        arcLength = (int) (360.0 - (angles[maxIndex + 1] - angles[maxIndex]));
        arcBounds = getOptimizedBounds();
    }
        
    private double getAngle(Point self, Point target) {
        double dx = target.x - self.x;
        double dy = target.y - self.y;

        if(dx > 0.0) {
            if(dy > 0.0)
                return 270 + Math.toDegrees(Math.atan(dx / dy));
            if(dy < 0.0)
                return Math.toDegrees(Math.atan(-dy / dx));
            else
                return 0.0;
        }
        else if(dx < 0.0) {
            if(dy > 0.0)
                return 180.0 + Math.toDegrees(Math.atan(dy / -dx));
            if(dy < 0.0)
                return 90.0 + Math.toDegrees(Math.atan(dx / dy));
            else
                return 180.0;
        }
        else {
            if(dy > 0.0)
                return 270.0;
            if(dy < 0.0)
                return 90.0;
            else
                return 0.0;
        }
    }

    private Rectangle getOptimizedBounds() {
        float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
        int inset1 = (int) Math.floor(lineInset);
        int inset2 = (int) Math.ceil(lineInset);

        Rectangle r = new Rectangle(getBounds());
        r.x += inset1;
        r.y += inset1;
        r.width -= inset1 + inset2;
        r.height -= inset1 + inset2;
        return r;
    }
    
}
