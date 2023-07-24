/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.ObjectValue#getPropertyValues <em>Property Values</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectValue()
 * @model
 * @generated
 */
public interface ObjectValue extends Value {
	/**
	 * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.object.PropertyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Values</em>' containment reference list.
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getObjectValue_PropertyValues()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PropertyValue> getPropertyValues();

} // ObjectValue
