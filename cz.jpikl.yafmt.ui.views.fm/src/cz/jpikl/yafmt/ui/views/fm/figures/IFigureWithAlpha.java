package cz.jpikl.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.IFigure;

public interface IFigureWithAlpha extends IFigure {

    void setAlpha(int alpha);
    
    int getAlpha();
    
}
