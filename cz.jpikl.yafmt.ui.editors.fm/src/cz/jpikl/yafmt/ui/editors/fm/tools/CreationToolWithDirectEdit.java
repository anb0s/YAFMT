package cz.jpikl.yafmt.ui.editors.fm.tools;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.widgets.Display;

public class CreationToolWithDirectEdit extends CreationTool {
    
    @Override
    protected void performCreation(int button) {
        super.performCreation(button);

        EditPartViewer viewer = getCurrentViewer();
        if(viewer == null)
            return;

        Object object = getCreateRequest().getNewObject();
        final EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(object);
        if(editPart == null)
            return;

        Display.getCurrent().asyncExec(new Runnable() {
            @Override
            public void run() {
                editPart.performRequest(new Request(REQ_OPEN));
            }
        });
    }
    
}
