package cz.zcu.yafmt.ui.tools;

import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.tools.SelectionTool;

import cz.zcu.yafmt.ui.util.DrawUtil;

// Adds support for dragging viewport with middle mouse button.
public class SelectionToolWithMovement extends SelectionTool {

    private static final int MIDDLE_MOUSE_BUTTON = 2;
    
    private boolean dragInProgress = false;    
    private Point dragStartLocation;
    
    @Override
    protected boolean handleButtonDown(int button) {
        if(button == MIDDLE_MOUSE_BUTTON) {
            setCursor(DrawUtil.DRAG_CURSOR);
            dragStartLocation = getLocation().getCopy();
            dragInProgress = true;
            return true;
        }
        else {
            return super.handleButtonDown(button);
        }
    }
    
    @Override
    protected boolean handleButtonUp(int button) {
        if(button == MIDDLE_MOUSE_BUTTON) {
            setCursor(getDefaultCursor());
            dragInProgress = false;
            return true;
        }
        else {
            return super.handleButtonUp(button);
        }
    }
    
    @Override
    protected boolean handleDrag() {
        if(dragInProgress) {
            Point dragEndLocation = getLocation().getCopy();
            Dimension dragSize = dragStartLocation.getDifference(dragEndLocation);
            dragStartLocation = dragEndLocation;
            
            FreeformGraphicalRootEditPart rootEditPart = (FreeformGraphicalRootEditPart) getCurrentViewer().getRootEditPart();
            Viewport viewport = (Viewport) rootEditPart.getFigure();
            viewport.setViewLocation(viewport.getViewLocation().getTranslated(dragSize));
            return true;
        }
        else {
            return super.handleDrag();
        }
    }
    
}
