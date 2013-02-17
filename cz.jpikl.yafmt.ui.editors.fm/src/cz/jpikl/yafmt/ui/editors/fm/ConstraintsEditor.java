package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;

import org.eclipse.gef.EditDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.util.DockWidget;
import cz.jpikl.yafmt.ui.editors.fm.util.Splitter;

public class ConstraintsEditor extends DockWidget {
    
    private TableViewer viewer;
    private ConstraintsEditorEditingSupport editingSupport;
    
    public ConstraintsEditor(Splitter splitter) {
        super(splitter, SWT.NONE);
        
        // This is called after createMainControl which is called in superclass constructor.
        setName("Constraints");
        setImage(FeatureModelEditorPlugin.getDefault().getImageRegistry().get("constraint"));
        setOpenToolTipText("Show Constraints");
        setCollapseToolTipText("Hide Constraints");
    }
    
    @Override
    protected Control createMainControl(Composite parent) {        
        viewer = new TableViewer(parent);
        createTableViewerColumn(viewer);        
        TableViewerEditor.create(viewer, new ConstraintsEditorActiovationStrategy(viewer), SWT.NONE);
        viewer.setContentProvider(new ConstraintsEditorProvider());
        return viewer.getControl();
    }
    
    private void createTableViewerColumn(TableViewer viewer) {
        editingSupport = new ConstraintsEditorEditingSupport(viewer);
        
        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        column.getColumn().setWidth(100);
        column.setEditingSupport(editingSupport);
        column.setLabelProvider(new ConstraintsEditorLabelProvider());
    }
    
    public void setEditDomain(EditDomain editDomain) {
        editingSupport.setEditDomain(editDomain);
    }
    
    public void setContents(FeatureModel featureModel) {
        viewer.setInput(featureModel);
    }
    
    public void filterContents(Collection<Feature> selectedFeatures) {
        
    }
    
    public void setSelection(ISelection selection) {
        
    }

}
