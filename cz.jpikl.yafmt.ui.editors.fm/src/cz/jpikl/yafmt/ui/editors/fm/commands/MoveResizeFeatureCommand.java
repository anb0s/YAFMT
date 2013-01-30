package cz.jpikl.yafmt.ui.editors.fm.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;

public class MoveResizeFeatureCommand extends Command {

    private LayoutData layoutData;
    private Feature feature;
    private Rectangle featureOldBounds;
    private Rectangle featureNewBounds;
    private Map<Group, Rectangle> groupOldBounds;
    private Map<Group, Rectangle> groupNewBounds;
    private boolean resize;
    
    public MoveResizeFeatureCommand(LayoutData layoutData, Feature feature, Rectangle newBounds) {
        this.layoutData = layoutData;
        this.feature = feature;
        this.featureOldBounds = layoutData.getMapping().get(feature);
        this.featureNewBounds = newBounds;
        this.resize = (featureOldBounds.width != featureNewBounds.width) || (featureOldBounds.height != featureNewBounds.height);
        
        if(resize)
            setLabel("Resize Feature");
        else
            setLabel("Move Feature");
    }

    @Override
    public void execute() {
        computeGroupBounds();
        redo();
    }
    
    @Override
    public void redo() {
        layoutData.getMapping().put(feature, featureNewBounds);
        applyGroupBounds(groupNewBounds);
    }
    
    @Override
    public void undo() {
        layoutData.getMapping().put(feature, featureOldBounds);
        applyGroupBounds(groupOldBounds);
    }
    
    private void applyGroupBounds(Map<Group, Rectangle> groupBounds) {
        if(groupBounds == null)
            return;
        for(Map.Entry<Group, Rectangle> entry: groupBounds.entrySet())
            layoutData.getMapping().put(entry.getKey(), entry.getValue());
    }
    
    private void computeGroupBounds() {
        if(feature.getGroups().isEmpty())
            return;
        
        groupOldBounds = new HashMap<Group, Rectangle>(feature.getGroups().size());
        groupNewBounds = new HashMap<Group, Rectangle>(feature.getGroups().size());
        
        for(Group group: feature.getGroups())
            groupOldBounds.put(group, layoutData.getMapping().get(group));
        
        int dx = featureNewBounds.x - featureOldBounds.x;
        int dy = featureNewBounds.y - featureOldBounds.y;
        
        double dwRatio = featureNewBounds.width / ((double) featureOldBounds.width);
        double dhRatio = featureNewBounds.height / ((double) featureOldBounds.height);
        
        for(Group group: feature.getGroups()) {
            Rectangle groupBounds = layoutData.getMapping().get(group).getCopy();
            if(resize) {
                // Change coordinates according to ratio. 
                Point groupCenter = groupBounds.getCenter();
                groupCenter.x = featureNewBounds.x + (int) ((groupCenter.x - featureOldBounds.x) * dwRatio);
                groupCenter.y = featureNewBounds.y + (int) ((groupCenter.y - featureOldBounds.y) * dhRatio);
                
                // Fix rounding error.
                if(Math.abs(groupCenter.x - featureNewBounds.x) <= 1)
                    groupCenter.x = featureNewBounds.x;
                else if(Math.abs(groupCenter.x - featureNewBounds.right()) <= 1)
                    groupCenter.x = featureNewBounds.right();
                if(Math.abs(groupCenter.y - featureNewBounds.y) <= 1)
                    groupCenter.y = featureNewBounds.y;
                else if(Math.abs(groupCenter.y - featureNewBounds.bottom()) <= 1)
                    groupCenter.y = featureNewBounds.bottom();
                
                groupBounds.x = groupCenter.x - groupBounds.width / 2;
                groupBounds.y = groupCenter.y - groupBounds.height / 2;
                            }
            else {
                // Just move coordinates.
                groupBounds.x += dx;
                groupBounds.y += dy;
            }
            groupNewBounds.put(group, groupBounds);
        }
    }
        
}
