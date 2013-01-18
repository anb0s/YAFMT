package cz.jpikl.yafmt.editors.featureconfig.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;

public class TreeNodeFigure extends Label {

    private NodeEditPart editPart;
    
    public TreeNodeFigure(NodeEditPart editPart, String name) {
        super(name);
        
        this.editPart = editPart;        
        setBorder(new LineBorder());
        setBackgroundColor(ColorConstants.white);
        setOpaque(true);
    }
        
    public TreeNodeFigure getTreeNodeParent() {
        for(Object object: editPart.getSourceConnections()) {
            ConnectionEditPart connection = (ConnectionEditPart) object;
            GraphicalEditPart parent = (GraphicalEditPart) connection.getTarget();
            return (TreeNodeFigure) parent.getFigure();
        }
        return null;
    }
    
    public List<TreeNodeFigure> getTreeNodeChildern() {        
        List<TreeNodeFigure> list = new ArrayList<TreeNodeFigure>();
        for(Object object: editPart.getTargetConnections()) {
            ConnectionEditPart connection = (ConnectionEditPart) object;
            GraphicalEditPart child = (GraphicalEditPart) connection.getSource();
            list.add((TreeNodeFigure) child.getFigure());
        }
        return list;
    }

}
