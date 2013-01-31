package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;

public class MoveAttributeCommand extends RecordingCommand {

    private Attribute attribute;
    private int targetIndex;
    
    public MoveAttributeCommand(Attribute attribute, int targetIndex) {
        this.attribute = attribute;
        this.targetIndex = targetIndex;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObjectParent(attribute);
    }

    @Override
    protected void performRecording() {
        Feature feature = (Feature) attribute.eContainer();
        feature.getAttributes().move(targetIndex, attribute);
    }

}