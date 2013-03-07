package cz.jpikl.yafmt.ui.editors.fc.model;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import cz.jpikl.yafmt.model.fc.AttributeValue;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.FeatureConfigurationPackage;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.util.EObjectDecorator;

// Wrapper for unselected feature (selection with no parent).
public class SelectionWrapper extends EObjectDecorator implements Selection {

    private FeatureConfiguration featureConfig;
    private Selection selection;
    private int insertPosition;
    
    public SelectionWrapper(FeatureConfiguration featureConfig, Selection selection) {
        this(featureConfig, selection, -1);
    }
    
    public SelectionWrapper(FeatureConfiguration featureConfig, Selection selection, int insertPosition) {
        super(selection);
        this.featureConfig = featureConfig;
        this.selection = selection;
        this.insertPosition = insertPosition;
    }
    
    public Selection getOriginalSelection() {
        return selection;
    }
    
    public int getInsertPosition() {
        return insertPosition;
    }
    
    public void incrementInsertPosition() {
        insertPosition++;
    }
    
    // ===============================================================
    // Modified operations
    // ===============================================================
    
    @Override
    public FeatureConfiguration getFeatureConfiguration() {
        return featureConfig;
    }
    
    @Override
    public Feature getFeature() {
        return featureConfig.getFeatureModelCopy().getFeatureById(selection.getId());
    }
    
    @Override
    public String getName() {
        return getFeature().getName();
    }
    
    @Override
    public String getDescription() {
        return getFeature().getDescription();
    }
    
    @Override
    public EList<AttributeValue> getValues() {
        // Hide attribute values for unselected feature.
        if(selection.getParent() == null)
            return ECollections.emptyEList();
        return selection.getValues();
    }
    
    @Override
    public Object eGet(EStructuralFeature feature) {
        return eGet(feature, true);
    }
    
    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        if(feature == FeatureConfigurationPackage.Literals.SELECTION__FEATURE_CONFIGURATION)
            return featureConfig;
        if(feature == FeatureConfigurationPackage.Literals.SELECTION__FEATURE)
            return getFeature();
        if(feature == FeatureConfigurationPackage.Literals.SELECTION__NAME)
            return getName();
        if(feature == FeatureConfigurationPackage.Literals.SELECTION__DESCRIPTION)
            return getDescription();
        if(feature == FeatureConfigurationPackage.Literals.SELECTION__VALUES)
            return getValues();
        return super.eGet(feature, resolve);
    }
        
    // ===============================================================
    //  Operations calling original methods
    // ===============================================================
        
    @Override
    public String getId() {
        return selection.getId();
    }

    @Override
    public void setId(String value) {
        selection.setId(value);
    }

    @Override
    public Selection getParent() {
        return selection.getParent();
    }

    @Override
    public void setParent(Selection value) {
        selection.setParent(value);
    }

    @Override
    public boolean isRoot() {
        return selection.isRoot();
    }

    @Override
    public EList<Selection> getSelections() {
        return selection.getSelections();
    }

    @Override
    public int hashCode() {
        return selection.hashCode(); // !!! Important.
    }
    
    @Override
    public boolean equals(Object obj) {
        return selection.equals(obj); // !!! Important.
    }
        
}
