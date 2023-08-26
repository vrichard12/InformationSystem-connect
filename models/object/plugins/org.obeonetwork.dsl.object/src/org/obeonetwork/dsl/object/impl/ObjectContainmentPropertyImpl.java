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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.ObjectContainmentPropertyImpl#getContainedValues <em>Contained Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectContainmentPropertyImpl extends ObjectPropertyImpl implements ObjectContainmentProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectContainmentPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.OBJECT_CONTAINMENT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Value> getContainedValues() {
		return (EList<Value>)eDynamicGet(ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES, ObjectPackage.Literals.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES:
				return ((InternalEList<?>)getContainedValues()).basicRemove(otherEnd, msgs);
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
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES:
				return getContainedValues();
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
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES:
				getContainedValues().clear();
				getContainedValues().addAll((Collection<? extends Value>)newValue);
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
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES:
				getContainedValues().clear();
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
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES:
				return !getContainedValues().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EList<Value> getValues() {
		return getContainedValues();
	}

} //ObjectContainmentPropertyImpl
