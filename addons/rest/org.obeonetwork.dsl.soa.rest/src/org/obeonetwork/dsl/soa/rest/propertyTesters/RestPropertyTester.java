package org.obeonetwork.dsl.soa.rest.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.utils.common.EObjectUtils;

public class RestPropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean test = false;
		
		EObject element = EObjectUtils.toSemantic((EObject)receiver);
		CallMessage callMessage = null;
		if(element instanceof CallMessage) {
			callMessage = (CallMessage) element;
		}
		
		if(callMessage != null) {
			switch(property) {
			case "isRestCallMessage":
				if(callMessage.getAction() instanceof Operation) {
					Operation operation = (Operation) callMessage.getAction();
					test = operation.getExposition() == ExpositionKind.REST;
				}
				break;
			case "isBindingTransformCallMessage":
				test = callMessage.getFinishingEnd().getContext().getType() instanceof BindingRegistry;
				break;
			}
		}
		
		return test;
	}

}
