package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class GroupFigure extends RectangleFigure {

    public static final int SIZE = 40;
    
    private LayoutData layoutData;
    private Group group;
    private Label label;

    private Rectangle arcBounds;
    private double[] angles;
    private int arcOffset;
    private int arcLength;
    
    public GroupFigure(LayoutData layoutData, Group group) {
        this.layoutData = layoutData;
        this.group = group;
        this.label = new NonInteractiveLabel();
        
        setOpaque(true);
        setForegroundColor(ColorConstants.black);
        updateState();
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
            int lower = group.getLower();
            int upper = group.getUpper();
            label.setText("<" + lower + " -" + ((upper == -1) ? "*" : upper) + ">");
        }
    }
        
    @Override
    public void paintFigure(Graphics graphics) {
        if(label.getParent() == null) {
            getParent().add(label);
            addAncestorListener(new AutoRemover(label));
        }
        
        recomputeArcData();
        repositionLabel();
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
    
    private void repositionLabel() {
        if(label.getText().isEmpty())
            return;
        
        Dimension size = label.getPreferredSize();
        
        int maxIndex = 0;
        int maxIndex2 = 0;
        double maxDiff = -1.0;
        for(int i = 0; i < (angles.length - 1); i++) {
            double diff = angles[i + 1] - angles[i];
            if(diff > maxDiff) {
                maxIndex2 = maxIndex;
                maxIndex = i;
                maxDiff = diff;
            }
        }
        
        double theta = Math.toRadians((angles[maxIndex2 + 1] + angles[maxIndex2]) / 2);
        int x =   (int) (50.0 * Math.cos(theta)) - size.width / 2;
        int y = - (int) (50.0 * Math.sin(theta)) - size.width / 2;
        
        Point position = bounds.getCenter().translate(x, y);
        Rectangle bounds = new Rectangle(position, size);
        getParent().setConstraint(label, bounds);
    }
    
    private void recomputeArcData() {
        List<Feature> features = group.getFeatures();
        int size = features.size();
        if(size < 2)
            return;
        
        angles = new double[size + 1];
        angles[size] = Double.MAX_VALUE; 
        Point self = layoutData.getMapping().get(group).getCenter();
        
        for(int i = 0; i < size; i++) {
            Point target = layoutData.getMapping().get(features.get(i)).getCenter();
            angles[i] = getAngle(self, target);
        }
        
        Arrays.sort(angles);
        angles[size] = angles[0] + 360.0;
        
        int maxIndex = 0;
        double maxDiff = -1.0;
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

        double result = Math.toDegrees(Math.atan2(-dy, dx));
        return (result < 0.0) ? result + 360.0 : result;
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
    
    private static class NonInteractiveLabel extends Label {
        
        @Override
        public IFigure findFigureAt(int x, int y, TreeSearch search) {
            return null;
        }
        
    }
    
    private static class AutoRemover implements AncestorListener {

        private IFigure target;
        
        public AutoRemover(IFigure target) {
            this.target = target;
        }
        
        @Override
        public void ancestorAdded(IFigure ancestor) {
        }

        @Override
        public void ancestorMoved(IFigure ancestor) {
        }

        @Override
        public void ancestorRemoved(IFigure ancestor) {
            IFigure parent = target.getParent();
            if(parent != null)
                parent.remove(target);
        }
        
    }
    
}
