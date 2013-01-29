package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class GroupFeaturesAction extends SelectionAction {
    
    public static final String ID_XOR = "cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction.XOR";
    public static final String ID_OR = "cz.jpikl.yafmt.ui.editors.fm.actions.GroupFeaturesAction.OR";

    public static RetargetAction createRetargetAction(boolean xorGroup) {
        LabelRetargetAction action;
        
        if(xorGroup) {
            action = new LabelRetargetAction(ID_XOR, "Make XOR group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-xor.png"));
        }
        else {
            action = new LabelRetargetAction(ID_OR, "Make OR group");
            action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-or.png"));
        }
        
        return action;
    }
    
    private boolean xorGroup;
    
    public GroupFeaturesAction(IWorkbenchPart part, boolean xorGroup) {
        super(part);
        this.xorGroup = xorGroup;
        
        // Do not call this code in init method since it its called in superclass constructor.
        if(xorGroup) {
            setId(ID_XOR);
            setText("Make XOR Group");
            setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-xor.png"));
        }
        else {
            setId(ID_OR);
            setText("Make OR Group");
            setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-or.png"));
        }
    }
        
    @SuppressWarnings("unchecked")
    private Command getCommand() {
        List<Object> objects = getSelectedObjects();
        if((objects.size() < 2) || !(objects.get(0) instanceof EditPart))
            return null;
        
        EditPart parentEditPart = ((EditPart) objects.get(0)).getParent();
        if(parentEditPart == null)
            return null;
        
        Request request = new Request(RequestConstants.REQ_GROUP_FEATURES);
        request.getExtendedData().put("selection", objects);
        request.getExtendedData().put("xor", xorGroup);
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
