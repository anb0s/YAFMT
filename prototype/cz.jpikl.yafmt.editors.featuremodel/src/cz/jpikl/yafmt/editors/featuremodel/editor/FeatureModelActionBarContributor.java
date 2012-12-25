package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.part.MultiPageEditorPart;

public class FeatureModelActionBarContributor extends ActionBarContributor {
	
	@Override
	public ActionRegistry getActionRegistry() {
		return super.getActionRegistry();
	}
	
	@Override
	public void setActiveEditor(IEditorPart part) {
        if (part instanceof MultiPageEditorPart) {
            Object page = ((MultiPageEditorPart) part).getSelectedPage();
            if(page instanceof IEditorPart)
            	part = (IEditorPart) page;
        }
        super.setActiveEditor(part);
    }
		
	@Override
	protected void buildActions() {
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
		addRetargetAction(new DeleteRetargetAction());
		addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// getAction looks for the action in action registry
		// register necessary actions in the action registry during editor creation (via addAction). 
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
	}
	
	@Override
	protected void declareGlobalActionKeys() {
	} 

}
