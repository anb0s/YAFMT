package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;

public class ConnectionFigure extends PolylineConnection {
    
    public ConnectionFigure() {
        PolygonDecoration decoration = new PolygonDecoration();
        decoration.setTemplate(PolygonDecoration.TRIANGLE_TIP);
        setSourceDecoration(decoration);
    }

}
