package cz.jpikl.yafmt.editors.featureconfig.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.editors.featureconfig.editor.FeatureConfigurationManager;
import cz.jpikl.yafmt.models.featuremodel.Feature;

public class UnselectCommand extends Command {

    private FeatureConfigurationManager configManager;
    private Collection<Feature> features;
    private Collection<Feature> affectedFeatures;
    
    public UnselectCommand(FeatureConfigurationManager configManager, Collection<Feature> features) {
        this.configManager = configManager;
        this.features = features;
    }
    
    public UnselectCommand(FeatureConfigurationManager configManager, Feature feature) {
        this.configManager = configManager;
        this.features = new ArrayList<Feature>();
        features.add(feature);
    }
    
    @Override
    public void execute() {
        affectedFeatures = configManager.unselectFeatures(features);
    }
    
    @Override
    public void undo() {
        configManager.selectFeatures(affectedFeatures);
    }
    
}
