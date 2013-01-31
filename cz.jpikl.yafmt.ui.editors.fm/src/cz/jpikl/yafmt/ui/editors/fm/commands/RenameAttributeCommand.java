package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Attribute;

public class RenameAttributeCommand extends RecordingCommand {

    private Attribute attribute;
    private String newName;

    public RenameAttributeCommand(Attribute attribute, String newName) {
        setLabel("Rename Attribute " + attribute.getName() + " to " + newName);
        this.attribute = attribute;
        this.newName = newName;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }
    
    @Override
    protected void performRecording() {
        attribute.setName(newName);
    }
    
}
