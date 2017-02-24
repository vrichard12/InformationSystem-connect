/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import fr.gouv.mindef.safran.graalextensions.adapterfactory.CustomAdapterFactory;
import fr.gouv.mindef.safran.graalextensions.adapterfactory.CustomAdapterFactory.PropertiesTab;

public class CustomVersionPropertiesEditionPartForm extends	VersionPropertiesEditionPartForm {

	public CustomVersionPropertiesEditionPartForm() {
		super();
		adapterFactory = new CustomAdapterFactory(PropertiesTab.VERSION);
	}
	
	@Override
	protected EObject resolveSemanticObject(Object object) {
		if (object instanceof DSemanticDecorator) {
			return((DSemanticDecorator) object).getTarget();
		}
		return super.resolveSemanticObject(object);
	}
}
