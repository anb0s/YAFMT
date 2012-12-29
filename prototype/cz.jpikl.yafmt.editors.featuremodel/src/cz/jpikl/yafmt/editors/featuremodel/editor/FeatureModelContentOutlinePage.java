package cz.jpikl.yafmt.editors.featuremodel.editor;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.provider.util.FeatureModelProviderUtil;

public class FeatureModelContentOutlinePage extends ContentOutlinePage {

    private FeatureModel featureModel;

    public FeatureModelContentOutlinePage(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        TreeViewer viewer = getTreeViewer();
        viewer.setContentProvider(new AdapterFactoryContentProvider(FeatureModelProviderUtil.getAdapterFactory()));
        viewer.setLabelProvider(new AdapterFactoryLabelProvider(FeatureModelProviderUtil.getAdapterFactory()));
        viewer.setInput(featureModel);
    }

}
