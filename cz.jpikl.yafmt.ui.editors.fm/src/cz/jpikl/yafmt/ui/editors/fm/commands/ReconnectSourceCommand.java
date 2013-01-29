package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.model.Connection;

public class ReconnectSourceCommand extends RecordingCommand {

    private EObject source;
    private Feature oldTarget;
    private Feature newTarget;
    
    public ReconnectSourceCommand(Connection connection, Feature newTarget) {
        this.source = connection.getSource();
        this.oldTarget = connection.getTarget();
        this.newTarget = newTarget;
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(oldTarget.getFeatureModel());
        addRecordedObject(source);
        addRecordedObjectParent(newTarget);
    }

    @Override
    protected void performRecording() {
        EObject newTargetPreviousParent = newTarget.getParent();
        oldTarget.setParent(oldTarget.getFeatureModel());
        newTarget.setParent(source);
        FeatureModelUtil.removeUnneededGroup(newTargetPreviousParent);
    }

}