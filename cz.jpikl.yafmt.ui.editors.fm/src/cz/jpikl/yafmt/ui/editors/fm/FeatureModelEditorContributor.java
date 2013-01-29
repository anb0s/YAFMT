package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.part.MultiPageEditorPart;

import cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction;
import cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction;

public class FeatureModelEditorContributor extends ActionBarContributor implements IPageChangedListener {

    private MultiPageEditorPart multipageEditor;
    
    @Override
    public void dispose() {
        disposeMultipageEditor();
        super.dispose();
    }
    
    private void disposeMultipageEditor() {
        if(multipageEditor != null) {
            multipageEditor.removePageChangedListener(this);
            multipageEditor = null;
        }
    }
    
    @Override
    public void setActiveEditor(IEditorPart editor) {
        disposeMultipageEditor();
                
        if(editor instanceof MultiPageEditorPart) {
            multipageEditor = (MultiPageEditorPart) editor;
            multipageEditor.addPageChangedListener(this);
            editor = (IEditorPart) multipageEditor.getSelectedPage();
        }
        
        super.setActiveEditor(editor);
    }
        
    @Override
    @SuppressWarnings("unchecked")
    public void pageChanged(PageChangedEvent event) {
        IEditorPart activePage = (IEditorPart) event.getSelectedPage();
        super.setActiveEditor(activePage);
        
        // Manually update actions when page changes (actions react only to editor part changes).
        Iterator<Map.Entry<String, IAction>> it = getActionRegistry().getActions();
        while(it.hasNext()) {
            IAction action = it.next().getValue();
            if(action instanceof RetargetAction)
                ((RetargetAction) action).partActivated(activePage);
        }
    }
    
    @Override
    protected void buildActions() {
        addRetargetAction(new UndoRetargetAction());
        addRetargetAction(new RedoRetargetAction());
        addRetargetAction(new DeleteRetargetAction());
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
        addRetargetAction(GroupFeaturesAction.createRetargetAction(true));
        addRetargetAction(GroupFeaturesAction.createRetargetAction(false));
        addRetargetAction(UngroupFeaturesAction.createRetargetAction());
    }
    
    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
        toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
        toolBarManager.add(getAction(GroupFeaturesAction.ID_XOR));
        toolBarManager.add(getAction(GroupFeaturesAction.ID_OR));
        toolBarManager.add(getAction(UngroupFeaturesAction.ID));
    }

    @Override
    protected void declareGlobalActionKeys() {
    }

}
