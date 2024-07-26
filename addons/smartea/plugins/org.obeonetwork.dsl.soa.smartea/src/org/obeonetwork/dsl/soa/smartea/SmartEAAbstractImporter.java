package org.obeonetwork.dsl.soa.smartea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.utils.common.EObjectUtils;

import fr.obeo.smartea.archimate.ArchimatePackage;
import fr.obeo.smartea.core.basemm.BasePackage;

public abstract class SmartEAAbstractImporter {

	protected static final String ISD_PRIMITIVE_TYPE_NAME_STRING = "String";
	protected static final String ISD_PRIMITIVE_TYPE_NAME_BOOLEAN = "Boolean";
	protected static final String ISD_PRIMITIVE_TYPE_NAME_DATE = "Date";
	protected static final String ISD_PRIMITIVE_TYPE_NAME_FLOAT = "Float";
	protected static final String ISD_PRIMITIVE_TYPE_NAME_INTEGER = "Integer";
	protected static final String ISD_SMARTEA_NAMESPACE_NAME = "SmartEA";
	protected static final String SMARTEA_ID = "SMARTEA_ID";
	
	// Context
	protected System soaSystem;
	private Environment environment;
	
	// Output
	private int status = IStatus.OK;
	
	public SmartEAAbstractImporter(System soaSystem) {
		this.soaSystem = soaSystem;
		
		environment = EObjectUtils.getAllResources(soaSystem).stream()//
			.map(Resource::getContents).flatMap(List::stream)//
			.filter(Environment.class::isInstance).map(Environment.class::cast)//
			.findFirst().orElse(null);
		
		initIsdDataTypeByInstanceTypeName();
	}
	
	protected Namespace getOrCreateIsdSmartEANamespace() {
		return getOrCreateIsdNamespace(soaSystem, ISD_SMARTEA_NAMESPACE_NAME);
	}
	
	protected Namespace getOrCreateIsdNamespace(NamespacesContainer namespacesContainer, String namespaceName) {
		Namespace isdNamespace = namespacesContainer.getOwnedNamespaces().stream()//
			.filter(namespace -> namespaceName.equals(namespace.getName()))
			.findAny().orElse(null);
		if(isdNamespace == null) {
			isdNamespace = EnvironmentFactory.eINSTANCE.createNamespace();
			isdNamespace.setName(namespaceName);
			namespacesContainer.getOwnedNamespaces().add(isdNamespace);
		}
			
		return isdNamespace;
	}
	
	Map<String, DataType> isdDataTypeByInstanceTypeName = null;
	private void initIsdDataTypeByInstanceTypeName() {
		isdDataTypeByInstanceTypeName = new HashMap<>();
		isdDataTypeByInstanceTypeName.put("java.lang.String", getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_STRING));
		isdDataTypeByInstanceTypeName.put("boolean", getPrimitiveTypeByName(ISD_PRIMITIVE_TYPE_NAME_BOOLEAN));
	}
	
	protected DataType getPrimitiveTypeByName(String primitiveTypeName) {
		return environment.getTypesDefinition().getTypes().stream()//
				.filter(DataType.class::isInstance).map(DataType.class::cast)//
				.filter(t -> primitiveTypeName.equals(t.getName()))//
				.findFirst().orElse(null);
	}
	
	protected DataType getIsdDataType(EDataType eDataType) {
		DataType isdDataType = isdDataTypeByInstanceTypeName.get(eDataType.getInstanceTypeName());
		if(isdDataType == null) {
			logError("Unhandled EDataType " + eDataType.getInstanceTypeName());
		}
		return isdDataType;
	}

	protected DTO getOrCreateIsdDto(Namespace isdNamespace, String dtoName) {
		DTO isdDto = isdNamespace.getTypes().stream()//
			.filter(DTO.class::isInstance).map(DTO.class::cast)//
			.filter(dto -> dtoName.equals(dto.getName()))//
			.findAny().orElse(null);
		if(isdDto == null) {
			isdDto = EnvironmentFactory.eINSTANCE.createDTO();
			isdDto.setName(dtoName);
			isdNamespace.getTypes().add(isdDto);
		}
		
		return isdDto;
	}

	protected DTO getOrCreateIsdEClassDto(EClass eClass) {
		Namespace isdNamespace = getOrCreateIsdPackageNamespace(eClass.getEPackage());
		return getOrCreateIsdDto(isdNamespace, eClass.getName());
	}

	protected Attribute getOrCreateIsdAttribute(DTO isdDto, String attributeName) {
		Attribute isdAttribute = isdDto.getOwnedAttributes().stream()//
			.filter(isdAttr -> isdAttr.getName().equals(attributeName))//
			.findFirst().orElse(null);
		
		if(isdAttribute == null) {
			isdAttribute = EnvironmentFactory.eINSTANCE.createAttribute();
			isdAttribute.setName(attributeName);
			isdDto.getOwnedAttributes().add(isdAttribute);
		}
		
		return isdAttribute;
	}

	protected Reference getOrCreateIsdReference(DTO isdDto, String referenceName) {
		
		Reference isdReference = isdDto.getOwnedReferences().stream()//
				.filter(isdRef -> isdRef.getName().equals(referenceName))//
				.findFirst().orElse(null);
			
		if(isdReference == null) {
			isdReference = EnvironmentFactory.eINSTANCE.createReference();
			isdReference.setName(referenceName);
			isdDto.getOwnedReferences().add(isdReference);
		}
		
		return isdReference;
	}
	
	protected Namespace getOrCreateIsdPackageNamespace(EPackage ePackage) {
		Namespace isdSmartEANamespace = getOrCreateIsdSmartEANamespace();
		return getOrCreateIsdNamespace(isdSmartEANamespace, ePackage.getName());
	}

	protected MultiplicityKind getIsdMultiplicity(int lowerBound, int upperBound) {
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

	@SuppressWarnings("serial")
	private final static Map<String, EPackage> ePackagesByName = new HashMap<>() {{
		put(ArchimatePackage.eINSTANCE.getName(), ArchimatePackage.eINSTANCE);
		put(BasePackage.eINSTANCE.getName(), BasePackage.eINSTANCE);
		put(EcorePackage.eINSTANCE.getName(), EcorePackage.eINSTANCE);
	}};
	protected EClass getEClassFromDTO(DTO isdDto) {
		Namespace isdNamespace = EObjectUtils.getContainer(isdDto, Namespace.class);
		return Optional.ofNullable(ePackagesByName.get(isdNamespace.getName())).stream()//
			.map(EPackage::getEClassifiers).flatMap(EList::stream)//
			.filter(EClass.class::isInstance).map(EClass.class::cast)//
			.filter(eClass -> eClass.getName().equals(isdDto.getName()))//
			.findFirst().orElse(null);
	}
	
	protected void initStatus() {
		status = IStatus.OK;
	}
	
	public int getStatus() {
		return status;
	}

	protected void logError(String message) {
		Activator.logError(message);
		status = IStatus.ERROR;
	}

	protected void logWarning(String message) {
		Activator.logWarning(message);
		if (status != IStatus.ERROR) {
			status = IStatus.WARNING;
		}
	}

}
