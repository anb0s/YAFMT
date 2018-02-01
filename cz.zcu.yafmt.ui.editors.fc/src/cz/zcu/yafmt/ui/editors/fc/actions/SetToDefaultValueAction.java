package cz.zcu.yafmt.ui.editors.fc.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationEditorPlugin;

public class SetToDefaultValueAction extends SelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fc.actions.SetToDefaultValueAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setActionDefinitionId(ID);
        action.setText("Set To Default Value");
        action.setImageDescriptor(FeatureConfigurationEditorPlugin.getAccess().getImageDescriptor("default.png"));
        return action;
    }

    public SetToDefaultValueAction(GraphicalEditor editor) {
        super(editor);
        initAction(this);
    }

    protected Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;
        Request request = new Request("cz.zcu.yafmt.ui.editors.fc.requests.SetToDefaultValue");

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
