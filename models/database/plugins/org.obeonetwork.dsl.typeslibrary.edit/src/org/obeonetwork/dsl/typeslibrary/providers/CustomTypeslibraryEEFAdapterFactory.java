/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.typeslibrary.providers;

import org.eclipse.emf.common.notify.Adapter;

public class CustomTypeslibraryEEFAdapterFactory extends TypeslibraryEEFAdapterFactory {

	@Override
	public Adapter createTypeInstanceAdapter() {
		return new CustomTypeInstancePropertiesEditionProvider();
	}
}
