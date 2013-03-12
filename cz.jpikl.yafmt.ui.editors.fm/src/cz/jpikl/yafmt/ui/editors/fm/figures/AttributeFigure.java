package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;
import cz.jpikl.yafmt.ui.figures.ErrorDecoration;

public class AttributeFigure extends Label {

    public static int WIDTH = 150;
    public static int HEIGHT = 18;
    public static int EXTENDED_HEIGHT = 28;

    private Attribute attribute;
    private ErrorDecoration errorDecoration;

    public AttributeFigure(Attribute attribute) {
        this.attribute = attribute;
        initialize();
        refresh();
    }

    // ==================================================================
    //  Initialization
    // ==================================================================
    
    private void initialize() {
        setForegroundColor(ColorConstants.black);
        //setLayoutManager(new StackLayout());
        add(createErrorDecoration());
    }
    
    private IFigure createDecorationLayer() {
        IFigure layer = new Figure();
        layer.setLayoutManager(new XYLayout());
        layer.add(createErrorDecoration(), new Rectangle(0, 0, 12, 12));
        return layer;
    }
    
    private IFigure createErrorDecoration() {
        errorDecoration = new ErrorDecoration();
        return errorDecoration;
    }

    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        List<String> s = new ArrayList<String>();s.add("aaaa");
        errorDecoration.setErrors(s);
    }
    
    public void refresh() {
        setNameAndType(attribute.getName(), attribute.getType());
    }

    public void setName(String name) {
        setNameAndType(name, attribute.getType());
    }

    private void setNameAndType(String name, AttributeType type) {
        setText(name + ": " + getTypeName(type));
    }

    private static String getTypeName(AttributeType type) {
        switch(type) {
            case BOOLEAN:
                return "Boolean";
            case INTEGER:
                return "Integer";
            case DOUBLE:
                return "Double";
            case STRING:
                return "String";
            default:
                return "Unknown";
        }
    }

}
