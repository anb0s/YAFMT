package cz.jpikl.yafmt.ui.util;

import org.eclipse.jface.viewers.ICellEditorValidator;

public class NonEmptyCellEditorValidator implements ICellEditorValidator {

    @Override
    public String isValid(Object value) {
        if((value == null) || ("".equals(value)))
            return "Empty input";
        return null;
    }

}
