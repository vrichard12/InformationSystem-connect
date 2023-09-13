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
package org.obeonetwork.dsl.interaction.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

import org.obeonetwork.dsl.interaction.ByValueParameterValue;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.InteractionPackage;

import org.obeonetwork.dsl.object.ObjectFactory;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.interaction.ByValueParameterValue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ByValueParameterValueItemProvider extends ParameterValueItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByValueParameterValueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ByValueParameterValue.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ByValueParameterValue"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ByValueParameterValue)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ByValueParameterValue_type") :
			getString("_UI_ByValueParameterValue_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ByValueParameterValue.class)) {
			case InteractionPackage.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createInteraction()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createParticipant()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createExecution()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createCreateParticipantMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createDestroyParticipantMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createReturnMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createStateInvariant()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createInteractionUse()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createEnd()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createCombinedFragment()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createOperand()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createCallMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createCompoundEnd()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createByReferenceParameterValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createByValueParameterValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 InteractionFactory.eINSTANCE.createComputedParameterValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createEnvironment()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createInterDSMLink()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createMetaDataContainer()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createPriorityDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createPriority()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createTypesDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createDTO()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createFilterContainer()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createNamespace()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createBindingInfo()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createBindingReference()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createBindingElement()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 EnvironmentFactory.eINSTANCE.createBindingRegistry()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 ObjectFactory.eINSTANCE.createObjectValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 ObjectFactory.eINSTANCE.createPrimitiveTypeValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 ObjectFactory.eINSTANCE.createLiteralValue()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE,
				 ObjectFactory.eINSTANCE.createWorkspace()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EnvironmentPackage.Literals.OBEO_DSM_OBJECT__METADATAS ||
			childFeature == InteractionPackage.Literals.BY_VALUE_PARAMETER_VALUE__CONTAINED_VALUE ||
			childFeature == EnvironmentPackage.Literals.OBEO_DSM_OBJECT__BEHAVIOURS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
