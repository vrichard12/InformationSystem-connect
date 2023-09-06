package org.obeonetwork.dsl.environment.services;

import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class ObeoDSMObjectService {

	public static String getAnnotationValue(ObeoDSMObject element, String key) {
		return element.getMetadatas().getMetadatas().stream()
		.filter(Annotation.class::isInstance).map(Annotation.class::cast)
		.filter(a -> key.equals(a.getTitle()))
		.map(a -> a.getBody())
		.findAny().orElse(null);
	}
	
}
