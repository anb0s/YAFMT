package cz.jpikl.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.jpikl.yafmt.ui.editors.fc.IFeatureConfigurationListener;
import cz.jpikl.yafmt.ui.editors.fc.figures.FeatureConfigurationFigure;

public class FeatureConfigurationEditPart extends AbstractGraphicalEditPart implements IFeatureConfigurationListener {

    private FeatureConfigurationManager featureConfigManager;
    private FeatureConfiguration featureConfig;

    public FeatureConfigurationEditPart(FeatureConfigurationManager featureConfigManager, FeatureConfiguration featureConfig) {
        this.featureConfigManager = featureConfigManager;
        this.featureConfig = featureConfig;
        setModel(featureConfig);
    }

    @Override
    public void activate() {
        super.activate();
        featureConfigManager.addFeatureConfigurationListener(this);
    }

    @Override
    public void deactivate() {
        featureConfigManager.removeFeatureConfigurationListener(this);
        super.deactivate();
    }

    @Override
    protected IFigure createFigure() {
        return new FeatureConfigurationFigure();
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelChildren() {
        List<Selection> modelChildren = new ArrayList<Selection>();
        modelChildren.add(featureConfig.getRoot());
        contributeModelChildren(modelChildren, featureConfig.getRoot());
        return modelChildren;
    }

    private void contributeModelChildren(List<Selection> modelChildren, Selection selection) {
        featureConfigManager.contributeChildrenSelections(selection, modelChildren, false);
        for(Selection childSelection: selection.getSelections())
            contributeModelChildren(modelChildren, childSelection);
    }

    @Override
    protected void createEditPolicies() {
    }

    private void refreshAll() {
        refresh();
        for(Object child: getChildren())
            ((EditPart) child).refresh();
        getFigure().getLayoutManager().layout(getFigure()); // We need to refresh connection anchors.
    }

    @Override
    public void featuresSelected(List<Selection> selections) {
        refreshAll();
    }

    @Override
    public void featuresDeselected(List<Selection> selections) {
        refreshAll();
    }

}
