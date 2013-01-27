package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class AddConnectionCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private Feature source;
    private Feature destination;
    
    public AddConnectionCommand(Feature feature) {
        this.featureModel = feature.getFeatureModel();
        this.source = feature;
    }
    
    public boolean setDestination(Feature destination) {
        if(destination.isRoot())
            return false;

        for(EObject item = source; item != null; item = item.eContainer()) {
            if(item == destination)
                return false;
        }

        this.destination = destination;
        setLabel("Make " + destination.getName() + " Subfeature of " + source.getName());
        return true;
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(source);
        addRecordedObject(destination);
        
        EObject parent = destination.getParent();
        if(parent != null) {
            addRecordedObject(parent);
            if(parent instanceof Group)
                addRecordedObject(((Group) parent).getParent());
        }
        else {
            addRecordedObject(featureModel);
        }
    }

    @Override
    protected void performRecording() {
        EObject parent = destination.getParent();
        source.getFeatures().add(destination);
        
        if(parent instanceof Group) {
            Group group = (Group) parent;
            if(group.getFeatures().isEmpty())
                group.getParent().getGroups().remove(group);
        }
    }

}
