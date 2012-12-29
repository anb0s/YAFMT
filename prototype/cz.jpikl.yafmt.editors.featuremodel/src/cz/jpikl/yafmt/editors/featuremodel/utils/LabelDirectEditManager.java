package cz.jpikl.yafmt.editors.featuremodel.utils;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

// Manages initialization of cell editor during direct editing (of feature name).
public class LabelDirectEditManager extends DirectEditManager {

    private Label label;

    public LabelDirectEditManager(GraphicalEditPart source, Label label) {
        super(source, TextCellEditor.class, new LabelCellEditorLocator(label));
        this.label = label;
    }

    // Initializes cell editor value from label.
    @Override
    protected void initCellEditor() {
        getCellEditor().setValue(label.getText());
    }

    // Locates where to place cell editor during direct editing (of feature name).
    private static class LabelCellEditorLocator implements CellEditorLocator {

        private Label label;

        public LabelCellEditorLocator(Label label) {
            this.label = label;
        }

        @Override
        public void relocate(CellEditor cellEditor) {
            Text text = (Text) cellEditor.getControl();
            Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            Rectangle rect = label.getTextBounds().getCopy();
            label.translateToAbsolute(rect);
            text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);
        }

    }

}
