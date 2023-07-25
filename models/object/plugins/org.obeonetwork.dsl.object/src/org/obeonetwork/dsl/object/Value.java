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

import org.obeonetwork.dsl.environment.Type;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.Value#getMetaType <em>Meta Type</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getValue()
 * @model abstract="true"
 * @generated
 */
public interface Value extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Type</em>' reference.
	 * @see #setMetaType(Type)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getValue_MetaType()
	 * @model
	 * @generated
	 */
	Type getMetaType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.Value#getMetaType <em>Meta Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Type</em>' reference.
	 * @see #getMetaType()
	 * @generated
	 */
	void setMetaType(Type value);

} // Value
