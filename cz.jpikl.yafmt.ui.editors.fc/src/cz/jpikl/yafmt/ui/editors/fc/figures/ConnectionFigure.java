package cz.jpikl.yafmt.ui.editors.fc.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;

public class ConnectionFigure extends PolylineConnection {

    public ConnectionFigure() {
        setForegroundColor(ColorConstants.black);
        setSourceDecoration(createSourceDecoration());
    }
    
    private PolygonDecoration createSourceDecoration() {
        PolygonDecoration decoration = new PolygonDecoration();
        decoration.setTemplate(PolygonDecoration.TRIANGLE_TIP);
        return decoration;
    }
    
    public void setGrayed(boolean grayed) {
        setForegroundColor(grayed ? ColorConstants.lightGray : ColorConstants.black);
    }
    
}
