package org.obeonetwork.dsl.object.design.services;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PropertyContainedValue;
import org.obeonetwork.dsl.object.PropertyValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.EObjectUtils;

public class PropertyValueService {
	
	public static boolean isDataTypePropertyValue(PropertyValue propertyValue) {
		if(propertyValue.getMetaProperty() != null) {
			return propertyValue.getMetaProperty() instanceof Attribute;
		}
		
		if(!propertyValue.getValues().isEmpty()) {
			return propertyValue.getValues().get(0) instanceof DataTypeValue;
		}
		
		return false;
	}

	public static boolean isObjectPropertyValue(PropertyValue propertyValue) {
		if(propertyValue.getMetaProperty() != null) {
			return propertyValue.getMetaProperty() instanceof Reference;
		}
		
		if(!propertyValue.getValues().isEmpty()) {
			return propertyValue.getValues().get(0) instanceof ObjectValue;
		}
		
		return true;
	}

	public static PropertyValue replaceValue(PropertyValue property, Value sourceValue, Value targetValue) {
		EList<Value> values = property.getValues();
		int index = values.indexOf(sourceValue);
		values.remove(index);
		values.add(index, targetValue);
		
		if(property instanceof PropertyContainedValue) {
			Workspace workspace = EObjectUtils.getContainer(property, Workspace.class);
			workspace.getValues().add(sourceValue);
		}
		
		return property;
	}
	
}
