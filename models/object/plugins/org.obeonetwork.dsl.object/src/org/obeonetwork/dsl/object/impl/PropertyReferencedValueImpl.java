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
package org.obeonetwork.dsl.object.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.PropertyReferencedValue;
import org.obeonetwork.dsl.object.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Referenced Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyReferencedValueImpl#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyReferencedValueImpl extends PropertyValueImpl implements PropertyReferencedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyReferencedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.PROPERTY_REFERENCED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value getReferencedValue() {
		return (Value)eDynamicGet(ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, ObjectPackage.Literals.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetReferencedValue() {
		return (Value)eDynamicGet(ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, ObjectPackage.Literals.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencedValue(Value newReferencedValue) {
		eDynamicSet(ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, ObjectPackage.Literals.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE, newReferencedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE:
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
			case ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE:
				setReferencedValue((Value)newValue);
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
			case ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE:
				setReferencedValue((Value)null);
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
			case ObjectPackage.PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE:
				return basicGetReferencedValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyReferencedValueImpl
