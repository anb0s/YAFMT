package cz.jpikl.yafmt.views.featuremodel.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import cz.jpikl.yafmt.models.featuremodel.Constraint;
import cz.jpikl.yafmt.models.featuremodel.Feature;
import cz.jpikl.yafmt.models.featuremodel.FeatureModel;
import cz.jpikl.yafmt.models.featuremodel.util.FeatureModelUtil;

public class FeatureModelContentProvider implements IGraphEntityContentProvider {

    private FeatureModelUtil fmUtil;

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fmUtil = (newInput != null) ? new FeatureModelUtil((FeatureModel) newInput) : null;
    }
    
    @Override
    public void dispose() {
        fmUtil.dispose();
    }

    @Override
    public Object[] getElements(Object input) {
        List<Object> elements = new ArrayList<Object>();
        if(input == null)
            return elements.toArray();

        FeatureModel featureModel = (FeatureModel) input;
        elements.addAll(featureModel.getConstraints());
        Feature rootFeature = featureModel.getRootFeature();
        elements.add(rootFeature);

        TreeIterator<EObject> it = rootFeature.eAllContents();
        while(it.hasNext()) {
            EObject obj = it.next();
            if(obj instanceof Feature)
                elements.add(obj);
        }

        return elements.toArray();
    }

    @Override
    public Object[] getConnectedTo(Object object) {
        if(object instanceof Feature)
            return ((Feature) object).getChildren().toArray();
        if(object instanceof Constraint) {
            List<Object> objects = new ArrayList<Object>();
            for(String name: ((Constraint) object).getValue().split("\\s+")) {
                Feature feature = fmUtil.getFeatureByName(name);
                if(feature != null)
                    objects.add(feature);
            }
            return objects.toArray();
        }
        return null;
    }

}
