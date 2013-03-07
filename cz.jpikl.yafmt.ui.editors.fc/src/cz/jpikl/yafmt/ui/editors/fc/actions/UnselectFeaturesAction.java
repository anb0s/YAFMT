package cz.jpikl.yafmt.ui.editors.fc.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.jpikl.yafmt.ui.editors.fc.commands.UnselectFeatureCommand;

public class UnselectFeaturesAction extends FeatureSelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fc.actions.UnselectFeaturesAction";
    
    public static RetargetAction createRetargetAction() {
        LabelRetargetAction action = new LabelRetargetAction(ID, "Unselect Features");
        action.setImageDescriptor(FeatureConfigurationEditorPlugin.getImageDescriptor("icons/unselect-del.png"));
        return action;
    }
    
    public UnselectFeaturesAction(GraphicalEditor editor, FeatureConfigurationManager featureConfigManager) {
        super(editor, featureConfigManager);
        
        setId(ID);
        setText("Unselect Features");
        setImageDescriptor(FeatureConfigurationEditorPlugin.getImageDescriptor("icons/unselect.png"));
        
    }
    
    protected Command getCommand() {
        List<Selection> featuresToSelect = getSelectedFeatures();
        if(featuresToSelect == null)
            return null;
        return new UnselectFeatureCommand(getFeatureConfigManager(), featuresToSelect);
    }

}
