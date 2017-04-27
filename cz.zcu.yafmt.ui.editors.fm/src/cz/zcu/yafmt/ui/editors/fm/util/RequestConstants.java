/*******************************************************************************
 * Copyright (c) 2012-2013 Jan Pikl and contributors.
 * Copyright (c) 2015-2017 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fm.util;

public interface RequestConstants {

    String REQ_ADD_ATTRIBUTE = "cz.zcu.yafmt.ui.editors.fm.requests.AddAttribute";
    String REQ_DELETE_ATTRIBUTE = "cz.zcu.yafmt.ui.editors.fm.requests.DeleteAttribute";
    String REQ_GROUP_FEATURES_XOR = "cz.zcu.yafmt.ui.editors.fm.requests.GroupFeatures.XOR";
    String REQ_GROUP_FEATURES_OR = "cz.zcu.yafmt.ui.editors.fm.requests.GroupFeatures.OR";
    String REQ_UNGROUP_FEATURES = "cz.zcu.yafmt.ui.editors.fm.requests.UngroupFeatures";
    String REQ_MAKE_GROUP_XOR = "cz.zcu.yafmt.ui.editors.fm.requests.MakeGroup.XOR";
    String REQ_MAKE_GROUP_OR = "cz.zcu.yafmt.ui.editors.fm.requests.MakeGroup.OR";
    String REQ_MAKE_FEATURE_MAN = "cz.zcu.yafmt.ui.editors.fm.requests.MakeFeaturesMandatory";
    String REQ_MAKE_FEATURE_OPT = "cz.zcu.yafmt.ui.editors.fm.requests.MakeFeaturesOptional";
    String REQ_APPLY_VER_TREE_LAYOUT = "cz.zcu.yafmt.ui.editors.fm.requests.ApplyVerticalTreeLayout";
    String REQ_APPLY_HOR_TREE_LAYOUT = "cz.zcu.yafmt.ui.editors.fm.requests.ApplyHorizontalTreeLayout";
    String REQ_SET_FEATURE_OPTIMAL_SIZE = "cz.zcu.yafmt.ui.editors.fm.requests.SetFeatureOptimalSize";
    String REQ_GENERATE_ID_FROM_NAME = "cz.zcu.yafmt.ui.editors.fm.requests.GenerateIdFromName";
    String REQ_GENERATE_UNIQUE_ID = "cz.zcu.yafmt.ui.editors.fm.requests.GenerateUniqueId";

}
