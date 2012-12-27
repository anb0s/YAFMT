package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;

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

	private void setFeatureTreeEditorActions(FeatureTreeEditor editor) {
		IActionBars bars = getActionBars();
		
		ActionRegistry registry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), registry.getAction(ActionFactory.UNDO.getId()));
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), registry.getAction(ActionFactory.REDO.getId()));
		bars.setGlobalActionHandler(ActionFactory.DELETE.getId(), registry.getAction(ActionFactory.DELETE.getId()));
		bars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), registry.getAction(ActionFactory.SELECT_ALL.getId()));
		
		IToolBarManager toolbarManager = bars.getToolBarManager();
		toolbarManager.add(registry.getAction(ActionFactory.UNDO.getId()));
		toolbarManager.add(registry.getAction(ActionFactory.REDO.getId()));
		toolbarManager.add(registry.getAction(ActionFactory.DELETE.getId()));
	}
	
	private void setConstraintsEditorActions(ConstraintsEditor editor) {
		IActionBars bars = getActionBars();
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(),editor.undo);
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), editor.redo);
		bars.setGlobalActionHandler(ActionFactory.DELETE.getId(), editor.delete);
		
		IToolBarManager toolbarManager = bars.getToolBarManager();
		toolbarManager.add(editor.undo);
		toolbarManager.add(editor.redo);
		toolbarManager.add(editor.delete);
	}

}
