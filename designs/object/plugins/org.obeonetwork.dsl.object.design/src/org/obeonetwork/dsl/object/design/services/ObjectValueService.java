package org.obeonetwork.dsl.object.design.services;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.window.Window;
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

}
