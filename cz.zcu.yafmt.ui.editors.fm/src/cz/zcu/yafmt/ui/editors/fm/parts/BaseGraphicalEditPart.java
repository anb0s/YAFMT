package cz.zcu.yafmt.ui.editors.fm.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

public abstract class BaseGraphicalEditPart extends AbstractGraphicalEditPart {
    
    // ===================================================================
    //  Policies
    // ===================================================================
    
    @Override
    protected void createEditPolicies() {
        // Policy for 'snap to grid' and 'snap to geometry' functions.
        installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
    }

    // ===================================================================
    //  Adapters
    // =================================================================== 
    
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        // Helper for 'snap to grid' and 'snap to geometry' functions. 
        if(type == SnapToHelper.class) {
            List<SnapToHelper> helpers = new ArrayList<SnapToHelper>(2);
            if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED)))
                helpers.add(new SnapToGeometry(this));
            if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED)))
                helpers.add(new SnapToGrid(this));
            if(helpers.size() == 0)
                return null;
            else
                return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[helpers.size()]));
        }
        return super.getAdapter(type);
    }

}
