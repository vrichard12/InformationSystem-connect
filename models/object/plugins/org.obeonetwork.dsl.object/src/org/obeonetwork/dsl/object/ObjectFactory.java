/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.object.ObjectPackage
 * @generated
 */
public interface ObjectFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectFactory eINSTANCE = org.obeonetwork.dsl.object.impl.ObjectFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value</em>'.
	 * @generated
	 */
	ObjectValue createObjectValue();

	/**
	 * Returns a new object of class '<em>Primitive Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Value</em>'.
	 * @generated
	 */
	PrimitiveTypeValue createPrimitiveTypeValue();

	/**
	 * Returns a new object of class '<em>Literal Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Value</em>'.
	 * @generated
	 */
	LiteralValue createLiteralValue();

	/**
	 * Returns a new object of class '<em>Property Contained Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Contained Value</em>'.
	 * @generated
	 */
	PropertyContainedValue createPropertyContainedValue();

	/**
	 * Returns a new object of class '<em>Property Referenced Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Referenced Value</em>'.
	 * @generated
	 */
	PropertyReferencedValue createPropertyReferencedValue();

	/**
	 * Returns a new object of class '<em>Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace</em>'.
	 * @generated
	 */
	Workspace createWorkspace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ObjectPackage getObjectPackage();

} //ObjectFactory
