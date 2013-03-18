package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.ui.commands.RecordingCommand;

public class SetAttributeNameCommand extends RecordingCommand {

    private Attribute attribute;
    private String newName;

    public SetAttributeNameCommand(Attribute attribute, String newName) {
        this.attribute = attribute;
        this.newName = newName;
    }
    
    @Override
    public boolean canExecute() {
        return (newName != null) && !newName.isEmpty();
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        setLabel("Rename Attribute " + attribute.getName() + " to " + newName);
        attribute.setName(newName);
    }

}
