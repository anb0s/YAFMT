package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.jpikl.yafmt.ui.editors.fm.RequestConstants;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public class AddAttributeAction extends AttributeAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.AddAtributeAction";
        
    public AddAttributeAction(CommandStack commandStack) {
        super(commandStack);
        setId(ID);
        setText("Add Attribute");
        setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
    }
        
    @Override
    public void run() {
        FeatureEditPart featureEditPart = getFeatureEditPart();
        executeCommand(featureEditPart.getCommand(new Request(RequestConstants.REQ_ADD_ATTRIBUTE)));
    }
    
}
