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

import org.obeonetwork.dsl.environment.Literal;

import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.LiteralValueImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.LiteralValueImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralValueImpl extends DataTypeValueImpl implements LiteralValue {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.LITERAL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getData() {
		return (Literal)eDynamicGet(ObjectPackage.LITERAL_VALUE__DATA, ObjectPackage.Literals.LITERAL_VALUE__DATA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetData() {
		return (Literal)eDynamicGet(ObjectPackage.LITERAL_VALUE__DATA, ObjectPackage.Literals.LITERAL_VALUE__DATA, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setData(Literal newData) {
		eDynamicSet(ObjectPackage.LITERAL_VALUE__DATA, ObjectPackage.Literals.LITERAL_VALUE__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if(getData() != null) {
			return getData().getName();
		}
		return (String)eDynamicGet(ObjectPackage.LITERAL_VALUE__NAME, ObjectPackage.Literals.LITERAL_VALUE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(ObjectPackage.LITERAL_VALUE__NAME, ObjectPackage.Literals.LITERAL_VALUE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.LITERAL_VALUE__DATA:
				if (resolve) return getData();
				return basicGetData();
			case ObjectPackage.LITERAL_VALUE__NAME:
				return getName();
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
			case ObjectPackage.LITERAL_VALUE__DATA:
				setData((Literal)newValue);
				return;
			case ObjectPackage.LITERAL_VALUE__NAME:
				setName((String)newValue);
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
			case ObjectPackage.LITERAL_VALUE__DATA:
				setData((Literal)null);
				return;
			case ObjectPackage.LITERAL_VALUE__NAME:
				setName(NAME_EDEFAULT);
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
			case ObjectPackage.LITERAL_VALUE__DATA:
				return basicGetData() != null;
			case ObjectPackage.LITERAL_VALUE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		}
		return super.eIsSet(featureID);
	}

} //LiteralValueImpl
