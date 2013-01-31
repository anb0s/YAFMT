package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IEditorPart;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.util.ImageExporter;

public class ExportAsImageAction extends WorkbenchPartAction {

public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.ExportAsImageAction";
    
    private GraphicalViewer viewer;

    public ExportAsImageAction(IEditorPart editorPart) {
        super(editorPart);
        setId(ID);
        setText("Export As Image");
    }
    
    public void setGraphicalViewer(GraphicalViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    protected boolean calculateEnabled() {
        return true;
    }
    
    @Override
    public void run() {
        String fileName = "image";
        FeatureModel feautureModel = (FeatureModel) getWorkbenchPart().getAdapter(FeatureModel.class);
        if((feautureModel != null) && !feautureModel.getName().trim().isEmpty())
            fileName = feautureModel.getName().trim();
        
        ImageExporter.save((IEditorPart) getWorkbenchPart(), viewer, fileName);
    }
    
}
