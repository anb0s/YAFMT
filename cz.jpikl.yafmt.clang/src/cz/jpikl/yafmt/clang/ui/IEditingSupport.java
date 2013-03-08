package cz.jpikl.yafmt.clang.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

public interface IEditingSupport {

    CellEditor createCellEditor(Composite composite, EditingContext context);

}
