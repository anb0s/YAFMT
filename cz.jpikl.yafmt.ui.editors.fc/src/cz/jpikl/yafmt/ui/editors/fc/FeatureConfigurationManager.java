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
import cz.jpikl.yafmt.ui.editors.fc.model.SelectionWrapper;

public class FeatureConfigurationManager {
    
    // Parent to children virtual connections.
    // Contains relation between selections which are present in feature configuration and selections which 
    // is possible to add (as their children) to the feature configuration.
    private Map<Selection, List<SelectionWrapper>> virtualConnections = new HashMap<Selection, List<SelectionWrapper>>();
    
    // Children to parent virtual connections.
    // Same as above, but opposite relation.
    private Map<SelectionWrapper, Selection> virtualConnectionsOpposite = new HashMap<SelectionWrapper, Selection>();
    
    private List<IFeatureConfigurationListener> listeners = new ArrayList<IFeatureConfigurationListener>();
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
    //  Listeners
    // ===========================================================================
    
    public void addFeatureConfigurationListener(IFeatureConfigurationListener listener) {
        listeners.add(listener);
    }
    
    public void removeFeatureConfigurationListener(IFeatureConfigurationListener listener) {
        listeners.add(listener);
    }
    
    protected void fireFeaturesSelected(List<Selection> selections) {
        for(IFeatureConfigurationListener listener: listeners)
            listener.featuresSelected(selections);
    }
    
    protected void fireFeaturesUnselected(List<Selection> selections) {
        for(IFeatureConfigurationListener listener: listeners)
            listener.featuresUnselected(selections);
    }
    
    // ===========================================================================
    //  Repair operations
    // ===========================================================================
    
    public void repairFeatureConfiguration() {
        // Repair feature configuration structure against feature model copy.
        Feature rootFeature = featureConfig.getFeatureModelCopy().getRoot();
        Selection rootSelection = featureConfig.getRoot();
        FeatureConfigurationUtil.repairSelection(rootFeature, rootSelection);
    }
    
    // ===========================================================================
    //  Virtual connection related operations
    // ===========================================================================

    public void rebuildVirtualConnections() {
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
            int groupUpper = (group.getUpper() == -1) ? Integer.MAX_VALUE : group.getUpper();
            startingIndex = createVirtualConnections(group.getFeatures(), startingIndex, selection, groupUpper);
        }
    }

    private int createVirtualConnections(EList<Feature> childrenFeatures, int startingIndex, Selection parentSelection, int groupUpper) {
        // This expect that children selections are sorted in order given by feature configuration repair process.
        EList<Selection> childrenSelections = parentSelection.getSelections();
        
        for(int i = 0; i < childrenFeatures.size(); i++) {
            Feature childFeature = childrenFeatures.get(i);
            String id = childFeature.getId();
            int allowedFeatureCount = childFeature.getUpper();
                           
            for(int j = startingIndex; j < childrenSelections.size(); j++) {
                Selection childSelection = childrenSelections.get(j); 
                if(childSelection.getId().equals(id)) {
                    createVirtualConnections(childFeature, childSelection);
                    allowedFeatureCount--;
                    startingIndex++;
                }
                else {
                    break;
                }
            }
            
            // Allow to select feature only if we don't break local constraint.
            if((allowedFeatureCount > 0) && (childrenSelections.size() < groupUpper)) {
                Selection childSelection = FeatureConfigurationUtil.createSelection(childFeature);
                addVirtualConnection(parentSelection, childSelection, startingIndex);
            }
        }
        
        return startingIndex;
    }

    private void addVirtualConnection(Selection parentSelection, Selection childSelection, int insertPosition) {
        SelectionWrapper childWrapper = new SelectionWrapper(featureConfig, childSelection, insertPosition);
        
        // Parent to child connection.
        List<SelectionWrapper> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null) {
            childrenSelections = new ArrayList<SelectionWrapper>();
            virtualConnections.put(parentSelection, childrenSelections);
        }
        childrenSelections.add(childWrapper);
        
        // Child to parent connection.
        virtualConnectionsOpposite.put(childWrapper, parentSelection);
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
        
        List<SelectionWrapper> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null)
            return;
        
        if(sortChildren) {
            // InsertPosition does not count other unselected features, so we have to increment it.
            int offset = 0;
            for(int i = 0; i < childrenSelections.size(); i++) {
                // We have to add wrapper, not the original selection, since it missing parent.
                SelectionWrapper childWrapper = childrenSelections.get(i);
                selectionList.add(childWrapper.getInsertPosition() + offset, childWrapper);
                offset++;
            }
        }
        else {
            selectionList.addAll(childrenSelections);
        }
    }
    
    // ===========================================================================
    //  Selections operations
    // ===========================================================================
        
    public List<Selection> selectFeatures(List<Selection> selections) {
        List<Selection> affectedSelections = new ArrayList<Selection>(selections.size());
        
        for(Selection selection: selections) {
            if(selectFeature(selection))
                affectedSelections.add(selection);
        }
        
        featuresSelected(affectedSelections);
        return affectedSelections;
    }
            
    public boolean canSelectFeature(Selection selection) {
        return virtualConnectionsOpposite.containsKey(selection);
    }

    private boolean selectFeature(Selection selection) {
        // Look for parent selection.
        Selection parentSelection = virtualConnectionsOpposite.get(selection);
        if(parentSelection == null)
            return false;
        
        // Look for sibling selections.
        List<SelectionWrapper> childrenSelections = virtualConnections.get(parentSelection);
        if(childrenSelections == null)
            return false;
        
        // Look for position between sibling selections.
        int index = -1;
        for(int i = 0; i < childrenSelections.size(); i++) {
            if(childrenSelections.get(i) == selection) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return false;
        
        // Insert selection to specified position.
        // Also increment position of other, yet unselected features.
        SelectionWrapper childWrapper = childrenSelections.remove(index);
        for(int i = index; i < childrenSelections.size(); i++)
            childrenSelections.get(i).incrementInsertPosition();
        parentSelection.getSelections().add(childWrapper.getInsertPosition(), childWrapper.getOriginalSelection());
        return true;
    }
    
    public void featuresSelected(List<Selection> selections) {
        rebuildVirtualConnections();
        fireFeaturesSelected(selections);
    }
    
    // ===========================================================================
    //  Unselections operations
    // ===========================================================================
    
    public List<Selection> unselectFeatures(List<Selection> selections) {
        List<Selection> affectedSelections = new ArrayList<Selection>(selections.size());
        
        for(Selection selection: selections) {
            if(unselectFeature(selection))
                affectedSelections.add(selection);
        }
        
        featuresUnselected(affectedSelections);
        return affectedSelections;
    }
    
    public boolean canUnselectFeature(Selection selection) {
        // Feature must be already selected.
        Selection parentSelection = selection.getParent();
        if(parentSelection == null)
            return false;
        
        String id = selection.getId();
        Feature feature = getFeatureModel().getFeatureById(id);
        if(feature == null)
            return false;
        
        // We cannot unselect mandatory feature.
        int count = 0;
        List<Selection> childrenSelections = parentSelection.getSelections();
        for(int i = 0; i < childrenSelections.size(); i++) {
            if(childrenSelections.get(i).getId().equals(id))
                count++;
        }
        return count > feature.getLower();
    }
    
    private boolean unselectFeature(Selection selection) {
        if(canUnselectFeature(selection)) {
            selection.setParent(null);
            return true;
        }
        return false;
    }

    public void featuresUnselected(List<Selection> selections) {
        rebuildVirtualConnections();
        fireFeaturesUnselected(selections);
    }
    
}
