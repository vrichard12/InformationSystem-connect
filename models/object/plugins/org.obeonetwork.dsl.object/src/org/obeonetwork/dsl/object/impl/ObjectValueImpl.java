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
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.ObjectValueImpl#getProperties <em>Properties</em>}</li>
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
	public EList<ObjectProperty> getProperties() {
		return (EList<ObjectProperty>)eDynamicGet(ObjectPackage.OBJECT_VALUE__PROPERTIES, ObjectPackage.Literals.OBJECT_VALUE__PROPERTIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean hasProperty(String name) {
		return getProperties().stream()
		.anyMatch(p -> name.equals(p.getMetaProperty().getName()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean hasProperty(Property property) {
		return getProperties().stream()
		.anyMatch(p -> p.getMetaProperty() == property);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue(String name) {
		return getProperties().stream()
		.filter(p -> name.equals(p.getMetaProperty().getName()))
		.findAny().map(p -> p.getValue()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue(Property property) {
		return getProperties().stream()
		.filter(p -> p.getMetaProperty() == property)
		.findAny().map(p -> p.getValue()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setValue(String name, Object value) {
		Optional<ObjectProperty> propertyOption = getProperties().stream()
		.filter(p -> name.equals(p.getName()))
		.findAny();
		propertyOption.ifPresent(property -> property.setValue(value));
		if(!propertyOption.isPresent()) {
			Property metaProperty = null;
			if(getMetaType() != null) {
				metaProperty = ((StructuredType)getMetaType()).getProperties().stream()
				.filter(p -> name.equals(p.getName()))
				.findFirst().orElse(null);
			}
			if(metaProperty != null) {
				setValue(metaProperty, value);
			} else {
				ObjectProperty property = ObjectFactory.eINSTANCE.createObjectContainmentProperty();
				property.setName(name);
				if(value instanceof List) {
					property.setMultiplicity(MultiplicityKind.ZERO_STAR_LITERAL);
				}
				property.setValue(value);
				getProperties().add(property);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setValue(Property property, Object value) {
		Optional<ObjectProperty> propertyOption = getProperties().stream()
		.filter(p -> p.getMetaProperty() == property)
		.findAny();
		propertyOption.ifPresent(p -> p.setValue(value));
		if(!propertyOption.isPresent()) {
			ObjectProperty p = (property instanceof Reference && !((Reference)property).isIsComposite())?
					ObjectFactory.eINSTANCE.createObjectReferenceProperty() :
					ObjectFactory.eINSTANCE.createObjectContainmentProperty();
			p.setMetaProperty(property);
			p.setValue(value);
			getProperties().add(p);
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
			case ObjectPackage.OBJECT_VALUE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case ObjectPackage.OBJECT_VALUE__PROPERTIES:
				return getProperties();
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
			case ObjectPackage.OBJECT_VALUE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ObjectProperty>)newValue);
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
			case ObjectPackage.OBJECT_VALUE__PROPERTIES:
				getProperties().clear();
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
			case ObjectPackage.OBJECT_VALUE__PROPERTIES:
				return !getProperties().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectValueImpl
