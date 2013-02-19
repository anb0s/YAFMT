package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.Viewer;

public class SetConstraintLanguageAction extends Action {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.SetConstraintLanguageAction";
    
    private Viewer viewer;
    private EditDomain editDomain;
    
    public SetConstraintLanguageAction(Viewer viewer, EditDomain editDomain) {
        this.viewer = viewer;
        this.editDomain = editDomain;
        
        setId(ID);
        setText("Set Language");
    }
    
    private Command getCommand() {
        CompoundCommand command = new CompoundCommand();
        return command;
    }
    
    @Override
    public boolean isEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }
    
    @Override
    public void run() {
        editDomain.getCommandStack().execute(getCommand());
    }
    
}
