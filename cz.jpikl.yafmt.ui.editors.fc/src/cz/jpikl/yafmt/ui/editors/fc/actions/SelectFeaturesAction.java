package cz.jpikl.yafmt.ui.editors.fc.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.jpikl.yafmt.ui.editors.fc.commands.SelectFeatureCommand;

public class SelectFeaturesAction extends FeatureSelectionAction {

    public static final String ID = "cz.jpikl.yafmt.ui.editors.fc.actions.SelectFeaturesAction";
        
    public static RetargetAction createRetargetAction() {
        LabelRetargetAction action = new LabelRetargetAction(ID, "Select Features");
        action.setImageDescriptor(FeatureConfigurationEditorPlugin.getImageDescriptor("icons/select-del.png"));
        return action;
    }
    
    public SelectFeaturesAction(GraphicalEditor editor, FeatureConfigurationManager featureConfigManager) {
        super(editor, featureConfigManager);
        
        setId(ID);
        setText("Select Features");
        setImageDescriptor(FeatureConfigurationEditorPlugin.getImageDescriptor("icons/select.png"));
        
    }
    
    protected Command getCommand() {
        List<Selection> featuresToSelect = getSelectedFeatures();
        if(featuresToSelect == null)
            return null;
        return new SelectFeatureCommand(getFeatureConfigManager(), featuresToSelect);
    }

}
