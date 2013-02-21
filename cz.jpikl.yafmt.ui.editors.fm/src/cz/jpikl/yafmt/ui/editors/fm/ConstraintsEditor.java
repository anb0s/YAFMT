package cz.jpikl.yafmt.ui.editors.fm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditor;
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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.ui.editors.fm.actions.SetConstraintLanguageAction;
import cz.jpikl.yafmt.ui.editors.fm.commands.AddConstraintCommand;
import cz.jpikl.yafmt.ui.editors.fm.util.DynamicContributionItem;
import cz.jpikl.yafmt.ui.editors.fm.widgets.Splitter;
import cz.jpikl.yafmt.ui.editors.fm.widgets.SplitterDock;

public class ConstraintsEditor extends SplitterDock {
        
    private FeatureModel featureModel;
    private FeatureModelAdapter featureModelAdapter = new FeatureModelAdapter();
    
    private ConstraintCache constraintCache = new ConstraintCache();
    private Set<Constraint> visibleConstraints = new HashSet<Constraint>();
    private IStructuredSelection outerSelection;
    
    private boolean filterEnabled = false;
    private ToolItem filterButton;
    private Image filterEnabledImage;
    private Image filterDisabledImage;
    
    private TableViewer viewer;
    private CommandStack commandStack;
    private ActionRegistry actionRegistry;
    private IContributionItem setLanguageAction;
    
    public ConstraintsEditor(Splitter splitter, GraphicalEditor editor) {
        super(splitter, SWT.NONE);
                
        ImageRegistry imageRegistry = FeatureModelEditorPlugin.getDefault().getImageRegistry(); 
        filterEnabledImage = imageRegistry.get("filter-enabled");
        filterDisabledImage = imageRegistry.get("filter-disabled");
        
        commandStack = (CommandStack) editor.getAdapter(CommandStack.class);
        actionRegistry = (ActionRegistry) editor.getAdapter(ActionRegistry.class);
        
        featureModel = (FeatureModel) editor.getAdapter(FeatureModel.class);
        featureModel.eAdapters().add(featureModelAdapter);
        constraintCache.setFeatureModel(featureModel);
        
        buildControl();
        
        setName("Constraints");
        setImage(imageRegistry.get("constraint"));
        setOpenToolTipText("Show Constraints");
        setCollapseToolTipText("Hide Constraints");
    }
    
    @Override
    public void dispose() {
        featureModel.eAdapters().remove(featureModelAdapter);
        super.dispose();
    }
    
    @Override
    protected Control createControl(Composite parent) {
        viewer = new TableViewer(parent);
        createViewerColumn();        
        createViewerActivationStrategy();
        createViewerActions();
        configureViewer();
        return viewer.getControl();
    }
    
    private void createViewerColumn() {
        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        column.getColumn().setWidth(100); // Number does not matter.
        column.setEditingSupport(new ConstraintsEditorEditingSupport(viewer, commandStack));
        column.setLabelProvider(new ConstraintsEditorLabelProvider());
    }
    
    private void createViewerActivationStrategy() {
        TableViewerEditor.create(viewer, new ConstraintsEditorActivationStrategy(viewer), SWT.NONE);
    }
    
    private void createViewerActions() {
        setLanguageAction = new DynamicContributionItem(new SetConstraintLanguageAction(viewer, commandStack));
    }
    
    private void configureViewer() {
        viewer.setContentProvider(new ConstraintsEditorContentProvider());
        viewer.addFilter(new ConstraintsFilter());
        viewer.setInput(featureModel);
        
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
                refreshFilterButton();
                refresh();
            }
        });
        refreshFilterButton();
    }
    
    private void refreshFilterButton() {
        if(filterEnabled) {
            filterButton.setImage(filterEnabledImage);
            filterButton.setToolTipText("Disable Filter");
        }
        else {
            filterButton.setImage(filterDisabledImage);
            filterButton.setToolTipText("Enable Filter");
        }
    }
        
    private void addNewConstraint() {
        Constraint constraint = FeatureModelFactory.eINSTANCE.createConstraint();
        constraint.setLanguage(getDefaultConstraintLanguage());
        constraint.setValue("");
        visibleConstraints.add(constraint); // Make the new constraint visible.
        
        // Execute command to add new constraint.
        Command command = new AddConstraintCommand(featureModel, constraint);
        commandStack.execute(command);
        
        // Start constraint editing.
        viewer.editElement(constraint, 0);
    }
    
    private String getDefaultConstraintLanguage() {
        // Get last used language for constraint or find first available if no constraint exists yet.
        List<Constraint> constraints = featureModel.getConstraints(); 
        if(!constraints.isEmpty())
            return constraints.get(constraints.size() - 1).getLanguage();
        
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        Iterator<ConstraintLanguageDescriptor> iterator = registry.getDescriptors().iterator();
        if(iterator.hasNext())
            return iterator.next().getId();
        return null;
    }
            
    @Override
    public boolean setFocus() {
        return viewer.getControl().setFocus();
    }
        
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        refresh();
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
    
    public void addSelectionChangeListener(ISelectionChangedListener listener) {
        viewer.addSelectionChangedListener(listener);
    }
    
    public void removeSelectionChangeListener(ISelectionChangedListener listener) {
        viewer.removeSelectionChangedListener(listener);
    }
    
    public void refresh() {
        if(!isVisible())
            return;
        
        if(filterEnabled)
            refreshFilter();
        viewer.refresh();
    }
    
    private void refreshFilter() {
        visibleConstraints.clear();
        
        for(Object object: outerSelection.toArray()) {
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
       
    private class ConstraintsFilter extends ViewerFilter {

        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if(!filterEnabled || (element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT))
                return true;
            return visibleConstraints.contains(element);
        }
        
    }
    
    private class FeatureModelAdapter extends EContentAdapter {
        
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            
            constraintCache.invalidate();
            Object notifier = notification.getNotifier();
            if((notifier instanceof FeatureModel) && (notification.getFeatureID(FeatureModel.class) == FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS))
                viewer.refresh();
            else if((notifier instanceof Constraint) && (notification.getFeatureID(Constraint.class) == FeatureModelPackage.CONSTRAINT__VALUE))
                viewer.refresh(notification.getNotifier());
        }
        
    }

}
