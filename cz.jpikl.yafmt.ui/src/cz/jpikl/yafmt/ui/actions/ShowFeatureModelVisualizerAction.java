package cz.jpikl.yafmt.ui.actions;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.jpikl.yafmt.ui.CommonUIPlugin;

public class ShowFeatureModelVisualizerAction extends Action {

    public static final String ID = "cz.jpikl.yafmt.ui.actions.ShowFeatureModelVisualizerAction";
    private static final String VIEW_ID = "cz.jpikl.yafmt.ui.views.fm";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Show Feature Model Visualizer");
        action.setImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/fm-visualizer.png"));
        return action;
    }

    public ShowFeatureModelVisualizerAction() {
        initAction(this);
        setEnabled(true);
    }

    @Override
    public void run() {
        try {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            page.showView(VIEW_ID);
        }
        catch(PartInitException ex) {
            CommonUIPlugin.getDefault().getLog().log(new Status(Status.ERROR, CommonUIPlugin.PLUGIN_ID, null, ex));
        }
    }

}
