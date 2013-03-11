package cz.jpikl.yafmt.ui.figures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.StackLayout;

public class FigureDecorator extends Figure {

    private static final int DEFAULT_BORDER_SIZE = 2;
    
    public FigureDecorator(IFigure figure) {
        this(figure, DEFAULT_BORDER_SIZE);
    }
    
    public FigureDecorator(IFigure figure, int borderSize) {
        setLayoutManager(new StackLayout());
        add(figure);
        add(createDecorationLayer(borderSize));
    }

    private IFigure createDecorationLayer(int borderSize) {
        IFigure decorationLayer = new Figure();
        decorationLayer.setLayoutManager(createDecorationLayerLayout(borderSize));
        decorationLayer.setBorder(new MarginBorder(borderSize + 1));
        return decorationLayer;
    }
    
    private LayoutManager createDecorationLayerLayout(int borderSize) {
        FlowLayout layout = new FlowLayout(true);
        layout.setMajorAlignment(OrderedLayout.ALIGN_TOPLEFT);
        layout.setMajorSpacing(borderSize);
        layout.setMinorSpacing(borderSize);
        return layout;
    }

    public IFigure getFigure() {
        return (IFigure) getChildren().get(0);
    }
    
    private IFigure getDecorationLayer() {
        return (IFigure) getChildren().get(1);
    }
    
    public void addDecoration(IFigure decoration) {
        getDecorationLayer().add(decoration);
    }
    
    @SuppressWarnings("unchecked")
    public List<IFigure> getDecorations() {
        return Collections.unmodifiableList(getDecorationLayer().getChildren());
    }
    
}
