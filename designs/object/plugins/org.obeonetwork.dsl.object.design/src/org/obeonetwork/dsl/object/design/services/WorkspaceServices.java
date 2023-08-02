package org.obeonetwork.dsl.object.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.window.Window;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.StreamUtils;

public class WorkspaceServices {
	
	public static Type openSelectMetaTypeDialog(Workspace context, EClass metaMetaType) {
		
		ISObjectTreeItemWrapper treeInput = new ISObjectTreeItemWrapper(
				null,
				(wrappedEObject) -> metaMetaType.isInstance(wrappedEObject));
		
		ResourceSet resourceSet = context.eResource().getResourceSet();
		resourceSet.getResources().stream()
		.flatMap(r -> StreamUtils.asStream(r.getAllContents()))
		.filter(e -> metaMetaType.isInstance(e))
		.forEach(metaType -> insertTreeItemWrapper(treeInput, metaType));
		
        String windowTitle = metaMetaType.getName() + " selection";
		String message = "Select a " + metaMetaType.getName();
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeInput,
        		false);
		
        wizard.setLevelToExpand(4);

        IPageCompleteTester pageCompleteTester = new IPageCompleteTester() {
			@Override
			public boolean isPageComplete(
					Collection<ISObjectTreeItemWrapper> selectedTreeItemWrapers,
					Collection<ISObjectTreeItemWrapper> partiallySelectedTreeItemWrapers) {
				return selectedTreeItemWrapers.size() == 1;
			}
        };
        wizard.setPageCompleteTester(pageCompleteTester);
        
        Type type = null;
        if(wizard.open() == Window.OK) {
        	type = (Type) wizard.getSelectedObject();
        }
        
		return type;
	}

	private static ISObjectTreeItemWrapper insertTreeItemWrapper(ISObjectTreeItemWrapper rootTiw, EObject element) {
		List<Object> ancestors = new ArrayList<>();
		ancestors.add(element.eResource());
		ancestors.addAll(EObjectUtils.getAncestors(element));
		ancestors.add(element);
		
		ISObjectTreeItemWrapper tiw = rootTiw;
		for(Object ancestor : ancestors) {
			tiw = tiw.getChildren().stream()
					.filter(childTiw -> childTiw.getWrappedObject() == ancestor)
					.findFirst().orElse(new ISObjectTreeItemWrapper(tiw, ancestor));
		}
		return tiw;
	}

}
