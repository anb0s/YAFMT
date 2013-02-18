package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class DeleteConstraintCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private Constraint constraint;

    public DeleteConstraintCommand(Constraint constraint) {
        setLabel("Delete constraint");
        this.featureModel = constraint.getFeatureModel();
        this.constraint = constraint;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
    }

    @Override
    protected void performRecording() {
        featureModel.getConstraints().remove(constraint);
    }
    
}
