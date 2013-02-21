package cz.jpikl.yafmt.ui.editors.fm.directediting;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class LabelDirectEditManager extends DirectEditManager {

    private String text;
    private ICellEditorValidator validator;
    
    public LabelDirectEditManager(GraphicalEditPart source, Label label) {
        this(source, label, label.getText());
    }
    
    public LabelDirectEditManager(GraphicalEditPart source, Label label, String text) {
        super(source, TextCellEditor.class, new LabelCellEditorLocator(label));
        this.text = text;
    }

    public void setValidator(ICellEditorValidator validator) {
        this.validator = validator;
    }
    
    @Override
    protected void initCellEditor() {
        // Initializes cell editor value from label.
        getCellEditor().setValue(text);
        getCellEditor().setValidator(validator);
    }
            
    // Locates where to place cell editor during direct editing.
    private static class LabelCellEditorLocator implements CellEditorLocator {

        private Label label;
        
        public LabelCellEditorLocator(Label label) {
            this.label = label;
        }
        
        @Override
        public void relocate(CellEditor cellEditor) {
            Text text = (Text) cellEditor.getControl();
            Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            if(text.getText().isEmpty())
                pref.x = 4;
            Rectangle rect = label.getTextBounds().getCopy();
            label.translateToAbsolute(rect);
            text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);
        }

    }

}
