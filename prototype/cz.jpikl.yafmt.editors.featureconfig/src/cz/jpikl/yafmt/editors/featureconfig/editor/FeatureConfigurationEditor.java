package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;

import cz.jpikl.yafmt.editors.featureconfig.parts.FeatureConfigEditPartFactory;
import cz.jpikl.yafmt.editors.featureconfig.utils.EditorUtil;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureConfigurationEditor extends GraphicalEditor {

    private static final LayoutManager LAYOUT_MANAGERS[] = { new FeatureTreeLayout(true), new FeatureTreeLayout(false) };
    private static final String LAYOUT_NAMES[] = { "Horizontal tree", "Vertical tree" };
    
    private FeatureConfiguration featureConfig;
    
    public FeatureConfigurationEditor() {
        setEditDomain(new DefaultEditDomain(this));
    }
    
    private void changeLayout(int index) {
        GraphicalEditPart part = (GraphicalEditPart) getGraphicalViewer().getEditPartRegistry().get(featureConfig);
        part.getFigure().setLayoutManager(LAYOUT_MANAGERS[index]); 
    }
    
    @Override
    protected void createGraphicalViewer(Composite parent) {
        Composite mainPanel = new Composite(parent, SWT.NONE);
        mainPanel.setLayout(new GridLayout());
        
        super.createGraphicalViewer(mainPanel);
        getGraphicalViewer().getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        Composite downPanel = new Composite(mainPanel, SWT.NONE);
        downPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        downPanel.setLayout(new GridLayout(2, false));
        
        Label label = new Label(downPanel, SWT.RIGHT);
        label.setText("Layout");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
        
        final Combo combo = new Combo(downPanel, SWT.READ_ONLY);
        combo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        for(String name: LAYOUT_NAMES)
            combo.add(name);
        
        changeLayout(0);
        combo.select(0);
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                changeLayout(combo.getSelectionIndex());
            }
        });
    }
        
    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
        getSite().getPage().addSelectionListener(this);
    }
    
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        super.dispose();
    }
        
    @Override
    protected void initializeGraphicalViewer() {
        try {
            doLoad();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        
        setPartName(getEditorInput().getName());
        
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setEditPartFactory(new FeatureConfigEditPartFactory(featureConfig));
        viewer.setContents(featureConfig);
    }
    
    private Map<Object, Object> createSaveLoadOptions() {
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        return options;
    }

    private void doLoad() throws IOException {
        @SuppressWarnings("unused")
        FeatureConfigPackage fcPackage = FeatureConfigPackage.eINSTANCE; // For package registration.
        ResourceSet resourceSet = new ResourceSetImpl();
        String path = EditorUtil.getEditorInputFileName(getEditorInput());
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.load(createSaveLoadOptions());
        featureConfig = (FeatureConfiguration) resource.getContents().get(0);
    }
    
    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            featureConfig.eResource().save(createSaveLoadOptions());
            getCommandStack().markSaveLocation();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    // Makes the editor dirty when a command is executed (allows save action).
    @Override
    public void commandStackChanged(EventObject event) {
        firePropertyChange(PROP_DIRTY);
        super.commandStackChanged(event);
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == FeatureModel.class)
            return featureConfig.getFeatureModel();
        return super.getAdapter(type);
    }
    
    // Wraps model elements selection to edit parts selection.
    @SuppressWarnings("unchecked")
    private ISelection wrapSelection(ISelection selection) {
        if(selection == null)
            return null;

        List<Object> objects = new ArrayList<Object>();
        Iterator<Object> it = ((IStructuredSelection) selection).iterator();
        while(it.hasNext()) {
            Object object = getGraphicalViewer().getEditPartRegistry().get(it.next());
            if(object != null)
                objects.add(object);
        }

        return new StructuredSelection(objects);
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        String id = part.getClass().getName();
        
        if(id.equals("cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView")) {
         // Wraps model elements to edit parts
            ISelection wrappedSelection = wrapSelection(selection);
            // Select edit parts
            getGraphicalViewer().setSelection(wrappedSelection);
            // Get first selected edit part
            EditPart selectedPart = (EditPart) ((IStructuredSelection) wrappedSelection).getFirstElement();

            if(selectedPart != null) {
                // Zoom to the selected edit part
                Viewport vp = (Viewport)((FreeformGraphicalRootEditPart) getGraphicalViewer().getRootEditPart()).getFigure();
                IFigure figure = ((GraphicalEditPart) selectedPart).getFigure();
                Point p = figure.getBounds().getCenter();
                vp.setViewLocation(p.x - vp.getSize().width / 2, p.y - vp.getSize().height / 2);
            }
        }
        
        super.selectionChanged(part, selection);
    }

}
