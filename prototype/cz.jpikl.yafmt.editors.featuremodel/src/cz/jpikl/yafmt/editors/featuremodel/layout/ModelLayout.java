package cz.jpikl.yafmt.editors.featuremodel.layout;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface ModelLayout extends EObject {

    /**
     * @model containment="true"
     */
    EList<ObjectLayout> getObjectLayouts();

}
