package cz.jpikl.yafmt.ui.pages;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetSorter;

public class EditorPropertySheetPage extends UndoablePropertySheetPage {

    private static CommandStack getCommandStack(IAdaptable adaptable) {
        return (CommandStack) adaptable.getAdapter(CommandStack.class);
    }

    private static ActionRegistry getActionRegistry(IAdaptable adaptable) {
        return (ActionRegistry) adaptable.getAdapter(ActionRegistry.class);
    }

    private static IAction getUndoAction(IAdaptable adaptable) {
        return getActionRegistry(adaptable).getAction(ActionFactory.UNDO.getId());
    }

    private static IAction getRedoAction(IAdaptable adaptable) {
        return getActionRegistry(adaptable).getAction(ActionFactory.REDO.getId());
    }

    private IPropertySourceProvider provider;

    public EditorPropertySheetPage(GraphicalEditor editor, IPropertySourceProvider provider) {
        super(getCommandStack(editor), getUndoAction(editor), getRedoAction(editor));

        this.provider = provider;
        setSorter(new DisabledSorter());
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        setPropertySourceProvider(provider);
    }

    private static class DisabledSorter extends PropertySheetSorter {

        @Override
        public void sort(IPropertySheetEntry[] entries) {
            // Disable sorting of entries.
        }

    }

}
