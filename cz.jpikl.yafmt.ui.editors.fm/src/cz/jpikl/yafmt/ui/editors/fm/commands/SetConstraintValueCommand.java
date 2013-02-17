package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Constraint;

public class SetConstraintValueCommand extends RecordingCommand {

    private Constraint constraint;
    private String newValue;
        
    public SetConstraintValueCommand(Constraint constraint, String newValue) {
        this.constraint = constraint;
        this.newValue = newValue;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(constraint);
    }

    @Override
    protected void performRecording() {
        constraint.setValue(newValue);
    }

}
