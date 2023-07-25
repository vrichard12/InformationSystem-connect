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
	 * The feature id for the '<em><b>Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE__PROPERTY_VALUES = VALUE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_VALUE__VALUE = DATA_TYPE_VALUE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__LITERAL = DATA_TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_FEATURE_COUNT = DATA_TYPE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl <em>Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.PropertyValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyValue()
	 * @generated
	 */
	int PROPERTY_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__META_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.PropertyContainedValueImpl <em>Property Contained Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.PropertyContainedValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyContainedValue()
	 * @generated
	 */
	int PROPERTY_CONTAINED_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINED_VALUE__META_PROPERTY = PROPERTY_VALUE__META_PROPERTY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINED_VALUE__VALUE = PROPERTY_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINED_VALUE__NAME = PROPERTY_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Contained Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE = PROPERTY_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Contained Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINED_VALUE_FEATURE_COUNT = PROPERTY_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.object.impl.PropertyReferencedValueImpl <em>Property Referenced Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.object.impl.PropertyReferencedValueImpl
	 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyReferencedValue()
	 * @generated
	 */
	int PROPERTY_REFERENCED_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Meta Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCED_VALUE__META_PROPERTY = PROPERTY_VALUE__META_PROPERTY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCED_VALUE__VALUE = PROPERTY_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCED_VALUE__NAME = PROPERTY_VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Referenced Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE = PROPERTY_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Referenced Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCED_VALUE_FEATURE_COUNT = PROPERTY_VALUE_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = EnvironmentPackage.OBEO_DSM_OBJECT_FEATURE_COUNT + 1;


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
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.object.ObjectValue#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Values</em>'.
	 * @see org.obeonetwork.dsl.object.ObjectValue#getPropertyValues()
	 * @see #getObjectValue()
	 * @generated
	 */
	EReference getObjectValue_PropertyValues();

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
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.PrimitiveTypeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.object.PrimitiveTypeValue#getValue()
	 * @see #getPrimitiveTypeValue()
	 * @generated
	 */
	EAttribute getPrimitiveTypeValue_Value();

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
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.LiteralValue#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see org.obeonetwork.dsl.object.LiteralValue#getLiteral()
	 * @see #getLiteralValue()
	 * @generated
	 */
	EReference getLiteralValue_Literal();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyValue
	 * @generated
	 */
	EClass getPropertyValue();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.PropertyValue#getMetaProperty <em>Meta Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Property</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyValue#getMetaProperty()
	 * @see #getPropertyValue()
	 * @generated
	 */
	EReference getPropertyValue_MetaProperty();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.PropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyValue#getValue()
	 * @see #getPropertyValue()
	 * @generated
	 */
	EReference getPropertyValue_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.object.PropertyValue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyValue#getName()
	 * @see #getPropertyValue()
	 * @generated
	 */
	EAttribute getPropertyValue_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.PropertyContainedValue <em>Property Contained Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Contained Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyContainedValue
	 * @generated
	 */
	EClass getPropertyContainedValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.object.PropertyContainedValue#getContainedValue <em>Contained Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyContainedValue#getContainedValue()
	 * @see #getPropertyContainedValue()
	 * @generated
	 */
	EReference getPropertyContainedValue_ContainedValue();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.object.PropertyReferencedValue <em>Property Referenced Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Referenced Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyReferencedValue
	 * @generated
	 */
	EClass getPropertyReferencedValue();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.object.PropertyReferencedValue#getReferencedValue <em>Referenced Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Value</em>'.
	 * @see org.obeonetwork.dsl.object.PropertyReferencedValue#getReferencedValue()
	 * @see #getPropertyReferencedValue()
	 * @generated
	 */
	EReference getPropertyReferencedValue_ReferencedValue();

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
		 * The meta object literal for the '<em><b>Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VALUE__PROPERTY_VALUES = eINSTANCE.getObjectValue_PropertyValues();

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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_VALUE__VALUE = eINSTANCE.getPrimitiveTypeValue_Value();

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
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL_VALUE__LITERAL = eINSTANCE.getLiteralValue_Literal();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.PropertyValueImpl <em>Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.PropertyValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyValue()
		 * @generated
		 */
		EClass PROPERTY_VALUE = eINSTANCE.getPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Meta Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE__META_PROPERTY = eINSTANCE.getPropertyValue_MetaProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_VALUE__VALUE = eINSTANCE.getPropertyValue_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_VALUE__NAME = eINSTANCE.getPropertyValue_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.PropertyContainedValueImpl <em>Property Contained Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.PropertyContainedValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyContainedValue()
		 * @generated
		 */
		EClass PROPERTY_CONTAINED_VALUE = eINSTANCE.getPropertyContainedValue();

		/**
		 * The meta object literal for the '<em><b>Contained Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTAINED_VALUE__CONTAINED_VALUE = eINSTANCE.getPropertyContainedValue_ContainedValue();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.object.impl.PropertyReferencedValueImpl <em>Property Referenced Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.object.impl.PropertyReferencedValueImpl
		 * @see org.obeonetwork.dsl.object.impl.ObjectPackageImpl#getPropertyReferencedValue()
		 * @generated
		 */
		EClass PROPERTY_REFERENCED_VALUE = eINSTANCE.getPropertyReferencedValue();

		/**
		 * The meta object literal for the '<em><b>Referenced Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_REFERENCED_VALUE__REFERENCED_VALUE = eINSTANCE.getPropertyReferencedValue_ReferencedValue();

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

	}

} //ObjectPackage
