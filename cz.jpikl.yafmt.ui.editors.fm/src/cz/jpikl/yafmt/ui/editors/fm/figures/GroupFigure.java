package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.util.AncestorRemover;

public class GroupFigure extends RectangleFigure {

    public static final int SIZE = 40;
    
    private Group group;
    private LayoutData layoutData;
    private Label label;
    
    private double[] connectionAngles;
    private int arcOffset = 0;
    private int arcLength = 0;
    private Rectangle arcBounds = bounds;
    
    public GroupFigure(Group group, LayoutData layoutData) {
        this.group = group;
        this.layoutData = layoutData;
        this.label = new NonInteractiveLabel();
        
        setOpaque(true);
        setForegroundColor(ColorConstants.black);
        addAncestorListener(new AncestorRemover(label));
        updateState();
        updateVisuals();
    }
    
    @Override
    public void paintFigure(Graphics graphics) {
        if(label.getParent() == null) {
            getParent().add(label);
            updateVisuals();
        }
        
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
    
    public void updateState() {
        if(group.isOr()) {
            setBackgroundColor(ColorConstants.black);
            label.setText(null);
        }
        else if(group.isXor()) {
            setBackgroundColor(null);
            label.setText(null);
        }
        else {
            setBackgroundColor(null);
            label.setText(FeatureModelUtil.getCardinality(group));
        }
    }
    
    public void updateVisuals() {
        Rectangle newBounds = layoutData.get(group);
        if(newBounds != null)
            setBounds(newBounds.getCopy());
        
        recomputeArcData();
        repositionLabel();
    }
        
    private void recomputeArcData() {
        List<Feature> features = group.getFeatures();
        int size = features.size();
        
        if(size < 2) {
            arcOffset = 0;
            arcLength = 0;
            arcBounds = bounds;
            return;
        }
                
        connectionAngles = new double[size + 1];
        connectionAngles[size] = Double.MAX_VALUE; 
        Point self = bounds.getCenter(); // Do not get this value from layout data, it could be outdated!
        
        // Get angle of each group-to-feature connection.
        for(int i = 0; i < size; i++) {
            Point target = layoutData.get(features.get(i)).getCenter();
            connectionAngles[i] = getAngle(self, target);
        }
        
        // Sort them and and duplicate the first one.
        Arrays.sort(connectionAngles);
        connectionAngles[size] = connectionAngles[0] + 360.0;
        
        int maxIndex = 0;
        double maxDiff = -1.0;
        
        // Find region with the biggest angle difference.
        for(int i = 0; i < size; i++) {
            double diff = connectionAngles[i + 1] - connectionAngles[i];
            if(diff > maxDiff) {
                maxDiff = diff;
                maxIndex = i;
            }
        }
        
        // Arc is made between connections outside the found region.
        arcOffset = (int) connectionAngles[maxIndex + 1];
        arcLength = (int) (360.0 - (connectionAngles[maxIndex + 1] - connectionAngles[maxIndex]) + 1);
        arcBounds = getOptimizedBounds();
    }
        
    private double getAngle(Point self, Point target) {
        double dx = target.x - self.x;
        double dy = target.y - self.y;

        double result = Math.toDegrees(Math.atan2(-dy, dx));
        return (result < 0.0) ? result + 360.0 : result;
    }

    private Rectangle getOptimizedBounds() {
        // Copied from superclass.
        float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
        int inset1 = (int) Math.floor(lineInset);
        int inset2 = (int) Math.ceil(lineInset);

        Rectangle r = new Rectangle(bounds);
        r.x += inset1;
        r.y += inset1;
        r.width -= inset1 + inset2;
        r.height -= inset1 + inset2;
        return r;
    }
    
    private void repositionLabel() {
        if(label.getText().isEmpty() || label.getParent() == null)
            return;
        
        Dimension size = label.getPreferredSize();
        
        int maxIndex1 = 0;
        int maxIndex2 = 0;
        double maxDiff1 = -1.0;
        double maxDiff2 = -1.0;
        
        // Find region with the 2nd biggest angle difference.
        for(int i = 0; i < (connectionAngles.length - 1); i++) {
            double diff = connectionAngles[i + 1] - connectionAngles[i];
            if(diff > maxDiff1) {
                maxIndex2 = maxIndex1;
                maxDiff2 = maxDiff1;
                maxIndex1 = i;
                maxDiff1 = diff;
            }
            else if(diff > maxDiff2) {
                maxIndex2 = i;
                maxDiff2 = diff;
            }
        }

        // Place the label inside the found region.
        double theta = Math.toRadians((connectionAngles[maxIndex2 + 1] + connectionAngles[maxIndex2]) / 2);
        int x =   (int) (50.0 * Math.cos(theta)) - size.width / 2;
        int y = - (int) (50.0 * Math.sin(theta)) - size.width / 2;
        
        Point position = bounds.getCenter().translate(x, y);
        Rectangle labelBounds = new Rectangle(position, size);
        getParent().setConstraint(label, labelBounds);
    }
    
}
