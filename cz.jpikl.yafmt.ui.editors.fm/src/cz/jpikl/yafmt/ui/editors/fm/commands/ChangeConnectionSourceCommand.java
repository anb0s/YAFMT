package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class ChangeConnectionSourceCommand extends RecordingCommand {

    private EObject oldParent;
    private EObject newParent;
    private Feature child;
    
    public ChangeConnectionSourceCommand(Connection connection, EObject newParent) {
        this.oldParent = connection.getSource();
        this.newParent = newParent;
        this.child = connection.getTarget();
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(oldParent);
        addRecordedObject(newParent);
        addRecordedObject(child);
        
        if(oldParent instanceof Group)
            addRecordedObject(((Group) oldParent).getParent());
    }

    @Override
    protected void performRecording() {
        if(newParent instanceof Group)
            ((Group) newParent).getFeatures().add(child);
        else
            ((Feature) newParent).getFeatures().add(child);
        
        if(oldParent instanceof Group) {
            Group group = (Group) oldParent;
            if(group.getFeatures().size() <= 1) {
                if(group.getFeatures().size() == 1)
                    group.getParent().getFeatures().add(group.getFeatures().get(0));
                group.getParent().getGroups().remove(group);
            }
        }
    }

}
