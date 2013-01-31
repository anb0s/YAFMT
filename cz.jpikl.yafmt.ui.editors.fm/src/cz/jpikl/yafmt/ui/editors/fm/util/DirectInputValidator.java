package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.jface.viewers.ICellEditorValidator;

public class DirectInputValidator implements ICellEditorValidator {
    
    @Override
    public String isValid(Object value) {
        if((value == null) || ("".equals(value)))
            return "Empty input"; // Not displayed anywhere.
        return null;
    }
    
}