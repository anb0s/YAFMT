package cz.jpikl.yafmt.editors.featureconfig.dialogs;


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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import cz.jpikl.yafmt.models.featureconfig.FeatureConfigFactory;
import cz.jpikl.yafmt.models.featureconfig.FeatureConfiguration;
import cz.jpikl.yafmt.models.featureconfig.Selection;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;


public class NewFeatureConfigurationWizard extends Wizard implements INewWizard {

    private static final String FM_FILE_EXTENSION = "yafm";
    private static final String FILE_EXTENSION = "yafc";
    private static final String DEFAULT_FILE_NAME = "FeatureConfig." + FILE_EXTENSION;

    private IWorkbench workbench;
    private IStructuredSelection selection;
    private FeatureModelSelectionPage featureModelSelectionPage;
    private NewFileCreationPage newFileCreationPage;
     
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        this.featureModelSelectionPage = new FeatureModelSelectionPage();
        this.newFileCreationPage = new NewFileCreationPage();
        setWindowTitle("New Feature Configuration");
    }

    @Override
    public void addPages() {
        addPage(featureModelSelectionPage);
        addPage(newFileCreationPage);
    }
    
    private Object getSelectedObject() {
        if(selection == null || selection.isEmpty())
            return null;
        return selection.iterator().next();
    }

    private class FeatureModelSelectionPage extends WizardPage implements Listener {

        private Text fileNameInput;
        private Button fileNameBrowseButton;
        
        public FeatureModelSelectionPage() {
            super("Feature Model Selection Page");
            setTitle("Feature Model");
            setDescription("Select feature model for configuration.");
        }
        
        @Override
        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL));
            
            GridLayout layout = new GridLayout();
            layout.numColumns = 3;
            composite.setLayout(layout);
            
            Label fileNameLabel = new Label(composite, SWT.NONE);
            fileNameLabel.setText("Feature model file:");
            
            fileNameInput = new Text(composite, SWT.SINGLE | SWT.BORDER);
            fileNameInput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            fileNameInput.addListener(SWT.Modify, this);
            
            fileNameBrowseButton = new Button(composite, SWT.PUSH);
            fileNameBrowseButton.setText("Browse");
            fileNameBrowseButton.addListener(SWT.Selection, this);
            
            setControl(composite);
            setPageComplete(false);
            
            Object selectedObject = getSelectedObject();
            if(selectedObject instanceof IFile) {
                IFile file = (IFile) selectedObject;
                if(FM_FILE_EXTENSION.equals(file.getFileExtension())) {
                    fileNameInput.setText(file.getFullPath().toString());
                    setPageComplete(true);
                }
            }
        }

        @Override
        public void handleEvent(Event event) {
            if(event.widget == fileNameBrowseButton) {
                ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
                dialog.setTitle("Feature Model Selection");
                dialog.setMessage("Select the feature model for configuration.");
                dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
                dialog.setAllowMultiple(false);
                dialog.open();
                
                Object result = dialog.getFirstResult();
                if((result == null) || !(result instanceof IResource))
                    return;
                
                fileNameInput.setText(((IResource) result).getFullPath().toString());
            }
            
            setPageComplete(validatePage());
        }
        
        private boolean validatePage() {
            IPath path = new Path(fileNameInput.getText());
            
            if(path.isEmpty() || !ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
                setErrorMessage("The selected file does not exist.");
                return false;
            }
            
            if(!FM_FILE_EXTENSION.equals(path.getFileExtension())) {
                setErrorMessage("The selected file in not a YAFMT feature model.");
                return false;
            }
            
            setErrorMessage(null);
            return true;
        }
        
        public IFile getModelFile() {
            IPath path = new Path(fileNameInput.getText());
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }
        
    }
    
    private class NewFileCreationPage extends WizardNewFileCreationPage {

        public NewFileCreationPage() {
            super("New File Creation Page", selection);
            setTitle("Feature Configuration");
            setDescription("Create a new feature configuration.");
            setFileName(DEFAULT_FILE_NAME);

            //Try and get the resource selection to determine a current directory for the file dialog.
            Object selectedObject = getSelectedObject();
            if (selectedObject instanceof IResource) {
                // Get the resource parent, if its a file.
                IResource selectedResource = (IResource) selectedObject;
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

        public IFile getConfigurationFile() {
            IPath path = getContainerFullPath().append(getFileName());
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }

    }

    @Override
    public boolean performFinish() {
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IWorkbenchPart activePart = page.getActivePart();
        IFile file = newFileCreationPage.getConfigurationFile();

        // Create feature model file in workspace.
        try {
            getContainer().run(false, false, new CreateFeatureConfigurationOperation());
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
            IEditorDescriptor descriptor = workbench.getEditorRegistry().getDefaultEditor(file.getName());
            if(descriptor != null)
                page.openEditor(input, descriptor.getId());
        }
        catch (PartInitException ex) {
            MessageDialog.openError(window.getShell(), "Unable to open " + file.getName(), ex.getMessage());
            return false;
        }

        return true;
    }

    private class CreateFeatureConfigurationOperation extends WorkspaceModifyOperation {

        @Override
        protected void execute(IProgressMonitor progressMonitor) {
            try {
                String configFile = newFileCreationPage.getConfigurationFile().getFullPath().toString();
                String modelFile = featureModelSelectionPage.getModelFile().getFullPath().toString();
                URI configUri = URI.createPlatformResourceURI(configFile, true);
                URI modelUri =  URI.createPlatformResourceURI(modelFile, true);
                Map<Object, Object> options = new HashMap<Object, Object>();
                options.put(XMLResource.OPTION_ENCODING, "UTF-8");

                ResourceSet resourceSet = new ResourceSetImpl();
                Resource resource = resourceSet.createResource(modelUri);
                resource.load(options);
                FeatureModel featureModel = (FeatureModel) resource.getContents().get(0);
                
                FeatureConfiguration featureConfig = FeatureConfigFactory.eINSTANCE.createFeatureConfiguration();
                featureConfig.setFeatureModel(featureModel);
                Selection selection = FeatureConfigFactory.eINSTANCE.createSelection();
                selection.setFeatureName(featureModel.getRootFeature().getName());
                featureConfig.getSelection().add(selection);
                
                resource = resourceSet.createResource(configUri);
                resource.getContents().add(featureConfig);
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
