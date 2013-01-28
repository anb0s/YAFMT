package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;

public class AddAttributeCommand extends RecordingCommand {

    private Feature feature;
    
    public AddAttributeCommand(Feature feature) {
        setLabel("Add Attribute");
        this.feature = feature;
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        Attribute attribute = FeatureModelFactory.eINSTANCE.createAttribute();
        attribute.setId(EcoreUtil.generateUUID());
        attribute.setName("New Attribute");
        feature.getAttributes().add(attribute);
    }
    
}
