/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.cdo.CDOObject;

import org.obeonetwork.dsl.environment.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.PropertyValue#getMetaProperty <em>Meta Property</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.object.PropertyValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyValue()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface PropertyValue extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Property</em>' reference.
	 * @see #setMetaProperty(Property)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyValue_MetaProperty()
	 * @model
	 * @generated
	 */
	Property getMetaProperty();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.PropertyValue#getMetaProperty <em>Meta Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Property</em>' reference.
	 * @see #getMetaProperty()
	 * @generated
	 */
	void setMetaProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(Value)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyValue_Value()
	 * @model derived="true"
	 * @generated
	 */
	Value getValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.PropertyValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Value value);

} // PropertyValue
