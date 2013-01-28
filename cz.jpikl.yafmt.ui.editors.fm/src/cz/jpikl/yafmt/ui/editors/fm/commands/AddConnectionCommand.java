package cz.jpikl.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;

public class AddConnectionCommand extends RecordingCommand {

    private EObject source;
    private Feature destination;
    
    public AddConnectionCommand(EObject source) {
        this.source = source;
    }
    
    public boolean setDestination(Feature destination) {
        if(destination.isRoot())
            return false;        
        if(EcoreUtil.isAncestor(destination, source))
            return false;

        this.destination = destination;
        setLabel("Make " + destination.getName() + " Subfeature of " + FeatureModelUtil.getParentName(destination));
        return true;
    }
    
    @Override
    protected void initializeRecording() {
        addRecordedObject(source);
        addRecordedObject(destination);
        addRecordedObjectParent(destination);
    }

    @Override
    protected void performRecording() {
        EObject destinationPreviousParent = destination.getParent();
        destination.setParent(source);
        FeatureModelUtil.removeUnneededGroup(destinationPreviousParent);
    }

}
