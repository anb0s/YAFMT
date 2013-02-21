package cz.jpikl.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.views.fm.filters.ConstraintFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.DistanceFilter;
import cz.jpikl.yafmt.ui.views.fm.filters.GroupFilter;
import cz.jpikl.yafmt.ui.views.fm.util.GraphDecorator;

public class FeatureModelDecorator extends GraphDecorator {
    
    private Font smallFont;
    private Image constraintImage;
    private Image groupImage;

    private ConstraintCache constraintCache;
    private ConstraintFilter constraintFilter;
    private GroupFilter groupFilter;
    private DistanceFilter distanceFilter;
            
    public FeatureModelDecorator() {
        constraintImage = FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("constraint-decoration");
        groupImage = FeatureModelVisualizerPlugin.getDefault().getImageRegistry().get("group-decoration");
    }
    
    @Override
    public void dispose() {
        if(smallFont != null)
            smallFont.dispose();
        super.dispose();
    }
    
    public void setConstraintFilter(ConstraintFilter constraintFilter) {
        this.constraintFilter = constraintFilter;
    }
    
    public void setGroupFilter(GroupFilter groupFilter) {
        this.groupFilter = groupFilter;
    }
    
    public void setDistanceFilter(DistanceFilter distanceFilter) {
        this.distanceFilter = distanceFilter;
    }
    
    public void setConstraintCache(ConstraintCache constraintCache) {
        this.constraintCache = constraintCache;
    }
    
    @Override
    protected IFigure[] getDecorations(Object element) {
        if(!(element instanceof Feature))
            return null;
        
        Feature feature = (Feature) element;
        List<IFigure> decorations = new ArrayList<IFigure>(3);
        
        int hiddenNeightbors = countHiddenNeighbors(feature);
        if(hiddenNeightbors > 0)
            decorations.add(new NumberDecoration(hiddenNeightbors));
        
        if(isHiddenGroup(feature))
            decorations.add(new ImageDecoration(groupImage));
        
        if(isHiddenConstraint(feature))
            decorations.add(new ImageDecoration(constraintImage));
        
        return decorations.isEmpty() ? null : decorations.toArray(new Figure[decorations.size()]);
    }
    
    private int countHiddenNeighbors(Feature feature) {
        int hiddenNeighbors = 0;
        
        Object parent = feature.getParent();
        if(parent instanceof Group)
            parent = ((Group) parent).getParent();
        if(!distanceFilter.select(null, null, parent))
            hiddenNeighbors++;
        
        for(Feature child: feature.getFeatures()) {
            if(!distanceFilter.select(null, null, child))
                hiddenNeighbors++;
        }
        
        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures()) {
                if(!distanceFilter.select(null, null, child))
                    hiddenNeighbors++;
            }
        }
        
        return hiddenNeighbors;
    }
    
    private boolean isHiddenGroup(Feature feature) {
        Group parentGroup = feature.getParentGroup();
        return (parentGroup != null) && !groupFilter.select(null, null, parentGroup);
    }

    private boolean isHiddenConstraint(Feature feature) {
        Collection<Constraint> constraints = constraintCache.getConstraintsAffectingFeature(feature);
        if((constraints == null) || constraints.isEmpty())
            return false;
        
        for(Constraint constraint: constraints) {
            if(!constraintFilter.select(null, null, constraint))
                return true;
        }
        
        return false;
    }
    
    private Font getSmallFont() {
        if(smallFont == null) {
            Display display = Display.getDefault();
            Font systemFont = display.getSystemFont();
            FontData[] fontData = systemFont.getFontData();
            for(FontData data: fontData)
                data.setHeight(8);
            smallFont = new Font(display, fontData);
        }
        return smallFont;
    }
    
    private class NumberDecoration extends Figure {
             
        public NumberDecoration(int number) {
            ToolbarLayout layout = new ToolbarLayout();
            layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
            setLayoutManager(new StackLayout());
            
            Label label = new Label(Integer.toString(number));
            label.setForegroundColor(ColorConstants.white);
            label.setFont(getSmallFont());
            add(label);
            
            setForegroundColor(ColorConstants.white);
            setSize(16, 16);
        }
        
        @Override
        public void paint(Graphics graphics) {
            graphics.setBackgroundColor(ColorConstants.darkBlue);
            graphics.fillOval(bounds.getCopy().resize(-1, -1));
            super.paint(graphics);
        }
        
    }
    
    private static class ImageDecoration extends ImageFigure {
        
        public ImageDecoration(Image image) {
            super(image);
            setSize(16, 16);
        }
        
    }
    
}
