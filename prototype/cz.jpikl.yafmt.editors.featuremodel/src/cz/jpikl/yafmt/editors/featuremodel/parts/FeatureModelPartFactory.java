package cz.jpikl.yafmt.editors.featuremodel.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.editors.featuremodel.utils.Connection;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureModelPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof FeatureModel)
			return new FeatureModelEditPart((FeatureModel) model);
		if(model instanceof Feature)
			return new FeatureEditPart((Feature) model);
		if(model instanceof Connection)
			return new ConnectionEditPart((Connection) model);
		throw new IllegalStateException("No EditPart for " + model.getClass());
	}

}
