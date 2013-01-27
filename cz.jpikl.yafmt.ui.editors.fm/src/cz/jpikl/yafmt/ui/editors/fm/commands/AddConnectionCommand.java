package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class AddConnectionCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private EObject source;
    private Feature destination;
    
    public AddConnectionCommand(EObject source) {
        this.source = source;
    }
    
    public boolean setDestination(Feature destination) {
        if(destination.isRoot())
            return false;

        for(EObject item = source; item != null; item = item.eContainer()) {
            if(item == destination)
                return false;
        }

        this.destination = destination;
        this.featureModel = destination.getFeatureModel();
        
        String sourceName = (source instanceof Group) ? ((Group) source).getParent().getName() : ((Feature) source).getName();
        setLabel("Make " + destination.getName() + " Subfeature of " + sourceName);
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
        if(source instanceof Group)
            ((Group) source).getFeatures().add(destination);
        else
            ((Feature) source).getFeatures().add(destination);
        
        if(parent instanceof Group) {
            Group group = (Group) parent;
            if(group.getFeatures().isEmpty())
                group.getParent().getGroups().remove(group);
        }
    }

}
