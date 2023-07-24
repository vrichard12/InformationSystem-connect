/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.environment.Type;

import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.Value;

import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.ValueImpl#getMetaType <em>Meta Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ValueImpl extends IdentifiableImpl implements Value {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getMetaType() {
		return (Type)eDynamicGet(ObjectPackage.VALUE__META_TYPE, ObjectPackage.Literals.VALUE__META_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetMetaType() {
		return (Type)eDynamicGet(ObjectPackage.VALUE__META_TYPE, ObjectPackage.Literals.VALUE__META_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaType(Type newMetaType) {
		eDynamicSet(ObjectPackage.VALUE__META_TYPE, ObjectPackage.Literals.VALUE__META_TYPE, newMetaType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.VALUE__META_TYPE:
				if (resolve) return getMetaType();
				return basicGetMetaType();
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
			case ObjectPackage.VALUE__META_TYPE:
				setMetaType((Type)newValue);
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
			case ObjectPackage.VALUE__META_TYPE:
				setMetaType((Type)null);
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
			case ObjectPackage.VALUE__META_TYPE:
				return basicGetMetaType() != null;
		}
		return super.eIsSet(featureID);
	}

} //ValueImpl
