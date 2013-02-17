package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.util.DockWidget;
import cz.jpikl.yafmt.ui.editors.fm.util.Splitter;

public class ConstraintsEditor extends DockWidget {
    
    private TableViewer viewer;
    
    public ConstraintsEditor(Splitter splitter) {
        super(splitter, SWT.NONE);
        setName("Constraints");
        setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("constraint"));
        setOpenToolTipText("Show Constraints");
        setCollapseToolTipText("Hide Constraints");
        
    }
    
    @Override
    protected Control createMainControl(Composite parent) {
        viewer = new TableViewer(parent);
        return viewer.getControl();
    }
    
    public void setSelection(ISelection selection) {
        
    }
    
    public void refreshContents(Collection<Feature> selectedFeatures) {
        
    }

}
