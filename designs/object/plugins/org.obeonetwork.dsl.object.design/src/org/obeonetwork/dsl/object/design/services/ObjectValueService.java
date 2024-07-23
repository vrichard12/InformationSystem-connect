package org.obeonetwork.dsl.object.design.services;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.jface.window.Window;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.ISObjectCheckBoxFilter;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;

public class ObjectValueService {
	
	private static List<?> getSelectValueDialogChildren(Object element) {
		List<?> children;
		if(element instanceof Workspace) {
			children = ((Workspace) element).getValues();
		} else if(element instanceof ObjectValue) {
			children = ((ObjectValue) element).getProperties().stream()
					.filter(ObjectContainmentProperty.class::isInstance).map(ObjectContainmentProperty.class::cast)
					.collect(toList());
		} else if(element instanceof ObjectContainmentProperty) {
			children = ((ObjectContainmentProperty) element).getContainedValues();
		} else {
			children = Collections.emptyList();
		}
		return children;
	}
	
	public static Value openSelectValueDialog(ObjectValue context) {
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(ObjectValueService::getSelectValueDialogChildren);
		treeRoot.getConfiguration().setSelectableCondition(Value.class::isInstance);
		
		context.eResource().getContents().stream()
		.filter(Workspace.class::isInstance).map(Workspace.class::cast)
		.forEach(workspace -> new ISObjectTreeItemWrapper(treeRoot, workspace));
		
        String windowTitle = "Value selection";
		String message = "Select a Value";
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		false);
		
        wizard.setLevelToExpand(4);

        wizard.setPageCompleteTester(
        		(selectedTreeItemWrapers, partiallySelectedTreeItemWrapers) -> 
        			selectedTreeItemWrapers.size() == 1);
        
        wizard.setCheckBoxFilter(new ISObjectCheckBoxFilter("Hide Object Values", true) {
			@Override
			public boolean filter(ISObjectTreeItemWrapper treeItemWrapper) {
				return treeItemWrapper.getWrappedObject() instanceof ObjectValue;
			}
		});
        
        Value selectedValue = null;
        if(wizard.open() == Window.OK) {
        	selectedValue = (Value) wizard.getSelectedObject();
        }
		
		return selectedValue;
	}

	private static List<?> getSelectPropertyDialogChildren(Object element, Set<Property> alreadyUsedProperties) {
		
		if(element instanceof StructuredType) {
			List<Object> children = new ArrayList<Object>();
			
			StructuredType structuredType = (StructuredType) element;
			
			children.addAll(structuredType.getAttributes());
			structuredType.getAssociatedTypes().stream()
			.flatMap(t -> t.getOwnedAttributes().stream())
			.forEach(a -> children.add(a));
			
			children.addAll(structuredType.getReferences());
			structuredType.getAssociatedTypes().stream()
			.flatMap(t -> t.getOwnedReferences().stream())
			.forEach(r -> children.add(r));
			
			return children.stream()
					.filter(p -> !alreadyUsedProperties.contains(p))
					.collect(toList());
		}
		
		return Collections.emptyList();
	}

	public static Property openSelectPropertyDialog(ObjectValue objectValue) {
		
		StructuredType definingType = (StructuredType) objectValue.getMetaType();
		Set<Property> alreadyUsedProperties = objectValue.getProperties().stream()
		.map(pv -> pv.getMetaProperty()).filter(p -> p != null)
		.collect(toSet());
		
		List<StructuredType> superTypes = new ArrayList<>();
		Queue<StructuredType> crawlingQueue = new LinkedList<>();
		superTypes.add(definingType);
		crawlingQueue.add(definingType);
		collectSuperTypesOrdered(superTypes, crawlingQueue);
		Collections.reverse(superTypes);
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				wrappedObject -> getSelectPropertyDialogChildren(wrappedObject, alreadyUsedProperties));
		treeRoot.getConfiguration().setSelectableCondition(Property.class::isInstance);
		
		superTypes.forEach(t -> new ISObjectTreeItemWrapper(treeRoot, t));
		
        String windowTitle = "Property selection";
		String message = "Select a Property";
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		false);
		
        wizard.setLevelToExpand(2);

        IPageCompleteTester pageCompleteTester = 
        		(selectedTreeItemWrapers, partiallySelectedTreeItemWrapers) -> 
        			selectedTreeItemWrapers.size() == 1;
        wizard.setPageCompleteTester(pageCompleteTester);
        
		Property selectedProperty = null;
        if(wizard.open() == Window.OK) {
        	selectedProperty = (Property) wizard.getSelectedObject();
        }
		
		return selectedProperty;
	}
	
	/**
	 * Collect the supertypes of the crawlingQueue StructuredTypes.
	 * The collected supertypes are stored (added) into the given empty
	 * superTypes list ordered from the most concrete to the most abstract
	 * ones.
	 * 
	 * @param superTypes
	 * @param crawlingQueue
	 */
	private static void collectSuperTypesOrdered(List<StructuredType> superTypes, Queue<StructuredType> crawlingQueue) {
		while(!crawlingQueue.isEmpty()) {
			StructuredType type = crawlingQueue.remove();
			type.getSupertypes().stream()
				.filter(supertype -> !superTypes.contains(supertype))
				.forEach(supertype -> {
					crawlingQueue.add(supertype);
					superTypes.add(supertype);
				});
		}
	}
	
}
