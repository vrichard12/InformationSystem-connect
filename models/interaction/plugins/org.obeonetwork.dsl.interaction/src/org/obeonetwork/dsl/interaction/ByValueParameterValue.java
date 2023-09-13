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
package org.obeonetwork.dsl.interaction;

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>By Value Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.ByValueParameterValue#getContainedValue <em>Contained Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getByValueParameterValue()
 * @model
 * @generated
 */
public interface ByValueParameterValue extends ParameterValue {
	/**
	 * Returns the value of the '<em><b>Contained Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Value</em>' containment reference.
	 * @see #setContainedValue(Identifiable)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getByValueParameterValue_ContainedValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Identifiable getContainedValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.ByValueParameterValue#getContainedValue <em>Contained Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Value</em>' containment reference.
	 * @see #getContainedValue()
	 * @generated
	 */
	void setContainedValue(Identifiable value);

} // ByValueParameterValue
