package cz.jpikl.yafmt.clang.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import cz.jpikl.yafmt.clang.ConstraintLanguagePlugin;

public class EditingSupportDescriptor {

    private IConfigurationElement element;
    
    private String languageId;
    private IEditingSupport editingSupport;
    
    public EditingSupportDescriptor(IConfigurationElement element) {
        this.element = element;
        
        languageId = element.getAttribute("languageId");
        if(languageId == null)
            throw new IllegalArgumentException("LanguageId attribute is missing.");
    }
    
    public String getLanguageId() {
        return languageId;
    }
    
    public IEditingSupport getEditingSupport() {
        if(editingSupport == null) {
            try {                            
                editingSupport = (IEditingSupport) element.createExecutableExtension("class");
            } catch (CoreException ex) {
                ConstraintLanguagePlugin.getDefault().logError("Unable to instantiate editing support class for " + languageId + ".", ex);
            }
        }
        
        return editingSupport;
    }
    
}
