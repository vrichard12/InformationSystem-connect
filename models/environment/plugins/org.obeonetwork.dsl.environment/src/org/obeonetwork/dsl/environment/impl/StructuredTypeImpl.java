/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getAssociatedTypes <em>Associated Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.StructuredTypeImpl#getSupertypes <em>Supertypes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StructuredTypeImpl extends TypeImpl implements StructuredType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.STRUCTURED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public StructuredType getSupertype() {
		StructuredType supertype = null;
		if (!getSupertypes().isEmpty()) {
			supertype = getSupertypes().get(0);
		}
		return supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StructuredType basicGetSupertype() {
		return getSupertype();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @throws IllegalArgumentException
	 *             if the <code>newSuperType</code> induces a cyclic
	 *             inheritance.
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setSupertype(StructuredType newSupertype) {
		if (newSupertype == this || getAllSupertypes().contains(newSupertype)) {
			throw new IllegalArgumentException(
					"Cyclic inheritance from " + getName() + " to " + newSupertype.getName() + ".");
		}
		getSupertypes().clear();
		if (newSupertype != null) {
			getSupertypes().add(newSupertype);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<StructuredType> getAssociatedTypes() {
		return (EList<StructuredType>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__ASSOCIATED_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Attribute> getOwnedAttributes() {
		return (EList<Attribute>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Attribute> getAttributes() {
		BasicEList<Attribute> result = new UniqueEList<Attribute>() {
			private static final long serialVersionUID = 7590892592603363094L;

			protected Object[] newData(int capacity) {
				return new Attribute[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedAttributes());
		getAllSupertypes().forEach(superType -> result.addAll(superType.getOwnedAttributes()));

		result.shrink();
		EList<Attribute> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Attribute>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__ATTRIBUTES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Reference> getOwnedReferences() {
		return (EList<Reference>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Reference> getReferences() {
		BasicEList<Reference> result = new UniqueEList<Reference>() {
			private static final long serialVersionUID = 7590892592603363094L;

			protected Object[] newData(int capacity) {
				return new Reference[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getOwnedReferences());
		getAllSupertypes().forEach(superType -> result.addAll(superType.getOwnedReferences()));
		
		result.shrink();
		EList<Reference> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Reference>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__REFERENCES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Property> getProperties() {
		BasicEList<Property> result = new UniqueEList<Property>() {
			private static final long serialVersionUID = 3148122129800312442L;

			protected Object[] newData(int capacity) {
				return new Property[capacity];
			}

			protected boolean useEquals() {
				return false;
			}
		};
		result.addAll(getAttributes());
		result.addAll(getReferences());
		result.shrink();
		EList<Property> unmodifiableResult = new EcoreEList.UnmodifiableEList.FastCompare<Property>(this,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__PROPERTIES, result.size(), result.data());
		return unmodifiableResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<StructuredType> getSupertypes() {
		return (EList<StructuredType>) eDynamicGet(EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPES,
				EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSubtypeOf(StructuredType type) {
		return EcoreUtil.equals(this, type) || getAllSupertypes().stream().anyMatch(supertype -> EcoreUtil.equals(supertype, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<StructuredType> getAllSupertypes() {
		return ECollections.toEList(getAllSupertypesInternal().iterator());
	}
	
	private Set<StructuredType> getAllSupertypesInternal() {
		Set<StructuredType> allSupertypes = new HashSet<>();
		
		getSupertypes().stream()//
			.map(StructuredTypeImpl.class::cast)//
			.forEach(supertype -> {
				if(!allSupertypes.contains(supertype)) {
					allSupertypes.add(supertype);
					allSupertypes.addAll(supertype.getAllSupertypesInternal());
				}
			});
		
		return allSupertypes;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedAttributes()).basicAdd(otherEnd, msgs);
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedReferences()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return ((InternalEList<?>) getOwnedAttributes()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return ((InternalEList<?>) getOwnedReferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			if (resolve)
				return getSupertype();
			return basicGetSupertype();
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			return getAssociatedTypes();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return getOwnedAttributes();
		case EnvironmentPackage.STRUCTURED_TYPE__ATTRIBUTES:
			return getAttributes();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return getOwnedReferences();
		case EnvironmentPackage.STRUCTURED_TYPE__REFERENCES:
			return getReferences();
		case EnvironmentPackage.STRUCTURED_TYPE__PROPERTIES:
			return getProperties();
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPES:
			return getSupertypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			setSupertype((StructuredType) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			getAssociatedTypes().addAll((Collection<? extends StructuredType>) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			getOwnedAttributes().addAll((Collection<? extends Attribute>) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			getOwnedReferences().clear();
			getOwnedReferences().addAll((Collection<? extends Reference>) newValue);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPES:
			getSupertypes().clear();
			getSupertypes().addAll((Collection<? extends StructuredType>) newValue);
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			setSupertype((StructuredType) null);
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			getAssociatedTypes().clear();
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			getOwnedAttributes().clear();
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			getOwnedReferences().clear();
			return;
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPES:
			getSupertypes().clear();
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
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPE:
			return basicGetSupertype() != null;
		case EnvironmentPackage.STRUCTURED_TYPE__ASSOCIATED_TYPES:
			return !getAssociatedTypes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
			return !getOwnedAttributes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__ATTRIBUTES:
			return !getAttributes().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			return !getOwnedReferences().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__REFERENCES:
			return !getReferences().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__PROPERTIES:
			return !getProperties().isEmpty();
		case EnvironmentPackage.STRUCTURED_TYPE__SUPERTYPES:
			return !getSupertypes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructuredTypeImpl