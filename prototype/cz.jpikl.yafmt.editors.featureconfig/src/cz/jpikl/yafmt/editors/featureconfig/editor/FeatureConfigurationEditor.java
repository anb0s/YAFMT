package cz.jpikl.yafmt.editors.featureconfig.editor;

import java.io.IOException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import cz.jpikl.yafmt.editors.featureconfig.parts.FeatureConfigEditPartFactory;
import cz.jpikl.yafmt.editors.featureconfig.utils.EditorUtil;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfigPackage;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;

public class FeatureConfigurationEditor extends GraphicalEditor {

    private FeatureConfiguration featureConfig;
    
    public FeatureConfigurationEditor() {
        setEditDomain(new DefaultEditDomain(this));
    }
        
    @Override
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
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

}
