package cz.jpikl.yafmt.editors.featureconfig.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import cz.jpikl.yafmt.models.featuremodel.Feature;

public class FeatureClone extends EObjectImpl implements Feature {

    private Feature originator;
    private int id;

    public FeatureClone(Feature origin, int id) {
        this.originator = origin;
    }

    public Feature getOriginator() {
        return originator;
    }

    @Override
    public String getName() {
        return originator.getName();
    }

    @Override
    public void setName(String name) {
        originator.setName(name);
    }

    @Override
    public EList<Feature> getChildren() {
        return originator.getChildren();
    }

    @Override
    public Feature getParent() {
        return originator.getParent();
    }

    @Override
    public void setParent(Feature parent) {
        originator.setParent(parent);
    }
    
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof FeatureClone))
            return false;
        FeatureClone clone = (FeatureClone) object;
        return originator.equals(clone.originator) && (id == clone.id);
    }
    
    @Override
    public int hashCode() {
        return originator.hashCode() + new Integer(id).hashCode();
    }
    
}
