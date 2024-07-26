package org.obeonetwork.dsl.soa.smartea;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.soa.System;

import fr.obeo.smartea.archimate.ArchimatePackage;
import fr.obeo.smartea.core.basemm.BasePackage;

public class SmartEAMetaModelImporter extends SmartEAAbstractImporter {
	
	// Internal
	private Set<EClass> allImportedEClasses;
	
	public SmartEAMetaModelImporter(System soaSystem) {
		super(soaSystem);
	}

	public int importEClasses(List<EClass> eClasses) {
		initStatus();
		
		// Build the set of all imported EClasses
		allImportedEClasses = new HashSet<>();
		
		// The given eClasses allowed in the import scope
		eClasses.stream()//
			.filter(this::isInSmartEAMetaModelImportScope)//
			.forEach(eClass -> allImportedEClasses.add(eClass));

		// All the super types of the given eClasses allowed in the import scope
		eClasses.stream()//
			.filter(this::isInSmartEAMetaModelImportScope)//
			.map(EClass::getEAllSuperTypes).flatMap(List::stream)//
			.distinct()//
			.filter(this::isInSmartEAMetaModelImportScope)//
			.forEach(eSuperClass -> allImportedEClasses.add(eSuperClass));
		
		// The previously imported EClasses
		soaSystem.getOwnedNamespaces().stream()//
			.filter(namespace -> ISD_SMARTEA_NAMESPACE_NAME.equals(namespace.getName()))//
			.map(Namespace::getOwnedNamespaces).flatMap(EList::stream)//
			.map(Namespace::getTypes).flatMap(EList::stream)//
			.filter(DTO.class::isInstance).map(DTO.class::cast)//
			.map(isdDto -> getEClassFromDTO(isdDto)).filter(Objects::nonNull)//
			.forEach(eClass -> allImportedEClasses.add(eClass));
		
		// And a few extra(s)
		allImportedEClasses.add(BasePackage.eINSTANCE.getFolder());
		
		// Touch the DTOs
		allImportedEClasses.forEach(eClass -> getOrCreateIsdEClassDto(eClass));

		// Update the DTOs with their owned data
		allImportedEClasses.forEach(eClass -> updateIsdEClassDtoOwnedData(eClass));
		
		return getStatus();
	}
	
	private boolean isInSmartEAMetaModelImportScope(EClass eClass) {
		return !eClass.isInterface() && 
					(eClass.getEPackage() == ArchimatePackage.eINSTANCE ||
					eClass.getEPackage() == EcorePackage.eINSTANCE ||
					eClass == BasePackage.eINSTANCE.getFolder());
	}
	
	private DTO updateIsdEClassDtoOwnedData(EClass eClass) {
		
		DTO isdDto = getOrCreateIsdEClassDto(eClass);
		
		List<EClass> eSuperTypes = eClass.getESuperTypes().stream()//
			.filter(this::isInSmartEAMetaModelImportScope)
			.toList();
		
		if(eSuperTypes.isEmpty()) {
			isdDto.getSupertypes().add(getOrCreateIsdEClassDto(EcorePackage.eINSTANCE.getEObject()));
		}
		
		eSuperTypes.forEach(eSuperClass -> isdDto.getSupertypes().add(getOrCreateIsdEClassDto(eSuperClass)));
		
		getEAttributes(eClass).forEach(eAttribute -> getOrCreateIsdEAttributeAttribute(isdDto, eAttribute));
		
		getEReferences(eClass).stream()//
			.filter(eReference -> allImportedEClasses.stream()
					.anyMatch(importedEClass -> isSuperTypeOf(eReference.getEReferenceType(), importedEClass)))//
			.forEach(eReference -> getOrCreateIsdEReferenceReference(isdDto, eReference));
		
		return isdDto;
	}
	
	private boolean isSuperTypeOf(EClass eClass, EClass candidateEClass) {
		return eClass == EcorePackage.eINSTANCE.getEObject() || eClass.isSuperTypeOf(candidateEClass);
	}

	List<EAttribute> getEAttributes(EClass eClass) {
		// Attributes to import for a given Archimate EClass are all attributes 
		// visible from this EClass minus the ones visible by the Archimate super
		// types of this EClass.
		// Attributes also have to be not derived.
		
		Set<EAttribute> archimateSuperAttributes = eClass.getEAllSuperTypes().stream()//
			.filter(eSuperClass -> eSuperClass.getEPackage() == ArchimatePackage.eINSTANCE)//
			.map(EClass::getEAllAttributes).flatMap(EList::stream)//
			.filter(eAttribute -> !eAttribute.isDerived())//
			.collect(toSet());
		
		return eClass.getEAllAttributes().stream()//
			.filter(eAttribute -> !eAttribute.isDerived())//
			.filter(eAttribute -> !archimateSuperAttributes.contains(eAttribute))//
			.toList();
	}

	private List<EReference> getEReferences(EClass eClass) {
		// References to import for a given Archimate EClass are all references 
		// visible from this EClass minus the ones visible by the Archimate super
		// types of this EClass.
		// References also have to be not derived.
		
		Set<EReference> archimateSuperReferences = eClass.getEAllSuperTypes().stream()//
			.filter(eSuperClass -> eSuperClass.getEPackage() == ArchimatePackage.eINSTANCE)//
			.map(EClass::getEAllReferences).flatMap(EList::stream)//
			.filter(eReference -> !eReference.isDerived())//
			.collect(toSet());
		
		return eClass.getEAllReferences().stream()//
			.filter(eReference -> !eReference.isDerived())//
			.filter(eReference -> !archimateSuperReferences.contains(eReference))//
			.toList();
	}

	private Reference getOrCreateIsdEReferenceReference(DTO isdDto, EReference eReference) {

		Reference isdReference = getOrCreateIsdEReferenceReferenceNoOpposite(isdDto, eReference);
		
		if(eReference.getEOpposite() != null) {
			EReference eOppositeReference = eReference.getEOpposite();
			DTO targetIsdDto = getOrCreateIsdEClassDto(eReference.getEReferenceType());
			
			Reference isdOppositeReference = getOrCreateIsdEReferenceReferenceNoOpposite(targetIsdDto, eOppositeReference);
			
			isdOppositeReference.setOppositeOf(isdReference);
		}
		
		return isdReference;
	}

	private Reference getOrCreateIsdEReferenceReferenceNoOpposite(DTO isdDto, EReference eReference) {
		Reference isdReference = getOrCreateIsdReference(isdDto, eReference.getName());
		
		DTO targetIsdDto = getOrCreateIsdEClassDto(eReference.getEReferenceType());
		isdReference.setMultiplicity(getIsdMultiplicity(eReference.getLowerBound(), eReference.getUpperBound()));
		isdReference.setIsComposite(eReference.isContainment());
		isdReference.setReferencedType(targetIsdDto);
		
		return isdReference;
	}
	
	private Object getOrCreateIsdEAttributeAttribute(DTO isdDto, EAttribute eAttribute) {
		Attribute isdAttribute = getOrCreateIsdAttribute(isdDto, eAttribute.getName());
		
		isdAttribute.setType(getIsdDataType(eAttribute.getEAttributeType()));
		isdAttribute.setMultiplicity(getIsdMultiplicity(eAttribute.getLowerBound(), eAttribute.getUpperBound()));
		
		return isdAttribute;
	}

}
