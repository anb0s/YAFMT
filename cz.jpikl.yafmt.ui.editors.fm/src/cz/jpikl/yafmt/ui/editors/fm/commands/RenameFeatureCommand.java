package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;

public class RenameFeatureCommand extends Command {

    private Feature feature;
    private String newName;
    private String oldName;

    public RenameFeatureCommand(Feature feature, String newName) {
        this.feature = feature;
        this.newName = newName;
        this.oldName = feature.getName();
    }

    @Override
    public void execute() {
        feature.setName(newName);
    }

    @Override
    public void undo() {
        feature.setName(oldName);
    }

}
