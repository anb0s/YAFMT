package cz.jpikl.yafmt.ui.views.fm.decorations;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Constraint;
import cz.jpikl.yafmt.ui.views.fm.FeatureModelVisualizerPlugin;

public class ConstraintDecoration extends ImageDecoration {

    private List<Constraint> constraints;
    private Label toolTip;
    
    public ConstraintDecoration(List<Constraint> constraints) {
        super(FeatureModelVisualizerPlugin.getAccess().getImage("constraint-decoration.png"));
        this.constraints = constraints;
    }
    
    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    public List<Constraint> getConstraints() {
        return constraints;
    }
    
    @Override
    public IFigure getToolTip() {
        if(toolTip == null)
            toolTip = new Label(createToolTipText());
        return toolTip;
    }
    
    private String createToolTipText() {
        StringBuilder builder = new StringBuilder();
        
        if(constraints.size() == 1) {
            builder.append("There is a constraint affecting this feature (");
            builder.append(constraints.get(0).getValue()).append(").");
        }
        else {
            builder.append("There are constraints affecting this feature:");
            for(Constraint constraint: constraints)
                builder.append("\n    - ").append(constraint.getValue());
        }
        
        return builder.toString();
    }
    
    // ===============================================================
    //  Decoration properties
    // ===============================================================
    
    @Override
    public Rectangle computeBounds(Rectangle parentBounds) {
        int x = parentBounds.x - bounds.width + 2;
        int y = parentBounds.y - bounds.height + 2;
        return new Rectangle(x, y, bounds.width, bounds.height);
    }

}
