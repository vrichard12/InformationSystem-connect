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
package org.obeonetwork.dsl.object;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectProperty#getMetaProperty <em>Meta Property</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectProperty#getValues <em>Values</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectProperty#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectProperty#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ObjectProperty extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Property</em>' reference.
	 * @see #setMetaProperty(Property)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty_MetaProperty()
	 * @model
	 * @generated
	 */
	Property getMetaProperty();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.ObjectProperty#getMetaProperty <em>Meta Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Property</em>' reference.
	 * @see #getMetaProperty()
	 * @generated
	 */
	void setMetaProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.object.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The values of the PropertyValue. It is mapped to PropertyContainedValue::containedValues or PropertyReferencedValue::referencedValues depending on the concrete type of this PropertyValue.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty_Values()
	 * @model containment="true" resolveProxies="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Value> getValues();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PropertyValue name. If metaProperty is defined, its value is the one of the referenced Property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.ObjectProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.environment.MultiplicityKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PropertyValue multiplicity. If metaProperty is defined, its value is the one of the referenced Property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #setMultiplicity(MultiplicityKind)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty_Multiplicity()
	 * @model
	 * @generated
	 */
	MultiplicityKind getMultiplicity();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.ObjectProperty#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityKind value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of this PropertyValue. If the property is mono valued the feature is mapped to the Value, if the property is multi valued the feature is mapped to the list of Values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectProperty_Value()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.ObjectProperty#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean unsetValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean unsetValue(Value value);

} // ObjectProperty
