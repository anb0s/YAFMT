package cz.jpikl.yafmt.ui.editors.fm.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.services.IDisposable;

public class UnwrappingSelectionProvider implements ISelectionProvider, ISelectionChangedListener, IDisposable {

    private List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();
    private EditPartViewer viewer;
    
    public UnwrappingSelectionProvider(EditPartViewer viewer) {
        this.viewer = viewer;
        this.viewer.addSelectionChangedListener(this);
    }
    
    @Override
    public void dispose() {
        viewer.removeSelectionChangedListener(this);
        viewer = null;
    }
    
    @Override
    public ISelection getSelection() {
        return SelectionConverter.unwrapSelection(viewer.getSelection());
    }
    
    @Override
    public void setSelection(ISelection selection) {
        // This currently uses only Constraints Editor (called explicitly inside Feature Model Editor).
        fireSelectionChangedEvent(new SelectionChangedEvent(this, selection));
    }
    
    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        ISelection selection = SelectionConverter.unwrapSelection(event.getSelection());
        fireSelectionChangedEvent(new SelectionChangedEvent(this, selection));
    }
    
    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.remove(listener);
    }
    
    protected void fireSelectionChangedEvent(SelectionChangedEvent event) {
        for(ISelectionChangedListener listener: listeners)
            listener.selectionChanged(event);
    }
    
}
