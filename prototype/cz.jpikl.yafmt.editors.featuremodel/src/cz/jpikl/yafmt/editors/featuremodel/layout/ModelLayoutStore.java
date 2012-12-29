package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.emf.ecore.EObject;

public interface ModelLayoutStore {

    void setObjectLayout(EObject object, EObject layoutData);

    EObject getObjectLayout(EObject object);

}
