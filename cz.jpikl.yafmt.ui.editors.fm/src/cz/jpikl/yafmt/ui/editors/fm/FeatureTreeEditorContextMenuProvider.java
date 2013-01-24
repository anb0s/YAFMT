package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.ui.editors.fm.actions.AddAttributeAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.RemoveAttributeAction;

public class FeatureTreeEditorContextMenuProvider extends ContextMenuProvider {

    private ActionRegistry registry;
    
    public FeatureTreeEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry) {
        super(viewer);
        this.registry = registry;
    } 
    
    @Override
    public void buildContextMenu(IMenuManager menu) {
        GEFActionConstants.addStandardActionGroups(menu);
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, registry.getAction(ActionFactory.UNDO.getId()));
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, registry.getAction(ActionFactory.REDO.getId()));
        
        IAction action = registry.getAction(AddAttributeAction.ID);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_ADD, action);
        
        action = registry.getAction(RemoveAttributeAction.ID);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_ADD, action);
    }

}
