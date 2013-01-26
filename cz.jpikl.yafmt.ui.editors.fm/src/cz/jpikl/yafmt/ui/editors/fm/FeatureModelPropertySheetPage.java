package cz.jpikl.yafmt.ui.editors.fm;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetSorter;

import cz.jpikl.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class FeatureModelPropertySheetPage extends UndoablePropertySheetPage {

    public FeatureModelPropertySheetPage(CommandStack commandStack, IAction undoAction, IAction redoAction) {
        super(commandStack, undoAction, redoAction);
        setSorter(new DisabledSorter());
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        setPropertySourceProvider(FeatureModelProviderUtil.getContentProvider());
    }
    
    private static class DisabledSorter extends PropertySheetSorter {
        
        @Override
        public void sort(IPropertySheetEntry[] entries) {
            // Disable sorting of entries.
        }
        
        @Override
        public int compareCategories(String categoryA, String categoryB) {
            // General category will always have space at the end (sorting trick).
            if(categoryA.endsWith(" "))
                return -1;
            if(categoryB.endsWith(" "))
                return 1;
            return super.compareCategories(categoryA, categoryB);
        }
        
    }

}
