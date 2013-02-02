package cz.jpikl.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import cz.jpikl.yafmt.model.fm.Attribute;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.FeatureModel;
import cz.jpikl.yafmt.model.fm.Group;

public class FeatureModelContentProvider implements IGraphEntityContentProvider {

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
    
    @Override
    public void dispose() {
    }

    @Override
    public Object[] getElements(Object input) {
        if(input == null)
            return null;
        
        Feature rootFeature =  ((FeatureModel) input).getRoot();
        List<Object> objects = new ArrayList<Object>();
        objects.add(rootFeature);
        
        Iterator<EObject> it = rootFeature.eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(!(object instanceof Attribute))
                objects.add(object);
        }
        
        return objects.toArray();
    }

    @Override
    public Object[] getConnectedTo(Object element) {
        if(element instanceof Feature) {
            Feature feature = (Feature) element;
            
            List<Object> objects = new ArrayList<Object>();
            objects.addAll(feature.getFeatures());
            
            for(Group group: feature.getGroups())
                objects.addAll(group.getFeatures());
            
            return objects.toArray();
        }
        
        if(element instanceof Group) {
            return ((Group) element).getFeatures().toArray();
        }
        
        return null;
    }

}
