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

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.interaction.ByReferenceParameterValue;
import org.obeonetwork.dsl.interaction.InteractionPackage;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>By Reference Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.ByReferenceParameterValueImpl#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ByReferenceParameterValueImpl extends ParameterValueImpl implements ByReferenceParameterValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ByReferenceParameterValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.BY_REFERENCE_PARAMETER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getReferencedValue() {
		return (Identifiable)eDynamicGet(InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, InteractionPackage.Literals.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetReferencedValue() {
		return (Identifiable)eDynamicGet(InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, InteractionPackage.Literals.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedValue(Identifiable newReferencedValue) {
		eDynamicSet(InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, InteractionPackage.Literals.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE, newReferencedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE:
				if (resolve) return getReferencedValue();
				return basicGetReferencedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE:
				setReferencedValue((Identifiable)newValue);
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
			case InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE:
				setReferencedValue((Identifiable)null);
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
			case InteractionPackage.BY_REFERENCE_PARAMETER_VALUE__REFERENCED_VALUE:
				return basicGetReferencedValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //ByReferenceParameterValueImpl
