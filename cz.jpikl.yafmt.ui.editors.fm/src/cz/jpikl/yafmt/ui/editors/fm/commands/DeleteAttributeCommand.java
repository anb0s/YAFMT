package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Feature;

public class DeleteAttributeCommand extends RecordingCommand {

    private Feature feature;
    private int attributeIndex;
    
    public DeleteAttributeCommand(Feature feature, int attributeIndex) {
        setLabel("Delete Attribute " + feature.getAttributes().get(attributeIndex).getName());
        this.attributeIndex = attributeIndex;
        this.feature = feature;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.getAttributes().remove(attributeIndex);
    }
    
    @Override
    public String toString() {
        return feature.getAttributes().get(attributeIndex).getName();
    }
    
}
