package org.obeonetwork.dsl.environment.services;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class ObeoDSMObjectService {

	public static String getAnnotationValue(ObeoDSMObject element, String key) {
		
		return Optional.ofNullable(element.getMetadatas()).stream()//
				.map(MetaDataContainer::getMetadatas).flatMap(EList::stream)//
				.filter(Annotation.class::isInstance).map(Annotation.class::cast)//
				.filter(a -> key.equals(a.getTitle()))//
				.map(annotation -> annotation.getBody())//
				.findAny().orElse(null);
	}
	
	private static Annotation getOrCreateAnnotation(ObeoDSMObject element, String key) {
		MetaDataContainer metadatas = element.getMetadatas();
		if(metadatas == null) {
			metadatas = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
			element.setMetadatas(metadatas);
		}
		
		Annotation annotation = metadatas.getMetadatas().stream()//
			.filter(Annotation.class::isInstance).map(Annotation.class::cast)//
			.filter(a -> key.equals(a.getTitle()))//
			.findAny().orElse(null);
		
		if(annotation == null) {
			annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
			annotation.setTitle(key);
			metadatas.getMetadatas().add(annotation);
		}
		
		return annotation;
	}
	
	public static ObeoDSMObject setAnnotationValue(ObeoDSMObject element, String key, String value) {
		Annotation annotation = getOrCreateAnnotation(element, key);
		annotation.setBody(value);
		
		return element;
	}
	
}
