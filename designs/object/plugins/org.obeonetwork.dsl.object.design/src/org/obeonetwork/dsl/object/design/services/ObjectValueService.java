package org.obeonetwork.dsl.object.design.services;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.window.Window;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.ISObjectCheckBoxFilter;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PropertyContainedValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;

public class ObjectValueService {
	
	private static List<?> getSelectValueDialogChildren(Object element) {
		List<?> children;
		if(element instanceof Workspace) {
			children = ((Workspace) element).getValues();
		} else if(element instanceof ObjectValue) {
			children = ((ObjectValue) element).getPropertyValues().stream()
					.filter(PropertyContainedValue.class::isInstance).map(PropertyContainedValue.class::cast)
					.collect(toList());
		} else if(element instanceof PropertyContainedValue) {
			children = ((PropertyContainedValue) element).getContainedValues();
		} else {
			children = Collections.emptyList();
		}
		return children;
	}
	
	public static Value openSelectValueDialog(ObjectValue context) {
		
		ISObjectTreeItemWrapper treeInput = new ISObjectTreeItemWrapper(
				ObjectValueService::getSelectValueDialogChildren,
				Value.class::isInstance);
		
		context.eResource().getContents().stream()
		.filter(Workspace.class::isInstance).map(Workspace.class::cast)
		.forEach(w -> new ISObjectTreeItemWrapper(treeInput, w));
		
        String windowTitle = "Value selection";
		String message = "Select a Value";
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeInput,
        		false);
		
        wizard.setLevelToExpand(4);

        IPageCompleteTester pageCompleteTester = 
        		(selectedTreeItemWrapers, partiallySelectedTreeItemWrapers) -> 
        			selectedTreeItemWrapers.size() == 1;
        wizard.setPageCompleteTester(pageCompleteTester);
        
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
		Set<Property> alreadyUsedProperties = objectValue.getPropertyValues().stream()
		.map(pv -> pv.getMetaProperty()).filter(p -> p != null)
		.collect(toSet());
		
		List<StructuredType> superTypes = new LinkedList<>();
		StructuredType superType = definingType;
		while(superType != null) {
			superTypes.add(0, superType);
			superType = superType.getSupertype();
		}
		
		ISObjectTreeItemWrapper treeInput = new ISObjectTreeItemWrapper(
				wrappedObject -> getSelectPropertyDialogChildren(wrappedObject, alreadyUsedProperties),
				Property.class::isInstance);
		
		superTypes.forEach(t -> new ISObjectTreeItemWrapper(treeInput, t));
		
        String windowTitle = "Property selection";
		String message = "Select a Property";
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeInput,
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
	
}
