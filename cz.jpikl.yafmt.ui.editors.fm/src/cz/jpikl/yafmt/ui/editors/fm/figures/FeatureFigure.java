package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.figures.ErrorDecoration;
import cz.jpikl.yafmt.ui.figures.SeparatorFigure;
import cz.jpikl.yafmt.ui.figures.VerticalToolbarFigure;
import cz.jpikl.yafmt.ui.util.DrawConstantans;
import cz.jpikl.yafmt.ui.util.DrawUtil;

public class FeatureFigure extends RoundedRectangle {

    public static final int INITIAL_WIDTH = 100;
    public static final int INITIAL_HEGHT = 25;
    private static final int DECORATION_SPACE = 2;

    private Label label;
    private Label toolTip;
    private Figure mainLayer;
    private Figure separatorFigure;
    private Figure attributesContainer;
    private ErrorDecoration errorDecoration;
    private ErrorDecoration constraintDecoration;

    private Feature feature;
    private boolean orphaned;

    public FeatureFigure(Feature feature) {
        this.feature = feature;
        this.orphaned = feature.isOrphan();
        initialize();
        refresh();
    }
    
    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setForegroundColor(ColorConstants.black);
        setLayoutManager(new StackLayout());
        setToolTip(createToolTip());
        add(createMainLayer());
        add(createDecorationLayer());
    }

    private IFigure createToolTip() {
        toolTip = new Label();
        return toolTip;
    }

    // ==================================================================
    //  Initialization (main layer)
    // ==================================================================
    
    private IFigure createMainLayer() {
        mainLayer = new Figure();
        mainLayer.setLayoutManager(new GridLayout());
        mainLayer.add(createLabel(), new GridData(SWT.CENTER, SWT.CENTER, true, true));
        return mainLayer;
    }
    
    private IFigure createLabel() {
        label = new Label();
        label.setFont(DrawConstantans.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        return label;
    }
    
    private void initializeAttributesContainer() {
        mainLayer.add(createSeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false), 1);
        mainLayer.add(createAttributesContainer(), new GridData(SWT.CENTER, SWT.CENTER, true, false), 2);
    }
    
    private void destroyAttributesContainer() {
        mainLayer.remove(attributesContainer);
        mainLayer.remove(separatorFigure);
        attributesContainer = null;
        separatorFigure = null;
    }
    
    private Figure createAttributesContainer() {
        attributesContainer = new VerticalToolbarFigure();
        return attributesContainer;
    }
    
    private Figure createSeparatorFigure() {
        separatorFigure = new SeparatorFigure();
        return separatorFigure;
    }
    
    // ==================================================================
    //  Initialization (decorations layer)
    // ==================================================================
    
    private IFigure createDecorationLayer() {
        Figure layer = new Layer();
        layer.add(createErrorDecoration());
        layer.add(createConstraintDecoration());
        return layer;
    }
    
    private IFigure createErrorDecoration() {
        errorDecoration = new ErrorDecoration();
        return errorDecoration;
    }
    
    private IFigure createConstraintDecoration() {
        constraintDecoration = new ErrorDecoration();
        return constraintDecoration;
    }
    
    private void repositionDecorations() {
        int x = DECORATION_SPACE;
        if(errorDecoration.isVisible()) {
            errorDecoration.setLocation(new Point(x, DECORATION_SPACE));
            x += errorDecoration.getSize().width + DECORATION_SPACE;
        }
        if(constraintDecoration.isVisible())
            constraintDecoration.setLocation(new Point(x, DECORATION_SPACE));
    }

    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        errorDecoration.setErrors(messages);
        repositionDecorations();
    }
    
    public void setConstrained(boolean value) {
        constraintDecoration.setVisible(value);
        repositionDecorations();
    }
    
    public boolean setOrphaned(boolean value) {
        if(orphaned == value)
            return false;
        orphaned = value;
        return true;
    }
    
    public Label getLabel() {
        return label;
    }

    public void refresh() {
        label.setText(feature.getName());
        toolTip.setText(createDescriptionText());
    }
    
    private String createDescriptionText() {
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            return feature.getId() + " - " + description;
        else
            return feature.getId();
    }
    
    // ==================================================================
    //  Drawing
    // ==================================================================

    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixZoomedFigureLocation(graphics);
        super.paint(graphics);
    }

    @Override
    protected void fillShape(Graphics graphics) {
        Pattern pattern = createBackgroundPattern(graphics);
        if(pattern != null)
            graphics.setBackgroundPattern(pattern);

        super.fillShape(graphics);
        
        if(pattern != null) {
            graphics.setBackgroundPattern(null);
            pattern.dispose();
        }
    }
        
    @Override
    protected void outlineShape(Graphics graphics) {
        if(orphaned) {
            graphics.setLineStyle(SWT.LINE_CUSTOM);
            graphics.setLineDash(DrawConstantans.LINE_DASHED);
        }
        super.outlineShape(graphics);
    }

    private Pattern createBackgroundPattern(Graphics graphics) {
        if(orphaned)
            return null;
        
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        double scale = graphics.getAbsoluteScale();

        // Apply scale.
        int topX = (int) (scale * top.x);
        int topY = (int) (scale * top.y);
        int bottomX = (int) (scale * bottom.x);
        int bottomY = (int) (scale * bottom.y);

        return new Pattern(Display.getCurrent(), topX, topY, bottomX, bottomY,  DrawConstantans.FEATURE_GRADIENT_COLOR, ColorConstants.white);
    }

    // ==================================================================
    //  Events
    // ==================================================================
    
    @Override
    public void add(IFigure figure, Object constraint, int index) {
        if(figure instanceof AttributeFigure)
            addAttributeFigure(figure, constraint, index);
        else
            super.add(figure, constraint, index);
    }

    @Override
    public void remove(IFigure figure) {
        if(figure instanceof AttributeFigure)
            removeAttributeFigure(figure);
        else
            super.remove(figure);
    }
    
    private void addAttributeFigure(IFigure figure, Object constraint, int index) {
        if(attributesContainer == null)
            initializeAttributesContainer();
        attributesContainer.add(figure, constraint, index);
    }

    private void removeAttributeFigure(IFigure figure) {
        attributesContainer.remove(figure);
        if(attributesContainer.getChildren().isEmpty())
            destroyAttributesContainer();
    }

}
