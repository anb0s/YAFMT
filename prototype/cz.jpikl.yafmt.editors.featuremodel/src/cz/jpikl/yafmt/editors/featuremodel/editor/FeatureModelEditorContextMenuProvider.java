package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class FeatureModelEditorContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry registry;
	
	public FeatureModelEditorContextMenuProvider(EditPartViewer viwer, ActionRegistry registry) {
		super(viwer);
		this.registry = registry;
	}
		
	@Override
	public void buildContextMenu(IMenuManager menu) {
		menu.add(getAction(ActionFactory.UNDO.getId()));
		menu.add(getAction(ActionFactory.REDO.getId()));
		menu.add(getAction(ActionFactory.DELETE.getId()));
	}
	
	private IAction getAction(String id) {
		return registry.getAction(id);
	}
	
}
