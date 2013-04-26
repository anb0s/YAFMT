package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;


public class SetFeatureOptimalSizeAction extends SelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.SetFeatureOptimalSizeAction";
    
    public SetFeatureOptimalSizeAction(IWorkbenchPart part) {
        super(part);
        setId(ID);
        setText("Set Optimal Size");
    }

    private Command getCommand() {
        List<?> editParts = getSelectedObjects();
        if(editParts.isEmpty() || !(editParts.get(0) instanceof EditPart))
            return null;
        
        Request request = new Request(RequestConstants.REQ_SET_FEATURE_OPTIMAL_SIZE);
        CompoundCommand command = new CompoundCommand();
        for(Object editPart: editParts)
            command.add(((EditPart) editPart).getCommand(request));
        return command;
    }
    
    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }
    
    @Override
    public void run() {
        execute(getCommand());
    }

}
