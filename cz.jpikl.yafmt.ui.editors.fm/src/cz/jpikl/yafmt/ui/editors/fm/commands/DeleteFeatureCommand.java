package cz.jpikl.yafmt.ui.editors.fm.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

public class DeleteFeatureCommand extends RecordingCommand {
    
    private Feature feature;
    
    public DeleteFeatureCommand(Feature feature) {
        setLabel("Delete Feature " + feature.getName());
        this.feature = feature;
    }
        
    protected void initializeRecording() {
        addRecordedObject(feature.getFeatureModel());
        addRecordedObject(feature.getParent());
        addRecordedObject(feature);
    }
    
    @Override
    protected void performRecording() {
        FeatureModel featureModel = feature.getFeatureModel();
        List<Feature> orphans = featureModel.getOrphans();
        
        orphans.addAll(feature.getFeatures());
        for(Group group: feature.getGroups())
            orphans.addAll(group.getFeatures());
        feature.getGroups().clear();
        
        EObject parent = feature.getParent();
        feature.setParent(null);
        FeatureModelUtil.removeUnneededGroup(parent);
    }
    
}
