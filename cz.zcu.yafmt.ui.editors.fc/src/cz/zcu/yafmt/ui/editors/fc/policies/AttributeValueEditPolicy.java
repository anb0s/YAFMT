/*******************************************************************************
 * Copyright (c) 2012-2013 Jan Pikl and contributors.
 * Copyright (c) 2015-2018 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fc.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.ui.editors.fc.commands.SetToDefaultValueCommand;

public class AttributeValueEditPolicy extends ComponentEditPolicy {

    @Override
    public Command getCommand(Request request) {
        Object type = request.getType();
        if("cz.zcu.yafmt.ui.editors.fc.requests.SetToDefaultValue".equals(type)) {
            AttributeValue attributeValue = (AttributeValue) getHost().getModel();
            String value = attributeValue.getAttribute().getDefaultValue();
            return new SetToDefaultValueCommand(attributeValue, value);
        }
        return super.getCommand(request);
    }

}
