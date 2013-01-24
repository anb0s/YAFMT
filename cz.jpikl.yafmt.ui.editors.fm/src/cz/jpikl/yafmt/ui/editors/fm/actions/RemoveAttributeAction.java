package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.RequestConstants;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class RemoveAttributeAction extends AttributeAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.RemoveAtributeAction";
    
    public RemoveAttributeAction(CommandStack commandStack) {
        super(commandStack);
        setId(ID);
        setText("Remove Attribute");
        setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
        setMenuCreator(new MenuCreator());
    }
    
    @Override
    public boolean isEnabled() {
        if(!super.isEnabled())
            return false;
        return !((Feature) getFeatureEditPart().getModel()).getAttributes().isEmpty();
    }
    
    @SuppressWarnings("unchecked")
    private void execute(int index) {
        FeatureEditPart featureEditPart = getFeatureEditPart();
        Request request = new Request(RequestConstants.REQ_REMOVE_ATTRIBUTE);
        request.getExtendedData().put("index", index);
        executeCommand(featureEditPart.getCommand(request));
    }
    
    private class MenuCreator implements IMenuCreator, SelectionListener {

        private Menu menu;
        
        @Override
        public Menu getMenu(Menu parent) {
            Feature feature = (Feature) getFeatureEditPart().getModel();
            List<Attribute> attributes = feature.getAttributes();
            
            menu = new Menu(parent);
            for(int i = 0; i < attributes.size(); i++) {
                MenuItem menuItem = new MenuItem(menu, SWT.NONE);
                menuItem.setText(attributes.get(i).getName());
                menuItem.setData(i);
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
            execute((Integer)((MenuItem) e.getSource()).getData());
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }
        
    }

}
