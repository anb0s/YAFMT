package cz.jpikl.yafmt.editors.featuremodel.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import cz.jpikl.yafmt.editors.featuremodel.Activator;
import cz.jpikl.yafmt.editors.featuremodel.utils.EditorUtil;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelPackage;

public class FeatureModelEditor extends MultiPageEditorPart implements ISelectionListener {

    private FeatureModel featureModel;
    private ContentOutlinePage outlinePage;

    // Initializes editor with input.
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        // ISelectionProvider is registered automatically in init() method.
        // I forwards selection from selection providers of inner editors.
        super.init(site, input);
        
        // TODO setInput method for model loading instead of init method
        
        try {
            // Loads specified input.
            @SuppressWarnings("unused")
            FeatureModelPackage fmPackage = FeatureModelPackage.eINSTANCE; // For package registration.
            ResourceSet resourceSet = new ResourceSetImpl();
            String path = EditorUtil.getEditorInputFileName(input);
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
            resource.load(createSaveLoadOptions());
            featureModel = (FeatureModel) resource.getContents().get(0);
        }
        catch(Exception ex) {
            throw new PartInitException("Unable to load input.", ex);
        }
        
        setPartName(getEditorInput().getName());
        site.getPage().addSelectionListener(this);
    }
    
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        super.dispose();
    }

    // Creates editor pages. Called after init.
    @Override
    protected void createPages() {
        try {
            addPage(new FeatureTreeEditor(featureModel), getEditorInput());
            setPageText(0, "Feature Tree");
            addPage(new ConstraintsEditor(featureModel), getEditorInput());
            setPageText(1, "Constraints");
        }
        catch (PartInitException ex) {
            ex.printStackTrace();
        }
    }

    private Map<Object, Object> createSaveLoadOptions() {
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        return options;
    }

    // Saves model.
    @Override
    public void doSave(IProgressMonitor monitor) {
        try {
            featureModel.eResource().save(createSaveLoadOptions());
            for(int i = 0; i < getPageCount(); i++)
                getEditor(i).doSave(monitor);
            firePropertyChange(PROP_DIRTY);
        }
        catch(Exception ex) {
            ErrorDialog.openError(getSite().getShell(), "Error During Save", null,
                                  new Status(Status.ERROR, Activator.PLUGIN_ID, ex.getMessage()), 0);
            ex.printStackTrace();
        }
    }

    @Override
    public void doSaveAs() {
        SaveAsDialog dialog = new SaveAsDialog(getSite().getShell());
        IEditorInput input = getEditorInput();
        if(input instanceof IFileEditorInput)
            dialog.setOriginalFile(((IFileEditorInput) input).getFile());
        dialog.open();
        
        IPath path = dialog.getResult();
        if (path == null)
            return;

        featureModel.eResource().setURI(URI.createPlatformResourceURI(path.toString(), true));
        IEditorInput newInput = new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(path));
        setInput(newInput);
        // TODO input for nested editors is not changed!!
        setPartName(newInput.getName());
        
        try {
            new ProgressMonitorDialog(getSite().getWorkbenchWindow().getShell()).run(false, true, 
                new WorkspaceModifyOperation() {
                    @Override
                    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
                        doSave(null);
                        monitor.done();
                    }
                }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    // =====================================================================
    //  IAdaptable
    // =====================================================================

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class type) {
        // Provides outline view content page.
        if(type == IContentOutlinePage.class) {
            if(outlinePage == null)
                outlinePage = new FeatureModelContentOutlinePage(featureModel);
            return outlinePage;
        }
        if(type == FeatureModel.class)
            return featureModel;
        return super.getAdapter(type);
    }

    // =====================================================================
    //  ISelectionListener
    // =====================================================================

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if(outlinePage == null)
            return;

        // Forward selection to the content outline view when it comes from the feature model view
        // or from feature tree editor.
        String id = part.getClass().getName();
        if(id.equals("cz.jpikl.yafmt.views.featuremodel.view.FeatureModelView"))
            outlinePage.setSelection(selection);
        else if(id.equals("cz.jpikl.yafmt.editors.featuremodel.editor.FeatureModelEditor")) {
            outlinePage.setSelection(FeatureTreeEditor.unwrapSelection(selection));
        }
    }

}
