package cz.jpikl.yafmt.ui.editors.fm.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteAttributeCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.MoveResizeFeatureCommand;
import cz.jpikl.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class AttributeEditPolicy extends ComponentEditPolicy {

    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        Attribute attribute = (Attribute) getHost().getModel();
        Feature feature = (Feature) attribute.eContainer();
        
        LayoutData layoutData = ((FeatureEditPart) getHost().getParent()).getLayoutData();
        Rectangle bounds = layoutData.getMapping().get(feature);
        bounds = FeatureFigure.computeBoundsWithoutAttribute(feature, bounds);
        
        CompoundCommand compoundCommand = new CompoundCommand();
        compoundCommand.add(new DeleteAttributeCommand(attribute));
        compoundCommand.add(new MoveResizeFeatureCommand(layoutData, feature, bounds));
        return compoundCommand;
    }
    
}
