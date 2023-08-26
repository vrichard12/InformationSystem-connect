package org.obeonetwork.dsl.object.design.services;

import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectReferenceProperty;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.EObjectUtils;

public class ValueService {

	public static Value moveValue(Value value, ObjectProperty sourceProperty, ObjectProperty targetProperty) {
		Workspace workspace = EObjectUtils.getContainer(targetProperty, Workspace.class);
		
		if(targetProperty instanceof ObjectContainmentProperty && !targetProperty.isMultiple() && targetProperty.getValue() != null) {
			workspace.getValues().add((Value) targetProperty.getValue());
		}
		
		sourceProperty.unsetValue(value);
		targetProperty.setValue(value);
		
		if(sourceProperty instanceof ObjectContainmentProperty && targetProperty instanceof ObjectReferenceProperty) {
			workspace.getValues().add(value);
		}
		
		return value;
	}
	
}
