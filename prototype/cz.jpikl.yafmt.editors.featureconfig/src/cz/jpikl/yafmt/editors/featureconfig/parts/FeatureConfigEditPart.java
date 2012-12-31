package cz.jpikl.yafmt.editors.featureconfig.parts;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class FeatureConfigEditPart extends AbstractGraphicalEditPart {


    @Override
    protected IFigure createFigure() {
        IFigure figure = new FreeformLayer();
        figure.setBorder(new MarginBorder(3));
        figure.setLayoutManager(new FreeformLayout());
        return figure;
    }

    @Override
    protected void createEditPolicies() {
        
    }

}
