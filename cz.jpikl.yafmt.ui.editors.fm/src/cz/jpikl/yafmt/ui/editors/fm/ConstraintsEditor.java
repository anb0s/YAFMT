package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cz.jpikl.yafmt.clang.ConstraintLanguageDescriptor;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddConstraintCommand;
import cz.jpikl.yafmt.ui.editors.fm.util.DockWidget;
import cz.jpikl.yafmt.ui.editors.fm.util.Splitter;

public class ConstraintsEditor extends DockWidget {
        
    private FeatureModel featureModel;
    private TableViewer viewer;
    private EditDomain editDomain;
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
        viewer.setContentProvider(new ConstraintsEditorContentProvider());
        
        viewer.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent event) {
                Object selection = ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                if(selection == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
                    addNewConstraint();
            }
        });
        
        return viewer.getControl();
    }
    
    private void createTableViewerColumn(TableViewer viewer) {
        editingSupport = new ConstraintsEditorEditingSupport(viewer);
        
        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        column.getColumn().setWidth(100);
        column.setEditingSupport(editingSupport);
        column.setLabelProvider(new ConstraintsEditorLabelProvider());
    }
        
    private void addNewConstraint() {
        // Get last used language for constraint or find first available if no constraint exists yet.
        String langaugeId = null;
        List<Constraint> constraints = featureModel.getConstraints(); 
        if(!constraints.isEmpty()) {
            langaugeId = constraints.get(constraints.size() - 1).getLanguage();
        }
        else {
            ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
            Iterator<ConstraintLanguageDescriptor> iterator = registry.getDescriptors().iterator();
            if(iterator.hasNext())
                langaugeId = iterator.next().getId();
        }
        
        // Execute command to add new constraint.
        Constraint constraint = FeatureModelFactory.eINSTANCE.createConstraint();
        constraint.setLanguage(langaugeId);
        constraint.setValue("");
        Command command = new AddConstraintCommand(featureModel, constraint);
        editDomain.getCommandStack().execute(command);
        
        // Start constraint editing.
        viewer.editElement(constraint, 0);
    }
    
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        viewer.addSelectionChangedListener(listener);
    }
    
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        viewer.removeSelectionChangedListener(listener);
    }
    
    @Override
    public boolean setFocus() {
        return viewer.getControl().setFocus();
    }
    
    public void setEditDomain(EditDomain editDomain) {
        this.editDomain = editDomain;
        editingSupport.setEditDomain(editDomain);
    }
    
    public void setContents(FeatureModel featureModel) {
        this.featureModel = featureModel;
        viewer.setInput(featureModel);
    }
    
    public void filterContents(Collection<Feature> selectedFeatures) {
        
    }
    
    public void setSelection(ISelection selection) {
        
    }

}
