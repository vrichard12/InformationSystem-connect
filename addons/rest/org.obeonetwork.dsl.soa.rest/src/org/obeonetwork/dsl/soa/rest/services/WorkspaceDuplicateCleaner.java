package org.obeonetwork.dsl.soa.rest.services;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.object.design.services.ObjectPropertyService;
import org.obeonetwork.dsl.object.edit.util.PrimitiveTypeValueService;

public class WorkspaceDuplicateCleaner {

	private Workspace workspace;

	private Map<StructuredType, Map<String, List<ObjectValue>>> duplicatesRegisrty = new HashMap<StructuredType, Map<String, List<ObjectValue>>>();
	
	public WorkspaceDuplicateCleaner(Workspace workspace) {
		this.workspace = workspace;
	}
	
	public void clean() {
		workspace.getValues().stream()
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
		.filter(objectValue -> isIdentifiable(objectValue))
		.forEach(objectValue -> declare(objectValue));
		
		duplicatesRegisrty.values().stream()
		.flatMap(idToValuesMap -> idToValuesMap.values().stream())
		.forEach(objectValues -> mergeProperties(objectValues));
		
		workspace.getValues().stream()
		.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
		.forEach(objectValue -> reconnectObjectProperties(objectValue));
		
		duplicatesRegisrty.values().stream()
		.flatMap(idToValuesMap -> idToValuesMap.values().stream())
		.forEach(objectValues -> removeDuplicates(objectValues));
		
	}
	
	private void declare(ObjectValue objectValue) {
		StructuredType metaType = (StructuredType)objectValue.getMetaType();
		Map<String, List<ObjectValue>> idToValuesMap = duplicatesRegisrty.get(metaType);
		if(idToValuesMap == null) {
			idToValuesMap = new HashMap<String, List<ObjectValue>>();
			duplicatesRegisrty.put(metaType, idToValuesMap);
		}
		
		String id = getId(objectValue);
		List<ObjectValue> objectValues = idToValuesMap.get(id);
		if(objectValues == null) {
			objectValues = new ArrayList<>();
			idToValuesMap.put(id, objectValues);
		}
		objectValues.add(objectValue);
	}

	private void mergeProperties(List<ObjectValue> objectValues) {
		Iterator<ObjectValue> objectValuesIterator = objectValues.iterator();
		ObjectValue uniqueObjectValue = objectValuesIterator.next();
		objectValuesIterator.forEachRemaining(duplicateObjectValue -> mergeProperties(uniqueObjectValue, duplicateObjectValue));
	}

	private void mergeProperties(ObjectValue uniqueObjectValue, ObjectValue duplicateObjectValue) {
		new ArrayList<>(duplicateObjectValue.getProperties()).forEach(otherProperty -> {
			if(uniqueObjectValue.getProperties().stream()
				.noneMatch(uniqueProperty -> 
				uniqueProperty.getMetaProperty() == otherProperty.getMetaProperty())) {
				uniqueObjectValue.getProperties().add(otherProperty);
			}
		});
	}

	private void reconnectObjectProperties(ObjectValue objectValue) {
		List<ObjectValue> objectValueDuplicates = getObjectValueDuplicates(objectValue);
		if(objectValueDuplicates != null && objectValue != objectValueDuplicates.get(0)) {
			return;
		}
		
		objectValue.getProperties().stream()
		.filter(property -> ObjectPropertyService.isObjectObjectProperty(property))
		.forEach(property -> {
			EList<Value> values = property.getValues();
			new ArrayList<>(values).stream()
			.filter(ObjectValue.class::isInstance).map(ObjectValue.class::cast)
			.forEach(referencedObjectValue -> {
				List<ObjectValue> referencedObjectValueDuplicates = getObjectValueDuplicates(referencedObjectValue);
				if(referencedObjectValueDuplicates != null && referencedObjectValue != referencedObjectValueDuplicates.get(0)) {
					int index = values.indexOf(referencedObjectValue);
					values.remove(index);
					values.add(index, referencedObjectValueDuplicates.get(0));
				}
			});
		});
	}
	
	private List<ObjectValue> getObjectValueDuplicates(ObjectValue objectValue) {
		List<ObjectValue> objectValueDuplicates = null;
		StructuredType metaType = (StructuredType)objectValue.getMetaType();
		if(metaType != null) {
			Map<String, List<ObjectValue>> idToValuesMap = duplicatesRegisrty.get(metaType);
			if(idToValuesMap != null) {
				String id = getId(objectValue);
				if(id != null) {
					objectValueDuplicates = idToValuesMap.get(id);
				}
			}
		}
		return objectValueDuplicates;
	}

	private boolean isIdentifiable(ObjectValue objectValue) {
		StructuredType metaType = (StructuredType) objectValue.getMetaType();
		return metaType != null && 
				metaType.getAttributes().stream()
				.anyMatch(attribute -> attribute.isIsIdentifier());
	}

	private String getId(ObjectValue objectValue) {
		if(isIdentifiable(objectValue)) {
			StructuredType metaType = (StructuredType) objectValue.getMetaType();
			return metaType.getAttributes().stream()
			.filter(attribute -> attribute.isIsIdentifier())
			.map(idAttribute -> idAttribute.getName() + "=" + valueToString(objectValue.getValue(idAttribute)))
			.collect(joining(","));
		}
		return null;
	}
	
	private String valueToString(Object value) {
		if(value instanceof List) {
			return ((List<?>)value).stream()
			.filter(DataTypeValue.class::isInstance).map(DataTypeValue.class::cast)
			.map(dataTypeValue -> dataTypeValueToString(dataTypeValue))
			.collect(joining(",", "{", "}"));
		} else if(value instanceof DataTypeValue) {
			return dataTypeValueToString((DataTypeValue) value);
		}
		return null;
	}

	private String dataTypeValueToString(DataTypeValue dataTypeValue) {
		if(dataTypeValue instanceof PrimitiveTypeValue) {
			return PrimitiveTypeValueService.getPrimitiveTypeDataAsString((PrimitiveTypeValue) dataTypeValue);
		}
		if(dataTypeValue instanceof LiteralValue) {
			return ((LiteralValue) dataTypeValue).getName();
		}
		return null;
	}

	private void removeDuplicates(List<ObjectValue> objectValues) {
		Iterator<ObjectValue> objectValuesIterator = objectValues.iterator();
		objectValuesIterator.next();
		objectValuesIterator.forEachRemaining(objectValue -> EcoreUtil.delete(objectValue));
	}

}
