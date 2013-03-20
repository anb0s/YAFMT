package cz.jpikl.yafmt.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class WorkspaceDialog extends ElementTreeSelectionDialog {

    public WorkspaceDialog(Shell shell) {
        super(shell, new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
        setInput(ResourcesPlugin.getWorkspace().getRoot());
    }
    
    public static String openFile(Shell shell, String title, String message) {
        WorkspaceDialog dialog = new WorkspaceDialog(shell);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setAllowMultiple(false);
        dialog.open();

        Object result = dialog.getFirstResult();
        if(result instanceof IFile)
            return ((IResource) result).getFullPath().toString();
        return null;
    }
        
}
