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
package org.obeonetwork.dsl.interaction.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.interaction.ByValueParameterValue;
import org.obeonetwork.dsl.interaction.InteractionPackage;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>By Value Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.ByValueParameterValueImpl#getContainedValue <em>Contained Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ByValueParameterValueImpl extends ParameterValueImpl implements ByValueParameterValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ByValueParameterValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Identifiable getContainedValue() {
		return (Identifiable)eDynamicGet(InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetContainedValue() {
		return (Identifiable)eDynamicGet(InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedValue(Identifiable newContainedValue, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newContainedValue, InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedValue(Identifiable newContainedValue) {
		eDynamicSet(InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE, newContainedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				return basicSetContainedValue(null, msgs);
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
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				if (resolve) return getContainedValue();
				return basicGetContainedValue();
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
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				setContainedValue((Identifiable)newValue);
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
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				setContainedValue((Identifiable)null);
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
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				return basicGetContainedValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //ByValueParameterValueImpl
