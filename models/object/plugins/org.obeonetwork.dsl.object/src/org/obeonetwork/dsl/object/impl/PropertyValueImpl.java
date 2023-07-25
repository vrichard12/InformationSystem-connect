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

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.environment.Property;

import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.PropertyValue;
import org.obeonetwork.dsl.object.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getMetaProperty <em>Meta Property</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyValueImpl extends CDOObjectImpl implements PropertyValue {
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
	protected PropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getMetaProperty() {
		return (Property)eDynamicGet(ObjectPackage.PROPERTY_VALUE__META_PROPERTY, ObjectPackage.Literals.PROPERTY_VALUE__META_PROPERTY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetMetaProperty() {
		return (Property)eDynamicGet(ObjectPackage.PROPERTY_VALUE__META_PROPERTY, ObjectPackage.Literals.PROPERTY_VALUE__META_PROPERTY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaProperty(Property newMetaProperty) {
		eDynamicSet(ObjectPackage.PROPERTY_VALUE__META_PROPERTY, ObjectPackage.Literals.PROPERTY_VALUE__META_PROPERTY, newMetaProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value getValue() {
		return (Value)eDynamicGet(ObjectPackage.PROPERTY_VALUE__VALUE, ObjectPackage.Literals.PROPERTY_VALUE__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetValue() {
		return (Value)eDynamicGet(ObjectPackage.PROPERTY_VALUE__VALUE, ObjectPackage.Literals.PROPERTY_VALUE__VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(Value newValue) {
		eDynamicSet(ObjectPackage.PROPERTY_VALUE__VALUE, ObjectPackage.Literals.PROPERTY_VALUE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(ObjectPackage.PROPERTY_VALUE__NAME, ObjectPackage.Literals.PROPERTY_VALUE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(ObjectPackage.PROPERTY_VALUE__NAME, ObjectPackage.Literals.PROPERTY_VALUE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.PROPERTY_VALUE__META_PROPERTY:
				if (resolve) return getMetaProperty();
				return basicGetMetaProperty();
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case ObjectPackage.PROPERTY_VALUE__NAME:
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
			case ObjectPackage.PROPERTY_VALUE__META_PROPERTY:
				setMetaProperty((Property)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				setValue((Value)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__NAME:
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
			case ObjectPackage.PROPERTY_VALUE__META_PROPERTY:
				setMetaProperty((Property)null);
				return;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				setValue((Value)null);
				return;
			case ObjectPackage.PROPERTY_VALUE__NAME:
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
			case ObjectPackage.PROPERTY_VALUE__META_PROPERTY:
				return basicGetMetaProperty() != null;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				return basicGetValue() != null;
			case ObjectPackage.PROPERTY_VALUE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		}
		return super.eIsSet(featureID);
	}

} //PropertyValueImpl
