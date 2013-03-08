package cz.jpikl.yafmt.ui.editors.fm.commands;

import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.commands.RecordingCommand;

public class SetGroupCardinalityCommand extends RecordingCommand {

    private Group group;
    private boolean xorGroup;

    public SetGroupCardinalityCommand(Group group, boolean xorGroup) {
        setLabel("Make " + (xorGroup ? "XOR" : "OR") + " Group");
        this.group = group;
        this.xorGroup = xorGroup;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(group);
    }

    @Override
    protected void performRecording() {
        group.setXor(xorGroup);
    }

}
