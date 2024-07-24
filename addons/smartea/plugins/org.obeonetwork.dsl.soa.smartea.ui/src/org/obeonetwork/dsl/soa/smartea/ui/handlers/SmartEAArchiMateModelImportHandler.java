package org.obeonetwork.dsl.soa.smartea.ui.handlers;

import static org.obeonetwork.dsl.soa.smartea.Activator.logError;

import java.util.List;
import java.util.function.Predicate;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.smartea.SmartEAMetaModelImporter;
import org.obeonetwork.utils.common.transaction.RecordingCommandWithResult;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

import fr.obeo.smartea.archimate.ArchimatePackage;

public class SmartEAArchiMateModelImportHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System soaSystem = EventHelper.uwrapSingleSelection(event, System.class);
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(null);
		
		ISObjectTreeItemWrapper archiMateRoot = new ISObjectTreeItemWrapper(treeRoot, ArchimatePackage.eINSTANCE);
		ArchimatePackage.eINSTANCE.getEClassifiers().stream()//
			.filter(EClass.class::isInstance).map(EClass.class::cast)//
			.filter(eClass -> !eClass.isAbstract() && !eClass.isInterface())
			.forEach(eClass -> insertTreeItemWrapper(archiMateRoot, eClass, 
					eInsertedClass -> eInsertedClass.getEPackage() == ArchimatePackage.eINSTANCE));
		
		String windowTitle = "ArchiMate types selection";
		String message = "Select the ArchiMate types to be imported as DTOs.";
		
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
		wizard.setLevelToExpand(3);
		
        IPageCompleteTester pageCompleteTester = 
        		(selectedTreeItemWrapers, partiallySelectedTreeItemWrapers) -> 
        			selectedTreeItemWrapers.stream()//
	        			.map(ISObjectTreeItemWrapper::getWrappedObject)//
	        			.filter(EClass.class::isInstance).map(EClass.class::cast)//
						.anyMatch(eClass -> !eClass.isAbstract() && !eClass.isInterface());
        wizard.setPageCompleteTester(pageCompleteTester);
		
        if(wizard.open() == Window.OK) {
        	List<EClass> selectedEClasses = wizard.getSelectedObjects().stream()//
        		.filter(EClass.class::isInstance).map(EClass.class::cast)//
        		.toList();
        	
        	
    		TransactionalEditingDomain ted = new EObjectQuery(soaSystem).getSession().getTransactionalEditingDomain();
    		
    		RecordingCommandWithResult<Integer> smartEAMetaModelImportCommand = new RecordingCommandWithResult<Integer>(ted) {

    			@Override
    			protected Integer doExecuteWithResult() {
    	        	SmartEAMetaModelImporter smartEAMetaModelImporter = new SmartEAMetaModelImporter(soaSystem);
    	        	return smartEAMetaModelImporter.importEClasses(selectedEClasses);
    			}
    			
    		};
    		
    		ted.getCommandStack().execute(smartEAMetaModelImportCommand);
    		
    		int status = smartEAMetaModelImportCommand.getSingleResult();
        	
    		if(smartEAMetaModelImportCommand.getException() != null) {
    			logError("Unexpected error", smartEAMetaModelImportCommand.getException());
    			status = IStatus.ERROR;
    		}
    		
    		Shell shell = HandlerUtil.getActiveShell(event);
    		switch (status) {
    		case IStatus.OK:
    			MessageDialog.openInformation(shell, "SmartEA Meta Model Import", "SmartEA Meta Model successfully imported.");
    			break;
    		case IStatus.WARNING:
    			MessageDialog.openWarning(shell, "SmartEA Meta Model Import", "SmartEA Meta Model imported with warnings. See error log for details.");
    			break;
    		case IStatus.ERROR:
    			MessageDialog.openError(shell, "SmartEA Meta Model Import", "SmartEA Meta Model import failed. See error log for details.");
    			break;
    		}
        }
        
		return null;
	}

	private List<ISObjectTreeItemWrapper> insertTreeItemWrapper(ISObjectTreeItemWrapper rootTiw, EClass eClass, Predicate<? super EClass> insertionPredicate) {
		List<ISObjectTreeItemWrapper> tiws;
		
		List<EClass> eSuperClasses = eClass.getESuperTypes().stream()//
			.filter(eSuperClass -> !eSuperClass.isInterface())//
			.filter(insertionPredicate)//
			.toList();
		
		if(eSuperClasses.isEmpty()) {
			tiws = List.of(getOrCreateTreeItemWrapperChild(rootTiw, eClass));
		} else {
			tiws = eSuperClasses.stream()//
				.flatMap(eSuperClass -> insertTreeItemWrapper(rootTiw, eSuperClass, insertionPredicate).stream())//
				.map(superTiw -> getOrCreateTreeItemWrapperChild(superTiw, eClass))//
				.toList();
		}
		
		return tiws;
	}

	private ISObjectTreeItemWrapper getOrCreateTreeItemWrapperChild(ISObjectTreeItemWrapper tiw, EClass wrappedObject) {
		ISObjectTreeItemWrapper child = tiw.getChildren().stream()//
				.filter(childTiw -> childTiw.getWrappedObject() == wrappedObject)//
				.findFirst().orElse(null);
		if(child == null) {
			child = new ISObjectTreeItemWrapper(tiw, wrappedObject);
			tiw.getChildren().sort((c1, c2) -> 
				((EClass)c1.getWrappedObject()).getName().compareTo(((EClass)c2.getWrappedObject()).getName()));
		}
		
		return child;
	}

}
