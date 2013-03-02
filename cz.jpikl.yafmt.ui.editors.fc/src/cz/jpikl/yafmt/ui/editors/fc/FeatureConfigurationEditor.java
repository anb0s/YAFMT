package cz.jpikl.yafmt.ui.editors.fc;

import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.provider.util.FeatureConfigurationProviderUtil;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.operations.ResourceSaveOperation;
import cz.jpikl.yafmt.ui.pages.EditorContentOutlinePage;
import cz.jpikl.yafmt.ui.pages.EditorPropertySheetPage;
import cz.jpikl.yafmt.ui.util.EditorAutoCloser;

public class FeatureConfigurationEditor extends GraphicalEditor {

    private FeatureConfiguration featureConfig;
    private EditorAutoCloser editorAutoCloser;
    private IContentOutlinePage contentOutlinePage;
    private IPropertySheetPage propertySheetPage;
    
    public FeatureConfigurationEditor() {
        editorAutoCloser = new EditorAutoCloser(this);
        setEditDomain(new DefaultEditDomain(this));
    }
    
    // ==================================================================================
    //  Basic initialization and dispose operations
    // ==================================================================================

    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");
        
        super.init(site, input);
        setPartName(input.getName());
        doLoad((IFileEditorInput) input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorAutoCloser);
    }
    
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorAutoCloser);
        super.dispose();
    }
    
    // ==================================================================================
    //  Editor initialization
    // ==================================================================================
    
    @Override
    protected void initializeGraphicalViewer() {
    }
    
    // ==================================================================================
    //  Save and Load operations
    // ==================================================================================
    
    private void doLoad(IFileEditorInput input) throws PartInitException {
        String path = input.getFile().getFullPath().toString();
        
        try {
            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
            resource.load(null);
            featureConfig = (FeatureConfiguration) resource.getContents().get(0);
        }
        catch(IOException ex) {
            throw new PartInitException("Unable to load " + path, ex);
        }
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            IWorkbenchWindow window = getSite().getWorkbenchWindow(); 
            window.run(true, false, new ResourceSaveOperation(featureConfig.eResource()));
            getEditDomain().getCommandStack().markSaveLocation();
            firePropertyChange(PROP_DIRTY);
        } 
        catch (Exception ex) {
            ErrorDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(),
                null, new Status(Status.ERROR, FeatureConfigurationEditorPlugin.PLUGIN_ID, ex.getMessage(), ex), 0);
        }
    }
    
    @Override
    public void doSaveAs() {
        SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();
        
        IPath path = dialog.getResult();
        if (path == null)
            return;

        featureConfig.eResource().setURI(URI.createPlatformResourceURI(path.toString(), true));
        setInputWithNotify(new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path)));
        setPartName(getEditorInput().getName());
        doSave(null);
    }
    
    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }
    
    // ==================================================================================
    //  Adapters
    // ==================================================================================
        
    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if(type == FeatureModel.class)
            return featureConfig.getFeatureModelCopy();
        
        if(type == IPropertySheetPage.class) {
            if(propertySheetPage == null)
                propertySheetPage = new EditorPropertySheetPage(this, FeatureConfigurationProviderUtil.getContentProvider());
            return propertySheetPage;
        }
        
        if(type == IContentOutlinePage.class) {
            if(contentOutlinePage == null)
                contentOutlinePage = new EditorContentOutlinePage(this, featureConfig, FeatureConfigurationProviderUtil.getContentProvider(), FeatureConfigurationProviderUtil.getLabelProvider());
            return contentOutlinePage;
        }
        
        return super.getAdapter(type);
    }

}
