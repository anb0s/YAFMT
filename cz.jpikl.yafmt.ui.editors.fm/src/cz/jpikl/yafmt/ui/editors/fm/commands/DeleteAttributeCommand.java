package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;

public class DeleteAttributeCommand extends Command {

    private Feature feature;
    private Attribute attribute;
    private int attributeIndex;
    
    public DeleteAttributeCommand(Feature feature, int attributeIndex) {
        setLabel("Delete Attribute " + feature.getAttributes().get(attributeIndex).getName());
        this.feature = feature;
        this.attributeIndex = attributeIndex;
    }
    
    @Override
    public void execute() {
        attribute = feature.getAttributes().get(attributeIndex);
        redo();
    }
    
    @Override
    public void redo() {
        feature.getAttributes().remove(attributeIndex);
    }
    
    @Override
    public void undo() {
        feature.getAttributes().add(attributeIndex, attribute);
    }
    
    @Override
    public String toString() {
        return feature.getAttributes().get(attributeIndex).getName();
    }
    
}
