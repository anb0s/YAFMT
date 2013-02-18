package cz.jpikl.yafmt.ui.editors.fm.actions;

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
    
    @Override
    protected boolean calculateEnabled() {
        Control controlWithFocus = Display.getCurrent().getFocusControl();
        if(controlWithFocus instanceof Table) {
            // Constraints editor has focus.
            Table constraintsTable = (Table) controlWithFocus;
            TableItem[] items = constraintsTable.getSelection();
            if(items == null)
                return false;
            for(TableItem item: items) {
                if(item.getData() instanceof Constraint)
                    return true;
            }
            return false;
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
            CompoundCommand command = new CompoundCommand();
            Table constraintsTable = (Table) controlWithFocus;
            for(TableItem item: constraintsTable.getSelection()) {
                Object data = item.getData();
                if(data instanceof Constraint)
                    command.add(new DeleteConstraintCommand((Constraint) data));
            }
            execute(command);
        }
        else {
            // GEF editor has focus.
            super.run();
        }
    }
  
}
