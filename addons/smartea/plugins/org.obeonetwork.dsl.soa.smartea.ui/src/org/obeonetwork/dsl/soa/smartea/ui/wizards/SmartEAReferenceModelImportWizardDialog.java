package org.obeonetwork.dsl.soa.smartea.ui.wizards;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.soa.System;

public class SmartEAReferenceModelImportWizardDialog extends WizardDialog {
	
	public static final int IGNORE_ID = 132;
	private boolean ignored = false;

	public SmartEAReferenceModelImportWizardDialog(Shell parentShell, System soaSystem) {
		super(parentShell, new SmartEAReferenceModelImportWizard(soaSystem));
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button ignoreButton = createButton(parent, IGNORE_ID, "Ignore", false);
		ignoreButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ignored = true;
				close();
			}
		});
		super.createButtonsForButtonBar(parent);
	}

	public boolean isIgnored() {
		return ignored ;
	}

	public String getPrismFilePath() {
		return ((SmartEAReferenceModelImportWizard)getWizard()).getPrismFilePath();
	}

}
