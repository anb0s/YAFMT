package cz.jpikl.yafmt.ui.editors.fm;

import java.io.IOException;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.FeatureModelPackage;
import cz.jpikl.yafmt.ui.editors.fm.operations.ResourceSaveOperation;

public class FeatureModelEditor extends MultiPageEditorPart implements IResourceChangeListener {
	
    private FeatureModel featureModel;
    private FeatureTreeEditor featureTreeEditor;
	
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof IFileEditorInput))
            throw new PartInitException("Invalid input: Must be IFileEditorInput");
        
        super.init(site, input);
        setPartName(input.getName());
        doLoad((IFileEditorInput) input);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }
    
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        super.dispose();
    }
		
	protected void createPages() {
		featureTreeEditor = new FeatureTreeEditor(featureModel);
		
		try {
		    addPage(featureTreeEditor, getEditorInput());
		    setPageText(0, "Feature Tree");
		}
		catch(PartInitException ex) {
		    FeatureModelEditorPlugin.getDefault().getLog().log(new Status(Status.ERROR, 
		            FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage(), ex));
		}
	}
		
	@SuppressWarnings("unused")
	private void doLoad(IFileEditorInput input) throws PartInitException {
	    try {
    	    FeatureModelPackage pkg = FeatureModelPackage.eINSTANCE; // For package registration.
            ResourceSet resourceSet = new ResourceSetImpl();
            String path = input.getFile().getFullPath().toString();
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
            resource.load(null);
            featureModel = (FeatureModel) resource.getContents().get(0);
	    }
	    catch(IOException ex) {
	        throw new PartInitException("Unable to load " + input.getName(), ex);
	    }
	}
	
	public void doSave(IProgressMonitor monitor) {
	    try {
            getSite().getWorkbenchWindow().run(true, false, new ResourceSaveOperation(featureModel.eResource()));
            featureTreeEditor.doSave(null);
            firePropertyChange(PROP_DIRTY);
        } 
	    catch (Exception ex) {
	        ErrorDialog.openError(getSite().getShell(), "Unable to save " + getEditorInput().getName(),
	            null, new Status(Status.ERROR, FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage(), ex), 0);
        }
	}

	public void doSaveAs() {
	    SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
        dialog.open();
        
        IPath path = dialog.getResult();
        if (path == null)
            return;

        featureModel.eResource().setURI(URI.createPlatformResourceURI(path.toString(), true));
        IEditorInput newInput = new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path));
        setPartName(newInput.getName());
        setInputWithNotify(newInput);
        featureTreeEditor.prepareToSaveAs(newInput);
        doSave(null);
	}
	
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	// ======================================================================
	//  IResourceChangeListener
	// ======================================================================
		
	public void resourceChanged(final IResourceChangeEvent event) {
		if(event.getType() != IResourceChangeEvent.PRE_CLOSE)
		    return;
		
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
			    IFileEditorInput input = (FileEditorInput) getEditorInput();
				IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
				for(int i = 0; i < pages.length; i++){
					if(input.getFile().getProject().equals(event.getResource())) {
						IEditorPart editorPart = pages[i].findEditor(input);
						pages[i].closeEditor(editorPart, true);
					}
				}
			}            
		});
	}
	
	// ======================================================================
    //  IAdaptable
    // ======================================================================
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
	    if(type == FeatureModel.class)
	        return featureModel;
	    return super.getAdapter(type);
	}
	
}
