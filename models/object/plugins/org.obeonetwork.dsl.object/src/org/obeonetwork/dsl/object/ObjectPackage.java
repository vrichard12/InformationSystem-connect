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
package org.obeonetwork.dsl.object;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.obeonetwork.dsl.environment.EnvironmentPackage;

import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.object.ObjectFactory
 * @model kind="package"
 * @generated
 */
public interface ObjectPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "object";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/object/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "object";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectPackage eINSTANCE = org.obeonetwork.dsl.object.impl.ObjectPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.ValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__META_TYPE = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.DataTypeValueImpl <em>Data Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.DataTypeValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getDataTypeValue()
	 * @generated
	 */
	int DATA_TYPE_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_VALUE__TECHNICALID = VALUE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_VALUE__META_TYPE = VALUE__META_TYPE;

	/**
	 * The number of structural features of the '<em>Data Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.ObjectValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.ObjectValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectValue()
	 * @generated
	 */
	int OBJECT_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE__TECHNICALID = VALUE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE__META_TYPE = VALUE__META_TYPE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE__PROPERTIES = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.PrimitiveTypeValueImpl <em>Primitive Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.PrimitiveTypeValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPrimitiveTypeValue()
	 * @generated
	 */
	int PRIMITIVE_TYPE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_VALUE__TECHNICALID = DATA_TYPE_VALUE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_VALUE__META_TYPE = DATA_TYPE_VALUE__META_TYPE;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_VALUE__DATA = DATA_TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_VALUE_FEATURE_COUNT = DATA_TYPE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.LiteralValueImpl <em>Literal Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.LiteralValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getLiteralValue()
	 * @generated
	 */
	int LITERAL_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__TECHNICALID = DATA_TYPE_VALUE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__META_TYPE = DATA_TYPE_VALUE__META_TYPE;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__DATA = DATA_TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__NAME = DATA_TYPE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_FEATURE_COUNT = DATA_TYPE_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.ObjectPropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.ObjectPropertyImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectProperty()
	 * @generated
	 */
	int OBJECT_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__META_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__VALUES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__NAME = 2;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__MULTIPLICITY = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__VALUE = 4;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.ObjectContainmentPropertyImpl <em>Containment Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.ObjectContainmentPropertyImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectContainmentProperty()
	 * @generated
	 */
	int OBJECT_CONTAINMENT_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__META_PROPERTY = OBJECT_PROPERTY__META_PROPERTY;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__VALUES = OBJECT_PROPERTY__VALUES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__NAME = OBJECT_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__MULTIPLICITY = OBJECT_PROPERTY__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__VALUE = OBJECT_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Contained Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES = OBJECT_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Containment Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONTAINMENT_PROPERTY_FEATURE_COUNT = OBJECT_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.ObjectReferencePropertyImpl <em>Reference Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.ObjectReferencePropertyImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectReferenceProperty()
	 * @generated
	 */
	int OBJECT_REFERENCE_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__META_PROPERTY = OBJECT_PROPERTY__META_PROPERTY;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__VALUES = OBJECT_PROPERTY__VALUES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__NAME = OBJECT_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__MULTIPLICITY = OBJECT_PROPERTY__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__VALUE = OBJECT_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Referenced Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES = OBJECT_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_PROPERTY_FEATURE_COUNT = OBJECT_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.WorkspaceImpl <em>Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.WorkspaceImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getWorkspace()
	 * @generated
	 */
	int WORKSPACE = 8;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__TECHNICALID = EnvironmentPackage.OBEO_DSM_OBJECT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__METADATAS = EnvironmentPackage.OBEO_DSM_OBJECT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__DESCRIPTION = EnvironmentPackage.OBEO_DSM_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__KEYWORDS = EnvironmentPackage.OBEO_DSM_OBJECT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__BEHAVIOURS = EnvironmentPackage.OBEO_DSM_OBJECT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__BINDING_REGISTRIES = EnvironmentPackage.OBEO_DSM_OBJECT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__VERSION = EnvironmentPackage.OBEO_DSM_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__CREATED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__MODIFIED_ON = EnvironmentPackage.OBEO_DSM_OBJECT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__VALUES = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__NAME = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.object.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.Value#getMetaType <em>Meta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Type</em>'.
	 * @see org.obeonetwork.dsl.object.Value#getMetaType()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_MetaType();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.DataTypeValue <em>Data Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Value</em>'.
	 * @see org.obeonetwork.dsl.object.DataTypeValue
	 * @generated
	 */
	EClass getDataTypeValue();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.ObjectValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectValue
	 * @generated
	 */
	EClass getObjectValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.object.ObjectValue#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectValue#getProperties()
	 * @see #getObjectValue()
	 * @generated
	 */
	EReference getObjectValue_Properties();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.PrimitiveTypeValue <em>Primitive Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Value</em>'.
	 * @see org.obeonetwork.dsl.object.PrimitiveTypeValue
	 * @generated
	 */
	EClass getPrimitiveTypeValue();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.PrimitiveTypeValue#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.obeonetwork.dsl.object.PrimitiveTypeValue#getData()
	 * @see #getPrimitiveTypeValue()
	 * @generated
	 */
	EAttribute getPrimitiveTypeValue_Data();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.LiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Value</em>'.
	 * @see org.obeonetwork.dsl.object.LiteralValue
	 * @generated
	 */
	EClass getLiteralValue();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.LiteralValue#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see org.obeonetwork.dsl.object.LiteralValue#getData()
	 * @see #getLiteralValue()
	 * @generated
	 */
	EReference getLiteralValue_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.LiteralValue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.object.LiteralValue#getName()
	 * @see #getLiteralValue()
	 * @generated
	 */
	EAttribute getLiteralValue_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.ObjectProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty
	 * @generated
	 */
	EClass getObjectProperty();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.ObjectProperty#getMetaProperty <em>Meta Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Property</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty#getMetaProperty()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_MetaProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.object.ObjectProperty#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty#getValues()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_Values();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.ObjectProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty#getName()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EAttribute getObjectProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.ObjectProperty#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty#getMultiplicity()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EAttribute getObjectProperty_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.ObjectProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectProperty#getValue()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EAttribute getObjectProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.ObjectContainmentProperty <em>Containment Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment Property</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectContainmentProperty
	 * @generated
	 */
	EClass getObjectContainmentProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.object.ObjectContainmentProperty#getContainedValues <em>Contained Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Values</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectContainmentProperty#getContainedValues()
	 * @see #getObjectContainmentProperty()
	 * @generated
	 */
	EReference getObjectContainmentProperty_ContainedValues();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.ObjectReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Property</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectReferenceProperty
	 * @generated
	 */
	EClass getObjectReferenceProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.object.ObjectReferenceProperty#getReferencedValues <em>Referenced Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Values</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectReferenceProperty#getReferencedValues()
	 * @see #getObjectReferenceProperty()
	 * @generated
	 */
	EReference getObjectReferenceProperty_ReferencedValues();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.Workspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace</em>'.
	 * @see org.obeonetwork.dsl.object.Workspace
	 * @generated
	 */
	EClass getWorkspace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.object.Workspace#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.obeonetwork.dsl.object.Workspace#getValues()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_Values();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.Workspace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.object.Workspace#getName()
	 * @see #getWorkspace()
	 * @generated
	 */
	EAttribute getWorkspace_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ObjectFactory getObjectFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.ValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Meta Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__META_TYPE = eINSTANCE.getValue_MetaType();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.DataTypeValueImpl <em>Data Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.DataTypeValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getDataTypeValue()
		 * @generated
		 */
		EClass DATA_TYPE_VALUE = eINSTANCE.getDataTypeValue();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.ObjectValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.ObjectValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectValue()
		 * @generated
		 */
		EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VALUE__PROPERTIES = eINSTANCE.getObjectValue_Properties();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.PrimitiveTypeValueImpl <em>Primitive Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.PrimitiveTypeValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPrimitiveTypeValue()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_VALUE = eINSTANCE.getPrimitiveTypeValue();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_VALUE__DATA = eINSTANCE.getPrimitiveTypeValue_Data();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.LiteralValueImpl <em>Literal Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.LiteralValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getLiteralValue()
		 * @generated
		 */
		EClass LITERAL_VALUE = eINSTANCE.getLiteralValue();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_VALUE__DATA = eINSTANCE.getLiteralValue_Data();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_VALUE__NAME = eINSTANCE.getLiteralValue_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.ObjectPropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.ObjectPropertyImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectProperty()
		 * @generated
		 */
		EClass OBJECT_PROPERTY = eINSTANCE.getObjectProperty();

		/**
		 * The meta object literal for the '<em><b>Meta Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROPERTY__META_PROPERTY = eINSTANCE.getObjectProperty_MetaProperty();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROPERTY__VALUES = eINSTANCE.getObjectProperty_Values();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_PROPERTY__NAME = eINSTANCE.getObjectProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_PROPERTY__MULTIPLICITY = eINSTANCE.getObjectProperty_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_PROPERTY__VALUE = eINSTANCE.getObjectProperty_Value();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.ObjectContainmentPropertyImpl <em>Containment Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.ObjectContainmentPropertyImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectContainmentProperty()
		 * @generated
		 */
		EClass OBJECT_CONTAINMENT_PROPERTY = eINSTANCE.getObjectContainmentProperty();

		/**
		 * The meta object literal for the '<em><b>Contained Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_CONTAINMENT_PROPERTY__CONTAINED_VALUES = eINSTANCE.getObjectContainmentProperty_ContainedValues();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.ObjectReferencePropertyImpl <em>Reference Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.ObjectReferencePropertyImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getObjectReferenceProperty()
		 * @generated
		 */
		EClass OBJECT_REFERENCE_PROPERTY = eINSTANCE.getObjectReferenceProperty();

		/**
		 * The meta object literal for the '<em><b>Referenced Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REFERENCE_PROPERTY__REFERENCED_VALUES = eINSTANCE.getObjectReferenceProperty_ReferencedValues();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.WorkspaceImpl <em>Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.WorkspaceImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getWorkspace()
		 * @generated
		 */
		EClass WORKSPACE = eINSTANCE.getWorkspace();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__VALUES = eINSTANCE.getWorkspace_Values();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE__NAME = eINSTANCE.getWorkspace_Name();

	}

} //ObjectPackage
