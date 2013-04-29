package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;


public class GenerateFeatureIdFromNameAction extends SelectionAction {
    
    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.GenerateFeatureIdFromName";
    
    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setActionDefinitionId(ID);
        action.setText("Generate ID from Name");
        action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("generate-id.png"));
        return action;
    }
    
    public GenerateFeatureIdFromNameAction(IWorkbenchPart part) {
        super(part);
        initAction(this);
    }

    private Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;

        Request request = new Request(RequestConstants.REQ_GEN_FEATURE_ID_FROM_NAME);
        
        CompoundCommand command = new CompoundCommand();
        for(Object object: objects)
            command.add(((EditPart) object).getCommand(request));
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
