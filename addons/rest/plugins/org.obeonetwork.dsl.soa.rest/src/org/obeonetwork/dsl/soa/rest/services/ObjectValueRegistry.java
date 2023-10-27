package org.obeonetwork.dsl.soa.rest.services;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.edit.util.PrimitiveTypeValueService;

public class ObjectValueRegistry {

	private Map<StructuredType, Map<String, ObjectValue>> objectValuesRegistry = new HashMap<StructuredType, Map<String, ObjectValue>>();
	
	public ObjectValue registerOrGetDuplicateIfIdentifiable(ObjectValue objectValue) {
		String id = getId(objectValue);
		if(id != null) {
			StructuredType metaType = (StructuredType) objectValue.getMetaType();
			Map<String, ObjectValue> objectValuePerId = objectValuesRegistry.get(metaType);
			if(objectValuePerId == null) {
				objectValuePerId = new HashMap<>();
				objectValuesRegistry.put(metaType, objectValuePerId);
			}
			ObjectValue registeredObjectValue = objectValuePerId.get(id);
			if(registeredObjectValue == null) {
				objectValuePerId.put(id, objectValue);
				registeredObjectValue = objectValue;
			}
			return registeredObjectValue;
		}
		
		return objectValue;
	}

	public ObjectValue getObjectValueFromPrototype(ObjectValue objectValuePrototype) {
		String id = getId(objectValuePrototype);
		if(id != null) {
			StructuredType metaType = (StructuredType) objectValuePrototype.getMetaType();
			Map<String, ObjectValue> objectValuePerId = objectValuesRegistry.get(metaType);
			if(objectValuePerId != null) {
				return objectValuePerId.get(id);
			}
		}
		return null;
	}

	private boolean isIdentifiable(ObjectValue objectValue) {
		StructuredType metaType = (StructuredType) objectValue.getMetaType();
		if(metaType != null && metaType.getAttributes().stream()
				.anyMatch(attribute -> attribute.isIsIdentifier())) {
			Set<Attribute> metaTypeIdAttributes = metaType.getAttributes().stream()
			.filter(attribute -> attribute.isIsIdentifier())
			.collect(toSet());
			
			objectValue.getProperties().stream()
			.map(property -> property.getMetaProperty())
			.filter(Attribute.class::isInstance).map(Attribute.class::cast)
			.filter(attribute -> attribute.isIsIdentifier())
			.forEach(idAttribute -> metaTypeIdAttributes.remove(idAttribute));
			
			return metaTypeIdAttributes.isEmpty();
		}
		return false;
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

}
