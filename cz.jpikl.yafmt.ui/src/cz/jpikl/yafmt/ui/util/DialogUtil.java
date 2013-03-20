package cz.jpikl.yafmt.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class DialogUtil {

    public static String chooseWorkspaceFile(Shell shell, String title, String message) {
        ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
        dialog.setAllowMultiple(false);
        dialog.open();

        Object result = dialog.getFirstResult();
        if(result instanceof IFile)
            return ((IResource) result).getFullPath().toString();
        return null;
    }
    
}
