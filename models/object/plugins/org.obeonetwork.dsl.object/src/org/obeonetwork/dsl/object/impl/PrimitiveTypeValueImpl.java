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
import org.obeonetwork.dsl.object.PrimitiveTypeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PrimitiveTypeValueImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeValueImpl extends DataTypeValueImpl implements PrimitiveTypeValue {
	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.PRIMITIVE_TYPE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getData() {
		return (Object)eDynamicGet(ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA, ObjectPackage.Literals.PRIMITIVE_TYPE_VALUE__DATA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setData(Object newData) {
		eDynamicSet(ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA, ObjectPackage.Literals.PRIMITIVE_TYPE_VALUE__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA:
				return getData();
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
			case ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA:
				setData(newValue);
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
			case ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA:
				setData(DATA_EDEFAULT);
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
			case ObjectPackage.PRIMITIVE_TYPE_VALUE__DATA:
				return DATA_EDEFAULT == null ? getData() != null : !DATA_EDEFAULT.equals(getData());
		}
		return super.eIsSet(featureID);
	}

} //PrimitiveTypeValueImpl
