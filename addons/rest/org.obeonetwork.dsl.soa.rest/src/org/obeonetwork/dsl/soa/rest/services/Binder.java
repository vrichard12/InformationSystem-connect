package org.obeonetwork.dsl.soa.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.Property;
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
	
	private Map<ObjectValue, ObjectValue> objects = new HashMap<>();
	
	public Binder(Workspace sourceWorkspace, Workspace targetWorkspace, BindingRegistry bindingRegistry) {
		this.sourceWorkspace = sourceWorkspace;
		this.targetWorkspace = targetWorkspace;
		this.bindingRegistry = bindingRegistry;
	}

	public void transform() {
		
		sourceWorkspace.getValues().stream()
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
		.flatMap(sourceObjectValue -> StreamUtils.closure(sourceObjectValue, this::streamContainedObjectValues))
		.forEach(sourceObjectValue -> createObjectValueIfBound(sourceObjectValue));
		
		objects.keySet().forEach(sourceObjectValue -> createObjectAttributeProperties(sourceObjectValue));
		
		objects.keySet().forEach(sourceObjectValue -> createObjectReferenceProperties(sourceObjectValue));
		
	}
	
	private void createObjectAttributeProperties(ObjectValue sourceObjectValue) {
		BindingInfo bindingInfo = getBindingInfoFromSourceMetaType((StructuredType) sourceObjectValue.getMetaType());
		
		bindingInfo.getReferences().stream()
		.filter(bindingReference -> 
				bindingReference.getLeft().getPathReferences().size() == 1 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute &&
				bindingReference.getRight().getPathReferences().size() == 1 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute)
		.forEach(bindingReference -> createObjectAttributeProperty(sourceObjectValue, bindingReference));
	}

	private ObjectContainmentProperty createObjectAttributeProperty(ObjectValue sourceObjectValue, BindingReference bindingReference) {
		
		ObjectProperty sourceObjectProperty = sourceObjectValue.getProperties().stream()
		.filter(p -> p.getMetaProperty() == bindingReference.getRight().getBoundElement())
		.findAny().orElse(null);
		
		if(sourceObjectProperty != null) {
			ObjectValue targetObjectValue = objects.get(sourceObjectValue);
			
			// Attributes instantiates as containment properties
			ObjectContainmentProperty targetObjectProperty = ObjectFactory.eINSTANCE.createObjectContainmentProperty();
			targetObjectProperty.setMetaProperty((Property) bindingReference.getLeft().getBoundElement());
			targetObjectValue.getProperties().add(targetObjectProperty);
			
			// TODO Exploit the binding expression
			sourceObjectProperty.getValues().stream()
			.map(value -> cloneDataTypeValue((DataTypeValue) value))
			.forEach(dataTypeValue -> targetObjectProperty.getContainedValues().add(dataTypeValue));
			
			return targetObjectProperty;
		}
		
		return null;
	}

	private void createObjectReferenceProperties(ObjectValue sourceObjectValue) {
		BindingInfo bindingInfo = getBindingInfoFromSourceMetaType((StructuredType) sourceObjectValue.getMetaType());
		
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
		.forEach(bindingReferences -> createObjectReferenceProperty(sourceObjectValue, bindingReferences));
	}

	private ObjectProperty createObjectReferenceProperty(ObjectValue sourceObjectValue, List<BindingReference> bindingReferences) {
		Reference sourceReference = (Reference) getFullPathReferences(bindingReferences.get(0).getRight()).get(1);
		ObjectProperty sourceObjectProperty = sourceObjectValue.getProperties().stream()
		.filter(property -> property.getMetaProperty() == sourceReference)
		.findAny().orElse(null);
		
		Reference targetReference = (Reference) getFullPathReferences(bindingReferences.get(0).getLeft()).get(1);
		ObjectProperty targetObjectProperty = createObjectReferenceProperty(sourceObjectValue, targetReference);
		
		// For now only two binding cases are handled for references.
		// Other cases might come up in the future.
		
		// Case 1 : The source relationship only is bound to its counterpart in the target structured 
		// type model.
		// In this case, the target referenced objects are straightforwardly mapped from their 
		// source counterparts.
		if(bindingReferences.size() == 1 && 
			bindingReferences.get(0).getRight().getPathReferences().size() == 1 &&
			bindingReferences.get(0).getLeft().getPathReferences().size() == 1) {
			
			sourceObjectProperty.getValues().stream()
			.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
			.map(referencedSourceObjectValue -> objects.get(referencedSourceObjectValue))
			.forEach(referencedTargetObjectValue -> targetObjectProperty.getValues().add(referencedTargetObjectValue));
		}
		
		// Case 2 : Attributes (and only Attributes) of the targeted type in the source relationship 
		// are bound to their counterparts in the target structured type model.
		else if(bindingReferences.stream()
				.allMatch(bindingReference -> 
				(bindingReference.getRight().getPathReferences().size() == 1 || 
				(bindingReference.getRight().getPathReferences().size() == 2 &&
				bindingReference.getRight().getBoundElement() instanceof Attribute)) &&
				(bindingReference.getLeft().getPathReferences().size() == 1 || 
				(bindingReference.getLeft().getPathReferences().size() == 2 &&
				bindingReference.getLeft().getBoundElement() instanceof Attribute)))) {
			
			sourceObjectProperty.getValues().stream()
			.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
			.map(referencedSourceObjectValue -> getReferencedTargetObjectValue(referencedSourceObjectValue, bindingReferences))
			.filter(referencedTargetObjectValue -> referencedTargetObjectValue != null)
			.forEach(referencedTargetObjectValue -> targetObjectProperty.getValues().add(referencedTargetObjectValue));
		}
		
		// Other cases
		else {
			System.out.println("[ERROR] Binding definition model is not valid.");
		}
		
		return targetObjectProperty;
	}

	private ObjectValue getReferencedTargetObjectValue(ObjectValue referencedSourceObjectValue, List<BindingReference> bindingReferences) {
		// Try our best guess
		if(match(referencedSourceObjectValue, objects.get(referencedSourceObjectValue), bindingReferences)) {
			return objects.get(referencedSourceObjectValue);
		}
		
		// Or else look into all the target ObjectValues
		return objects.values().stream()
				.filter(targetObjectValue -> match(referencedSourceObjectValue, targetObjectValue, bindingReferences))
				.findAny().orElse(null);
	}

	private boolean match(ObjectValue referencedSourceObjectValue, ObjectValue targetObjectValue, List<BindingReference> bindingReferences) {
		Reference targetReference = (Reference) getFullPathReferences(bindingReferences.get(0).getLeft()).get(1);
		StructuredType targetReferencedMetaType = targetReference.getReferencedType();
		if(!((StructuredType)targetObjectValue.getMetaType()).isSubtypeOf(targetReferencedMetaType)) {
			return false;
		}
		
		return bindingReferences.stream()
		.filter(bindingReference -> 
				bindingReference.getRight().getPathReferences().size() == 2 &&
				bindingReference.getLeft().getPathReferences().size() == 2)
		.allMatch(bindingReference -> {
			Attribute sourceAttribute = (Attribute) bindingReference.getRight().getBoundElement();
			Attribute targetAttribute = (Attribute) bindingReference.getLeft().getBoundElement();
			Object sourceAttributeValue = referencedSourceObjectValue.getValue(sourceAttribute);
			Object targetAttributeValue = targetObjectValue.getValue(targetAttribute);
			
			// TODO Exploit the binding expression
			return attributeValueEquals(sourceAttributeValue, targetAttributeValue);
		});
	}

	private boolean attributeValueEquals(Object sourceAttributeValue, Object targetAttributeValue) {
		if(sourceAttributeValue instanceof List && targetAttributeValue instanceof List) {
			List<?> sourceAttributeValueList = (List<?>) sourceAttributeValue;
			List<?> targetAttributeValueList = (List<?>) targetAttributeValue;
			boolean equals = sourceAttributeValueList.size() == targetAttributeValueList.size();
			Iterator<?> sourceAttributeValueIterator = sourceAttributeValueList.iterator();
			Iterator<?> targetAttributeValueIterator = targetAttributeValueList.iterator();
			while(equals && sourceAttributeValueIterator.hasNext()) {
				DataTypeValue sourceValue = (DataTypeValue) sourceAttributeValueIterator.next();
				DataTypeValue targetValue = (DataTypeValue) targetAttributeValueIterator.next();
				equals = equals && dataTypeValueEquals(sourceValue, targetValue);
			}
			return equals;
		}
		
		return dataTypeValueEquals((DataTypeValue)sourceAttributeValue, (DataTypeValue)targetAttributeValue);
	}

	private boolean dataTypeValueEquals(DataTypeValue sourceValue, DataTypeValue targetValue) {
		if(sourceValue instanceof PrimitiveTypeValue && targetValue instanceof PrimitiveTypeValue) {
			return primitiveTypeValueEquals((PrimitiveTypeValue)sourceValue, (PrimitiveTypeValue)targetValue);
		}
		if(sourceValue instanceof LiteralValue && targetValue instanceof LiteralValue) {
			return literalValueEquals((LiteralValue)sourceValue, (LiteralValue)targetValue);
		}
		return false;
	}

	private boolean primitiveTypeValueEquals(PrimitiveTypeValue sourceValue, PrimitiveTypeValue targetValue) {
		return Objects.equals(
				PrimitiveTypeValueService.getPrimitiveTypeDataAsString(sourceValue), 
				PrimitiveTypeValueService.getPrimitiveTypeDataAsString(targetValue));
	}

	private boolean literalValueEquals(LiteralValue sourceValue, LiteralValue targetValue) {
		return Objects.equals(
				sourceValue.getData().getName(), 
				targetValue.getData().getName());
	}

	private List<BoundableElement> getFullPathReferences(BindingElement bindingElement) {
		List<BoundableElement> fullPathReferences = new ArrayList<>(bindingElement.getPathReferences());
		fullPathReferences.add(bindingElement.getBoundElement());
		return fullPathReferences;
	}
	
	private ObjectProperty createObjectReferenceProperty(ObjectValue sourceObjectValue, Reference reference) {
		ObjectProperty targetObjectProperty = (reference.isIsComposite())?
					ObjectFactory.eINSTANCE.createObjectContainmentProperty() :
					ObjectFactory.eINSTANCE.createObjectReferenceProperty();
		targetObjectProperty.setMetaProperty(reference);
		ObjectValue targetObjectValue = objects.get(sourceObjectValue);
		targetObjectValue.getProperties().add(targetObjectProperty);
		
		return targetObjectProperty;
	}

	private BindingInfo getBindingInfoFromSourceMetaType(StructuredType sourceMetaType) {
		return bindingRegistry.getBindingInfos().stream()
		.filter(bi -> bi.getRight() == sourceMetaType)
		.findFirst().orElse(null);
	}

	private Stream<ObjectValue> streamContainedObjectValues(ObjectValue objectValue) {
		return objectValue.getProperties().stream()
		.filter(ObjectContainmentProperty.class::isInstance).map(ObjectContainmentProperty.class::cast)
		.flatMap(objectContainmentProperty -> objectContainmentProperty.getContainedValues().stream())
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast);
	}

	private ObjectValue createObjectValueIfBound(ObjectValue sourceObjectValue) {
		ObjectValue targetObjectValue = null;
		BindingInfo bindingInfo = getBindingInfoFromSourceMetaType((StructuredType) sourceObjectValue.getMetaType());
		if(bindingInfo != null) {
			targetObjectValue = ObjectFactory.eINSTANCE.createObjectValue();
			targetObjectValue.setMetaType((StructuredType) bindingInfo.getLeft());
			targetWorkspace.getValues().add(targetObjectValue);
			objects.put(sourceObjectValue, targetObjectValue);
		}
		
		return targetObjectValue;
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

}
