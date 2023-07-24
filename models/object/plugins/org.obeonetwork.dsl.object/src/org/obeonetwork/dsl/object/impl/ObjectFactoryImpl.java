/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
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
			case ObjectPackage.PROPERTY_CONTAINED_VALUE: return (EObject)createPropertyContainedValue();
			case ObjectPackage.PROPERTY_REFERENCED_VALUE: return (EObject)createPropertyReferencedValue();
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
	public PropertyContainedValue createPropertyContainedValue() {
		PropertyContainedValueImpl propertyContainedValue = new PropertyContainedValueImpl();
		return propertyContainedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyReferencedValue createPropertyReferencedValue() {
		PropertyReferencedValueImpl propertyReferencedValue = new PropertyReferencedValueImpl();
		return propertyReferencedValue;
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
