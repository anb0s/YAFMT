package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class FeatureTreeEditorContextMenuProvider extends ContextMenuProvider {

    private ActionRegistry registry;

    public FeatureTreeEditorContextMenuProvider(EditPartViewer viwer, ActionRegistry registry) {
        super(viwer);
        this.registry = registry;
    }

    @Override
    public void buildContextMenu(IMenuManager menu) {
        // Just returns id for already registered actions in action registry.
        menu.add(registry.getAction(ActionFactory.UNDO.getId()));
        menu.add(registry.getAction(ActionFactory.REDO.getId()));
        menu.add(registry.getAction(ActionFactory.DELETE.getId()));
    }

}
