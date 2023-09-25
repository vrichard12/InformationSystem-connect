package org.obeonetwork.dsl.interaction.design.services;

import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.obeonetwork.dsl.interaction.ByReferenceParameterValue;
import org.obeonetwork.dsl.interaction.ByValueParameterValue;
import org.obeonetwork.dsl.interaction.ComputedParameterValue;
import org.obeonetwork.dsl.interaction.ParameterValue;
import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.utils.common.SiriusInterpreterUtils;

public class ParameterValueServices {

	public static Identifiable getValue(ParameterValue parameter) {
		if(parameter instanceof ByReferenceParameterValue) {
			return ((ByReferenceParameterValue) parameter).getReferencedValue();
		}
		
		if(parameter instanceof ByValueParameterValue) {
			return ((ByValueParameterValue) parameter).getContainedValue();
		}
		
		if(parameter instanceof ComputedParameterValue) {
			String expression = ((ComputedParameterValue) parameter).getExpression();
			IInterpreter interpreter = new EObjectQuery(parameter).getSession().getInterpreter();
			return (Identifiable) SiriusInterpreterUtils.evaluateToEObject(interpreter, parameter.eContainer(), expression);
		}
		
		return null;
	}
	
}
