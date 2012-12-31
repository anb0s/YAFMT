package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.editors.featuremodel.layout.ModelLayoutStore;
import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureModelEditPartFactory implements EditPartFactory {

    private ModelLayoutStore layoutStore;

    public FeatureModelEditPartFactory(ModelLayoutStore layoutStore) {
        this.layoutStore = layoutStore;
    }

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureModel)
            return new FeatureModelEditPart((FeatureModel) model, layoutStore);
        if(model instanceof Feature)
            return new FeatureEditPart((Feature) model, layoutStore);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);
        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

}
