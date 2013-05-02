package cz.zcu.yafmt.ui.editors.fm.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.ui.figures.ConstraintMarker;
import cz.zcu.yafmt.ui.figures.ErrorMarker;
import cz.zcu.yafmt.ui.figures.MarkerLayer;
import cz.zcu.yafmt.ui.figures.SeparatorFigure;
import cz.zcu.yafmt.ui.figures.VerticalToolbarFigure;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class FeatureFigure extends RoundedRectangle {

    public static final int INITIAL_WIDTH = 96;
    public static final int INITIAL_HEGHT = 24;

    private Label label;
    private Label toolTip;
    private Figure mainLayer;
    private MarkerLayer markerLayer;
    private Figure separatorFigure;
    private Figure attributesContainer;
    private ErrorMarker errorMarker;
    private ConstraintMarker constraintMarker;

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
        setMinimumSize(new Dimension(INITIAL_WIDTH, INITIAL_HEGHT));
        add(createMainLayer());
        add(createMarkerLayer());
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
        label.setFont(DrawUtil.BOLD_FONT);
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
    //  Initialization (marker layer)
    // ==================================================================
    
    private IFigure createMarkerLayer() {
        markerLayer = new MarkerLayer();
        markerLayer.add(createErrorMarker());
        markerLayer.add(createConstraintMarker());
        return markerLayer;
    }
    
    private IFigure createErrorMarker() {
        errorMarker = new ErrorMarker();
        return errorMarker;
    }
    
    private IFigure createConstraintMarker() {
        constraintMarker = new ConstraintMarker();
        return constraintMarker;
    }
    
    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        errorMarker.setErrors(messages);
        markerLayer.refresh();
    }
    
    public void setConstrained(boolean value) {
        if(constraintMarker.isVisible() != value) {
            constraintMarker.setVisible(value);
            markerLayer.refresh();
        }
    }
    
    public void setOrphaned(boolean value) {
        if(orphaned != value) {
            orphaned = value;
            repaint();
        }
    }
    
    public Label getLabel() {
        return label;
    }
    
    public Feature getFeature() {
        return feature;
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
    
    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        return super.getPreferredSize(wHint, hHint).getExpanded(24, 0);
    }
    
    // ==================================================================
    //  Drawing
    // ==================================================================

    @Override
    public void paint(Graphics graphics) {
        DrawUtil.fixScaledFigureLocation(graphics);
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
            graphics.setLineDash(DrawUtil.LINE_DASHED);
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

        return new Pattern(Display.getCurrent(), topX, topY, bottomX, bottomY,  DrawUtil.FEATURE_GRADIENT_COLOR, ColorConstants.white);
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
