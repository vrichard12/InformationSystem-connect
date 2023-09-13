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
package org.obeonetwork.dsl.interaction.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.ParameterValue;
import org.obeonetwork.dsl.object.Workspace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CallMessageImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CallMessageImpl#getRuntimeWorkspace <em>Runtime Workspace</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CallMessageImpl#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallMessageImpl extends MessageImpl implements CallMessage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.CALL_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		return (Action)eDynamicGet(InteractionPackage.CALL_MESSAGE__ACTION, InteractionPackage.Literals.CALL_MESSAGE__ACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return (Action)eDynamicGet(InteractionPackage.CALL_MESSAGE__ACTION, InteractionPackage.Literals.CALL_MESSAGE__ACTION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		eDynamicSet(InteractionPackage.CALL_MESSAGE__ACTION, InteractionPackage.Literals.CALL_MESSAGE__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace getRuntimeWorkspace() {
		return (Workspace)eDynamicGet(InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE, InteractionPackage.Literals.CALL_MESSAGE__RUNTIME_WORKSPACE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace basicGetRuntimeWorkspace() {
		return (Workspace)eDynamicGet(InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE, InteractionPackage.Literals.CALL_MESSAGE__RUNTIME_WORKSPACE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeWorkspace(Workspace newRuntimeWorkspace) {
		eDynamicSet(InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE, InteractionPackage.Literals.CALL_MESSAGE__RUNTIME_WORKSPACE, newRuntimeWorkspace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ParameterValue> getParameterValues() {
		return (EList<ParameterValue>)eDynamicGet(InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES, InteractionPackage.Literals.CALL_MESSAGE__PARAMETER_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES:
				return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.CALL_MESSAGE__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE:
				if (resolve) return getRuntimeWorkspace();
				return basicGetRuntimeWorkspace();
			case InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES:
				return getParameterValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InteractionPackage.CALL_MESSAGE__ACTION:
				setAction((Action)newValue);
				return;
			case InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE:
				setRuntimeWorkspace((Workspace)newValue);
				return;
			case InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES:
				getParameterValues().clear();
				getParameterValues().addAll((Collection<? extends ParameterValue>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InteractionPackage.CALL_MESSAGE__ACTION:
				setAction((Action)null);
				return;
			case InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE:
				setRuntimeWorkspace((Workspace)null);
				return;
			case InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES:
				getParameterValues().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InteractionPackage.CALL_MESSAGE__ACTION:
				return basicGetAction() != null;
			case InteractionPackage.CALL_MESSAGE__RUNTIME_WORKSPACE:
				return basicGetRuntimeWorkspace() != null;
			case InteractionPackage.CALL_MESSAGE__PARAMETER_VALUES:
				return !getParameterValues().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallMessageImpl
