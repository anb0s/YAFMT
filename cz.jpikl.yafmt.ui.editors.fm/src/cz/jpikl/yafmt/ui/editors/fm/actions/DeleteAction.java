package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.ui.editors.fm.commands.DeleteConstraintCommand;

public class DeleteAction extends org.eclipse.gef.ui.actions.DeleteAction {

    public DeleteAction(IWorkbenchPart part) {
        super(part);
    }
    
    private Command getDeleteConstrainsCommand(Table table) {
        CompoundCommand command = new CompoundCommand();
        for(TableItem item: table.getSelection()) {
            Object object = item.getData();
            if(object instanceof Constraint)
                command.add(new DeleteConstraintCommand((Constraint) object));
        }
        return command;
    }
    
    @Override
    protected boolean calculateEnabled() {
        Control controlWithFocus = Display.getCurrent().getFocusControl();
        if(controlWithFocus instanceof Table) {
            // Constraints editor has focus.
            Command command = getDeleteConstrainsCommand((Table) controlWithFocus);
            return (command != null) && command.canExecute();
        }
        else {
            // GEF editor has focus.
            return super.calculateEnabled();
        }
    }
    
    @Override
    public void run() {
        Control controlWithFocus = Display.getCurrent().getFocusControl();
        if(controlWithFocus instanceof Table) {
            // Constraints editor has focus.
            execute(getDeleteConstrainsCommand((Table) controlWithFocus));
        }
        else {
            // GEF editor has focus.
            super.run();
        }
    }
  
}
