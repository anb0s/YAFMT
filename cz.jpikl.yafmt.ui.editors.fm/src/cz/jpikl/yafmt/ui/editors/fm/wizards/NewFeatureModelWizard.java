package cz.jpikl.yafmt.ui.editors.fm.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.editors.fm.operations.ResourceSaveOperation;

public class NewFeatureModelWizard extends Wizard implements INewWizard {

    private static final String FILE_EXTENSION = "yafm";
    private static final String DEFAULT_FILE_NAME = "FeatureModel." + FILE_EXTENSION;
    
    private IWorkbench workbench;
    private NewFileCreationPage newFileCreationPage;
    private FeatureModelPropertiesPage featureModelPropertiesPage;
    
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("New Feature Model Wizard");
        this.workbench = workbench;
        this.newFileCreationPage = new NewFileCreationPage(selection);
        this.featureModelPropertiesPage = new FeatureModelPropertiesPage();
    }
    
    @Override
    public void addPages() {
        addPage(newFileCreationPage);
        addPage(featureModelPropertiesPage);
    }    
    
    private Resource createFeatureModelResource(IFile file) {
        String name = featureModelPropertiesPage.getFeatureModelName();
        String version = featureModelPropertiesPage.getFeatureModelVersion();
        String description = featureModelPropertiesPage.getFeatureModelDescription();
        FeatureModel featureModel = FeatureModelUtil.createEmptyFeatureModel(name);
        if(!version.isEmpty())
            featureModel.setVersion(version);
        if(!description.isEmpty())
            featureModel.setDescription(description);
        
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(featureModel);
        return resource;
    }
    
    @Override
    public boolean performFinish() {
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IWorkbenchPart activePart = page.getActivePart();
        IFile file = newFileCreationPage.getFile();

        try {
            Resource resource = createFeatureModelResource(file);
            getContainer().run(false, false, new ResourceSaveOperation(resource));
        }
        catch(Exception ex) {
            ErrorDialog.openError(window.getShell(), "Unable to create " + file.getName(), null, 
                    new Status(Status.ERROR, FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage(), ex));
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
            IEditorDescriptor descriptor = workbench.getEditorRegistry().getDefaultEditor(file.getName());
            if(descriptor != null)
                page.openEditor(input, descriptor.getId());
        }
        catch (PartInitException ex) {
            ErrorDialog.openError(window.getShell(), "Unable to open " + file.getName(), null, 
                    new Status(Status.ERROR, FeatureModelEditorPlugin.PLUGIN_ID, ex.getMessage()));
            return false;
        }

        return true;
    }
    
    private class NewFileCreationPage extends WizardNewFileCreationPage {

        public NewFileCreationPage(IStructuredSelection selection) {
            super("New Feature Model Creation Page", selection);
            setTitle("Feature Model");
            setDescription("Create a new feature model.");
            setFileName(DEFAULT_FILE_NAME);

            // Try and get the resource selection to determine a current directory for the file dialog.
            if(selection == null || selection.isEmpty())
                return;
            
            Object selectedObject = selection.iterator().next();
            if(!(selectedObject instanceof IResource))
                return;
            
            // Get the resource parent, if its a file.
            IResource selectedResource = (IResource) selectedObject;
            if (selectedResource.getType() == IResource.FILE)
                selectedResource = selectedResource.getParent();
            
            // This gives us a directory or project, select it as a container.
            if ((selectedResource instanceof IFolder) || (selectedResource instanceof IProject))
                setContainerFullPath(selectedResource.getFullPath());
        }

        @Override
        protected boolean validatePage() {
            if(!super.validatePage())
                return false;
            if(getFileName().length() <= (FILE_EXTENSION.length() + 1)) {
                setErrorMessage("The name of the file must be set.");
                return false;
            }
            if(!FILE_EXTENSION.equals(new Path(getFileName()).getFileExtension())) {
                setErrorMessage("The file must have the " + FILE_EXTENSION + " extension.");
                return false;
            }
            return true;
        }

        public IFile getFile() {
            IPath path = getContainerFullPath().append(getFileName());
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }

    }
    
    private class FeatureModelPropertiesPage extends WizardPage implements Listener {
        
        private Text nameText;
        private Text versionText;
        private Text descriptionText;
        
        protected FeatureModelPropertiesPage() {
            super("New Feature Model Properties Page");
            setTitle("Feature Model");
            setDescription("Set feature model properties.");
        }

        @Override
        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL));
            
            GridLayout layout = new GridLayout();
            layout.numColumns = 2;
            composite.setLayout(layout);
                        
            Label nameLabel = new Label(composite, SWT.NONE);
            nameLabel.setText("Name:");
            nameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
            
            nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            nameText.addListener(SWT.Modify, this);
            
            Label versionLabel = new Label(composite, SWT.NONE);
            versionLabel.setText("Version:");
            versionText = new Text(composite, SWT.SINGLE | SWT.BORDER);
            versionText.setText("1.0.0");
            versionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            versionText.addListener(SWT.Modify, this);
            
            Label descriptionLabel = new Label(composite, SWT.NONE);
            descriptionLabel.setLayoutData(new GridData(SWT.TOP, SWT.LEFT, false, false));
            descriptionLabel.setText("Description:");
            descriptionText = new Text(composite, SWT.MULTI | SWT.BORDER);
            descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
            
            setControl(composite);
            revalidatePage();
        }
        
        @Override
        public void setVisible(boolean visible) {
            if(visible && nameText.getText().isEmpty()) {
                String name = newFileCreationPage.getFileName();
                nameText.setText(name.substring(0, name.length() - FILE_EXTENSION.length() - 1));
            }
            
            super.setVisible(visible);
        }        
        
        @Override
        public void handleEvent(Event event) {
            if(event.widget == nameText)
                revalidatePage();
        }
        
        private void revalidatePage() {
            setPageComplete(validatePage());
        }
        
        private boolean validatePage() {
            if(nameText.getText().trim().isEmpty()) {
                setErrorMessage("The name of the feature model must be set.");
                return false;
            }
            
            setErrorMessage(null);
            return true;
        }
        
        public String getFeatureModelName() {
            return nameText.getText();
        }
        
        public String getFeatureModelVersion() {
            return versionText.getText();
        }
        
        public String getFeatureModelDescription() {
            return descriptionText.getText();
        }
        
    }

}
