package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;

public class AddAttributeCommand extends RecordingCommand {

    private Feature feature;
    private Attribute attribute;
    
    public AddAttributeCommand(Feature feature, Attribute attribute) {
        setLabel("Add Attribute");
        this.feature = feature;
        this.attribute = attribute;
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.getAttributes().add(attribute);
    }
    
}
