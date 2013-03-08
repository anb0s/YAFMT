package cz.jpikl.yafmt.ui.util;

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

    // ============================================================================
    //  ISelectionProvider
    // ============================================================================

    @Override
    public ISelection getSelection() {
        return SelectionConverter.unwrapSelection(viewer.getSelection());
    }

    @Override
    public void setSelection(ISelection selection) {
        viewer.setSelection(SelectionConverter.wrapSelection(selection, viewer.getEditPartRegistry()));
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.remove(listener);
    }

    // ============================================================================
    //  ISelectionChangedListener
    // ============================================================================

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        if(event.getSource() == viewer) {
            ISelection selection = SelectionConverter.unwrapSelection(event.getSelection());
            event = new SelectionChangedEvent(viewer, selection);
        }

        for(ISelectionChangedListener listener: listeners)
            listener.selectionChanged(event);
    }

}
