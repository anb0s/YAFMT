/*******************************************************************************
 * Copyright (c) 2015-2017 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class GenerateUniqueFeatureIdCommand extends RecordingCommand {

    private Feature feature;

    public GenerateUniqueFeatureIdCommand(Feature feature) {
        setLabel("Generate Unique ID");
        this.feature = feature;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(feature);
    }

    @Override
    protected void performRecording() {
        String id = FeatureModelUtil.generateFeatureId();
        feature.setId(id);
    }

}
