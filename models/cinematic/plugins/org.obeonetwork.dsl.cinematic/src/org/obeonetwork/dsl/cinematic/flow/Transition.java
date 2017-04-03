/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.Transition#isModal <em>Modal</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.Transition#getTo <em>To</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.Transition#getOn <em>On</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' attribute.
	 * @see #setGuard(String)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	String getGuard();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getGuard <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' attribute.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(String value);

	/**
	 * Returns the value of the '<em><b>Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modal</em>' attribute.
	 * @see #setModal(boolean)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition_Modal()
	 * @model
	 * @generated
	 */
	boolean isModal();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.Transition#isModal <em>Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modal</em>' attribute.
	 * @see #isModal()
	 * @generated
	 */
	void setModal(boolean value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(FlowState)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition_To()
	 * @model
	 * @generated
	 */
	FlowState getTo();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(FlowState value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(FlowState)
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition_From()
	 * @model
	 * @generated
	 */
	FlowState getFrom();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(FlowState value);

	/**
	 * Returns the value of the '<em><b>On</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#getTransition_On()
	 * @model
	 * @generated
	 */
	EList<Event> getOn();

} // Transition
