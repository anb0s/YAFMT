package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.FeatureModel;

public class AddConstraintCommand extends RecordingCommand {

    private FeatureModel featureModel;
    private Constraint constraint;

    public AddConstraintCommand(FeatureModel featureModel, Constraint constraint) {
        setLabel("Add New Constraint");
        this.featureModel = featureModel;
        this.constraint = constraint;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(featureModel);
    }

    @Override
    protected void performRecording() {
        featureModel.getConstraints().add(constraint);
    }
    
}
