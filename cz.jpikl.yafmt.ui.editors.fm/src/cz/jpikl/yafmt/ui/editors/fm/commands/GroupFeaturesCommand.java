package cz.jpikl.yafmt.ui.editors.fm.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class GroupFeaturesCommand extends RecordingCommand {

    private LayoutData layoutData;
    private List<Feature> features;
    private Group group;
    private Rectangle bounds;
    private boolean xorGroup;
    
    public GroupFeaturesCommand(LayoutData layoutData, List<Feature> features, boolean xorGroup) {
        setLabel("Make " + (xorGroup ? "XOR" : "OR") + " Group");
        this.layoutData = layoutData;
        this.features = features;
        this.xorGroup = xorGroup;
    }
    
    @Override
    protected void initializeRecording() {
        for(Feature feature: features)
            addRecordedObjectParent(feature);
    }
    
    @Override
    protected void performRecording() {
        EObject parent = features.get(0).getParent();
        if(parent instanceof Group)
            parent = ((Group) parent).getParent();
        
        group = FeatureModelFactory.eINSTANCE.createGroup();
        group.setParent((Feature) parent);
        group.getFeatures().addAll(features);
        group.setXor(xorGroup); // Must be called after adding features.
        
        for(Group group: ((Feature) parent).getGroups())
            FeatureModelUtil.removeUnneededGroup(group);
        
        computeGroupBounds();
    }
    
    private void computeGroupBounds() {
        Rectangle parentBounds = layoutData.getMapping().get(group.getParent());
        
        int cx = 0;
        int cy = 0;
        for(Feature feature: features) {
            Rectangle featureBounds = layoutData.getMapping().get(feature);
            cx += featureBounds.x;
            cy += featureBounds.y;
        }
        cx /= features.size();
        cy /= features.size();
        
        bounds = MoveGroupCommand.computeGroupBounds(parentBounds, cx, cy);
    }
    
    @Override
    public void execute() {
        super.execute();
        layoutData.getMapping().put(group, bounds);
    }
    
    @Override
    public void redo() {
        super.redo();
        layoutData.getMapping().put(group, bounds);
    }
    
    @Override
    public void undo() {
        super.undo();
        layoutData.getMapping().remove(group);
    }
    
}
