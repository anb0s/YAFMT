package cz.jpikl.yafmt.model.featuremodel;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface FeatureModel extends EObject {

	/**
	 * @model containment="true" required="true" changeable="false"
	 */
	Feature getRootFeature();
	
	/**
	 * @model containment="true"
	 */
	List<Feature> getOrphanedFeatures();
	
	/**
	 * @model containment="true"
	 */
	List<Constraint> getConstraints();
	
}
