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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.ui.editors.fm.RequestConstants;

public class RemoveAttributeAction extends SelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.RemoveAtributeAction";
    
    public RemoveAttributeAction(IWorkbenchPart part) {
        super(part);
        setId(ID);
        
    }
    
    @Override
    protected void init() {
        super.init();
        setText("Remove Attribute");
        setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
        setMenuCreator(new MenuCreator());
    }
    
    @SuppressWarnings("unchecked")
    private Command getCommand(int attributeIndex) {
        List<Object> objects = getSelectedObjects();
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
            menu.dispose();
            menu = null;
        }


        @Override
        public void widgetSelected(SelectionEvent e) {
            execute((Command)((MenuItem) e.getSource()).getData());
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }
        
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

}
