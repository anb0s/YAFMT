package cz.jpikl.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;

import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureEditPart;

public abstract class AttributeAction extends CommandStackAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.AddAtributeAction";
    
    private GraphicalViewer viewer;
    
    public AttributeAction(CommandStack commandStack) {
        super(commandStack);
    }
    
    public void setGraphicalViewer(GraphicalViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean isEnabled() {
        List<Object> selectedEditParts = viewer.getSelectedEditParts();
        if(selectedEditParts.size() != 1)
            return false;
        return selectedEditParts.get(0) instanceof FeatureEditPart;
    }
    
    protected FeatureEditPart getFeatureEditPart() {
        return (FeatureEditPart) viewer.getSelectedEditParts().get(0);
    }
        
}
