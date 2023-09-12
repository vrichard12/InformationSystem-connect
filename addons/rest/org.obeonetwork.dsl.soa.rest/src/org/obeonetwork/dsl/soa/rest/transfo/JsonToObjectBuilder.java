package org.obeonetwork.dsl.soa.rest.transfo;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.services.PropertyService;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.StreamUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public class JsonToObjectBuilder {

	private JsonNode json;
	private StructuredType structuredType;
	private Workspace workspace;
	
	private List<Value> newValues = new ArrayList<>();

	public JsonToObjectBuilder(JsonNode json, StructuredType structuredType, Workspace workspace) {
		this.json = json;
		this.structuredType = structuredType;
		this.workspace = workspace;
	}
	
	public void build() {
		buildValue(json, structuredType);
		
		newValues.stream()
		.filter(v -> v.eContainer() == null)
		.forEach(v -> workspace.getValues().add(v));
	}

	private Object buildValue(JsonNode jsonNode, Type targetType) {
		if(jsonNode.isArray()) {
			return StreamUtils.asStream(((ArrayNode) jsonNode).elements())
			.map(arrayElement -> buildValue(arrayElement, targetType))
			.collect(toList());
		} 
		
		if(jsonNode.isObject()) {
			ObjectValue objectValue = buildObject((ObjectNode) jsonNode, (StructuredType)targetType);
			newValues.add(objectValue);
			return objectValue;
		} 
		
		if(jsonNode.isValueNode()) {
			DataTypeValue dataTypeValue = buildDataType((ValueNode) jsonNode, targetType);
			newValues.add(dataTypeValue);
			return dataTypeValue;
		}
		
		logWarning("Unsupported JsonNode type : " + jsonNode.getClass().getName());
		return null;
	}

	private ObjectValue buildObject(ObjectNode objectNode, StructuredType targetType) {
		ObjectValue objectValue = ObjectFactory.eINSTANCE.createObjectValue();
		objectValue.setMetaType(targetType);
		objectNode.fieldNames().forEachRemaining(fieldName -> {
			JsonNode fieldValue = objectNode.get(fieldName);
			Object value = buildValue(fieldValue, getPropertyType(targetType, fieldName));
			objectValue.setValue(fieldName, value);
		});
		
		return objectValue;
	}
	
	private Type getPropertyType(StructuredType targetType, String fieldName) {
		Type propertyType = null;
		if(targetType != null && fieldName != null) {
			propertyType = targetType.getProperties().stream()
			.filter(p -> fieldName.equals(p.getName()))
			.map(p -> PropertyService.getType(p))
			.findFirst().orElse(null);
		}
		
		return propertyType;
	}

	private DataTypeValue buildDataType(ValueNode valueNode, Type targetType) {
		if(valueNode instanceof BinaryNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.toString());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof BooleanNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asBoolean());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof NullNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof TextNode) {
			// Date, Time and Timestamp are handled as Strings
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			if(targetType instanceof Enumeration) {
				Literal literal = ((Enumeration) targetType).getLiterals().stream()
				.filter(lit -> lit.getName().equals(valueNode.asText()))
				.findFirst().orElse(null);
				if(literal != null) {
					primitiveTypeValue.setData(literal);
				} else {
					primitiveTypeValue.setData(valueNode.asText());
				}
			} else {
				primitiveTypeValue.setData(valueNode.asText());
			}
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof BigIntegerNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(new BigInteger(valueNode.asText()));
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof DecimalNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asDouble());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof DoubleNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asDouble());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof FloatNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asLong());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof IntNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asInt());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof LongNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asLong());
			return primitiveTypeValue;
		}
		
		if(valueNode instanceof ShortNode) {
			PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
			primitiveTypeValue.setMetaType(targetType);
			primitiveTypeValue.setData(valueNode.asInt());
			return primitiveTypeValue;
		}
		
		// Not handled : MissingNode, POJONode
		logWarning("Unsupported ValueNode type : " + valueNode.getClass().getName());
		return null;
	}

	private void logWarning(String message) {
		// TODO Auto-generated method stub
		System.out.println("[WARNING] " + message);
	}

}
