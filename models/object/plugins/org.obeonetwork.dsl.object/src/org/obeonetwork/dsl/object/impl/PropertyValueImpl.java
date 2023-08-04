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

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.environment.MultiplicityKind;
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
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl#getValue <em>Value</em>}</li>
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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ZERO_ONE_LITERAL;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

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
	 * @generated NOT
	 */
	@Override
	public abstract EList<Value> getValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if(getMetaProperty() != null) {
			return getMetaProperty().getName();
		}
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
	 * @generated NOT
	 */
	@Override
	public MultiplicityKind getMultiplicity() {
		if(getMetaProperty() != null) {
			return getMetaProperty().getMultiplicity();
		}
		return (MultiplicityKind)eDynamicGet(ObjectPackage.PROPERTY_VALUE__MULTIPLICITY, ObjectPackage.Literals.PROPERTY_VALUE__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(ObjectPackage.PROPERTY_VALUE__MULTIPLICITY, ObjectPackage.Literals.PROPERTY_VALUE__MULTIPLICITY, newMultiplicity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue() {
		if(getMultiplicity() == null || getMultiplicity() == MultiplicityKind.ZERO_ONE_LITERAL || getMultiplicity() == MultiplicityKind.ONE_LITERAL) {
			return getValues().isEmpty() ? null : getValues().get(0);
		} else {
			return getValues();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setValue(Object newValue) {
		EList<Value> values = getValues();
		if(getMultiplicity() == null || getMultiplicity() == MultiplicityKind.ZERO_ONE_LITERAL || getMultiplicity() == MultiplicityKind.ONE_LITERAL) {
			if(newValue instanceof Value) {
				values.removeIf(v -> true);
				values.add((Value)newValue);
			} else {
				throw new InvalidParameterException();
			}
		} else {
			if(newValue instanceof List<?> && ((List<?>) newValue).stream().allMatch(Value.class::isInstance)) {
				values.removeIf(v -> true);
				((List<?>) newValue).stream().forEach(v -> values.add((Value) v));
			} else {
				throw new InvalidParameterException();
			}
		}
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
			case ObjectPackage.PROPERTY_VALUE__VALUES:
				return getValues();
			case ObjectPackage.PROPERTY_VALUE__NAME:
				return getName();
			case ObjectPackage.PROPERTY_VALUE__MULTIPLICITY:
				return getMultiplicity();
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				return getValue();
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
			case ObjectPackage.PROPERTY_VALUE__META_PROPERTY:
				setMetaProperty((Property)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__NAME:
				setName((String)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__MULTIPLICITY:
				setMultiplicity((MultiplicityKind)newValue);
				return;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				setValue(newValue);
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
			case ObjectPackage.PROPERTY_VALUE__VALUES:
				getValues().clear();
				return;
			case ObjectPackage.PROPERTY_VALUE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ObjectPackage.PROPERTY_VALUE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ObjectPackage.PROPERTY_VALUE__VALUES:
				return !getValues().isEmpty();
			case ObjectPackage.PROPERTY_VALUE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case ObjectPackage.PROPERTY_VALUE__MULTIPLICITY:
				return getMultiplicity() != MULTIPLICITY_EDEFAULT;
			case ObjectPackage.PROPERTY_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
		}
		return super.eIsSet(featureID);
	}

} //PropertyValueImpl
