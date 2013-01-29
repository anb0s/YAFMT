package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class SetFeatureCardinalityAction extends SelectionAction {

    public static final String ID_MANDATORY = "cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction.Mandatory";
    public static final String ID_OPTIONAL = "cz.jpikl.yafmt.ui.editors.fm.actions.SetFeatureCardinalityAction.Optional";
    
    public static RetargetAction createRetargetAction(boolean mandatory) {
        LabelRetargetAction action = new LabelRetargetAction(null, null);
        setActionProperties(action, mandatory);        
        return action;
    }
    
    private static void setActionProperties(IAction action, boolean mandatory) {
        if(mandatory) {
            action.setId(ID_MANDATORY);
            action.setText("Make Features Mandatory");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/feature-man.png"));
        }
        else {
            action.setId(ID_OPTIONAL);
            action.setText("Make Features Optional");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/feature-opt.png"));
        }
    }
        
    private boolean mandatory;

    public SetFeatureCardinalityAction(IWorkbenchPart part, boolean mandatory) {
        super(part);
        this.mandatory = mandatory;
        // Do not call this code in init method since it its called in superclass constructor.
        setActionProperties(this, mandatory);
    }

    @SuppressWarnings("unchecked")
    private Command getCommand() {
        List<Object> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;
        
        String type = mandatory ? RequestConstants.REQ_MAKE_FEATURES_MAN :RequestConstants.REQ_MAKE_FEATURES_OPT; 
        GroupRequest request = new GroupRequest(type);
        request.setEditParts(objects);

        String name = "Make Features " + (mandatory ? "Mandatory" : "Optional");
        CompoundCommand compoundCommand = new CompoundCommand(name);
        for (Object object: objects) {
            Command command = ((EditPart) object).getCommand(request);
            if(command != null)
                compoundCommand.add(command);
        }
        return compoundCommand;
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
