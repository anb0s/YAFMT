package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.Label;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;

public class AttributeFigure extends Label {
    
    public static int WIDTH = 150;
    public static int HEIGHT = 18;
    public static int EXTENDED_HEIGHT = 28;
    
    public AttributeFigure(Attribute attribute) {
        updateLabel(attribute);
    }
    
    public void updateLabel(Attribute attribute) {
        setText(attribute.getName() + ": " + getTypeName(attribute.getType()));
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
