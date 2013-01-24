package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;

public abstract class CommandStackAction extends Action {

    private CommandStack commandStack;

    public CommandStackAction(CommandStack commandStack) {
        this.commandStack = commandStack;
    }
        
    protected void executeCommand(Command command) {
        if(command != null)
            commandStack.execute(command);
    }
    
}
