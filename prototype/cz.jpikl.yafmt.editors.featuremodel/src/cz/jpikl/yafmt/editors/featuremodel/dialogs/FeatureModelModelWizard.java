package cz.jpikl.yafmt.editors.featuremodel.dialogs;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.FeatureModelFactory;


public class FeatureModelModelWizard extends Wizard implements INewWizard {

    private static final String FILE_EXTENSION = "yafm";
    private static final String DEFAULT_FILE_NAME = "FeatureModel." + FILE_EXTENSION;

    private IWorkbench workbench;
    private IStructuredSelection selection;
    private NewFileCreationPage newFileCreationPage;

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        this.newFileCreationPage = new NewFileCreationPage();
        setWindowTitle("New Feature Model");
    }

    @Override
    public void addPages() {
        addPage(newFileCreationPage);
    }

    private class NewFileCreationPage extends WizardNewFileCreationPage {

        public NewFileCreationPage() {
            super("Feature Model New File Creation Page", selection);
            setTitle("Feature Model");
            setDescription("Create a new feature model.");
            setFileName(DEFAULT_FILE_NAME);

            // Try and get the resource selection to determine a current directory for the file dialog.
            if(selection == null || selection.isEmpty())
                return;

            // Get the resource.
            Object selectedElement = selection.iterator().next();
            if (selectedElement instanceof IResource) {
                // Get the resource parent, if its a file.
                IResource selectedResource = (IResource) selectedElement;
                if (selectedResource.getType() == IResource.FILE)
                    selectedResource = selectedResource.getParent();
                // This gives us a directory or project, select it as a container.
                if ((selectedResource instanceof IFolder) || (selectedResource instanceof IProject))
                    setContainerFullPath(selectedResource.getFullPath());
            }
        }

         // The framework calls this to see if the file is correct.
        @Override
        protected boolean validatePage() {
            if(!super.validatePage())
                return false;
            if(!FILE_EXTENSION.equals(new Path(getFileName()).getFileExtension())) {
                setErrorMessage("The file must have the " + FILE_EXTENSION + " extension.");
                return false;
            }
            return true;
        }

        public IFile getModelFile() {
            IPath path = getContainerFullPath().append(getFileName());
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }

    }

    @Override
    public boolean performFinish() {
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IWorkbenchPart activePart = page.getActivePart();
        IFile file = newFileCreationPage.getModelFile();

        // Create feature model file in workspace.
        try {
            getContainer().run(false, false, new CreateFeatureModelOperation());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }

        // Select the new file resource in the current view.
        if (activePart instanceof ISetSelectionTarget) {
            final ISetSelectionTarget setSelectionTarget = (ISetSelectionTarget) activePart;
            final ISelection targetSelection = new StructuredSelection(file);
            getShell().getDisplay().asyncExec (new Runnable() {
                 public void run() {
                     setSelectionTarget.selectReveal(targetSelection);
                 }
             });
        }

        // Open an editor on the new file.
        try {
            IEditorInput input = new FileEditorInput(file);
            String editorId = workbench.getEditorRegistry().getDefaultEditor(file.getName()).getId();
            page.openEditor(input, editorId);
        }
        catch (PartInitException ex) {
            MessageDialog.openError(window.getShell(), "Unable to open " + file.getName(), ex.getMessage());
            return false;
        }

        return true;
    }

    private class CreateFeatureModelOperation extends WorkspaceModifyOperation {

        @Override
        protected void execute(IProgressMonitor progressMonitor) {
            try {
                String file = newFileCreationPage.getModelFile().getFullPath().toString();
                URI uri = URI.createPlatformResourceURI(file, true);
                Map<Object, Object> options = new HashMap<Object, Object>();
                options.put(XMLResource.OPTION_ENCODING, "UTF-8");

                String modelName = newFileCreationPage.getModelFile().getName().replace("." + FILE_EXTENSION, "");
                FeatureModel featureModel = FeatureModelFactory.eINSTANCE.createFeatureModel();
                featureModel.getRootFeature().setName(modelName);

                ResourceSet resourceSet = new ResourceSetImpl();
                Resource resource = resourceSet.createResource(uri);
                resource.getContents().add(featureModel);
                resource.save(options);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                progressMonitor.done();
            }
        }

    }

}
