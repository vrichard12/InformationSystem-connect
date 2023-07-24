/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Referenced Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.PropertyReferencedValue#getReferencedValue <em>Referenced Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyReferencedValue()
 * @model
 * @generated
 */
public interface PropertyReferencedValue extends PropertyValue {
	/**
	 * Returns the value of the '<em><b>Referenced Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Value</em>' reference.
	 * @see #setReferencedValue(Value)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getPropertyReferencedValue_ReferencedValue()
	 * @model
	 * @generated
	 */
	Value getReferencedValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.PropertyReferencedValue#getReferencedValue <em>Referenced Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Value</em>' reference.
	 * @see #getReferencedValue()
	 * @generated
	 */
	void setReferencedValue(Value value);

} // PropertyReferencedValue
