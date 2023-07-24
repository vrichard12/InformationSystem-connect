/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.PropertyContainedValue;
import org.obeonetwork.dsl.object.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Contained Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyContainedValueImpl#getContainedValue <em>Contained Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyContainedValueImpl extends PropertyValueImpl implements PropertyContainedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyContainedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.PROPERTY_CONTAINED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Value> getContainedValue() {
		return (EList<Value>)eDynamicGet(ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE, ObjectPackage.Literals.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE:
				return ((InternalEList<?>)getContainedValue()).basicRemove(otherEnd, msgs);
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
			case ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE:
				return getContainedValue();
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
			case ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE:
				getContainedValue().clear();
				getContainedValue().addAll((Collection<? extends Value>)newValue);
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
			case ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE:
				getContainedValue().clear();
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
			case ObjectPackage.PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE:
				return !getContainedValue().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyContainedValueImpl
