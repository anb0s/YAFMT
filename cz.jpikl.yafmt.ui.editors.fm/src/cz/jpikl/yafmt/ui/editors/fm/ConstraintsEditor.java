package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.util.Splitter;

public class ConstraintsEditor extends Composite {

    private static final int DEFAULT_SIZE = 200;
    private static final int COLLAPSED_SIZE = 25;
    
    private Splitter splitter;
    private Button collapseButton;
    private boolean collapsed;
    private int size;
    
    ConstraintsEditor(Splitter splitter) {
        super(splitter, SWT.NONE);
        
        this.splitter = splitter;
        this.size = DEFAULT_SIZE;
        this.collapsed = false;
        
        setLayout(createLayout());
        createTopControl(this);
        createEditorControl(this);
        
        splitter.maintainSize(this);
        updateState();
    }
    
    private Layout createLayout() {
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        return layout;
    }
    
    private void createTopControl(final Composite parent) {
        collapseButton = new Button(parent, SWT.NONE);
        collapseButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        collapseButton.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                switchState();
            }
        });
    }
    
    private void createEditorControl(Composite parent) {
        TableViewer viewer = new TableViewer(parent);
        viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    
    private void switchState() {
        collapsed = !collapsed;
        updateState();
    }
    
    private void updateState() {
        if(collapsed) {
            collapseButton.setText("Show");
            size = splitter.getFixedSize();
            splitter.setFixedSize(COLLAPSED_SIZE);
            splitter.setResizeEnabled(false);
        }
        else {
            collapseButton.setText("Hide");
            splitter.setFixedSize(size);
            splitter.setResizeEnabled(true);
        }
        splitter.layout();
    }
    
    public void setSelection(ISelection selection) {
        
    }
    
    public void refreshContents(Collection<Feature> selectedFeatures) {
        
    }

}
