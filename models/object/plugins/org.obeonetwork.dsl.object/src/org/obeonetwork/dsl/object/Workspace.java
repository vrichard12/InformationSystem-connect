/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object;

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.Workspace#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.object.ObjectPackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends ObeoDSMObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.object.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.obeonetwork.dsl.object.ObjectPackage#getWorkspace_Values()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Value> getValues();

} // Workspace
