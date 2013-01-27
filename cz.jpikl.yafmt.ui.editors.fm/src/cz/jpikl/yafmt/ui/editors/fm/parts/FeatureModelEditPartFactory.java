package cz.jpikl.yafmt.ui.editors.fm.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.ModelLayout;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class FeatureModelEditPartFactory implements EditPartFactory {

    private ModelLayout modelLayout;
        
    public FeatureModelEditPartFactory(ModelLayout modelLayout) {
        this.modelLayout = modelLayout;
    }

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureModel)
            return new FeatureModelEditPart((FeatureModel) model, modelLayout);
        if(model instanceof Feature)
            return new FeatureEditPart((Feature) model);
        if(model instanceof Group)
            return new GroupEditPart((Group) model);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);
        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

    
    
}
