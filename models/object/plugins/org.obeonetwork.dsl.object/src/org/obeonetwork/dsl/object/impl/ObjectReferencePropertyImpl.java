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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.ObjectReferenceProperty;
import org.obeonetwork.dsl.object.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.ObjectReferencePropertyImpl#getReferencedValues <em>Referenced Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectReferencePropertyImpl extends ObjectPropertyImpl implements ObjectReferenceProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectReferencePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.OBJECT_REFERENCE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Value> getReferencedValues() {
		return (EList<Value>)eDynamicGet(ObjectPackage.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES, ObjectPackage.Literals.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES:
				return getReferencedValues();
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
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES:
				getReferencedValues().clear();
				getReferencedValues().addAll((Collection<? extends Value>)newValue);
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
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES:
				getReferencedValues().clear();
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
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES:
				return !getReferencedValues().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public EList<Value> getValues() {
		return getReferencedValues();
	}

} //ObjectReferencePropertyImpl