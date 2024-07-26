package org.obeonetwork.dsl.soa.smartea;

import static java.util.stream.Collectors.joining;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.services.ObeoDSMObjectService;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.utils.common.EObjectUtils;

import fr.obeo.smartea.core.refmodel.PropertyType;
import fr.obeo.smartea.core.refmodel.RelationshipStereotypeSpecification;
import fr.obeo.smartea.core.refmodel.Stereotype;
import fr.obeo.smartea.core.refmodel.StereotypeFolder;
import fr.obeo.smartea.core.refmodel.StereotypeLibrary;
import fr.obeo.smartea.core.refmodel.Type;

public class SmartEAReferenceModelImporter extends SmartEAAbstractImporter {

	private static final String ISD_SMARTEA_STEREOTYPES_NAMESPACE_NAME = "stereotypes";

	public SmartEAReferenceModelImporter(System soaSystem) {
		super(soaSystem);
		
		initIsdDataTypeBySmartEAType();
	}

	public int importStereotypes(List<Stereotype> stereotypes) {
		initStatus();
		
		stereotypes.forEach(stereotype -> getOrCreateIsdStereotypeDto(stereotype));
		
		return getStatus();
	}

	private DTO getOrCreateIsdStereotypeDto(Stereotype stereotype) {
		
		List<EObject> stereotypeAncestors = EObjectUtils.getAncestors(stereotype);
		Iterator<EObject> stereotypeAncestorsIterator = stereotypeAncestors.iterator();
		while(!(stereotypeAncestorsIterator.next() instanceof StereotypeLibrary)) { };
		
		Namespace isdNamespace = getOrCreateIsdStereotypesNamespace();
		EObject stereotypeAncestor = stereotypeAncestorsIterator.next();
		while(stereotypeAncestor instanceof StereotypeFolder stereotypeFolder) {
			isdNamespace = getOrCreateIsdNamespace(isdNamespace, stereotypeFolder.getName());
			stereotypeAncestor = stereotypeAncestorsIterator.next();
		}
		
		// At this point, stereotypeAncestor == stereotype.
		
		DTO isdDto = getOrCreateIsdDto(isdNamespace, stereotype.getLabel());
		
		isdDto.getSupertypes().add(getOrCreateIsdEClassDto(stereotype.getStereotypedClass()));
		
		stereotype.getAttributes().stream()//
			.filter(PropertyType.class::isInstance).map(PropertyType.class::cast)//
			.forEach(typedProperty -> getOrCreateIsdTypedPropertyAttribute(isdDto, typedProperty));
		
		ObeoDSMObjectService.setAnnotationValue(isdDto, SMARTEA_ID , stereotype.getId());
		
		StringWriter documentationStringWriter = new StringWriter();
		PrintWriter documentationPrintWriter = new PrintWriter(documentationStringWriter);
		documentationPrintWriter.println("# Description:");
		documentationPrintWriter.println("   " + stereotype.getDescription());
		documentationPrintWriter.println("# Authorized Prisms:");
		documentationPrintWriter.println("   " + stereotype.getAuthorizedPrisms().stream().collect(joining(", ")));
		documentationPrintWriter.println("# Relationship Specifications:");
		documentationPrintWriter.println(
				stereotype.getRelationshipSpecifications().stream()//
					.map(rel -> asText(rel))//
					.collect(joining("\n   ", "   ", "")));
		isdDto.setDescription(documentationStringWriter.toString());
		
		return isdDto;
	}

	private String asText(RelationshipStereotypeSpecification rel) {
		boolean insertSep = false;
		StringBuilder text = new StringBuilder();
		if(rel.getAllowedSourceType() != null) {
			text.append("Source Type: " + rel.getAllowedSourceType().getName());
			insertSep = true;
		}
		if(rel.getAllowedSourceStereotype() != null) {
			if(insertSep) text.append("; ");
			text.append("Source Stereotype: " + rel.getAllowedSourceStereotype().getLabel());
			insertSep = true;
		}
		if(!rel.getAllowedTargetTypes().isEmpty()) {
			if(insertSep) text.append("; ");
			text.append("Target Types: " + rel.getAllowedTargetTypes().stream().map(EClass::getName).collect(joining(", ")));
			insertSep = true;
		}
		if(!rel.getAllowedTargetStereotypes().isEmpty()) {
			if(insertSep) text.append("; ");
			text.append("Target Stereotypes: " + rel.getAllowedTargetStereotypes().stream().map(Stereotype::getLabel).collect(joining(", ")));
		}
		
		return text.toString();
	}

	private Attribute getOrCreateIsdTypedPropertyAttribute(DTO isdDto, PropertyType typedProperty) {
		
		Attribute isdAttribute = getOrCreateIsdAttribute(isdDto, typedProperty.getName());
		
		isdAttribute.setMultiplicity(MultiplicityKind.ZERO_ONE_LITERAL);
		
		ObeoDSMObjectService.setAnnotationValue(isdAttribute, SMARTEA_ID , typedProperty.getId());
		
		DataType isdDataType = getIsdDataTypeBySmartEAType(typedProperty.getType());
		isdAttribute.setType(isdDataType);
		
		StringWriter documentationStringWriter = new StringWriter();
		PrintWriter documentationPrintWriter = new PrintWriter(documentationStringWriter);
		documentationPrintWriter.println("# Documentation:");
		documentationPrintWriter.println("   " + typedProperty.getDocumentation());
		documentationPrintWriter.println("# Type:");
		documentationPrintWriter.println("   " + typedProperty.getType());
		documentationPrintWriter.println("# Authorized Prisms:");
		documentationPrintWriter.println("   " + typedProperty.getAuthorizedPrisms().stream().collect(joining(", ")));
		documentationPrintWriter.println("# Constraint:");
		documentationPrintWriter.println("   " + typedProperty.getConstraint());
		documentationPrintWriter.println("# Constraint Description:");
		documentationPrintWriter.println("   " + typedProperty.getConstraintDescription());
		documentationPrintWriter.println("# Default Value:");
		documentationPrintWriter.println("   " + typedProperty.getDefaultValue());
		isdAttribute.setDescription(documentationStringWriter.toString());
		
		return isdAttribute;
	}

	Map<Type, DataType> isdDataTypeBySmartEAType = null;
	private void initIsdDataTypeBySmartEAType() {
		isdDataTypeBySmartEAType = new HashMap<>();
		isdDataTypeBySmartEAType.put(Type.BOOLEAN, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_BOOLEAN));
		isdDataTypeBySmartEAType.put(Type.DATE, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_DATE));
		isdDataTypeBySmartEAType.put(Type.ENUM, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_STRING));
		isdDataTypeBySmartEAType.put(Type.FLOAT, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_FLOAT));
		isdDataTypeBySmartEAType.put(Type.INTEGER, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_INTEGER));
		isdDataTypeBySmartEAType.put(Type.STRING, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_STRING));
		isdDataTypeBySmartEAType.put(Type.STRING_MULTILINE, getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_STRING));
	}
	private DataType getIsdDataTypeBySmartEAType(Type type) {
		// TODO Import ENUMs as Enums (and rename this method getOrCreateIsdSmartEATypeDataType)
		return isdDataTypeBySmartEAType.get(type);
	}

	private Namespace getOrCreateIsdStereotypesNamespace() {
		Namespace isdSmartEANamespace = getOrCreateIsdSmartEANamespace();
		return getOrCreateIsdNamespace(isdSmartEANamespace, ISD_SMARTEA_STEREOTYPES_NAMESPACE_NAME);
	}
	
}
