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
package org.obeonetwork.dsl.object.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

import org.obeonetwork.dsl.object.*;

import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.object.ObjectPackage
 * @generated
 */
public class ObjectSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ObjectPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectSwitch() {
		if (modelPackage == null) {
			modelPackage = ObjectPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ObjectPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseIdentifiable(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.DATA_TYPE_VALUE: {
				DataTypeValue dataTypeValue = (DataTypeValue)theEObject;
				T result = caseDataTypeValue(dataTypeValue);
				if (result == null) result = caseValue(dataTypeValue);
				if (result == null) result = caseIdentifiable(dataTypeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.OBJECT_VALUE: {
				ObjectValue objectValue = (ObjectValue)theEObject;
				T result = caseObjectValue(objectValue);
				if (result == null) result = caseValue(objectValue);
				if (result == null) result = caseIdentifiable(objectValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.PRIMITIVE_TYPE_VALUE: {
				PrimitiveTypeValue primitiveTypeValue = (PrimitiveTypeValue)theEObject;
				T result = casePrimitiveTypeValue(primitiveTypeValue);
				if (result == null) result = caseDataTypeValue(primitiveTypeValue);
				if (result == null) result = caseValue(primitiveTypeValue);
				if (result == null) result = caseIdentifiable(primitiveTypeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.LITERAL_VALUE: {
				LiteralValue literalValue = (LiteralValue)theEObject;
				T result = caseLiteralValue(literalValue);
				if (result == null) result = caseDataTypeValue(literalValue);
				if (result == null) result = caseValue(literalValue);
				if (result == null) result = caseIdentifiable(literalValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.OBJECT_PROPERTY: {
				ObjectProperty objectProperty = (ObjectProperty)theEObject;
				T result = caseObjectProperty(objectProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.OBJECT_CONTAINMENT_PROPERTY: {
				ObjectContainmentProperty objectContainmentProperty = (ObjectContainmentProperty)theEObject;
				T result = caseObjectContainmentProperty(objectContainmentProperty);
				if (result == null) result = caseObjectProperty(objectContainmentProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.OBJECT_REFERENCE_PROPERTY: {
				ObjectReferenceProperty objectReferenceProperty = (ObjectReferenceProperty)theEObject;
				T result = caseObjectReferenceProperty(objectReferenceProperty);
				if (result == null) result = caseObjectProperty(objectReferenceProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ObjectPackage.WORKSPACE: {
				Workspace workspace = (Workspace)theEObject;
				T result = caseWorkspace(workspace);
				if (result == null) result = caseObeoDSMObject(workspace);
				if (result == null) result = caseIdentifiable(workspace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeValue(DataTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectValue(ObjectValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeValue(PrimitiveTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralValue(LiteralValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectProperty(ObjectProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectContainmentProperty(ObjectContainmentProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectReferenceProperty(ObjectReferenceProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workspace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspace(Workspace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObeoDSMObject(ObeoDSMObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ObjectSwitch
