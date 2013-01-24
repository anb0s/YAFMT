package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;

public class AddAttributeCommand extends Command {

    private Feature feature;
    private Attribute attribute;
    
    public AddAttributeCommand(Feature feature) {
        setLabel("Add Attribute");
        this.feature = feature;
    }
    
    @Override
    public void execute() {
        attribute = FeatureModelFactory.eINSTANCE.createAttribute();
        attribute.setId(EcoreUtil.generateUUID());
        attribute.setName("New Attribute");
        redo();
    }
    
    @Override
    public void redo() {
        feature.getAttributes().add(attribute);
    }
    
    @Override
    public void undo() {
        feature.getAttributes().remove(attribute);
    }
    
}
