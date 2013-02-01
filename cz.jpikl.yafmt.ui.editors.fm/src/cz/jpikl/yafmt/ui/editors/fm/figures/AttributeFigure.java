package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;

public class AttributeFigure extends Label {
    
    public static int WIDTH = 150;
    public static int HEIGHT = 18;
    public static int EXTENDED_HEIGHT = 28;
    
    private String name;
    private String type;
    
    public AttributeFigure(Attribute attribute) {
        setForegroundColor(ColorConstants.black);
        updateLabel(attribute);
    }
    
    public void updateName(String name) {
        this.name = name;
        updateLabel();
    }
    
    public void updateType(AttributeType type) {
        this.type = getTypeName(type); 
        updateLabel();
    }
    
    public void updateLabel(Attribute attribute) {
        this.name = attribute.getName();
        this.type = getTypeName(attribute.getType());
        updateLabel();
    }
    
    private void updateLabel() {
        setText(name + ": " + type);
    }
       
    private static String getTypeName(AttributeType type) {
        switch(type) {
            case BOOLEAN: return "Boolean";
            case INTEGER: return "Integer";
            case DOUBLE:  return "Double";
            case STRING:  return "String";
            default:      return "Unknown";
        }
    }

}
