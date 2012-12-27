package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;

import cz.jpikl.yafmt.editors.featuremodel.actions.AddConstraintAction;

public class FeatureModelActionBarContributor extends MultiPageEditorActionBarContributor {

	// IActionBars.setGlobalActionHandler() - set action handler for existing global action (hook global action)
	// ToolBarManager.add() - add custom action to toolbar (use retarget action for hooking global actions)
	// MenuManager.add() - same as above, but for menu
	// IActionBars.updateActionBars() - commit changes!!!

	// How it works in GEF
	// When part is changed (setActivePart is called) ActionBarContributor gets all actions from ActionRegisry 
	// of selected part (initialized in GraphicalEditor) and hooks them via setGlobalActionHandler.
	// With help of retarget actions, the same actions can be added to toolbar.
	
	// When part is changed, all retarget actions gets their new action handler from the current part.
	// So do not use retarget actions since they do not react to multipage editor page change (only to whole part change).
			
	@Override
	public void setActivePage(IEditorPart editor) {
		IActionBars bars = getActionBars();
		bars.clearGlobalActionHandlers();
		bars.getToolBarManager().removeAll();
		
		if(editor instanceof FeatureTreeEditor)
			setFeatureTreeEditorActions((FeatureTreeEditor) editor);
		else if(editor instanceof ConstraintsEditor)
			setConstraintsEditorActions((ConstraintsEditor) editor);
		
		bars.updateActionBars();
		bars.getToolBarManager().update(true);
	}

	private void setGlobalActionHandler(ActionRegistry registry, String actionId) {
		getActionBars().setGlobalActionHandler(actionId, registry.getAction(actionId));
	}
	
	private void addToolBarAction(ActionRegistry registry, String actionId) {
		getActionBars().getToolBarManager().add(registry.getAction(actionId));
	}
	
	private void setFeatureTreeEditorActions(FeatureTreeEditor editor) {
		ActionRegistry registry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
		setGlobalActionHandler(registry, ActionFactory.UNDO.getId());
		setGlobalActionHandler(registry, ActionFactory.REDO.getId());
		setGlobalActionHandler(registry, ActionFactory.DELETE.getId());
		setGlobalActionHandler(registry, ActionFactory.SELECT_ALL.getId());
		addToolBarAction(registry, ActionFactory.UNDO.getId());
		addToolBarAction(registry, ActionFactory.REDO.getId());
		addToolBarAction(registry, ActionFactory.DELETE.getId());
	}
	
	private void setConstraintsEditorActions(ConstraintsEditor editor) {
		ActionRegistry registry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
		setGlobalActionHandler(registry, ActionFactory.UNDO.getId());
		setGlobalActionHandler(registry, ActionFactory.REDO.getId());
		setGlobalActionHandler(registry, ActionFactory.DELETE.getId());
		setGlobalActionHandler(registry, ActionFactory.SELECT_ALL.getId());
		addToolBarAction(registry, ActionFactory.UNDO.getId());
		addToolBarAction(registry, ActionFactory.REDO.getId());
		addToolBarAction(registry, AddConstraintAction.ID);
		addToolBarAction(registry, ActionFactory.DELETE.getId());
	}

}
