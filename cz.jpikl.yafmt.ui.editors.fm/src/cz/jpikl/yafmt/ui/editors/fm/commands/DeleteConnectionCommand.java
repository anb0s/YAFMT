package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class DeleteConnectionCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private EObject parent;
    private Feature child;
        
    public DeleteConnectionCommand(Connection connection) {
        parent = connection.getSource();
        child = connection.getTarget();
        featureModel = child.getFeatureModel();
        
        String parentName = (parent instanceof Group) ? ((Group) parent).getParent().getName() : ((Feature) parent).getName();
        String childName = child.getName();
        setLabel("Delete Subfeature " + childName + " from " + parentName);
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
        addRecordedObject(child);
        addRecordedObject(parent);
        if(parent instanceof Group)
            addRecordedObject(((Group) parent).getParent());
    }

    @Override
    protected void performRecording() {
        featureModel.getOrphans().add(child);
        if(parent instanceof Group) {
            Group group = (Group) parent;
            if(group.getFeatures().size() <= 1) {
                if(group.getFeatures().size() == 1)
                    group.getParent().getFeatures().add(group.getFeatures().get(0));
                group.getParent().getGroups().remove(group);
            }
        }
    }

}
