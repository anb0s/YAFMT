package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class FeatureModelContentOutlinePage extends ContentOutlinePage implements ISelectionListener {

    private FeatureModel featureModel;
    
    public FeatureModelContentOutlinePage(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        
        TreeViewer viewer = getTreeViewer();
        viewer.setContentProvider(FeatureModelProviderUtil.getContentProvider());
        viewer.setLabelProvider(FeatureModelProviderUtil.getLabelProvider());
        viewer.setInput(featureModel);
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if(!(part instanceof ContentOutline))
            setSelection(selection);
    }

}
