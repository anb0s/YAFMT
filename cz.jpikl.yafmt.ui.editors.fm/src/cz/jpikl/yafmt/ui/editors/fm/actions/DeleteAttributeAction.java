package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPart;

import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class DeleteAttributeAction extends SelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.DeleteAtributeAction";
    
    public DeleteAttributeAction(IWorkbenchPart part) {
        super(part);
    }
    
    @Override
    protected void init() {
        super.init();
        setId(ID);
        setText("Delete Attribute");
        setImageDescriptor(FeatureModelEditorPlugin.getImageDescriptor("icons/attribute-del.png"));
        setMenuCreator(new MenuCreator());
    }
    
    @SuppressWarnings("unchecked")
    private Command getCommand(int attributeIndex) {
        List<?> objects = getSelectedObjects();
        if((objects.size() != 1) || !(objects.get(0) instanceof EditPart))
            return null;
        Request request = new Request(RequestConstants.REQ_REMOVE_ATTRIBUTE);
        request.getExtendedData().put("index", attributeIndex);
        EditPart editPart = (EditPart) objects.get(0);
        return editPart.getCommand(request);
    }
    
    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand(0);
        return (command != null) && command.canExecute();
    }
            
    private class MenuCreator implements IMenuCreator, SelectionListener {

        private Menu menu;
        
        @Override
        public Menu getMenu(Menu parent) {
            dispose();
            
            menu = new Menu(parent);
            for(int i = 0; ; i++) {
                Command command = getCommand(i);
                if(command == null)
                    break;
                MenuItem menuItem = new MenuItem(menu, SWT.NONE);
                menuItem.setText(command.toString());
                menuItem.setData(command);
                menuItem.addSelectionListener(this);
            }
            return menu;
        }
        
        @Override
        public Menu getMenu(Control parent) {
            return null;
        }
        
        @Override
        public void dispose() {
            if(menu != null) {
                menu.dispose();
                menu = null;
            }
        }


        @Override
        public void widgetSelected(SelectionEvent e) {
            execute((Command)((MenuItem) e.getSource()).getData());
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }
        
    }

}
