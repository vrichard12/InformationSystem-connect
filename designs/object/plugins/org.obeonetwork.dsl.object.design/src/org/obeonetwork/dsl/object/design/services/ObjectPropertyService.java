package org.obeonetwork.dsl.object.design.services;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.EObjectUtils;

public class ObjectPropertyService {
	
	public static boolean isDataTypeObjectProperty(ObjectProperty property) {
		if(property.getMetaProperty() != null) {
			return property.getMetaProperty() instanceof Attribute;
		}
		
		if(!property.getValues().isEmpty()) {
			return property.getValues().get(0) instanceof DataTypeValue;
		}
		
		return false;
	}

	public static boolean isObjectObjectProperty(ObjectProperty property) {
		if(property.getMetaProperty() != null) {
			return property.getMetaProperty() instanceof Reference;
		}
		
		if(!property.getValues().isEmpty()) {
			return property.getValues().get(0) instanceof ObjectValue;
		}
		
		return true;
	}

	public static ObjectProperty replaceValue(ObjectProperty property, Value sourceValue, Value targetValue) {
		EList<Value> values = property.getValues();
		int index = values.indexOf(sourceValue);
		values.remove(index);
		values.add(index, targetValue);
		
		if(property instanceof ObjectContainmentProperty) {
			Workspace workspace = EObjectUtils.getContainer(property, Workspace.class);
			workspace.getValues().add(sourceValue);
		}
		
		return property;
	}
	
	public static ObjectProperty deleteValueEdge(ObjectProperty property, Value value) {
		property.unsetValue(value);
		
		if(property instanceof ObjectContainmentProperty) {
			Workspace workspace = EObjectUtils.getContainer(property, Workspace.class);
			workspace.getValues().add(value);
		}
		
		return property;
	}
	
}
