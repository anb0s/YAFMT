package cz.jpikl.yafmt.ui.editors.fm.util;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetSorter;

public class NonSortingPropertySheetPage extends UndoablePropertySheetPage {

    public NonSortingPropertySheetPage(CommandStack commandStack, IAction undoAction, IAction redoAction) {
        super(commandStack, undoAction, redoAction);
        
        setSorter(new PropertySheetSorter() {
            @Override
            public void sort(IPropertySheetEntry[] entries) {
            }
            
            @Override
            public int compareCategories(String categoryA, String categoryB) {
                // General category has always space at the end (sorting trick).
                if(categoryA.endsWith(" "))
                    return -1;
                if(categoryB.endsWith(" "))
                    return 1;
                return super.compareCategories(categoryA, categoryB);
            }
        });
    }

}
