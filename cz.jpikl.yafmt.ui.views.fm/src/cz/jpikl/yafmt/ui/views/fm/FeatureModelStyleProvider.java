package cz.jpikl.yafmt.ui.views.fm;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangleAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenConstraintDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenGroupDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenNeighborsDecoration;
import cz.jpikl.yafmt.ui.views.fm.figures.ConstraintFigure;
import cz.jpikl.yafmt.ui.views.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.views.fm.figures.GroupFigure;
import cz.jpikl.yafmt.ui.views.fm.figures.NodeFigure;
import cz.jpikl.yafmt.ui.views.fm.util.LabelProviderAdapter;

public class FeatureModelStyleProvider extends LabelProviderAdapter {

    private GraphViewer viewer;
    private ViewerFilter[] filters;
    private ConstraintCache constraintCache;

    public FeatureModelStyleProvider(GraphViewer viewer, ConstraintCache constraintCache) {
        this.viewer = viewer;
        this.constraintCache = constraintCache;
    }
    
    // =============================================================
    // Connections
    // =============================================================
    
    @Override
    public void selfStyleConnection(Object element, GraphConnection connection) {
        // Replace connection anchors.
        Connection figure = connection.getConnectionFigure();
        
        NodeFigure source = (NodeFigure) figure.getSourceAnchor().getOwner();
        Dimension corners = new Dimension(source.getArcRadius(), source.getArcRadius());
        figure.setSourceAnchor(new RoundedRectangleAnchor(source, corners));
        
        NodeFigure target = (NodeFigure) figure.getTargetAnchor().getOwner();
        corners = new Dimension(target.getArcRadius(), target.getArcRadius());
        figure.setTargetAnchor(new RoundedRectangleAnchor(target, corners));
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
    // Nodes
    // =============================================================
    
    @Override
    public IFigure getFigure(Object element) {
        if(element instanceof Feature)
            return createFeatureFigure((Feature) element);
        if(element instanceof Group)
            return new GroupFigure((Group) element);
        if(element instanceof Constraint)
            return new ConstraintFigure((Constraint) element);
        return null;
    }
        
    protected IFigure createFeatureFigure(Feature feature) {
        FeatureFigure figure = new FeatureFigure(feature);
                
        int hiddenNeighbors = countHiddenNeighbors(feature);
        if(hiddenNeighbors > 0)
            figure.addDecoration(new HiddenNeighborsDecoration(hiddenNeighbors));
        if(isHiddenGroup(feature))
            figure.addDecoration(new HiddenGroupDecoration());
        if(isHiddenConstraint(feature))
            figure.addDecoration(new HiddenConstraintDecoration());
        
        return figure;
    }
    
    // =============================================================
    // Helpers
    // =============================================================
    
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
