package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.commands.RecordingCommand;

public class SetFeatureNameCommand extends RecordingCommand {

    private Feature feature;
    private String newName;

    public SetFeatureNameCommand(Feature feature, String newName) {
        setLabel("Rename Feature " + feature.getName() + " to " + newName);
        this.feature = feature;
        this.newName = newName;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }
    
    @Override
    protected void performRecording() {
        feature.setName(newName);
    }
    
}
