package cz.jpikl.yafmt.ui.editors.fm.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.gef.commands.Command;

public abstract class RecordingCommand extends Command {

    private Collection<Notifier> recordedObjects = new ArrayList<Notifier>();
    private InnerCommand innerCommand;
    
    protected void addRecordedObject(Notifier object) {
        if(object != null)
            recordedObjects.add(object);
    }
    
    protected void addRecordedObjects(Collection<Notifier> objects) {
        if(objects != null)
            recordedObjects.addAll(objects);
    }
    
    protected abstract void initializeRecording();
    
    protected abstract void performRecording();
        
    @Override
    public void execute() {
        initializeRecording();
        innerCommand = new InnerCommand(recordedObjects);
        innerCommand.execute();
    }
    
    @Override
    public void redo() {
        innerCommand.redo();
    }
    
    @Override
    public void undo() {
        innerCommand.undo();
    }
        
    private class InnerCommand extends ChangeCommand {
        
        public InnerCommand(Collection<Notifier> recordedObjects) {
            super(recordedObjects);
        }

        @Override
        protected void doExecute() {
            RecordingCommand.this.performRecording();
        }
        
    }
    
}
