package cz.jpikl.yafmt.ui.editors.fm.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;
import cz.jpikl.yafmt.ui.editors.fm.commands.GroupFeaturesCommand;
import cz.jpikl.yafmt.ui.editors.fm.commands.UngroupFeaturesCommand;
import cz.jpikl.yafmt.ui.editors.fm.layout.LayoutData;
import cz.jpikl.yafmt.ui.editors.fm.parts.FeatureModelEditPart;
import cz.jpikl.yafmt.ui.editors.fm.util.RequestConstants;

public class FeatureModelEditPolicy extends ComponentEditPolicy {

    @Override
    @SuppressWarnings("unchecked")
    public Command getCommand(Request request) {
        Object type = request.getType();
        if(RequestConstants.REQ_GROUP_FEATURES.equals(type)) {
            List<Object> selection = (List<Object>) request.getExtendedData().get("selection");
            boolean xorGroup = (Boolean) request.getExtendedData().get("xor");
            return createGroupFeaturesCommand(selection, xorGroup);
        }
        else if(RequestConstants.REQ_UNGROUP_FEATURES.equals(type)) {
            List<Object> selection = (List<Object>) request.getExtendedData().get("selection");
            return createUngroupFeaturesCommand(selection);
        }
        return super.getCommand(request);
    }

    private Command createGroupFeaturesCommand(List<Object> selectedEditParts, boolean xorGroup) {
        List<Feature> features = getFeatureSelection(selectedEditParts);
        if((features == null) || (features.size() < 2))
            return null;
        
        // Check if all features are sub-features of the same feature.
        EObject commonParent = null;
        for(Feature feature: features) {
            EObject parent = feature.getParent();
            if(parent == null)
                return null;
            if(parent instanceof Group)
                parent = ((Group) parent).getParent();
            if(commonParent == null)
                commonParent = parent;
            else if(parent != commonParent)
                return null;
        }
        
        LayoutData layoutData = ((FeatureModelEditPart) getHost()).getLayoutData();
        return new GroupFeaturesCommand(layoutData, features, xorGroup);
    }
    
    private Command createUngroupFeaturesCommand(List<Object> selectedEditParts) {
        List<Feature> features = getFeatureSelection(selectedEditParts);
        if((features == null) || features.isEmpty())
            return null;
        
        // Check if there is a parent group.
        boolean canExecute = false;
        for(Feature feature: features) {
            if(feature.getParentGroup() != null) {
                canExecute = true;
                break;
            }
        }
        if(!canExecute)
            return null;
        
        return new UngroupFeaturesCommand(features);
    }

    List<Feature> getFeatureSelection(List<Object> selectedEditParts) {
        for(Object selectedObject: selectedEditParts) {
            if(!(selectedObject instanceof EditPart))
                return null;
            Object model = ((EditPart) selectedObject).getModel();
            if(!(model instanceof Feature))
                return null;
        }
        
        List<Feature> features = new ArrayList<Feature>();
        for(Object selectedObject: selectedEditParts)
            features.add((Feature) ((EditPart) selectedObject).getModel());
        return features;
    }
    
}
