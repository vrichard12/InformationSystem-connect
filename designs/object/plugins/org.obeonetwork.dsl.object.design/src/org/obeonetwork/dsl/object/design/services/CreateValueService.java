package org.obeonetwork.dsl.object.design.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.PropertyContainedValue;
import org.obeonetwork.dsl.object.Workspace;

public class CreateValueService {

	public static ObjectValue createObjectValueInstance(EObject context) {
		ObjectValue objectValue = ObjectFactory.eINSTANCE.createObjectValue();
		
		if(context instanceof PropertyContainedValue) {
			PropertyContainedValue propertyContainedValue = (PropertyContainedValue) context;
			propertyContainedValue.setValue(objectValue);
		} else if(context instanceof Workspace) {
			Workspace workspace = (Workspace) context;
			workspace.getValues().add(objectValue);
		}
		
		return objectValue;
	}
	
	public static PrimitiveTypeValue createPrimitiveTypeValueInstance(EObject context) {
		PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
		primitiveTypeValue.setData("");
		
		if(context instanceof PropertyContainedValue) {
			PropertyContainedValue propertyContainedValue = (PropertyContainedValue) context;
			propertyContainedValue.setValue(primitiveTypeValue);
		} else if(context instanceof Workspace) {
			Workspace workspace = (Workspace) context;
			workspace.getValues().add(primitiveTypeValue);
		}
		
		return primitiveTypeValue;
	}
	
	//createLiteralValueInstance
	public static LiteralValue createLiteralValueInstance(EObject context) {
		LiteralValue literalValue = ObjectFactory.eINSTANCE.createLiteralValue();
		literalValue.setName("LITERAL");
		
		if(context instanceof PropertyContainedValue) {
			PropertyContainedValue propertyContainedValue = (PropertyContainedValue) context;
			propertyContainedValue.setValue(literalValue);
		} else if(context instanceof Workspace) {
			Workspace workspace = (Workspace) context;
			workspace.getValues().add(literalValue);
		}
		
		return literalValue;
	}
	
}
