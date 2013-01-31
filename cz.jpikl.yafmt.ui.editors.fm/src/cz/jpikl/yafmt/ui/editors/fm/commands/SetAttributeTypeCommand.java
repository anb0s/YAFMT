package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;

public class SetAttributeTypeCommand extends RecordingCommand {

    private Attribute attribute;
    private AttributeType type;
    
    public SetAttributeTypeCommand(Attribute attribute, AttributeType type) {
        this.attribute = attribute;
        this.type = type;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        attribute.setType(type);
    }

}
