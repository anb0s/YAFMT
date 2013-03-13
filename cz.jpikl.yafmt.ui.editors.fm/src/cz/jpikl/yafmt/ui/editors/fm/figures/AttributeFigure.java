package cz.jpikl.yafmt.ui.editors.fm.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

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
        add(createErrorDecoration());
    }
    
    private IFigure createErrorDecoration() {
        errorDecoration = new ErrorDecoration();
        return errorDecoration;
    }

    // ==================================================================
    //  Properties
    // ==================================================================
    
    public void setErrors(List<String> messages) {
        errorDecoration.setErrors(messages);
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
