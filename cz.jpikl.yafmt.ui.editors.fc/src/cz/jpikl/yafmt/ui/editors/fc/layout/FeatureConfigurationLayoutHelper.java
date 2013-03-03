package cz.jpikl.yafmt.ui.editors.fc.layout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.NodeEditPart;

import cz.jpikl.yafmt.ui.editors.fc.parts.ConnectionEditPart;

public class FeatureConfigurationLayoutHelper implements TreeLayout.Helper {

    private GraphicalViewer viewer;
    
    public void setGraphicalViewer(GraphicalViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public IFigure getTreeParentFigure(IFigure figure) {
        Object part = viewer.getVisualPartMap().get(figure);
        if(!(part instanceof NodeEditPart))
            return null;
        
        for(Object connectionPart: ((NodeEditPart) part).getSourceConnections()) {
            if(connectionPart instanceof ConnectionEditPart) {
                Object targetPart = ((ConnectionEditPart) connectionPart).getTarget();
                if(targetPart instanceof GraphicalEditPart)
                    return ((GraphicalEditPart) targetPart).getFigure();
            }
        }
        return null;
    }

    @Override
    public List<IFigure> getTreeChildrenFigures(IFigure figure) {
        Object part = viewer.getVisualPartMap().get(figure);
        if(!(part instanceof NodeEditPart))
            return null;
        
        List<IFigure> figures = new ArrayList<IFigure>();
        for(Object connectionPart: ((NodeEditPart) part).getTargetConnections()) {
            if(connectionPart instanceof ConnectionEditPart) {
                Object sourcePart = ((ConnectionEditPart) connectionPart).getSource();
                if(sourcePart instanceof GraphicalEditPart)
                    figures.add(((GraphicalEditPart) sourcePart).getFigure());
            }
        }
        return figures;
    }

}
