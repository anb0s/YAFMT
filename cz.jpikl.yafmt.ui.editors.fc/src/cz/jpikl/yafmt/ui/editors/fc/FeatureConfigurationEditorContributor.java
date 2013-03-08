package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;

import cz.jpikl.yafmt.ui.actions.ShowFeatureModelVisualizerAction;
import cz.jpikl.yafmt.ui.editors.fc.actions.SelectFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fc.actions.DeselectFeaturesAction;

public class FeatureConfigurationEditorContributor extends ActionBarContributor {

    @Override
    protected void buildActions() {
        addRetargetAction(new UndoRetargetAction());
        addRetargetAction(new RedoRetargetAction());
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
        addRetargetAction(SelectFeaturesAction.createRetargetAction());
        addRetargetAction(DeselectFeaturesAction.createRetargetAction());
        addRetargetAction(ShowFeatureModelVisualizerAction.createRetargetAction());
    }

    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
        toolBarManager.add(getAction(SelectFeaturesAction.ID));
        toolBarManager.add(getAction(DeselectFeaturesAction.ID));
        toolBarManager.add(getAction(ShowFeatureModelVisualizerAction.ID));
    }

    @Override
    protected void declareGlobalActionKeys() {
    }

}
