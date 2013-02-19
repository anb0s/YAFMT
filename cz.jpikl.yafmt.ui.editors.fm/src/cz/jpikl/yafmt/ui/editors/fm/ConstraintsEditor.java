package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.actions.ActionFactory;

import cz.jpikl.yafmt.clang.ConstraintLanguageDescriptor;
import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;
import cz.jpikl.yafmt.clang.ConstraintLanguageRegistry;
import cz.jpikl.yafmt.clang.util.ConstraintCache;
import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelFactory;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetConstraintLanguageAction;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddConstraintCommand;
import cz.jpikl.yafmt.ui.editors.fm.util.DockWidget;
import cz.jpikl.yafmt.ui.editors.fm.util.Splitter;

public class ConstraintsEditor extends DockWidget {
        
    private FeatureModel featureModel;
    private FeatureModelAdapter featureModelAdapter;
    
    private ConstraintCache constraintCache;
    private IStructuredSelection outerSelection;
    private Set<Constraint> visibleConstraints;
    private ToolItem filterButton;
    private boolean filterEnabled;
    
    private ImageRegistry imageRegistry;
    private ActionRegistry actionRegistry;
    private EditDomain editDomain;
    private TableViewer viewer;
    private ConstraintsEditorEditingSupport editingSupport;
    private IContributionItem setLanguageAction;
    
    public ConstraintsEditor(Splitter splitter) {
        super(splitter, SWT.NONE);
                
        constraintCache = new ConstraintCache();
        visibleConstraints = new HashSet<Constraint>();
        filterEnabled = false;
        imageRegistry = FeatureModelEditorPlugin.getDefault().getImageRegistry();
    }
    
    @Override
    public void dispose() {
        if(featureModel != null)
            featureModel.eAdapters().remove(featureModelAdapter);
        super.dispose();
    }
    
    @Override
    protected void initializeControl() {
        setName("Constraints");
        setImage(imageRegistry.get("constraint"));
        setOpenToolTipText("Show Constraints");
        setCollapseToolTipText("Hide Constraints");
    }
    
    @Override
    protected Control createMainControl(Composite parent) {        
        viewer = new TableViewer(parent);
        
        createTableViewerColumn(viewer);        
        TableViewerEditor.create(viewer, new ConstraintsEditorActiovationStrategy(viewer), SWT.NONE);
        
        viewer.setContentProvider(new ConstraintsEditorContentProvider());
        viewer.addFilter(new ConstraintsFilter());
        viewer.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent event) {
                Object selection = ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                if(selection == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
                    addNewConstraint();
            }
        });
        viewer.getTable().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.keyCode == SWT.DEL) {
                    actionRegistry.getAction(ActionFactory.DELETE.getId()).run();
                }
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
    
    @Override
    protected void contributeToContextMenu(IMenuManager manager) {
        IAction deleteAction = actionRegistry.getAction(ActionFactory.DELETE.getId());
        if(deleteAction.isEnabled())
            manager.add(deleteAction);
        if(setLanguageAction.isEnabled())
            manager.add(setLanguageAction);
    }
    
    @Override
    protected void contributeToToolbar(ToolBar toolBar) {
        filterButton = new ToolItem(toolBar, SWT.NONE);
        filterButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                filterEnabled = !filterEnabled;
                updateFilterButton();
                refresh();
            }
        });
        updateFilterButton();
    }
    
    private void updateFilterButton() {
        if(filterEnabled) {
            filterButton.setImage(imageRegistry.get("filter-enabled"));
            filterButton.setToolTipText("Disable Filter");
        }
        else {
            filterButton.setImage(imageRegistry.get("filter-disabled"));
            filterButton.setToolTipText("Enable Filter");
        }
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
        visibleConstraints.add(constraint); // Make the new constraint visible.
        
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
    
    public void addKeyListener(final KeyListener listener) {
        viewer.getTable().addKeyListener(listener);
    }
    
    @Override
    public boolean setFocus() {
        return viewer.getControl().setFocus();
    }
    
    public void setActionRegistry(ActionRegistry actionRegistry) {
        this.actionRegistry = actionRegistry;
    }
    
    public void setEditDomain(EditDomain editDomain) {
        this.editDomain = editDomain;
        editingSupport.setEditDomain(editDomain);
        setLanguageAction = new ActionContributionItem(new SetConstraintLanguageAction(viewer, editDomain)) {
            @Override
            public boolean isDynamic() {
                return true; // Recreate language menu when show.
            }
        };
    }
    
    public void setContents(FeatureModel featureModel) {
        this.featureModel = featureModel;
        constraintCache.setFeatureModel(featureModel);
        viewer.setInput(featureModel);
        
        if(featureModel != null) {
            featureModelAdapter = new FeatureModelAdapter();
            featureModel.eAdapters().add(featureModelAdapter);
        }
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        refresh();
    }
    
    public void refresh() {
        if(!isVisible())
            return;
        
        if(filterEnabled) {
            visibleConstraints.clear();
            
            for(Object object: ((IStructuredSelection) outerSelection).toArray()) {
                if(object instanceof Constraint) {
                    visibleConstraints.add((Constraint) object);
                }
                else if(object instanceof Feature) {
                    Collection<Constraint> constraints = constraintCache.getConstraintsAffectingFeature((Feature) object);
                    if(constraints != null)
                        visibleConstraints.addAll(constraints);
                }
                else if(object instanceof FeatureModel) {
                    visibleConstraints.addAll(featureModel.getConstraints());
                }
            }
        }
        
        viewer.refresh();
    }
    
    public void setSelection(ISelection selection) {        
        if(!(selection instanceof IStructuredSelection))
            return;
        
        outerSelection = (IStructuredSelection) selection; 
       
        if(filterEnabled)
            refresh();
        else
            viewer.setSelection(selection);
    }
    
    private class ConstraintsFilter extends ViewerFilter {

        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if(!filterEnabled)
                return true;
            if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
                return true;
            return visibleConstraints.contains(element);
        }
        
    }
    
    private class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            constraintCache.invalidate();
        }
        
    }

}
