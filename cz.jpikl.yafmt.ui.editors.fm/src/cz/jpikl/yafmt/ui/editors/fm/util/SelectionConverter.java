package cz.jpikl.yafmt.ui.editors.fm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class SelectionConverter {

    private Map<Object, Object> editPartRegistry;
    
    public SelectionConverter(Map<Object, Object> editPartRegistry) {
        this.editPartRegistry = editPartRegistry;
    }
    
    public ISelection wrapSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return selection;
        
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        List<Object> wrappedValues = new ArrayList<Object>();
        
        for(Object value: structuredSelection.toArray()) {
            Object wrappedValue = editPartRegistry.get(value);
            if(wrappedValue != null)
                wrappedValues.add(wrappedValue);
        }
        
        return new StructuredSelection(wrappedValues);
    }
    
    public static ISelection unwrapSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return selection;
        
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        if(!(structuredSelection.getFirstElement() instanceof EditPart))
            return selection;
        
        Object[] values = structuredSelection.toArray();
        Object[] unwrappedValues = new Object[values.length];
        
        for(int i = 0; i < values.length; i++) {
            if(values[i] instanceof EditPart){
                unwrappedValues[i] = ((EditPart) values[i]).getModel();}
            else
                unwrappedValues[i] = values[i];
        }
            
        return new StructuredSelection(unwrappedValues);
    }
    
}