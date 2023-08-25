package org.obeonetwork.dsl.object.design.services;

import org.obeonetwork.dsl.object.PropertyContainedValue;
import org.obeonetwork.dsl.object.PropertyReferencedValue;
import org.obeonetwork.dsl.object.PropertyValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.EObjectUtils;

public class ValueService {

	public static Value moveValue(Value value, PropertyValue sourceProperty, PropertyValue targetProperty) {
		Workspace workspace = EObjectUtils.getContainer(targetProperty, Workspace.class);
		
		if(targetProperty instanceof PropertyContainedValue && !targetProperty.isMultiple() && targetProperty.getValue() != null) {
			workspace.getValues().add((Value) targetProperty.getValue());
		}
		
		sourceProperty.unsetValue(value);
		targetProperty.setValue(value);
		
		if(sourceProperty instanceof PropertyContainedValue && targetProperty instanceof PropertyReferencedValue) {
			workspace.getValues().add(value);
		}
		
		return value;
	}
	
}
