package cz.jpikl.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenConstraintDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenGroupDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenNeighborsDecoration;
import cz.jpikl.yafmt.ui.views.fm.util.GraphStyleProvider;

public class FeatureModelStyleProvider extends GraphStyleProvider {

    private GraphViewer viewer;
    private ViewerFilter[] filters;
    private ConstraintCache constraintCache;
    private Color lightRedColor;

    public FeatureModelStyleProvider(GraphViewer viewer, ConstraintCache constraintCache) {
        this.viewer = viewer;
        this.constraintCache = constraintCache;
        this.lightRedColor = new Color(Display.getCurrent(), 255, 192, 192);
        hook(viewer.getGraphControl());
    }
    
    @Override
    public void dispose() {
        HiddenNeighborsDecoration.disposeFonts();
        lightRedColor.dispose();
        super.dispose();
    }
        
    // =============================================================
    // Node style
    // =============================================================

    @Override
    public String getText(Object element) {
        if(element instanceof Feature) {
            return ((Feature) element).getName();
        }
        if(element instanceof Group) {
            Group group = (Group) element;
            if(group.isOr())
                return "OR Group";
            if(group.isXor())
                return "XOR Group";
            return FeatureModelUtil.getCardinality(group) + " Group";
        }
        if(element instanceof Constraint) {
            return ((Constraint) element).getValue();
        }
        return null;
    }
    
    @Override
    public IFigure getTooltip(Object entity) {
        if(entity instanceof Feature) {
            Feature feature = (Feature) entity;
            String id = feature.getId();
            String description = feature.getDescription();
            if((description != null) && !description.isEmpty())
                return new Label(id + " - " + description);
            else
                return new Label(id);
        }
        if(entity instanceof Constraint) {
            String description = ((Constraint) entity).getDescription();
            if((description != null) && !description.isEmpty())
                return new Label(description);
            else
                return null;
        }
        return null;
    }
    
    @Override
    public Color getBackgroundColour(Object element) {
        return ColorConstants.white;
    }
    
    @Override
    public Color getForegroundColour(Object element) {
        if(element instanceof Feature)
            return ColorConstants.darkBlue;
        if(element instanceof Group)
            return ColorConstants.darkGray;
        return ColorConstants.red;
    }

    @Override
    public Color getNodeHighlightColor(Object element) {
        if(element instanceof Feature)
            return ColorConstants.lightBlue;
        if(element instanceof Group)
            return ColorConstants.lightGray;
        return lightRedColor;
    }
    
    @Override
    public int getBorderWidth(Object entity) {
        return 1;
    }

    @Override
    public Color getBorderColor(Object element) {
        if(element instanceof Feature)
            return ColorConstants.darkBlue;
        if(element instanceof Group)
            return ColorConstants.darkGray;
        return ColorConstants.red;
    }

    @Override
    public Color getBorderHighlightColor(Object element) {
        if(element instanceof Feature)
            return ColorConstants.darkBlue;
        if(element instanceof Group)
            return ColorConstants.darkGray;
        return ColorConstants.red;
    }
  
    @Override
    public int getConnectionStyle(Object src, Object dst) {
        if((src instanceof Feature) && (dst instanceof Feature)) {
            EObject dstParent = ((Feature) dst).getParent();
            if(dstParent instanceof Group)
                dstParent = ((Group) dstParent).getParent();
            return (src == dstParent) ? ZestStyles.CONNECTIONS_DIRECTED : ZestStyles.NONE;
        }
        return ZestStyles.CONNECTIONS_DASH;
    }
    
    // =============================================================
    // Connection style
    // =============================================================
    
    @Override
    public int getLineWidth(Object src, Object dest) {
        return 1;
    }
    
    @Override
    public Color getColor(Object src, Object dst) {
        if((src instanceof Feature) && (dst instanceof Feature))
            return ColorConstants.darkBlue;
        if((src instanceof Group) || (dst instanceof Group))
            return ColorConstants.darkGray;
        return ColorConstants.red;
    }

    @Override
    public Color getHighlightColor(Object src, Object dst) {
        return getColor(src, dst);
    }

    // =============================================================
    // Node decorations
    // =============================================================
    
    @Override
    protected IFigure[] getDecorations(Object element) {
        if(!(element instanceof Feature))
            return null;
        
        Feature feature = (Feature) element;
        List<IFigure> decorations = new ArrayList<IFigure>(3);
        
        int hiddenNeighbors = countHiddenNeighbors(feature);
        if(hiddenNeighbors > 0)
            decorations.add(new HiddenNeighborsDecoration(hiddenNeighbors));
        
        if(isHiddenGroup(feature))
            decorations.add(new HiddenGroupDecoration());
        
        if(isHiddenConstraint(feature))
            decorations.add(new HiddenConstraintDecoration());
        
        return decorations.isEmpty() ? null : decorations.toArray(new Figure[decorations.size()]);
    }
    
    private int countHiddenNeighbors(Feature feature) {
        int hiddenNeighbors = 0;
        
        Object parent = feature.getParent();
        if(parent instanceof Group)
            parent = ((Group) parent).getParent();
        if(isFiltered(parent))
            hiddenNeighbors++;
        
        for(Feature child: feature.getFeatures()) {
            if(isFiltered(child))
                hiddenNeighbors++;
        }
        
        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures()) {
                if(isFiltered(child))
                    hiddenNeighbors++;
            }
        }
        
        return hiddenNeighbors;
    }
    
    private boolean isHiddenGroup(Feature feature) {
        Group parentGroup = feature.getParentGroup();
        return (parentGroup != null) && isFiltered(parentGroup);
    }

    private boolean isHiddenConstraint(Feature feature) {
        Collection<Constraint> constraints = constraintCache.getConstraintsAffectingFeature(feature);
        if((constraints == null) || constraints.isEmpty())
            return false;
        
        for(Constraint constraint: constraints) {
            if(isFiltered(constraint))
                return true;
        }
        return false;
    }
    
    private boolean isFiltered(Object element) {
        if(filters == null)
            filters = viewer.getFilters();
        
        for(ViewerFilter filter: filters) {
            if(!filter.select(viewer, viewer.getInput(), element))
                return true;
        }
        
        return false;
    }
    
}
