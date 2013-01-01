package cz.jpikl.yafmt.editors.featureconfig.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.editors.featureconfig.utils.Connection;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureConfigEditPartFactory implements EditPartFactory {

    private FeatureConfigurationManager configManager;
    
    public FeatureConfigEditPartFactory(FeatureConfiguration featureConfig) {
        configManager = new FeatureConfigurationManager(featureConfig);
    }
    
    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureConfiguration)
            return new FeatureConfigEditPart(configManager);
        if(model instanceof Feature)
            return new SelectionEditPart(configManager, (Feature) model);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);
        return null;
    }

}
