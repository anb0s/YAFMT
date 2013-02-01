package cz.jpikl.yafmt.ui.editors.fm.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.ui.IEditorPart;

import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.ui.editors.fm.util.ImageExporter;

public class ExportAsImageAction extends EditorPartAction {

public static final String ID = "cz.jpikl.yafmt.ui.editors.fm.actions.ExportAsImageAction";
    
    private GraphicalViewer viewer;

    public ExportAsImageAction(IEditorPart editorPart, GraphicalViewer viewer) {
        super(editorPart);
        this.viewer = viewer;
        
        setId(ID);
        setText("Export As Image");
    }
        
    @Override
    protected boolean calculateEnabled() {
        return true;
    }
    
    @Override
    public void run() {
        String fileName = "image";
        FeatureModel feautureModel = (FeatureModel) getEditorPart().getAdapter(FeatureModel.class);
        if((feautureModel != null) && !feautureModel.getName().trim().isEmpty())
            fileName = feautureModel.getName().trim();
        
        ImageExporter.save(getEditorPart(), viewer, fileName);
    }
    
}
