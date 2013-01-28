package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteGroupCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.GroupEditPart;

public class GroupEditPolicy extends ComponentEditPolicy {

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        LayoutData layoutData = ((GroupEditPart) getHost()).getLayoutData();
        Group group = (Group) getHost().getModel();
        return new DeleteGroupCommand(group, layoutData);
    }
    
}
