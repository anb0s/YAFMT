package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class AttributeEditPolicy extends ComponentEditPolicy {

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        Attribute attribute = (Attribute) getHost().getModel();
        LayoutData layoutData = ((FeatureEditPart) getHost().getParent()).getLayoutData();

        return new DeleteAttributeCommand(layoutData, attribute);
    }

}
