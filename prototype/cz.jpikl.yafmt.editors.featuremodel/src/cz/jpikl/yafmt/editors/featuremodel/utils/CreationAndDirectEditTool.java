package cz.jpikl.yafmt.editors.featuremodel.utils;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.widgets.Display;

// Palette tool that creates object and starts its direct editing (feature label)
public class CreationAndDirectEditTool extends CreationTool {

	@Override
	protected void performCreation(int button) {
		super.performCreation(button); // Create object.
		
		// Perform direct editing.
		EditPartViewer viewer = getCurrentViewer();
		Object model = getCreateRequest().getNewObject();
		if(model == null || viewer == null)
			return;
		
		final EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(model);
		Display.getCurrent().asyncExec(new Runnable() {
			@Override
			public void run() {
				// Send REQ_OPEN instead of REQ_DIRECT_EDIT (new DirectEditRequest).
				// Edit parts start direct editing on REQ_OPEN request type.
				editPart.performRequest(new Request(REQ_OPEN));
			}
		});
	}
	
}
