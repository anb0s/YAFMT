package cz.jpikl.yafmt.editors.featureconfig.editor;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;

import cz.jpikl.yafmt.editors.featureconfig.actions.SelectAction;
import cz.jpikl.yafmt.editors.featureconfig.actions.UnselectAction;

public class FeatureConfigurationEditorContributor extends ActionBarContributor {

    @Override
    protected void buildActions() {
        addRetargetAction(new UndoRetargetAction());
        addRetargetAction(new RedoRetargetAction());
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
        addRetargetAction(SelectAction.createRetargetAction());
        addRetargetAction(UnselectAction.createRetargetAction());
    }

    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
        toolBarManager.add(getAction(SelectAction.ID));
        toolBarManager.add(getAction(UnselectAction.ID));
    }
        
    @Override
    protected void declareGlobalActionKeys() {       
    }

}
