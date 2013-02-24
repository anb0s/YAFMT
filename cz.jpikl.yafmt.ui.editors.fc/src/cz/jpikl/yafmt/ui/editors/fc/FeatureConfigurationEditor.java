package cz.jpikl.yafmt.ui.editors.fc;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;

public class FeatureConfigurationEditor extends GraphicalEditor {

    public FeatureConfigurationEditor() {
        setEditDomain(new DefaultEditDomain(this));
    }

    @Override
    protected void initializeGraphicalViewer() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        // TODO Auto-generated method stub
    }

}
