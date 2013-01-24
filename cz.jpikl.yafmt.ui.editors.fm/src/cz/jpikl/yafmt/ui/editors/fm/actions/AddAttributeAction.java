package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.ui.editors.fm.RequestConstants;

public class AddAttributeAction extends SelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.AddAtributeAction";
        
    public AddAttributeAction(IWorkbenchPart part) {
        super(part);
    }
    
    @Override
    protected void init() {
        super.init();
        setId(ID);
        setText("Add Attribute");
        setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
    }
    
    @SuppressWarnings("unchecked")
    private Command getCommand() {
        List<Object> objects = getSelectedObjects();
        if((objects.size() != 1) || !(objects.get(0) instanceof EditPart))
            return null;
        EditPart editPart = (EditPart) objects.get(0);
        return editPart.getCommand(new Request(RequestConstants.REQ_ADD_ATTRIBUTE));
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
