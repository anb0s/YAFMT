package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.jpikl.yafmt.ui.figures.SeparatorFigure;
import cz.jpikl.yafmt.ui.util.DrawConstantans;

public class FeatureFigure extends RoundedRectangle {

    public static final int WIDTH = 100;
    public static final int HEGHT = 25;

    private Label label = new Label();
    private Label toolTip = new Label();
    private SeparatorFigure separator;
    private Figure attributes;
    private Image constraintDecoration;

    private Feature feature;
    private boolean orphaned;    // Is feature orphaned?
    private boolean constrained; // Has feature constraints?

    public FeatureFigure(Feature feature) {
        this.feature = feature;
        this.orphaned = feature.isOrphan();
        this.constrained = false;
        this.constraintDecoration = FeatureModelEditorPlugin.getDefault().getImageRegistry().get("constraint-decoration");

        setLayoutManager(new GridLayout());
        setToolTip(toolTip);

        label.setFont(DrawConstantans.BOLD_FONT);
        label.setForegroundColor(ColorConstants.black);
        add(label, new GridData(SWT.FILL, SWT.FILL, true, true));

        setForegroundColor(ColorConstants.black);
        refresh();
    }

    public Label getLabel() {
        return label;
    }

    public boolean setOrphaned(boolean orphaned) {
        if(this.orphaned != orphaned) {
            this.orphaned = orphaned;
            repaint();
            return true;
        }
        return false;
    }

    public void setConstrained(boolean constrained) {
        if(this.constrained != constrained) {
            this.constrained = constrained;
            repaint();
        }
    }

    public void refresh() {
        label.setText(feature.getName());
        String description = feature.getDescription();
        if((description != null) && !description.isEmpty())
            toolTip.setText(feature.getId() + " - " + description);
        else
            toolTip.setText(feature.getId());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        if(constrained)
            graphics.drawImage(constraintDecoration, bounds.x + 2, bounds.y + 2);
    }

    @Override
    protected void fillShape(Graphics graphics) {
        Pattern pattern = null;
        if(!orphaned) {
            pattern = createPattern(graphics, DrawConstantans.FEATURE_GRADIENT_COLOR, ColorConstants.white);
            graphics.setBackgroundPattern(pattern);
        }

        super.fillShape(graphics);
        graphics.setBackgroundPattern(null);

        if(pattern != null)
            pattern.dispose();
    }
    
    @Override
    protected void outlineShape(Graphics graphics) {
        if(orphaned) {
            graphics.setLineStyle(SWT.LINE_CUSTOM);
            graphics.setLineDash(DrawConstantans.LINE_DASHED);
        }
        super.outlineShape(graphics);
    }

    private Pattern createPattern(Graphics graphics, Color topColor, Color bottomColor) {
        Point top = bounds.getTop();
        Point bottom = bounds.getBottom();
        double scale = graphics.getAbsoluteScale();

        // Apply scale.
        int topX = (int) (scale * top.x);
        int topY = (int) (scale * top.y);
        int bottomX = (int) (scale * bottom.x);
        int bottomY = (int) (scale * bottom.y);

        return new Pattern(Display.getCurrent(), topX, topY, bottomX, bottomY, topColor, bottomColor);
    }

    private void addAttributeFigure(IFigure figure, Object constraint, int index) {
        if(attributes == null) {
            separator = new SeparatorFigure();
            attributes = new AttributeContainerFigure();
            add(separator, new GridData(SWT.FILL, SWT.CENTER, true, false), 1);
            add(attributes, new GridData(SWT.CENTER, SWT.FILL, true, false), 2);
        }
        attributes.add(figure, constraint, index);
    }

    private void removeAttributeFigure(IFigure figure) {
        attributes.remove(figure);
        if(attributes.getChildren().isEmpty()) {
            remove(attributes);
            remove(separator);
            attributes = null;
            separator = null;
        }
    }

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

}
