package org.obeonetwork.dsl.soa.smartea.ui.handlers;

import static org.obeonetwork.dsl.soa.smartea.Activator.logError;

import java.util.List;
import java.util.function.Predicate;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.obeonetwork.dsl.soa.smartea.SmartEAReferenceModelImporter;
import org.obeonetwork.dsl.soa.smartea.ui.wizards.SmartEAReferenceModelImportWizardDialog;
import org.obeonetwork.utils.common.transaction.RecordingCommandWithResult;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

import fr.obeo.smartea.archimate.ArchimatePackage;
import fr.obeo.smartea.core.prism.DocumentRoot;
import fr.obeo.smartea.core.refmodel.DerivedRelationshipDescription;
import fr.obeo.smartea.core.refmodel.DerivedRelationshipFolder;
import fr.obeo.smartea.core.refmodel.DerivedRelationshipLibrary;
import fr.obeo.smartea.core.refmodel.Stereotype;
import fr.obeo.smartea.core.refmodel.StereotypeFolder;
import fr.obeo.smartea.core.refmodel.StereotypeLibrary;
import fr.obeo.smartea.core.refmodel.TypeExtension;
import fr.obeo.smartea.core.refmodel.TypeExtensionFolder;
import fr.obeo.smartea.core.refmodel.TypeExtensionLibrary;

public class SmartEAReferenceModelImportHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System soaSystem = EventHelper.uwrapSingleSelection(event, System.class);
		Shell shell = HandlerUtil.getActiveShell(event);
		
		// Prompt the user for an optional prism resource to import
		SmartEAReferenceModelImportWizardDialog smartEAReferenceModelImportWizardDialog = new SmartEAReferenceModelImportWizardDialog(shell, soaSystem);
		if(smartEAReferenceModelImportWizardDialog.open() == Window.CANCEL) {
			return null;
		}
		
		// The tree root of the ISObjectSelectionWizard to select Archimate EClasses and reference model elements
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(SmartEAReferenceModelImportHandler::getReferenceModelSelectionWizardChildren);
		
		// The ArchiMate model tree is entirely built here, presenting the archimate package as root and the
		// hierarchy of sub types as children. A type can therefore appears under two different nodes in case
		// of multiple inheritance.
		ISObjectTreeItemWrapper archiMateRoot = new ISObjectTreeItemWrapper(treeRoot, ArchimatePackage.eINSTANCE);
		ArchimatePackage.eINSTANCE.getEClassifiers().stream()//
			.filter(EClass.class::isInstance).map(EClass.class::cast)//
			.filter(eClass -> !eClass.isAbstract() && !eClass.isInterface())
			.forEach(eClass -> insertEClassTreeItemWrapper(archiMateRoot, eClass, 
					eInsertedClass -> eInsertedClass.getEPackage() == ArchimatePackage.eINSTANCE));
		
		// Add the reference model root node if needed 
		if(!smartEAReferenceModelImportWizardDialog.isIgnored()) {
			URI prismFileURI = URI.createFileURI(smartEAReferenceModelImportWizardDialog.getPrismFilePath());
			ResourceSet prismResourceSet = new ResourceSetImpl();
			Resource prismResource = prismResourceSet.getResource(prismFileURI, true);
			DocumentRoot prismDocumentRoot = prismResource.getContents().stream()//
					.filter(DocumentRoot.class::isInstance).map(DocumentRoot.class::cast)//
					.findFirst().orElse(null);
			
			// Create the reference model root. No need to build the tree here, it is managed by the
			// getReferenceModelSelectionWizardChildren method set as the childrenFunction on the
			// treeRoot.
			new ISObjectTreeItemWrapper(treeRoot, prismDocumentRoot.getReferenceModel());
		}
		
		String windowTitle = "ArchiMate and Reference Model types selection";
		String message = "Select the types to be imported as DTOs.";
		
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
		wizard.setLevelToExpand(2);
		
        IPageCompleteTester pageCompleteTester = 
        		(selectedTreeItemWrapers, partiallySelectedTreeItemWrapers) -> 
        			// Any non abstract and non interface EClass is selected
        			selectedTreeItemWrapers.stream()//
	        			.map(ISObjectTreeItemWrapper::getWrappedObject)//
	        			.filter(EClass.class::isInstance).map(EClass.class::cast)//
						.anyMatch(eClass -> !eClass.isAbstract() && !eClass.isInterface()) ||
	        		// Or any Stereotype, TypeExtension or DerivedRelationshipDescription is selected
					selectedTreeItemWrapers.stream()//
	        			.map(ISObjectTreeItemWrapper::getWrappedObject)//
	        			.anyMatch(wrappedObject ->
	        					wrappedObject instanceof Stereotype ||
	        					wrappedObject instanceof TypeExtension ||
	        					wrappedObject instanceof DerivedRelationshipDescription);
        wizard.setPageCompleteTester(pageCompleteTester);
		
        wizard.setCustomLabelProvider(wrappedObject -> {
        	if(wrappedObject instanceof StereotypeFolder stereotypeFolder) {
        		return stereotypeFolder.getName();
        	}
        	if(wrappedObject instanceof TypeExtensionFolder typeExtensionFolder) {
        		return typeExtensionFolder.getName();
        	}
        	if(wrappedObject instanceof DerivedRelationshipFolder derivedRelationshipFolder) {
        		return derivedRelationshipFolder.getName();
        	}
        	if(wrappedObject instanceof TypeExtension typeExtension) {
        		return typeExtension.getLabel();
        	}
        	if(wrappedObject instanceof DerivedRelationshipDescription derivedRelationshipDescription) {
        		return derivedRelationshipDescription.getName();
        	}
        	return null;
        });
        
        if(wizard.open() == Window.OK) {
        	List<EClass> selectedEClasses = wizard.getSelectedObjects().stream()//
            	.filter(EClass.class::isInstance).map(EClass.class::cast)//
            	.filter(eClass -> !eClass.isAbstract() && !eClass.isInterface())//
            	.toList();
        	
        	List<Stereotype> selectedStereotypes = wizard.getSelectedObjects().stream()//
        		.filter(Stereotype.class::isInstance).map(Stereotype.class::cast)//
        		.toList();
            	
        	TransactionalEditingDomain ted = new EObjectQuery(soaSystem).getSession().getTransactionalEditingDomain();
        		
    		RecordingCommandWithResult<Integer> smartEAReferenceModelImportCommand = new RecordingCommandWithResult<Integer>(ted) {

    			@Override
    			protected Integer doExecuteWithResult() {
    	        	SmartEAMetaModelImporter smartEAMetaModelImporter = new SmartEAMetaModelImporter(soaSystem);
    	        	int metaModelImportStatus = smartEAMetaModelImporter.importEClasses(selectedEClasses);
    	        	
    	        	SmartEAReferenceModelImporter smartEAReferenceModelImporter = new SmartEAReferenceModelImporter(soaSystem);
    	        	int stereotypesImportStatus = smartEAReferenceModelImporter.importStereotypes(selectedStereotypes);
    	        	
    	        	int status = Math.max(metaModelImportStatus, stereotypesImportStatus);
    	        	return status;
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
    			MessageDialog.openInformation(shell, "SmartEA Reference Model Import", "SmartEA Reference Model successfully imported.");
    			break;
    		case IStatus.WARNING:
    			MessageDialog.openWarning(shell, "SmartEA Reference Model Import", "SmartEA Reference Model imported with warnings. See error log for details.");
    			break;
    		case IStatus.ERROR:
    			MessageDialog.openError(shell, "SmartEA Reference Model Import", "SmartEA Reference Model import failed. See error log for details.");
    			break;
    		}
        }
		
		return null;
	}

	private List<ISObjectTreeItemWrapper> insertEClassTreeItemWrapper(ISObjectTreeItemWrapper rootTiw, EClass eClass, Predicate<? super EClass> insertionPredicate) {
		List<ISObjectTreeItemWrapper> tiws;
		
		List<EClass> eSuperClasses = eClass.getESuperTypes().stream()//
			.filter(eSuperClass -> !eSuperClass.isInterface())//
			.filter(insertionPredicate)//
			.toList();
		
		if(eSuperClasses.isEmpty()) {
			tiws = List.of(getOrCreateEClassTreeItemWrapperChild(rootTiw, eClass));
		} else {
			tiws = eSuperClasses.stream()//
				.flatMap(eSuperClass -> insertEClassTreeItemWrapper(rootTiw, eSuperClass, insertionPredicate).stream())//
				.map(superTiw -> getOrCreateEClassTreeItemWrapperChild(superTiw, eClass))//
				.toList();
		}
		
		return tiws;
	}

	private ISObjectTreeItemWrapper getOrCreateEClassTreeItemWrapperChild(ISObjectTreeItemWrapper tiw, EClass wrappedObject) {
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

	private static List<EObject> getReferenceModelSelectionWizardChildren(Object parent) {
		List<EObject> children = null;
		if(parent instanceof EObject parentEObject) {
			children = parentEObject.eContents().stream()//
				.filter(eObject -> eObject instanceof StereotypeLibrary ||
						eObject instanceof StereotypeLibrary ||
						eObject instanceof StereotypeFolder ||
						eObject instanceof Stereotype ||
						eObject instanceof TypeExtensionLibrary ||
						eObject instanceof TypeExtensionFolder ||
						eObject instanceof TypeExtension ||
						eObject instanceof DerivedRelationshipLibrary ||
						eObject instanceof DerivedRelationshipFolder ||
						eObject instanceof DerivedRelationshipDescription)
				.toList();
		}
		return children;
	}
}
