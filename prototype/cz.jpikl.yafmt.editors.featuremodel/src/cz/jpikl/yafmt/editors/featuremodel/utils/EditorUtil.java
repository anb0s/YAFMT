package cz.jpikl.yafmt.editors.featuremodel.utils;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;

public class EditorUtil {

    public static String getEditorInputFileName(IEditorInput input) {
        if(input instanceof IFileEditorInput) {
            return ((IFileEditorInput) input).getFile().getFullPath().toString();
        }

        if(input instanceof IURIEditorInput) {
            try {
                IFileStore store = EFS.getStore(((IURIEditorInput) input).getURI());
                return "file://" + store.toLocalFile(EFS.NONE, null).getAbsolutePath();
            }
            catch(CoreException ex) {
                ex.printStackTrace();
                return null;
            }
        }

        return null;
    }

}
