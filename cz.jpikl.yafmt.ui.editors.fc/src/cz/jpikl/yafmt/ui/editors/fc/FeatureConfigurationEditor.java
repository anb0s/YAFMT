package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

import cz.jpikl.yafmt.ui.util.EditorAutoCloser;

public class FeatureConfigurationEditor extends GraphicalEditor {

    private EditorAutoCloser editorAutoCloser;
    
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
        
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
    }

}
