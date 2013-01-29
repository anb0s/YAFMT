package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class GroupFeaturesAction extends SelectionAction {
    
    public static final String ID_XOR = "cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction.XOR";
    public static final String ID_OR = "cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction.OR";
    
    public static RetargetAction createRetargetAction(boolean xorGroup) {
        LabelRetargetAction action = new LabelRetargetAction(null, null);
        setActionProperties(action, xorGroup);        
        return action;
    }
    
    private static void setActionProperties(IAction action, boolean xorGroup) {
        if(xorGroup) {
            action.setId(ID_XOR);
            action.setText("Make XOR Group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-xor.png"));
        }
        else {
            action.setId(ID_OR);
            action.setText("Make OR Group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-or.png"));
        }
    }
    
    private boolean xorGroup;
    
    public GroupFeaturesAction(IWorkbenchPart part, boolean xorGroup) {
        super(part);
        this.xorGroup = xorGroup;
        // Do not call this code in init method since it its called in superclass constructor.
        setActionProperties(this, xorGroup);
    }
        
    @SuppressWarnings("unchecked")
    private Command getCommand() {
        List<Object> objects = getSelectedObjects();
        if((objects.size() < 2) || !(objects.get(0) instanceof EditPart))
            return null;
        
        EditPart parentEditPart = ((EditPart) objects.get(0)).getParent();
        if(parentEditPart == null)
            return null;
        
        String type = xorGroup ? RequestConstants.REQ_GROUP_FEATURES_XOR : RequestConstants.REQ_GROUP_FEATURES_OR;
        GroupRequest request = new GroupRequest(type);
        request.setEditParts(objects);
        return parentEditPart.getCommand(request);
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
