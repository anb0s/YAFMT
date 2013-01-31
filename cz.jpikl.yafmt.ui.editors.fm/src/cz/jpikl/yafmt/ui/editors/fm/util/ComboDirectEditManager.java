package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.custom.CCombo;

public class ComboDirectEditManager extends DirectEditManager {

    private Object value;
    
    public ComboDirectEditManager(GraphicalEditPart source, Rectangle bounds, Class<?> cellEditorType, Object value) {
        super(source, cellEditorType, new SimpleLocator(bounds));
        this.value = value;
    }

    @Override
    protected void initCellEditor() {
        getCellEditor().setValue(value);
    }
    
    @Override
    protected void commit() {
        // Cell editor does not notify direct edit manager about value change.
        // Do it manually.
        if(!value.equals(getCellEditor().getValue()))
            setDirty(true);
        super.commit();
    }

    // Locates the editor on specified position.
    private static class SimpleLocator implements CellEditorLocator {

        private Rectangle bounds;
        
        public SimpleLocator(Rectangle bounds) {
            this.bounds = bounds;
        }
        
        @Override
        public void relocate(CellEditor cellEditor) {
            CCombo combo = (CCombo) cellEditor.getControl();
            combo.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        }
        
    }

}
