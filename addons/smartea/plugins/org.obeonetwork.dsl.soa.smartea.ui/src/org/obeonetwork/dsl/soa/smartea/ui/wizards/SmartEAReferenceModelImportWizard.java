package org.obeonetwork.dsl.soa.smartea.ui.wizards;

import static org.obeonetwork.dsl.soa.smartea.Activator.logError;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.smartea.SmartEAReferenceModelImporter;
import org.obeonetwork.utils.common.transaction.RecordingCommandWithResult;

public class SmartEAReferenceModelImportWizard extends Wizard {

	private System soaSystem;
	private SmartEAReferenceModelImportWizardPage smartEAReferenceModelImportWizardPage;
	
	public SmartEAReferenceModelImportWizard(System soaSystem) {
		super();
		this.soaSystem = soaSystem;
		
		setWindowTitle("SmartEA Reference Model Import");
		
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
		boolean exitStatus = true;
		
		String prismFilePath = smartEAReferenceModelImportWizardPage.getPrismFilePath();
		
		TransactionalEditingDomain ted = new EObjectQuery(soaSystem).getSession().getTransactionalEditingDomain();
		
		RecordingCommandWithResult<Integer> smartEAReferenceModelImportCommand = new RecordingCommandWithResult<Integer>(ted) {

			@Override
			protected Integer doExecuteWithResult() {
				SmartEAReferenceModelImporter smartEAReferenceModelImporter = new SmartEAReferenceModelImporter(soaSystem);
				return smartEAReferenceModelImporter.importFromFile(prismFilePath);
			}
			
		};
		
		ted.getCommandStack().execute(smartEAReferenceModelImportCommand);
		
		int status = smartEAReferenceModelImportCommand.getSingleResult();
		
		if(smartEAReferenceModelImportCommand.getException() != null) {
			logError("Unexpected error", smartEAReferenceModelImportCommand.getException());
			status = IStatus.ERROR;
		}
		
		switch (status) {
		case IStatus.OK:
			MessageDialog.openInformation(getShell(), "SmartEA Reference Model Import", "SmartEA Reference Model successfully imported.");
			break;
		case IStatus.WARNING:
			MessageDialog.openWarning(getShell(), "SmartEA Reference Model Import", "SmartEA Reference Model imported with warnings. See error log for details.");
			break;
		case IStatus.ERROR:
			MessageDialog.openError(getShell(), "SmartEA Reference Model Import", "SmartEA Reference Model import failed. See error log for details.");
			break;
		}

		return exitStatus;
	}

	
}
