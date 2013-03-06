package cz.jpikl.yafmt.ui.editors.fc;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;

public class FeatureConfigurationManager {

    private FeatureConfiguration featureConfig;

    public FeatureConfigurationManager(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
        repairFeatureConfiguration();
        rebuildVirtualConnections();
    }
    
    private void repairFeatureConfiguration() {
        // Repair configuration structure against feature model copy.
        repairFeatureConfiguration(featureConfig.getRoot());
    }
    
    private void repairFeatureConfiguration(Selection selection) {
        // Repair configuration structure from given selection.
        // Used when adding new selection
    }
    
    
    
    

    private void rebuildVirtualConnections() {
        // Visit all existing selections and build map of virtual connections to unselected features. 
    }

    public void contributeModelChildren(List<Object> modelChildren, Selection selection) {
        // Add all child selections and unselected features (virtual connections) to modelChildren list.
    }
    
}
