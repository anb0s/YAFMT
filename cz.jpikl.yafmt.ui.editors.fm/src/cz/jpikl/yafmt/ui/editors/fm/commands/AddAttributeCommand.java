package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class AddAttributeCommand extends RecordingCommand {

    private ResizeFeatureCommand resizeCommand;
    private LayoutData layoutData;
    private Feature feature;
    private Attribute attribute;
    
    public AddAttributeCommand(LayoutData layoutData, Feature feature, Attribute attribute) {
        setLabel("Add Attribute");
        this.layoutData = layoutData;
        this.feature = feature;
        this.attribute = attribute;
    }
    
    private void initializeResizeCommand() {
        Rectangle bounds = layoutData.get(feature);
        Rectangle deltas = new Rectangle();
        deltas.height = (feature.getAttributes().isEmpty()) ? AttributeFigure.EXTENDED_HEIGHT : AttributeFigure.HEIGHT;
        if(bounds.width < AttributeFigure.WIDTH)
            deltas.width = AttributeFigure.WIDTH - bounds.width;
        resizeCommand = new ResizeFeatureCommand(layoutData, feature, deltas);
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        feature.getAttributes().add(attribute);
    }
    
    @Override
    public void execute() {
        initializeResizeCommand();
        super.execute();
        resizeCommand.execute();
    }
    
    @Override
    public void redo() {
        super.redo();
        resizeCommand.redo();
    }
    
    @Override
    public void undo() {
        resizeCommand.undo();
        super.undo();
    }
        
}
