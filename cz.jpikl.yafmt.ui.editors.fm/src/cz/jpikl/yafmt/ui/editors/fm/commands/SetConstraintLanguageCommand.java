package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Constraint;

public class SetConstraintLanguageCommand extends RecordingCommand {

    private Constraint constraint;
    private String language;
    
    public SetConstraintLanguageCommand(Constraint constraint, String language) {
        setLabel("Change constraint language");
        this.constraint = constraint;
        this.language = language;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(constraint);
    }

    @Override
    protected void performRecording() {
        constraint.setLanguage(language);
    }    
    
}
