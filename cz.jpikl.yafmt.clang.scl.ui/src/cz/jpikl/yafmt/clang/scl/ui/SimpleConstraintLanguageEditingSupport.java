package cz.jpikl.yafmt.clang.scl.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import cz.jpikl.yafmt.clang.scl.ui.internal.SimpleConstraintLanguageActivator;
import cz.jpikl.yafmt.clang.ui.EditingSupport;
import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor;

public class SimpleConstraintLanguageEditingSupport extends EditingSupport {
        
    @Override
    public CellEditor createCellEditor(Composite parent) {
        String languageId = SimpleConstraintLanguageActivator.CZ_JPIKL_YAFMT_CLANG_SCL_SIMPLECONSTRAINTLANGUAGE;
        Injector injector = SimpleConstraintLanguageActivator.getInstance().getInjector(languageId);
        
        XtextStyledTextCellEditor cellEditor = new XtextStyledTextCellEditor(SWT.NONE, injector);
        cellEditor.create(parent);
        return cellEditor;
    }

}
