package cz.jpikl.yafmt.editors.featureconfig.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.editors.featureconfig.Activator;

public class UnselectAction extends SelectionAction {

    public static final String ID = "cz.jpikl.yafmt.editors.featureconfig.actions.UnselectAction";
    public static final String REQUEST = "cz.jpikl.yafmt.editors.featureconfig.requests.UnselectRequest";
    
    private static final Request REQUEST_OBJ = new Request(REQUEST);
    
    public static RetargetAction createRetargetAction() {
        // Image descriptor must be set, otherwise editor actions stop working when switching active page!!!
        LabelRetargetAction action = new LabelRetargetAction(ID, "Unselect Feature(s)");
        action.setImageDescriptor(Activator.getImageDescriptor("icons/unselect.gif"));
        return action;
    }
    
    public UnselectAction(IWorkbenchPart part) {
        super(part);   
    }
    
    @Override
    protected void init() {
        setId(ID);
        setText("Unselect Feature(s)");
        setImageDescriptor(Activator.getImageDescriptor("icons/unselect.gif"));
    }
    
    @Override
    protected boolean calculateEnabled() {
        for(Object object: getSelectedObjects()) {
            if(object instanceof EditPart) {
                if(((EditPart) object).getCommand(REQUEST_OBJ) != null)
                    return true;
            }
        }
        return false;
    }
    
    @Override
    public void run() {
        CompoundCommand command = new CompoundCommand();
        for(Object object: getSelectedObjects()) {
            if(object instanceof EditPart) {
                Command c = ((EditPart) object).getCommand(REQUEST_OBJ);
                if(c != null)
                    command.add(c);
            }
        }
        execute(command);
    }
    
}
