package org.obeonetwork.dsl.object.design.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.object.DataTypeValue;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PropertyValue;

public class PropertyValueService {
	
	public static boolean isDataTypePropertyValue(PropertyValue propertyValue) {
		if(propertyValue.getMetaProperty() != null) {
			return propertyValue instanceof Attribute;
		}
		
		if(!propertyValue.getValues().isEmpty()) {
			return propertyValue.getValues().get(0) instanceof DataTypeValue;
		}
		
		return false;
	}

	public static boolean isObjectPropertyValue(PropertyValue propertyValue) {
		if(propertyValue.getMetaProperty() != null) {
			return propertyValue instanceof Reference;
		}
		
		if(!propertyValue.getValues().isEmpty()) {
			return propertyValue.getValues().get(0) instanceof ObjectValue;
		}
		
		return true;
	}

}
