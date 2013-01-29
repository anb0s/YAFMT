package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Feature;

public class SetFeatureCardinalityCommand extends RecordingCommand {

    private Feature feature;
    private boolean mandatory;
    
    public SetFeatureCardinalityCommand(Feature feature, boolean mandatory) {
        setLabel("Make Features " + (mandatory ? "Mandatory" : "Optional"));
        this.feature = feature;
        this.mandatory = mandatory;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.setMandatory(mandatory);
    }

}