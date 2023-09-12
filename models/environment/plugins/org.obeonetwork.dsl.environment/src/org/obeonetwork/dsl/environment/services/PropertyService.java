package org.obeonetwork.dsl.environment.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;

public class PropertyService {

	public static Type getType(Property property) {
		if(property instanceof Attribute) {
			return ((Attribute) property).getType();
		}
		if(property instanceof Reference) {
			return ((Reference) property).getReferencedType();
		}
		return null;
	}
	
}
