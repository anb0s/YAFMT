/*******************************************************************************
 * Copyright (c) 2015-2017 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fm.commands;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class GenerateUniqueAttributeId extends RecordingCommand {

    private Attribute attribute;

    public GenerateUniqueAttributeId(Attribute attribute) {
        setLabel("Generate Unique ID");
        this.attribute = attribute;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        String id = FeatureModelUtil.generateAttributeId();
        attribute.setId(id);
    }
}
