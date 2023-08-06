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
import java.util.Optional;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PropertyValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.ObjectValueImpl#getPropertyValues <em>Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectValueImpl extends ValueImpl implements ObjectValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.OBJECT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<PropertyValue> getPropertyValues() {
		return (EList<PropertyValue>)eDynamicGet(ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES, ObjectPackage.Literals.OBJECT_VALUE__PROPERTY_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean hasProperty(String name) {
		return getPropertyValues().stream()
		.anyMatch(pv -> name.equals(pv.getMetaProperty().getName()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean hasProperty(Property property) {
		return getPropertyValues().stream()
		.anyMatch(pv -> pv.getMetaProperty() == property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue(String name) {
		return getPropertyValues().stream()
		.filter(pv -> name.equals(pv.getMetaProperty().getName()))
		.findAny().map(pv -> pv.getValue()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue(Property property) {
		return getPropertyValues().stream()
		.filter(pv -> pv.getMetaProperty() == property)
		.findAny().map(pv -> pv.getValue()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setValue(String name, Object value) {
		Optional<PropertyValue> pvOpt = getPropertyValues().stream()
		.filter(pv -> name.equals(pv.getName()))
		.findAny();
		pvOpt.ifPresent(pv -> pv.setValue(value));
		if(!pvOpt.isPresent()) {
			PropertyValue pv = ObjectFactory.eINSTANCE.createPropertyContainedValue();
			pv.setName(name);
			pv.setValue(value);
			getPropertyValues().add(pv);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setValue(Property property, Object value) {
		Optional<PropertyValue> pvOpt = getPropertyValues().stream()
		.filter(pv -> pv.getMetaProperty() == property)
		.findAny();
		pvOpt.ifPresent(pv -> pv.setValue(value));
		if(!pvOpt.isPresent()) {
			PropertyValue pv = (property instanceof Reference && !((Reference)property).isIsComposite())?
					ObjectFactory.eINSTANCE.createPropertyReferencedValue() :
					ObjectFactory.eINSTANCE.createPropertyContainedValue();
			pv.setMetaProperty(property);
			pv.setValue(value);
			getPropertyValues().add(pv);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES:
				return ((InternalEList<?>)getPropertyValues()).basicRemove(otherEnd, msgs);
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
			case ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES:
				return getPropertyValues();
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
			case ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES:
				getPropertyValues().clear();
				getPropertyValues().addAll((Collection<? extends PropertyValue>)newValue);
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
			case ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES:
				getPropertyValues().clear();
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
			case ObjectPackage.OBJECT_VALUE__PROPERTY_VALUES:
				return !getPropertyValues().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectValueImpl
