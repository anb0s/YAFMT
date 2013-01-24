package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.gef.ui.actions.ActionBarContributor;
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

public class FeatureModelEditorContributor extends ActionBarContributor implements IPageChangedListener {

    private MultiPageEditorPart activeEditor;
    
    @Override
    public void dispose() {
        if(activeEditor != null)
            activeEditor.removePageChangedListener(this);
        super.dispose();
    }
    
    @Override
    public void setActiveEditor(IEditorPart editor) {
        if(activeEditor != null)
            activeEditor.removePageChangedListener(this);
        activeEditor = (MultiPageEditorPart) editor;
        activeEditor.addPageChangedListener(this);
        setActivePage((IEditorPart) activeEditor.getSelectedPage());
    }
    
    public void setActivePage(IEditorPart editor) {
        super.setActiveEditor(editor);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void pageChanged(PageChangedEvent event) {
        IEditorPart activaPage = (IEditorPart) event.getSelectedPage();
        setActivePage(activaPage);
        
        // Manualy update actions when page changes (actions react only to editor part changes).
        Iterator<Map.Entry<String, IAction>> it = getActionRegistry().getActions();
        while(it.hasNext()) {
            IAction action = it.next().getValue();
            if(action instanceof RetargetAction)
                ((RetargetAction) action).partActivated(activaPage);
        }
    }
    
    @Override
    protected void buildActions() {
        addRetargetAction(new UndoRetargetAction());
        addRetargetAction(new RedoRetargetAction());
        addRetargetAction(new LabelRetargetAction(ActionFactory.SELECT_ALL.getId(), "Select All"));
    }
    
    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));
    }

    @Override
    protected void declareGlobalActionKeys() {
    }

}