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

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>By Reference Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.ByReferenceParameterValue#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getByReferenceParameterValue()
 * @model
 * @generated
 */
public interface ByReferenceParameterValue extends ParameterValue {
	/**
	 * Returns the value of the '<em><b>Referenced Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Value</em>' reference.
	 * @see #setReferencedValue(Identifiable)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getByReferenceParameterValue_ReferencedValue()
	 * @model
	 * @generated
	 */
	Identifiable getReferencedValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.ByReferenceParameterValue#getReferencedValue <em>Referenced Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Value</em>' reference.
	 * @see #getReferencedValue()
	 * @generated
	 */
	void setReferencedValue(Identifiable value);

} // ByReferenceParameterValue
