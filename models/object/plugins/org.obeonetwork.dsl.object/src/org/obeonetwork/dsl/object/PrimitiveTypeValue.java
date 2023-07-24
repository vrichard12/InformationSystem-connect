/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.PrimitiveTypeValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getPrimitiveTypeValue()
 * @model
 * @generated
 */
public interface PrimitiveTypeValue extends DataTypeValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getPrimitiveTypeValue_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.object.PrimitiveTypeValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // PrimitiveTypeValue
