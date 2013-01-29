package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.ui.editors.fm.actions.AddAttributeAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.DeleteAttributeAction;

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
        
        action = registry.getAction(DeleteAttributeAction.ID);
        if(action.isEnabled()) {
            menu.appendToGroup(GEFActionConstants.GROUP_ADD, new ActionContributionItem(action) {
                // Always regenerate menu when shown.
                @Override
                public boolean isDynamic() {
                    return true;
                }
            });
        }
        
        action = registry.getAction(ActionFactory.DELETE.getId());
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
    }

}
