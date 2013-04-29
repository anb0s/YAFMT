package cz.zcu.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class AutoLayoutAction extends EditorPartAction {

    public static String ID = "cz.zcu.yafmt.ui.editors.fm.actions.AutoLayoutAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }
    
    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Apply Auto Layout");
        action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("auto-layout.png"));
        return action;
    }

    public AutoLayoutAction(GraphicalEditor editor) {
        super(editor);
        initAction(this);
    }

    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }

    private Command getCommand() {
        GraphicalViewer viewer = (GraphicalViewer) getEditorPart().getAdapter(GraphicalViewer.class);
        EditPart editPart = viewer.getRootEditPart().getContents();
        return editPart.getCommand(new Request(RequestConstants.REQ_AUTO_LAYOUT));
    }

    @Override
    public void run() {
        execute(getCommand());
    }

}
