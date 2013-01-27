package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fm.Group;

public class GroupEditPart extends AbstractGraphicalEditPart {

    public GroupEditPart(Group group) {
        setModel(group);
    }
    
    @Override
    protected IFigure createFigure() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void createEditPolicies() {
        // TODO Auto-generated method stub
        
    }

}
