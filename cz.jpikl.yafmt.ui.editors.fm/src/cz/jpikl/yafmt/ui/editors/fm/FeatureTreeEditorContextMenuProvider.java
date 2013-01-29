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
import cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;

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
        
        IAction action = registry.getAction(ActionFactory.DELETE.getId());
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        action = registry.getAction(AddAttributeAction.ID);
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
        
        action = registry.getAction(SetFeatureCardinalityAction.ID_OPTIONAL);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        
        action = registry.getAction(SetFeatureCardinalityAction.ID_MANDATORY);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        
        action = registry.getAction(GroupFeaturesAction.ID_XOR);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        
        action = registry.getAction(GroupFeaturesAction.ID_OR);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        
        action = registry.getAction(UngroupFeaturesAction.ID);
        if(action.isEnabled())
            menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        
    }

}
