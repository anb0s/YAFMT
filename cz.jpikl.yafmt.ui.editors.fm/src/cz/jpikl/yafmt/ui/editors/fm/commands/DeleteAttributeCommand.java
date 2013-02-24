package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.commands.RecordingCommand;
import cz.jpikl.yafmt.ui.editors.fm.figures.AttributeFigure;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class DeleteAttributeCommand extends RecordingCommand {

    private ResizeFeatureCommand resizeCommand;
    private LayoutData layoutData;
    private Attribute attribute;
    
    public DeleteAttributeCommand(LayoutData layoutData, Attribute attribute) {
        setLabel("Delete Attribute " + attribute.getName());
        this.layoutData = layoutData;
        this.attribute = attribute;
    }
    
    private void initializeResizeCommand() {
        Feature feature = (Feature) attribute.eContainer();
        Rectangle deltas = new Rectangle();
        deltas.height = -((feature.getAttributes().size() == 1) ? AttributeFigure.EXTENDED_HEIGHT : AttributeFigure.HEIGHT);
        resizeCommand = new ResizeFeatureCommand(layoutData, feature, deltas);
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
