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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectReferenceProperty;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectPackageImpl extends EPackageImpl implements ObjectPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectContainmentPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectReferencePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.object.ObjectPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ObjectPackageImpl() {
		super(eNS_URI, ObjectFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ObjectPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ObjectPackage init() {
		if (isInited) return (ObjectPackage)EPackage.Registry.INSTANCE.getEPackage(ObjectPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredObjectPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ObjectPackageImpl theObjectPackage = registeredObjectPackage instanceof ObjectPackageImpl ? (ObjectPackageImpl)registeredObjectPackage : new ObjectPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theObjectPackage.createPackageContents();

		// Initialize created meta-data
		theObjectPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theObjectPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ObjectPackage.eNS_URI, theObjectPackage);
		return theObjectPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValue_MetaType() {
		return (EReference)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataTypeValue() {
		return dataTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectValue() {
		return objectValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectValue_Properties() {
		return (EReference)objectValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveTypeValue() {
		return primitiveTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveTypeValue_Data() {
		return (EAttribute)primitiveTypeValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralValue() {
		return literalValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteralValue_Data() {
		return (EReference)literalValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteralValue_Name() {
		return (EAttribute)literalValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectProperty() {
		return objectPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectProperty_MetaProperty() {
		return (EReference)objectPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectProperty_Values() {
		return (EReference)objectPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectProperty_Name() {
		return (EAttribute)objectPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectProperty_Multiplicity() {
		return (EAttribute)objectPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectProperty_Value() {
		return (EAttribute)objectPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectContainmentProperty() {
		return objectContainmentPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectContainmentProperty_ContainedValues() {
		return (EReference)objectContainmentPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectReferenceProperty() {
		return objectReferencePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectReferenceProperty_ReferencedValues() {
		return (EReference)objectReferencePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWorkspace() {
		return workspaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWorkspace_Values() {
		return (EReference)workspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWorkspace_Name() {
		return (EAttribute)workspaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectFactory getObjectFactory() {
		return (ObjectFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		valueEClass = createEClass(VALUE);
		createEReference(valueEClass, VALUE__META_TYPE);

		dataTypeValueEClass = createEClass(DATA_TYPE_VALUE);

		objectValueEClass = createEClass(OBJECT_VALUE);
		createEReference(objectValueEClass, OBJECT_VALUE__PROPERTIES);

		primitiveTypeValueEClass = createEClass(PRIMITIVE_TYPE_VALUE);
		createEAttribute(primitiveTypeValueEClass, PRIMITIVE_TYPE_VALUE__DATA);

		literalValueEClass = createEClass(LITERAL_VALUE);
		createEReference(literalValueEClass, LITERAL_VALUE__DATA);
		createEAttribute(literalValueEClass, LITERAL_VALUE__NAME);

		objectPropertyEClass = createEClass(OBJECT_PROPERTY);
		createEReference(objectPropertyEClass, OBJECT_PROPERTY__META_PROPERTY);
		createEReference(objectPropertyEClass, OBJECT_PROPERTY__VALUES);
		createEAttribute(objectPropertyEClass, OBJECT_PROPERTY__NAME);
		createEAttribute(objectPropertyEClass, OBJECT_PROPERTY__MULTIPLICITY);
		createEAttribute(objectPropertyEClass, OBJECT_PROPERTY__VALUE);

		objectContainmentPropertyEClass = createEClass(OBJECT_CONTAINMENT_PROPERTY);
		createEReference(objectContainmentPropertyEClass, OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES);

		objectReferencePropertyEClass = createEClass(OBJECT_REFERENCE_PROPERTY);
		createEReference(objectReferencePropertyEClass, OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES);

		workspaceEClass = createEClass(WORKSPACE);
		createEReference(workspaceEClass, WORKSPACE__VALUES);
		createEAttribute(workspaceEClass, WORKSPACE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TechnicalIDPackage theTechnicalIDPackage = (TechnicalIDPackage)EPackage.Registry.INSTANCE.getEPackage(TechnicalIDPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		valueEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		dataTypeValueEClass.getESuperTypes().add(this.getValue());
		objectValueEClass.getESuperTypes().add(this.getValue());
		primitiveTypeValueEClass.getESuperTypes().add(this.getDataTypeValue());
		literalValueEClass.getESuperTypes().add(this.getDataTypeValue());
		objectContainmentPropertyEClass.getESuperTypes().add(this.getObjectProperty());
		objectReferencePropertyEClass.getESuperTypes().add(this.getObjectProperty());
		workspaceEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());

		// Initialize classes and features; add operations and parameters
		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValue_MetaType(), theEnvironmentPackage.getType(), null, "metaType", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeValueEClass, DataTypeValue.class, "DataTypeValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectValueEClass, ObjectValue.class, "ObjectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectValue_Properties(), this.getObjectProperty(), null, "properties", null, 0, -1, ObjectValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(objectValueEClass, ecorePackage.getEBoolean(), "hasProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectValueEClass, ecorePackage.getEBoolean(), "hasProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEnvironmentPackage.getProperty(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectValueEClass, ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectValueEClass, ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEnvironmentPackage.getProperty(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectValueEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectValueEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEnvironmentPackage.getProperty(), "property", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeValueEClass, PrimitiveTypeValue.class, "PrimitiveTypeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypeValue_Data(), ecorePackage.getEJavaObject(), "data", null, 0, 1, PrimitiveTypeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalValueEClass, LiteralValue.class, "LiteralValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralValue_Data(), theEnvironmentPackage.getLiteral(), null, "data", null, 0, 1, LiteralValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteralValue_Name(), ecorePackage.getEString(), "name", null, 0, 1, LiteralValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectPropertyEClass, ObjectProperty.class, "ObjectProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectProperty_MetaProperty(), theEnvironmentPackage.getProperty(), null, "metaProperty", null, 0, 1, ObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectProperty_Values(), this.getValue(), null, "values", null, 0, -1, ObjectProperty.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectProperty_Multiplicity(), theEnvironmentPackage.getMultiplicityKind(), "multiplicity", null, 0, 1, ObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectProperty_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, ObjectProperty.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(objectPropertyEClass, ecorePackage.getEBoolean(), "isMultiple", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(objectPropertyEClass, ecorePackage.getEBoolean(), "unsetValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectPropertyEClass, ecorePackage.getEBoolean(), "unsetValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValue(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(objectContainmentPropertyEClass, ObjectContainmentProperty.class, "ObjectContainmentProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectContainmentProperty_ContainedValues(), this.getValue(), null, "containedValues", null, 0, -1, ObjectContainmentProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectReferencePropertyEClass, ObjectReferenceProperty.class, "ObjectReferenceProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectReferenceProperty_ReferencedValues(), this.getValue(), null, "referencedValues", null, 0, -1, ObjectReferenceProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceEClass, Workspace.class, "Workspace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspace_Values(), this.getValue(), null, "values", null, 0, -1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspace_Name(), ecorePackage.getEString(), "name", null, 0, 1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (getLiteralValue_Name(),
		   source,
		   new String[] {
			   "documentation", "The LiteralValue name. If literal is defined, its value is the one of the referenced Literal."
		   });
		addAnnotation
		  (getObjectProperty_Values(),
		   source,
		   new String[] {
			   "documentation", "The values of the PropertyValue. It is mapped to PropertyContainedValue::containedValues or PropertyReferencedValue::referencedValues depending on the concrete type of this PropertyValue."
		   });
		addAnnotation
		  (getObjectProperty_Name(),
		   source,
		   new String[] {
			   "documentation", "The PropertyValue name. If metaProperty is defined, its value is the one of the referenced Property."
		   });
		addAnnotation
		  (getObjectProperty_Multiplicity(),
		   source,
		   new String[] {
			   "documentation", "The PropertyValue multiplicity. If metaProperty is defined, its value is the one of the referenced Property."
		   });
		addAnnotation
		  (getObjectProperty_Value(),
		   source,
		   new String[] {
			   "documentation", "The value of this PropertyValue. If the property is mono valued the feature is mapped to the Value, if the property is multi valued the feature is mapped to the list of Values."
		   });
	}

} //ObjectPackageImpl
