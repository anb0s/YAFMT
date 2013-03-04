package cz.jpikl.yafmt.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class SelectionConverter {
    
    public static ISelection wrapSelection(ISelection selection, Map<?, ?> editPartRegistry) {
        if(!(selection instanceof IStructuredSelection))
            return selection;
        
        Object[] elements = ((IStructuredSelection) selection).toArray();
        List<Object> wrappedElements = new ArrayList<Object>(elements.length);
        
        // Result list MUST contain only edit parts!!!
        for(int i = 0; i < elements.length; i++) {
            Object editPart = editPartRegistry.get(elements[i]);
            if(editPart != null)
                wrappedElements.add(editPart);
        }
        
        return new StructuredSelection(wrappedElements);
    }
    
    public static ISelection unwrapSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return selection;
        
        Object[] elements = ((IStructuredSelection) selection).toArray();
        for(int i = 0; i < elements.length; i++) {
            Object element = elements[i];
            if(element instanceof EditPart) {
                Object model = ((EditPart) element).getModel();
                if(model != null)
                    elements[i] = model;
            }
        }
            
        return new StructuredSelection(elements);
    }
    
}
