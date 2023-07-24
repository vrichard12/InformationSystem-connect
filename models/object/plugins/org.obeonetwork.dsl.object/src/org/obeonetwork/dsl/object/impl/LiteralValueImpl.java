/**
 * Copyright Text	Copyright (c) 2008, 2023 Obeo....
 */
package org.obeonetwork.dsl.object.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.environment.Literal;

import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.object.impl.LiteralValueImpl#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralValueImpl extends DataTypeValueImpl implements LiteralValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectPackage.Literals.LITERAL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getLiteral() {
		return (Literal)eDynamicGet(ObjectPackage.LITERAL_VALUE__LITERAL, ObjectPackage.Literals.LITERAL_VALUE__LITERAL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetLiteral() {
		return (Literal)eDynamicGet(ObjectPackage.LITERAL_VALUE__LITERAL, ObjectPackage.Literals.LITERAL_VALUE__LITERAL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiteral(Literal newLiteral) {
		eDynamicSet(ObjectPackage.LITERAL_VALUE__LITERAL, ObjectPackage.Literals.LITERAL_VALUE__LITERAL, newLiteral);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectPackage.LITERAL_VALUE__LITERAL:
				if (resolve) return getLiteral();
				return basicGetLiteral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ObjectPackage.LITERAL_VALUE__LITERAL:
				setLiteral((Literal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ObjectPackage.LITERAL_VALUE__LITERAL:
				setLiteral((Literal)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ObjectPackage.LITERAL_VALUE__LITERAL:
				return basicGetLiteral() != null;
		}
		return super.eIsSet(featureID);
	}

} //LiteralValueImpl
