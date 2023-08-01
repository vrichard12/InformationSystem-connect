/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.object.design.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.is.ui.wizards.AbstractISNewModelWizard;
import org.obeonetwork.dsl.is.ui.wizards.NewModelCreationPage;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.object.design.Activator;
import static org.obeonetwork.dsl.object.design.IObjectViewpointConstants.*;

public class NewObjectModelWizard extends AbstractISNewModelWizard {
	
	private static final String OBJECT_RESOURCE_FILE_EXTENSION = ".object";

	public NewObjectModelWizard() {
		super("New Object Model", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/wizban/NewObject.gif"));
	}

	@Override
	protected Collection<EObject> createInitialObjects() {
		Workspace workspace = ObjectFactory.eINSTANCE.createWorkspace();
		workspace.setCreatedOn(new Date());
		workspace.setName(this.getProjectName() + " Workspace");
		return Arrays.asList(workspace);
	}
	
	@Override
	public void addPages() {
		modelCreationPage = new NewModelCreationPage("ModelCreationPage", selection, OBJECT_RESOURCE_FILE_EXTENSION);
		modelCreationPage.setTitle("Create a new object model");
		modelCreationPage.setDescription("Choose the new object model name and path.");
		addPage(modelCreationPage);
	}

	@Override
	protected String getWizardTitle() {
		return "New Object model";
	}
	
	@Override
	protected Collection<URI> getViewpointsURIToBeActivated() {
		return VIEWPOINT_DEPENDENCIES;
	}
	
	@Override
	protected Map<EClassifier, Collection<String>> getRepresentationDescriptionsIDToBeCreated() {
		Map<EClassifier, Collection<String>> descs = new HashMap<>();
		descs.put(ObjectPackage.Literals.WORKSPACE, Arrays.asList(OBJECT_WORKSPACE_DIAGRAM_ID));
		return descs;
	}
	
	@Override
	protected String getRepresentationName(RepresentationDescription representationDescription, EObject object) {
		if (object instanceof Workspace) {
			String repDescName = representationDescription.getName();
			if (OBJECT_WORKSPACE_DIAGRAM_ID.equals(repDescName)) {
				return String.format("%1$s - %2$s", this.getProjectName(), OBJECT_WORKSPACE_DIAGRAM_ID);
			}
		}
		return null;
	}

	@Override
	protected boolean shouldOpenRepresentation(DRepresentation representation) {
		if (representation instanceof DDiagram) {
			String repDescName = ((DDiagram) representation).getDescription().getName();
			return OBJECT_WORKSPACE_DIAGRAM_ID.equals(repDescName);
		}
		
		return false;
	}
	
}
