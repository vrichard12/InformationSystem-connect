package org.obeonetwork.dsl.soa.rest.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.utils.common.EObjectUtils;

public class RestPropertyTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if("isRestCallMessage".equals(property)) {
			EObject element = EObjectUtils.toSemantic((EObject)receiver);
			if(element instanceof CallMessage) {
				Action action = ((CallMessage) element).getAction();
				if(action instanceof Operation) {
					Operation operation = (Operation) action;
					return operation.getExposition() == ExpositionKind.REST;
				}
			}
		}
		
		return false;
	}

}
