package org.obeonetwork.dsl.soa.smartea.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.soa.System;

public class SmartEAReferenceModelImportWizard extends Wizard {

	private SmartEAReferenceModelImportWizardPage smartEAReferenceModelImportWizardPage;
	private System soaSystem;
	
	public SmartEAReferenceModelImportWizard(System soaSystem) {
		super();
		
		setWindowTitle("SmartEA Reference Model Import");
		
		this.soaSystem = soaSystem;
		
		smartEAReferenceModelImportWizardPage = new SmartEAReferenceModelImportWizardPage(this);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(smartEAReferenceModelImportWizardPage);
	}
	
	@Override
	public boolean canFinish() {
		return smartEAReferenceModelImportWizardPage.isComplete();
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	public System getSoaSystem() {
		return soaSystem;
	}

	public String getPrismFilePath() {
		return smartEAReferenceModelImportWizardPage.getPrismFilePath();
	}
	
}
