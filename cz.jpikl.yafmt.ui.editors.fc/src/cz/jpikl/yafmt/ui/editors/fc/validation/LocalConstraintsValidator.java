package cz.jpikl.yafmt.ui.editors.fc.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;
import cz.jpikl.yafmt.model.fm.Feature;
import cz.jpikl.yafmt.model.fm.Group;

public class LocalConstraintsValidator implements IFeatureConfigurationValidator {

	@Override
	public void validate(FeatureConfiguration featureConfig, IValidationResultWriter writer) {
		TreeIterator<EObject> it = featureConfig.getFeatureModelCopy().eAllContents();
		while(it.hasNext()) {
			EObject object = it.next();
			if(object instanceof Group)
				validateGroup((Group) object, featureConfig, writer);
		}
	}
	
	private void validateGroup(Group group, FeatureConfiguration featureConfig, IValidationResultWriter writer) {
		List<Selection> parentSelections = featureConfig.getSelectionsById(group.getParent().getId());
		if(parentSelections == null)
			return;
		
		// Collect children IDs.
		Set<String> groupChildrenIds = new HashSet<String>();
		for(Feature childFeature: group.getFeatures())
			groupChildrenIds.add(childFeature.getId());
		
		// Local constraints.
		int lower = group.getLower();
		int upper = group.getUpper();
		
		// Validate number of grouped selected features in each group.
		for(Selection parentSelection: parentSelections) {
			int groupSize = 0;
			
			for(Selection childSelection: parentSelection.getSelections()) {
				if(groupChildrenIds.contains(childSelection.getId()))
					groupSize++;
			}
			
			if(groupSize < lower)
				writer.addError(parentSelection, "At least " + lower + " of (" + printIds(groupChildrenIds) + ") must be selected.");
			if(groupSize > upper)
				writer.addError(parentSelection, "At most " + lower + " of (" + printIds(groupChildrenIds) + ") can be selected.");
		}
	}
	
	private String printIds(Set<String> ids) {
		if(ids.isEmpty())
			return null;
		
		StringBuilder builder = null;
		for(String id: ids) {
			if(builder == null)
				builder = new StringBuilder(id);
			else
				builder.append(", ").append(id);
		}
		return builder.toString();
	}

}
