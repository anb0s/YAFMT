package cz.jpikl.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import cz.jpikl.yafmt.ui.views.fm.decorations.AttributeDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenConstraintDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenGroupDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.HiddenNeighborsDecoration;
import cz.jpikl.yafmt.ui.views.fm.decorations.IDecoration;
import cz.jpikl.yafmt.ui.views.fm.graph.IDecorationSelecionProvider;


public class DecorationSelectionProvider implements IDecorationSelecionProvider {

    @Override
    public ISelection getSelectionForDecoration(IDecoration decoration) {
        return new StructuredSelection(getSelectionElements(decoration));
    }
    
    private List<?> getSelectionElements(IDecoration decoration) {
        if(decoration instanceof HiddenNeighborsDecoration)
            return ((HiddenNeighborsDecoration) decoration).getNeighbors();
        if(decoration instanceof HiddenGroupDecoration)
            return toList(((HiddenGroupDecoration) decoration).getGroup());
        if(decoration instanceof HiddenConstraintDecoration)
            return ((HiddenConstraintDecoration) decoration).getConstraints();
        if(decoration instanceof AttributeDecoration)
            return ((AttributeDecoration) decoration).getAttributes();
        return Collections.EMPTY_LIST;
    }
    
    private List<?> toList(Object element) {
        List<Object> list = new ArrayList<Object>(1);
        list.add(element);
        return list;
    }

}
