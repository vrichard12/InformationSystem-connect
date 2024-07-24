package org.obeonetwork.dsl.soa.smartea;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.utils.common.EObjectUtils;

import fr.obeo.smartea.archimate.ArchimatePackage;
import fr.obeo.smartea.core.basemm.BasePackage;

public class SmartEAMetaModelImporter {

	private static final String ISD_PRIMITIVE_TYPE_NAME_STRING = "String";
	private static final String ISD_PRIMITIVE_TYPE_NAME_BOOLEAN = "Boolean";
	private static final String ISD_SMARTEA_NAMESPACE = "SmartEA";
	
	// Context
	private System soaSystem;
	private Environment environment;
	
	// Output
	private int status;
	
	// Internal
	private Set<EClass> allImportedEClasses;
	
	public SmartEAMetaModelImporter(System soaSystem) {
		this.soaSystem = soaSystem;
		
		environment = EObjectUtils.getAllResources(soaSystem).stream()//
			.map(Resource::getContents).flatMap(List::stream)//
			.filter(Environment.class::isInstance).map(Environment.class::cast)//
			.findFirst().orElse(null);
		
		initIsdDataTypeByInstanceTypeName();
	}

	public int importEClasses(List<EClass> eClasses) {
		status = IStatus.OK;
		
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
			.filter(namespace -> ISD_SMARTEA_NAMESPACE.equals(namespace.getName()))//
			.map(Namespace::getOwnedNamespaces).flatMap(EList::stream)//
			.map(Namespace::getTypes).flatMap(EList::stream)//
			.filter(DTO.class::isInstance).map(DTO.class::cast)//
			.map(isdDto -> getEClassFromDTO(isdDto)).filter(Objects::nonNull)//
			.forEach(eClass -> allImportedEClasses.add(eClass));
		
		// And a few extra(s)
		allImportedEClasses.add(BasePackage.eINSTANCE.getFolder());
		
		// Touch the DTOs
		allImportedEClasses.forEach(eClass -> getOrCreateIsdDto(eClass));

		// Update the DTOs with their owned data
		allImportedEClasses.forEach(eClass -> updateDtoOwnedData(eClass));
		
		return status;
	}
	
	@SuppressWarnings("serial")
	private final static Map<String, EPackage> ePackagesByName = new HashMap<>() {{
		put(ArchimatePackage.eINSTANCE.getName(), ArchimatePackage.eINSTANCE);
		put(BasePackage.eINSTANCE.getName(), BasePackage.eINSTANCE);
		put(EcorePackage.eINSTANCE.getName(), EcorePackage.eINSTANCE);
	}};
	private EClass getEClassFromDTO(DTO isdDto) {
		
		Namespace isdNamespace = EObjectUtils.getContainer(isdDto, Namespace.class);
		return ePackagesByName.get(isdNamespace.getName()).getEClassifiers().stream()//
			.filter(EClass.class::isInstance).map(EClass.class::cast)//
			.filter(eClass -> eClass.getName().equals(isdDto.getName()))//
			.findFirst().orElse(null);
	}
	
	private boolean isInSmartEAMetaModelImportScope(EClass eClass) {
		return !eClass.isInterface() && 
					(eClass.getEPackage() == ArchimatePackage.eINSTANCE ||
					eClass.getEPackage() == EcorePackage.eINSTANCE ||
					eClass == BasePackage.eINSTANCE.getFolder());
	}
	
	private DTO getOrCreateIsdDto(EClass eClass) {
		Namespace isdNamespace = getOrCreateIsdNamespace(eClass.getEPackage());
		
		DTO isdDto = isdNamespace.getTypes().stream()//
			.filter(DTO.class::isInstance).map(DTO.class::cast)//
			.filter(dto -> eClass.getName().equals(dto.getName()))//
			.findAny().orElse(null);
		if(isdDto == null) {
			isdDto = EnvironmentFactory.eINSTANCE.createDTO();
			isdDto.setName(eClass.getName());
			isdNamespace.getTypes().add(isdDto);
		}
		
		return isdDto;
	}

	private Namespace getOrCreateIsdSmartEANamespace() {
		Namespace isdSmartEANamespace = soaSystem.getOwnedNamespaces().stream()//
			.filter(namespace -> ISD_SMARTEA_NAMESPACE.equals(namespace.getName()))
			.findAny().orElse(null);
		if(isdSmartEANamespace == null) {
			isdSmartEANamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			isdSmartEANamespace.setName(ISD_SMARTEA_NAMESPACE);
			soaSystem.getOwnedNamespaces().add(isdSmartEANamespace);
		}
			
		return isdSmartEANamespace;
	}
	
	private Namespace getOrCreateIsdNamespace(EPackage ePackage) {
		Namespace isdSmartEANamespace = getOrCreateIsdSmartEANamespace();
		
		Namespace isdNamespace = isdSmartEANamespace.getOwnedNamespaces().stream()//
			.filter(namespace -> ePackage.getName().equals(namespace.getName()))//
			.findAny().orElse(null);
		if(isdNamespace == null) {
			isdNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			isdNamespace.setName(ePackage.getName());
			isdSmartEANamespace.getOwnedNamespaces().add(isdNamespace);
		}
		
		return isdNamespace;
	}

	private DTO updateDtoOwnedData(EClass eClass) {
		
		DTO isdDto = getOrCreateIsdDto(eClass);
		
		List<EClass> eSuperTypes = eClass.getESuperTypes().stream()//
			.filter(this::isInSmartEAMetaModelImportScope)
			.toList();
		
		if(eSuperTypes.isEmpty()) {
			isdDto.getSupertypes().add(getOrCreateIsdDto(EcorePackage.eINSTANCE.getEObject()));
		}
		
		eSuperTypes.forEach(eSuperClass -> isdDto.getSupertypes().add(getOrCreateIsdDto(eSuperClass)));
		
		getEAttributes(eClass).forEach(eAttribute -> getOrCreateIsdAttribute(isdDto, eAttribute));
		
		getEReferences(eClass).stream()//
			.filter(eReference -> allImportedEClasses.stream()
					.anyMatch(importedEClass -> isSuperTypeOf(eReference.getEReferenceType(), importedEClass)))//
			.forEach(eReference -> getOrCreateIsdReference(isdDto, eReference));
		
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

	private Reference getOrCreateIsdReference(DTO isdDto, EReference eReference) {

		Reference isdReference = isdDto.getOwnedReferences().stream()//
			.filter(isdRef -> isdRef.getName().equals(eReference.getName()))//
			.findFirst().orElse(null);
		
		if(isdReference == null) {
			isdReference = EnvironmentFactory.eINSTANCE.createReference();
			
			DTO targetIsdDto = getOrCreateIsdDto(eReference.getEReferenceType());
			isdReference.setName(eReference.getName());
			isdReference.setMultiplicity(getIsdMultiplicity(eReference.getLowerBound(), eReference.getUpperBound()));
			isdReference.setIsComposite(eReference.isContainment());
			isdReference.setReferencedType(targetIsdDto);
			
			if(eReference.getEOpposite() != null) {
				EReference eOppositeReference = eReference.getEOpposite();
				Reference isdOppositeReference = EnvironmentFactory.eINSTANCE.createReference();
				isdOppositeReference.setName(eOppositeReference.getName());
				isdOppositeReference.setMultiplicity(getIsdMultiplicity(eOppositeReference.getLowerBound(), eOppositeReference.getUpperBound()));
				isdOppositeReference.setIsComposite(eOppositeReference.isContainment());
				isdOppositeReference.setReferencedType(isdDto);
				isdOppositeReference.setOppositeOf(isdReference);
				targetIsdDto.getOwnedReferences().add(isdOppositeReference);
			}
			
			isdDto.getOwnedReferences().add(isdReference);
		}
		
		return isdReference;
	}

	private Object getOrCreateIsdAttribute(DTO isdDto, EAttribute eAttribute) {
		
		Attribute isdAttribute = isdDto.getOwnedAttributes().stream()//
			.filter(isdAttr -> isdAttr.getName().equals(eAttribute.getName()))//
			.findFirst().orElse(null);
		
		if(isdAttribute == null) {
			isdAttribute = EnvironmentFactory.eINSTANCE.createAttribute();
			isdAttribute.setName(eAttribute.getName());
			isdAttribute.setType(getIsdDataType(eAttribute.getEAttributeType()));
			isdAttribute.setMultiplicity(getIsdMultiplicity(eAttribute.getLowerBound(), eAttribute.getUpperBound()));
			isdDto.getOwnedAttributes().add(isdAttribute);
		}
		
		return isdAttribute;
	}

	Map<String, DataType> isdDataTypeByInstanceTypeName = null;
	private void initIsdDataTypeByInstanceTypeName() {
		isdDataTypeByInstanceTypeName = new HashMap<>();
		isdDataTypeByInstanceTypeName.put("java.lang.String", getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_STRING));
		isdDataTypeByInstanceTypeName.put("boolean", getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_BOOLEAN));
	}
	
	private DataType getPrimitiveTypeByName(String primitiveTypeName) {
		return environment.getTypesDefinition().getTypes().stream()//
				.filter(DataType.class::isInstance).map(DataType.class::cast)//
				.filter(t -> primitiveTypeName.equals(t.getName()))//
				.findFirst().orElse(null);
	}
	
	private DataType getIsdDataType(EDataType eDataType) {
		DataType isdDataType = isdDataTypeByInstanceTypeName.get(eDataType.getInstanceTypeName());
		if(isdDataType == null) {
			logError("Unhandled EDataType " + eDataType.getInstanceTypeName());
		}
		return isdDataType;
	}

	private MultiplicityKind getIsdMultiplicity(int lowerBound, int upperBound) {
		MultiplicityKind multiplicityKind = null;
		if(lowerBound == 0 && upperBound == 1) {
			multiplicityKind = MultiplicityKind.ZERO_ONE_LITERAL;
		} else if(lowerBound == 0 && upperBound > 1) {
			multiplicityKind = MultiplicityKind.ZERO_STAR_LITERAL;
		} else if(lowerBound > 0 && upperBound == 1) {
			multiplicityKind = MultiplicityKind.ONE_LITERAL;
		} else if(lowerBound > 0 && upperBound > 1) {
			multiplicityKind = MultiplicityKind.ONE_STAR_LITERAL;
		}
		return multiplicityKind;
	}

	private void logError(String message) {
		Activator.logError(message);
		status = IStatus.ERROR;
	}

	@SuppressWarnings("unused")
	private void logWarning(String message) {
		Activator.logWarning(message);
		if (status != IStatus.ERROR) {
			status = IStatus.WARNING;
		}
	}

}
