package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class ChangeConnectionTargetCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private EObject parent;
    private Feature oldChild;
    private Feature newChild;
    private EObject newChildPrevParent;
    
    public ChangeConnectionTargetCommand(Connection connection, Feature newChild) {
        this.featureModel = newChild.getFeatureModel();
        this.parent = connection.getSource();
        this.oldChild = connection.getTarget();
        this.newChild = newChild;
        this.newChildPrevParent = newChild.getParent();
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
        addRecordedObject(parent);
        addRecordedObject(oldChild);
        addRecordedObject(newChild);
        
        if(newChildPrevParent != null) {
            addRecordedObject(newChildPrevParent);
            if(newChildPrevParent instanceof Group)
                addRecordedObject(((Group) newChildPrevParent).getParent());
        }
    }

    @Override
    protected void performRecording() {
        featureModel.getOrphans().add(oldChild);
        
        if(parent instanceof Group)
            ((Group) parent).getFeatures().add(newChild);
        else
            ((Feature) parent).getFeatures().add(newChild);
        
        if(newChildPrevParent instanceof Group) {
            Group group = (Group) newChildPrevParent;
            if(group.getFeatures().isEmpty())
                group.getParent().getGroups().remove(group);
        }
    }

}
