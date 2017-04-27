/*******************************************************************************
 * Copyright (c) 2015-2017 Andre Bossert and contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package cz.zcu.yafmt.ui.editors.fm.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.actions.RetargetAction;

import cz.zcu.yafmt.ui.editors.fm.FeatureModelEditorPlugin;
import cz.zcu.yafmt.ui.editors.fm.util.RequestConstants;


public class GenerateUniqueIdAction extends SelectionAction {

    public static final String ID = "cz.zcu.yafmt.ui.editors.fm.actions.GenerateUniqueIdAction";

    public static RetargetAction createRetargetAction() {
        return (RetargetAction) initAction(new LabelRetargetAction(null, null));
    }

    private static IAction initAction(IAction action) {
        action.setId(ID);
        action.setText("Generate Unique ID");
        action.setImageDescriptor(FeatureModelEditorPlugin.getAccess().getImageDescriptor("generate-id.png"));
        return action;
    }

    public GenerateUniqueIdAction(IWorkbenchPart part) {
        super(part);
        initAction(this);
    }

    private Command getCommand() {
        List<?> objects = getSelectedObjects();
        if(objects.isEmpty() || !(objects.get(0) instanceof EditPart))
            return null;

        Request request = new Request(RequestConstants.REQ_GENERATE_UNIQUE_ID);

        CompoundCommand command = new CompoundCommand();
        for(Object object: objects)
            command.add(((EditPart) object).getCommand(request));
        return command;
    }

    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }

    @Override
    public void run() {
        execute(getCommand());
    }



}
