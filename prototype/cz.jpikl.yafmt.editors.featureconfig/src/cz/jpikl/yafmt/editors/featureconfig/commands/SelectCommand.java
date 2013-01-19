package cz.jpikl.yafmt.editors.featureconfig.commands;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class SelectCommand extends Command {

    private FeatureConfigurationManager configManager;
    private Collection<Feature> features;
    
    public SelectCommand(FeatureConfigurationManager configManager, Collection<Feature> features) {
        this.configManager = configManager;
        this.features = features;
    }
    
    public SelectCommand(FeatureConfigurationManager configManager, Feature feature) {
        this.configManager = configManager;
        this.features = new ArrayList<Feature>();
        this.features.add(feature);
    }
    
    @Override
    public void execute() {
        configManager.selectFeatures(features);
    }
    
    @Override
    public void undo() {
        configManager.unselectFeatures(features);
    }

    
}
