package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class DeleteFeatureCommand extends RecordingCommand {
    
    private Feature feature;
    
    public DeleteFeatureCommand(Feature feature) {
        setLabel("Delete Feature " + feature.getName());
        this.feature = feature;
    }
        
    protected void initializeRecording() {
        FeatureModel featureModel = feature.getFeatureModel();
        if(featureModel == null)
            return;
        
        addRecordedObject(featureModel);
        addRecordedObject(feature);
        
        EObject parent = feature.getParent();
        if(parent != null) {
            addRecordedObject(parent);
            if(parent instanceof Group)
                addRecordedObject(((Group) parent).getParent());
        }
    }
    
    @Override
    protected void performRecording() {
        FeatureModel featureModel = feature.getFeatureModel();
        if(featureModel == null)
            return;
        
        featureModel.getOrphans().addAll(feature.getFeatures());
        for(Group group: feature.getGroups())
            featureModel.getOrphans().addAll(group.getFeatures());
        feature.getGroups().clear();
        
        EObject parent = feature.getParent();
        if(parent instanceof Feature) {
            ((Feature) parent).getFeatures().remove(feature);
        }
        else if(parent instanceof Group) {
            Group group = (Group) parent;
            group.getFeatures().remove(feature);
            if(group.getFeatures().size() <= 1) {
                if(group.getFeatures().size() == 1)
                    group.getParent().getFeatures().add(group.getFeatures().get(0));
                group.getParent().getGroups().remove(group);
            }
        }
        else {
            featureModel.getOrphans().remove(feature);
        }
    }
    
}
