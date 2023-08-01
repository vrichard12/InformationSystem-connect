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
package org.obeonetwork.dsl.object.design;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.obeonetwork.dsl.environment.design.IEnvironmentViewpointConstants;

public interface IObjectViewpointConstants {
	
	public static URI OBJECT_VIEWPOINT_URI = URI.createURI("viewpoint:/org.obeonetwork.dsl.object.design/Object Views");
	
	
	public static Collection<URI> VIEWPOINT_DEPENDENCIES = Arrays.asList(
			OBJECT_VIEWPOINT_URI,
			IEnvironmentViewpointConstants.ENVIRONMENT_VIEWPOINT_URI
	);

	public static String OBJECT_WORKSPACE_DIAGRAM_ID = "Object Workspace Diagram";
	
}
