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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.obeonetwork.dsl.object.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectFactoryImpl extends EFactoryImpl implements ObjectFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectFactory init() {
		try {
			ObjectFactory theObjectFactory = (ObjectFactory)EPackage.Registry.INSTANCE.getEFactory(ObjectPackage.eNS_URI);
			if (theObjectFactory != null) {
				return theObjectFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ObjectFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ObjectPackage.OBJECT_VALUE: return (EObject)createObjectValue();
			case ObjectPackage.PRIMITIVE_TYPE_VALUE: return (EObject)createPrimitiveTypeValue();
			case ObjectPackage.LITERAL_VALUE: return (EObject)createLiteralValue();
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY: return (EObject)createObjectContainmentProperty();
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY: return (EObject)createObjectReferenceProperty();
			case ObjectPackage.WORKSPACE: return (EObject)createWorkspace();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectValue createObjectValue() {
		ObjectValueImpl objectValue = new ObjectValueImpl();
		return objectValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveTypeValue createPrimitiveTypeValue() {
		PrimitiveTypeValueImpl primitiveTypeValue = new PrimitiveTypeValueImpl();
		return primitiveTypeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralValue createLiteralValue() {
		LiteralValueImpl literalValue = new LiteralValueImpl();
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectContainmentProperty createObjectContainmentProperty() {
		ObjectContainmentPropertyImpl objectContainmentProperty = new ObjectContainmentPropertyImpl();
		return objectContainmentProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectReferenceProperty createObjectReferenceProperty() {
		ObjectReferencePropertyImpl objectReferenceProperty = new ObjectReferencePropertyImpl();
		return objectReferenceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Workspace createWorkspace() {
		WorkspaceImpl workspace = new WorkspaceImpl();
		return workspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectPackage getObjectPackage() {
		return (ObjectPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ObjectPackage getPackage() {
		return ObjectPackage.eINSTANCE;
	}

} //ObjectFactoryImpl
