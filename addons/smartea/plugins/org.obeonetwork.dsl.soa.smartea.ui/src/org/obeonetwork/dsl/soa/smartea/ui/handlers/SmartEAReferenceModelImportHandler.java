package org.obeonetwork.dsl.soa.smartea.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.smartea.ui.wizards.SmartEAReferenceModelImportWizard;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class SmartEAReferenceModelImportHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System soaSystem = EventHelper.uwrapSingleSelection(event, System.class);
		Shell shell = HandlerUtil.getActiveShell(event);
		WizardDialog dialog = new WizardDialog(shell, new SmartEAReferenceModelImportWizard(soaSystem));
		dialog.open();
		
		return null;
	}

}
