package cz.jpikl.yafmt.ui.editors.fc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class FeatureConfigurationManager {
    
    // Feature selection which has no parent (its unselected feature). 
    private static class VirtualSelection {
        
        private Selection selection;
        private int insertPosition;
        
        public VirtualSelection(Selection selection, int insertPosition) {
            this.selection = selection;
            this.insertPosition = insertPosition;
        }
                
    }
    
    // Parent to children virtual connections.
    private Map<Selection, List<VirtualSelection>> virtualConnections = new HashMap<Selection, List<VirtualSelection>>();
    // Children to parent virtual connections.
    private Map<Selection, Selection> virtualConnectionsOpposite = new HashMap<Selection, Selection>();
    
    private FeatureConfiguration featureConfig;

    public FeatureConfigurationManager(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
        repairFeatureConfiguration();
        rebuildVirtualConnections();
    }
    
    public FeatureConfiguration getFeatureConfiguration() {
        return featureConfig;
    }
    
    public FeatureModel getFeatureModel() {
        return featureConfig.getFeatureModelCopy();
    }
    
    // ===========================================================================
    //  Repair operations
    // ===========================================================================
    
    private void repairFeatureConfiguration() {
        // Repair configuration structure against feature model copy.
        Feature rootFeature = featureConfig.getFeatureModelCopy().getRoot();
        Selection rootSelection = featureConfig.getRoot();
        FeatureConfigurationUtil.repairSelection(rootFeature, rootSelection);
    }
    
    // ===========================================================================
    //  Virtual connection related operations
    // ===========================================================================

    private void rebuildVirtualConnections() {
        virtualConnections.clear();
        virtualConnectionsOpposite.clear();
        
        Feature rootFeature = featureConfig.getFeatureModelCopy().getRoot();
        Selection rootSelection = featureConfig.getRoot();
        createVirtualConnections(rootFeature, rootSelection);
    }
    
    private void createVirtualConnections(Feature feature, Selection selection) {
        // This expect that children selections are sorted in order given by feature configuration repair process. 
        int startingIndex = 0;
        startingIndex = createVirtualConnections(feature.getFeatures(), startingIndex, selection, Integer.MAX_VALUE);
        
        EList<Group> groups = feature.getGroups();
        for(int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            int groupMax = group.getUpper();
            if(groupMax == -1)
                groupMax = Integer.MAX_VALUE;
            startingIndex = createVirtualConnections(group.getFeatures(), startingIndex, selection, groupMax);
        }
    }

    private int createVirtualConnections(EList<Feature> childrenFeatures, int startingIndex, Selection parentSelection, int groupMax) {
        // This expect that children selections are sorted in order given by feature configuration repair process.
        EList<Selection> childrenSelections = parentSelection.getSelections();
        
        for(int i = 0; i < childrenFeatures.size(); i++) {
            Feature childFeature = childrenFeatures.get(i);
            String id = childFeature.getId();
            int featureMax = childFeature.getUpper();
                           
            for(int j = startingIndex; j < childrenSelections.size(); j++) {
                Selection childSelection = childrenSelections.get(j); 
                if(childSelection.getId().equals(id)) {
                    createVirtualConnections(childFeature, childSelection);
                    featureMax--;
                    groupMax--;
                    startingIndex++;
                }
                else {
                    break;
                }
            }
            
            if((groupMax > 0) && (featureMax > 0)) {
                Selection childSelection = FeatureConfigurationUtil.createSelection(childFeature);
                addVirtualConnection(parentSelection, childSelection, startingIndex);
            }
        }
        
        return startingIndex;
    }

    private void addVirtualConnection(Selection parentSelection, Selection childSelection, int insertPosition) {
        // Parent to child connection.
        List<VirtualSelection> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null) {
            childrenSelections = new ArrayList<VirtualSelection>();
            virtualConnections.put(parentSelection, childrenSelections);
        }
        childrenSelections.add(new VirtualSelection(childSelection, insertPosition));
        
        // Child to parent connection.
        virtualConnectionsOpposite.put(childSelection, parentSelection);
    }
        
    // ===========================================================================
    //  Query operations
    // ===========================================================================
    
    public Selection getParentSelection(Selection childSelection) {
        Selection parentSelection = childSelection.getParent();
        if(parentSelection == null)
            parentSelection = virtualConnectionsOpposite.get(childSelection);
        return parentSelection;
    }
    
    public List<Selection> getChildrenSelections(Selection parentSelection) {
        List<Selection> childrenSelections = new ArrayList<Selection>();
        contributeChildrenSelections(parentSelection, childrenSelections, true);
        return childrenSelections;
    }
    
    public void contributeChildrenSelections(Selection parentSelection, List<Selection> selectionList, boolean sortChildren) {
        if(virtualConnectionsOpposite.containsKey(parentSelection))
            return;
        
        selectionList.addAll(parentSelection.getSelections());
        
        List<VirtualSelection> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null)
            return;
        
        if(sortChildren) {
            int offset = 0;
            for(int i = 0; i < childrenSelections.size(); i++) {
                VirtualSelection childSelection = childrenSelections.get(i);
                selectionList.add(childSelection.insertPosition + offset, childSelection.selection);
                offset++;
            }
        }
        else {
            for(int i = 0; i < childrenSelections.size(); i++) {
                VirtualSelection childSelection = childrenSelections.get(i);
                selectionList.add(childSelection.selection);
            }
        }
    }
    
    // ===========================================================================
    //  Selections operations
    // ===========================================================================
        
    public void selectFeatures(List<Selection> selections) {
        for(Selection selection: selections)
            selectFeature(selection);
    }
    
    public boolean canSelectFeature(Selection selection) {
        return virtualConnections.containsKey(selection);
    }

    public void selectFeature(Selection selection) {
        Selection parentSelection = virtualConnectionsOpposite.get(selection);
        if(parentSelection == null)
            return;
        
        List<VirtualSelection> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null)
            return;
        
        int index = -1;
        for(int i = 0; i < childrenSelections.size(); i++) {
            if(childrenSelections.get(i).selection == selection) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return;
        
        int insertPosition = childrenSelections.remove(index).insertPosition;
        for(int i = index; i < childrenSelections.size(); i++)
            childrenSelections.get(i).insertPosition++;
        parentSelection.getSelections().add(insertPosition, selection);
    }
    
}
