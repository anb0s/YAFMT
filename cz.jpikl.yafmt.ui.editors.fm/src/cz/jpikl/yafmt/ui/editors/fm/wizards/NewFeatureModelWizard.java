package cz.jpikl.yafmt.ui.editors.fm.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.util.FeatureModelUtil;
import cz.jpikl.yafmt.ui.wizards.NewFileWizard;

public class NewFeatureModelWizard extends NewFileWizard {
    
    private FeatureModelPropertiesPage featureModelPropertiesPage = new FeatureModelPropertiesPage();

    public NewFeatureModelWizard() {
        setWindowTitle("New Feature Model Wizard");
    }
    
    @Override
    protected void initNewFileCreationPage(WizardNewFileCreationPage page) {
        page.setTitle("Feature Model");
        page.setDescription("Create a new feature model.");
        page.setFileName("FeatureModel");
        page.setFileExtension("yafm");
    }
    
    @Override
    public void addPages() {
        super.addPages();
        addPage(featureModelPropertiesPage);
    }    
    
    @Override
    protected Resource createNewResource(IFile file) {
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
        
    private class FeatureModelPropertiesPage extends WizardPage implements Listener {
        
        private Text nameText;
        private Text versionText;
        private Text descriptionText;
        
        protected FeatureModelPropertiesPage() {
            super("Feature Model Properties Page");
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
                String name = getFile().getName();
                String extension = getFile().getFileExtension();
                nameText.setText(name.substring(0, name.length() - extension.length() - 1));
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
