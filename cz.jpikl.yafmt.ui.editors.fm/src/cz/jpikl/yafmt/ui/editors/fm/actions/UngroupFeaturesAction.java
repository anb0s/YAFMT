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

public class UngroupFeaturesAction extends SelectionAction {
    
    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.UngroupFeaturesAction";

    public static RetargetAction createRetargetAction() {
        LabelRetargetAction action = new LabelRetargetAction(ID, "Ungroup Features");
        action.setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-del.png"));
        return action;
    }
    
    public UngroupFeaturesAction(IWorkbenchPart part) {
        super(part);
    }
    
    @Override
    protected void init() {
        super.init();
        setId(ID);
        setText("Ungroup Features");
        setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/group-del.png"));
    }
    
    @SuppressWarnings("unchecked")
    private Command getCommand() {
        List<Object> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;
        
        EditPart parentEditPart = ((EditPart) objects.get(0)).getParent();
        if(parentEditPart == null)
            return null;
        
        Request request = new Request(RequestConstants.REQ_UNGROUP_FEATURES);
        request.getExtendedData().put("selection", objects);
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
