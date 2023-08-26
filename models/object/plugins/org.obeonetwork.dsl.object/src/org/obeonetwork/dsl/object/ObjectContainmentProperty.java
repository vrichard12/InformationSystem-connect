/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectContainmentProperty#getContainedValues <em>Contained Values</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectContainmentProperty()
 * @model
 * @generated
 */
public interface ObjectContainmentProperty extends ObjectProperty {
	/**
	 * Returns the value of the '<em><b>Contained Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.object.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Values</em>' containment reference list.
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectContainmentProperty_ContainedValues()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Value> getContainedValues();

} // ObjectContainmentProperty
