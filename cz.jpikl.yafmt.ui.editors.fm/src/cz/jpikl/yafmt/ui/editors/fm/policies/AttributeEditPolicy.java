package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;

public class AttributeEditPolicy extends ComponentEditPolicy {

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        return new DeleteAttributeCommand((Attribute) getHost().getModel());
    }
    
}
