package org.obeonetwork.dsl.object.design.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectContainmentProperty;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;

public class CreateValueService {

	public static ObjectValue createObjectValueInstance(EObject context) {
		ObjectValue objectValue = ObjectFactory.eINSTANCE.createObjectValue();
		
		setContainer(context, objectValue);
		
		return objectValue;
	}
	
	public static PrimitiveTypeValue createPrimitiveTypeValueInstance(EObject context) {
		PrimitiveTypeValue primitiveTypeValue = ObjectFactory.eINSTANCE.createPrimitiveTypeValue();
		primitiveTypeValue.setData("");
		
		setContainer(context, primitiveTypeValue);
		
		return primitiveTypeValue;
	}
	
	public static LiteralValue createLiteralValueInstance(EObject context) {
		LiteralValue literalValue = ObjectFactory.eINSTANCE.createLiteralValue();
		literalValue.setName("LITERAL");
		
		setContainer(context, literalValue);
		
		return literalValue;
	}

	private static void setContainer(EObject context, Value value) {
		if(context instanceof ObjectContainmentProperty) {
			ObjectContainmentProperty containmentProperty = (ObjectContainmentProperty) context;
			containmentProperty.setValue(value);
		} else if(context instanceof Workspace) {
			Workspace workspace = (Workspace) context;
			workspace.getValues().add(value);
		}
	}
	
}
