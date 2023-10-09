package org.obeonetwork.dsl.soa.rest.services;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.object.edit.util.PrimitiveTypeValueService;
import org.obeonetwork.utils.common.StreamUtils;

public class Binder {

	private Workspace sourceWorkspace;
	private Workspace targetWorkspace;
	private BindingRegistry bindingRegistry;
	
	private Map<StructuredType, List<ObjectValue>> sourceObjectValuesPerType = new HashMap<>();
	private Map<BindingInfo, Map<ObjectValue, ObjectValue>> targetObjectValuesPerBindingAndSource = new HashMap<>();
	private ObjectValueRegistry targetObjectValueRegistry = new ObjectValueRegistry();
	
	public Binder(Workspace sourceWorkspace, Workspace targetWorkspace, BindingRegistry bindingRegistry) {
		this.sourceWorkspace = sourceWorkspace;
		this.targetWorkspace = targetWorkspace;
		this.bindingRegistry = bindingRegistry;
	}
	
	public void transform() {
		
		sourceWorkspace.getValues().stream()
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
		.flatMap(sourceObjectValue -> StreamUtils.closure(sourceObjectValue, this::streamContainedObjectValues))
		.filter(sourceObjectValue -> sourceObjectValue != null)
		.forEach(sourceObjectValue -> {
			StructuredType metaType = (StructuredType)sourceObjectValue.getMetaType();
			List<ObjectValue> sourceObjects = sourceObjectValuesPerType.get(metaType);
			if(sourceObjects == null) {
				sourceObjects = new ArrayList<>();
				sourceObjectValuesPerType.put(metaType, sourceObjects);
			}
			sourceObjects.add(sourceObjectValue);
		});
		
		bindingRegistry.getBindingInfos().stream()
		.filter(bindingInfo -> bindingInfo.getRight() instanceof StructuredType && bindingInfo.getLeft() instanceof StructuredType)
		.forEach(bindingInfo -> createObjectValues(bindingInfo));
		
		// 3- Appliquer les bindings de références aux objets sources et en interrogeant la binding registry avec
		//    des protorypes d'objets cibles pour trouver les objets cibles
		bindingRegistry.getBindingInfos().stream()
		.filter(bindingInfo -> bindingInfo.getRight() instanceof StructuredType && bindingInfo.getLeft() instanceof StructuredType)
		.forEach(bindingInfo -> createReferences(bindingInfo));
		
	}
	
	private Stream<ObjectValue> streamContainedObjectValues(ObjectValue objectValue) {
		return objectValue.getProperties().stream()
		.filter(ObjectContainmentProperty.class::isInstance).map(ObjectContainmentProperty.class::cast)
		.flatMap(objectContainmentProperty -> objectContainmentProperty.getContainedValues().stream())
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast);
	}

	private void createObjectValues(BindingInfo bindingInfo) {
		StructuredType sourceMetaType = (StructuredType) bindingInfo.getRight();
		List<ObjectValue> sourceObjectValues = sourceObjectValuesPerType.get(sourceMetaType);
		if(sourceObjectValues != null) {
			sourceObjectValues.forEach(sourceObjectValue -> createOrUpdateObjectValue(bindingInfo, sourceObjectValue));
		}
	}

	private void createOrUpdateObjectValue(BindingInfo bindingInfo, ObjectValue sourceObjectValue) {
		ObjectValue targetObjectValue = createIdentifiableObjectValue(bindingInfo, sourceObjectValue);
		
		targetObjectValue = targetObjectValueRegistry.registerOrGetDuplicateIfIdentifiable(targetObjectValue);
		if(!targetWorkspace.getValues().contains(targetObjectValue)) {
			targetWorkspace.getValues().add(targetObjectValue);
		}
		
		updateObjectProperties(bindingInfo, sourceObjectValue, targetObjectValue);
		
		Map<ObjectValue, ObjectValue> targetObjectValuePerSource = targetObjectValuesPerBindingAndSource.get(bindingInfo);
		if(targetObjectValuePerSource == null) {
			targetObjectValuePerSource = new HashMap<ObjectValue, ObjectValue>();
			targetObjectValuesPerBindingAndSource.put(bindingInfo, targetObjectValuePerSource);
		}
		targetObjectValuePerSource.put(sourceObjectValue, targetObjectValue);
	}

	private ObjectValue createIdentifiableObjectValue(BindingInfo bindingInfo, ObjectValue sourceObjectValue) {
		ObjectValue targetObjectValue = ObjectFactory.eINSTANCE.createObjectValue();
		targetObjectValue.setMetaType((StructuredType) bindingInfo.getLeft());
		
		bindingInfo.getReferences().stream()
		.filter(bindingReference -> 
				bindingReference.getLeft().getPathReferences().size() == 1 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute &&
				bindingReference.getRight().getPathReferences().size() == 1 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute
				&& ((Attribute)bindingReference.getLeft().getBoundElement()).isIsIdentifier())
		.forEach(bindingReference -> createObjectAttributeProperty(bindingReference, sourceObjectValue, targetObjectValue));
		
		return targetObjectValue;
	}

	private void updateObjectProperties(BindingInfo bindingInfo, ObjectValue sourceObjectValue, ObjectValue targetObjectValue) {
		List<Attribute> alreadyBoundMetaAttributes = targetObjectValue.getProperties().stream()
				.map(property -> property.getMetaProperty())
				.filter(Attribute.class::isInstance).map(Attribute.class::cast)
				.collect(toList());
		
		bindingInfo.getReferences().stream()
		.filter(bindingReference -> 
				bindingReference.getLeft().getPathReferences().size() == 1 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute &&
				bindingReference.getRight().getPathReferences().size() == 1 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute
				&& !alreadyBoundMetaAttributes.contains((Attribute)bindingReference.getRight().getBoundElement()))
		.forEach(bindingReference -> createObjectAttributeProperty(bindingReference, sourceObjectValue, targetObjectValue));
	}

	private void createObjectAttributeProperty(BindingReference bindingReference, ObjectValue sourceObjectValue, ObjectValue targetObjectValue) {
		Attribute sourceMetaAttribute = (Attribute) bindingReference.getRight().getBoundElement();
		Attribute targetMetaAttribute = (Attribute) bindingReference.getLeft().getBoundElement();
		String bindingExpression = bindingReference.getLeft().getBindingExpression();
		
		ObjectProperty sourceObjectProperty = sourceObjectValue.getProperties().stream()
		.filter(objectProperty -> objectProperty.getMetaProperty() == sourceMetaAttribute)
		.findAny().orElse(null);
		
		if(sourceObjectProperty != null) {
			// Attributes instantiates as containment properties
			ObjectContainmentProperty targetObjectProperty = ObjectFactory.eINSTANCE.createObjectContainmentProperty();
			targetObjectProperty.setMetaProperty(targetMetaAttribute);
			targetObjectValue.getProperties().add(targetObjectProperty);
			
			// TODO Exploit the binding expression
			sourceObjectProperty.getValues().stream()
			.map(value -> cloneDataTypeValue((DataTypeValue) value))
			.forEach(dataTypeValue -> targetObjectProperty.getContainedValues().add(dataTypeValue));
		}
	}
	
	private DataTypeValue cloneDataTypeValue(DataTypeValue sourceDataTypeValue) {
		if(sourceDataTypeValue instanceof PrimitiveTypeValue) {
			return clonePrimitiveTypeValue((PrimitiveTypeValue)sourceDataTypeValue);
		}
		
		if(sourceDataTypeValue instanceof LiteralValue) {
			return cloneLiteralValue((LiteralValue)sourceDataTypeValue);
		}
		
		return null;
	}

	private PrimitiveTypeValue clonePrimitiveTypeValue(PrimitiveTypeValue sourcePrimitiveTypeValue) {
		PrimitiveTypeValue targetPrimitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
		targetPrimitiveTypeValue.setMetaType(sourcePrimitiveTypeValue.getMetaType());
		String dataAsString = PrimitiveTypeValueService.getPrimitiveTypeDataAsString(sourcePrimitiveTypeValue);
		PrimitiveTypeValueService.setPrimitiveTypeDataAsString(targetPrimitiveTypeValue, dataAsString);
		
		return targetPrimitiveTypeValue;
	}

	private LiteralValue cloneLiteralValue(LiteralValue sourceLiteralValue) {
		LiteralValue targetLiteralValue = ObjectFactory.eINSTANCE.createLiteralValue();
		targetLiteralValue.setMetaType(sourceLiteralValue.getMetaType());
		targetLiteralValue.setData(sourceLiteralValue.getData());
		
		return targetLiteralValue;
	}

	private void createReferences(BindingInfo bindingInfo) {
		StructuredType sourceMetaType = (StructuredType) bindingInfo.getRight();
		List<ObjectValue> sourceObjectValues = sourceObjectValuesPerType.get(sourceMetaType);
		if(sourceObjectValues != null) {
			sourceObjectValues.forEach(sourceObjectValue -> createReferences(bindingInfo, sourceObjectValue));
		}
	}

	private void createReferences(BindingInfo bindingInfo, ObjectValue sourceObjectValue) {
		ObjectValue targetObjectValue = targetObjectValuesPerBindingAndSource.get(bindingInfo).get(sourceObjectValue);
		
		Map<Reference, List<BindingReference>> bindingReferencesPerSourceReference = new HashMap<>();
		
		bindingInfo.getReferences().stream()
		.filter(bindingReference -> 
				bindingReference.getLeft().getPathReferences().size() > 0 &&
				getFullPathReferences(bindingReference.getLeft()).get(1) instanceof Reference &&
				bindingReference.getRight().getPathReferences().size() > 0 &&
				getFullPathReferences(bindingReference.getRight()).get(1) instanceof Reference)
		.forEach(bindingReference -> {
			Reference sourceReference = (Reference) getFullPathReferences(bindingReference.getRight()).get(1);
			List<BindingReference> bindingReferences = bindingReferencesPerSourceReference.get(sourceReference);
			if(bindingReferences == null) {
				bindingReferences = new ArrayList<>();
				bindingReferencesPerSourceReference.put(sourceReference, bindingReferences);
			}
			bindingReferences.add(bindingReference);
		});
		
		bindingReferencesPerSourceReference.values().stream()
		.forEach(bindingReferences -> createObjectReference(bindingReferences, sourceObjectValue, targetObjectValue));
		
	}

	private void createObjectReference(List<BindingReference> bindingReferences, ObjectValue sourceObjectValue, ObjectValue targetObjectValue) {
		
		Reference targetReference = (Reference) getFullPathReferences(bindingReferences.get(0).getLeft()).get(1);
		if(targetObjectValue.getProperties().stream()
				.anyMatch(property -> property.getMetaProperty() == targetReference)) {
			return;
		}
		ObjectProperty targetObjectProperty = createObjectReferenceProperty(targetObjectValue, targetReference);
		
		Reference sourceReference = (Reference) getFullPathReferences(bindingReferences.get(0).getRight()).get(1);
		ObjectProperty sourceObjectProperty = sourceObjectValue.getProperties().stream()
		.filter(property -> property.getMetaProperty() == sourceReference)
		.findAny().orElse(null);
		
		if(bindingReferences.stream()
				.noneMatch(bindingReference -> 
				bindingReference.getRight().getPathReferences().size() == 2 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute &&
				bindingReference.getLeft().getPathReferences().size() == 2 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute)) {
			System.out.println("[ERROR] Binding definition model not valid.");
			return;
		}
		
		sourceObjectProperty.getValues().stream()
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
		.map(referencedSourceObjectValue -> getReferencedTargetObjectValue(referencedSourceObjectValue, bindingReferences))
		.filter(referencedTargetObjectValue -> referencedTargetObjectValue != null)
		.forEach(referencedTargetObjectValue -> targetObjectProperty.getValues().add(referencedTargetObjectValue));
	}

	private ObjectValue getReferencedTargetObjectValue(ObjectValue referencedSourceObjectValue, List<BindingReference> bindingReferences) {
		ObjectValue referencedTargetObjectValuePrototype = ObjectFactory.eINSTANCE.createObjectValue();
		Reference targetReference = (Reference) getFullPathReferences(bindingReferences.get(0).getLeft()).get(1);
		StructuredType targetReferencedMetaType = targetReference.getReferencedType();
		referencedTargetObjectValuePrototype.setMetaType(targetReferencedMetaType);
		
		bindingReferences.stream()
		.filter(bindingReference -> 
				bindingReference.getRight().getPathReferences().size() == 2 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute &&
				bindingReference.getLeft().getPathReferences().size() == 2 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute)
		.forEach(bindingReference -> createObjectAttributeProperty(bindingReference, referencedSourceObjectValue, referencedTargetObjectValuePrototype));
		
		ObjectValue referencedTargetObjectValue = targetObjectValueRegistry.getObjectValueFromPrototype(referencedTargetObjectValuePrototype);
		return referencedTargetObjectValue;
	}

	private ObjectProperty createObjectReferenceProperty(ObjectValue targetObjectValue, Reference reference) {
		ObjectProperty targetObjectProperty = (reference.isIsComposite())?
					ObjectFactory.eINSTANCE.createObjectContainmentProperty() :
					ObjectFactory.eINSTANCE.createObjectReferenceProperty();
		targetObjectProperty.setMetaProperty(reference);
		targetObjectValue.getProperties().add(targetObjectProperty);
		
		return targetObjectProperty;
	}

	private List<BoundableElement> getFullPathReferences(BindingElement bindingElement) {
		List<BoundableElement> fullPathReferences = new ArrayList<>(bindingElement.getPathReferences());
		fullPathReferences.add(bindingElement.getBoundElement());
		return fullPathReferences;
	}
	
}
