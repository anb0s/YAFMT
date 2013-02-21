package cz.jpikl.yafmt.ui.views.fm;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.IEntityConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

public class FeatureModelStyleProvider implements IFigureProvider, 
                                                  ILabelProvider, 
                                                  IEntityStyleProvider, 
                                                  IEntityConnectionStyleProvider,
                                                  ISelfStyleProvider {

    private Color lightRedColor;

    public FeatureModelStyleProvider() {
        lightRedColor = new Color(Display.getCurrent(), 255, 192, 192);
    }
    
    // =============================================================
    // ILabelProvider
    // =============================================================

    @Override
    public void dispose() {
        lightRedColor.dispose();
    }
    
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
    public IFigure getFigure(Object element) {
        return null;
    }
    
    @Override
    public Image getImage(Object element) {
        return null;
    }
    
    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }
    
    @Override
    public void addListener(ILabelProviderListener listener) {
    }

    

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    // =============================================================
    // IEntityStyleProvider
    // =============================================================

    @Override
    public Color getForegroundColour(Object element) {
        if(element instanceof Feature)
            return ColorConstants.darkBlue;
        if(element instanceof Group)
            return ColorConstants.darkGray;
        return ColorConstants.red;
    }

    @Override
    public Color getBackgroundColour(Object element) {
        return ColorConstants.white;
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
    public int getBorderWidth(Object entity) {
        return 1;
    }

    @Override
    public boolean fisheyeNode(Object entity) {
        return false;
    }

    // =============================================================
    // IEntityConnectionStyleProvider
    // =============================================================

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

    @Override
    public int getLineWidth(Object src, Object dest) {
        return 1;
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
            return new Label(((Constraint) entity).getDescription());
        }
        
        return null;
    }
    
    // =============================================================
    // ISelfStyleProvider
    // =============================================================

    @Override
    public void selfStyleNode(Object element, GraphNode node) {
        
    }
    
    @Override
    public void selfStyleConnection(Object element, GraphConnection connection) {
    }
    
}
