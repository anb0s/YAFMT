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
import cz.jpikl.yafmt.ui.editors.fm.actions.AutoLayoutAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.DeleteAttributeAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.ExportAsImageAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;

public class FeatureTreeEditorContextMenuProvider extends ContextMenuProvider {

    private ActionRegistry registry;
    
    public FeatureTreeEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry) {
        super(viewer);
        this.registry = registry;
    } 
    
    private void addAction(IMenuManager menu, String groupId, String actionId) {
        IAction action = registry.getAction(actionId);
        if(action.isEnabled())
            menu.appendToGroup(groupId, action);
    }
    
    @Override
    public void buildContextMenu(IMenuManager menu) {
        GEFActionConstants.addStandardActionGroups(menu);
        
        addAction(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.UNDO.getId());
        addAction(menu, GEFActionConstants.GROUP_UNDO, ActionFactory.REDO.getId());
        addAction(menu, GEFActionConstants.GROUP_ADD, AddAttributeAction.ID);
        
        IAction action = registry.getAction(DeleteAttributeAction.ID);
        if(action.isEnabled()) {
            menu.appendToGroup(GEFActionConstants.GROUP_ADD, new ActionContributionItem(action) {
                // Always regenerate menu when shown.
                @Override
                public boolean isDynamic() {
                    return true;
                }
            });
        }        
        
        addAction(menu, GEFActionConstants.GROUP_EDIT, ActionFactory.DELETE.getId());
        addAction(menu, GEFActionConstants.GROUP_REST, SetFeatureCardinalityAction.ID_OPTIONAL);
        addAction(menu, GEFActionConstants.GROUP_REST, SetFeatureCardinalityAction.ID_MANDATORY);
        addAction(menu, GEFActionConstants.GROUP_REST, GroupFeaturesAction.ID_XOR);
        addAction(menu, GEFActionConstants.GROUP_REST, GroupFeaturesAction.ID_OR);
        addAction(menu, GEFActionConstants.GROUP_REST, UngroupFeaturesAction.ID);
        addAction(menu, GEFActionConstants.GROUP_SAVE, AutoLayoutAction.ID);
        addAction(menu, GEFActionConstants.GROUP_SAVE, ExportAsImageAction.ID);     
    }
    
}
