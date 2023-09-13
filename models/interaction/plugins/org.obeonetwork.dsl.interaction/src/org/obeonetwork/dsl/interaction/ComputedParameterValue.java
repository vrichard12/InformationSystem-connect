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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computed Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.ComputedParameterValue#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getComputedParameterValue()
 * @model
 * @generated
 */
public interface ComputedParameterValue extends ParameterValue {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getComputedParameterValue_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.ComputedParameterValue#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // ComputedParameterValue
