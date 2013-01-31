package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.ui.IEditorPart;

import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class AutoLayoutAction extends EditorPartAction {

    public static String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.AutoLayoutAction";
    
    private GraphicalViewer viewer;
    
    public AutoLayoutAction(IEditorPart editorPart) {
        super(editorPart);
        setId(ID);
        setText("Apply Auto Layout");
    }
    
    public void setGraphicalViewer(GraphicalViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }
    
    private Command getCommand() {
        EditPart editPart = viewer.getRootEditPart().getContents();
        return editPart.getCommand(new Request(RequestConstants.REQ_AUTO_LAYOUT));
    }
    
    @Override
    public void run() {
        Command command = getCommand();
        viewer.getEditDomain().getCommandStack().execute(command);
    }

}
