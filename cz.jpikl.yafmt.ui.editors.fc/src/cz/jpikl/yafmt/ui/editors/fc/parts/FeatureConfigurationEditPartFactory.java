package cz.jpikl.yafmt.ui.editors.fc.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.model.Connection;
import cz.jpikl.yafmt.ui.editors.fc.model.SelectionPair;

public class FeatureConfigurationEditPartFactory implements EditPartFactory {

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureConfiguration) {
            return new FeatureConfigurationEditPart((FeatureConfiguration) model);
        }
        if(model instanceof Selection) {
            return new SelectionEditPart((Selection) model);
        }
        if(model instanceof SelectionPair) {
            SelectionPair pair = (SelectionPair) model;
            return new SelectionEditPart(pair.getParentSelection(), pair.getSelection());
        }
        if(model instanceof Connection) {
            return new ConnectionEditPart((Connection) model);
        }
        
        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

}
