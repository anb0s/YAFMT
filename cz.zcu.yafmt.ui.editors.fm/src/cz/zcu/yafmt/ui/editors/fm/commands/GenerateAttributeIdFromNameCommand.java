/*******************************************************************************
 * Copyright (c) 2012-2013 Jan Pikl and contributors.
 * Copyright (c) 2015-2018 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.Random;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;


public class GenerateAttributeIdFromNameCommand extends RecordingCommand {

    private Attribute attribute;

    public GenerateAttributeIdFromNameCommand(Attribute attribute) {
        setLabel("Generate ID from Name");
        this.attribute = attribute;
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attribute);
    }

    @Override
    protected void performRecording() {
        String id = FeatureModelUtil.generateIdFromName(attribute.getName());
        Feature feature = attribute.getFeature();

        if(feature != null) {
            for(Attribute other: feature.getAttributes()) {
                if((other != attribute) && other.getId().equals(id))
                    id = id + "_" + (new Random()).nextInt(Short.MAX_VALUE);
            }
        }

        attribute.setId(id);
    }
}
