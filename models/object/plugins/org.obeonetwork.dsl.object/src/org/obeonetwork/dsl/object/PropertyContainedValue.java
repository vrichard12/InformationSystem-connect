/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Contained Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.PropertyContainedValue#getContainedValue <em>Contained Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyContainedValue()
 * @model
 * @generated
 */
public interface PropertyContainedValue extends PropertyValue {
	/**
	 * Returns the value of the '<em><b>Contained Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.object.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Value</em>' containment reference list.
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyContainedValue_ContainedValue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Value> getContainedValue();

} // PropertyContainedValue
