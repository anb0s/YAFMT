package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;
import cz.jpikl.yafmt.ui.validation.IProblemManager;

public class FeatureModelEditPartFactory implements EditPartFactory {

    private LayoutData layoutData;
    private IProblemManager problemManager;

    public FeatureModelEditPartFactory(LayoutData layoutData, IProblemManager problemManager) {
        this.layoutData = layoutData;
        this.problemManager = problemManager;
    }

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureModel)
            return new FeatureModelEditPart((FeatureModel) model, layoutData, problemManager);
        if(model instanceof Feature)
            return new FeatureEditPart((Feature) model, layoutData, problemManager);
        if(model instanceof Group)
            return new GroupEditPart((Group) model, layoutData, problemManager);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);
        if(model instanceof Attribute)
            return new AttributeEditPart((Attribute) model, problemManager);

        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

}
