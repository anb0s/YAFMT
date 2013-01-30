package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;

public class DeleteAttributeCommand extends RecordingCommand {

    private Attribute attribute;
    
    public DeleteAttributeCommand(Attribute attribute) {
        init(attribute);
    }
    
    public DeleteAttributeCommand(Feature feature, int attributeIndex) {
        init(feature.getAttributes().get(0));
    }
    
    private void init(Attribute attribute) {
        setLabel("Delete Attribute " + attribute.getName());
        this.attribute = attribute;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObjectParent(attribute);
    }

    @Override
    protected void performRecording() {
        EcoreUtil.remove(attribute);
    }
    
    @Override
    public String toString() {
        return attribute.getName();
    }
    
}
