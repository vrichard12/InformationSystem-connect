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
package org.obeonetwork.dsl.interaction;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.object.Workspace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.CallMessage#getAction <em>Action</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.CallMessage#getRuntimeWorkspace <em>Runtime Workspace</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.CallMessage#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCallMessage()
 * @model
 * @generated
 */
public interface CallMessage extends Message {

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCallMessage_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.CallMessage#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Runtime Workspace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Workspace</em>' reference.
	 * @see #setRuntimeWorkspace(Workspace)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCallMessage_RuntimeWorkspace()
	 * @model
	 * @generated
	 */
	Workspace getRuntimeWorkspace();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.CallMessage#getRuntimeWorkspace <em>Runtime Workspace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Workspace</em>' reference.
	 * @see #getRuntimeWorkspace()
	 * @generated
	 */
	void setRuntimeWorkspace(Workspace value);

	/**
	 * Returns the value of the '<em><b>Parameter Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.ParameterValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Values</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCallMessage_ParameterValues()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ParameterValue> getParameterValues();
} // CallMessage
