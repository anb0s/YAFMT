package cz.zcu.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;

public class AutoLayoutAction extends EditorPartAction {

    public static String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.AutoLayoutAction";

    public AutoLayoutAction(GraphicalEditor editor) {
        super(editor);
        setId(ID);
        setText("Apply Auto Layout");
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
