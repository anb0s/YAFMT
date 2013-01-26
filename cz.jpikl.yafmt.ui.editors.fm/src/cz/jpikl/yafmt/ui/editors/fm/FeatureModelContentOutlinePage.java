package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheet;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class FeatureModelContentOutlinePage extends ContentOutlinePage implements ISelectionListener {

    private FeatureModel featureModel;
    
    public FeatureModelContentOutlinePage(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }
    
    @Override
    public void init(IPageSite pageSite) {
        super.init(pageSite);
        pageSite.getPage().addSelectionListener(this);
    }
    
    @Override
    public void dispose() {
        getSite().getPage().removeSelectionListener(this);
        super.dispose();
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
        // Ignore invalid selections.
        if(part != getSite().getPage().getActivePart())
            return;
        if((part instanceof ContentOutline) || (part instanceof PropertySheet))
            return;
                
        setSelection(selection);
    }

}
