package cz.jpikl.yafmt.clang.ui;

import cz.jpikl.yafmt.model.fm.FeatureModel;

public class EditingContext {

    FeatureModel featureModel;

    public EditingContext(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    public FeatureModel getFeatureModel() {
        return featureModel;
    }

}
