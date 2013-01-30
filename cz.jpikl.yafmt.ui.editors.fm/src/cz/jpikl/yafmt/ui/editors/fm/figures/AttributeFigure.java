package cz.jpikl.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.SWT;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.AttributeType;

public class AttributeFigure extends Label {
        
    private static final Border HIGHLIGHT_BORDER = new LineBorder(ColorConstants.black, 1, SWT.LINE_DASH);
    private static final Border EMPTY_BORDER = new MarginBorder(1);
    
    public AttributeFigure(Attribute attribute) {
        updateLabel(attribute);
        setBorder(EMPTY_BORDER);
    }
    
    public void updateLabel(Attribute attribute) {
        setText(attribute.getName() + ": " + getTypeName(attribute.getType()));
    }
    
    public void setHighlighted(boolean highlighted) {
        setBorder(highlighted ? HIGHLIGHT_BORDER : EMPTY_BORDER);
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
