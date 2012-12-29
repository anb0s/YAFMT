package cz.jpikl.yafmt.models.featuremodel;

import org.eclipse.emf.common.util.EList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface FeatureModel extends EObject {

    /**
     * @model containment="true" required="true"
     */
    Feature getRootFeature();

    /**
     * Sets the value of the '{@link cz.jpikl.yafmt.models.featuremodel.FeatureModel#getRootFeature <em>Root Feature</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root Feature</em>' containment reference.
     * @see #getRootFeature()
     * @generated
     */
    void setRootFeature(Feature value);

    /**
     * @model containment="true"
     */
    EList<Feature> getOrphanedFeatures();

    /**
     * @model containment="true"
     */
    EList<Constraint> getConstraints();

}
